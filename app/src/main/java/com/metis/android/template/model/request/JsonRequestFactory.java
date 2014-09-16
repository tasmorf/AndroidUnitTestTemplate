package com.metis.android.template.model.request;

import com.android.volley.Request;
import com.android.volley.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.Converter;
import com.metis.android.template.model.bean.client.Movie;
import com.metis.android.template.model.header.HeaderProvider;

import java.util.List;

/**
 * Creates requests in order to get all the movies
 */
public class JsonRequestFactory<F, T> implements RequestFactory<T> {

    private HeaderProvider headerProvider;
    private ObjectMapper objectMapper;
    private Converter<F, T> converter;
    private Class<F> serverClass;

    public JsonRequestFactory(HeaderProvider headerProvider, ObjectMapper objectMapper, Converter<F, T> converter, Class<F> serverClass) {
        this.headerProvider = headerProvider;
        this.objectMapper = objectMapper;
        this.converter = converter;
        this.serverClass = serverClass;
    }

    @Override
    public Request<T> createRequest(String url, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        return new ConverterRequest<F, T>(Request.Method.GET, url, null, listener, errorListener, headerProvider,
                objectMapper, converter, serverClass);
    }

    @Override
    public Request<T> createRequest(int method, String url, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        return new ConverterRequest<F, T>(method, url, null, listener, errorListener, headerProvider,
                objectMapper, converter, serverClass);
    }

    @Override
    public Request<T> createRequest(int method, Object requestBody, String url, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        return new ConverterRequest<F, T>(method, url, requestBody, listener, errorListener, headerProvider,
                objectMapper, converter, serverClass);
    }
}
