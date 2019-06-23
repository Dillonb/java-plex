package com.dillonbeliveau.plex.model.xml;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MyPlexDeviceConnection {
    @JsonProperty("protocol")
    private String protocol;

    @JsonProperty("address")
    private String address;

    @JsonProperty("port")
    private String port;

    @JsonProperty("uri")
    private String uri;

    @JsonProperty("local")
    private String local;

    @JsonProperty("relay")
    private String relay;

    public String getUri() {
        return uri;
    }

    public Boolean isLocal() {
        return "1".equals(local);
    }

    public Boolean isRelay() {
        return "1".equals(relay);
    }
}
