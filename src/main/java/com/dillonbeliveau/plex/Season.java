package com.dillonbeliveau.plex;

import com.dillonbeliveau.plex.model.xml.EpisodesResponse;
import com.dillonbeliveau.plex.model.xml.SeasonXML;
import lombok.Builder;
import lombok.Getter;

import java.io.IOException;
import java.util.stream.Stream;

@Builder
@Getter
public class Season {
    public static Season fromXML(LibrarySection librarySection, SeasonXML season) {
        return Season.builder()
                .ratingKey(season.getRatingKey())
                .key(season.getKey())
                .parentRatingKey(season.getParentRatingKey())
                .guid(season.getGuid())
                .parentGuid(season.getParentGuid())
                .type(season.getType())
                .title(season.getTitle())
                .parentKey(season.getParentKey())
                .parentTitle(season.getParentTitle())
                .summary(season.getSummary())
                .index(season.getIndex())
                .parentIndex(season.getParentIndex())
                .thumb(season.getThumb())
                .art(season.getArt())
                .parentThumb(season.getParentThumb())
                .parentTheme(season.getParentTheme())
                .leafCount(season.getLeafCount())
                .viewedLeafCount(season.getViewedLeafCount())
                .addedAt(season.getAddedAt())
                .updatedAt(season.getUpdatedAt())
                .librarySection(librarySection)
                .build();
    }

    private String ratingKey;
    private String key;
    private String parentRatingKey;
    private String guid;
    private String parentGuid;
    private String type;
    private String title;
    private String parentKey;
    private String parentTitle;
    private String summary;
    private String index;
    private String parentIndex;
    private String thumb;
    private String art;
    private String parentThumb;
    private String parentTheme;
    private String leafCount;
    private String viewedLeafCount;
    private String addedAt;
    private String updatedAt;
    private LibrarySection librarySection;

    public Stream<Episode> allVideos() {
        String allEpisodes = getLibrarySection().getServer().request(getKey());

        try {
            EpisodesResponse response = getLibrarySection().getServer()
                    .objectMapper()
                    .readValue(allEpisodes, EpisodesResponse.class);

            return response.getVideos().stream().map(episode -> Episode.fromXML(getLibrarySection(), episode));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
