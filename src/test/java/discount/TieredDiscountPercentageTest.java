package discount;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClassPackage.BaseClasses;
import utilPackages.PropertyValExtractors;

public class TieredDiscountPercentageTest {
	DiscountScenarioPage discountPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		discountPage = DiscountScenarioPage.getPage(driver, DiscountScenarioPage.class);

	}

	@Test(groups = { "Discount Feature" }, description = "Create Tiered Discount Percentage Orders")
	public void userSignin() throws Exception {

		/*discountPage.enterLoginID();
		discountPage.enterPassword();
		discountPage.selectCompany();
		discountPage.clickLoginButton();*/
		
		discountPage.clickCustomerTab();
		discountPage.enterCustomerNameFilter(1);
		discountPage.applyFilter();
		discountPage.selectCustomer(1);
		discountPage.clickCreateOrderButton();
		discountPage.clickProductSubTab();
		discountPage.selectPricingProduct(0);
		discountPage.clickDiscountSubTab();
		discountPage.selectDiscount(1);
		discountPage.verifyErrorMessage();
		discountPage.selectDiscountableItem(0);
		discountPage.clickUpdateButton();
		discountPage.clickSaveChangesButton();
		discountPage.verifyConfirmationMsg("Saved Subscription Order Successfully For Tiered Discount Percentage");

		for (int rowNum = 0; rowNum < 5; rowNum++) {
			discountPage.clickCustomerTab();
			discountPage.enterCustomerNameFilter(1);
			discountPage.applyFilter();
			discountPage.selectCustomer(1);
			discountPage.clickCreateOrderButton();
			discountPage.clickProductSubTab();
			discountPage.selectProduct(0);
			discountPage.enterQuantity(rowNum);
			discountPage.clickUpdateButton();
			discountPage.verifyTotalAmount(9,rowNum);
			discountPage.clickSaveChangesButton();
			discountPage.verifyConfirmationMsg("Saved Order Successfully For Tiered Discount Percentage");
		}
	}
}
