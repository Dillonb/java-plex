package com.dillonbeliveau.plex.model.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MoviesResponse {
    @JsonProperty("size")
    private Integer size;

    @JacksonXmlElementWrapper(localName = "Video", useWrapping = false)
    @JacksonXmlProperty(localName = "Video")
    private List<VideoXml> videos = new ArrayList<>();

    public Integer getSize() {
        return size;
    }

    public List<VideoXml> getVideos() {
        return videos;
    }
}
