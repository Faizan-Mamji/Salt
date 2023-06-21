package org.Salt.TestExecution.Mobile;

import io.qameta.allure.*;
import org.Salt.BusinessLayer.Mobile_BusinessLogic;
import org.Salt.Listeners.MobileAllureListener;
import org.Salt.Utils.AllClasses;
import org.Salt.Utils.CommonStaticEnumStrings;
import org.Salt.Utils.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(MobileAllureListener.class)
public class Selendroid_MobileApp_TestCases extends PageFactory {
    AllClasses objAll;
    Mobile_BusinessLogic objMobile;
    public static String configFile = CommonStaticEnumStrings.configPath.getCommonStrings();

    @Epic("Android Application Launch!")
    @Description("Before method launch for Application!")
    @BeforeClass(groups = "Main_App_Launch")
    public void launchBrowser() throws Exception {
        launch_AndroidApplication();
        objAll = new AllClasses(PageFactory.getMobileDriver(), PageFactory.getWebDriver());
        objMobile = new Mobile_BusinessLogic(PageFactory.getMobileDriver());
    }

    @Epic("Elements Verification!")
    @Description("Verify elements on the page!")
    @Story("Verification Of Elements!")
    @Feature("Element")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1, description = "Verify Few Elements!")
    public void Tc1_Verify_Elements_Selendroid_App() {
        try {
            objMobile.Testcase1_Verify_Elements();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Epic("Title!")
    @Description("Verify title on the page!")
    @Story("Verification Of Title!")
    @Feature("Title Verification!")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 2, description = "Verify title on homepage!")
    public void Tc2_Verify_Title_Selendroid_App() {
        try {
            objMobile.Testcase2_Validate_HomePage(CommonStaticEnumStrings.title_HomePage.getCommonStrings());

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Epic("Chrome")
    @Description("Verify chrome actions on the page!")
    @Story("Verification Of chrome actions!")
    @Feature("Chrome Verification!")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 3, description = "Verify chrome page actions!")
    public void Tc3_Verify_Text_Chrome_Logo() {
        try {
            objMobile.Testcase3_Validate_ChromePage_Actions(CommonStaticEnumStrings.chrome_Page_Text.getCommonStrings(), CommonStaticEnumStrings.name.getCommonStrings(),
                    CommonStaticEnumStrings.prefered_Car.getCommonStrings());

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Epic("File Registrations")
    @Description("Verify registration actions on the page!")
    @Story("Verification Of registration actions!")
    @Feature("File Registrations Verification!")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 4, description = "Verify File Registrations page actions!")
    public void Tc4_Verify_File_Registration_Actions() {
        try {
            objMobile.Testcase4_Validate_FileLogon_Actions(CommonStaticEnumStrings.register_Message.getCommonStrings(),
                    CommonStaticEnumStrings.register_Name.getCommonStrings(),
                    CommonStaticEnumStrings.register_Programming_Language.getCommonStrings(),
                    CommonStaticEnumStrings.name.getCommonStrings(),
                    CommonStaticEnumStrings.register_Email.getCommonStrings(),
                    CommonStaticEnumStrings.register_Password.getCommonStrings());

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Epic("Progress Bar")
    @Description("Verify registration fields on the page!")
    @Story("Verification Of registration fields!")
    @Feature("Registrations Verification!")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5, description = "Verify fields on registration!")
    public void Tc5_Verify_Progress_Bar_Registration() {
        try {
            objMobile.Testcase5_ProgressBar_UserDetails(CommonStaticEnumStrings.register_Message.getCommonStrings());

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Epic("Toast")
    @Description("Verify Toast Message!")
    @Story("Verification Of Toast Message!")
    @Feature("Toast Message!")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 6, description = "Verify toast messages!")
    public void Tc6_Verify_Toast_Message() {
        try {
            objMobile.Testcase6_Verify_ToastMessage(CommonStaticEnumStrings.toast_Message.getCommonStrings());

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Epic("Dismiss Alert")
    @Description("Verify ALert!")
    @Story("Verification Of Alert to be dismiss!")
    @Feature("Alert Dismiss!")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 7, description = "Verify alert dismiss!")
    public void Tc7_Verify_Dismiss_Alert() {
        try {
            objMobile.Testcase7_Verify_Popup();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Epic("Unhandled Exception")
    @Description("Verify Unhandled_Exception!")
    @Story("Verification Of Unhandled_Exception!")
    @Feature("Unhandled_Exception!")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 8, description = "Verify Unhandled_Exception!")
    public void Tc8_Verify_Unhandled_Exception() {
        try {
            objMobile.Testcase8_Unhandled_Exception(CommonStaticEnumStrings.title_HomePage.getCommonStrings());

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Epic("Unhandled Exception")
    @Description("Verify Unhandled_Exception!")
    @Story("Verification Of Unhandled_Exception!")
    @Feature("Unhandled_Exception!")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 9, description = "Verify Unhandled_Exception!")
    public void Tc9_Verify_Unhandled_Exception() {
        try {
            objMobile.Testcase9_Unhandled_Exception(CommonStaticEnumStrings.title_HomePage.getCommonStrings());

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @AfterClass(alwaysRun = true)
    public void teardown() throws Exception {
        close_MobileApp();
    }
}