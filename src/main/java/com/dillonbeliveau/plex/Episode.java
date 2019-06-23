package com.dillonbeliveau.plex;

import lombok.Builder;

import java.util.Date;
import java.util.List;

public class Episode extends Video {
    @Builder
    Episode(String guid, String ratingKey, String key, String studio, String type, String title, String titleSort, String originalTitle,
            String contentRating, String summary, String rating, String audienceRating, String userRating, int viewCount,
            Date lastViewedAt, String year, String tagline, String thumb, String art, String duration, String viewOffset,
            String originallyAvailableAt, Date addedAt, Date updatedAt, String audienceRatingImage, String chapterSource,
            String primaryExtraKey, String ratingImage, List<String> genres, List<String> directors, List<String> writers,
            List<String> roles, String country, LibrarySection librarySection) {
        super(guid, ratingKey, key, studio, type, title, titleSort, originalTitle, contentRating, summary, rating, audienceRating, userRating, viewCount, lastViewedAt, year, tagline, thumb, art, duration, viewOffset, originallyAvailableAt, addedAt, updatedAt, audienceRatingImage, chapterSource, primaryExtraKey, ratingImage, genres, directors, writers, roles, country, librarySection);
    }
}
