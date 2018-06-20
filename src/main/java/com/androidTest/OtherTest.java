package com.androidTest;

import com.androidTest.Config.DriverConfig;
import io.appium.java_client.android.AndroidDriver;

import java.util.Base64;

public class OtherTest {

    public static void main(String[] args) {
        AndroidDriver driver = DriverConfig.getDriver();
        driver.lockDevice();//熄屏
        String act = driver.currentActivity();
        System.out.println(act);
        //隐藏键盘
        if (driver.isKeyboardShown()) {
            driver.hideKeyboard();
            System.out.println("隐藏键盘成功");
        }
        //自定义类，通过TouchAction 完成滑动事件
        //        driver.swipe(75, 500, 75, 0, 800);
        driver.pullFile("path");//拉取事件
        String str = "这是一个测试Appium推送事件的程序";
        byte[] data = Base64.getEncoder().encode(str.getBytes());
        driver.pushFile("sdcard/text.txt", data);//推送事件
    }
}
