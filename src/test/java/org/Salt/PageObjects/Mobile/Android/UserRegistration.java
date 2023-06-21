package org.Salt.PageObjects.Mobile.Android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.Salt.Utils.AllClasses;
import org.Salt.Utils.PageFactory;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserRegistration extends PageFactory {
    AllClasses objAll;

    public UserRegistration(AppiumDriver driver) {
        objAll = new AllClasses(PageFactory.getMobileDriver(), PageFactory.getWebDriver());
    }

    public WebElement register_Message() {
        return objAll.getObjCommonLocators().elemLocator(AppiumBy.xpath("//android.widget.TextView[@content-desc='label_usernameCD']/preceding-sibling::android.widget.TextView"));
    }

    public List<WebElement> register_UserName() {
        return objAll.getObjCommonLocators().list_ElemLocators(AppiumBy.id("io.selendroid.testapp:id/inputUsername"));
    }

    public List<WebElement> register_Email() {
        return objAll.getObjCommonLocators().list_ElemLocators(AppiumBy.id("io.selendroid.testapp:id/inputEmail"));
    }

    public List<WebElement> register_Password() {
        return objAll.getObjCommonLocators().list_ElemLocators(AppiumBy.id("io.selendroid.testapp:id/inputPassword"));
    }

    public List<WebElement> register_Name() {
        return objAll.getObjCommonLocators().list_ElemLocators(AppiumBy.id("io.selendroid.testapp:id/inputName"));
    }

    public List<WebElement> register_Programming_Language() {
        return objAll.getObjCommonLocators().list_ElemLocators(AppiumBy.xpath("//android.widget.Spinner[@resource-id='io.selendroid.testapp:id/input_preferedProgrammingLanguage']/android.widget.TextView"));
    }

    public List<WebElement> register_Programming_LanguageAgreement_Checkbox() {
        return objAll.getObjCommonLocators().list_ElemLocators(AppiumBy.id("io.selendroid.testapp:id/input_adds"));
    }

    public WebElement btn_Register_User() {
        return objAll.getObjCommonLocators().elemLocator(AppiumBy.id("io.selendroid.testapp:id/btnRegisterUser"));
    }

    public WebElement getDetails_Name() {
        return objAll.getObjCommonLocators().elemLocator(AppiumBy.id("io.selendroid.testapp:id/label_name_data"));
    }

    public WebElement getDetails_UserName() {
        return objAll.getObjCommonLocators().elemLocator(AppiumBy.id("io.selendroid.testapp:id/label_username_data"));
    }

    public WebElement getDetails_Password() {
        return objAll.getObjCommonLocators().elemLocator(AppiumBy.id("io.selendroid.testapp:id/label_password_data"));
    }

    public WebElement getDetails_Email() {
        return objAll.getObjCommonLocators().elemLocator(AppiumBy.id("io.selendroid.testapp:id/label_email_data"));
    }

    public WebElement getDetails_Programming_Language() {
        return objAll.getObjCommonLocators().elemLocator(AppiumBy.id("io.selendroid.testapp:id/label_preferedProgrammingLanguage_data"));
    }

    public WebElement getDetails_Agreement() {
        return objAll.getObjCommonLocators().elemLocator(AppiumBy.id("io.selendroid.testapp:id/label_acceptAdds_data"));
    }

    public WebElement getDetails_Btn_RegisterUser() {
        return objAll.getObjCommonLocators().elemLocator(AppiumBy.id("io.selendroid.testapp:id/buttonRegisterUser"));
    }
}
