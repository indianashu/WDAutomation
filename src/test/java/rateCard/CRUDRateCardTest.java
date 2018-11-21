package rateCard;

import baseClassPackage.BaseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;
import utilPackages.WaitClass;
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
    	createRateCardPage.enterRateCardName();
    	createRateCardPage.enterRateCardPrice();
    	createRateCardPage.uploadRatingCSVFile();
    	createRateCardPage.clickLoginButton();
    	createRateCardPage.verifyConfirmationMsg();
    	
    	createRateCardPage.selectRateCard();
    	createRateCardPage.navigateBottom();
    	createRateCardPage.clickEditButton();
    	createRateCardPage.enterRateCardName();
    	createRateCardPage.rateCardRateConsumptionUnit();
    	createRateCardPage.mediatedQuantityConsumptionUnit();
    	createRateCardPage.clickLoginButton();
    	createRateCardPage.verifyConfirmationMsg();
    	
    	createRateCardPage.selectRateCard();
    	createRateCardPage.navigateBottom();
    	createRateCardPage.clickDeleteButton();
    	createRateCardPage.clickYesDeleteInvoicePopup();
    	createRateCardPage.verifyConfirmationMsg();
    }
}
