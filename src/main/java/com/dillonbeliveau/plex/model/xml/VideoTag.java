package com.dillonbeliveau.plex.model.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class VideoTag {
    @JacksonXmlProperty(localName = "tag", isAttribute = true)
    private String tag;

    public String getTag() {
        return tag;
    }
}
