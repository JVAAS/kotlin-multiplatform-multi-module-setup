package com.generic.integrations

import kotlin.test.assertEquals


class IntegrationJvmTest {

	fun test() {
		val output = IntegrationJvm().toString()
		assertEquals("IntegrationJvm::toString", output.toString())
	}



}