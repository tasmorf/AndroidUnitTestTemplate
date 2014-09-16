package com.metis.android.template.model.persistence;

/**
 * A simple interface for the android {@link android.content.SharedPreferences}. We might not want to use all the
 * methods that exist in that class. Additionally we don't want to be writing all that editor boilerplate code. Finally
 * contains all the keys for the preferences we are going to use in this app.
 */
public interface SimplePreferences {
    public static final String COOKIE = "cookie";

    String getString(String key);

    void saveString(String key, String value);
}
