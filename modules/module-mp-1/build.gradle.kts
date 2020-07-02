import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.4-M2"
}
group = "com.generic.modules"
version = "1.0.0"

repositories {
	mavenCentral()
	jcenter()
	maven {
		url = uri("https://dl.bintray.com/kotlin/kotlin-eap")
	}
}
dependencies {
	testImplementation(kotlin("test-junit5"))
	implementation(kotlin("stdlib-jdk8"))

	// ktor
	val ktorVersion = "1.3.1"
	//implementation("io.ktor:ktor-server-netty:$ktorVersion")
	implementation("io.ktor:ktor-server-cio:$ktorVersion")
	implementation("io.ktor:ktor-html-builder:$ktorVersion")
	implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.1")

	// logging
	val slf4jVersion = "1.7.25"
	val logbackVersion = "1.2.3"
	implementation("org.slf4j:slf4j-api:$slf4jVersion")
	implementation("org.slf4j:jcl-over-slf4j:$slf4jVersion")
	implementation("org.slf4j:jul-to-slf4j:$slf4jVersion")
	implementation("org.slf4j:log4j-over-slf4j:$slf4jVersion")
	implementation("ch.qos.logback:logback-classic:$logbackVersion")

	api(project(":integrations:integration-jvm-1"))

}
tasks.withType<KotlinCompile>() {
	kotlinOptions.jvmTarget = "11"
}
