package star.sky.voyager.hook

import de.robv.android.xposed.IXposedHookZygoteInit
import de.robv.android.xposed.XSharedPreferences
import star.sky.voyager.BuildConfig.APPLICATION_ID
import star.sky.voyager.hook.apps.AiasstVision
import star.sky.voyager.hook.apps.Aireco
import star.sky.voyager.hook.apps.Android
import star.sky.voyager.hook.apps.Aod
import star.sky.voyager.hook.apps.Barrage
import star.sky.voyager.hook.apps.Browser
import star.sky.voyager.hook.apps.Cast
import star.sky.voyager.hook.apps.CloudService
import star.sky.voyager.hook.apps.Creation
import star.sky.voyager.hook.apps.ExternalStorage
import star.sky.voyager.hook.apps.FileExplorer
import star.sky.voyager.hook.apps.Gallery
import star.sky.voyager.hook.apps.GuardProvider
import star.sky.voyager.hook.apps.Home
import star.sky.voyager.hook.apps.Lbe
import star.sky.voyager.hook.apps.Market
import star.sky.voyager.hook.apps.MediaEditor
import star.sky.voyager.hook.apps.MiSettings
import star.sky.voyager.hook.apps.MiShare
import star.sky.voyager.hook.apps.Mirror
import star.sky.voyager.hook.apps.Music
import star.sky.voyager.hook.apps.Notes
import star.sky.voyager.hook.apps.PackageInstaller
import star.sky.voyager.hook.apps.PersonalAssistant
import star.sky.voyager.hook.apps.PowerKeeper
import star.sky.voyager.hook.apps.ProvidersDownloads
import star.sky.voyager.hook.apps.RearDisplay
import star.sky.voyager.hook.apps.Scanner
import star.sky.voyager.hook.apps.ScreenRecorder
import star.sky.voyager.hook.apps.ScreenShot
import star.sky.voyager.hook.apps.SecurityCenter
import star.sky.voyager.hook.apps.Settings
import star.sky.voyager.hook.apps.SystemUI
import star.sky.voyager.hook.apps.TaPlus
import star.sky.voyager.hook.apps.Updater
import star.sky.voyager.hook.apps.WallPaper
import star.sky.voyager.hook.apps.Weather
import star.sky.voyager.hook.hooks.corepatch.CorePatchMainHook
import star.sky.voyager.utils.init.AppRegister
import star.sky.voyager.utils.init.EasyXposedInit
import star.sky.voyager.utils.yife.XSharedPreferences.prefFileName

class MainHook : EasyXposedInit() {
    private var prefs = XSharedPreferences(APPLICATION_ID, prefFileName)

    override val registeredApp: Set<AppRegister> = setOf(
        AiasstVision, // 小爱翻译
        Aireco, // 小爱建议
        Android, // 系统框架
        Aod, // 万象息屏
        Barrage, // 弹幕通知
        Browser, // 浏览器
        Cast, // 投屏
        CloudService, // 小米云服务
        Creation, // 小米创作
        ExternalStorage, // 外部存储服务
        FileExplorer, // 文件管理
        Gallery, // 相册
        GuardProvider, // MIUI安全组件
        Home, // 系统桌面
        Lbe, // 权限管理服务
        Market, // 应用商店
        MediaEditor, // 小米相册-编辑
        Mirror, // Miui+ Beta
        MiSettings, // 小米设置
        MiShare, // 小米互传
        Music, // 音乐
        Notes, // 笔记
        PackageInstaller, // 应用包管理组件
        PersonalAssistant, // 智能助理
        PowerKeeper, // 电量与性能
        ProvidersDownloads, // 下载管理程序
        RearDisplay, // 背屏
        Scanner, // 小爱视觉
        ScreenRecorder, // 屏幕录制
        ScreenShot, // 截屏
        SecurityCenter, // 手机管家
        Settings, // 设置
        SystemUI, // 系统界面
        TaPlus, // 传送门
        Updater, // 系统更新
        WallPaper, // 壁纸
        Weather, // 天气
    )

    override fun initZygote(startupParam: IXposedHookZygoteInit.StartupParam?) {
        super.initZygote(startupParam)
        startupParam?.let {
            CorePatchMainHook().initZygote(it)
        }
    }
}