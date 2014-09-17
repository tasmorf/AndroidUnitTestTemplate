package com.metis.android.template.module.model;

import com.metis.android.template.model.ResourcesUrlProvider;
import com.metis.android.template.model.UrlProvider;

import static com.metis.android.template.module.ResourcesModule.resources;

public class UrlProviderModule {

    public static UrlProvider urlProvider() {
        return new ResourcesUrlProvider(resources());
    }
}
