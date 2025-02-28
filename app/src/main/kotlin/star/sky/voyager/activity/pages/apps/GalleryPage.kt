package star.sky.voyager.activity.pages.apps

import android.view.View
import cn.fkj233.ui.activity.MIUIActivity.Companion.safeSP
import cn.fkj233.ui.activity.annotation.BMPage
import cn.fkj233.ui.activity.data.BasePage
import cn.fkj233.ui.activity.view.SwitchV
import cn.fkj233.ui.activity.view.TextSummaryV
import cn.fkj233.ui.dialog.MIUIDialog
import star.sky.voyager.R

@BMPage("scope_gallery", "Gallery", hideMenu = false)

class GalleryPage : BasePage() {
    override fun onCreate() {
        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.super_clipboard,
                onClickListener = { showFragment("super_clipboard") }
            )
        )
        TitleText(textId = R.string.scope_gallery)
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.album_optimize,
                tipsId = R.string.album_optimize_summary
            ), SwitchV("album_optimize", false)
        )
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.open_video_self,
                tipsId = R.string.open_video_self_summary,
            ), SwitchV("open_video_self", false)
        )
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.hdr_enhance,
                tipsId = R.string.hdr_enhance_summary
            ), SwitchV("hdr_enhance", false)
        )
        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.unlock,
                onClickListener = { showFragment("gallery_unlock") }
            )
        )
        Line()
        TitleText(textId = R.string.scope_media_editor)
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.filter_manager,
            ), SwitchV("filter_manager")
        )
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.unlock_unlimited_cropping,
                tipsId = R.string.unlock_unlimited_cropping_summary
            ), SwitchV("unlock_unlimited_cropping")
        )
        Line()
        TitleText(textId = R.string.scope_screen_recorder)
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.force_enable_native_playback_capture
            ),
            SwitchV("force_enable_native_playback_capture", false)
        )
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.change_bitrate_and_frame_rate_range
            ),
            SwitchV("modify_screen_recorder_config", false)
        )
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.save_to_movies
            ),
            SwitchV("save_to_movies", false)
        )
        Line()
        TitleText(textId = R.string.scope_screen_shot)
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.save_to_pictures
            ),
            SwitchV("save_to_pictures", false)
        )
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.save_as_png
            ),
            SwitchV("save_as_png", false)
        )
        val deviceBinding = GetDataBinding({
            safeSP.getBoolean(
                "device_shell",
                false
            )
        }) { view, flags, data ->
            if (flags == 1) view.visibility = if (data as Boolean) View.VISIBLE else View.GONE
        }
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.device_shell,
            ),
            SwitchV(
                "device_shell",
                false,
                dataBindingSend = deviceBinding.bindingSend
            ),
        )
        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.Market_As,
                onClickListener = {
                    MIUIDialog(activity) {
                        setTitle(R.string.Market_As)
                        setMessage(
                            "${activity.getString(R.string.def)}ishtar\n${
                                activity.getString(
                                    R.string.current
                                )
                            }${
                                safeSP.getString(
                                    "device_shell_s",
                                    "ishtar"
                                )
                            }"
                        )
                        setEditText(
                            "",
                            "${activity.getString(R.string.current)}${
                                safeSP.getString(
                                    "device_shell_s",
                                    "ishtar"
                                )
                            }"
                        )
                        setLButton(textId = R.string.cancel) {
                            dismiss()
                        }
                        setRButton(textId = R.string.done) {
                            if (getEditText() != "") {
                                safeSP.putAny(
                                    "device_shell_s",
                                    getEditText()
                                )
                            }
                            dismiss()
                        }
                    }.show()
                }), dataBindingRecv = deviceBinding.binding.getRecv(1)
        )
    }
}