package com.dillonbeliveau.plex.model.xml;

import java.util.Date;

class Util {
    static Date stringToDate(String stringDate) {
        if (stringDate == null) {
            return null;
        }
        else {
            return new Date(Long.parseLong(stringDate) * 1000);
        }
    }
}
