package companySetUp;

import baseClassPackage.BasePage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utilPackages.JavaScriptExec;
import utilPackages.PropertyValExtractors;

import org.openqa.selenium.support.ui.Select;

/**
 * @author Ashutosh
 *
 */

public class ConfigurationAccountTypePage extends BasePage {
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public ConfigurationAccountTypePage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(ConfigurationAccountTypePage.class);
	ConfigurationAccountTypePage configurationAccountTypePage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "ConfigAccType";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		ConfigurationAccountTypePage sp = new ConfigurationAccountTypePage(driver);

		log.info("Verifying the Login ID is available or not");
		Assert.assertTrue(enterLoginID.isDisplayed());
		enterLoginID.sendKeys(sp.ExcelRead(sheetName).get(0));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='j_password']")
	private WebElement enterPassword;

	/**
	 * Method to enter Password.
	 * 
	 * @throws IOException
	 */
	public void enterPassword() throws IOException {
		ConfigurationAccountTypePage sp = new ConfigurationAccountTypePage(driver);
		log.info("Verifying the First Name is available or not");
		Assert.assertTrue(enterPassword.isDisplayed());
		enterPassword.sendKeys(sp.ExcelRead(sheetName).get(1));

	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='j_client_id']")
	private WebElement selectCompany;

	/**
	 * Method to select Company.
	 * 
	 * @throws IOException
	 */
	public void selectCompany() throws IOException {
		ConfigurationAccountTypePage sp = new ConfigurationAccountTypePage(driver);
		Select se = new Select(selectCompany);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(2));
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']")
	private WebElement clickLoginButton;

	/**
	 * Method to Click on Save Changes Button
	 */
	public void clickLoginButton() {
		ConfigurationAccountTypePage sp = new ConfigurationAccountTypePage(driver);
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
		ConfigurationAccountTypePage sp = new ConfigurationAccountTypePage(driver);
		log.info("Click on Currencies");
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url2") + "/config/currency";
		driver.get(url);
	}
	
	public void checkCurrencyUSD() throws IOException {
		ConfigurationAccountTypePage sp = new ConfigurationAccountTypePage(driver);
		if ( !driver.findElement(By.id("currencies.1.inUse")).isSelected() )
		{
		     driver.findElement(By.id("currencies.1.inUse")).click();
		}
	}

	@FindBy(how = How.XPATH, using = "//a[.='Account Type']")
	private WebElement clickAccountType;

	/**
	 * Method to click on Account Type.
	 * 
	 * @throws IOException
	 */
	public void clickAccountType() throws IOException {
		ConfigurationAccountTypePage sp = new ConfigurationAccountTypePage(driver);
		log.info("Click on Account Type");
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url2") + "/accountType/list";
		driver.get(url);
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add New']")
	private WebElement clickAddNewButton;

	/**
	 * Method to click on Account Type.
	 * 
	 * @throws IOException
	 */
	public void clickAddNewButton() throws IOException {
		ConfigurationAccountTypePage sp = new ConfigurationAccountTypePage(driver);
		log.info("Click on Add New");
		Assert.assertTrue(clickAddNewButton.isDisplayed());
		clickAddNewButton.click();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='accountType.descriptions[0].content']")
	private WebElement enterAccountName;

	/**
	 * Method to Enter Account Name.
	 * 
	 * @throws IOException
	 */
	public void enterAccountName() throws IOException {
		ConfigurationAccountTypePage sp = new ConfigurationAccountTypePage(driver);
		log.info("Enter Account Name");
		Assert.assertTrue(enterAccountName.isDisplayed());
		enterAccountName.sendKeys(sp.ExcelRead(sheetName).get(3));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='mainSubscription.nextInvoiceDayOfPeriod']")
	private WebElement enterBillingCycle;

	/**
	 * Method to Enter Billing Cycle.
	 * 
	 * @throws IOException
	 */
	public void enterBillingCycle() throws IOException {
		ConfigurationAccountTypePage sp = new ConfigurationAccountTypePage(driver);
		log.info("Enter Billing Cycle");
		Assert.assertTrue(enterBillingCycle.isDisplayed());
		enterBillingCycle.clear();
		enterBillingCycle.sendKeys(sp.ExcelRead(sheetName).get(4));

	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='invoiceDesign']")
	private WebElement selectInvoiceDesign;

	/**
	 * Method to select Invoice Design.
	 * 
	 * @throws IOException
	 */
	public void selectInvoiceDesign() throws IOException {
		ConfigurationAccountTypePage sp = new ConfigurationAccountTypePage(driver);
		Select se = new Select(selectInvoiceDesign);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(5));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickSaveChangesButton() throws IOException {
		ConfigurationAccountTypePage sp = new ConfigurationAccountTypePage(driver);
		log.info("Click on Save Changes Button");
		navigateBottom();
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		clickSaveChangesButton.click();

	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}
}