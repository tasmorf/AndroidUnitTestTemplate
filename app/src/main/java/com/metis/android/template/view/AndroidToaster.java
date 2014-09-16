package com.metis.android.template.view;

import android.content.Context;
import android.widget.Toast;

/**
 * Shows toasts using the regular {@link android.widget.Toast}
 */
public class AndroidToaster implements Toaster {
    private Context context;

    public AndroidToaster(Context context) {
        this.context = context;
    }

    @Override
    public void showToast(String toastMessage) {
        Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
    }
}
