package productHistoricalTest;

import baseClassPackage.BaseClasses;
import productHistorical.AddCustomerPage;
import productHistorical.AddProduct1Page;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class AddCustomerTest {
	
	AddCustomerPage addCustomerPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		// WaitClass.waitForUrl(driver, url, 10);
		addCustomerPage = AddCustomerPage.getPage(driver, AddCustomerPage.class);

	}

	@Test(groups = { "Product Historical Feature" }, description = "Create Customer for the Child and Parent Company")
	public void userSignin() throws Exception {
		
		/*addCustomerPage.enterLoginID();
		addCustomerPage.enterPassword();
		addCustomerPage.selectCompany();
		addCustomerPage.clickLoginButton();*/
		
		for (int rowNum = 0; rowNum <= 2; rowNum++) {
			addCustomerPage.clickCustomerTab();
			addCustomerPage.navigateBottom();
			addCustomerPage.clickAddNewButton();
			addCustomerPage.clickSelectButton();
			addCustomerPage.enterLoginName(rowNum);
			addCustomerPage.selectCurrency(rowNum);
			addCustomerPage.navigateBottom();
			addCustomerPage.clickSaveChangesButton();
			addCustomerPage.verifyConfirmationMsg();
		}
		addCustomerPage.clickImpersonate();
		addCustomerPage.selectChildCompany();
		addCustomerPage.clickOKButton();
		for (int rowNum = 0; rowNum <= 2; rowNum++) {
			addCustomerPage.clickCustomerTab();
			addCustomerPage.navigateBottom();
			addCustomerPage.clickAddNewButton();
			addCustomerPage.clickSelectButton();
			addCustomerPage.enterLoginName(rowNum);
			addCustomerPage.selectCurrency(rowNum);
			addCustomerPage.navigateBottom();
			addCustomerPage.clickSaveChangesButton();
			addCustomerPage.verifyConfirmationMsg();
		}
		addCustomerPage.clickRedCross();
		
		
	}

}
