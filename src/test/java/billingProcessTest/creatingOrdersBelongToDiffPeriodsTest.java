package billingProcessTest;

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
import billingProcess.CreatingOrdersPage;


public class creatingOrdersBelongToDiffPeriodsTest {
	CreatingOrdersPage creatingOrdersPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        creatingOrdersPage=CreatingOrdersPage.getPage(driver, CreatingOrdersPage.class);

    }

    @Test(groups={"Sanity"},description="Creating Orders Belonging to Different Periods")
    public void userSignin() throws IOException{

    	/*creatingOrdersPage.enterLoginID();
    	creatingOrdersPage.enterPassword();
    	creatingOrdersPage.selectCompany();
    	creatingOrdersPage.clickLoginButton();*/

    	creatingOrdersPage.clickProductsTab();
    	creatingOrdersPage.clickAddCategoryButton();
    	creatingOrdersPage.enterProductCategoryName();
    	creatingOrdersPage.clickSaveChangesButton();
    	creatingOrdersPage.verifyConfirmationMsg("Saved Category Successfully");
    	creatingOrdersPage.clickProductCategoryName();
    	creatingOrdersPage.clickAddProductButton();
    	creatingOrdersPage.enterProductDescription();
    	creatingOrdersPage.enterProductCode();
    	creatingOrdersPage.selectPriceCurrency();
		creatingOrdersPage.navigateBottom();
    	creatingOrdersPage.enterPriceDate();
    	creatingOrdersPage.enterPriceRate();
		creatingOrdersPage.clickAddPriceButton();
    	creatingOrdersPage.clickSaveChangesButton();
    	creatingOrdersPage.verifyConfirmationMsg("Saved Product Successfully");
    	//creatingOrdersPage.clickProductsTab();
    	creatingOrdersPage.clickProductCategoryName();
    	creatingOrdersPage.clickAddProductButton();
    	creatingOrdersPage.enterProductDescription1();
    	creatingOrdersPage.enterProductCode1();
		creatingOrdersPage.navigateBottom();
    	creatingOrdersPage.enterPriceDate1();
    	creatingOrdersPage.selectPriceCurrency();
    	creatingOrdersPage.enterPriceRate1();
		creatingOrdersPage.clickAddPriceButton();
    	creatingOrdersPage.clickSaveChangesButton();
    	creatingOrdersPage.verifyConfirmationMsg("Saved Product Successfully");
    	creatingOrdersPage.clickCustomerTab();
    	creatingOrdersPage.enterCustomerNameFilter(12);
    	creatingOrdersPage.applyFilter();
    	creatingOrdersPage.clickCustomer1(12);
    	creatingOrdersPage.clickCreateOrderButton();
    	creatingOrdersPage.selectActiveSince();
    	creatingOrdersPage.clickProductSubTab();
    	creatingOrdersPage.selectProduct();
    	creatingOrdersPage.enterQuantity();
    	creatingOrdersPage.clickUpdateButton();
    	creatingOrdersPage.clickSaveChangesButton();
    	creatingOrdersPage.verifyConfirmationMsg("Saved Order Successfully");
    	creatingOrdersPage.clickCustomerTab();
    	creatingOrdersPage.enterCustomerNameFilter(12);
    	creatingOrdersPage.applyFilter();
    	creatingOrdersPage.clickCustomer1(12);
    	creatingOrdersPage.clickCreateOrderButton();
    	creatingOrdersPage.selectPeriod1();
    	creatingOrdersPage.selectOrderType1();
    	creatingOrdersPage.selectActiveSince1();
    	creatingOrdersPage.clickProductSubTab();
    	creatingOrdersPage.selectProduct1();
    	creatingOrdersPage.enterQuantity1();
    	creatingOrdersPage.clickUpdateButton();
    	creatingOrdersPage.clickSaveChangesButton();
    	creatingOrdersPage.verifyConfirmationMsg("Saved Order Successfully");
    	creatingOrdersPage.clickCustomerTab();
    	creatingOrdersPage.enterCustomerNameFilter(23);
    	creatingOrdersPage.applyFilter();
    	creatingOrdersPage.clickCustomer1(23);
    	creatingOrdersPage.clickCreateOrderButton();
    	creatingOrdersPage.selectPeriod2();
    	creatingOrdersPage.selectOrderType2();
    	creatingOrdersPage.selectActiveSince3();
    	creatingOrdersPage.clickProductSubTab();
    	creatingOrdersPage.selectProduct2a();
    	creatingOrdersPage.enterQuantity2();
    	creatingOrdersPage.clickUpdateButton();
    	creatingOrdersPage.clickProductSubTab();
    	creatingOrdersPage.selectProduct1();
    	creatingOrdersPage.enterQuantity3();
    	creatingOrdersPage.clickUpdateButton2();
    	creatingOrdersPage.clickSaveChangesButton();
    	creatingOrdersPage.verifyConfirmationMsg("Saved Order Successfully");

    }

    @AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }
}

