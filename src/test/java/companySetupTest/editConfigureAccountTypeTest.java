package companySetupTest;

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
import companySetUp.EditConfigurationAccountTypePage;


public class editConfigureAccountTypeTest {
	EditConfigurationAccountTypePage editconfigurationAccountTypePage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        editconfigurationAccountTypePage=EditConfigurationAccountTypePage.getPage(driver, EditConfigurationAccountTypePage.class);

    }

    @Test(groups={"Sanity"},description="Edit Configuration Account Type")
    public void userSignin() throws IOException{

    	editconfigurationAccountTypePage.enterLoginID();
    	editconfigurationAccountTypePage.enterPassword();
    	editconfigurationAccountTypePage.selectCompany();
    	editconfigurationAccountTypePage.clickLoginButton();

        editconfigurationAccountTypePage.clickAccountType();
        editconfigurationAccountTypePage.clickAddNewButton();
    	editconfigurationAccountTypePage.enterAccountName();
    	editconfigurationAccountTypePage.enterBillingCycle();
    	editconfigurationAccountTypePage.selectInvoiceDesing();
    	editconfigurationAccountTypePage.clickSaveChangesButton();
    	editconfigurationAccountTypePage.verifyConfirmationMsg();
    	editconfigurationAccountTypePage.clickAccountTypeCreated();
    	editconfigurationAccountTypePage.clickEditAccountTypeCreated();
    	editconfigurationAccountTypePage.enterEditAccountName();
    	editconfigurationAccountTypePage.clickSaveChangesButton();
    	editconfigurationAccountTypePage.verifyConfirmationMsg();

    }
    
    @AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }

}