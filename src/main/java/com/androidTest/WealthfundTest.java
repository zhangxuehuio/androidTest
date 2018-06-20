package com.androidTest;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("ALL")
public class WealthfundTest {

    public static void main(String[] args) {
        DesiredCapabilities capabilities = connectDriver();
        try {
            AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
            //手动安装
            if (!driver.isAppInstalled("com.wealthfund")) {
                installAPP(driver);
            } else {
                launchApp(driver);
            }
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    /**
     * 关闭应用
     *
     * @param driver
     */
    private static void closeApp(AndroidDriver driver) {
        driver.closeApp();
        System.out.println("关闭应用成功");
        deleteApp(driver);
    }

    /**
     * 重启应用
     *
     * @param driver
     */
    private static void resetApp(AndroidDriver driver) {
        driver.resetApp();
        System.out.println("重启应用成功");
        closeApp(driver);
    }

    /**
     * 重启应用
     *
     * @param driver
     */

    private static void runBackgroundApp(AndroidDriver driver) {
        System.out.println(System.currentTimeMillis());
        driver.runAppInBackground(Duration.ofSeconds(10));
        System.out.println(System.currentTimeMillis());
        System.out.println("应用进入后台成功");
        resetApp(driver);
    }

    /**
     * 启动应用
     *
     * @param driver
     */
    private static void launchApp(AndroidDriver driver) {
        driver.launchApp();
        System.out.println("启动应用成功");
        System.out.println(System.currentTimeMillis());
        runBackgroundApp(driver);
    }


    /**
     * 删除应用
     *
     * @param driver
     */
    private static void deleteApp(AndroidDriver driver) {
//        driver.removeApp("com.wealthfund");
        System.out.println("删除应用成功");
        driver.quit();//断开连接
    }

    /**
     * 连接设备
     */
    private static DesiredCapabilities connectDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android emulator-5554");//设备名称
        capabilities.setCapability("automationName", "Appium");//测试框架名称
        capabilities.setCapability("platformName", "Android");//测试平台andorid
        capabilities.setCapability("platformVersion", "8.0");//测试平台的版本等级
        capabilities.setCapability("autoLaunch", true);//测试平台的版本等级
        capabilities.setCapability("app", "/Users/zhangxuehui/Documents/work/基金APP打包/V1.0/诺千金-V1.0-T2018-04-11.apk");//测试平台的版本等级
        return capabilities;
    }

    /**
     * 安装APP
     */
    private static void installAPP(AndroidDriver driver) {
        driver.installApp("/Users/zhangxuehui/Documents/work/基金APP打包/V1.0/诺千金-V1.0-T2018-04-11.apk");

        System.out.println("安装应用成功");
        launchApp(driver);
    }
}

