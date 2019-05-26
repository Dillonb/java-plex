package com.dillonbeliveau.plex;

import java.util.Date;
import java.util.List;

public class Video {
    private String ratingKey;
    private String key;
    private String studio;
    private String type;
    private String title;
    private String titleSort;
    private String originalTitle;
    private String contentRating;
    private String summary;
    private String rating;
    private String audienceRating;
    private String userRating;
    private String viewCount;
    private Date lastViewedAt;
    private String year;
    private String tagline;
    private String thumb;
    private String art;
    private String duration;
    private String viewOffset;
    private String originallyAvailableAt;
    private Date addedAt;
    private Date updatedAt;
    private String audienceRatingImage;
    private String chapterSource;
    private String primaryExtraKey;
    private String ratingImage;
    private List<String> genres;
    private List<String> directors;
    private List<String> writers;
    private List<String> roles;
    private String country;

    Video(String ratingKey, String key, String studio, String type, String title, String titleSort, String originalTitle,
                 String contentRating, String summary, String rating, String audienceRating, String userRating, String viewCount, Date lastViewedAt,
                 String year, String tagline, String thumb, String art, String duration, String viewOffset, String originallyAvailableAt,
                 Date addedAt, Date updatedAt, String audienceRatingImage, String chapterSource, String primaryExtraKey,
                 String ratingImage, List<String> genres, List<String> directors, List<String> writers, List<String> roles, String country) {
        this.ratingKey = ratingKey;
        this.key = key;
        this.studio = studio;
        this.type = type;
        this.title = title;
        this.titleSort = titleSort;
        this.originalTitle = originalTitle;
        this.contentRating = contentRating;
        this.summary = summary;
        this.rating = rating;
        this.audienceRating = audienceRating;
        this.userRating = userRating;
        this.viewCount = viewCount;
        this.lastViewedAt = lastViewedAt;
        this.year = year;
        this.tagline = tagline;
        this.thumb = thumb;
        this.art = art;
        this.duration = duration;
        this.viewOffset = viewOffset;
        this.originallyAvailableAt = originallyAvailableAt;
        this.addedAt = addedAt;
        this.updatedAt = updatedAt;
        this.audienceRatingImage = audienceRatingImage;
        this.chapterSource = chapterSource;
        this.primaryExtraKey = primaryExtraKey;
        this.ratingImage = ratingImage;
        this.genres = genres;
        this.directors = directors;
        this.writers = writers;
        this.roles = roles;
        this.country = country;
    }

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
        return lastViewedAt;
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
        return addedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
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

    public List<String> getGenres() {
        return genres;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public List<String> getWriters() {
        return writers;
    }

    public List<String> getRoles() {
        return roles;
    }

    public String getCountry() {
        return country;
    }

}
