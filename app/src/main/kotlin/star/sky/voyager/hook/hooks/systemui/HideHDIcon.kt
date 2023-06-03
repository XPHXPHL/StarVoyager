package star.sky.voyager.hook.hooks.systemui

import android.view.View
import android.widget.ImageView
import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import de.robv.android.xposed.XC_MethodHook
import star.sky.voyager.utils.api.getObjectFieldAs
import star.sky.voyager.utils.init.HookRegister
import star.sky.voyager.utils.key.hasEnable

object HideHDIcon : HookRegister() {
    override fun init() {
        loadClass("com.android.systemui.statusbar.StatusBarMobileView").methodFinder()
            .filterByName("initViewState")
            .filterByParamCount(1)
            .first().createHook {
                after {
                    hide(it)
                }
            }

        loadClass("com.android.systemui.statusbar.StatusBarMobileView").methodFinder()
            .filterByName("updateState")
            .filterByParamCount(1)
            .first().createHook {
                after {
                    hide(it)
                }
            }

        hasEnable("hide_new_hd_icon") {
            loadClass("com.android.systemui.statusbar.policy.HDController").methodFinder()
                .filterByName("update")
                .first().createHook {
                    before {
                        it.result = null
                    }
                }
        }
    }

    private fun hide(it: XC_MethodHook.MethodHookParam) {
        hasEnable("hide_big_hd_icon") {
            (it.thisObject.getObjectFieldAs<ImageView>("mVolte")).visibility = View.GONE
        }
        hasEnable("hide_small_hd_icon") {
            (it.thisObject.getObjectFieldAs<ImageView>("mSmallHd")).visibility = View.GONE
        }
        hasEnable("hide_hd_no_service_icon") {
            (it.thisObject.getObjectFieldAs<ImageView>("mVolteNoService")).visibility = View.GONE
        }
    }
}