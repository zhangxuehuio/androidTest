package com.androidTest;

import com.androidTest.Config.DriverConfig;
import io.appium.java_client.android.AndroidDriver;

import java.util.Base64;

public class OtherTest {

    public static void main(String[] args) {
        AndroidDriver driver = DriverConfig.getDriver();
        driver.lockDevice();//Ϩ��
        String act = driver.currentActivity();
        System.out.println(act);
        //���ؼ���
        if (driver.isKeyboardShown()) {
            driver.hideKeyboard();
            System.out.println("���ؼ��̳ɹ�");
        }
        //�Զ����࣬ͨ��TouchAction ��ɻ����¼�
        //        driver.swipe(75, 500, 75, 0, 800);
        driver.pullFile("path");//��ȡ�¼�
        String str = "����һ������Appium�����¼��ĳ���";
        byte[] data = Base64.getEncoder().encode(str.getBytes());
        driver.pushFile("sdcard/text.txt", data);//�����¼�
    }
}
