package ProductDependency;

import baseClassPackage.BaseClasses;
import ProductDependency.CreateOrderPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class CreateOrderTest {
	
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
	
	@Test(groups = { "Product Historical Feature" }, description = "Create Order for the Parent Company & USD Customer")
	public void userSignin() throws Exception {

		createOrderPage.enterLoginID();
		createOrderPage.enterPassword();
		createOrderPage.selectCompany();
		createOrderPage.clickLoginButton();

		
		/*createOrderPage.clickCustomerTab();
		createOrderPage.addCompanyFilter();
		createOrderPage.selectCustomer();
		createOrderPage.clickCreateOrder();
		createOrderPage.selectPeriod();
		createOrderPage.selectOrderType();
		createOrderPage.clickProductsSubTab();
		createOrderPage.selectCategory();
		createOrderPage.selectProduct();
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct();
		createOrderPage.clickCurrentOrderButton();
		//createOrderPage.enterQuantity();
		createOrderPage.clickUpdateButton();
		createOrderPage.clickSaveChangesButton();
		createOrderPage.verifyConfirmationMsg();*/
		
		
		createOrderPage.clickCustomerTab();
		createOrderPage.addCompanyFilter();
		createOrderPage.selectCustomer1();
		createOrderPage.clickCreateOrder();
		createOrderPage.clickProductsSubTab();
		createOrderPage.selectCategory();
		createOrderPage.selectProduct1();
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct1();
		createOrderPage.clickAddSubOrderButton();
		//createOrderPage.enterQuantity1();
		createOrderPage.clickUpdateButton();
		createOrderPage.clickSaveChangesButton();
		createOrderPage.verifyConfirmationMsg();
		
		
		createOrderPage.clickCustomerTab();
		createOrderPage.addCompanyFilter();
		createOrderPage.selectCustomer2();
		createOrderPage.clickCreateOrder();
		createOrderPage.clickProductsSubTab();
		createOrderPage.selectCategory();
		createOrderPage.selectProduct2();
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct2();
		createOrderPage.clickAddSubOrderButton();
		//createOrderPage.enterQuantity1();
		createOrderPage.clickUpdateButton();
		createOrderPage.clickDetailsTab();
		createOrderPage.selectProduct2();
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct3();
		createOrderPage.clickAddSubOrderButton();
		//createOrderPage.enterQuantity1();
		createOrderPage.clickUpdateButton();
		
		
		
		

}
}
