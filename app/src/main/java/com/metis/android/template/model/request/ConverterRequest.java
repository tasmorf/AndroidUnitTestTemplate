package com.metis.android.template.model.request;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.Converter;
import com.metis.android.template.model.header.HeaderProvider;

import java.util.Map;

/**
 * A {@link com.android.volley.toolbox.JsonRequest} that uses an {@link com.fasterxml.jackson.databind.ObjectMapper}
 * and a {@link com.fasterxml.jackson.databind.util.Converter} in order to parse the network response into a client
 * bean that the app can use
 */
public class ConverterRequest<F, T> extends JsonRequest<T> {

    private Object requestObject;
    private HeaderProvider headerProvider;
    private ObjectMapper objectMapper;
    private Converter<F, T> converter;
    private Class<F> serverClass;

    public ConverterRequest(int method,
                            String url,
                            Object requestObject,
                            Response.Listener<T> listener,
                            Response.ErrorListener errorListener,
                            HeaderProvider headerProvider,
                            ObjectMapper objectMapper,
                            Converter<F, T> converter,
                            Class<F> serverClass) {
        super(method, url, null, listener, errorListener);
        this.requestObject = requestObject;
        this.headerProvider = headerProvider;
        this.objectMapper = objectMapper;
        this.converter = converter;
        this.serverClass = serverClass;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            return Response.success(converter.convert(objectMapper.readValue(response.data, serverClass)),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (Exception e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headerProvider.getHeaders();
    }

    @Override
    public byte[] getBody() {
        try {
            byte[] result = objectMapper.writeValueAsBytes(requestObject);
            return result;
        } catch (JsonProcessingException e) {
            throw new RuntimeException("The request body can't be converted to JSON");
        }
    }

    @Override
    public void deliverError(VolleyError error) {
        Log.w(ConverterRequest.class.getSimpleName(), "Delivering error:" + error);
        super.deliverError(error);
    }
}
