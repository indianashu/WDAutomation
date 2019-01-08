package discount;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClassPackage.BaseClasses;
import utilPackages.PropertyValExtractors;

public class CRUDDiscountTest {
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

		discountPage.enterLoginID();
		discountPage.enterPassword();
		discountPage.selectCompany();
		discountPage.clickLoginButton();
		
		discountPage.clickDiscountTab();
		discountPage.clickAddNewButton();
		discountPage.enterDiscountDescription(0);
		discountPage.enterDiscountCode(0);
		discountPage.selectDiscountType();
		discountPage.checkPercentage();
		discountPage.selectTierRadioButton();
		discountPage.clickSaveChangesButton();
		discountPage.verifyConfirmationMsg();
		discountPage.clickEditButton();
		discountPage.editDiscountName();
		discountPage.clickSaveChangesButton();
		discountPage.verifyConfirmationMsg();
		discountPage.clickDeleteButton();
		discountPage.clickDeleteYesDiscountPopup();
		discountPage.verifyConfirmationMsg();
		
	}
}
