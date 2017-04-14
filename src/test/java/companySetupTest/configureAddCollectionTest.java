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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;
import utilPackages.WaitClass;
import companySetUp.ConfigurationCollectionsPage;


public class configureAddCollectionTest {
	ConfigurationCollectionsPage configurationCollectionsPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        configurationCollectionsPage=ConfigurationCollectionsPage.getPage(driver, ConfigurationCollectionsPage.class);

    }

    @Test(groups={"Sanity"},description="Configure Add Collection")
    public void userSignin() throws IOException{
/*
    	configurationCollectionsPage.enterLoginID();
    	configurationCollectionsPage.enterPassword();
    	configurationCollectionsPage.selectCompany();
    	configurationCollectionsPage.clickLoginButton();
*/
		//configurationCollectionsPage.clickConfigurationTab();
    	configurationCollectionsPage.clickCollections();
    	configurationCollectionsPage.enterIDSteps();
    	configurationCollectionsPage.enterForDays();
    	configurationCollectionsPage.selectPaymentCheckbox();
    	configurationCollectionsPage.enterIDSteps1();
    	configurationCollectionsPage.enterForDays1();
    	configurationCollectionsPage.selectNotificationCheckbox();
    	configurationCollectionsPage.enterIDSteps2();
    	configurationCollectionsPage.enterForDays2();
    	configurationCollectionsPage.selectPaymentCheckbox1();
        configurationCollectionsPage.enterIDSteps3();
    	configurationCollectionsPage.enterForDays3();
    	configurationCollectionsPage.selectSuspendCheckbox1();
    	String gracePeriodId = configurationCollectionsPage.clickSaveChangesButton();
    	configurationCollectionsPage.verifyConfirmationMsg();
		configurationCollectionsPage.clickPluginsLink();
		configurationCollectionsPage.clickCategory17();
		configurationCollectionsPage.clickAddNewButton();
		configurationCollectionsPage.selectTypeID();
		configurationCollectionsPage.enterLeftAttribute();
		configurationCollectionsPage.enterRightAttribute(gracePeriodId);
		configurationCollectionsPage.clickPlusIcon();
		configurationCollectionsPage.clickSavePluginButton();

    }
    
    @AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }
}