package com.metis.android.template.module.view;

import com.metis.android.template.view.AndroidToaster;
import com.metis.android.template.view.Toaster;

import static com.metis.android.template.module.ApplicationModule.applicationContext;

public class ToasterModule {

    public static Toaster toaster() {
        return new AndroidToaster(applicationContext());
    }
}
