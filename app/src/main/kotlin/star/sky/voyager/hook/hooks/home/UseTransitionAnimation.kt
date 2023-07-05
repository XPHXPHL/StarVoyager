package star.sky.voyager.hook.hooks.home

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import star.sky.voyager.utils.init.HookRegister
import star.sky.voyager.utils.key.hasEnable

object UseTransitionAnimation : HookRegister() {
    override fun init() = hasEnable("Use_Transition_Animation") {
        setOf(
            loadClass("com.miui.home.launcher.LauncherWidgetView"),
            loadClass("com.miui.home.launcher.maml.MaMlWidgetView")
        ).forEach { clazz ->
            clazz.methodFinder()
                .filterByName("isUseTransitionAnimation")
                .first().createHook {
                    returnConstant(true)
                }
        }
    }
}