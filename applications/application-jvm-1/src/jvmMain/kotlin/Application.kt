package com.generic.applications

import ModuleJvm1
import com.generic.modules.ModuleCommon1
import kotlin.js.ExperimentalJsExport

object Application {

	@JvmStatic
	@ExperimentalJsExport
	fun main(args: Array<String>) {

		println(
			listOf(
				"Application",
				ModuleJvm1(),
				ModuleCommon1()
			).joinToString(separator = "::") { it.toString() }
		)

	}


}