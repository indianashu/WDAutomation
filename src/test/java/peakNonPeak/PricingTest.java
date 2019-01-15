package peakNonPeak;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClassPackage.BaseClasses;
import peakNonPeak.PricingPage;
import utilPackages.PropertyValExtractors;

public class PricingTest {
	
	PricingPage pricingPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		pricingPage = PricingPage.getPage(driver, PricingPage.class);

	}

	@Test(groups = { "Peak Non-Peak Feature" }, description = "Create Pricing")
	public void userSignin() throws Exception {

		pricingPage.enterLoginID();
		pricingPage.enterPassword();
		pricingPage.selectCompany();
		pricingPage.clickLoginButton();
		
		pricingPage.clickPricingTab();
		pricingPage.clickAddNewButton();
		pricingPage.enterPricingName();
		pricingPage.selectPricingType();
		pricingPage.enterPeakPrice();
		pricingPage.enterNonPeakPrice();
		pricingPage.clickSaveChangesButton();
		String name=driver.findElement(By.xpath("//tr[@class='active']//a")).getText();
		pricingPage.verifyConfirmationMsg("Pricing " + name + "Saved Successfully");
		
	}
}
