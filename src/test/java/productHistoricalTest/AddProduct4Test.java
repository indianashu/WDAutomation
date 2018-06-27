package productHistoricalTest;

import baseClassPackage.BaseClasses;
import productHistorical.AddProduct1Page;
import productHistorical.AddProduct4Page;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class AddProduct4Test {

	AddProduct4Page addProductCategoryPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		// WaitClass.waitForUrl(driver, url, 10);
		addProductCategoryPage = AddProduct4Page.getPage(driver, AddProduct4Page.class);

	}

	@Test(groups = { "Product Historical Feature" }, description = "Create Product4 for the Child and Parent Company")
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
		addProductCategoryPage.selectProductCompany2();
		
		addProductCategoryPage.selectHistoricalPrices();
		addProductCategoryPage.selectHistoricalPrices1();
		
		addProductCategoryPage.clickSaveChangesButton();
		addProductCategoryPage.verifyConfirmationMsg();

	}
}
