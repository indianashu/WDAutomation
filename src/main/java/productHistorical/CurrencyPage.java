package productHistorical;
import baseClassPackage.BasePage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import utilPackages.JavaScriptExec;
import utilPackages.PropertyValExtractors;
import org.openqa.selenium.support.ui.Select;


	public class CurrencyPage extends BasePage {
		
		public CurrencyPage(WebDriver webdriver) {
			super(webdriver);
		}

		Logger log = Logger.getLogger(CurrencyPage.class);

		PropertyValExtractors p = new PropertyValExtractors();
		Actions actions = new Actions(driver);
		String sheetName = "AddCurrency";
		String xlsxName = "/ProductHistorical_TestData.xlsx";

		@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
		private WebElement enterLoginID;

		/**
		 * Method to enter login ID.
		 * 
		 * @throws Exception
		 */
		public void enterLoginID() throws Exception {
			CurrencyPage sp = new CurrencyPage(driver);

			log.info("Verifying the Login ID is available or not");
			Assert.assertTrue(enterLoginID.isDisplayed());
			enterLoginID.sendKeys(BasePage.getCellData(xlsxName, sheetName, 0, 0));
		}

		@FindBy(how = How.XPATH, using = "//input[@name='j_password']")
		private WebElement enterPassword;

		/**
		 * Method to enter Password.
		 * 
		 * @throws Exception
		 */
		public void enterPassword() throws Exception {
			CurrencyPage sp = new CurrencyPage(driver);
			log.info("Verifying the First Name is available or not");
			Assert.assertTrue(enterPassword.isDisplayed());
			enterPassword.sendKeys(BasePage.getCellData(xlsxName, sheetName, 1, 0));

		}

		private WebElement selectCompany;

		/**
		 * Method to select Company.
		 * 
		 * @throws IOException
		 */
		public void selectCompany() throws Exception {
			CurrencyPage sp = new CurrencyPage(driver);
			WebElement Companyelement = driver.findElement(By.xpath("//select[@name='j_client_id']"));
			Select se = new Select(Companyelement);
			se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 2, 0));

		}

		@FindBy(how = How.XPATH, using = "//a[@class='submit save']")
		private WebElement clickLoginButton;

		/**
		 * Method to Click on Save Changes Button
		 */
		public void clickLoginButton() {
			CurrencyPage sp = new CurrencyPage(driver);
			log.info("Verifying the login button is available or not");
			Assert.assertTrue(clickLoginButton.isDisplayed());
			clickLoginButton.click();
		}
		
		@FindBy(how = How.XPATH, using = "//a[.='Currencies']")
		private WebElement clickCurrencies;

		/**
		 * Method to click on Currencies.
		 * 
		 * @throws IOException
		 */
		public void clickCurrencies() throws IOException {
			CurrencyPage sp = new CurrencyPage(driver);
			log.info("Click on Currencies");
			JavaScriptExec.sleep();
			p.getPropertyFile("test", "configuration.properties");
			String url = p.getVal("url2") + "/config/currency";
			driver.get(url);
		}
		@FindBy(how = How.XPATH, using = "//input[@name='currencies.1.inUse']")
		private WebElement checkUSDcurrency;

		/**
		 * Method to Check United States Dollar Currency CheckBox.
		 * 
		 * @throws IOException
		 */
		public void checkUSDcurrency() throws IOException {
			CurrencyPage sp = new CurrencyPage(driver);
			log.info("Check United States Dollar Currency Checkbox.");
			Assert.assertTrue(checkUSDcurrency.isDisplayed());
			if ( !checkUSDcurrency.isSelected() )
			{
				checkUSDcurrency.click();
			}

		}

		@FindBy(how = How.XPATH, using = "//input[@name='currencies.2.inUse']")
		private WebElement checkCADcurrency;

		/**
		 * Method to Check Canadian Currency CheckBox.
		 * 
		 * @throws IOException
		 */
		public void checkCADcurrency() throws IOException {
			CurrencyPage sp = new CurrencyPage(driver);
			log.info("Check Canadian Currency Checkbox.");
			Assert.assertTrue(checkCADcurrency.isDisplayed());
			if ( !checkCADcurrency.isSelected() )
			{
				checkCADcurrency.click();
			}

		}

		@FindBy(how = How.XPATH, using = "//input[@name='currencies.3.inUse']")
		private WebElement checkEUROcurrency;

		/**
		 * Method to Check Euro Currency CheckBox.
		 * 
		 * @throws IOException
		 */
		public void checkEUROcurrency() throws IOException {
			CurrencyPage sp = new CurrencyPage(driver);
			log.info("Check Euro Currency Checkbox.");
			Assert.assertTrue(checkEUROcurrency.isDisplayed());
			if ( !checkEUROcurrency.isSelected() )
			{
			checkEUROcurrency.click();
			}

		}

		@FindBy(how = How.XPATH, using = "//a[@class='submit save']")
		private WebElement clickSaveChangesButton;

		/**
		 * Method to Click on Save Changes Button
		 */
		public void clickSaveChangesButton() {
			log.info("Verifying the login button is available or not");
			navigateBottom();
			Assert.assertTrue(clickSaveChangesButton.isDisplayed());
			clickSaveChangesButton.click();
		}
		
		@FindBy(how = How.XPATH, using = "//div[@class='msg-box successfully']")
		private WebElement verifyLabelConfirmationMessage;

		/**
		 * Method to verify Label is present after successful login.
		 * 
		 * @throws IOException
		 */
		public void verifyLabelConfirmationMessage() throws IOException {
			CurrencyPage sp = new CurrencyPage(driver);
			log.info("Verifying if Label is available or not");
			JavaScriptExec.sleep();
			Assert.assertTrue(verifyLabelConfirmationMessage.getText().contains(BasePage.getCellData(xlsxName, sheetName, 4, 0)),
					"Assert Failed as its unable to search text in Logged in Page");
		}
		
		@FindBy(how = How.XPATH, using = "//*[@class='fa fa-plus-square']")
		private WebElement clickImpersonate;

		/**
		 * Method to Click on Impersonate Link
		 */
		public void clickImpersonate() {
			CurrencyPage sp = new CurrencyPage(driver);
			log.info("Click on Impersonate Link");
			JavaScriptExec.sleep();
			Assert.assertTrue(clickImpersonate.isDisplayed());
			clickImpersonate.click();
		}

		private WebElement selectChildCompany;

		/**
		 * Method to select Child Company.
		 * 
		 * @throws IOException
		 */
		public void selectChildCompany() throws IOException {
			CurrencyPage sp = new CurrencyPage(driver);
			JavaScriptExec.sleep();
			WebElement Companyelement = driver.findElement(By.xpath("//select[@name='entityId']"));
			Select se = new Select(Companyelement);
			se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 3, 0));

		}

		@FindBy(how = How.XPATH, using = "//*[text()='OK']")
		private WebElement clickOKButton;

		/**
		 * Method to Click on Select Button
		 */
		public void clickOKButton() {
			CurrencyPage sp = new CurrencyPage(driver);
			log.info("Click on Select Button");
			Assert.assertTrue(clickOKButton.isDisplayed());
			clickOKButton.click();
		}

		// @FindBy(how=How.XPATH,using="//*[@id='header']/ul/a")
		private WebElement verifyChildCompanyName;

		/**
		 * Method to Verify Child Company Name is shown
		 * 
		 * @throws IOException
		 */
		public void verifyChildCompanyName() throws IOException {
			CurrencyPage sp = new CurrencyPage(driver);
			log.info("Verify Child Company Name is shown.");
			String ExpectedName = BasePage.getCellData(xlsxName, sheetName, 5, 0);
			String ActualName = driver.findElement(By.xpath("//*[@id='header']//span[@class='right-text']")).getText();
			Assert.assertEquals(ActualName, ExpectedName);
		}
		@FindBy(how = How.XPATH, using = "//span[@class='right-text']//a")
		private WebElement clickRedCross;

		/**
		 * Method to click on Red Cross
		 * 
		 * @throws IOException
		 */
		public void clickRedCross() throws IOException {
			CurrencyPage sp = new CurrencyPage(driver);
			log.info("Click on Red Cross");
			JavaScriptExec.sleep();
			Assert.assertTrue(clickRedCross.isDisplayed());
			clickRedCross.click();

		}

		public void navigateBottom() {
			JavaScriptExec.scrolltoBottomofPage(driver);
			JavaScriptExec.sleep();
		
	}
	}
	
		
		

