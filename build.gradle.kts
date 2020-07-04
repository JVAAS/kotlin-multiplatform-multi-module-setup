allprojects {

	version = "1.0.0"


}


project("modules:module-mp-1") {
	dependencies {
		//"implementation"(":integrations:integration-jvm-1")
	}
}

project("applications:application-jvm-1") {
	dependencies {
		//"implementation"(":modules:module-mp-1")
	}
}

