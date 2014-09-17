package com.metis.android.template.controller.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.metis.android.template.R;
import com.metis.android.template.controller.activity.SynopsisDialogActivity;
import com.metis.android.template.controller.listener.OnMovieClickListener;
import com.metis.android.template.model.UrlProvider;
import com.metis.android.template.model.bean.client.Movie;
import com.metis.android.template.model.request.RequestFactory;
import com.metis.android.template.view.indicator.MovieListIndicator;

import java.util.List;

import static com.metis.android.template.module.model.RequestFactoryModule.allMoviesRequestFactory;
import static com.metis.android.template.module.model.RequestQueueModule.requestQueue;
import static com.metis.android.template.module.model.UrlProviderModule.urlProvider;
import static com.metis.android.template.module.view.IndicatorModule.movieListIndicator;

/**
 * Downloads and then uses an indicator to display a list of movies
 */
public class MovieListFragment extends BaseFragment implements Response.Listener<List<Movie>>,
        Response.ErrorListener,
        OnMovieClickListener {

    private RequestQueue requestQueue;
    private RequestFactory<List<Movie>> moviesRequestFactory;
    private MovieListIndicator indicator;
    private UrlProvider urlProvider;

    public static Fragment newInstance() {
        Fragment result = new MovieListFragment();
        Bundle args = new Bundle();
        result.setArguments(args);
        return result;
    }

    public MovieListFragment() {
        this(requestQueue(), allMoviesRequestFactory(), movieListIndicator(),
                urlProvider());
    }

    public MovieListFragment(RequestQueue requestQueue, RequestFactory<List<Movie>> moviesRequestFactory,
                             MovieListIndicator indicator, UrlProvider urlProvider) {
        this.requestQueue = requestQueue;
        this.moviesRequestFactory = moviesRequestFactory;
        this.indicator = indicator;
        this.urlProvider = urlProvider;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);
        indicator.initialize(view, this);
        requestQueue.add(moviesRequestFactory.createRequest(urlProvider.allMoviesUrl(), this, this));
        return view;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        indicator.showError();
    }

    @Override
    public void onResponse(List<Movie> response) {
        indicator.showData(response);
    }

    @Override
    public void onMovieClicked(Movie movie) {
        startActivity(SynopsisDialogActivity.getSynopsisDialogIntent(getActivityOveride(), movie.getTitle(), movie.getSynopsis()));
    }
}
