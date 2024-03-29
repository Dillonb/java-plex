package com.dillonbeliveau.plex.model.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class VideoTag {
    @JacksonXmlProperty(localName = "tag", isAttribute = true)
    private String tag;
}
