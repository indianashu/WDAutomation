package productHistoricalTest;

import baseClassPackage.BaseClasses;
import productHistorical.CurrencyPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class CurrencyTest {

	CurrencyPage currencyPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		// WaitClass.waitForUrl(driver, url, 10);
		currencyPage = CurrencyPage.getPage(driver, CurrencyPage.class);

	}

	@Test(groups = { "Product Historical Feature" }, description = "Create Currency for the Child and Parent Company")
	public void userSignin() throws IOException {

		
		 currencyPage.enterLoginID(); 
		 currencyPage.enterPassword();
		 currencyPage.selectCompany(); 
		 currencyPage.clickLoginButton();
		 
		currencyPage.clickCurrencies();
		currencyPage.checkCADcurrency();
		currencyPage.checkEUROcurrency();
		currencyPage.clickSaveChangesButton();
		currencyPage.verifyLabelConfirmationMessage();
		currencyPage.clickImpersonate();
		currencyPage.selectChildCompany();
		currencyPage.clickOKButton();
		currencyPage.verifyChildCompanyName();
		currencyPage.clickCurrencies();
		currencyPage.checkCADcurrency();
		currencyPage.checkEUROcurrency();
		currencyPage.clickSaveChangesButton();
		currencyPage.verifyLabelConfirmationMessage();
		currencyPage.clickRedCross();

	}
}
