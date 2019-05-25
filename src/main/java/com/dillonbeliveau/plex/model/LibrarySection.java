package com.dillonbeliveau.plex.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LibrarySection {

    @JacksonXmlProperty(localName = "allowSync", isAttribute = true)
    private String allowSync;
    @JacksonXmlProperty(localName = "art", isAttribute = true)
    private String art;
    @JacksonXmlProperty(localName = "composite", isAttribute = true)
    private String composite;
    @JacksonXmlProperty(localName = "filters", isAttribute = true)
    private String filters;
    @JacksonXmlProperty(localName = "refreshing", isAttribute = true)
    private String refreshing;
    @JacksonXmlProperty(localName = "thumb", isAttribute = true)
    private String thumb;
    @JacksonXmlProperty(localName = "key", isAttribute = true)
    private String key;
    @JacksonXmlProperty(localName = "type", isAttribute = true)
    private String type;
    @JacksonXmlProperty(localName = "title", isAttribute = true)
    private String title;
    @JacksonXmlProperty(localName = "agent", isAttribute = true)
    private String agent;
    @JacksonXmlProperty(localName = "scanner", isAttribute = true)
    private String scanner;
    @JacksonXmlProperty(localName = "language", isAttribute = true)
    private String language;
    @JacksonXmlProperty(localName = "uuid", isAttribute = true)
    private String uuid;
    @JacksonXmlProperty(localName = "updatedAt", isAttribute = true)
    private String updatedAt;
    @JacksonXmlProperty(localName = "createdAt", isAttribute = true)
    private String createdAt;
    @JacksonXmlProperty(localName = "scannedAt", isAttribute = true)
    private String scannedAt;

    public boolean allowSync() {
        return "1".equals(allowSync);
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
        return "1".equals(refreshing);
    }

    public String getThumb() {
        return thumb;
    }

    public String getKey() {
        return key;
    }

    public String getType() {
        return type;
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
        return new Date(Long.parseLong(updatedAt) * 1000);
    }

    public Date getCreatedAt() {
        return new Date(Long.parseLong(createdAt) * 1000);
    }

    public Date getScannedAt() {
        return new Date(Long.parseLong(scannedAt) * 1000);
    }

    @Override
    public String toString() {
        return "LibrarySection{" +
                "allowSync='" + allowSync + '\'' +
                ", art='" + getArt() + '\'' +
                ", composite='" + getComposite() + '\'' +
                ", filters='" + getFilters() + '\'' +
                ", refreshing='" + isRefreshing() + '\'' +
                ", thumb='" + getThumb() + '\'' +
                ", key='" + getKey() + '\'' +
                ", type='" + getType() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", agent='" + getAgent() + '\'' +
                ", scanner='" + getScanner() + '\'' +
                ", language='" + getLanguage() + '\'' +
                ", uuid='" + getUuid() + '\'' +
                ", updatedAt='" + getUpdatedAt() + '\'' +
                ", createdAt='" + getCreatedAt() + '\'' +
                ", scannedAt='" + getScannedAt() + '\'' +
                '}';
    }
}
