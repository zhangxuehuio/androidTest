package com.androidTest.Config;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverConfig {
    /**
     * �����豸
     */
    public static DesiredCapabilities connectDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android emulator-5554");//�豸����
        capabilities.setCapability("automationName", "Appium");//���Կ������
        capabilities.setCapability("platformName", "Android");//����ƽ̨andorid
        capabilities.setCapability("platformVersion", "8.0");//����ƽ̨�İ汾�ȼ�
        capabilities.setCapability("autoLaunch", true);//����ƽ̨�İ汾�ȼ�
        capabilities.setCapability("app", "/Users/zhangxuehui/Documents/work/����APP���/V1.0/ŵǧ��-V1.0-T2018-04-11.apk");//����ƽ̨�İ汾�ȼ�
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
