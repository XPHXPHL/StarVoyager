package star.sky.voyager.hook.hooks.systemui

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.ClassUtils.setStaticObject
import star.sky.voyager.utils.init.HookRegister
import star.sky.voyager.utils.key.hasEnable
import star.sky.voyager.utils.yife.Build.IS_INTERNATIONAL_BUILD

object NotificationSettingsNoWhiteList : HookRegister() {
    override fun init() = hasEnable("notification_settings_no_white_list") {
        if (!IS_INTERNATIONAL_BUILD) return@hasEnable
        setStaticObject(
            loadClass("com.android.systemui.statusbar.notification.NotificationSettingsManager"),
            "USE_WHITE_LISTS",
            false
        )
    }
}