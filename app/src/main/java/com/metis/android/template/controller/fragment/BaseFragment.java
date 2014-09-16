package com.metis.android.template.controller.fragment;

import android.app.Activity;
import android.app.Fragment;

/**
 * Unfortunately this base class is needed if we want to test fragments in isolation. A few methods of the {@link
 * android.app.Fragment} class are overriden and changed in order to facilitate unit tests
 */
public class BaseFragment extends Fragment {

    private Activity activity;

    @Override
    public void onAttach(Activity activity) {
        this.activity = activity;
        super.onAttach(activity);
    }

    public Activity getActivityOveride() {
        return activity;
    }

    public String getStringOveride(int id) {
        return activity.getString(id);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }
}
