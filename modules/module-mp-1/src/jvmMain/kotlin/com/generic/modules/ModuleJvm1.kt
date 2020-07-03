
import com.generic.integrations.*
import com.generic.modules.ModuleCommon1
import kotlin.js.ExperimentalJsExport


class ModuleJvm1 {

	@ExperimentalJsExport
	override fun toString(): String {
		return ModuleCommon1().toString() + "::ModuleJvm1" + "::" + IntegrationJvm().toString()
	}


}