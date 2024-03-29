pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven ( url= "https://maven.neshan.org/artifactory/public-maven" )
    }
}

rootProject.name = "uber.customer"
include(":app")
 