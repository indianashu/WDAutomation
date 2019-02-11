package mediationTest;

import baseClassPackage.BaseClasses;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;
import mediation.MediationPage;


public class mediation15MediationReaderTest {
	MediationPage mediationPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        mediationPage=MediationPage.getPage(driver, MediationPage.class);

    }

    @Test(groups={"Sanity"},description="Mediation 2.0")
    public void userSignin() throws IOException{

    	mediationPage.enterLoginID();
    	mediationPage.enterPassword();
    	mediationPage.selectCompany();
    	mediationPage.clickLoginButton();
    	
    	mediationPage.clickConfigurationsTab();
    	mediationPage.clickfileFormatTab();
    	mediationPage.clickAddNewButton();
    	mediationPage.enterFormatFile();
    	mediationPage.uploadFileFormatXML();
    	mediationPage.clickSaveChangesButton();
    	
    	mediationPage.clickPluginsLink();
    	mediationPage.clickMediationReader();
    	mediationPage.clickAddNewButton();
    	mediationPage.selectTypeIdMediationReader();
    	mediationPage.enterSufix();
    	mediationPage.enterDateFormat();
    	mediationPage.enterSeparator();
    	mediationPage.clickSavePluginButton();
    	mediationPage.verifyConfirmationMsg();
    	
    }
    
    @AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }

}
