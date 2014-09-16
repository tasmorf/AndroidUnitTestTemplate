package com.metis.android.template.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

import com.metis.android.template.R;
import com.metis.android.template.model.bean.client.Movie;
import com.metis.android.template.view.widget.MovieRowView;

import java.util.List;

/**
 * Displays movies
 */
public class MovieAdapter extends BaseAdapter {
    private final Context context;
    private final List<Movie> movies;

    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.view_movie_row, viewGroup, false);
        }
        ((MovieRowView)convertView).setData(movies.get(position));
        return convertView;
    }
}
