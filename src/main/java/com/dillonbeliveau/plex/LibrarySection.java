package com.dillonbeliveau.plex;

import lombok.Data;

import java.util.Date;

@Data
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
    public abstract String getType();

    public <T extends LibrarySection> T as(Class<T> type) {
        if (type.isInstance(this)) {
            return type.cast(this);
        }
        throw new ClassCastException("Trying to cast " + this.getClass().getSimpleName() + " as " + type.getSimpleName());
    }
}
