package com.metis.android.template.model.converter;

import com.metis.android.template.model.bean.client.Movie;
import com.metis.android.template.model.bean.server.ServerMoviesResponse;
import com.metis.android.template.response.ServerMovies;
import com.metis.android.template.response.ServerMoviesResponses;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MoviesConverterTest {

    private ServerMoviesResponse serverResponse = ServerMoviesResponses.singleGodzillaResponse();
    private List<Movie> result;

    private MoviesConverter converter = new MoviesConverter();

    @Before
    public void setup() {
        result = converter.convert(serverResponse);
    }

    @Test
    public void hasSameSize() {
        assertThat(result.size(), equalTo(serverResponse.getMovies().size()));
    }

    @Test
    public void usesSameTitle() {
        assertThat(result.get(0).getTitle(), equalTo(ServerMovies.GODZILLA_TITLE));
    }

    @Test
    public void usesSameId() {
        assertThat(result.get(0).getId(), equalTo(ServerMovies.GODZILLA_ID));
    }

    @Test
    public void usesSameSynopsis() {
        assertThat(result.get(0).getSynopsis(), equalTo(ServerMovies.GODZILLA_SYNOPSIS));
    }

    @Test
    public void usesThumbnailImage() {
        assertThat(result.get(0).getImageUrl(), equalTo(ServerMovies.GODZILLA_THUMBNAIL_POSTER));
    }
}
