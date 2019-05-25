package com.dillonbeliveau.plex.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;
import java.util.List;

public class ResourcesResponse {
    @JacksonXmlElementWrapper(localName = "Device", useWrapping = false)
    @JsonProperty("Device")
    List<MyPlexDevice> resources = new ArrayList<>();

    @JsonProperty("size")
    Integer size;

    public List<MyPlexDevice> getResources() {
        return resources;
    }

    public Integer getSize() {
        return size;
    }
}