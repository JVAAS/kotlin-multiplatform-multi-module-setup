package com.generic.modules

import kotlin.js.ExperimentalJsExport
import kotlin.test.Test
import kotlin.test.assertEquals

class ModuleCommon1Test  {

	@ExperimentalJsExport
	@Test
	fun genericTest() {

		assertEquals(true, true)
		// TODO: assert this
		println( ModuleCommon1())

	}


}