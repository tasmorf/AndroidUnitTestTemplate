package com.metis.android.template.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.metis.android.template.R;
import com.metis.android.template.model.bean.client.Movie;

import static com.metis.android.template.module.view.ImageLoaderModule.imageLoader;


/**
 * Represents a single movie
 */
public class MovieRowView extends LinearLayout{
    private TextView title;
    private TextView id;
    private TextView year;
    private ImageView thumbnail;
    private ImageLoader imageLoader;

    public MovieRowView(Context context) {
        super(context);
        postConstruct(imageLoader());
    }

    public MovieRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        postConstruct(imageLoader());
    }

    public MovieRowView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        postConstruct(imageLoader());
    }

    private void postConstruct(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        title = (TextView)findViewById(R.id.title);
        id = (TextView)findViewById(R.id.id);
        year = (TextView)findViewById(R.id.year);
        thumbnail = (ImageView)findViewById(R.id.thumbnail);
    }

    public void setData(Movie movie) {
        title.setText(movie.getTitle());
        id.setText(movie.getId());
        year.setText(String.valueOf(movie.getYear()));
        ImageLoader.ImageContainer imageContainer = (ImageLoader.ImageContainer) thumbnail.getTag();
        if(imageContainer == null || !imageContainer.getRequestUrl().equals(movie.getImageUrl())) {
            thumbnail.setTag(imageLoader.get(movie.getImageUrl(), ImageLoader.getImageListener(thumbnail,
                    R.drawable.ic_launcher, R.drawable.ic_launcher)));
        }
    }
}
