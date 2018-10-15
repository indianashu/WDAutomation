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

		// Create order for customer Leo Holder
		
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
		createOrderPage.enterQuantity();
		createOrderPage.clickUpdateButton();
		createOrderPage.clickSaveChangesButton();
		createOrderPage.verifyConfirmationMsg();*/
		
		// Create Order for customer William
		
		createOrderPage.clickCustomerTab();
		createOrderPage.addCompanyFilter();
		createOrderPage.selectCustomer1();
		createOrderPage.clickCreateOrder();
		createOrderPage.clickProductsSubTab();
		createOrderPage.selectCategory();
		createOrderPage.selectProduct1();
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct1();
		createOrderPage.clickNewSubOrderButton();
		createOrderPage.enterQuantity1();
		createOrderPage.clickUpdateButton1();
		createOrderPage.clickSaveChangesButton();
		createOrderPage.verifyConfirmationMsg();
		
		//Create order for customer Olivia
		
		/*createOrderPage.clickCustomerTab();
		createOrderPage.addCompanyFilter();
		createOrderPage.selectCustomer2();
		createOrderPage.clickCreateOrder();
		createOrderPage.selectPeriod1();
		createOrderPage.selectOrderType1();
		createOrderPage.clickProductsSubTab();
		createOrderPage.selectCategory();
		createOrderPage.selectProduct2();
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct2();
		createOrderPage.clickNewSubOrderButton();
		createOrderPage.clickUpdateButton();
		createOrderPage.clickDetailsTab();
		createOrderPage.clickNew();
		createOrderPage.clickParentOrder();
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct3();
		createOrderPage.clickNewSubOrderButton();
		createOrderPage.clickUpdateButton1();
		createOrderPage.clickDetailsTab();
		createOrderPage.clickNew();
		createOrderPage.clickParentOrder();
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct4();
		createOrderPage.clickCurrentOrderButton();
		createOrderPage.clickUpdateButton2();
		createOrderPage.clickSaveChangesButton();
		createOrderPage.verifyConfirmationMsg();
		createOrderPage.clickGenerateInvoiceButton();
		
		
		
		// Create order for customer Isabella
		
		createOrderPage.clickCustomerTab();
		createOrderPage.addCompanyFilter();
		createOrderPage.selectCustomer3();
		createOrderPage.clickCreateOrder();
		createOrderPage.selectPeriod2();
		createOrderPage.selectOrderType2();
		createOrderPage.clickProductsSubTab();
		createOrderPage.selectCategory();
		createOrderPage.selectProduct3();
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct5();
		createOrderPage.clickNewSubOrderButton();
		createOrderPage.clickUpdateButton3();
		createOrderPage.enterQuantity5();
		createOrderPage.clickUpdateButton3();
		createOrderPage.clickDetailsTab();
		createOrderPage.clickNew();
		createOrderPage.clickParentOrder1();
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct6();
		createOrderPage.clickNewSubOrderButton();
		createOrderPage.clickUpdateButton4();
		createOrderPage.clickDetailsTab();
		createOrderPage.clickNew();
		createOrderPage.clickParentOrder1();
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct7();
		createOrderPage.clickNewSubOrderButton();
		createOrderPage.enterQuantity6();
		createOrderPage.clickUpdateButton5();
		createOrderPage.clickSaveChangesButton();
		createOrderPage.verifyConfirmationMsg();
		createOrderPage.selectParentOrder();
		createOrderPage.selectParentOrder();
		createOrderPage.clickGenerateInvoiceButton();
		
		
		
		// Create order for customer Sophia
		
		createOrderPage.clickCustomerTab();
		createOrderPage.addCompanyFilter();
		createOrderPage.selectCustomer4();
		createOrderPage.clickCreateOrder();
		createOrderPage.selectPeriod3();
		createOrderPage.selectOrderType3();
		createOrderPage.clickProductsSubTab();
		createOrderPage.selectCategory();
		createOrderPage.selectProduct4();
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct8();
		createOrderPage.clickCurrentOrderButton();
		createOrderPage.clickUpdateButton8();
		createOrderPage.enterQuantity7();
		createOrderPage.clickUpdateButton12();
		createOrderPage.clickSaveChangesButton();
		//createOrderPage.clickOrderTab();
		createOrderPage.clickCustomerName1();
		createOrderPage.clickGenerateInvoiceButton();
		//createOrderPage.clickOrderTab();
		createOrderPage.clickCustomerName1();
		createOrderPage.clickEditthisorder();
		createOrderPage.selectOrderType4();
		createOrderPage.clickSaveChangesButton();
		createOrderPage.clickGenerateInvoiceButton();
		
		//Create Order for Jacob
		
		createOrderPage.clickCustomerTab();
		createOrderPage.addCompanyFilter();
		createOrderPage.selectCustomer5();
		createOrderPage.clickCreateOrder();
		createOrderPage.selectPeriod5();
		createOrderPage.selectOrderType5();
		createOrderPage.clickProductsSubTab();
		createOrderPage.selectCategory();
		createOrderPage.selectProduct5();
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct9();
		createOrderPage.clickNewSubOrderButton();
		createOrderPage.enterQuantity9();
		createOrderPage.clickUpdateButton13();
		createOrderPage.clickDetailsTab();
		createOrderPage.clickNew();
		createOrderPage.clickParentOrder2();
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct10();
		createOrderPage.clickNewSubOrderButton();
		createOrderPage.clickUpdateButton10();
		createOrderPage.enterQuantity10();
		createOrderPage.clickUpdateButton15();
		createOrderPage.clickSaveChangesButton();
		//createOrderPage.clickOrderTab();
		createOrderPage.clickParentCustomerName();
		createOrderPage.clickGenerateInvoiceButton();*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}
}
