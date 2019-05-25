package com.dillonbeliveau.plex;

import okhttp3.Headers;
import okhttp3.OkHttpClient;

class PlexClient {
    private static final OkHttpClient client = new OkHttpClient();

    private static Headers baseHeaders = new Headers.Builder()
            .add("X-Plex-Platform", "java-plex")
            .add("X-Plex-Platform-Version", "1.0.0-SNAPSHOT")
            .add("X-Plex-Provides", "controller")
            .add("X-Plex-Client-Identifier", "java-plex")
            .build();

    static Headers getBaseHeaders() {
        return baseHeaders;
    }
}
