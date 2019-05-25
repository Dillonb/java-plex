package com.dillonbeliveau.plex.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LibrarySectionsResponse {
    @JacksonXmlElementWrapper(localName = "Directory", useWrapping = false)
    @JacksonXmlProperty(localName = "Directory")
    private List<LibrarySection> sections = new ArrayList<>();

    public List<LibrarySection> getSections() {
        return sections;
    }
}
