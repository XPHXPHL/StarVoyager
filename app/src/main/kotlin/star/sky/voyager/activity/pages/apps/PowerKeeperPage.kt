package star.sky.voyager.activity.pages.apps

import android.content.ComponentName
import android.content.Intent
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.makeText
import cn.fkj233.ui.activity.annotation.BMPage
import cn.fkj233.ui.activity.data.BasePage
import cn.fkj233.ui.activity.view.SwitchV
import cn.fkj233.ui.activity.view.TextSummaryV
import star.sky.voyager.R
import star.sky.voyager.utils.yife.Terminal.exec

@BMPage("scope_power_keeper", "PowerKeeper", hideMenu = false)
class PowerKeeperPage : BasePage() {
    override fun onCreate() {
        TitleText(textId = R.string.scope_power_keeper)
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.custom_refresh_rate,
            ), SwitchV("custom_refresh_rate")
        )
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.do_not_clear_app,
            ), SwitchV("do_not_clear_app")
        )
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.prevent_recovery_of_battery_optimization_white_list,
                tipsId = R.string.failed_after_restart
            ), SwitchV("prevent_recovery_of_battery_optimization_white_list")
        )
        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.battery_optimization,
                tipsId = R.string.battery_optimization_summary,
                onClickListener = {
                    try {
                        val intent = Intent()
                        val comp = ComponentName(
                            "com.android.settings",
                            "com.android.settings.Settings\$HighPowerApplicationsActivity"
                        )
                        intent.component = comp
                        activity.startActivity(intent)
                    } catch (e: Exception) {
                        makeText(activity, "启动失败，可能是不支持", LENGTH_LONG).show()
                    }
                })
        )
        Line()
        TitleText(textId = R.string.scope_settings)
        TitleText(textId = R.string.scope_mi_settings)
        Page(
            activity.getDrawable(R.drawable.ic_settings)!!,
            TextSummaryV(
                textId = R.string.scope_settings,
            ), round = 8f,
            onClickListener = { showFragment("scope_settings") }
        )
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.dc_fps,
                tipsId = R.string.dc_fps_summary
            ), SwitchV("dc_fps")
        )
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.dc_backlight,
            ), SwitchV("dc_backlight")
        )
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.show_all_fps,
                tipsId = R.string.show_all_fps_summary
            ), SwitchV("show_all_fps")
        )
        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.exported,
                tipsId = R.string.exported_summary,
                onClickListener = {
                    try {
                        val intent = Intent()
                        val comp = ComponentName(
                            "com.android.settings",
                            "com.android.settings.Settings\$ReduceBrightColorsSettingsActivity"
                        )
                        intent.component = comp
                        activity.startActivity(intent)
                    } catch (e: Exception) {
                        makeText(activity, "启动失败，可能是不支持", LENGTH_LONG).show()
                    }
                })
        )
        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.original_notification,
                onClickListener = {
                    try {
                        val intent = Intent()
                        val comp = ComponentName(
                            "com.android.settings",
                            "com.android.settings.Settings\$ConfigureNotificationSettingsActivity"
                        )
                        intent.component = comp
                        activity.startActivity(intent)
                    } catch (e: Exception) {
                        makeText(activity, "启动失败，可能是不支持", LENGTH_LONG).show()
                    }
                })
        )
        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.original_manage_applications,
                onClickListener = {
                    try {
                        val intent = Intent()
                        val comp = ComponentName(
                            "com.android.settings",
                            "com.android.settings.applications.ManageApplications"
                        )
                        intent.component = comp
                        activity.startActivity(intent)
                    } catch (e: Exception) {
                        makeText(activity, "启动失败，可能是不支持", LENGTH_LONG).show()
                    }
                })
        )
        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.original_language_settings,
                onClickListener = {
                    try {
                        val intent = Intent()
                        val comp = ComponentName(
                            "com.android.settings",
                            "com.android.settings.LanguageSettings"
                        )
                        intent.component = comp
                        activity.startActivity(intent)
                    } catch (e: Exception) {
                        makeText(activity, "启动失败，可能是不支持", LENGTH_LONG).show()
                    }
                })
        )
        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.desktop_mode,
                onClickListener = {
                    try {
                        val intent = Intent()
                        val comp = ComponentName(
                            "com.miui.freeform",
                            "com.miui.freeform.guide.MiuiDesktopModeGuideActivity"
                        )
                        intent.component = comp
                        activity.startActivity(intent)
                    } catch (e: Exception) {
                        makeText(activity, "启动失败，可能是不支持", LENGTH_LONG).show()
                    }
                })
        )
        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.original_privacy_dashboard,
                onClickListener = {
                    try {
                        val intent = Intent()
                        val comp = ComponentName(
                            "com.android.settings",
                            "com.android.settings.Settings\$PrivacyDashboardActivity"
                        )
                        intent.component = comp
                        activity.startActivity(intent)
                    } catch (e: Exception) {
                        makeText(activity, "启动失败，可能是不支持", LENGTH_LONG).show()
                    }
                })
        )
        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.privacy_dashboard_7_day,
            ) {
                val command = "device_config put privacy privacy_dashboard_7_day_toggle true"
                exec(command)
                makeText(
                    activity,
                    getString(R.string.finished),
                    Toast.LENGTH_SHORT
                ).show()
            }
        )
    }
}