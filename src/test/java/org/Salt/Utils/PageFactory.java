package org.Salt.Utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class PageFactory {
    public static final Logger log = LogManager.getLogger(PageFactory.class);
    DesiredCapabilities caps;
    public static String configFile = CommonStaticEnumStrings.configPath.getCommonStrings();
//    public static String deedConfigFile = CommonStaticEnumStrings.deedConfigPath.getCommonStrings();

    public AppiumDriver driver;
    public WebDriver driverWeb;
    public String apkDirectory = CommonStaticEnumStrings.apkLocation.getCommonStrings();
    File apkPath = new File(apkDirectory);
    public static ThreadLocal<AppiumDriver> tMdriver = new ThreadLocal<>();
    public static ThreadLocal<WebDriver> tWdriver = new ThreadLocal<>();

    public AppiumDriver launch_AndroidApplication() {
        caps = new DesiredCapabilities();
        try {
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, PropertyReader.getConfigValue(configFile, "platformName"));
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
            caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 1000);
            caps.setCapability("appPackage", PropertyReader.getConfigValue(configFile, "appPackage"));
            caps.setCapability("appActivity", PropertyReader.getConfigValue(configFile, "appActivity"));
            caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
            caps.setCapability("autoAcceptAlerts", true);
            caps.setCapability("autoDismissAlerts", true);
            caps.setCapability(MobileCapabilityType.FULL_RESET, true);
            caps.setCapability(MobileCapabilityType.APP, apkPath.getAbsolutePath());
            System.out.println("The Url generate is " + PropertyReader.getConfigValue(configFile, "launchUrl") + ":" + PropertyReader.getConfigValue(configFile, "port") + PropertyReader.getConfigValue(configFile, "completeUrl"));
            driver = new AppiumDriver(new URL(PropertyReader.getConfigValue(configFile, "launchUrl") + ":" + PropertyReader.getConfigValue(configFile, "port") + PropertyReader.getConfigValue(configFile, "completeUrl")), caps);
            log.info("Android App launch successfully!");
            tMdriver.set(driver);
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertyReader.getConfigValue(configFile, "implicitWait")), TimeUnit.SECONDS);
            log.info("Android App launch successfully!");

        } catch (Exception ex) {
            ex.getMessage();
        }
        return driver;
    }

    public WebDriver launchWebBrowser(String browserName, String appUrl) {
        try {
            if (browserName.toLowerCase().equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driverWeb = new ChromeDriver();

            } else if (browserName.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driverWeb = new FirefoxDriver();
            }
            driverWeb.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(PropertyReader.getConfigValue(configFile, "implicitWait"))));
            driverWeb.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(PropertyReader.getConfigValue(configFile, "webDriverWait"))));
            driverWeb.navigate().to(appUrl);
            driverWeb.manage().window().maximize();
            tWdriver.set(driverWeb);

        } catch (Exception ex) {
            Assert.fail("Issue in launching browser - " + ex.getMessage());
        }
        return driverWeb;
    }

    public static synchronized WebDriver getWebDriver() {
        return tWdriver.get();
    }

    public void close_WebApp() {
        driverWeb.quit();
    }

    public static synchronized AppiumDriver getMobileDriver() {
        return tMdriver.get();
    }

    public void close_MobileApp() {
        driver.quit();
    }
}
