package collectionsTest;

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
import collections.CollectionConfigurationPage;


public class runningCollectionToCheckStatusChangeTest {
	CollectionConfigurationPage collectionConfigurationPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        collectionConfigurationPage=CollectionConfigurationPage.getPage(driver, CollectionConfigurationPage.class);

    }

    @Test(groups={"Sanity"},description="Running collection to see changed status of Customer.")
    public void userSignin() throws IOException{
/*
    	collectionConfigurationPage.enterLoginID();
    	collectionConfigurationPage.enterPassword();
    	collectionConfigurationPage.selectCompany();
    	collectionConfigurationPage.clickLoginButton();
*/
    	collectionConfigurationPage.clickCustomerTab();
    	collectionConfigurationPage.clickBillingCustomer2();
    	collectionConfigurationPage.clickEditButton();
    	collectionConfigurationPage.navigateBottom();
    	collectionConfigurationPage.enterCardNumber();
    	collectionConfigurationPage.clickSaveChangesButton();
    	collectionConfigurationPage.verifyConfirmationMsg();
    	collectionConfigurationPage.clickConfigurationTab();
    	collectionConfigurationPage.clickCollectionsLink();
    	collectionConfigurationPage.enterRunCollectionDate();
    	collectionConfigurationPage.clickRunCollectionsButton();
    	collectionConfigurationPage.clickRunCollectionsPopup();
    	collectionConfigurationPage.clickCustomerTab();
    	collectionConfigurationPage.clickBillingCustomer1();
    	collectionConfigurationPage.verifyBillingCustomer1Status();
    	collectionConfigurationPage.clickBillingCustomer2();
    	collectionConfigurationPage.verifyBillingCustomer2Status();
    	collectionConfigurationPage.clickConfigurationTab();
    	collectionConfigurationPage.clickCollectionsLink();
    	collectionConfigurationPage.enterRunCollectionDate1();
    	collectionConfigurationPage.clickRunCollectionsButton();
    	collectionConfigurationPage.clickRunCollectionsPopup();
    	collectionConfigurationPage.clickCustomerTab();
    	collectionConfigurationPage.clickBillingCustomer1();
    	collectionConfigurationPage.verifyBillingCustomer1Status();
    	collectionConfigurationPage.clickBillingCustomer2();
    	collectionConfigurationPage.verifyBillingCustomer2Status1();
    	collectionConfigurationPage.clickConfigurationTab();
    	collectionConfigurationPage.clickCollectionsLink();
    	collectionConfigurationPage.enterRunCollectionDate2();
    	collectionConfigurationPage.clickRunCollectionsButton();
    	collectionConfigurationPage.clickRunCollectionsPopup();
    	collectionConfigurationPage.clickCustomerTab();
    	collectionConfigurationPage.clickBillingCustomer1();
    	collectionConfigurationPage.verifyBillingCustomer1Status();
    	collectionConfigurationPage.clickBillingCustomer2();
    	collectionConfigurationPage.verifyBillingCustomer2Status2();
    	collectionConfigurationPage.clickConfigurationTab();
    	collectionConfigurationPage.clickCollectionsLink();
    	collectionConfigurationPage.enterRunCollectionDate3();
    	collectionConfigurationPage.clickRunCollectionsButton();
    	collectionConfigurationPage.clickRunCollectionsPopup();
    	collectionConfigurationPage.clickCustomerTab();
    	collectionConfigurationPage.clickBillingCustomer1();
    	collectionConfigurationPage.verifyBillingCustomer1Status();
    	collectionConfigurationPage.clickBillingCustomer2();
    	collectionConfigurationPage.verifyBillingCustomer2Status3();
    	
    }

    @AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }
}

