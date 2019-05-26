package com.dillonbeliveau.plex;

import com.dillonbeliveau.plex.model.xml.MyPlexDevice;
import com.dillonbeliveau.plex.model.xml.MyPlexDeviceConnection;
import okhttp3.Headers;
import okhttp3.OkHttpClient;

import java.util.List;

class PlexClient {
    private static final OkHttpClient client = new OkHttpClient();

    /**
     * Gets the best connection to a given Plex server.
     * Picks local if available, then non-relay.
     * @param device The plex server to attempt to connect to
     * @return the best connection object available.
     */
    static MyPlexDeviceConnection getBestConnection(MyPlexDevice device) {
        List<MyPlexDeviceConnection> connections = device.getConnections();

        connections.sort((c1, c2) -> {
            // Pick a local server if we can
            if (!c1.isLocal().equals(c2.isLocal())) {
                return c1.isLocal().compareTo(c2.isLocal());
            }

            if (!c1.isRelay().equals(c2.isRelay())) {
                // Pick a non-relay server if we can

                Boolean c1NotRelay = !c1.isRelay();
                Boolean c2NotRelay = !c2.isRelay();

                return c1NotRelay.compareTo(c2NotRelay);
            }

            return 0; // Equal priority
        });

        return connections.get(0);
    }

    private static Headers baseHeaders = new Headers.Builder()
            .add("X-Plex-Platform", "java-plex")
            .add("X-Plex-Platform-Version", "1.0.0-SNAPSHOT")
            .add("X-Plex-Provides", "controller")
            .add("X-Plex-Client-Identifier", "java-plex")
            .build();

    static Headers getBaseHeaders() {
        return baseHeaders;
    }
}
