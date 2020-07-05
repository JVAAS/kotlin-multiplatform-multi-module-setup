import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackOutput.Target.UMD

plugins {
	val kotlinVersion = "1.4-M2"
	application
	kotlin("multiplatform") version kotlinVersion
	kotlin("plugin.serialization") version kotlinVersion
}

group = "com.generic.applications"

repositories {
	// add extra repositories in here that's not in root
}

kotlin {

	jvm {
		compilations.all {
			kotlinOptions.jvmTarget = "11"
		}
	}

	sourceSets {

		val serializationVersion = "0.20.0-1.4-M2"
		val coroutinesVersion = "1.3.7-1.4-M2"

		val jvmMain by getting {

			dependencies {
				implementation(kotlin("stdlib-jdk8"))
				implementation(kotlin("reflect"))

				// logging
				val slf4jVersion = "1.7.25"
				val logbackVersion = "1.2.3"
				implementation("org.slf4j:slf4j-api:$slf4jVersion")
				implementation("org.slf4j:jcl-over-slf4j:$slf4jVersion")
				implementation("org.slf4j:jul-to-slf4j:$slf4jVersion")
				implementation("org.slf4j:log4j-over-slf4j:$slf4jVersion")
				implementation("ch.qos.logback:logback-classic:$logbackVersion")

				api(project(":modules:module-mp-1"))

			}
		}
		val jvmTest by getting {
			dependencies {
				implementation(kotlin("test-junit"))
			}
		}
		all {
			languageSettings.enableLanguageFeature("InlineClasses")
		}
	}

}

application {
	mainClassName = "Application"
}
