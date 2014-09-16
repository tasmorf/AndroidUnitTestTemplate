package com.metis.android.template.model.bean.server;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class ServerMovie {

    private String id;
    private String title;
    private int year;
    @JsonProperty("mpaa_rating")
    private String mpaaRating;
    @JsonProperty("critics_consensus")
    private String criticsConsensus;
    private int runtime;
    private String synopsis;
    private Map<String, String> posters;
    private Map<String, String> links;

    public ServerMovie() {
        //needed for Jackson
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public String getCriticsConsensus() {
        return criticsConsensus;
    }

    public int getRuntime() {
        return runtime;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public Map<String, String> getPosters() {
        return posters;
    }

    public Map<String, String> getLinks() {
        return links;
    }

    private ServerMovie(Builder builder) {
        id = builder.id;
        title = builder.title;
        year = builder.year;
        mpaaRating = builder.mpaaRating;
        criticsConsensus = builder.criticsConsensus;
        runtime = builder.runtime;
        synopsis = builder.synopsis;
        posters = builder.posters;
        links = builder.links;
    }

    public static Builder aServerMovie() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private String title;
        private int year;
        private String mpaaRating;
        private String criticsConsensus;
        private int runtime;
        private String synopsis;
        private Map<String, String> posters;
        private Map<String, String> links;

        private Builder() {
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Builder mpaaRating(String mpaaRating) {
            this.mpaaRating = mpaaRating;
            return this;
        }

        public Builder criticsConsensus(String criticsConsensus) {
            this.criticsConsensus = criticsConsensus;
            return this;
        }

        public Builder runtime(int runtime) {
            this.runtime = runtime;
            return this;
        }

        public Builder synopsis(String synopsis) {
            this.synopsis = synopsis;
            return this;
        }

        public Builder posters(Map<String, String> posters) {
            this.posters = posters;
            return this;
        }

        public Builder links(Map<String, String> links) {
            this.links = links;
            return this;
        }

        public ServerMovie build() {
            return new ServerMovie(this);
        }
    }
}
