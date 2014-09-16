package com.metis.android.template;

import android.app.Application;

import com.metis.android.template.module.ApplicationModule;

public class TemplateApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationModule.setApplication(this);
    }
}
