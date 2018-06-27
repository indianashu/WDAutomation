package productHistoricalTest;

import baseClassPackage.BaseClasses;
import productHistorical.CreateOrderPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class CreateOrderEUROChildTest {
	
	CreateOrderPage createOrderPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		// WaitClass.waitForUrl(driver, url, 10);
		createOrderPage = CreateOrderPage.getPage(driver, CreateOrderPage.class);

	}

	@Test(groups = { "Product Historical Feature" }, description = "Create Order for the Child Company & EURO Customer")
	public void userSignin() throws Exception {
		
		/*createOrderPage.enterLoginID();
		createOrderPage.enterPassword();
		createOrderPage.selectCompany();
		createOrderPage.clickLoginButton();*/
		
		createOrderPage.clickImpersonate();
		createOrderPage.selectChildCompany();
		createOrderPage.clickSelectButton();
		createOrderPage.createOrder6();
		createOrderPage.clickRedCross();
		
		
	}

}

