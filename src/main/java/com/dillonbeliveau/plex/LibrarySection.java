package com.dillonbeliveau.plex;

import okhttp3.OkHttpClient;

import java.util.Date;

public abstract class LibrarySection {
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

    public LibrarySection(boolean allowSync, String art, String composite, String filters, boolean isRefreshing,
                          String thumb, String key, String title, String agent, String scanner, String language,
                          String uuid, Date updatedAt, Date createdAt, Date scannedAt, PlexServer server) {
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
        this.server = server;
    }

    public boolean isAllowSync() {
        return allowSync;
    }

    public String getArt() {
        return art;
    }

    public String getComposite() {
        return composite;
    }

    public String getFilters() {
        return filters;
    }

    public boolean isRefreshing() {
        return isRefreshing;
    }

    public String getThumb() {
        return thumb;
    }

    public String getKey() {
        return key;
    }

    public String getTitle() {
        return title;
    }

    public String getAgent() {
        return agent;
    }

    public String getScanner() {
        return scanner;
    }

    public String getLanguage() {
        return language;
    }

    public String getUuid() {
        return uuid;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getScannedAt() {
        return scannedAt;
    }

    public PlexServer getServer() {
        return server;
    }

    public abstract String getType();

    public <T extends LibrarySection> T as(Class<T> type) {
        if (type.isInstance(this)) {
            return type.cast(this);
        }
        throw new ClassCastException("Trying to cast " + this.getClass().getSimpleName() + " as " + type.getSimpleName());
    }
}
