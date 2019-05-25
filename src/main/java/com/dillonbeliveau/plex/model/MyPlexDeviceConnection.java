package com.dillonbeliveau.plex.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    public String getProtocol() {
        return protocol;
    }

    public String getAddress() {
        return address;
    }

    public String getPort() {
        return port;
    }

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
