package productHistoricalTest;

import baseClassPackage.BaseClasses;
import productHistorical.AddProduct2Page;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class AddProduct2Test {
	AddProduct2Page addProductCategoryPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		// WaitClass.waitForUrl(driver, url, 10);
		addProductCategoryPage = AddProduct2Page.getPage(driver, AddProduct2Page.class);

	}

	@Test(groups = { "Product Historical Feature" }, description = "Create Product2 for the Parent Company")
	public void userSignin() throws Exception {

		/*addProductCategoryPage.enterLoginID();
		addProductCategoryPage.enterPassword();
		addProductCategoryPage.selectCompany();
		addProductCategoryPage.clickLoginButton();*/
		
		addProductCategoryPage.clickProductsTab();
		addProductCategoryPage.selectCategoryName();
		
		addProductCategoryPage.clickAddProductButton();
		addProductCategoryPage.enterEnglishDescription();
		addProductCategoryPage.enterProductCode();
		addProductCategoryPage.selectProductCompany1();
		
		addProductCategoryPage.selectHistoricalPrices();
		
		addProductCategoryPage.clickSaveChangesButton();
		addProductCategoryPage.verifyConfirmationMsg();

	}

}



