package mediationTest;

import baseClassPackage.BaseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;
import utilPackages.WaitClass;
import mediation.MediationPage;


public class mediationRunTest {
	MediationPage mediationPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        mediationPage=MediationPage.getPage(driver, MediationPage.class);

    }

    @Test(groups={"Sanity"},description="Mediation 2.3 - Mediation Run Test")
    public void userSignin() throws IOException{
/*
    	mediationPage.enterLoginID();
    	mediationPage.enterPassword();
    	mediationPage.selectCompany();
    	mediationPage.clickLoginButton();
*/
    	mediationPage.clickCustomersTab();
    	mediationPage.clickAddNewButton();
    	mediationPage.selectAccountType();
    	mediationPage.clickSelectButton();
    	mediationPage.enterLoginName();
		mediationPage.navigateBottom();
    	mediationPage.clickSaveChangesButton();
    	mediationPage.verifyConfirmationMsg();
    	mediationPage.clickConfigurationsTab();
    	mediationPage.clickMediationsLink();
    	mediationPage.clickAddNewButton();
    	mediationPage.enterConfigurationName();
    	mediationPage.enterExecutionOrder();
    	mediationPage.clickSaveChangesButton();
    	mediationPage.clickMediation();
    	mediationPage.uploadMediationCSVFile();
    	mediationPage.clickTriggerConfigButton();
    	mediationPage.clickMediationsTab();
    	mediationPage.verifyNumberOrders();
    	mediationPage.clickMediationName();
    	mediationPage.clickDoneBillableViewLink();
    	mediationPage.clickOrdersTab();
    	
    }
    
    @AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }

}
