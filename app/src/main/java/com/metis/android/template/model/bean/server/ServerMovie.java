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
}
