package com.metis.android.template.model.persistence;

import android.content.SharedPreferences;

/**
 * Uses the shared preferences in order to save and get stuff
 */
public class SimpleAndroidPreferences implements SimplePreferences {
    private SharedPreferences sharedPreferences;

    public SimpleAndroidPreferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public String getString(String key) {
        return sharedPreferences.getString(key, null);
    }

    @Override
    public void saveString(String key, String value) {
        sharedPreferences.edit().putString(key, value).apply();
    }
}
