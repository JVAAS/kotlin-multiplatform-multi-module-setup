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

gradle.buildFinished {

	// make some adjustments to typescript headers which are currently not valid typescript.
	println("================================================================================")
	println("Adjusting TypeScript Headers")
	println("================================================================================")
	allprojects.forEach { subproject ->

		//println("==============================================================")
		val path = "$buildDir/js/packages/${project.name}-${subproject.name}/kotlin/${project.name}-${subproject.name}.d.ts"
		if (!File(path).exists()) {
			return@forEach
		}
		println(path)
		val newLines = mutableListOf<String>()
		if (File(path).exists()) {
			File(path).readLines().forEach { line ->
				if (line.startsWith("declare namespace") || line.startsWith("}")) {
					"// $line".let {
						newLines.add(it)
						//println(it)
					}
				} else if (line.trim().startsWith("namespace")) {
					line.replace("namespace", "export namespace").let {
						newLines.add(it)
						//println(it)
					}
				} else {
					line.let {
						newLines.add(it)
						//println(it)
					}
				}
			}
			File(path).writeText(newLines.joinToString("\n"))
		}
	}
	println("================================================================================")
}


