package productHistoricalTest;

import baseClassPackage.BaseClasses;
import productHistorical.AddProduct1Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class AddProduct1Test {
	
	AddProduct1Page addProductCategoryPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		// WaitClass.waitForUrl(driver, url, 10);
		addProductCategoryPage = AddProduct1Page.getPage(driver, AddProduct1Page.class);

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
		addProductCategoryPage.clickGlobalCheckbox();
		addProductCategoryPage.clickSaveChangesButton();
		String name1=driver.findElement(By.xpath("//tr[@class='active']//strong")).getText();
		addProductCategoryPage.verifyConfirmationMsg("Saved " + name1 + "Successfully");
		
		addProductCategoryPage.clickAddProductButton();
		addProductCategoryPage.enterEnglishDescription();
		addProductCategoryPage.enterProductCode();
		addProductCategoryPage.clickGlobalCheckbox();
		
		addProductCategoryPage.selectHistoricalPriceForParent();
		addProductCategoryPage.selectHistoricalPricesForChild();
		
		
		addProductCategoryPage.clickSaveChangesButton();
		String name2=driver.findElement(By.xpath("//table[@id='products']//strong")).getText();
		addProductCategoryPage.verifyConfirmationMsg("Saved " + name2 + "Successfully");

}
}
