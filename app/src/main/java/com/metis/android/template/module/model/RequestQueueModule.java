package com.metis.android.template.module.model;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import static com.metis.android.template.module.ApplicationModule.applicationContext;

public class RequestQueueModule {

    private static RequestQueue requestQueue = Volley.newRequestQueue(applicationContext());

    public static RequestQueue requestQueue() {
        return requestQueue;
    }
}
