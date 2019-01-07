package configurablePricing;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClassPackage.BaseClasses;
import utilPackages.PropertyValExtractors;

public class ProductTest {
	ProductPage createProductPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		createProductPage = ProductPage.getPage(driver, ProductPage.class);

	}

	@Test(groups = { "Configurable Pricing Feature" }, description = "Create Product")
	public void userSignin() throws Exception {

		/*createProductPage.enterLoginID();
		createProductPage.enterPassword();
		createProductPage.selectCompany();
		createProductPage.clickLoginButton();*/

		// Item Category and Product
		createProductPage.clickProductTab();
		createProductPage.clickAddNewButton();
		createProductPage.enterCategoryName(0);
		createProductPage.clickSaveChangesButton();
		
		createProductPage.verifyConfirmationMsg();
		//@TODO:- Please Uncomment when the bug-1874 is fixed 
		//createProductPage.verifyCategoryData(0);
		
		createProductPage.clickAddProductButton();
		createProductPage.enterEnglishDescription(0);
		createProductPage.enterProductCode(0);
		createProductPage.navigateBottom();
		createProductPage.selectPriceCurrency();
		createProductPage.enterPriceRate(0);
		createProductPage.clickAddPriceButton();
		createProductPage.clickSaveChangesButton();
		createProductPage.verifyConfirmationMsg();
		createProductPage.verifyProductName(0);
		
		// Plan Category and Product
		createProductPage.clickProductTab();
		createProductPage.clickAddNewButton();
		createProductPage.enterCategoryName(1);
		createProductPage.selectOrderLineTypeId();
		createProductPage.clickSaveChangesButton();
		createProductPage.verifyConfirmationMsg();
		//@TODO:- Please Uncomment when the bug-1874 is fixed 
		//createProductPage.verifyCategoryData(1);
		
		createProductPage.clickAddProductButton();
		createProductPage.enterEnglishDescription(1);
		createProductPage.enterProductCode(1);
		createProductPage.navigateBottom();
		createProductPage.selectPriceCurrency();
		createProductPage.enterPriceRate(1);
		createProductPage.clickAddPriceButton();
		createProductPage.enterPlanProduct(0);
		createProductPage.enterPricing(0);
		createProductPage.clickOnAddPrice();
		createProductPage.clickSaveChangesButton();
		createProductPage.verifyConfirmationMsg();
		createProductPage.verifyProductData(0);
		
		// Item  Product
		createProductPage.clickProductTab();
		createProductPage.selectCategory(0);
		createProductPage.clickAddProductButton();
		createProductPage.enterEnglishDescription(2);
		createProductPage.enterProductCode(2);
		createProductPage.navigateBottom();
		createProductPage.selectPriceCurrency();
		createProductPage.enterPriceRate(1);
		createProductPage.clickAddPriceButton();
		createProductPage.clickSaveChangesButton();
		createProductPage.verifyConfirmationMsg();
		createProductPage.verifyProductName(1);
		
		// Plan  Product
		createProductPage.clickProductTab();
		createProductPage.selectCategory(1);
		createProductPage.clickAddProductButton();
		createProductPage.enterEnglishDescription(3);
		createProductPage.enterProductCode(3);
		createProductPage.navigateBottom();
		createProductPage.selectPriceCurrency();
		createProductPage.enterPriceRate(1);
		createProductPage.clickAddPriceButton();
		createProductPage.enterPlanProduct(1);
		createProductPage.enterPricing(1);
		createProductPage.clickOnAddPrice();
		createProductPage.clickSaveChangesButton();
		createProductPage.verifyConfirmationMsg();
		createProductPage.verifyProductData(1);
	}
}
