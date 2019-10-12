package com.dillonbeliveau.plex.model.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SeasonsResponse {
    @JacksonXmlProperty(localName = "size", isAttribute = true)
    private String size;

    @JacksonXmlProperty(localName = "allowSync", isAttribute = true)
    private String allowSync;

    @JacksonXmlProperty(localName = "identifier", isAttribute = true)
    private String identifier;

    @JacksonXmlProperty(localName = "librarySectionID", isAttribute = true)
    private String librarySectionID;

    @JacksonXmlProperty(localName = "librarySectionUUID", isAttribute = true)
    private String librarySectionUUID;

    @JacksonXmlProperty(localName = "librarySectionTitle", isAttribute = true)
    private String librarySectionTitle;

    @JacksonXmlProperty(localName = "mediaTagPrefix", isAttribute = true)
    private String mediaTagPrefix;


    @JacksonXmlProperty(localName = "art", isAttribute = true)
    private String art;
    @JacksonXmlProperty(localName = "banner", isAttribute = true)
    private String banner;
    @JacksonXmlProperty(localName = "key", isAttribute = true)
    private String key;
    @JacksonXmlProperty(localName = "mediaTagVersion", isAttribute = true)
    private String mediaTagVersion;
    @JacksonXmlProperty(localName = "nocache", isAttribute = true)
    private String nocache;
    @JacksonXmlProperty(localName = "parentIndex", isAttribute = true)
    private String parentIndex;
    @JacksonXmlProperty(localName = "parentTitle", isAttribute = true)
    private String parentTitle;
    @JacksonXmlProperty(localName = "parentYear", isAttribute = true)
    private String parentYear;
    @JacksonXmlProperty(localName = "summary", isAttribute = true)
    private String summary;
    @JacksonXmlProperty(localName = "theme", isAttribute = true)
    private String theme;
    @JacksonXmlProperty(localName = "thumb", isAttribute = true)
    private String thumb;
    @JacksonXmlProperty(localName = "title1", isAttribute = true)
    private String title1;
    @JacksonXmlProperty(localName = "title2", isAttribute = true)
    private String title2;
    @JacksonXmlProperty(localName = "viewGroup", isAttribute = true)
    private String viewGroup;
    @JacksonXmlProperty(localName = "viewMode", isAttribute = true)
    private String viewMode;

    @JacksonXmlElementWrapper(localName = "Directory", useWrapping = false)
    @JacksonXmlProperty(localName = "Directory")
    private List<SeasonXML> seasons;

    public List<SeasonXML> getSeasons() {
        return seasons;
    }
}
