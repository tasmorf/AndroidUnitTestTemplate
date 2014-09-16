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

    public ServerMoviesResponse() {
        //needed for jackson
    }

    public String getLinkTemplate() {
        return linkTemplate;
    }

    public int getTotal() {
        return total;
    }

    public List<ServerMovie> getMovies() {
        return movies;
    }

    private ServerMoviesResponse(Builder builder) {
        linkTemplate = builder.linkTemplate;
        total = builder.total;
        movies = builder.movies;
    }

    public static Builder aServerMoviesResponse() {
        return new Builder();
    }

    public static final class Builder {
        private String linkTemplate;
        private int total;
        private List<ServerMovie> movies;

        private Builder() {
        }

        public Builder linkTemplate(String linkTemplate) {
            this.linkTemplate = linkTemplate;
            return this;
        }

        public Builder total(int total) {
            this.total = total;
            return this;
        }

        public Builder movies(List<ServerMovie> movies) {
            this.movies = movies;
            return this;
        }

        public ServerMoviesResponse build() {
            return new ServerMoviesResponse(this);
        }
    }
}
