package com.metis.android.template.model.bean.server;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Contains a list of {@link ServerMovie} objects
 */
public class ServerMoviesResponse {

    @JsonProperty("link_template")
    private String linkTemplate;
    private int total;
    private List<ServerMovie> movies;

    public String getLinkTemplate() {
        return linkTemplate;
    }

    public int getTotal() {
        return total;
    }

    public List<ServerMovie> getMovies() {
        return movies;
    }
}
