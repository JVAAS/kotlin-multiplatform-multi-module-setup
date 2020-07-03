import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackOutput.Target.UMD

plugins {
	val kotlinVersion = "1.4-M2"
	kotlin("jvm") version "1.4-M2"
	kotlin("multiplatform") version kotlinVersion
}
group = "com.generic.modules"
version = "1.0.0"

repositories {
	jcenter()
	mavenCentral()
	maven {
		url = uri("https://dl.bintray.com/kotlin/kotlin-eap")
	}
	maven {
		url = uri("https://kotlin.bintray.com/kotlinx")
	}
	gradlePluginPortal()
}

kotlin {

	jvm {
		compilations.all {
			kotlinOptions.jvmTarget = "11"
		}
	}
	js(IR) {
		browser {
			binaries.executable()
			webpackTask {
				output.libraryTarget = UMD
				//output.libraryTarget = COMMONJS
				//output.libraryTarget = AMD
			}
		}
	}

	sourceSets {

		val serializationVersion = "0.20.0-1.4-M2"
		val coroutinesVersion = "1.3.7-1.4-M2"
		val klockVersion = "1.11.12"

		val commonMain by getting {
			dependencies {
				implementation(kotlin("stdlib-common"))
				implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:$serializationVersion")
			}
		}
		val commonTest by getting {
			dependencies {
				implementation(kotlin("test-common"))
				implementation(kotlin("test-annotations-common"))
			}
		}
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

				// integration
				api(project(":integrations:integration-jvm-1"))

			}
		}
		val jvmTest by getting {
			dependencies {
				implementation(kotlin("test-junit"))
			}
		}
		val jsMain by getting {
			dependencies {
				implementation(kotlin("stdlib-js"))
			}
		}
		val jsTest by getting {
			dependencies {
				implementation(kotlin("test-js"))
			}
		}
		all {
			languageSettings.enableLanguageFeature("InlineClasses")
		}
	}

}

//tasks.withType<KotlinCompile>() {
//	kotlinOptions.jvmTarget = "11"
//	kotlinOptions.js.
//}
