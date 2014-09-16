package com.metis.android.template.module.model;

import com.fasterxml.jackson.databind.util.Converter;
import com.metis.android.template.model.bean.client.Movie;
import com.metis.android.template.model.bean.converter.MoviesConverter;
import com.metis.android.template.model.bean.server.ServerMoviesResponse;

import java.util.List;

public class ConverterModule {
    public static Converter<ServerMoviesResponse, List<Movie>> movieConverter() {
        return new MoviesConverter();
    }
}
