package discount;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClassPackage.BaseClasses;
import discount.DiscountPage;
import utilPackages.PropertyValExtractors;

public class CreateDiscountTest {
	DiscountPage discountPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		discountPage = DiscountPage.getPage(driver, DiscountPage.class);

	}

	@Test(groups = { "Discount Feature" }, description = "Create Discount")
	public void userSignin() throws Exception {

		/*discountPage.enterLoginID();
		discountPage.enterPassword();
		discountPage.selectCompany();
		discountPage.clickLoginButton();*/

		// Tiered Discount
		discountPage.clickDiscountTab();
		discountPage.clickAddNewButton();
		discountPage.enterDiscountDescription(1);
		discountPage.enterDiscountCode(1);
		discountPage.selectDiscountType();
		discountPage.selectTierRadioButton();
		discountPage.fillTierData();
		discountPage.clickSaveChangesButton();
		discountPage.verifyConfirmationMsg("Saved Tiered Discount Successfully");
		discountPage.verifyDiscountName(1);

		// Tiered Percentage Discount
		discountPage.clickDiscountTab();
		discountPage.clickAddNewButton();
		discountPage.enterDiscountDescription(2);
		discountPage.enterDiscountCode(2);
		discountPage.selectDiscountType();
		discountPage.checkPercentage();
		discountPage.selectTierRadioButton();
		discountPage.fillTierData();
		discountPage.clickSaveChangesButton();
		discountPage.verifyConfirmationMsg("Saved Tiered Percentage Discount Successfully");
		discountPage.verifyDiscountName(2);
		
		// Volume Discount
		discountPage.clickAddNewButton();
		discountPage.enterDiscountDescription(3);
		discountPage.enterDiscountCode(3);
		discountPage.selectDiscountType();
		discountPage.selectVolumeRadioButton();
		discountPage.fillTierData();
		discountPage.clickSaveChangesButton();
		discountPage.verifyConfirmationMsg("Saved Volume Discount Successfully");
		discountPage.verifyDiscountName(3);

		// Volume Percentage Discount
		discountPage.clickAddNewButton();
		discountPage.enterDiscountDescription(4);
		discountPage.enterDiscountCode(4);
		discountPage.selectDiscountType();
		discountPage.checkPercentage();
		discountPage.selectVolumeRadioButton();
		discountPage.fillTierData();
		discountPage.clickSaveChangesButton();
		discountPage.verifyConfirmationMsg("Saved Volume Percentage Discount Successfully");
		discountPage.verifyDiscountName(4);

	}
}
