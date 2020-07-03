package com.generic.modules

import com.generic.integrations.IntegrationJvm

class Module1 {

	override fun toString(): String {
		return IntegrationJvm().toString() + "::Module1"
	}

}