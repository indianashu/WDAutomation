package specificPricing;

import baseClassPackage.BaseClasses;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;
import specificPricing.MediationConfigurationPage;

public class MediationConfigurationTest {
	
	MediationConfigurationPage mediationPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        mediationPage=MediationConfigurationPage.getPage(driver, MediationConfigurationPage.class);
    }
        
        @Test(groups={"Specific Pricing Feature"},description="AddCategory")
        public void userSignin() throws IOException{

        	/*mediationPage.enterLoginID();
        	mediationPage.enterPassword();
        	mediationPage.selectCompany();
        	mediationPage.clickLoginButton();*/
        	
        	mediationPage.clickPluginsLink();
        	mediationPage.clickMediationReader();
        	mediationPage.clickAddNewButton();
        	mediationPage.selectReaderType(0);
        	mediationPage.selectFileFormat();
        	mediationPage.enterSufix();
        	mediationPage.enterDateFormat();
        	mediationPage.enterSeparator();
        	mediationPage.clickSavePluginButton();
        	mediationPage.verifyConfirmationMsg();
        	
        	String ItemId = mediationPage.fetchDefaultItemID();
        	mediationPage.clickPluginsLink();
        	mediationPage.clickMediationProcessor();
        	mediationPage.clickAddNewButton();
        	mediationPage.selectReaderType(1);
        	mediationPage.enterDefaultItemIDMediationProcessor(ItemId);
        	mediationPage.clickSavePluginButton();
        	mediationPage.verifyConfirmationMsg();
        	
        	mediationPage.clickMediationLink();
        	mediationPage.clickAddNewButton();
        	mediationPage.enterConfigurationName();
        	mediationPage.enterExecutionOrder();
        	mediationPage.clickSaveChangesButton();
        	
        }
}
