package com.dillonbeliveau.plex;

import com.dillonbeliveau.plex.model.xml.MyPlexDevice;
import com.dillonbeliveau.plex.model.xml.MyPlexUser;
import com.dillonbeliveau.plex.model.xml.ResourcesResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class MyPlex {
    private static final String GET_RESOURCES = "https://plex.tv/api/resources?includeHttps=1&includeRelay=1";
    private static final String AUTH = "https://plex.tv/users/sign_in.xml";

    private final String basicCredentials;

    private MyPlexUser user = null;
    private static final ObjectMapper objectMapper = new XmlMapper();

    private static final OkHttpClient client = new OkHttpClient();

    private void signin() {
        if (this.user != null) {
            return;
        }

        try {
            RequestBody emptyBody = RequestBody.create(null, new byte[]{});
            Request authRequest = new Request.Builder()
                    .url(AUTH)
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

    public MyPlex(String username, String password) {
        this.basicCredentials = Credentials.basic(username, password);
    }

    /**
     * @return all resources available to this MyPlex account. Servers, players, controllers, all of it.
     */
    public List<MyPlexDevice> resources() {
        signin();

        Request getServersRequest = new Request.Builder()
                .url(GET_RESOURCES)
                .headers(PlexClient.getBaseHeaders())
                .addHeader("X-Plex-Token", user.getAuthToken())
                .get()
                .build();

        try {
            String result = client.newCall(getServersRequest).execute().body().string();
            ResourcesResponse resourcesResponse = objectMapper.readValue(result, ResourcesResponse.class);
            return resourcesResponse.getResources();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets a stream of all servers available to this MyPlex account
     * @return a Stream of servers
     */
    public Stream<MyPlexDevice> servers() {
        List<MyPlexDevice> resources = resources();

        return resources.stream()
                .filter(resource -> resource.getProvides().contains("server"));
    }

    /**
     * Gets the server with the given name, if it exists.
     */
    public Optional<MyPlexDevice> server(String name) {
        return servers().filter(device -> device.getName().equals(name)).findFirst();
    }


    /**
     * Gets the device with the given name, if it exists.
     */
    public Optional<MyPlexDevice> device(String name) {
        return resources().stream().filter(device -> device.getName().equals(name)).findFirst();
    }

    /**
     * Gets a stream of only the available servers on this MyPlex account
     * @return All online servers associated with this account
     */
    public Stream<MyPlexDevice> availableServers() {
        return servers().filter(MyPlexDevice::isPresent);
    }
}
