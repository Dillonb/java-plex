package com.dillonbeliveau.plex.model.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MyPlexDevice {
    @JacksonXmlElementWrapper(localName = "Connection", useWrapping = false)
    @JsonProperty("Connection")
    List<MyPlexDeviceConnection> connections = new ArrayList<>();

    @JacksonXmlProperty(localName = "name", isAttribute = true)
    private String name;

    @JacksonXmlProperty(localName = "product", isAttribute = true)
    private String product;

    @JacksonXmlProperty(localName = "productVersion", isAttribute = true)
    private String productVersion;

    @JacksonXmlProperty(localName = "platform", isAttribute = true)
    private String platform;

    @JacksonXmlProperty(localName = "platformVersion", isAttribute = true)
    private String platformVersion;

    @JacksonXmlProperty(localName = "device", isAttribute = true)
    private String device;

    @JacksonXmlProperty(localName = "clientIdentifier", isAttribute = true)
    private String clientIdentifier;

    @JacksonXmlProperty(localName = "createdAt", isAttribute = true)
    private String createdAt;

    @JacksonXmlProperty(localName = "lastSeenAt", isAttribute = true)
    private String lastSeenAt;

    @JacksonXmlProperty(localName = "provides", isAttribute = true)
    private String provides;

    @JacksonXmlProperty(localName = "owned", isAttribute = true)
    private String owned;

    @JacksonXmlProperty(localName = "publicAddress", isAttribute = true)
    private String publicAddress;

    @JacksonXmlProperty(localName = "publicAddressMatches", isAttribute = true)
    private String publicAddressMatches;

    @JacksonXmlProperty(localName = "presence", isAttribute = true)
    private String presence;

    @JacksonXmlProperty(localName = "accessToken", isAttribute = true)
    private String accessToken;

    @JacksonXmlProperty(localName = "httpsRequired", isAttribute = true)
    private String httpsRequired;

    @JacksonXmlProperty(localName = "sourceTitle", isAttribute = true)
    private String sourceTitle;

    @JacksonXmlProperty(localName = "synced", isAttribute = true)
    private String synced;

    @JacksonXmlProperty(localName = "dnsRebindingProtection", isAttribute = true)
    private String dnsRebindingProtection;

    @JacksonXmlProperty(localName = "relay", isAttribute = true)
    private String relay;

    @JacksonXmlProperty(localName = "ownerId", isAttribute = true)
    private String ownerId;

    @JacksonXmlProperty(localName = "home", isAttribute = true)
    private String home;

    public Date getCreatedAt() {
        return Util.stringToDate(createdAt);
    }

    public Date getLastSeenAt() {
        return Util.stringToDate(lastSeenAt);
    }

    public boolean isOwned() {
        return "1".equals(owned);
    }

    public boolean getPublicAddressMatches() {
        return "1".equals(publicAddressMatches);
    }

    public boolean isPresent() {
        return "1".equals(presence);
    }

    public boolean isHttpsRequired() {
        return "1".equals(httpsRequired);
    }

    public boolean isSynced() {
        return "1".equals(synced);
    }

    @Override
    public String toString() {
        return String.format("%s - %s present: %b", getName(), getProduct(), isPresent());
    }
}
