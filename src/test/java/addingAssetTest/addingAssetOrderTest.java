package addingAssetTest;

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
import assets.AddingAssetPage;


public class addingAssetOrderTest {
	AddingAssetPage addingAssetPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        WaitClass.waitForUrl(driver, url, 10);
        addingAssetPage=AddingAssetPage.getPage(driver, AddingAssetPage.class);

    }

    @Test(groups={"Sanity"},description="Adding Asset to Order Test Case")
    public void userSignin() throws IOException{
    	addingAssetPage.enterLoginID();
    	addingAssetPage.enterPassword();
    	addingAssetPage.selectCompany();
    	addingAssetPage.clickLoginButton();
    	addingAssetPage.clickCustomersTab();
    	addingAssetPage.clickAddNewButton();
    	addingAssetPage.selectUserCompany();
    	addingAssetPage.selectAccountType();
    	addingAssetPage.clickSelectButton();
    	addingAssetPage.enterCustomerLoginName();
    	addingAssetPage.clickSaveChangesButton();
    	addingAssetPage.verifyConfirmationMsg();
    	addingAssetPage.clickCustomerA();
    	addingAssetPage.clickCreateOrderButton();
    	addingAssetPage.selectPeriod();
    	addingAssetPage.selectOrderType();
    	addingAssetPage.selectActiveSince();
    	addingAssetPage.clickProductSubTab();
    	addingAssetPage.selectProduct();
    	addingAssetPage.clickAssetCheckbox();
    	addingAssetPage.clickAddSelectedButton();
    	addingAssetPage.clickAddToOrderButton();
    	addingAssetPage.verifyAddedAsset();
    	addingAssetPage.clickUpdateButton();
    	addingAssetPage.navigateBottom();
    	addingAssetPage.clickSaveChangesButton();
    	addingAssetPage.verifyAssetOrderPreview();
    	addingAssetPage.clickProductsTab();
    	addingAssetPage.clickProductCategory();
    	addingAssetPage.selectProduct();
    	addingAssetPage.clickShowAssetsButton();
    	addingAssetPage.verifyAssetStatus();
    }

    @AfterClass(alwaysRun=true)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }
}

