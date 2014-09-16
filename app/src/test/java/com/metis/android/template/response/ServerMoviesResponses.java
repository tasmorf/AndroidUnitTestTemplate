package com.metis.android.template.response;

import com.metis.android.template.model.bean.server.ServerMoviesResponse;

import java.util.Arrays;

import static com.metis.android.template.model.bean.server.ServerMoviesResponse.aServerMoviesResponse;

public class ServerMoviesResponses {

    public static ServerMoviesResponse singleGodzillaResponse() {
        return aServerMoviesResponse()
                .total(1)
                .movies(Arrays.asList(ServerMovies.godzilla()))
                .build();
    }
}
