package com.metis.android.template.fake;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xmlpull.v1.XmlPullParser;

/**
 * A layout inflater that always returns a single view
 */
public class FakeLayoutInflater extends LayoutInflater {
    private View view;

    public FakeLayoutInflater(View view) {
        super(null);
        this.view = view;
    }

    @Override
    public LayoutInflater cloneInContext(Context context) {
        return null;
    }

    @Override
    public View inflate(int resource, ViewGroup root) {
        return view;
    }

    @Override
    public View inflate(int resource, ViewGroup root, boolean attachToRoot) {
        return view;
    }
}
