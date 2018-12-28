package customerTest;

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
import customer.ImpersonateCustomerPage;


public class impersonateCustomerTest {
	ImpersonateCustomerPage impersonateCustomerPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        impersonateCustomerPage=ImpersonateCustomerPage.getPage(driver, ImpersonateCustomerPage.class);

    }

    @Test(groups={"Sanity"},description="Impersonate a Customer")
    public void userSignin() throws IOException{

    	/*impersonateCustomerPage.enterLoginID();
    	impersonateCustomerPage.enterPassword();
    	impersonateCustomerPage.selectCompany();
    	impersonateCustomerPage.clickLoginButton();*/

    	impersonateCustomerPage.clickCustomerTab();
    	impersonateCustomerPage.enterCustomerNameFilter();
    	impersonateCustomerPage.applyFilter();
    	impersonateCustomerPage.selectCustomer();
    	impersonateCustomerPage.clickImpersonateUserImage();
    	impersonateCustomerPage.verifyCustomerName();
        impersonateCustomerPage.selectCustomer();
    	impersonateCustomerPage.clickResumeAsAdmin();
    	impersonateCustomerPage.verifyAdminLogin();
    }
    
    @AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }

}
