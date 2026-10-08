package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config.properties"
})
public interface BrowserStackConfig extends Config {

    @Key("browserstack.user")
    String user();

    @Key("browserstack.key")
    String key();

    @Key("browserstack.hubUrl")
    String hubUrl();

    @Key("android.deviceName")
    String androidDeviceName();

    @Key("android.osVersion")
    String androidOsVersion();

    @Key("android.app")
    String androidApp();

    @Key("ios.deviceName")
    String iosDeviceName();

    @Key("ios.osVersion")
    String iosOsVersion();

    @Key("ios.app")
    String iosApp();

    @Key("appium.version")
    String appiumVersion();

    @Key("project.name")
    String projectName();

    @Key("build.name")
    String buildName();

    @Key("emulation.deviceName")
    @DefaultValue("Pixel 4")
    String emulationDeviceName();

    @Key("emulation.platformVersion")
    @DefaultValue("11.0")
    String emulationPlatformVersion();

    @Key("emulation.appiumUrl")
    @DefaultValue("http://localhost:4723/wd/hub")
    String emulationAppiumUrl();

    @Key("emulation.appUrl")
    @DefaultValue("https://github.com/wikimedia/apps-android-wikipedia/releases/download/latest/app-alpha-universal-release.apk")
    String emulationAppUrl();

    @Key("emulation.appVersion")
    @DefaultValue("app-alpha-universal-release.apk")
    String emulationAppVersion();
}