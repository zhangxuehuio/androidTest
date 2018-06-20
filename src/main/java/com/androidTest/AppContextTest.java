package com.androidTest;

import com.androidTest.Config.DriverConfig;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class AppContextTest {

    public static void main(String[] args) {
        AndroidDriver driver = DriverConfig.getDriver();
        driver.launchApp();
        System.out.println("��ȡ���������ͣ�" + driver.getContext());
        System.out.println("��ȡ�����ľ����" + driver.getContextHandles());
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("com.wealthfund:id/bottom_banner")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("��ȡ���������ͣ�" + driver.getContext());
        System.out.println("��ȡ�����ľ����" + driver.getContextHandles());
    }
}
