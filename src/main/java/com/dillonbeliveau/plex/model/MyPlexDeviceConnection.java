package com.dillonbeliveau.plex.model;

import com.fasterxml.jackson.annotation.JsonProperty;

class MyPlexDeviceConnection {
    @JsonProperty("protocol")
    public String protocol;

    @JsonProperty("address")
    public String address;

    @JsonProperty("port")
    public String port;

    @JsonProperty("uri")
    public String uri;

    @JsonProperty("local")
    public String local;

    @JsonProperty("relay")
    public String relay;
}
