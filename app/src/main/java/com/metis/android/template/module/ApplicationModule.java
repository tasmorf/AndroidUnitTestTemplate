package com.metis.android.template.module;

import android.content.Context;

import com.metis.android.template.TemplateApplication;

public class ApplicationModule {

    private static TemplateApplication templateApplication;

    public static void setApplication(TemplateApplication templateApplication) {
        ApplicationModule.templateApplication = templateApplication;
    }

    public static Context applicationContext() {
        return templateApplication;
    }
}
