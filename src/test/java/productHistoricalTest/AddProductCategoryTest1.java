package productHistoricalTest;

import baseClassPackage.BaseClasses;
import productHistorical.AddProductCategoryPage1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class AddProductCategoryTest1 {

	AddProductCategoryPage1 addProductCategoryPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		// WaitClass.waitForUrl(driver, url, 10);
		addProductCategoryPage = AddProductCategoryPage1.getPage(driver, AddProductCategoryPage1.class);

	}

	@Test(groups = { "Product Historical Feature" }, description = "Create Product for the Child and Parent Company")
	public void userSignin() throws Exception {

		/*addProductCategoryPage.enterLoginID();
		addProductCategoryPage.enterPassword();
		addProductCategoryPage.selectCompany();
		addProductCategoryPage.clickLoginButton();*/
		
		addProductCategoryPage.clickProductsTab();
		addProductCategoryPage.clickAddCategoryButton();
		addProductCategoryPage.enterCategoryName();
		addProductCategoryPage.checkGlobal();
		addProductCategoryPage.clickSaveChangesButton();
		addProductCategoryPage.verifyConfirmationMsg();
		
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
