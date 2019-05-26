package com.dillonbeliveau.plex.model.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public String getRatingKey() {
        return ratingKey;
    }

    public String getKey() {
        return key;
    }

    public String getStudio() {
        return studio;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getTitleSort() {
        return titleSort;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getContentRating() {
        return contentRating;
    }

    public String getSummary() {
        return summary;
    }

    public String getRating() {
        return rating;
    }

    public String getAudienceRating() {
        return audienceRating;
    }

    public String getUserRating() {
        return userRating;
    }

    public String getViewCount() {
        return viewCount;
    }

    public Date getLastViewedAt() {
        return Util.stringToDate(lastViewedAt);
    }

    public String getYear() {
        return year;
    }

    public String getTagline() {
        return tagline;
    }

    public String getThumb() {
        return thumb;
    }

    public String getArt() {
        return art;
    }

    public String getDuration() {
        return duration;
    }

    public String getViewOffset() {
        return viewOffset;
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

    public String getAudienceRatingImage() {
        return audienceRatingImage;
    }

    public String getChapterSource() {
        return chapterSource;
    }

    public String getPrimaryExtraKey() {
        return primaryExtraKey;
    }

    public String getRatingImage() {
        return ratingImage;
    }

    public Media getMedia() {
        return media;
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
