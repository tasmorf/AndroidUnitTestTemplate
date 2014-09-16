package com.metis.android.template.view.indicator;

import android.view.View;
import android.widget.AdapterView;

import com.metis.android.template.controller.listener.OnMovieClickListener;
import com.metis.android.template.model.bean.client.Movie;

import java.util.List;

/**
 * Handles the actual displaying of a list opf movies
 */
public interface MovieListIndicator {

    void initialize(View rootView, OnMovieClickListener onMovieClickListener);
    void showData(List<Movie> movies);
    void showError();
}
