package com.metis.android.template.model.converter;

import com.fasterxml.jackson.databind.util.StdConverter;
import com.metis.android.template.model.bean.client.Movie;
import com.metis.android.template.model.bean.server.ServerMovie;
import com.metis.android.template.model.bean.server.ServerMoviesResponse;

import java.util.ArrayList;
import java.util.List;

import static com.metis.android.template.model.bean.client.Movie.aMovie;

/**
 * Converts from a {@link com.metis.android.template.model.bean.server.ServerMoviesResponse} to a {@link
 * com.metis.android.template.model.bean.client.Movie} list
 */
public class MoviesConverter extends StdConverter<ServerMoviesResponse, List<Movie>> {

    @Override
    public List<Movie> convert(ServerMoviesResponse from) {
        List<ServerMovie> serverMovies = from.getMovies();
        List<Movie> result = new ArrayList<Movie>(serverMovies.size());
        for (ServerMovie serverMovie : serverMovies) {
            result.add(aMovie()
                    .id(serverMovie.getId())
                    .title(serverMovie.getTitle())
                    .year(serverMovie.getYear())
                    .synopsis(serverMovie.getSynopsis())
                    .imageUrl(serverMovie.getPosters().get("thumbnail"))
                    .build());
        }
        return result;
    }
}
