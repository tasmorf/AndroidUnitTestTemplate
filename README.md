AndroidUnitTestTemplate
=======================

Contains a basic android project with all that you would need if you need to develop on Android Studio and be able to run both Instrumentation and actual unit tests both on your IDE and the command line.
Uses the following:
- The [Volley](https://android.googlesource.com/platform/frameworks/volley/) library as a second module. Most people eventually change it, so it's worth having it like that in order to demonstrate how ot add a second module as well.
- [Jackson](http://wiki.fasterxml.com/JacksonHome) (to demonstrate how to add regular java libraries that exist in maven central)
- Some android support libraries (v4, v13 and mediarouter-v7)
- [Espresso](https://code.google.com/p/android-test-kit/wiki/Espresso) for instrumentation tests (that run on a device) along with the GoogleInstrumentationTestRunner
- [Robolectric](http://robolectric.org/), along with [Mockito](https://code.google.com/p/mockito/) and [Fest](http://www.vogella.com/tutorials/FEST/article.html) for unit tests
- The project also uses the [android-unit-test](https://github.com/JCAndKSolutions/android-unit-test) plugin for gradle (works great with the [android-studio-unit-test-plugin](https://github.com/evant/android-studio-unit-test-plugin) in order to run your  unit tests on the IDE)
- A basic lint and proguard configuration has been added