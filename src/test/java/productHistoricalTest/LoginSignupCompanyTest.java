package productHistoricalTest;

import baseClassPackage.BaseClasses;
import productHistorical.LoginSignupCompanyPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class LoginSignupCompanyTest {

	LoginSignupCompanyPage loginSignupCompanyPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		// WaitClass.waitForUrl(driver, url, 10);
		loginSignupCompanyPage = LoginSignupCompanyPage.getPage(driver, LoginSignupCompanyPage.class);

	}

	@Test(groups = { "Product Historical Feature" }, description = "Create Product4 for the Child and Parent Company")
	public void userSignin() throws Exception {

		loginSignupCompanyPage.enterLoginID();
		loginSignupCompanyPage.enterPassword();
		loginSignupCompanyPage.selectCompany();
		loginSignupCompanyPage.clickLoginButton();
		
		loginSignupCompanyPage.verifyLabelSuccessfulLogin();
		loginSignupCompanyPage.enterURL();
		loginSignupCompanyPage.labelRootCompany();
		loginSignupCompanyPage.enterLoginName();
    	loginSignupCompanyPage.enterFirstName();
    	loginSignupCompanyPage.enterLastName();
    	loginSignupCompanyPage.enterPhoneCountryCode();
    	loginSignupCompanyPage.enterPhoneAreaCode();
    	loginSignupCompanyPage.enterPhoneAreaCode();
    	loginSignupCompanyPage.enterPhoneNumber();
    	loginSignupCompanyPage.enterEmail();
    	loginSignupCompanyPage.selectLanguage();
    	loginSignupCompanyPage.selectCurrency();
    	loginSignupCompanyPage.enterOrgName();
    	loginSignupCompanyPage.enterAddress();
    	loginSignupCompanyPage.enterAddress2();
    	loginSignupCompanyPage.enterCity();
    	loginSignupCompanyPage.enterStateProvince();
    	loginSignupCompanyPage.selectCountry();
    	loginSignupCompanyPage.enterZipCode();
    	loginSignupCompanyPage.clickSaveChangesButton();
		
		

	}
}
