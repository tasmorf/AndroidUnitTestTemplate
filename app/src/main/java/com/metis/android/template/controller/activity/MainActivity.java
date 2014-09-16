package com.metis.android.template.controller.activity;

import android.app.Activity;
import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.metis.android.template.R;
import com.metis.android.template.controller.fragment.MovieListFragment;
import com.metis.android.template.model.bean.client.Movie;
import com.metis.android.template.model.request.RequestFactory;
import com.metis.android.template.view.Toaster;

import java.util.List;

import static com.metis.android.template.module.model.RequestFactoryModule.allMoviesRequestFactory;
import static com.metis.android.template.module.model.RequestQueueModule.requestQueue;
import static com.metis.android.template.module.view.ToasterModule.toaster;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, MovieListFragment.newInstance()).commit();
    }

}
