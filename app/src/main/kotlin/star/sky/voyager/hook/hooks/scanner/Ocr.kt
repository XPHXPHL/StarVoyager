package star.sky.voyager.hook.hooks.scanner

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import star.sky.voyager.utils.init.HookRegister
import star.sky.voyager.utils.key.hasEnable

object Ocr : HookRegister() {
    override fun init() = hasEnable("ocr2") {
        loadClass("com.xiaomi.scanner.settings.FeatureManager").methodFinder()
            .filterByName("isAddTextExtractionFunction")
            .first().createHook {
                before {
                    it.result = true
                }
            }
    }
}