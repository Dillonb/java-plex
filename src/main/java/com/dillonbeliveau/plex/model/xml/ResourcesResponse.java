package com.dillonbeliveau.plex.model.xml;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResourcesResponse {
    @JacksonXmlElementWrapper(localName = "Device", useWrapping = false)
    @JsonProperty("Device")
    List<MyPlexDevice> resources = new ArrayList<>();

    @JsonProperty("size")
    Integer size;
}
