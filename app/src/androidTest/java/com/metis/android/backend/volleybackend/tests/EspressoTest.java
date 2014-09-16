package com.metis.android.backend.volleybackend.tests;

import android.test.ActivityInstrumentationTestCase2;

import com.google.android.apps.common.testing.ui.espresso.Espresso;
import com.google.android.apps.common.testing.ui.espresso.action.EspressoKey;
import com.google.android.apps.common.testing.ui.espresso.action.ViewActions;
import com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions;
import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;
import com.metis.android.template.R;
import com.metis.android.template.controller.activity.MainActivity;

public class EspressoTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public EspressoTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
        Espresso.registerIdlingResources(new VolleyIdlingResource ("VolleyCalls"));
    }

    public void testLoadsGodzilla() {
        Espresso.onView(ViewMatchers.withId(R.id.content_list))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .check(ViewAssertions.matches(ViewMatchers.hasDescendant(ViewMatchers.withText("Godzilla"))));
    }

    public void testClickingShowsSynopsis() {
        Espresso.onView(ViewMatchers.withText("Godzilla"))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.synopsis))
                .check(ViewAssertions.matches(ViewMatchers.withText("In Summer 2014, the world's most revered monster is reborn as Warner Bros. Pictures and Legendary Pictures unleash the epic action adventure \"Godzilla.\" From visionary new director Gareth Edwards (\"Monsters\") comes a powerful story of human courage and reconciliation in the face of titanic forces of nature, when the awe-inspiring Godzilla rises to restore balance as humanity stands defenseless. (c) Warner Bros")));

    }

}