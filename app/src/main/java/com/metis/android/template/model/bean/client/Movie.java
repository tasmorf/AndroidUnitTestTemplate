package com.metis.android.template.model.bean.client;

/**
 * Represents a single movie
 */
public class Movie {

    private String title;
    private String id;
    private String synopsis;
    private String imageUrl;
    private int year;

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    private Movie(Builder builder) {
        title = builder.title;
        id = builder.id;
        synopsis = builder.synopsis;
        imageUrl = builder.imageUrl;
        year = builder.year;
    }

    public static Builder aMovie() {
        return new Builder();
    }

    public static final class Builder {
        private String title;
        private String id;
        private String synopsis;
        private String imageUrl;
        private int year;

        private Builder() {
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder synopsis(String synopsis) {
            this.synopsis = synopsis;
            return this;
        }

        public Builder imageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }
}
