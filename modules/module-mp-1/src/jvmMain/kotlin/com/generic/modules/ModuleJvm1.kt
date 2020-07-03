
import com.generic.integrations.*


class ModuleJvm1 {

	override fun toString(): String {
		return ModuleCommon1Test().toString() + "::ModuleJvm1" + "::" + IntegrationJvm().toString()
	}


}