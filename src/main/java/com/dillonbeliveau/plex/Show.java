package com.dillonbeliveau.plex;

import com.dillonbeliveau.plex.model.xml.Media;
import com.dillonbeliveau.plex.model.xml.SeasonsResponse;
import com.dillonbeliveau.plex.model.xml.ShowXML;
import com.dillonbeliveau.plex.model.xml.ShowsResponse;
import lombok.Builder;
import lombok.Getter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@Builder
@Getter
public class Show {
    public static Show fromXML(LibrarySection librarySection, ShowXML show) {
        return Show.builder()
                .ratingKey(show.getRatingKey())
                .key(show.getKey())
                .studio(show.getStudio())
                .type(show.getType())
                .title(show.getTitle())
                .titleSort(show.getTitleSort())
                .contentRating(show.getContentRating())
                .summary(show.getSummary())
                .rating(show.getRating())
                .userRating(show.getUserRating())
                .viewCount(show.getViewCount())
                .lastViewedAt(show.getLastViewedAt())
                .year(show.getYear())
                .tagline(show.getTagline())
                .thumb(show.getThumb())
                .art(show.getArt())
                .duration(show.getDuration())
                .viewOffset(show.getViewOffset())
                .originallyAvailableAt(show.getOriginallyAvailableAt())
                .addedAt(show.getAddedAt())
                .updatedAt(show.getUpdatedAt())
                .audienceRatingImage(show.getAudienceRatingImage())
                .chapterSource(show.getChapterSource())
                .primaryExtraKey(show.getPrimaryExtraKey())
                .ratingImage(show.getRatingImage())
                .banner(show.getBanner())
                .theme(show.getTheme())
                .leafCount(show.getLeafCount())
                .viewedLeafCount(show.getViewedLeafCount())
                .childCount(show.getChildCount())
                .media(show.getMedia())
                .genres(show.getGenres())
                .directors(show.getDirectors())
                .writers(show.getWriters())
                .roles(show.getRoles())
                .collections(show.getCollections())
                .country(show.getCountry())
                .guid(show.getGuid())
                .index(show.getIndex())
                .librarySection(librarySection)
                .build();
    }
    private String ratingKey;
    private String key;
    private String studio;
    private String type;
    private String title;
    private String titleSort;
    private String contentRating;
    private String summary;
    private String rating;
    private String userRating;
    private String viewCount;
    private String lastViewedAt;
    private String year;
    private String tagline;
    private String thumb;
    private String art;
    private String duration;
    private String viewOffset;
    private String originallyAvailableAt;
    private String addedAt;
    private String updatedAt;
    private String audienceRatingImage;
    private String chapterSource;
    private String primaryExtraKey;
    private String ratingImage;
    private String banner;
    private String theme;
    private String leafCount;
    private String viewedLeafCount;
    private String childCount;
    private Media media;
    private List<String> genres;
    private List<String> directors;
    private List<String> writers;
    private List<String> roles;
    private List<String> collections;
    private String country;
    private String guid;
    private String index;
    LibrarySection librarySection;

    public Stream<Season> allSeasons() {
        String allSeasons = getLibrarySection().getServer().request(getKey());
        try {
            SeasonsResponse response = getLibrarySection().getServer()
                    .objectMapper()
                    .readValue(allSeasons, SeasonsResponse.class);

            return response.getSeasons().stream().map(season -> Season.fromXML(getLibrarySection(), season));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Stream<Episode> allVideos() {
        return allSeasons().flatMap(Season::allVideos);
    }
}
