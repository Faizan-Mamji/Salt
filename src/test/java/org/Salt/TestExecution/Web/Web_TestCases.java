package org.Salt.TestExecution.Web;

import io.qameta.allure.*;
import org.Salt.BusinessLayer.Api_Logics;
import org.Salt.BusinessLayer.Web_BusinessLogic;
import org.Salt.Listeners.WebAllureListener;
import org.Salt.Utils.AllClasses;
import org.Salt.Utils.CommonStaticEnumStrings;
import org.Salt.Utils.PageFactory;
import org.Salt.Utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners(WebAllureListener.class)
public class Web_TestCases extends PageFactory {
    AllClasses objAll;
    Web_BusinessLogic objWeb;
    public static String configFile = CommonStaticEnumStrings.configPath.getCommonStrings();

    @Epic("Web Browser Launch!")
    @Description("Before method launch for browser!")
    @BeforeClass(groups = "Main_Browser_Launch")
    public void launchBrowser() throws Exception {
        launchWebBrowser(PropertyReader.getConfigValue(configFile, "browserValue"), PropertyReader.getConfigValue(configFile, "appUrl"));
        objAll = new AllClasses(PageFactory.getMobileDriver(), PageFactory.getWebDriver());
        objWeb = new Web_BusinessLogic(PageFactory.getMobileDriver());
    }

    @Epic("Drag & Drop!")
    @Description("Verify element to be drag!")
    @Story("Verification Of element drag!")
    @Feature("Drag & Drop - Droppable")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1, description = "Verify elements drop to particular position!")
    public void Tc1_Verify_Drag_And_Drop_Action() {
        try {
            objWeb.Testcase1_Verify_Element_Droppable();
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Epic("Selectable!")
    @Description("Verify multiple list item should selected!")
    @Story("Verification Of multiple selections!")
    @Feature("Multiple seelctions - Selectables")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2, description = "Verify multiple options selected!")
    public void Tc2_Verify_Selectable_Multiple_Selections() {
        try {
            objWeb.Testcase2_Verify_Element_Selectable("Item 1", "Item 3", "Item 7");
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Epic("Control Group!")
    @Description("Verify multiple options from control group!")
    @Story("Verification Of multiple options!")
    @Feature("Multiple selections - Control Group")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3, description = "Verify Control Group selections!")
    public void Tc3_Verify_Control_Group_Multiple_Selections() {
        try {
            objWeb.Testcase3_Verify_ControlGroup_Actions();
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

     // Api
    @Test(priority = 4, description = "Verify Get Api!")
    public void Tc1_Verify_Get_Api() {
        try {
            Api_Logics.Get_Api_Reqres();
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test(priority = 5, description = "Verify Post Api!")
    public void Tc2_Verify_Post_Api() {
        try {
            Api_Logics.Post_Api_Reqres();
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @AfterClass(alwaysRun = true)
    public void teardown() throws Exception {
        close_WebApp();
    }
}
