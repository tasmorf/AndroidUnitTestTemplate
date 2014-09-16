package com.metis.android.template.controller.fragment;

import android.app.Activity;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.metis.android.template.fake.FakeLayoutInflater;
import com.metis.android.template.fake.FakeRequestFactory;
import com.metis.android.template.model.bean.client.Movie;
import com.metis.android.template.model.request.RequestFactory;
import com.metis.android.template.stub.StubRequest;
import com.metis.android.template.view.indicator.MovieListIndicator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.util.ActivityController;
import org.robolectric.util.FragmentTestUtil;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
public class MovieListFragmentTest {

    //We need a context
    private Activity act = ActivityController.of(Activity.class).attach().get();

    //Stub
    private View stubView = new View(act);
    private VolleyError stubError = new VolleyError();
    private Request<List<Movie>> stubMovieListRequest = new StubRequest<List<Movie>>();
    private List<Movie> stubResponse = new ArrayList<Movie>();

    //Fake
    private RequestFactory<List<Movie>> fakeRequestFactory = new FakeRequestFactory<List<Movie>>(stubMovieListRequest);
    private FakeLayoutInflater fakeInflater = new FakeLayoutInflater(stubView);

    //Mocks
    @Mock
    private RequestQueue mockRequestQueue;
    @Mock
    private MovieListIndicator mockIndicator;

    private MovieListFragment sut;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        sut = new MovieListFragment(mockRequestQueue, fakeRequestFactory, mockIndicator);
        sut.onAttach(act);
    }

    @Test
    public void onCreateViewInitializesIndicator() {
        //when
        sut.onCreateView(fakeInflater, null, null);
        //then
        verify(mockIndicator).initialize(stubView, sut);
    }

    @Test
    public void onCreateViewDoesRequest() {
        //when
        sut.onCreateView(fakeInflater, null, null);
        //then
        verify(mockRequestQueue).add(stubMovieListRequest);
    }

    @Test
    public void onErrorResponseUsesIndicator() {
        //when
        sut.onErrorResponse(stubError);
        //then
        verify(mockIndicator).showError();
    }

    @Test
    public void onResponseUsesIndicator() {
        //when
        sut.onResponse(stubResponse);
        //then
        verify(mockIndicator).showData(stubResponse);
    }

    @Test
    public void testOnMovieClicked() throws Exception {

    }
}