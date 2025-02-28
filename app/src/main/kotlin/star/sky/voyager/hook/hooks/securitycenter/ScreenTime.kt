package star.sky.voyager.hook.hooks.securitycenter

import com.github.kyuubiran.ezxhelper.EzXHelper.classLoader
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import io.luckypray.dexkit.enums.MatchType
import star.sky.voyager.utils.init.HookRegister
import star.sky.voyager.utils.key.hasEnable
import star.sky.voyager.utils.yife.DexKit.safeDexKitBridge

object ScreenTime : HookRegister() {
    override fun init() = hasEnable("screen_time") {
        val classesName = safeDexKitBridge.batchFindClassesUsingStrings {
            addQuery("qwq1", setOf("not support screenPowerSplit", "PowerRankHelperHolder"))
            matchType = MatchType.FULL
        }.values
            .flatten()
            .map { it.getClassInstance(classLoader).name }
            .firstOrNull()

        val methods1 = safeDexKitBridge.batchFindMethodsUsingStrings {
            addQuery("qwq2", setOf("ishtar", "nuwa", "fuxi"))
            matchType = MatchType.FULL
        }.values
            .flatten()
            .map { it.getMethodInstance(classLoader) }
            .firstOrNull()

        safeDexKitBridge.findMethod {
            methodDeclareClass = classesName!!
            methodReturnType = "boolean"
            methodParamTypes = arrayOf()
        }.forEach { methods ->
            val methods2 = methods.getMethodInstance(classLoader)
            methods2.createHook {
                returnConstant(
                    when (methods2) {
                        methods1 -> true
                        else -> false
                    }
                )
            }
        }
    }
}