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

	@Test(groups = { "Peak Non-Peak Feature" }, description = "Create Products")
	public void userSignin() throws Exception {

		productPage.enterLoginID();
		productPage.enterPassword();
		productPage.selectCompany();
		productPage.clickLoginButton();

		productPage.clickProductsTab();
		productPage.clickAddCategoryButton();
		productPage.enterCategoryName(0);
		productPage.selectCompanies();
		productPage.clickSaveChangesButton();
		productPage.verifyConfirmationMsg();
		productPage.verifyCategoryData(0);

		productPage.clickAddCategoryButton();
		productPage.enterCategoryName(1);
		productPage.enterCategoryType();
		productPage.selectCompanies();
		productPage.clickSaveChangesButton();
		productPage.verifyConfirmationMsg();
		productPage.verifyCategoryData(1);

		for (int rowNum = 0; rowNum < 6; rowNum++) {
			productPage.selectCategoryName(0);
			productPage.clickAddProductButton();
			productPage.enterEnglishDescription(rowNum);
			productPage.enterProductCode(rowNum);
			productPage.selectCurrency();
			productPage.enterPriceRate(0);
			productPage.clickAddPriceButton();
			productPage.clickSaveChangesButton();
			productPage.verifyConfirmationMsg();
			productPage.verifyProductName(rowNum);

			productPage.selectCategoryName(0);
			productPage.clickAddProductButton();
			productPage.enterEnglishDescription(rowNum);
			productPage.enterProductCode(rowNum);
			productPage.selectCurrency();
			productPage.enterPriceRate(1);
			productPage.clickAddPriceButton();
			productPage.enterPlanProduct();
			productPage.enterPricing();
			productPage.clickAddPriceButton();
			productPage.clickSaveChangesButton();
			productPage.verifyConfirmationMsg();
			productPage.verifyProductData(rowNum);
		}
		productPage.selectProductName(1);
		productPage.clickAddSpecialButton();
		productPage.selectPeakInterval(0);
		productPage.clickAddButton();
		productPage.selectisRecurring();
		productPage.enterStartDate(0);
		productPage.enterEndDate(0);
		productPage.selectDayofWeek(0);
		productPage.clickSavePeakButton();
		productPage.verifyConfirmationMsg();
		
		productPage.navigateBottom();
		productPage.clickAddSpecialButton();
		productPage.selectPeakInterval(1);
		productPage.clickAddButton();
		productPage.selectisRecurring();
		productPage.checkIsPeak();
		productPage.enterStartDate(1);
		productPage.enterEndDate(1);
		productPage.enterStartTime();
		productPage.enterEndTime();
		productPage.clickSavePeakButton();
		productPage.verifyConfirmationMsg();
		
		productPage.selectProductName(3);
		productPage.clickAddSpecialButton();
		productPage.selectPeakInterval(1);
		productPage.clickAddButton();
		productPage.selectisRecurring();
		productPage.enterStartDate(1);
		productPage.enterEndDate(1);
		productPage.enterStartTime();
		productPage.enterEndTime();
		productPage.clickSavePeakButton();
		productPage.verifyConfirmationMsg();
		
		productPage.selectProductName(5);
		productPage.clickAddSpecialButton();
		productPage.selectPeakInterval(0);
		productPage.clickAddButton();
		productPage.selectisRecurring();
		productPage.checkIsPeak();
		productPage.enterStartDate(1);
		productPage.enterEndDate(0);
		productPage.selectDayofWeek(1);
		productPage.clickSavePeakButton();
	}
}
