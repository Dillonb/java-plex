package com.dillonbeliveau.plex;

import com.dillonbeliveau.plex.model.xml.LibrarySectionXml;
import com.dillonbeliveau.plex.model.xml.MoviesResponse;
import com.dillonbeliveau.plex.model.xml.ShowsResponse;
import com.dillonbeliveau.plex.model.xml.VideoXml;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShowSection extends VideoSection {

    public static ShowSection fromXml(PlexServer plexServer, LibrarySectionXml sectionXml) {
        return new ShowSection.Builder()
                .setAllowSync(sectionXml.allowSync())
                .setArt(sectionXml.getArt())
                .setComposite(sectionXml.getComposite())
                .setFilters(sectionXml.getFilters())
                .setIsRefreshing(sectionXml.isRefreshing())
                .setThumb(sectionXml.getThumb())
                .setKey(sectionXml.getKey())
                .setTitle(sectionXml.getTitle())
                .setAgent(sectionXml.getAgent())
                .setScanner(sectionXml.getScanner())
                .setLanguage(sectionXml.getLanguage())
                .setUuid(sectionXml.getUuid())
                .setUpdatedAt(sectionXml.getUpdatedAt())
                .setCreatedAt(sectionXml.getCreatedAt())
                .setScannedAt(sectionXml.getScannedAt())
                .setServer(plexServer)
                .build();
    }

    @Override
    public String getType() {
        return "show";
    }

    private ShowSection(boolean allowSync, String art, String composite, String filters, boolean isRefreshing, String thumb,
                        String key, String title, String agent, String scanner, String language, String uuid, Date updatedAt,
                        Date createdAt, Date scannedAt, PlexServer server) {
        super(allowSync, art, composite, filters, isRefreshing, thumb, key, title, agent, scanner, language, uuid, updatedAt, createdAt, scannedAt, server);
    }

    @Override
    public List<Video> allVideos() {
        String allShows = getServer().request(String.format("/library/sections/%s/all", getKey()));

        try {
            ShowsResponse response = getServer()
                    .objectMapper()
                    .readValue(allShows, ShowsResponse.class);
            Stream<Show> shows = response.getShows().stream().map(show -> Show.fromXML(this, show));
            return shows.flatMap(Show::allVideos).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static class Builder {
        private boolean allowSync;
        private String art;
        private String composite;
        private String filters;
        private boolean isRefreshing;
        private String thumb;
        private String key;
        private String title;
        private String agent;
        private String scanner;
        private String language;
        private String uuid;
        private Date updatedAt;
        private Date createdAt;
        private Date scannedAt;
        private PlexServer server;

        public Builder setAllowSync(boolean allowSync) {
            this.allowSync = allowSync;
            return this;
        }

        public Builder setArt(String art) {
            this.art = art;
            return this;
        }

        public Builder setComposite(String composite) {
            this.composite = composite;
            return this;
        }

        public Builder setFilters(String filters) {
            this.filters = filters;
            return this;
        }

        public Builder setIsRefreshing(boolean isRefreshing) {
            this.isRefreshing = isRefreshing;
            return this;
        }

        public Builder setThumb(String thumb) {
            this.thumb = thumb;
            return this;
        }

        public Builder setKey(String key) {
            this.key = key;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setAgent(String agent) {
            this.agent = agent;
            return this;
        }

        public Builder setScanner(String scanner) {
            this.scanner = scanner;
            return this;
        }

        public Builder setLanguage(String language) {
            this.language = language;
            return this;
        }

        public Builder setUuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder setUpdatedAt(Date updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder setScannedAt(Date scannedAt) {
            this.scannedAt = scannedAt;
            return this;
        }

        public Builder setServer(PlexServer server) {
            this.server = server;
            return this;
        }

        public ShowSection build() {
            return new ShowSection(allowSync, art, composite, filters, isRefreshing, thumb, key, title, agent, scanner, language, uuid, updatedAt, createdAt, scannedAt, server);
        }
    }

}
