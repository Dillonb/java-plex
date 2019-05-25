package com.dillonbeliveau.plex;

import com.dillonbeliveau.plex.model.MyPlexUser;
import com.dillonbeliveau.plex.model.ResourcesResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

public class MyPlex {
    private final String basicCredentials;

    private MyPlexUser user = null;
    private static final ObjectMapper objectMapper = new XmlMapper();

    private static final OkHttpClient client = new OkHttpClient();

    private void signin() {
        try {
            if (this.user != null) {
                return;
            }

            RequestBody emptyBody = RequestBody.create(null, new byte[]{});
            Request authRequest = new Request.Builder()
                    .url("https://plex.tv/users/sign_in.xml")
                    .headers(PlexClient.getBaseHeaders())
                    .addHeader("Authorization", basicCredentials)
                    .post(emptyBody)
                    .build();


            String string = client.newCall(authRequest).execute().body().string();

            user = objectMapper.readValue(string, MyPlexUser.class);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public MyPlex(String username, String password) throws IOException {
        this.basicCredentials = Credentials.basic(username, password);
    }

    public void resources() {
        signin();

        Request getServersRequest = new Request.Builder()
                .url("https://plex.tv/api/resources?includeHttps=1&includeRelay=1")
                .headers(PlexClient.getBaseHeaders())
                .addHeader("X-Plex-Token", user.getAuthToken())
                .get()
                .build();

        try {
            String result = client.newCall(getServersRequest).execute().body().string();
            System.out.println(result);
            ResourcesResponse resourcesResponse = objectMapper.readValue(result, ResourcesResponse.class);


            System.out.println(resourcesResponse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
