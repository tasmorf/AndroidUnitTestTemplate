package com.metis.android.template.module.view;

import android.app.ActivityManager;
import android.content.Context;

import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.metis.android.template.view.LruImageCache;

import static com.metis.android.template.module.ApplicationModule.applicationContext;

public class ImageCacheModule {

	private static ImageCache imageCache = new LruImageCache(getCacheSize());

	public static ImageCache imageCache() {
		return imageCache;
	}

	private static int getCacheSize() {
		int memClass = ((ActivityManager) applicationContext().getSystemService(Context.ACTIVITY_SERVICE))
				.getMemoryClass();
        //use an eighth of the available memory
		return memClass * 1024 * 1024 / 8;
	}

}
