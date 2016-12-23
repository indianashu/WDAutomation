package mediationTest;

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
import mediation.MediationPage;


public class mediation21MediationErrorHandlerTest {
	MediationPage mediationPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        WaitClass.waitForUrl(driver, url, 10);
        mediationPage=MediationPage.getPage(driver, MediationPage.class);

    }

    @Test(groups={"Sanity"},description="Mediation 2.2")
    public void userSignin() throws IOException{
    	mediationPage.enterLoginID();
    	mediationPage.enterPassword();
    	mediationPage.selectCompany();
    	mediationPage.clickLoginButton();
    	mediationPage.clickConfigurationsTab();
    	mediationPage.clickPluginsLink();
    	mediationPage.clickMediationErrorHandler();
    	mediationPage.clickAddNewButton();
    	mediationPage.selectTypeIdMediationErrorHandler();
    	mediationPage.enterOrderMediationErrorHandler();
    	mediationPage.clickSavePluginButton();
    	mediationPage.verifyConfirmationMsg();
    	
    }
    
    @AfterClass(alwaysRun=true)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }

}
