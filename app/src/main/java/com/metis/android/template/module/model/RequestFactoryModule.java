package com.metis.android.template.module.model;

import com.metis.android.template.model.bean.client.Movie;
import com.metis.android.template.model.bean.server.ServerMoviesResponse;
import com.metis.android.template.model.request.JsonRequestFactory;
import com.metis.android.template.model.request.RequestFactory;

import java.util.List;

import static com.metis.android.template.module.model.ConverterModule.movieConverter;
import static com.metis.android.template.module.model.HeaderProviderModule.headerProvider;
import static com.metis.android.template.module.model.ObjectMapperModule.objectMapper;

public class RequestFactoryModule {

    public static RequestFactory<List<Movie>> allMoviesRequestFactory() {
        return new JsonRequestFactory<ServerMoviesResponse, List<Movie>>(headerProvider(),
                objectMapper(),
                movieConverter(),
                ServerMoviesResponse.class);
    }
}
