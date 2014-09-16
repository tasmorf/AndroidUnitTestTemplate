package com.metis.android.template.module.model;

import com.metis.android.template.model.header.HeaderProvider;
import com.metis.android.template.model.header.PreferencesHeaderProvider;

import static com.metis.android.template.module.model.SimplePreferencesModule.defaultSimplePreferences;

public class HeaderProviderModule {

    public static HeaderProvider headerProvider() {
        return new PreferencesHeaderProvider(defaultSimplePreferences());
    }
}
