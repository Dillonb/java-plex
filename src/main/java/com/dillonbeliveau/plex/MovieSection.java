package com.dillonbeliveau.plex;

import com.dillonbeliveau.plex.model.xml.LibrarySectionXml;
import com.dillonbeliveau.plex.model.xml.MoviesResponse;
import com.dillonbeliveau.plex.model.xml.VideoXml;
import lombok.Builder;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class MovieSection extends VideoSection {

    static MovieSection fromXml(PlexServer plexServer, LibrarySectionXml sectionXml) {
        return MovieSection.builder()
                .allowSync(sectionXml.allowSync())
                .art(sectionXml.getArt())
                .composite(sectionXml.getComposite())
                .filters(sectionXml.getFilters())
                .isRefreshing(sectionXml.isRefreshing())
                .thumb(sectionXml.getThumb())
                .key(sectionXml.getKey())
                .title(sectionXml.getTitle())
                .agent(sectionXml.getAgent())
                .scanner(sectionXml.getScanner())
                .language(sectionXml.getLanguage())
                .uuid(sectionXml.getUuid())
                .updatedAt(sectionXml.getUpdatedAt())
                .createdAt(sectionXml.getCreatedAt())
                .scannedAt(sectionXml.getScannedAt())
                .server(plexServer)
                .build();
    }

    @Override
    public String getType() {
        return "movie";
    }


    public List<Video> allVideos() {
        String allMovies = getServer().request(String.format("/library/sections/%s/all", getKey()));

        try {
            List<VideoXml> videos = getServer().objectMapper().readValue(allMovies, MoviesResponse.class).getVideos();

            return videos.stream().map(video -> Movie.fromXml(this, video)).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Builder
    private MovieSection(boolean allowSync, String art, String composite, String filters, boolean isRefreshing, String thumb,
                         String key, String title, String agent, String scanner, String language, String uuid, Date updatedAt,
                         Date createdAt, Date scannedAt, PlexServer server) {
        super(allowSync, art, composite, filters, isRefreshing, thumb, key, title, agent, scanner, language, uuid, updatedAt, createdAt, scannedAt, server);

    }
}
