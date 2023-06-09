package org.TREE.PageObjects.Mobile.Android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.TREE.Utils.AllClasses;
import org.TREE.Utils.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomeScreen extends PageFactory {
    AllClasses objAll;

    public HomeScreen(AppiumDriver driver) {
        objAll = new AllClasses(PageFactory.getMobileDriver(), PageFactory.getWebDriver());
    }

    public List<WebElement> verify_Title() {
        return objAll.getObjCommonLocators().list_ElemLocators(AppiumBy.id("android:id/title"));
    }

    public WebElement get_Welcome_Text() {
        return objAll.getObjCommonLocators().elemLocator(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id='io.selendroid.testapp:id/l10n']/preceding-sibling::android.widget.TextView"));
    }

    public List<WebElement> alert_popup() {
        return objAll.getObjCommonLocators().list_ElemLocators(AppiumBy.id("android:id/alertTitle"));
    }

    public WebElement alert_popup_OkBtn() {
        return objAll.getObjCommonLocators().elemLocator(AppiumBy.id("android:id/button1"));
    }

    public List<WebElement> google_Chrome_Icon() {
        return objAll.getObjCommonLocators().list_ElemLocators(AppiumBy.id("io.selendroid.testapp:id/buttonStartWebview"));
    }

    public List<WebElement> user_Registration() {
        return objAll.getObjCommonLocators().list_ElemLocators(AppiumBy.id("io.selendroid.testapp:id/startUserRegistration"));
    }

    public List<WebElement> btn_Toast() {
        return objAll.getObjCommonLocators().list_ElemLocators(AppiumBy.id("io.selendroid.testapp:id/showToastButton"));
    }

    public List<WebElement> btn_Window_Popup() {
        return objAll.getObjCommonLocators().list_ElemLocators(new AppiumBy.ByAccessibilityId("showPopupWindowButtonCD"));
    }

    public List<WebElement> btn_Unhandled_Exception() {
        return objAll.getObjCommonLocators().list_ElemLocators(new AppiumBy.ByAccessibilityId("exceptionTestButtonCD"));
    }

    public WebElement txtbox_Exception(){
        return objAll.getObjCommonLocators().elemLocator(AppiumBy.xpath("//android.widget.EditText[@resource-id='io.selendroid.testapp:id/exceptionTestField']"));
    }

    public List<WebElement> btn_Display_Focus() {
        return objAll.getObjCommonLocators().list_ElemLocators(new AppiumBy.ByAccessibilityId("showPopupWindowButtonCD"));
    }

    public List<WebElement> btn_ProgressBar() {
        return objAll.getObjCommonLocators().list_ElemLocators(new AppiumBy.ByAccessibilityId("waitingButtonTestCD"));
    }

    public WebElement btn_EN() {
        return objAll.getObjCommonLocators().elemLocator(AppiumBy.id("io.selendroid.testapp:id/buttonTest"));
    }

    public WebElement btn_No_ENModal() {
        return objAll.getObjCommonLocators().elemLocator(AppiumBy.id("android:id/button2"));
    }

    public WebElement chrome_Page_Text() {
        return objAll.getObjCommonLocators().elemLocator(AppiumBy.xpath("//android.widget.TextView[@text='Hello, can you please tell me your name?']"));
    }

    public WebElement chrome_Enter_Name() {
        return objAll.getObjCommonLocators().elemLocator(AppiumBy.xpath("//android.widget.EditText[@text='Enter your name here!']"));
    }

    public WebElement chrome_Enter_Name_Text() {
        return objAll.getObjCommonLocators().elemLocator(AppiumBy.xpath("//android.widget.EditText[@resource-id='name_input']"));
    }

    public WebElement chrome_Prefered_Car_Dropdown() {
        return objAll.getObjCommonLocators().elemLocator(AppiumBy.xpath("//android.widget.TextView[@text='Prefered Car:']/following-sibling::android.view.View[2]"));
    }

    public WebElement chrome_Prefered_Car_Select(String preferedcar) {
        return objAll.getObjCommonLocators().elemLocator(AppiumBy.xpath("//android.widget.CheckedTextView[@text='" + preferedcar + "']"));
    }

    public WebElement chrome_Btn_Send_Your_Name() {
        return objAll.getObjCommonLocators().elemLocator(AppiumBy.xpath("//android.widget.Button[@text='Send me your name!']"));
    }

    public WebElement chrome_get_Name() {
        return objAll.getObjCommonLocators().elemLocator(AppiumBy.xpath("//android.widget.TextView[@index='3']"));
    }

    public WebElement chrome_get_PreferedCar() {
        return objAll.getObjCommonLocators().elemLocator(AppiumBy.xpath("//android.widget.TextView[@index='5']"));
    }

    public WebElement chrome_Link_Here(){
        return objAll.getObjCommonLocators().elemLocator(new AppiumBy.ByAccessibilityId("here"));
    }

}
