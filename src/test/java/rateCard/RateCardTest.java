package rateCard;

import baseClassPackage.BaseClasses;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;
import rateCard.RateCardPage;

public class RateCardTest {
	RateCardPage rateCardPage;
    WebDriver driver,driver2;
	
	@BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        rateCardPage=RateCardPage.getPage(driver, RateCardPage.class);

    }
	
	@Test(groups={"RateCard"},description="Test Cases of the Rate Card")
    public void userSignin() throws Exception{
		/*rateCardPage.enterLoginName();
		rateCardPage.enterPassword();
		rateCardPage.selectCompany();
		rateCardPage.clickLoginButton();*/
		
		rateCardPage.selectRateCardConfig();
		int row = 0 ;
		while (row <= 4) {
			rateCardPage.clickAddNewButton();
			rateCardPage.enterRateCardName(row);
			rateCardPage.enterRateCardPrice();
			rateCardPage.uploadRatingCSVFile(row);
			rateCardPage.clickLoginButton();
			rateCardPage.verifyConfirmationMsg(row);
			row++;
		}
		
	}
	
	@AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }
}
