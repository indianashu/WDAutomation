package productHistoricalTest;

import baseClassPackage.BaseClasses;
import productHistorical.AddProduct3Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class AddProduct3Test {
	AddProduct3Page addProductCategoryPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		// WaitClass.waitForUrl(driver, url, 10);
		addProductCategoryPage = AddProduct3Page.getPage(driver, AddProduct3Page.class);

	}

	@Test(groups = { "Product Historical Feature" }, description = "Create Product3 for the Child Company")
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
		addProductCategoryPage.deselectProductCompany1();
		addProductCategoryPage.selectProductCompany2();
		
		addProductCategoryPage.selectHistoricalPrices();
		
		addProductCategoryPage.clickSaveChangesButton();
		addProductCategoryPage.verifyConfirmationMsg("Saved Product Successfully");
	}

}
