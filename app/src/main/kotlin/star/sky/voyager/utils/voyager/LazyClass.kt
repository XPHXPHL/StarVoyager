package star.sky.voyager.utils.voyager

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass

object LazyClass {
    val FeatureParserCls by lazy {
        loadClass("miui.util.FeatureParser")
    }

    val SystemProperties by lazy {
        loadClass("android.os.SystemProperties")
    }

    val AndroidBuildCls by lazy {
        loadClass("android.os.Build")
    }

    val MiuiBuildCls by lazy {
        loadClass("miui.os.Build")
    }

    val SettingsFeaturesCls by lazy {
        loadClass("com.android.settings.utils.SettingsFeatures")
    }

    val AiasstVisionSystemUtilsCls by lazy {
        loadClass("com.xiaomi.aiasst.vision.utils.SystemUtils")
    }
}