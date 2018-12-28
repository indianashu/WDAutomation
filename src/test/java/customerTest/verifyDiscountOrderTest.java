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
import customer.DiscountPage;


public class verifyDiscountOrderTest {
	DiscountPage discountPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        discountPage=DiscountPage.getPage(driver, DiscountPage.class);

    }

    @Test(groups={"Sanity"},description="Verify Order Discount")
    public void userSignin() throws IOException{

    	/*discountPage.enterLoginID();
    	discountPage.enterPassword();
    	discountPage.selectCompany();
    	discountPage.clickLoginButton();*/

    	discountPage.clickDiscountTab();
    	discountPage.clickAddNewButton();
		discountPage.clickSaveChangesButton();
    	discountPage.verifyErrorMsg();
    	discountPage.enterDiscountDescription();
    	discountPage.enterDiscountCode();
    	discountPage.selectDiscountType();
    	discountPage.enterDiscountRate();
    	discountPage.clickSaveChangesButton();
    	discountPage.verifyConfirmationMsg();
		discountPage.createPlanCategory();
        discountPage.createPlanTypeProduct();
    	discountPage.clickCustomersTab();
    	discountPage.enterCustomerNameFilter();
    	discountPage.applyFilter();
    	discountPage.clickCustomerA();
    	discountPage.clickCreateOrderButton();
    	discountPage.clickProductSubTab();
    	discountPage.selectProduct();
    	discountPage.clickDiscountSubTab();
    	discountPage.selectDiscount();
    	discountPage.verifyErrorMessage();
    	discountPage.selectDiscountableItem();
    	discountPage.clickUpdateButton();
    	discountPage.clickSaveChangesButton();
    	discountPage.verifyConfirmationMsg();
    	discountPage.clickCustomersTab();
    	discountPage.clickCustomerA();
    	discountPage.clickCreateOrderButton();
    	discountPage.clickProductSubTab();
    	discountPage.selectProduct1();
    	discountPage.clickUpdateButton();
    	discountPage.verifyAmount();
    	discountPage.clickSaveChangesButton();

    }
    
    @AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }

}
