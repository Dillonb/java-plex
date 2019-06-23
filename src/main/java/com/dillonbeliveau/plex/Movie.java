package com.dillonbeliveau.plex;

import com.dillonbeliveau.plex.model.xml.VideoXml;
import lombok.Builder;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Movie extends Video {

    @Builder
    Movie(String guid, String ratingKey, String key, String studio, String type, String title, String titleSort, String originalTitle,
                 String contentRating, String summary, String rating, String audienceRating, String userRating, int viewCount, Date lastViewedAt,
                 String year, String tagline, String thumb, String art, String duration, String viewOffset, String originallyAvailableAt,
                 Date addedAt, Date updatedAt, String audienceRatingImage, String chapterSource, String primaryExtraKey,
                 String ratingImage, List<String> genres, List<String> directors, List<String> writers, List<String> roles, String country, LibrarySection librarySection) {
        super(guid, ratingKey, key, studio, type, title, titleSort, originalTitle, contentRating, summary, rating, audienceRating, userRating, viewCount, lastViewedAt, year, tagline, thumb, art, duration, viewOffset, originallyAvailableAt, addedAt, updatedAt, audienceRatingImage, chapterSource, primaryExtraKey, ratingImage, genres, directors, writers, roles, country, librarySection);
    }

    static Movie fromXml(LibrarySection librarySection, VideoXml video) {
        int viewCount = Optional.ofNullable(video.getViewCount()).map(Integer::parseInt).orElse(0);

        return Movie.builder()
                .ratingKey(video.getRatingKey())
                .key(video.getKey())
                .studio(video.getStudio())
                .type(video.getType())
                .title(video.getTitle())
                .titleSort(video.getTitleSort())
                .originalTitle(video.getOriginalTitle())
                .contentRating(video.getContentRating())
                .contentRating(video.getSummary())
                .summary(video.getRating())
                .audienceRating(video.getAudienceRating())
                .userRating(video.getUserRating())
                .viewCount(viewCount)
                .lastViewedAt(video.getLastViewedAt())
                .year(video.getYear())
                .tagline(video.getTagline())
                .thumb(video.getThumb())
                .art(video.getArt())
                .duration(video.getDuration())
                .viewOffset(video.getViewOffset())
                .originallyAvailableAt(video.getOriginallyAvailableAt())
                .addedAt(video.getAddedAt())
                .updatedAt(video.getUpdatedAt())
                .audienceRatingImage(video.getAudienceRatingImage())
                .chapterSource(video.getChapterSource())
                .primaryExtraKey(video.getPrimaryExtraKey())
                .ratingImage(video.getRatingImage())
                .genres(video.getGenres())
                .directors(video.getDirectors())
                .writers(video.getWriters())
                .roles(video.getRoles())
                .country(video.getCountry())
                .librarySection(librarySection)
                .guid(video.getGuid())
                .build();
    }

    public String toString() {
        return String.format("[%s] %s (%s)", hasBeenViewed() ? " " : "*", getTitle(), getYear());
    }
}
