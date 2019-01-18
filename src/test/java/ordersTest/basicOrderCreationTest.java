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
import customer.OrderPage;


public class basicOrderCreationTest {
	OrderPage orderPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        orderPage=OrderPage.getPage(driver, OrderPage.class);

    }

    @Test(groups={"Sanity"},description="Basic Order Creation")
    public void userSignin() throws IOException{

    	/*orderPage.enterLoginID();
    	orderPage.enterPassword();
    	orderPage.selectCompany();
    	orderPage.clickLoginButton();*/

    	orderPage.clickCustomerTab();
    	orderPage.clickAddNewButton();
    	//orderPage.selectUserCompany();
    	orderPage.selectAccountType();
    	orderPage.clickSelectButton();
    	orderPage.enterLoginName();
    	orderPage.selectCurrency();
		orderPage.navigateBottom();
    	orderPage.selectPaymentMethodType();
    	orderPage.enterCCCardholderName();
    	orderPage.enterCCNumber();
    	orderPage.enterCCExpiryDate();
    	orderPage.clickSaveChangesButton();
    	orderPage.verifyConfirmationMsg("Saved Customer Successfully");
    	orderPage.clickCreateOrderButton();
		orderPage.selectPeriod();
		orderPage.selectOrderType();
    	orderPage.selectActiveSince();
    	orderPage.clickProductsSubTab();
    	orderPage.selectProduct();
    	orderPage.enterQuantity();
    	orderPage.clickUpdateButton();
    	orderPage.verifyNewOrder();
    	orderPage.clickSaveChangesButton();
    	orderPage.verifyConfirmationMsg("Saved Order Successfully");
    	orderPage.clickEditOrderButton();
    	orderPage.clickChangeLog();
    	orderPage.clickSelectedProduct();
    	orderPage.clickChangeButton();
    	orderPage.enterChangeQty();
    	orderPage.clickSaveChangesButton();
    	orderPage.verifyConfirmationMsg("Order Updated Successfully");
    	
    }
    
    @AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }

}
