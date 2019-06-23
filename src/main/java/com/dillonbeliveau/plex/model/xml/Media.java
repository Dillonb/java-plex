package com.dillonbeliveau.plex.model.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class Media {
    @JacksonXmlProperty(localName = "id", isAttribute = true)
    String id;
    @JacksonXmlProperty(localName = "duration", isAttribute = true)
    String duration;

    @JacksonXmlProperty(localName = "bitrate", isAttribute = true)
    String bitrate;

    @JacksonXmlProperty(localName = "width", isAttribute = true)
    String width;

    @JacksonXmlProperty(localName = "height", isAttribute = true)
    String height;

    @JacksonXmlProperty(localName = "aspectRatio", isAttribute = true)
    String aspectRatio;

    @JacksonXmlProperty(localName = "audioChannels", isAttribute = true)
    String audioChannels;

    @JacksonXmlProperty(localName = "audioCodec", isAttribute = true)
    String audioCodec;

    @JacksonXmlProperty(localName = "videoCodec", isAttribute = true)
    String videoCodec;

    @JacksonXmlProperty(localName = "videoResolution", isAttribute = true)
    String videoResolution;

    @JacksonXmlProperty(localName = "container", isAttribute = true)
    String container;

    @JacksonXmlProperty(localName = "videoFrameRate", isAttribute = true)
    String videoFrameRate;

    @JacksonXmlProperty(localName = "audioProfile", isAttribute = true)
    String audioProfile;

    @JacksonXmlProperty(localName = "videoProfile", isAttribute = true)
    String videoProfile;

    @JacksonXmlProperty(localName = "optimizedForStreaming", isAttribute = true)
    String optimizedForStreaming;

    @JacksonXmlProperty(localName = "has64bitOffsets", isAttribute = true)
    String has64bitOffsets;

    @JacksonXmlProperty(localName = "Part")
    Part part;
}
