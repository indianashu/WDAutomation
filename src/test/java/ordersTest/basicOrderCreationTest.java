package ordersTest;

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
import customer.AddingAssetPage;


public class basicOrderCreationTest {
	AddingAssetPage addingAssetPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        addingAssetPage=AddingAssetPage.getPage(driver, AddingAssetPage.class);

    }

    @Test(groups={"Sanity"},description="Basic Order Creation")
    public void userSignin() throws IOException{

    	/*addingAssetPage.enterLoginID();
    	addingAssetPage.enterPassword();
    	addingAssetPage.selectCompany();
    	addingAssetPage.clickLoginButton();*/

    	addingAssetPage.clickCustomerTab();
    	addingAssetPage.clickAddNewButton();
    	//addingAssetPage.selectUserCompany();
    	addingAssetPage.selectAccountType();
    	addingAssetPage.clickSelectButton();
    	addingAssetPage.enterLoginName();
    	addingAssetPage.selectCurrency();
		addingAssetPage.navigateBottom();
    	addingAssetPage.selectPaymentMethodType();
    	addingAssetPage.enterCCCardholderName();
    	addingAssetPage.enterCCNumber();
    	addingAssetPage.enterCCExpiryDate();
    	addingAssetPage.clickSaveChangesButton();
    	addingAssetPage.verifyConfirmationMsg();
    	addingAssetPage.clickCreateOrderButton();
		addingAssetPage.selectPeriod();
		addingAssetPage.selectOrderType();
    	addingAssetPage.selectActiveSince();
    	addingAssetPage.clickProductsSubTab();
    	addingAssetPage.selectProduct();
    	addingAssetPage.enterQuantity();
    	addingAssetPage.clickUpdateButton();
    	addingAssetPage.verifyNewOrder();
    	addingAssetPage.clickSaveChangesButton();
    	addingAssetPage.verifyConfirmationMsg();
    	addingAssetPage.clickEditOrderButton();
    	addingAssetPage.clickChangeLog();
    	addingAssetPage.clickSelectedProduct();
    	addingAssetPage.clickChangeButton();
    	addingAssetPage.enterChangeQty();
    	addingAssetPage.clickSaveChangesButton();
    	addingAssetPage.verifyConfirmationMsg();
    	
    }
    
    @AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }

}
