plugins {
  `kotlin-dsl`
}

dependencies {
  compileOnly(libs.android.gradle)
  compileOnly(libs.compose.gradle)
  compileOnly(libs.kotlin.gradle)
  compileOnly(libs.ksp.gradle)
}

gradlePlugin {
  plugins {
    register("swupdater.application") {
      id = "swupdater.application"
      implementationClass = "ApplicationConventionPlugin"
    }
    
    register("swupdater.library") {
      id = "swupdater.library"
      implementationClass = "LibraryConventionPlugin"
    }
    
    register("swupdater.compose") {
      id = "swupdater.compose"
      implementationClass = "ComposeConventionPlugin"
    }
  }
}