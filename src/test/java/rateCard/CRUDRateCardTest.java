package rateCard;

import baseClassPackage.BaseClasses;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;
import rateCard.CRUDRateCardPage;

public class CRUDRateCardTest {
	CRUDRateCardPage createRateCardPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        createRateCardPage=CRUDRateCardPage.getPage(driver, CRUDRateCardPage.class);

    }
    @Test(groups={"RateCard"},description="CRUD operation of the Rate Card")
    public void userSignin() throws Exception{
    	
    	createRateCardPage.enterLoginName();
    	createRateCardPage.enterPassword();
    	createRateCardPage.selectCompany();
    	createRateCardPage.clickLoginButton();
    	
    	createRateCardPage.selectRateCardConfig();
    	createRateCardPage.clickAddNewButton();
    	createRateCardPage.enterRateCardName(3);
    	createRateCardPage.enterRateCardPrice();
    	createRateCardPage.uploadRatingCSVFile();
    	createRateCardPage.clickLoginButton();
    	createRateCardPage.verifyConfirmationMsg();
    	
    	createRateCardPage.selectRateCard(3);
    	createRateCardPage.navigateBottom();
    	createRateCardPage.clickEditButton();
    	createRateCardPage.enterRateCardName(4);
    	createRateCardPage.rateCardRateConsumptionUnit();
    	createRateCardPage.mediatedQuantityConsumptionUnit();
    	createRateCardPage.consumptionUnit();
    	createRateCardPage.clickLoginButton();
    	createRateCardPage.verifyConfirmationMsg();
    	
    	createRateCardPage.selectRateCard(4);
    	createRateCardPage.navigateBottom();
    	createRateCardPage.clickDeleteButton();
    	createRateCardPage.clickYesDeleteInvoicePopup();
    	createRateCardPage.verifyConfirmationMsg();
    }
}
