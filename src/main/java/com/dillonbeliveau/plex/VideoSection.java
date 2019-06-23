package com.dillonbeliveau.plex;

import java.util.Date;
import java.util.List;

public abstract class VideoSection extends LibrarySection {
    public VideoSection(boolean allowSync, String art, String composite, String filters, boolean isRefreshing, String thumb,
                        String key, String title, String agent, String scanner, String language, String uuid, Date updatedAt,
                        Date createdAt, Date scannedAt, PlexServer server) {
        super(allowSync, art, composite, filters, isRefreshing, thumb, key, title, agent, scanner, language, uuid, updatedAt, createdAt, scannedAt, server);
    }

    public abstract List<Video> allVideos();
}
