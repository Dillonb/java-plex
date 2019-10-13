package com.dillonbeliveau.plex;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class Video {
    private final String guid;
    private final String ratingKey;
    private final String key;
    private final String studio;
    private final String type;
    private final String title;
    private final String titleSort;
    private final String originalTitle;
    private final String contentRating;
    private final String summary;
    private final String rating;
    private final String audienceRating;
    private final String userRating;
    private final int viewCount;
    private final Date lastViewedAt;
    private final String year;
    private final String tagline;
    private final String thumb;
    private final String art;
    private final String duration;
    private final String viewOffset;
    private final String originallyAvailableAt;
    private final Date addedAt;
    private final Date updatedAt;
    private final String audienceRatingImage;
    private final String chapterSource;
    private final String primaryExtraKey;
    private final String ratingImage;
    private final List<String> genres;
    private final List<String> directors;
    private final List<String> writers;
    private final List<String> roles;
    private final String country;
    private final LibrarySection librarySection;

    public boolean hasBeenViewed() {
        return viewCount > 0;
    }

    private final Pattern endsWithLang = Pattern.compile("^(.+)\\?lang=..$");

    public void markWatched() {
        getLibrarySection().getServer().request(String.format("/:/scrobble?key=%s&identifier=com.plexapp.plugins.library", getRatingKey()));
    }

    public void markUnwatched() {
        getLibrarySection().getServer().request(String.format("/:/unscrobble?key=%s&identifier=com.plexapp.plugins.library", getRatingKey()));
    }

    public String getGuidNoLang() {
        String guid = getGuid();

        if (guid == null || guid.equals("")) {
            return guid;
        }

        Matcher matcher = endsWithLang.matcher(guid);

        if (matcher.matches()) {
            return matcher.group(1);
        }

        return guid;
    }
}
