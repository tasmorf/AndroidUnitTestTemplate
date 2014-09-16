package com.metis.android.template.module.model;

import android.preference.PreferenceManager;

import com.metis.android.template.model.persistence.SimpleAndroidPreferences;
import com.metis.android.template.model.persistence.SimplePreferences;

import static com.metis.android.template.module.ApplicationModule.applicationContext;

public class SimplePreferencesModule {
    public static SimplePreferences defaultSimplePreferences() {
        return new SimpleAndroidPreferences(PreferenceManager.getDefaultSharedPreferences(applicationContext()));
    }
}
