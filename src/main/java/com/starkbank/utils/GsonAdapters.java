package com.starkbank.utils;

import com.starkbank.error.ErrorElement;
import com.starkcore.utils.GsonEvent;

public class GsonAdapters {
    private static boolean initialized = false;

    public static synchronized void setup() {
        if (initialized) {
            return;
        }

        GsonEvent.registerTypeAdapter(ErrorElement.class, new ErrorElement.Deserializer());
        initialized = true;
    }
}
