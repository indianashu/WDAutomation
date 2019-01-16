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
		dependentProductPage.selectItemCompany();
		dependentProductPage.clickLoginButton();*/

		dependentProductPage.clickProductsTab();
		dependentProductPage.clickAddCategoryButton();
		dependentProductPage.enterCategoryName();
		dependentProductPage.selectCompanies();
		dependentProductPage.clickSaveChangesButton();
		dependentProductPage.verifyConfirmationMsg();

		// Dependent Category Product 1
		dependentProductPage.selectCategoryName();
		dependentProductPage.clickAddProductButton();
		dependentProductPage.enterEnglishDescription(3);
		dependentProductPage.enterProductCode(3);
		dependentProductPage.selectItemCompany();
		dependentProductPage.selectPriceCurrency();
		dependentProductPage.enterPriceRate(3);
		dependentProductPage.clickAddPriceButton();
		dependentProductPage.clickDependenciesPlus();
		dependentProductPage.selectProductCategoryDependency();
		dependentProductPage.selectProductPeriod(0);
		dependentProductPage.enterMin("1");
		dependentProductPage.addDependencyLine();
		dependentProductPage.clickSaveChangesButton();
		dependentProductPage.verifyConfirmationMsg();

		// Dependent Category Product 2
		dependentProductPage.clickProductsTab();
		dependentProductPage.selectCategoryName();
		dependentProductPage.clickAddProductButton();
		dependentProductPage.enterEnglishDescription(4);
		dependentProductPage.enterProductCode(4);
		dependentProductPage.selectItemCompany();
		dependentProductPage.selectPriceCurrency();
		dependentProductPage.enterPriceRate(4);
		dependentProductPage.clickAddPriceButton();
		dependentProductPage.clickDependenciesPlus();
		dependentProductPage.selectProductCategoryDependency();
		dependentProductPage.selectProductPeriod(1);
		dependentProductPage.enterMin("1");
		dependentProductPage.enterMax("5");
		dependentProductPage.addDependencyLine();
		dependentProductPage.clickSaveChangesButton();
		dependentProductPage.verifyConfirmationMsg();

		// Dependent Category Product 3
		dependentProductPage.clickProductsTab();
		dependentProductPage.selectCategoryName();
		dependentProductPage.clickAddProductButton();
		dependentProductPage.enterEnglishDescription(5);
		dependentProductPage.enterProductCode(5);
		dependentProductPage.selectItemCompany();
		dependentProductPage.selectPriceCurrency();
		dependentProductPage.enterPriceRate(5);
		dependentProductPage.clickAddPriceButton();
		dependentProductPage.clickDependenciesPlus();
		dependentProductPage.selectProductCategoryDependency();
		dependentProductPage.selectProductPeriod(2);
		dependentProductPage.enterMin("3");
		dependentProductPage.enterMax("5");
		dependentProductPage.addDependencyLine();
		dependentProductPage.clickSaveChangesButton();
		dependentProductPage.verifyConfirmationMsg();

		// Dependent Category Product 4
		dependentProductPage.clickProductsTab();
		dependentProductPage.selectCategoryName();
		dependentProductPage.clickAddProductButton();
		dependentProductPage.enterEnglishDescription(6);
		dependentProductPage.enterProductCode(6);
		dependentProductPage.selectItemCompany();
		dependentProductPage.selectPriceCurrency();
		dependentProductPage.enterPriceRate(6);
		dependentProductPage.clickAddPriceButton();
		dependentProductPage.clickDependenciesPlus();
		dependentProductPage.selectProductCategoryDependency();
		dependentProductPage.selectProductDependency1();
		dependentProductPage.selectProductPeriod(0);
		dependentProductPage.enterMin("2");
		dependentProductPage.addDependencyLine();
		dependentProductPage.selectProductCategoryDependency();
		dependentProductPage.selectProductDependency2();
		dependentProductPage.selectProductPeriod(1);
		dependentProductPage.enterMin("0");
		dependentProductPage.enterMax("3");
		dependentProductPage.addDependencyLine();
		dependentProductPage.selectProductCategoryDependency();
		dependentProductPage.selectProductDependency3();
		dependentProductPage.selectProductPeriod(1);
		dependentProductPage.enterMin("1");
		dependentProductPage.enterMax("5");
		dependentProductPage.addDependencyLine();
		dependentProductPage.clickSaveChangesButton();
		dependentProductPage.verifyConfirmationMsg();

		// Dependent Category Product 5
		dependentProductPage.clickProductsTab();
		dependentProductPage.selectCategoryName();
		dependentProductPage.clickAddProductButton();
		dependentProductPage.enterEnglishDescription(7);
		dependentProductPage.enterProductCode(7);
		dependentProductPage.selectItemCompany();
		dependentProductPage.selectPriceCurrency();
		dependentProductPage.enterPriceRate(7);
		dependentProductPage.clickAddPriceButton();
		dependentProductPage.clickDependenciesPlus();
		dependentProductPage.selectProductCategoryDependency();
		dependentProductPage.selectProductDependency1();
		dependentProductPage.selectProductPeriod(0);
		dependentProductPage.enterMin("2");
		dependentProductPage.addDependencyLine();
		dependentProductPage.clickSaveChangesButton();
		dependentProductPage.verifyConfirmationMsg();

		// Dependent Category Product 6
		dependentProductPage.clickProductsTab();
		dependentProductPage.selectCategoryName();
		dependentProductPage.clickAddProductButton();
		dependentProductPage.enterEnglishDescription(8);
		dependentProductPage.enterProductCode(8);
		dependentProductPage.selectItemCompany();
		dependentProductPage.selectPriceCurrency();
		dependentProductPage.enterPriceRate(8);
		dependentProductPage.clickAddPriceButton();
		dependentProductPage.clickDependenciesPlus();
		dependentProductPage.selectProductCategoryDependency();
		dependentProductPage.selectProductDependency2();
		dependentProductPage.selectProductPeriod(1);
		dependentProductPage.enterMin("0");
		dependentProductPage.enterMax("2");
		dependentProductPage.addDependencyLine();
		dependentProductPage.selectProductCategoryDependency();
		dependentProductPage.selectProductDependency3();
		dependentProductPage.selectProductPeriod(1);
		dependentProductPage.enterMin("3");
		dependentProductPage.enterMax("5");
		dependentProductPage.addDependencyLine();
		dependentProductPage.clickSaveChangesButton();
		dependentProductPage.verifyConfirmationMsg();

	}
}
