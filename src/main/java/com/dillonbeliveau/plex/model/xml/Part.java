package com.dillonbeliveau.plex.model.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class Part {
    @JacksonXmlProperty(localName = "id", isAttribute = true)
    String id;

    @JacksonXmlProperty(localName = "key", isAttribute = true)
    String key;

    @JacksonXmlProperty(localName = "duration", isAttribute = true)
    String duration;

    @JacksonXmlProperty(localName = "file", isAttribute = true)
    String file;

    @JacksonXmlProperty(localName = "size", isAttribute = true)
    String size;

    @JacksonXmlProperty(localName = "audioProfile", isAttribute = true)
    String audioProfile;

    @JacksonXmlProperty(localName = "container", isAttribute = true)
    String container;

    @JacksonXmlProperty(localName = "videoProfile", isAttribute = true)
    String videoProfile;

    @JacksonXmlProperty(localName = "hasThumbnail", isAttribute = true)
    String hasThumbnail;

    @JacksonXmlProperty(localName = "has64bitOffsets", isAttribute = true)
    String has64bitOffsets;

    @JacksonXmlProperty(localName = "optimizedForStreaming", isAttribute = true)
    String optimizedForStreaming;
}
