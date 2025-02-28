package star.sky.voyager.hook.hooks.securitycenter

import com.github.kyuubiran.ezxhelper.EzXHelper.classLoader
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import star.sky.voyager.utils.init.HookRegister
import star.sky.voyager.utils.key.hasEnable
import star.sky.voyager.utils.yife.DexKit.safeDexKitBridge

object SuperResolution : HookRegister() {
    override fun init() = hasEnable("super_resolution") {
        safeDexKitBridge.batchFindClassesUsingStrings {
            addQuery("qwq", setOf("ro.vendor.media.video.frc.support"))
        }.forEach { (_, classes) ->
            classes.map {
                val qaq = it.getClassInstance(classLoader)
                var counter = 0
                safeDexKitBridge.findMethod {
                    methodDeclareClass = qaq.name
                    methodReturnType = "boolean"
                    methodParamTypes = arrayOf("java.lang.String")
                }.forEach { methods ->
                    counter++
                    if (counter == 1) {
                        methods.getMethodInstance(classLoader).createHook {
                            returnConstant(true)
                        }
                    }
                }
                safeDexKitBridge.findMethodUsingString {
                    methodDeclareClass = qaq.name
                    usingString = "debug.config.media.video.ais.support"
                }.single().getMethodInstance(classLoader).createHook {
                    returnConstant(true)
                }
            }
        }
    }
}