package com.metis.android.template.model;

import android.content.res.Resources;

import com.metis.android.template.R;

/**
 * Uses the android resources in order to provide urls
 */
public class ResourcesUrlProvider implements UrlProvider {

    private Resources resources;

    public ResourcesUrlProvider(Resources resources) {
        this.resources = resources;
    }

    @Override
    public String allMoviesUrl() {
        return resources.getString(R.string.movies_url);
    }
}
