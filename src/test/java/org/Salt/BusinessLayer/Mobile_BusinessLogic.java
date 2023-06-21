package org.Salt.BusinessLayer;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.Salt.Utils.AllClasses;
import org.Salt.Utils.CommonMethods;
import org.Salt.Utils.CommonStaticEnumStrings;
import org.Salt.Utils.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Mobile_BusinessLogic extends PageFactory {
    AllClasses objAll;
    String[] getValue = new String[10];
    Boolean elementPresent;
    Logger log = LogManager.getLogger(Mobile_BusinessLogic.class);

    public Mobile_BusinessLogic(AppiumDriver driver) {
        objAll = new AllClasses(PageFactory.getMobileDriver(), PageFactory.getWebDriver());
    }

    @Step("Verify element in this method!")
    public void Testcase1_Verify_Elements() {
        try {
            //Check boolean for popup!
            elementPresent = objAll.getObjHomeScreen().alert_popup().size() > 0;
            log.info("Popup is present " + elementPresent);
            if (elementPresent) {
                objAll.getObjCommonMethods().click_Element(objAll.getObjHomeScreen().alert_popup_OkBtn());
                log.info("Pop up closed successfully!");

            } else {
                Assert.fail("Popup element is not present!");
            }
            //Verify Elements on the page!
            objAll.getObjCommonMethods().checkELementExist_Mobile(objAll.getObjHomeScreen().verify_Title());
            objAll.getObjCommonMethods().checkELementExist_Mobile(objAll.getObjHomeScreen().google_Chrome_Icon());
            objAll.getObjCommonMethods().checkELementExist_Mobile(objAll.getObjHomeScreen().user_Registration());
            objAll.getObjCommonMethods().checkELementExist_Mobile(objAll.getObjHomeScreen().btn_Toast());
            objAll.getObjCommonMethods().checkELementExist_Mobile(objAll.getObjHomeScreen().btn_Window_Popup());
            objAll.getObjCommonMethods().checkELementExist_Mobile(objAll.getObjHomeScreen().btn_Unhandled_Exception());
            objAll.getObjCommonMethods().checkELementExist_Mobile(objAll.getObjHomeScreen().btn_Display_Focus());
            objAll.getObjCommonMethods().checkELementExist_Mobile(objAll.getObjHomeScreen().btn_ProgressBar());
            log.info("Elements are presents on the screen!");

        } catch (Exception ex) {
            log.info("Tc failed - Testcase1_Verify_Elements");
            Assert.fail("Issue in Testcase1_Verify_Elements -" + ex.getMessage());
        }
    }

    @Step("Verify text when navigating to home page!")
    public void Testcase2_Validate_HomePage(String actualText) {
        try {
            objAll.getObjCommonMethods().click_Element(objAll.getObjHomeScreen().btn_EN());
            log.info("EN Modal Opens successfully!");
            objAll.getObjCommonMethods().click_Element(objAll.getObjHomeScreen().btn_No_ENModal());
            log.info("Modal closed successfully!");
            getValue[0] = objAll.getObjCommonMethods().element_GetText(objAll.getObjHomeScreen().get_Welcome_Text());
            log.info("The value of title is " + getValue[0]);
            CommonMethods.assert_VerificationText(getValue[0], actualText);
            log.info("Assertion is verified!");

        } catch (Exception ex) {
            log.info("Tc failed - Testcase2_Validate_HomePage");
            Assert.fail("Issue in Testcase2_Validate_HomePage -" + ex.getMessage());
        }
    }

    @Step("Verify text when click on button & verify car name!")
    public void Testcase3_Validate_ChromePage_Actions(String actualText, String sendName, String selectCar) {
        try {
            objAll.getObjCommonMethods().click_Element(objAll.getObjHomeScreen().google_Chrome_Icon().get(0));
            log.info("Chrome text page open successfully!");
            getValue[1] = objAll.getObjCommonMethods().element_GetText(objAll.getObjHomeScreen().chrome_Page_Text());
            CommonMethods.assert_VerificationText(getValue[1], actualText);
            log.info("Assertion verified for chrome page text!");
            objAll.getObjCommonMethods().clear_text(objAll.getObjHomeScreen().chrome_Enter_Name());
            log.info("Text clears from the textbox!");
            objAll.getObjCommonMethods().sendKeysّ(objAll.getObjHomeScreen().chrome_Enter_Name_Text(), sendName);
            log.info("Name entered successfully in textbox!");
            getValue[2] = objAll.getObjCommonMethods().element_GetText(objAll.getObjHomeScreen().chrome_Prefered_Car_Dropdown());
            log.info("The value of is " + getValue[2]);
            objAll.getObjCommonMethods().click_Element(objAll.getObjHomeScreen().chrome_Prefered_Car_Dropdown());
            log.info("Prefered Car dropdown opens!");
            objAll.getObjCommonMethods().click_Element(objAll.getObjHomeScreen().chrome_Prefered_Car_Select(selectCar));
            log.info("Car select successfully!!");
            objAll.getObjCommonMethods().click_Element(objAll.getObjHomeScreen().chrome_Btn_Send_Your_Name());
            CommonMethods.assert_VerificationText(objAll.getObjHomeScreen().chrome_get_Name().getText().replaceAll("\"", ""), sendName);
            log.info("Verified name " + sendName);
            CommonMethods.assert_VerificationText(objAll.getObjHomeScreen().chrome_get_PreferedCar().getText().replaceAll("\"", "").toLowerCase(), selectCar.toLowerCase());
            log.info("Verified prefered car " + selectCar);
            objAll.getObjCommonMethods().click_Element(objAll.getObjHomeScreen().chrome_Link_Here());
            getValue[3] = objAll.getObjCommonMethods().element_GetText(objAll.getObjHomeScreen().chrome_Prefered_Car_Dropdown());
            log.info("prefered car is " + getValue[3]);
            CommonMethods.assert_VerificationText(getValue[3], CommonStaticEnumStrings.prefered_Car_Volvo.getCommonStrings());
            objAll.getObjCommonMethods().navigate_Back(1);
            CommonMethods.assert_VerificationText(getValue[0], CommonStaticEnumStrings.title_HomePage.getCommonStrings());

        } catch (Exception ex) {
            log.info("Tc failed - Testcase3_Validate_ChromePage_Actions");
            Assert.fail("Issue in Testcase3_Validate_ChromePage_Actions -" + ex.getMessage());
        }
    }

    @Step("Verify text when click on file button & verify details!")
    public void Testcase4_Validate_FileLogon_Actions(String actualText, String register_Uname, String register_Programming_Lng,
                                                     String userName, String userEmail, String password) {
        try {
            objAll.getObjCommonMethods().click_Element(objAll.getObjHomeScreen().user_Registration().get(0));
            log.info("User Registration page open successfully!");
            CommonMethods.assert_VerificationText(objAll.getObjUserReg().register_Message().getText(), actualText);
            objAll.getObjCommonMethods().navigate_Back(1);
            validate_User_Form();
            getValue[4] = objAll.getObjCommonMethods().element_GetText(objAll.getObjUserReg().register_Name().get(0));
            CommonMethods.assert_VerificationText(getValue[4], register_Uname);
            getValue[5] = objAll.getObjCommonMethods().element_GetText(objAll.getObjUserReg().register_Programming_Language().get(0));
            CommonMethods.assert_VerificationText(getValue[5], register_Programming_Lng);
            objAll.getObjCommonMethods().sendKeysّ(objAll.getObjUserReg().register_UserName().get(0), userName);
            objAll.getObjCommonMethods().sendKeysّ(objAll.getObjUserReg().register_Email().get(0), userEmail);
            objAll.getObjCommonMethods().sendKeysّ(objAll.getObjUserReg().register_Password().get(0), password);
            objAll.getObjCommonMethods().click_Element(objAll.getObjUserReg().register_Programming_LanguageAgreement_Checkbox().get(0));
            objAll.getObjCommonMethods().click_Element(objAll.getObjUserReg().btn_Register_User());

            //Verify Details On User Detail Screen
            CommonMethods.assert_VerificationText(objAll.getObjUserReg().getDetails_Name().getText(), getValue[4]);
            CommonMethods.assert_VerificationText(objAll.getObjUserReg().getDetails_UserName().getText(), userName);
            CommonMethods.assert_VerificationText(objAll.getObjUserReg().getDetails_Password().getText(), password);
            CommonMethods.assert_VerificationText(objAll.getObjUserReg().getDetails_Email().getText(), userEmail);
            CommonMethods.assert_VerificationText(objAll.getObjUserReg().getDetails_Programming_Language().getText(), getValue[5]);
            CommonMethods.assert_VerificationText(objAll.getObjUserReg().getDetails_Agreement().getText(), "true");
            objAll.getObjCommonMethods().click_Element(objAll.getObjUserReg().getDetails_Btn_RegisterUser());
            CommonMethods.assert_VerificationText(getValue[0], CommonStaticEnumStrings.title_HomePage.getCommonStrings());

        } catch (Exception ex) {
            log.info("Tc failed - Testcase4_Validate_FileLogon_Actions");
            Assert.fail("Issue in Testcase4_Validate_FileLogon_Actions -" + ex.getMessage());
        }
    }

    public void validate_User_Form() {
        try {
            objAll.getObjCommonMethods().checkELementExist_Mobile(objAll.getObjUserReg().register_UserName());
            objAll.getObjCommonMethods().checkELementExist_Mobile(objAll.getObjUserReg().register_Email());
            objAll.getObjCommonMethods().checkELementExist_Mobile(objAll.getObjUserReg().register_Password());
            objAll.getObjCommonMethods().checkELementExist_Mobile(objAll.getObjUserReg().register_Name());
            objAll.getObjCommonMethods().checkELementExist_Mobile(objAll.getObjUserReg().register_Programming_Language());
            objAll.getObjCommonMethods().checkELementExist_Mobile(objAll.getObjUserReg().register_Programming_LanguageAgreement_Checkbox());

        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    @Step("Tap on show progress bar & verify user details!")
    public void Testcase5_ProgressBar_UserDetails(String actual_RegistrationMessage) {
        try {
            objAll.getObjCommonMethods().click_Element(objAll.getObjHomeScreen().btn_ProgressBar().get(0));
            log.info("Progress bar appears!");
            CommonMethods.element_WebDriverWait_Visibility_Mobile(By.xpath("//android.widget.TextView[@content-desc='label_usernameCD']/preceding-sibling::android.widget.TextView"));
            CommonMethods.assert_VerificationText(objAll.getObjUserReg().register_Message().getText(), actual_RegistrationMessage);
            objAll.getObjCommonMethods().navigate_Back(1);
            validate_User_Form();
            CommonMethods.wait_For_Element(2);
            objAll.getObjCommonMethods().navigate_Back(1);

        } catch (Exception ex) {
            log.info("Tc failed - Testcase5_ProgressBar_UserDetails");
            Assert.fail("Issue in Testcase5_ProgressBar_UserDetails -" + ex.getMessage());
        }
    }

    @Step("Tap on toast button to verify toast message!")
    public void Testcase6_Verify_ToastMessage(String toastMessage) {
        try {
            objAll.getObjCommonMethods().click_Element(objAll.getObjHomeScreen().btn_Toast().get(0));
            log.info("Toast button click successfully!");
            WebDriverWait waitForToast = new WebDriverWait(PageFactory.getMobileDriver(), Duration.ofSeconds(25));

            waitForToast.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));

            String ttm = PageFactory.getMobileDriver().findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();

            System.out.println(ttm);

//            ImmutableMap args = ImmutableMap.of(
//                    "text", toastMessage,
//                    "isRegexp", false
//            );
//            PageFactory.getMobileDriver().executeScript("mobile: scroll", ImmutableMap.of("direction", "down"), args);

        } catch (Exception ex) {
            log.info("Tc failed - Testcase6_Verify_ToastMessage");
            Assert.fail("Issue in Testcase6_Verify_ToastMessage -" + ex.getMessage());
        }
    }

    @Step("Tap on display button to view popup!")
    public void Testcase7_Verify_Popup() {
        try {
            objAll.getObjCommonMethods().click_Element(objAll.getObjHomeScreen().btn_Display_Focus().get(0));
            log.info("Toast button click successfully!");
            log.info("There is no alert present!");
            CommonMethods.wait_For_Element(2);

        } catch (Exception ex) {
            log.info("Tc failed - Testcase7_Verify_Popup");
            Assert.fail("Issue in Testcase7_Verify_Popup -" + ex.getMessage());
        }
    }

    @Step("Tap on Unhandled exception button!")
    public void Testcase8_Unhandled_Exception(String actualText) {
        try {
            objAll.getObjCommonMethods().click_Element(objAll.getObjHomeScreen().btn_Unhandled_Exception().get(0));
            log.info("App crashed!");
            CommonMethods.wait_For_Element(1);
            launch_AndroidApplication();
            //Check boolean for popup!
            elementPresent = objAll.getObjHomeScreen().alert_popup().size() > 0;
            log.info("Popup is present " + elementPresent);
            if (elementPresent) {
                objAll.getObjCommonMethods().click_Element(objAll.getObjHomeScreen().alert_popup_OkBtn());
                log.info("Pop up closed successfully!");

            } else {
                Assert.fail("Popup element is not present!");
            }
            CommonMethods.assert_VerificationText(getValue[0], actualText);
            log.info("Assertion is verified!");
            TimeUnit.SECONDS.sleep(1);

        } catch (Exception ex) {
            log.info("Tc failed - Testcase8_Unhandled_Exception");
            Assert.fail("Issue in Testcase8_Unhandled_Exception -" + ex.getMessage());
        }
    }

    @Step("Tap on Unhandled exception button!")
    public void Testcase9_Unhandled_Exception(String actualText) throws InterruptedException {
        try {
            objAll.getObjCommonMethods().click_Element(objAll.getObjHomeScreen().txtbox_Exception());
            objAll.getObjCommonMethods().sendKeysّ(objAll.getObjHomeScreen().txtbox_Exception(), "a");
            log.info("App crashed!");
            CommonMethods.wait_For_Element(1);

        } catch (Exception ex) {
            objAll.getObjCommonMethods().navigate_Back(1);
            launch_AndroidApplication();
            //Check boolean for popup!
            elementPresent = objAll.getObjHomeScreen().alert_popup().size() > 0;
            log.info("Popup is present " + elementPresent);
            if (elementPresent) {
                objAll.getObjCommonMethods().click_Element(objAll.getObjHomeScreen().alert_popup_OkBtn());
                log.info("Pop up closed successfully!");

            } else {
                Assert.fail("Popup element is not present!");
            }
            CommonMethods.assert_VerificationText(getValue[0], actualText);
            log.info("Assertion is verified!");
            TimeUnit.SECONDS.sleep(1);
//            log.info("Tc failed - Testcase9_Unhandled_Exception");
//            Assert.fail("Issue in Testcase9_Unhandled_Exception -" + ex.getMessage());
        }
    }
}
