package com.dillonbeliveau.plex.model.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MyPlexUser {
    @JsonProperty("username")
    String username;

    @JsonProperty("email")
    String email;

    @JsonProperty("authentication-token")
    String authToken;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getAuthToken() {
        return authToken;
    }
}
