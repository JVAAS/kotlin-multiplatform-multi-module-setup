allprojects {

	version = "1.0.0"
	val serializationVersion = "0.20.0-1.4-M2"

	repositories {
		jcenter()
		mavenCentral()
		maven {
			url = uri("https://dl.bintray.com/kotlin/kotlin-eap")
		}
		maven {
			url = uri("https://kotlin.bintray.com/kotlinx")
		}
	}
}

project("modules:module-mp-1") {
	dependencies {

	}
}


