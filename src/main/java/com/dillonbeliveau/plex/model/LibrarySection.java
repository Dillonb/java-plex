package com.dillonbeliveau.plex.model;

import java.util.Date;

public interface LibrarySection {
    boolean allowSync();

    String getArt();

    String getComposite();

    String getFilters();

    boolean isRefreshing();

    String getThumb();

    String getKey();

    String getTitle();

    String getAgent();

    String getScanner();

    String getLanguage();

    String getUuid();

    Date getUpdatedAt();

    Date getCreatedAt();

    Date getScannedAt();

    String getType();
}
