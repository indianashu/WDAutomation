package productDependency;

import baseClassPackage.BaseClasses;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;
import productDependency.CreateDependentCategoryPage;

public class CreateDependentCategoryTest {

	CreateDependentCategoryPage dependentProductPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		// WaitClass.waitForUrl(driver, url, 10);
		dependentProductPage = CreateDependentCategoryPage.getPage(driver, CreateDependentCategoryPage.class);

	}

	@Test(groups = { "Product Dependency Feature" }, description = "Add Edit Product")
	public void userSignin() throws IOException {

		/*dependentProductPage.enterLoginID();
		dependentProductPage.enterPassword();
		dependentProductPage.selectCompany1();
		dependentProductPage.clickLoginButton();*/

		dependentProductPage.clickProductsTab();
		dependentProductPage.clickAddCategoryButton();
		dependentProductPage.enterCategoryName();
		dependentProductPage.clickSaveChangesButton();
		dependentProductPage.verifyConfirmationMsg("Saved Category Successfully");

		// Billing Category Product 1
		dependentProductPage.selectCategoryName();
		dependentProductPage.clickAddProductButton();
		dependentProductPage.enterEnglishDescription();
		dependentProductPage.enterProductCode();
		dependentProductPage.selectCompany();
		dependentProductPage.selectPriceCurrency();
		dependentProductPage.enterPriceRate();
		dependentProductPage.clickAddPriceButton();
		dependentProductPage.clickDependenciesPlus();
		dependentProductPage.selectProductCategoryDependency();
		dependentProductPage.selectProductPeriod();
		dependentProductPage.enterMin();
		dependentProductPage.addDependencyLine();
		dependentProductPage.clickSaveChangesButton();
		dependentProductPage.verifyConfirmationMsg("Saved Product 1 Successfully");

		// Billing Category Product 2
		dependentProductPage.clickProductsTab();
		dependentProductPage.selectCategoryName();
		dependentProductPage.clickAddProductButton();
		dependentProductPage.enterEnglishDescription1();
		dependentProductPage.enterProductCode1();
		dependentProductPage.selectCompany();
		dependentProductPage.selectPriceCurrency();
		dependentProductPage.enterPriceRate1();
		dependentProductPage.clickAddPriceButton();
		dependentProductPage.clickDependenciesPlus();
		dependentProductPage.selectProductCategoryDependency();
		dependentProductPage.selectProductPeriod1();
		dependentProductPage.enterMin1();
		dependentProductPage.enterMax1();
		dependentProductPage.addDependencyLine();
		dependentProductPage.clickSaveChangesButton();
		dependentProductPage.verifyConfirmationMsg("Saved Product 2 Successfully");

		// Billing Category Product 3
		dependentProductPage.clickProductsTab();
		dependentProductPage.selectCategoryName();
		dependentProductPage.clickAddProductButton();
		dependentProductPage.enterEnglishDescription2();
		dependentProductPage.enterProductCode2();
		dependentProductPage.selectCompany();
		dependentProductPage.selectPriceCurrency();
		dependentProductPage.enterPriceRate2();
		dependentProductPage.clickAddPriceButton();
		dependentProductPage.clickDependenciesPlus();
		dependentProductPage.selectProductCategoryDependency();
		dependentProductPage.selectProductPeriod2();
		dependentProductPage.enterMin2();
		dependentProductPage.enterMax2();
		dependentProductPage.addDependencyLine();
		dependentProductPage.clickSaveChangesButton();
		dependentProductPage.verifyConfirmationMsg("Saved Product 3 Successfully");

		// Billing Category Product 4
		dependentProductPage.clickProductsTab();
		dependentProductPage.selectCategoryName();
		dependentProductPage.clickAddProductButton();
		dependentProductPage.enterEnglishDescription3();
		dependentProductPage.enterProductCode3();
		dependentProductPage.selectCompany();
		dependentProductPage.selectPriceCurrency();
		dependentProductPage.enterPriceRate3();
		dependentProductPage.clickAddPriceButton();
		dependentProductPage.clickDependenciesPlus();
		dependentProductPage.selectProductCategoryDependency();
		dependentProductPage.selectProductDependency1();
		dependentProductPage.selectProductPeriod3();
		dependentProductPage.enterMin3();
		dependentProductPage.addDependencyLine();
		dependentProductPage.selectProductCategoryDependency();
		dependentProductPage.selectProductDependency2();
		dependentProductPage.selectProductPeriod4();
		dependentProductPage.entermin6();
		dependentProductPage.enterMax3();
		dependentProductPage.addDependencyLine();
		dependentProductPage.selectProductCategoryDependency();
		dependentProductPage.selectProductDependency3();
		dependentProductPage.selectProductPeriod5();
		dependentProductPage.enterMin4();
		dependentProductPage.enterMax4();
		dependentProductPage.addDependencyLine();
		dependentProductPage.clickSaveChangesButton();
		dependentProductPage.verifyConfirmationMsg("Saved Product 4 Successfully");

		// Billing Category Product 5
		dependentProductPage.clickProductsTab();
		dependentProductPage.selectCategoryName();
		dependentProductPage.clickAddProductButton();
		dependentProductPage.enterEnglishDescription4();
		dependentProductPage.enterProductCode4();
		dependentProductPage.selectCompany();
		dependentProductPage.selectPriceCurrency();
		dependentProductPage.enterPriceRate4();
		dependentProductPage.clickAddPriceButton();
		dependentProductPage.clickDependenciesPlus();
		dependentProductPage.selectProductCategoryDependency();
		dependentProductPage.selectProductDependency1();
		dependentProductPage.selectProductPeriod3();
		dependentProductPage.enterMin3();
		dependentProductPage.addDependencyLine();
		dependentProductPage.clickSaveChangesButton();
		dependentProductPage.verifyConfirmationMsg("Saved Product 5 Successfully");

		// Billing Category Product 6
		dependentProductPage.clickProductsTab();
		dependentProductPage.selectCategoryName();
		dependentProductPage.clickAddProductButton();
		dependentProductPage.enterEnglishDescription5();
		dependentProductPage.enterProductCode5();
		dependentProductPage.selectCompany();
		dependentProductPage.selectPriceCurrency();
		dependentProductPage.enterPriceRate5();
		dependentProductPage.clickAddPriceButton();
		dependentProductPage.clickDependenciesPlus();
		dependentProductPage.selectProductCategoryDependency();
		dependentProductPage.selectProductDependency2();
		dependentProductPage.selectProductPeriod4();
		dependentProductPage.entermin6();
		dependentProductPage.enterMax6();
		dependentProductPage.addDependencyLine();
		dependentProductPage.selectProductCategoryDependency();
		dependentProductPage.selectProductDependency3();
		dependentProductPage.selectProductPeriod5();
		dependentProductPage.enterMin5();
		dependentProductPage.enterMax5();
		dependentProductPage.addDependencyLine();
		dependentProductPage.clickSaveChangesButton();
		dependentProductPage.verifyConfirmationMsg("Saved Product 6 Successfully");

	}
}
