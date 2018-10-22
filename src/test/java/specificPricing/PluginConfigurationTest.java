 package specificPricing;

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
import specificPricing.PluginConfigurationPage;

public class PluginConfigurationTest {
	
	PluginConfigurationPage pluginPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        pluginPage=PluginConfigurationPage.getPage(driver, PluginConfigurationPage.class);

    }
    @Test(groups={"Specific Pricing Feature"},description="Mediation 2.0")
    public void userSignin() throws IOException{

    	pluginPage.enterLoginID();
    	pluginPage.enterPassword();
    	pluginPage.selectCompany();
    	pluginPage.clickLoginButton();
    	
    	pluginPage.clickFileFormatLink();
    	pluginPage.clickAddNewButton();
    	pluginPage.enterName();
    	pluginPage.uploadFile();
    	pluginPage.clickSaveChangesButton();
    	pluginPage.clickUpdateChangesButton();
    	
    	pluginPage.clickPluginsLink();
    	pluginPage.clickMediationReader();
    	pluginPage.clickAddNewButton();
    	pluginPage.selectTypeIdMediationReader();
    	pluginPage.enterSufix();
    	pluginPage.enterDateFormat();
    	pluginPage.enterSeparator();
    	pluginPage.clickSavePluginButton();
    	pluginPage.verifyConfirmationMsg();
    	
    	String ItemId = pluginPage.fetchDefaultItemID();
    	pluginPage.clickPluginsLink();
    	pluginPage.clickMediationProcessor();
    	pluginPage.clickAddNewButton();
    	pluginPage.selectTypeIdMediationProcessor();
    	pluginPage.enterDefaultItemIDMediationProcessor(ItemId);
    	pluginPage.clickSavePluginButton();
    	pluginPage.verifyConfirmationMsg();
    }
}
