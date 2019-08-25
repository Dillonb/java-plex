package com.dillonbeliveau.plex;

import com.dillonbeliveau.plex.model.xml.LibrarySectionsResponse;
import com.dillonbeliveau.plex.model.xml.MyPlexDevice;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.dillonbeliveau.plex.PlexClient.getBestConnection;
import static java.util.concurrent.TimeUnit.SECONDS;

public class PlexServer {
    private static final OkHttpClient client = new OkHttpClient.Builder()
            .callTimeout(10, SECONDS)
            .connectTimeout(10, SECONDS)
            .readTimeout(10, SECONDS)
            .writeTimeout(10, SECONDS)
            .build();
    private static final ObjectMapper objectMapper = new XmlMapper();

    private final String uri;
    private final String token;

    public PlexServer(String uri, String token) {
        this.uri = uri;
        this.token = token;
    }


    public static PlexServer connect(MyPlexDevice device) {
        return new PlexServer(getBestConnection(device).getUri(), device.getAccessToken());
    }

    ObjectMapper objectMapper() {
        return objectMapper;
    }

    String request(String path) {
        System.out.println("Making a request to " + path);
        Request request = new Request.Builder()
                .url(uri + path)
                .headers(PlexClient.getBaseHeaders())
                .addHeader("X-Plex-Token", token)
                .build();


        try {
            return client.newCall(request).execute().body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<LibrarySection> librarySections() {
        try {
            String sections = request("/library/sections");
            return objectMapper.readValue(sections, LibrarySectionsResponse.class).getSections().stream()
                    .map(sectionXml -> {
                        if (sectionXml.getType().equals("show")) {
                            return ShowSection.fromXml(this, sectionXml);
                        }
                        else if (sectionXml.getType().equals("movie")) {
                            return MovieSection.fromXml(this, sectionXml);
                        }
                        else if (sectionXml.getType().equals("artist")) {
                            return ArtistSection.fromXml(this, sectionXml);
                            // TODO implement music sections
                        }
                        else {
                            throw new IllegalStateException("Unknown section type: " + sectionXml.getType());
                        }
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<LibrarySection> section(String title) {
        return librarySections().stream()
                .filter(section -> section.getTitle().equals(title))
                .findFirst();
    }

    public List<VideoSection> videoSections() {
        return librarySections().stream()
                .filter(section -> section.getType().equals("show") || section.getType().equals("movie"))
                .map(section -> section.as(VideoSection.class))
                .collect(Collectors.toList());
    }

    public List<MovieSection> movieSections() {
        return videoSections().stream()
                .filter(section -> section instanceof MovieSection)
                .map(section ->  section.as(MovieSection.class))
                .collect(Collectors.toList());
    }

    public List<ShowSection> showSections() {
        return videoSections().stream()
                .filter(section -> section instanceof ShowSection)
                .map(section -> section.as(ShowSection.class))
                .collect(Collectors.toList());
    }
}
