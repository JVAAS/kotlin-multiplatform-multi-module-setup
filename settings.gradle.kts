rootProject.name = "generic-project"

include("applications:application-jvm-1")
include("modules:module-mp-1")
include("integrations:integration-jvm-1")

pluginManagement {
	repositories {
		mavenCentral()
		gradlePluginPortal()
		maven {
			url = uri("https://dl.bintray.com/kotlin/kotlin-eap")
		}
	}
}

