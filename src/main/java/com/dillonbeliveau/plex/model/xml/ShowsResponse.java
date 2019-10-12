package com.dillonbeliveau.plex.model.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShowsResponse {
    @JacksonXmlElementWrapper(localName = "Directory", useWrapping = false)
    @JacksonXmlProperty(localName = "Directory")
    private List<ShowXML> shows;

    public List<ShowXML> getShows() {
        return shows;
    }
}
