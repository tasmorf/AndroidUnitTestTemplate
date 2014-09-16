package com.metis.android.template.controller.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.metis.android.template.R;

/**
 * An activity with a dialog theme, that will simply display the title and the synopsis for a movie
 */
public class SynopsisDialogActivity extends Activity {


    private static final String PARAM_TITLE = "title";
    private static final String PARAM_SYNOPSIS = "synopsis";

    public static Intent getSynopsisDialogIntent(Context context, String title, String synopsis) {
        Intent intent = new Intent(context, SynopsisDialogActivity.class);
        intent.putExtra(PARAM_TITLE, title);
        intent.putExtra(PARAM_SYNOPSIS, synopsis);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synopsis_dialog);
        ((TextView)findViewById(R.id.title)).setText(getIntent().getStringExtra(PARAM_TITLE));
        ((TextView)findViewById(R.id.synopsis)).setText(getIntent().getStringExtra(PARAM_SYNOPSIS));
    }
}
