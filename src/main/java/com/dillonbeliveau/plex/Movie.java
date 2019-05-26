package com.dillonbeliveau.plex;

import com.dillonbeliveau.plex.model.xml.VideoXml;

import java.util.Date;
import java.util.List;

public class Movie extends Video {

    public Movie(String ratingKey, String key, String studio, String type, String title, String titleSort, String originalTitle,
                 String contentRating, String summary, String rating, String audienceRating, String userRating, String viewCount, Date lastViewedAt,
                 String year, String tagline, String thumb, String art, String duration, String viewOffset, String originallyAvailableAt,
                 Date addedAt, Date updatedAt, String audienceRatingImage, String chapterSource, String primaryExtraKey,
                 String ratingImage, List<String> genres, List<String> directors, List<String> writers, List<String> roles, String country) {
        super(ratingKey, key, studio, type, title, titleSort, originalTitle, contentRating, summary, rating, audienceRating, userRating, viewCount, lastViewedAt, year, tagline, thumb, art, duration, viewOffset, originallyAvailableAt, addedAt, updatedAt, audienceRatingImage, chapterSource, primaryExtraKey, ratingImage, genres, directors, writers, roles, country);
    }

    public static Movie fromXml(PlexServer server, VideoXml video) {
        return new Movie(video.getRatingKey(), video.getKey(), video.getStudio(), video.getType(), video.getTitle(), video.getTitleSort(),
                video.getOriginalTitle(), video.getContentRating(), video.getSummary(), video.getRating(), video.getAudienceRating(), video.getUserRating(),
                video.getViewCount(), video.getLastViewedAt(), video.getYear(), video.getTagline(), video.getThumb(), video.getArt(), video.getDuration(),
                video.getViewOffset(), video.getOriginallyAvailableAt(), video.getAddedAt(), video.getUpdatedAt(), video.getAudienceRatingImage(),
                video.getChapterSource(), video.getPrimaryExtraKey(), video.getRatingImage(), video.getGenres(), video.getDirectors(), video.getWriters(),
                video.getRoles(), video.getCountry());
    }

    public String toString() {
        return String.format("%s (%s)", getTitle(), getYear());
    }
}
