package com.androidTest.Config;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverConfig {
    /**
     * 连接设备
     */
    public static DesiredCapabilities connectDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android emulator-5554");//设备名称
        capabilities.setCapability("automationName", "Appium");//测试框架名称
        capabilities.setCapability("platformName", "Android");//测试平台andorid
        capabilities.setCapability("platformVersion", "8.0");//测试平台的版本等级
        capabilities.setCapability("autoLaunch", true);//测试平台的版本等级
        capabilities.setCapability("app", "/Users/zhangxuehui/Documents/work/基金APP打包/V1.0/诺千金-V1.0-T2018-04-11.apk");//测试平台的版本等级
        return capabilities;
    }

    public static AndroidDriver getDriver() {
        AndroidDriver driver = null;
        try {
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), connectDriver());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
