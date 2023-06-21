package org.Salt.Utils;

import io.appium.java_client.AppiumDriver;
import org.Salt.PageObjects.Mobile.Android.HomeScreen;
import org.Salt.PageObjects.Mobile.Android.UserRegistration;
import org.Salt.PageObjects.WebApplication.JqueryElements;
import org.openqa.selenium.WebDriver;

public class AllClasses extends PageFactory {

    CommonMethods objCommonMethods;
    CommonLocators objCommonLocators;
    HomeScreen objHomeScreen;
    UserRegistration objUserReg;
    JqueryElements objJqueryElements;


    public AllClasses(AppiumDriver driver, WebDriver driverWeb) {
        this.driver = driver;
        this.driverWeb = driverWeb;
    }

    public CommonMethods getObjCommonMethods() {
        return objCommonMethods = new CommonMethods(PageFactory.getMobileDriver(), PageFactory.getWebDriver());
    }

    public CommonLocators getObjCommonLocators() {
        return objCommonLocators = new CommonLocators(PageFactory.getMobileDriver(), PageFactory.getWebDriver());
    }

    public HomeScreen getObjHomeScreen() {
        return objHomeScreen = new HomeScreen(PageFactory.getMobileDriver());
    }

    public UserRegistration getObjUserReg() {
        return objUserReg = new UserRegistration(PageFactory.getMobileDriver());
    }

    public JqueryElements getObjJqueryElements() {
        return objJqueryElements = new JqueryElements(PageFactory.getWebDriver());
    }
}
