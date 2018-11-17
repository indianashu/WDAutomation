package discount;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClassPackage.BaseClasses;
import discount.ProductCategoryPage;
import utilPackages.PropertyValExtractors;

public class ProductTest {

	ProductCategoryPage productCategoryPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		productCategoryPage = ProductCategoryPage.getPage(driver, ProductCategoryPage.class);

	}

	@Test(groups = { "Configurable Pricing Feature" }, description = "Create Product")
	public void userSignin() throws Exception {

		/*productCategoryPage.enterLoginID();
		productCategoryPage.enterPassword();
		productCategoryPage.selectCompany();
		productCategoryPage.clickLoginButton();*/

		// Item Category and Product
		productCategoryPage.clickProductTab();
		productCategoryPage.clickAddNewButton();
		productCategoryPage.enterCategoryName(0);
		productCategoryPage.clickSaveChangesButton();
		productCategoryPage.verifyConfirmationMsg();
		productCategoryPage.verifyCategoryData(0);

		productCategoryPage.clickAddProductButton();
		productCategoryPage.enterEnglishDescription(0);
		productCategoryPage.enterProductCode(0);
		productCategoryPage.navigateBottom();
		productCategoryPage.selectPriceCurrency();
		productCategoryPage.enterPriceRate(0);
		productCategoryPage.clickAddPriceButton();
		productCategoryPage.clickSaveChangesButton();
		productCategoryPage.verifyConfirmationMsg();
		productCategoryPage.verifyProductName(0);

		// Plan Category and Product
		productCategoryPage.clickProductTab();
		productCategoryPage.clickAddNewButton();
		productCategoryPage.enterCategoryName(1);
		productCategoryPage.selectOrderLineTypeId();
		productCategoryPage.clickSaveChangesButton();
		productCategoryPage.verifyConfirmationMsg();
		productCategoryPage.verifyCategoryData(1);

		productCategoryPage.clickAddProductButton();
		productCategoryPage.enterEnglishDescription(2);
		productCategoryPage.enterProductCode(2);
		productCategoryPage.navigateBottom();
		productCategoryPage.selectPriceCurrency();
		productCategoryPage.enterPriceRate(1);
		productCategoryPage.clickAddPriceButton();
		productCategoryPage.clickSaveChangesButton();
		productCategoryPage.verifyConfirmationMsg();
		productCategoryPage.verifyProductName(2);

		// Item Product
		productCategoryPage.clickProductTab();
		productCategoryPage.selectCategory(0);
		productCategoryPage.clickAddProductButton();
		productCategoryPage.enterEnglishDescription(1);
		productCategoryPage.enterProductCode(1);
		productCategoryPage.navigateBottom();
		productCategoryPage.selectPriceCurrency();
		productCategoryPage.enterPriceRate(0);
		productCategoryPage.clickAddPriceButton();
		productCategoryPage.clickSaveChangesButton();
		productCategoryPage.verifyConfirmationMsg();
		productCategoryPage.verifyProductName(1);

		// Plan Product
		productCategoryPage.clickProductTab();
		productCategoryPage.selectCategory(1);
		productCategoryPage.clickAddProductButton();
		productCategoryPage.enterEnglishDescription(3);
		productCategoryPage.enterProductCode(3);
		productCategoryPage.navigateBottom();
		productCategoryPage.selectPriceCurrency();
		productCategoryPage.enterPriceRate(1);
		productCategoryPage.clickAddPriceButton();
		productCategoryPage.clickSaveChangesButton();
		productCategoryPage.verifyConfirmationMsg();
		productCategoryPage.verifyProductName(3);
	}
}
