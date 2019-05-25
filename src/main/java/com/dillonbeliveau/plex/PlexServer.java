package com.dillonbeliveau.plex;

import com.dillonbeliveau.plex.model.LibrarySection;
import com.dillonbeliveau.plex.model.LibrarySectionsResponse;
import com.dillonbeliveau.plex.model.MyPlexDevice;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.util.List;

import static com.dillonbeliveau.plex.PlexClient.getBestConnection;

public class PlexServer {
    private static final OkHttpClient client = new OkHttpClient();
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

    private String request(String path) {
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
            return objectMapper.readValue(sections, LibrarySectionsResponse.class).getSections();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
