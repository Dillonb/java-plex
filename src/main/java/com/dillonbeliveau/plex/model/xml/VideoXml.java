package com.dillonbeliveau.plex.model.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoXml {
    @JacksonXmlProperty(localName = "ratingKey", isAttribute = true)
    private String ratingKey;

    @JacksonXmlProperty(localName = "key", isAttribute = true)
    private String key;

    @JacksonXmlProperty(localName = "studio", isAttribute = true)
    private String studio;

    @JacksonXmlProperty(localName = "type", isAttribute = true)
    private String type;

    @JacksonXmlProperty(localName = "title", isAttribute = true)
    private String title;

    @JacksonXmlProperty(localName = "titleSort", isAttribute = true)
    private String titleSort;

    @JacksonXmlProperty(localName = "originalTitle", isAttribute = true)
    private String originalTitle;

    @JacksonXmlProperty(localName = "contentRating", isAttribute = true)
    private String contentRating;

    @JacksonXmlProperty(localName = "summary", isAttribute = true)
    private String summary;

    @JacksonXmlProperty(localName = "rating", isAttribute = true)
    private String rating;

    @JacksonXmlProperty(localName = "audienceRating", isAttribute = true)
    private String audienceRating;

    @JacksonXmlProperty(localName = "userRating", isAttribute = true)
    private String userRating;

    @JacksonXmlProperty(localName = "viewCount", isAttribute = true)
    private String viewCount;

    @JacksonXmlProperty(localName = "lastViewedAt", isAttribute = true)
    private String lastViewedAt;

    @JacksonXmlProperty(localName = "year", isAttribute = true)
    private String year;

    @JacksonXmlProperty(localName = "tagline", isAttribute = true)
    private String tagline;

    @JacksonXmlProperty(localName = "thumb", isAttribute = true)
    private String thumb;

    @JacksonXmlProperty(localName = "art", isAttribute = true)
    private String art;

    @JacksonXmlProperty(localName = "duration", isAttribute = true)
    private String duration;

    @JacksonXmlProperty(localName = "viewOffset", isAttribute = true)
    private String viewOffset;

    @JacksonXmlProperty(localName = "originallyAvailableAt", isAttribute = true)
    private String originallyAvailableAt;

    @JacksonXmlProperty(localName = "addedAt", isAttribute = true)
    private String addedAt;

    @JacksonXmlProperty(localName = "updatedAt", isAttribute = true)
    private String updatedAt;

    @JacksonXmlProperty(localName = "audienceRatingImage", isAttribute = true)
    private String audienceRatingImage;

    @JacksonXmlProperty(localName = "chapterSource", isAttribute = true)
    private String chapterSource;

    @JacksonXmlProperty(localName = "primaryExtraKey", isAttribute = true)
    private String primaryExtraKey;

    @JacksonXmlProperty(localName = "ratingImage", isAttribute = true)
    private String ratingImage;

    @JacksonXmlProperty(localName = "Media")
    private Media media;

    @JacksonXmlElementWrapper(localName = "Genre", useWrapping = false)
    @JacksonXmlProperty(localName = "Genre")
    private List<VideoTag> genres = new ArrayList<>();

    @JacksonXmlElementWrapper(localName = "Director", useWrapping = false)
    @JacksonXmlProperty(localName = "Director")
    private List<VideoTag> directors = new ArrayList<>();

    @JacksonXmlElementWrapper(localName = "Writer", useWrapping = false)
    @JacksonXmlProperty(localName = "Writer")
    private List<VideoTag> writers = new ArrayList<>();

    @JacksonXmlElementWrapper(localName = "Role", useWrapping = false)
    @JacksonXmlProperty(localName = "Role")
    private List<VideoTag> roles = new ArrayList<>();

    @JacksonXmlProperty(localName = "Country")
    private VideoTag country;

    @JacksonXmlProperty(localName = "guid")
    private String guid;

    @JacksonXmlProperty(localName = "parentRatingKey", isAttribute = true)
    private String parentRatingKey;

    @JacksonXmlProperty(localName = "grandparentRatingKey", isAttribute = true)
    private String grandparentRatingKey;

    @JacksonXmlProperty(localName = "parentGuid", isAttribute = true)
    private String parentGuid;

    @JacksonXmlProperty(localName = "grandparentGuid", isAttribute = true)
    private String grandparentGuid;

    @JacksonXmlProperty(localName = "grandparentKey", isAttribute = true)
    private String grandparentKey;

    @JacksonXmlProperty(localName = "parentKey", isAttribute = true)
    private String parentKey;

    @JacksonXmlProperty(localName = "grandparentTitle", isAttribute = true)
    private String grandparentTitle;

    @JacksonXmlProperty(localName = "parentTitle", isAttribute = true)
    private String parentTitle;

    @JacksonXmlProperty(localName = "index", isAttribute = true)
    private String index;

    @JacksonXmlProperty(localName = "parentIndex", isAttribute = true)
    private String parentIndex;

    @JacksonXmlProperty(localName = "parentThumb", isAttribute = true)
    private String parentThumb;

    @JacksonXmlProperty(localName = "grandparentThumb", isAttribute = true)
    private String grandparentThumb;

    @JacksonXmlProperty(localName = "grandparentArt", isAttribute = true)
    private String grandparentArt;

    @JacksonXmlProperty(localName = "grandparentTheme", isAttribute = true)
    private String grandparentTheme;

    public Date getLastViewedAt() {
        return Util.stringToDate(lastViewedAt);
    }

    public String getOriginallyAvailableAt() {
        return originallyAvailableAt;
    }

    public Date getAddedAt() {
        return Util.stringToDate(addedAt);
    }

    public Date getUpdatedAt() {
        return Util.stringToDate(updatedAt);
    }

    public List<String> getGenres() {
        return genres.stream().map(VideoTag::getTag).collect(Collectors.toList());
    }

    public List<String> getDirectors() {
        return directors.stream().map(VideoTag::getTag).collect(Collectors.toList());
    }

    public List<String> getWriters() {
        return writers.stream().map(VideoTag::getTag).collect(Collectors.toList());
    }

    public List<String> getRoles() {
        return roles.stream().map(VideoTag::getTag).collect(Collectors.toList());
    }

    public String getCountry() {
        return Optional.ofNullable(country).map(VideoTag::getTag).orElse(null);
    }
}
