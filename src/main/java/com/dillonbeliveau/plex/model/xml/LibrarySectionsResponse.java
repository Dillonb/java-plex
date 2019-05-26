package com.dillonbeliveau.plex.model.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LibrarySectionsResponse {
    @JacksonXmlElementWrapper(localName = "Directory", useWrapping = false)
    @JacksonXmlProperty(localName = "Directory")
    private List<LibrarySectionXml> sections = new ArrayList<>();

    public List<LibrarySectionXml> getSections() {
        return sections;
    }
}
