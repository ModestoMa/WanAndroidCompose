dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // Warning: this repository is going to shut down soon
    }
}
rootProject.name = "WanAndroidCompose"
include(":app")
include(":architecture")
include(":common")
include(":net")
