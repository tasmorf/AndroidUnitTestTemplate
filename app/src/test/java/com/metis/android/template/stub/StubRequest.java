package com.metis.android.template.stub;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;

/**
 * A request that does nothing. Only used for unit testing.
 */
public class StubRequest<T> extends Request<T> {

    public StubRequest() {
        super(0, null, null);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        return null;
    }

    @Override
    protected void deliverResponse(T response) {

    }
}
