package com.metis.android.template.view.indicator.impl;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.metis.android.template.R;
import com.metis.android.template.controller.listener.OnMovieClickListener;
import com.metis.android.template.model.bean.client.Movie;
import com.metis.android.template.view.Toaster;
import com.metis.android.template.view.adapter.MovieAdapter;
import com.metis.android.template.view.indicator.MovieListIndicator;

import java.util.List;

/**
 * Uses views in order to diplay a movie list
 */
public class MovieListViewIndicator implements MovieListIndicator, AdapterView.OnItemClickListener {

    private final Resources res;
    private final Toaster toaster;

    private View progress;
    private ListView listView;
    private OnMovieClickListener onMovieClickListener;

    public MovieListViewIndicator(Resources res, Toaster toaster) {
        this.res = res;
        this.toaster = toaster;
    }

    @Override
    public void initialize(View rootView, OnMovieClickListener onMovieClickListener) {
        this.onMovieClickListener = onMovieClickListener;
        progress = rootView.findViewById(R.id.progress);
        listView = (ListView)rootView.findViewById(R.id.content_list);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void showData(List<Movie> movies) {
        progress.setVisibility(View.GONE);
        listView.setVisibility(View.VISIBLE);
        listView.setAdapter(new MovieAdapter(listView.getContext(), movies));
    }

    @Override
    public void showError() {
        progress.setVisibility(View.GONE);
        //just show a generic error
        toaster.showToast(res.getString(R.string.an_error_happened));
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        onMovieClickListener.onMovieClicked((Movie) adapterView.getAdapter().getItem(i));
    }
}
