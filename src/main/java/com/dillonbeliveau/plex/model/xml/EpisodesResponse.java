package com.dillonbeliveau.plex.model.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class EpisodesResponse {
    @JacksonXmlProperty(localName = "size", isAttribute = true)
    private String size;
    @JacksonXmlProperty(localName = "allowSync", isAttribute = true)
    private String allowSync;
    @JacksonXmlProperty(localName = "art", isAttribute = true)
    private String art;
    @JacksonXmlProperty(localName = "banner", isAttribute = true)
    private String banner;
    @JacksonXmlProperty(localName = "grandparentContentRating", isAttribute = true)
    private String grandparentContentRating;
    @JacksonXmlProperty(localName = "grandparentRatingKey", isAttribute = true)
    private String grandparentRatingKey;
    @JacksonXmlProperty(localName = "grandparentStudio", isAttribute = true)
    private String grandparentStudio;
    @JacksonXmlProperty(localName = "grandparentTheme", isAttribute = true)
    private String grandparentTheme;
    @JacksonXmlProperty(localName = "grandparentThumb", isAttribute = true)
    private String grandparentThumb;
    @JacksonXmlProperty(localName = "grandparentTitle", isAttribute = true)
    private String grandparentTitle;
    @JacksonXmlProperty(localName = "identifier", isAttribute = true)
    private String identifier;
    @JacksonXmlProperty(localName = "key", isAttribute = true)
    private String key;
    @JacksonXmlProperty(localName = "librarySectionID", isAttribute = true)
    private String librarySectionID;
    @JacksonXmlProperty(localName = "librarySectionTitle", isAttribute = true)
    private String librarySectionTitle;
    @JacksonXmlProperty(localName = "librarySectionUUID", isAttribute = true)
    private String librarySectionUUID;
    @JacksonXmlProperty(localName = "mediaTagPrefix", isAttribute = true)
    private String mediaTagPrefix;
    @JacksonXmlProperty(localName = "mediaTagVersion", isAttribute = true)
    private String mediaTagVersion;
    @JacksonXmlProperty(localName = "nocache", isAttribute = true)
    private String nocache;
    @JacksonXmlProperty(localName = "parentIndex", isAttribute = true)
    private String parentIndex;
    @JacksonXmlProperty(localName = "parentTitle", isAttribute = true)
    private String parentTitle;
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
    @JacksonXmlProperty(localName = "mixedParents", isAttribute = true)
    private String mixedParents;
    @JacksonXmlProperty(localName = "parentYear", isAttribute = true)
    private String parentYear;

    @JacksonXmlElementWrapper(localName = "Video", useWrapping = false)
    @JacksonXmlProperty(localName = "Video")
    private List<VideoXml> videos = new ArrayList<>();
}
