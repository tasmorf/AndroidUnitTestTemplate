package com.metis.android.backend.volleybackend.tests;

import android.test.ActivityInstrumentationTestCase2;

import com.google.android.apps.common.testing.ui.espresso.Espresso;
import com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions;
import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;
import com.metis.android.template.R;
import com.metis.android.template.controller.activity.MainActivity;

import org.hamcrest.Matchers;

public class EspressoTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public EspressoTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testEspressoClickingListViewPopulatesTextView() {

        Espresso.onView(ViewMatchers.withId(R.id.thumbnail))
                .check(ViewAssertions.matches(ViewMatchers.withText(Matchers.containsString("Hello"))));
    }
}