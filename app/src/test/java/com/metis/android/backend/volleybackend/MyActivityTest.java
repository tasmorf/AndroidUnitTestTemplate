package com.metis.android.backend.volleybackend;

import android.view.View;

import junit.framework.Assert;

import org.fest.assertions.api.ANDROID;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.ConsoleMockitoLogger;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.util.ActivityController;

@RunWith(RobolectricTestRunner.class)
public class MyActivityTest {

    @Mock
    private View.OnClickListener bla;
    private MyActivity activity;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        activity = new MyActivity();
        ActivityController.of(activity).create();
    }

    @Test
    public void failingTest() {
        MatcherAssert.assertThat("bla", Matchers.equalTo("bla2"));

    }

    @Test
    public void succeedingTest() {
        MatcherAssert.assertThat("bla", Matchers.equalTo("bla"));
    }

    @Test
    public void succeedingTest2() {
        Mockito.verifyZeroInteractions(bla);
    }

    @Test
    public void failingTest2() {
        Mockito.verify(bla).onClick(new View(activity));
    }

    @Test
    public void succeedingTest3() {
        View v = new View(activity);
        ANDROID.assertThat(v).isVisible();
    }

}
