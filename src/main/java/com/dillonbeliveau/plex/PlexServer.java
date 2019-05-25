package com.dillonbeliveau.plex;

import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class PlexServer {
    private static final OkHttpClient client = new OkHttpClient();

    private final String host;
    private final String token;

    public PlexServer(String host, String token) {
        this.host = host;
        this.token = token;
    }

    private Request.Builder request(String path) {
        return new Request.Builder()
                .url("https://" + host + ":32400" + path)
                .addHeader("X-Plex-Token", token)
                .addHeader("X-Plex-Platform", "java")
                //.addHeader("X-Plex-Platform-Version", )
                ;
    }

    public String root() throws IOException {
        return client.newCall(request("/").build()).execute().body().string();
    }
}
