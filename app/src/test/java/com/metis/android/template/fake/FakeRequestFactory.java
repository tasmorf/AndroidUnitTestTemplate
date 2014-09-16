package com.metis.android.template.fake;

import com.android.volley.Request;
import com.android.volley.Response;
import com.metis.android.template.model.bean.client.Movie;
import com.metis.android.template.model.request.RequestFactory;

import java.util.List;

/**
 * Always returns the request it was constructed with
 */
public class FakeRequestFactory<T> implements RequestFactory<T> {
    private Request<T> aRequest;

    public FakeRequestFactory(Request<T> aRequest) {
        this.aRequest = aRequest;
    }

    @Override
    public Request<T> createRequest(String url, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        return aRequest;
    }

    @Override
    public Request<T> createRequest(int method, String url, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        return aRequest;
    }

    @Override
    public Request<T> createRequest(int method, Object requestBody, String url, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        return aRequest;
    }
}
