package com.androidTest;

import com.androidTest.Config.DriverConfig;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class KeyboardTest {

    public static void main(String[] args) {
        AndroidDriver driver = DriverConfig.getDriver();
        driver.findElement(By.name("Name")).sendKeys("123445");//自动向控件填入数据
        driver.pressKeyCode(29);//通过点击事件，实现数据输入。

    }
}
