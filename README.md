# AndroidUnitTestTemplate

Contains a basic android project with all that you would need if you need to develop on Android Studio and be able to run both Instrumentation and actual unit tests both on your IDE and the command line.
Uses the following:
- The [Volley](https://android.googlesource.com/platform/frameworks/volley/) library as a second module. Most peopleeventually change it, so it's worth having it like that in order to demonstrate how to add a second module as well.
- [Jackson](http://wiki.fasterxml.com/JacksonHome) (to demonstrate how to add regular java libraries that exist in maven central)
- Some android support libraries (v4, v13 and mediarouter-v7)
- [Espresso](https://code.google.com/p/android-test-kit/wiki/Espresso) for instrumentation tests (that run on a 
device) along with the GoogleInstrumentationTestRunner
- [MockWebServer](https://code.google.com/p/mockwebserver/) in order to fake responses from the server
- [espresso-volley-tests](https://github.com/bolhoso/espresso-volley-tests) was used in order to synchronize espresso
 and the volley request queue
- [Robolectric](http://robolectric.org/), along with [Mockito](https://code.google.com/p/mockito/) and [Fest](http://www.vogella.com/tutorials/FEST/article.html) for unit tests
- The project also uses the [android-unit-test](https://github.com/JCAndKSolutions/android-unit-test) plugin for 
gradle (works great with the [gradle-android-add-dir](https://github.com/sababado/gradle-android-add-dir) script in 
order to run your  unit tests on the IDE)
- A basic lint and proguard configuration has been added

## The Main Project

The code for the main project exists under src/main.The app connects to the [Rotten Tomatoes API](http://developer.rottentomatoes.com/) 
in order to get a list of movies, which are displayed along with their images on a listview. When the user clicks on a movie, a popup appears, 
 containing the movie title and synopsis.
 
## Unit Tests
 
They exist under the src/test folder. Two unit tests have been created for demonstration purposes. One is a pure java unit test 
(MoviesConverterTest) and the other is a Robolectric test (MovieListFragmentTest).
 
## Instrumentation Tests
  
These exist under the src/androidTestFakeResponse folder.  A separate flavor was created for fake responses. The 
idea is that this flavor can be used for actually running the app as well (when the real server is down for 
example). Either way, in that flavor all urls point to localhost, so all you'd need to do is run the mockserver 
and prepare the responses. That way instrumentation tests are more stable. If you want to add tests with the real 
server, simply put them under src/androidProd. There is a single class (EspressoTest) with two tests. One 
that checks if the movies are loaded correctly, and another one that checks if the app behaves correctly when clicking on an item. 