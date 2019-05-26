package com.dillonbeliveau.plex.model;

import com.dillonbeliveau.plex.model.xml.LibrarySectionXml;

import java.util.Date;

public class MovieSection implements LibrarySection{
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

    public static MovieSection fromXml(LibrarySectionXml sectionXml) {
        return new MovieSection.Builder()
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
                .build();
    }

    @Override
    public boolean allowSync() {
        return allowSync;
    }

    @Override
    public String getArt() {
        return art;
    }

    @Override
    public String getComposite() {
        return composite;
    }

    @Override
    public String getFilters() {
        return filters;
    }

    @Override
    public boolean isRefreshing() {
        return isRefreshing;
    }

    @Override
    public String getThumb() {
        return thumb;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAgent() {
        return agent;
    }

    @Override
    public String getScanner() {
        return scanner;
    }

    @Override
    public String getLanguage() {
        return language;
    }

    @Override
    public String getUuid() {
        return uuid;
    }

    @Override
    public Date getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public Date getScannedAt() {
        return scannedAt;
    }

    @Override
    public String getType() {
        return "movie";
    }

    private MovieSection(boolean allowSync, String art, String composite, String filters, boolean isRefreshing, String thumb,
                        String key, String title, String agent, String scanner, String language, String uuid, Date updatedAt,
                        Date createdAt, Date scannedAt) {
        this.allowSync = allowSync;
        this.art = art;
        this.composite = composite;
        this.filters = filters;
        this.isRefreshing = isRefreshing;
        this.thumb = thumb;
        this.key = key;
        this.title = title;
        this.agent = agent;
        this.scanner = scanner;
        this.language = language;
        this.uuid = uuid;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.scannedAt = scannedAt;
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

        public MovieSection build() {
            return new MovieSection(allowSync, art, composite, filters, isRefreshing, thumb, key, title, agent, scanner, language, uuid, updatedAt, createdAt, scannedAt);
        }
    }

}
