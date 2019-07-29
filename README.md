# Android Q Save File to External Storage crash

The purpose of this branch is to show a demo of a Android Q related crash in terms of external storage

The problem is lays on the following pre-requisit:
* User is on Android Q beta 5 device
* A clean build & assemble for the apk been installed & tested - `./gradlew clean assembleDebug`


## Issue
App is crashing due to a non-recognized file directory path:

```
Caused by: java.io.IOException: No such file or directory
         at java.io.UnixFileSystem.createFileExclusively0(Native Method)
         at java.io.UnixFileSystem.createFileExclusively(UnixFileSystem.java:317)
         at java.io.File.createNewFile(File.java:1008)
         at com.erikzuo.androidplayground.MainActivity.saveFile(MainActivity.kt:55)
         at com.erikzuo.androidplayground.MainActivity.onRequestPermissionsResult(MainActivity.kt:39)
```

And this is potentially caused by `.mkdirs()` fails at the first place.

### NOTE: This does not happen in devices on Android Pie or lower OS versions