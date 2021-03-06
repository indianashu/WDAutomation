package companySetUp;

import baseClassPackage.BasePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utilPackages.JavaScriptExec;
import utilPackages.PropertyValExtractors;
import utilPackages.WaitClass;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Ashutosh Add Billing Process
 */

public class ConfigurationBillingProcessPage extends BasePage {
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public ConfigurationBillingProcessPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(ConfigurationBillingProcessPage.class);
	ConfigurationBillingProcessPage configurationBillingProcessPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "ConfigBillingProcess";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		ConfigurationBillingProcessPage sp = new ConfigurationBillingProcessPage(driver);

		log.info("Verifying the Login ID is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, enterLoginID);
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
		ConfigurationBillingProcessPage sp = new ConfigurationBillingProcessPage(driver);
		log.info("Verifying the First Name is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, enterPassword);
		Assert.assertTrue(enterPassword.isDisplayed());
		enterPassword.sendKeys(sp.ExcelRead(sheetName).get(1));

	}

	private WebElement selectCompany;

	/**
	 * Method to select Comapny.
	 * 
	 * @throws IOException
	 */
	public void selectCompany() throws IOException {
		ConfigurationBillingProcessPage sp = new ConfigurationBillingProcessPage(driver);
		WebElement Companyelement = driver.findElement(By.xpath("//select[@name='j_client_id']"));
		Select se = new Select(Companyelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(2));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']")
	private WebElement clickLoginButton;

	/**
	 * Method to Click on Login Button
	 */
	public void clickLoginButton() {
		ConfigurationBillingProcessPage sp = new ConfigurationBillingProcessPage(driver);
		log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
		Assert.assertTrue(clickLoginButton.isDisplayed());
		clickLoginButton.click();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu.link.configuration']/div/div/ul/a[5]/li/span")
	private WebElement clickBillingProcess;

	/**
	 * Method to click on Billing Process.
	 * 
	 * @throws IOException
	 */
	public void clickBillingProcess() throws IOException {
		ConfigurationBillingProcessPage sp = new ConfigurationBillingProcessPage(driver);
		log.info("Click on Billing Process");
		JavaScriptExec.sleep();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url2") + "/billingconfiguration/index";
		driver.get(url);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='nextRunDate']")
	private WebElement enterNextRunDate;

	/**
	 * Method to enter Next Run Date.
	 * 
	 * @throws IOException
	 */
	public void enterNextRunDate() throws IOException {
		ConfigurationBillingProcessPage sp = new ConfigurationBillingProcessPage(driver);
		log.info("Verifying the Next Run Date is available or not");
		Assert.assertTrue(enterNextRunDate.isDisplayed());
		enterNextRunDate.clear();
		enterNextRunDate.sendKeys(sp.ExcelRead(sheetName).get(3));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='maximumPeriods']")
	private WebElement enterMaxPeriodInvoice;

	/**
	 * Method to enter Maximum Order Periods to Invoice.
	 * 
	 * @throws IOException
	 */
	public void enterMaxPeriodInvoice() throws IOException {
		ConfigurationBillingProcessPage sp = new ConfigurationBillingProcessPage(driver);
		log.info("Verifying the Maximum Order Periods to Invoice is available or not");
		Assert.assertTrue(enterMaxPeriodInvoice.isDisplayed());
		enterMaxPeriodInvoice.clear();
		enterMaxPeriodInvoice.sendKeys(sp.ExcelRead(sheetName).get(4));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='generateReport']")
	private WebElement selectGenerateReport;

	/**
	 * Method to select Generate Report.
	 * 
	 * @throws IOException
	 */
	public void selectGenerateReport() throws IOException {
		ConfigurationBillingProcessPage sp = new ConfigurationBillingProcessPage(driver);
		log.info("Verifying the Is Recurring is available or not");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, selectGenerateReport);
		Assert.assertTrue(selectGenerateReport.isDisplayed());
		// selectGenerateReport.clear();
		selectGenerateReport.click();

	}

	private WebElement selectBillingPeriod;

	/**
	 * Method to select Billing Period.
	 * 
	 * @throws IOException
	 */
	public void selectBillingPeriod() throws IOException {
		ConfigurationBillingProcessPage sp = new ConfigurationBillingProcessPage(driver);
		WebElement Billingelement = driver.findElement(By.xpath("//select[@name='periodUnitId']"));
		Select se = new Select(Billingelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(4));
	}

	@FindBy(how = How.XPATH, using = "//select[@name='proratingType']")
	private WebElement selectNeverProrate;

	/**
	 * Method to select Never enable prorating.
	 * 
	 * @throws IOException
	 */
	public void selectNeverProrate() throws IOException {
		ConfigurationBillingProcessPage sp = new ConfigurationBillingProcessPage(driver);
		log.info("Verifying the Never enable prorating is available or not");
		Select se = new Select(selectNeverProrate);
		se.selectByVisibleText("Never enable prorating");
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickSaveChangesButton() throws IOException {
		ConfigurationBillingProcessPage sp = new ConfigurationBillingProcessPage(driver);
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
