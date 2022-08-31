package com.geancarloleiva.jetcompnoteapp_12

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp //Creates the dependency container at app's the top level
class NoteApplication: Application() {

    /*
    * Hilt configuration
    * 1. Add gradle project dependency, gradle module plugins and dependencies
    * 2. Create Application class and use @HiltAndroidApp on it
    * 3. Update AndroidManifest and add android:name=".thisClassName"
    * 4. Update MainActivity class adding @AndroidEntryPoint
    * 5. Create "di" package to contain AppModule object class
    * */
}