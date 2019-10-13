package com.dillonbeliveau.plex.util;

import java.util.concurrent.Callable;

public class Retry {

    public static <T> T retry(Callable<T> call) throws Exception {
        return retry(call, 3);
    }

    public static <T> T retry(Callable<T> call, int tries) throws Exception {
        int triesRemaining = tries;
        Exception lastException = new IllegalArgumentException("Never even tried. Did you tell me to retry 0 times?");
        while (triesRemaining > 0) {
            try {
                return call.call();
            } catch (Exception e) {
                lastException = e;
            }
            triesRemaining--;
        }
        throw lastException;
    }
}
