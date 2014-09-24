package com.metis.android.template.tests;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.google.android.apps.common.testing.ui.espresso.IdlingResource;
import com.metis.android.template.module.model.RequestQueueModule;

import java.lang.reflect.Field;
import java.util.Set;

/**
* Does something
*/
public final class VolleyIdlingResource implements IdlingResource {
    private static final String TAG = "VolleyIdlingResource";
    private final String resourceName;
    // written from main thread, read from any thread.
    private volatile ResourceCallback resourceCallback;
    private Field currentRequests;
    private RequestQueue volleyRequestQueue;
    public VolleyIdlingResource(String resourceName) throws SecurityException, NoSuchFieldException {
        this.resourceName = resourceName;
        volleyRequestQueue = RequestQueueModule.requestQueue();
        currentRequests = RequestQueue.class.getDeclaredField("mCurrentRequests");
        currentRequests.setAccessible(true);
    }
    @Override
    public String getName() {
        return resourceName;
    }
    @Override
    public boolean isIdleNow() {
        try {
            Set<Request> set = (Set<Request>) currentRequests.get(volleyRequestQueue);
            int count = set.size();
            if (set != null) {
                if (count == 0) {
                    Log.d(TAG, "Volley is idle now! with: " + count);
                    resourceCallback.onTransitionToIdle();
                } else {
                    Log.d(TAG, "Not idle... " +count);
                }
                return count == 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    @Override
    public void registerIdleTransitionCallback(ResourceCallback resourceCallback) {
        this.resourceCallback = resourceCallback;
    }
}
