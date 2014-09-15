AndroidUnitTestTemplate
=======================

Contains a basic android project with all that you would need if you need to develop on Android Studio and be able to run both Instrumentation and actual unit tests both on your IDE and the command line.
Uses the following:
- The volley library (to demonstrate how to add a second module to your project)
- Jackson (to demonstrate how to add regular java libraries that exist in maven central)
- Some android support libraries (v4, v13 and mediarouter-v7)
- Espresso for instrumentation tests (that run on a device) along with the GoogleInstrumentationTestRunner
- Robolectric, along with Mockito and Fest for unit tests
- The project also uses the android-unit-test plugin for eclipse (works great with the android-studio-unit-test-plugin in order to run your  unit tests on the IDE)
- A basic lint and proguard configuration has been added