package peakNonPeak;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClassPackage.BaseClasses;
import utilPackages.PropertyValExtractors;

public class CategoryProductTest {
	
	CategoryProductPage productPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		productPage = CategoryProductPage.getPage(driver, CategoryProductPage.class);
	}

	@Test(groups = { "Peak Non-Peak Feature" }, description = "Create Pricing")
	public void userSignin() throws Exception {

		productPage.enterLoginID();
		productPage.enterPassword();
		productPage.selectCompany();
		productPage.clickLoginButton();
		
		productPage.clickProductsTab();
		productPage.clickAddCategoryButton();
		productPage.enterCategoryName();
		productPage.selectCompanies();
		productPage.clickSaveChangesButton();
		productPage.verifyConfirmationMsg();
		productPage.clickAddProductButton();
		productPage.enterEnglishDescription();
		productPage.enterProductCode();
		productPage.enterPriceRate();
		productPage.clickAddPriceButton();
		productPage.clickSaveChangesButton();
		productPage.verifyConfirmationMsg();
	}
}
