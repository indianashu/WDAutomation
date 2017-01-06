package tearDownTest;

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
import tearDown.TearDownProcessPage;


public class tearDownProcessTest {
	TearDownProcessPage tearDownProcessPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        WaitClass.waitForUrl(driver, url, 10);
        tearDownProcessPage=TearDownProcessPage.getPage(driver, TearDownProcessPage.class);

    }

    @Test(groups={"Sanity"},description="Tear Down Process")
    public void userSignin() throws IOException{
    	tearDownProcessPage.enterLoginID();
    	tearDownProcessPage.enterPassword();
    	tearDownProcessPage.selectCompany();
    	tearDownProcessPage.clickLoginButton();
    	tearDownProcessPage.clickPaymentsTab();
    	tearDownProcessPage.clickCustomerA();
    	tearDownProcessPage.clickUnlink();
    	tearDownProcessPage.clickYesPopup();
    	tearDownProcessPage.verifyPaymentUnlinkedSuccessfully();
    	tearDownProcessPage.clickInvoicesTab();
    	tearDownProcessPage.clickCustomerB();
    	tearDownProcessPage.clickDeleteInvoiceButton();
    	tearDownProcessPage.clickYesDeleteInvoiceProductPopup();
    	tearDownProcessPage.clickOrdersTab();
    	tearDownProcessPage.clickCustomerC();
    	tearDownProcessPage.clickDeleteButton();
    	tearDownProcessPage.clickProductsTab();
    	tearDownProcessPage.clickProductCategory();
    	tearDownProcessPage.clickProduct();
    	tearDownProcessPage.verifyNoProducts();
    	tearDownProcessPage.clickDeleteCategoryButton();
    	tearDownProcessPage.clickDeleteYesCategoryPopup();
    	tearDownProcessPage.clickCustomersTab();
    	tearDownProcessPage.clickCustomerA();
    	tearDownProcessPage.clickDeleteButton();
    	tearDownProcessPage.clickDeleteYesCustomerPopup();
    	
    	
    }
    
    @AfterClass(alwaysRun=true)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }

}
