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
import companySetUp.ConfigurationBillingProcessPage;


public class configureAddBillingPeriodTest {
	ConfigurationBillingProcessPage configurationBillingProcessPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        WaitClass.waitForUrl(driver, url, 10);
        configurationBillingProcessPage=configurationBillingProcessPage.getPage(driver, ConfigurationBillingProcessPage.class);

    }

    @Test(groups={"Sanity"},description="Login",priority = 1)
    public void userSignin() throws IOException{
    	configurationBillingProcessPage.enterLoginID();
    	configurationBillingProcessPage.enterPassword();
    	configurationBillingProcessPage.selectCompany();
    	configurationBillingProcessPage.clickLoginButton();
    	configurationBillingProcessPage.clickConfigurationTab();
    	configurationBillingProcessPage.clickBillingProcess();
    	configurationBillingProcessPage.enterNextRunDate();
    	configurationBillingProcessPage.selectGenerateReport();
    	configurationBillingProcessPage.selectBillingPeriod();
    	configurationBillingProcessPage.enterMaxPeriodInvoice();
    	configurationBillingProcessPage.selectNeverProrate();
    	configurationBillingProcessPage.clickSaveChangesButton();
    	configurationBillingProcessPage.verifyConfirmationMsg();


    }

}
