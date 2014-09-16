package com.metis.android.template.module.view;

import com.android.volley.toolbox.ImageLoader;

import static com.metis.android.template.module.model.RequestQueueModule.requestQueue;
import static com.metis.android.template.module.view.ImageCacheModule.imageCache;

public class ImageLoaderModule {

    private static ImageLoader imageLoader = new ImageLoader(requestQueue(), imageCache());

    public static ImageLoader imageLoader() {
        return imageLoader;
    }
}
