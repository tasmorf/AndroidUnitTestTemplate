package com.metis.android.template.controller.activity;

import android.app.Activity;
import android.os.Bundle;

import com.metis.android.template.controller.fragment.MovieListFragment;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, MovieListFragment.newInstance()).commit();
    }

}
