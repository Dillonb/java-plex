package com.dillonbeliveau.plex.model.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SeasonXML {
    @JacksonXmlProperty(localName = "ratingKey", isAttribute = true)
    private String ratingKey;
    @JacksonXmlProperty(localName = "key", isAttribute = true)
    private String key;
    @JacksonXmlProperty(localName = "parentRatingKey", isAttribute = true)
    private String parentRatingKey;
    @JacksonXmlProperty(localName = "guid", isAttribute = true)
    private String guid;
    @JacksonXmlProperty(localName = "parentGuid", isAttribute = true)
    private String parentGuid;
    @JacksonXmlProperty(localName = "type", isAttribute = true)
    private String type;
    @JacksonXmlProperty(localName = "title", isAttribute = true)
    private String title;
    @JacksonXmlProperty(localName = "parentKey", isAttribute = true)
    private String parentKey;
    @JacksonXmlProperty(localName = "parentTitle", isAttribute = true)
    private String parentTitle;
    @JacksonXmlProperty(localName = "summary", isAttribute = true)
    private String summary;
    @JacksonXmlProperty(localName = "index", isAttribute = true)
    private String index;
    @JacksonXmlProperty(localName = "parentIndex", isAttribute = true)
    private String parentIndex;
    @JacksonXmlProperty(localName = "thumb", isAttribute = true)
    private String thumb;
    @JacksonXmlProperty(localName = "art", isAttribute = true)
    private String art;
    @JacksonXmlProperty(localName = "parentThumb", isAttribute = true)
    private String parentThumb;
    @JacksonXmlProperty(localName = "parentTheme", isAttribute = true)
    private String parentTheme;
    @JacksonXmlProperty(localName = "leafCount", isAttribute = true)
    private String leafCount;
    @JacksonXmlProperty(localName = "viewedLeafCount", isAttribute = true)
    private String viewedLeafCount;
    @JacksonXmlProperty(localName = "addedAt", isAttribute = true)
    private String addedAt;
    @JacksonXmlProperty(localName = "updatedAt", isAttribute = true)
    private String updatedAt;
    @JacksonXmlProperty(localName = "viewCount", isAttribute = true)
    private String viewCount;
    @JacksonXmlProperty(localName = "lastViewedAt", isAttribute = true)
    private String lastViewedAt;
    @JacksonXmlProperty(localName = "hasPremiumPrimaryExtra", isAttribute = true)
    private String hasPremiumPrimaryExtra;
    @JacksonXmlProperty(localName = "primaryExtraKey", isAttribute = true)
    private String primaryExtraKey;


}
