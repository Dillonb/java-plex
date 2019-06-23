package com.dillonbeliveau.plex.model.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class MyPlexUser {
    @JsonProperty("username")
    String username;

    @JsonProperty("email")
    String email;

    @JsonProperty("authentication-token")
    String authToken;
}
