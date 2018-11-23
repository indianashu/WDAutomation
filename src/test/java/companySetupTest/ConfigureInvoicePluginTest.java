package companySetupTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClassPackage.BaseClasses;
import companySetUp.ConfigureInvoicePluginPage;
import utilPackages.PropertyValExtractors;

public class ConfigureInvoicePluginTest {
	ConfigureInvoicePluginPage configureInvoicePluginPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        configureInvoicePluginPage=ConfigureInvoicePluginPage.getPage(driver, ConfigureInvoicePluginPage.class);
    }
    @Test(groups={"Sanity"},description="Configure Invoice Designs")
    public void userSignin() throws IOException{

    	/*configureInvoicePluginPage.enterLoginID();
    	configureInvoicePluginPage.enterPassword();
    	configureInvoicePluginPage.selectCompany();
    	configureInvoicePluginPage.clickLoginButton();*/
    	
    	configureInvoicePluginPage.clickPluginsLink();
    	configureInvoicePluginPage.clickNotificationPlugin();
    	configureInvoicePluginPage.selectPDFPlugin();
    	configureInvoicePluginPage.clickEditPlugin();
    	configureInvoicePluginPage.selectInvoice();
    	configureInvoicePluginPage.enterSQLField();
    	configureInvoicePluginPage.enterTrue();
    	//configureInvoicePluginPage.clickPlusButton();
    	configureInvoicePluginPage.clickSavePluginButton();
    	configureInvoicePluginPage.verifyConfirmationMsg();
    	
    }
    
    @AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }
    
}
