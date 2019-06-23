package com.dillonbeliveau.plex;

import com.dillonbeliveau.plex.model.xml.LibrarySectionXml;
import lombok.Builder;

import java.util.Date;

public class ArtistSection extends LibrarySection {

    static ArtistSection fromXml(PlexServer plexServer, LibrarySectionXml sectionXml) {
        return ArtistSection.builder()
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
        return "artist";
    }

    @Builder
    private ArtistSection(boolean allowSync, String art, String composite, String filters, boolean isRefreshing, String thumb,
                          String key, String title, String agent, String scanner, String language, String uuid, Date updatedAt,
                          Date createdAt, Date scannedAt, PlexServer server) {
        super(allowSync, art, composite, filters, isRefreshing, thumb, key, title, agent, scanner, language, uuid, updatedAt, createdAt, scannedAt, server);
    }
}
