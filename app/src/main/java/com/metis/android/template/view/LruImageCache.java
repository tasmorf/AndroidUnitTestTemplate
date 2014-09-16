package com.metis.android.template.view;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.android.volley.toolbox.ImageLoader.ImageCache;

public class LruImageCache extends LruCache<String, Bitmap> implements ImageCache {

	public LruImageCache(int maxSize) {
		super(maxSize);
	}

	@Override
	public Bitmap getBitmap(String url) {
		return get(url);
	}

	@Override
	public void putBitmap(String url, Bitmap bitmap) {
		put(url, bitmap);
	}

	@Override
	protected int sizeOf(String key, Bitmap bitmap) {
		// The cache size will be measured in bytes rather than
		// number of items.
		return bitmap.getByteCount();
	}

}
