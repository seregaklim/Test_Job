buildscript {
    dependencies {
        classpath("com.google.gms:google-services:4.3.8")

    }
}

plugins { id ("com.android.application") version "8.1.0" apply false
    id ("com.android.library") version "8.1.0" apply false
    id ("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id ("com.google.devtools.ksp") version "1.9.0-1.0.13" apply false
}