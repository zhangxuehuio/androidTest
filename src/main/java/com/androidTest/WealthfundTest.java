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
            //�ֶ���װ
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
     * �ر�Ӧ��
     *
     * @param driver
     */
    private static void closeApp(AndroidDriver driver) {
        driver.closeApp();
        System.out.println("�ر�Ӧ�óɹ�");
        deleteApp(driver);
    }

    /**
     * ����Ӧ��
     *
     * @param driver
     */
    private static void resetApp(AndroidDriver driver) {
        driver.resetApp();
        System.out.println("����Ӧ�óɹ�");
        closeApp(driver);
    }

    /**
     * ����Ӧ��
     *
     * @param driver
     */

    private static void runBackgroundApp(AndroidDriver driver) {
        System.out.println(System.currentTimeMillis());
        driver.runAppInBackground(Duration.ofSeconds(10));
        System.out.println(System.currentTimeMillis());
        System.out.println("Ӧ�ý����̨�ɹ�");
        resetApp(driver);
    }

    /**
     * ����Ӧ��
     *
     * @param driver
     */
    private static void launchApp(AndroidDriver driver) {
        driver.launchApp();
        System.out.println("����Ӧ�óɹ�");
        System.out.println(System.currentTimeMillis());
        runBackgroundApp(driver);
    }


    /**
     * ɾ��Ӧ��
     *
     * @param driver
     */
    private static void deleteApp(AndroidDriver driver) {
//        driver.removeApp("com.wealthfund");
        System.out.println("ɾ��Ӧ�óɹ�");
        driver.quit();//�Ͽ�����
    }

    /**
     * �����豸
     */
    private static DesiredCapabilities connectDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android emulator-5554");//�豸����
        capabilities.setCapability("automationName", "Appium");//���Կ������
        capabilities.setCapability("platformName", "Android");//����ƽ̨andorid
        capabilities.setCapability("platformVersion", "8.0");//����ƽ̨�İ汾�ȼ�
        capabilities.setCapability("autoLaunch", true);//����ƽ̨�İ汾�ȼ�
        capabilities.setCapability("app", "/Users/zhangxuehui/Documents/work/����APP���/V1.0/ŵǧ��-V1.0-T2018-04-11.apk");//����ƽ̨�İ汾�ȼ�
        return capabilities;
    }

    /**
     * ��װAPP
     */
    private static void installAPP(AndroidDriver driver) {
        driver.installApp("/Users/zhangxuehui/Documents/work/����APP���/V1.0/ŵǧ��-V1.0-T2018-04-11.apk");

        System.out.println("��װӦ�óɹ�");
        launchApp(driver);
    }
}

