package com.metis.android.template.response;

import com.metis.android.template.model.bean.server.ServerMovie;

import java.util.HashMap;
import java.util.Map;

import static com.metis.android.template.model.bean.server.ServerMovie.aServerMovie;

public class ServerMovies {

    public static final String GODZILLA_TITLE = "Godzilla";
    public static final int GODZILLA_YEAR = 2014;
    public static final String GODZILLA_ID = "771225175";
    public static final String GODZILLA_SYNOPSIS = "In Summer 2014, the world's most revered monster is reborn as Warner Bros. Pictures and Legendary Pictures unleash the epic action adventure \\\"Godzilla.\\\" From visionary new director Gareth Edwards (\\\"Monsters\\\") comes a powerful story of human courage and reconciliation in the face of titanic forces of nature, when the awe-inspiring Godzilla rises to restore balance as humanity stands defenseless. (c) Warner Bros";
    public static final int GODZILLA_RUNTIME = 138;
    public static final String GODZILLA_THUMBNAIL_POSTER = "http://content8.flixster.com/movie/11/17/95/11179576_tmb.jpg";
    public static final String GODZILLA_PROFILE_POSTER = "http://content8.flixster.com/movie/11/17/95/11179577_tmb.jpg";
    public static final String GODZILLA_DETAILED_POSTER = "http://content8.flixster.com/movie/11/17/95/11179578_tmb.jpg";
    public static final String GODZILLA_ORIGINAL_POSTER = "http://content8.flixster.com/movie/11/17/95/11179579_tmb.jpg";

    public static ServerMovie godzilla() {
        Map<String,String> posters = new HashMap<String, String>();
        posters.put("thumbnail", GODZILLA_THUMBNAIL_POSTER);
        posters.put("profile", GODZILLA_PROFILE_POSTER);
        posters.put("detailed", GODZILLA_DETAILED_POSTER);
        posters.put("original", GODZILLA_ORIGINAL_POSTER);
        return aServerMovie()
                .title(GODZILLA_TITLE)
                .year(GODZILLA_YEAR)
                .id(GODZILLA_ID)
                .synopsis(GODZILLA_SYNOPSIS)
                .runtime(GODZILLA_RUNTIME)
                .links(new HashMap<String, String>())
                .posters(posters)
                .build();
    }
}
