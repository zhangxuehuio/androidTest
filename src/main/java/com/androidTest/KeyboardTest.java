package com.androidTest;

import com.androidTest.Config.DriverConfig;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class KeyboardTest {

    public static void main(String[] args) {
        AndroidDriver driver = DriverConfig.getDriver();
        driver.findElement(By.name("Name")).sendKeys("123445");//�Զ���ؼ���������
        driver.pressKeyCode(29);//ͨ������¼���ʵ���������롣

    }
}
