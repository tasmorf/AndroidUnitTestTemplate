package com.metis.android.template.module.view;

import com.metis.android.template.view.indicator.MovieListIndicator;
import com.metis.android.template.view.indicator.impl.MovieListViewIndicator;

import static com.metis.android.template.module.ResourcesModule.resources;
import static com.metis.android.template.module.view.ToasterModule.toaster;

public class IndicatorModule {
    public static MovieListIndicator movieListIndicator() {
        return new MovieListViewIndicator(resources(), toaster());
    }
}
