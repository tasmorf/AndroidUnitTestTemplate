package com.metis.android.template.model.request;

import com.android.volley.Request;
import com.android.volley.Response;

/**
 * Creates {@link com.android.volley.Request} objects
 */
public interface RequestFactory<T> {

    /**
     * Create a simple get request
     * @param url
     * @param listener
     * @param errorListener
     * @return
     */
    Request<T> createRequest(String url, Response.Listener<T> listener, Response.ErrorListener errorListener);

    /**
     * Create a request and specify the method
     * @param method
     * @param url
     * @param listener
     * @param errorListener
     * @return
     */
    Request<T> createRequest(int method, String url, Response.Listener<T> listener, Response.ErrorListener errorListener);

    /**
     * Create a request and specify the method and an object (which will be serialized for the body)
     * @param method
     * @param requestBody
     * @param url
     * @param listener
     * @param errorListener
     * @return
     */
    Request<T> createRequest(int method, Object requestBody, String url, Response.Listener<T> listener, Response.ErrorListener errorListener);

}

