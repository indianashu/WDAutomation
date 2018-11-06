package specificPricing;

import baseClassPackage.BaseClasses;
import productDependency.CreateOrderPeriodPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class CreateRateCardTest {

	CreateRateCardPage ratecardPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		ratecardPage = CreateRateCardPage.getPage(driver, CreateRateCardPage.class);
	}

	@Test(groups = { "Specific Pricing Feature" }, description = "Create Rate Card")
	public void userSignin() throws Exception {

		ratecardPage.enterLoginID();
		ratecardPage.enterPassword();
		ratecardPage.selectCompany();
		ratecardPage.clickLoginButton();

		ratecardPage.clickRateCards();
		ratecardPage.clickAddNewButton();
		ratecardPage.enterRateCardName(0);
		ratecardPage.enterPriceColumn();
		ratecardPage.uploadRatingCSVFile(0);
		ratecardPage.clickSaveChangesButton();
		ratecardPage.verifyConfirmationMsg();
		ratecardPage.selectRateCard(0);
		ratecardPage.clickEdit();
		ratecardPage.rateCardRateConsumptionUnit();
		ratecardPage.mediatedQuantityConsumptionUnit();
		ratecardPage.clickSaveChangesButton();
		ratecardPage.verifyRateCardData(0);
		
		ratecardPage.clickAddNewButton();
		ratecardPage.enterRateCardName(1);
		ratecardPage.enterPriceColumn();
		ratecardPage.uploadRatingCSVFile(1);
		ratecardPage.clickSaveChangesButton();
		ratecardPage.verifyConfirmationMsg();
		ratecardPage.selectRateCard(1);
		ratecardPage.clickEdit();
		ratecardPage.rateCardRateConsumptionUnit();
		ratecardPage.mediatedQuantityConsumptionUnit();
		ratecardPage.clickSaveChangesButton();
		ratecardPage.verifyRateCardData(1);
	}
}
