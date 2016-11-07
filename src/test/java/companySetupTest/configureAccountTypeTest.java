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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;
import utilPackages.WaitClass;
import companySetUp.ConfigurationAccountTypePage;


public class configureAccountTypeTest {
	ConfigurationAccountTypePage configurationAccountTypePage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        WaitClass.waitForUrl(driver, url, 10);
        configurationAccountTypePage=configurationAccountTypePage.getPage(driver, ConfigurationAccountTypePage.class);

    }

    @Test(groups={"Sanity"},description="Login",priority = 1)
    public void userSignin() throws IOException{
    	configurationAccountTypePage.enterLoginID();
    	configurationAccountTypePage.enterPassword();
    	configurationAccountTypePage.selectCompany();
    	configurationAccountTypePage.clickLoginButton();
    	configurationAccountTypePage.clickConfigurationTab();
    	configurationAccountTypePage.clickAccountType();
    	configurationAccountTypePage.clickAddNewButton();
    	configurationAccountTypePage.enterAccountName();
    	configurationAccountTypePage.enterBillingCycle();
    	configurationAccountTypePage.selectInvoiceDesing();
    	configurationAccountTypePage.clickSaveChangesButton();
    	configurationAccountTypePage.verifyConfirmationMsg();


    }

}
