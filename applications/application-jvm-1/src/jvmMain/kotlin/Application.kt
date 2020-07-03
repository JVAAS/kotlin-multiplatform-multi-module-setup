package com.generic.applications

import ModuleJvm1

object Application {

	@JvmStatic
	fun main(args: Array<String>) {

		println("TEST")

		println(ModuleJvm1().toString())

	}


}