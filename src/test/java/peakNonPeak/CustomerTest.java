package peakNonPeak;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import peakNonPeak.CustomerPage;
import baseClassPackage.BaseClasses;
import utilPackages.PropertyValExtractors;

public class CustomerTest {
	CustomerPage customerPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		// WaitClass.waitForUrl(driver, url, 10);
		customerPage = CustomerPage.getPage(driver, CustomerPage.class);

	}

	@Test(groups = { "Peak Non-Peak Feature" }, description = "Create Customers and set their Peek")
	public void userSignin() throws Exception {

		/*customerPage.enterLoginID();
		customerPage.enterPassword();
		customerPage.selectCompany();
		customerPage.clickLoginButton();*/
		
		customerPage.clickCustomerTab();
		
		for (int rowNum = 0; rowNum < 8; rowNum++) {

			customerPage.clickAddNewButton();
			customerPage.clickSelectButton();
			customerPage.enterCustomerName(rowNum);
			customerPage.selectCurrency();
			customerPage.clickSaveChangesButton();
			customerPage.verifyConfirmationMsg();
		}
		
		// WEEKLY BASED FOR TOMMY ALLEN
		
		//@TODO Add Filter to select the customer
		customerPage.selectCustomer(0);
		customerPage.clickCustomerInspectIcon();
		customerPage.clickActiveSpecialPlusButton();
		customerPage.clickAddSpecialButton();
		customerPage.selectPeakInterval(0);
		customerPage.clickAddButton();
		customerPage.selectisRecurring();
		customerPage.checkIsPeak();
		customerPage.enterStartDate(0);
		customerPage.enterEndDate(0);
		customerPage.selectDayofWeek();
		customerPage.clickSavePeakButton();
		customerPage.verifyConfirmationMsg();

		// SPECIAL DAY FOR TOMMY ALLEN
		customerPage.clickActiveSpecialPlusButton();
		customerPage.clickAddSpecialButton();
		customerPage.selectPeakInterval(1);
		customerPage.clickAddButton();
		customerPage.selectisRecurring();
		customerPage.enterStartDate(1);
		customerPage.enterDescription("Work Anniversary");
		customerPage.clickSavePeakButton();
		customerPage.verifyConfirmationMsg();

		// HOLIDAY FOR TOMMY ALLEN
		customerPage.clickActiveSpecialPlusButton();
		customerPage.clickAddSpecialButton();
		customerPage.selectPeakInterval(2);
		customerPage.clickAddButton();
		customerPage.selectisRecurring();
		customerPage.enterStartDate(2);
		customerPage.clickSavePeakButton();
		customerPage.verifyConfirmationMsg();

		// TIME BASED FOR TOMMY ALLEN
		customerPage.clickActiveSpecialPlusButton();
		customerPage.clickAddSpecialButton();
		customerPage.selectPeakInterval(3);
		customerPage.clickAddButton();
		customerPage.selectisRecurring();
		customerPage.checkIsPeak();
		customerPage.enterStartDate(3);
		customerPage.enterEndDate(1);
		customerPage.enterStartTime();
		customerPage.enterEndTime();
		customerPage.clickSavePeakButton();
		customerPage.verifyConfirmationMsg();
		
		// SPECIAL DAY FOR TYLER KIM
		customerPage.clickCustomerTab();
		customerPage.selectCustomer(3);
		customerPage.clickCustomerInspectIcon();
		customerPage.clickActiveSpecialPlusButton();
		customerPage.clickAddSpecialButton();
		customerPage.selectPeakInterval(1);
		customerPage.clickAddButton();
		customerPage.selectisRecurring();
		customerPage.enterStartDate(1);
		customerPage.enterDescription("Birthday");
		customerPage.clickSavePeakButton();
		customerPage.verifyConfirmationMsg();
	}
}
