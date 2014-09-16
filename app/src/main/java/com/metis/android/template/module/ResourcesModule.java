package com.metis.android.template.module;

import android.content.res.Resources;

import static com.metis.android.template.module.ApplicationModule.applicationContext;

public class ResourcesModule {
    public static Resources resources() {
        return applicationContext().getResources();
    }
}
