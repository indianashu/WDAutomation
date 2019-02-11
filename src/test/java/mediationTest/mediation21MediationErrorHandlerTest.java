package mediationTest;

import baseClassPackage.BaseClasses;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;
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
        //WaitClass.waitForUrl(driver, url, 10);
        mediationPage=MediationPage.getPage(driver, MediationPage.class);

    }

    @Test(groups={"Sanity"},description="Mediation 2.2")
    public void userSignin() throws IOException{

    	/*mediationPage.enterLoginID();
    	mediationPage.enterPassword();
    	mediationPage.selectCompany();
    	mediationPage.clickLoginButton();*/

    	mediationPage.clickPluginsLink();
    	mediationPage.clickMediationErrorHandler();
    	mediationPage.clickAddNewButton();
    	mediationPage.selectTypeIdMediationErrorHandler();
    	mediationPage.clickSavePluginButton();
    	mediationPage.verifyConfirmationMsg();
    	
    }
    
    @AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }

}
