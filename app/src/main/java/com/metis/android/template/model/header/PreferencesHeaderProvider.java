package com.metis.android.template.model.header;

import com.metis.android.template.model.persistence.SimplePreferences;

import java.util.Collections;
import java.util.Map;

/**
 * Uses the preferences in order to provide the correct headers. Great for cookies, sessions etc.
 */
public class PreferencesHeaderProvider implements HeaderProvider {

    private SimplePreferences simplePreferences;

    public PreferencesHeaderProvider(SimplePreferences simplePreferences) {
        this.simplePreferences = simplePreferences;
    }

    @Override
    public Map<String, String> getHeaders() {
        return Collections.EMPTY_MAP;
    }
}
