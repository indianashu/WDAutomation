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
 * @author Ashutosh Add Order Periods - Semi Monthly
 */

public class ConfigurationOrderPeriodsPage extends BasePage {
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public ConfigurationOrderPeriodsPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(ConfigurationOrderPeriodsPage.class);
	ConfigurationOrderPeriodsPage configurationOrderPeriodsPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "ConfigOrderPeriods";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		ConfigurationOrderPeriodsPage sp = new ConfigurationOrderPeriodsPage(driver);

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
		ConfigurationOrderPeriodsPage sp = new ConfigurationOrderPeriodsPage(driver);
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
		ConfigurationOrderPeriodsPage sp = new ConfigurationOrderPeriodsPage(driver);
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
		ConfigurationOrderPeriodsPage sp = new ConfigurationOrderPeriodsPage(driver);
		log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
		Assert.assertTrue(clickLoginButton.isDisplayed());
		clickLoginButton.click();
	}

	@FindBy(how = How.XPATH, using = "//a[.='Configuration']")
	private WebElement clickConfigurationTab;

	/**
	 * Method to click on Configuration tab after successful login.
	 * 
	 * @throws IOException
	 */
	public void clickConfigurationTab() throws IOException {
		ConfigurationOrderPeriodsPage sp = new ConfigurationOrderPeriodsPage(driver);
		log.info("Click on Configuration Tab after successful login");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, clickConfigurationTab);
		Assert.assertTrue(clickConfigurationTab.isDisplayed());
		clickConfigurationTab.click();

	}

	@FindBy(how = How.XPATH, using = "//a[.='Order Periods']")
	private WebElement clickOrderPeriods;

	/**
	 * Method to click on Order Periods.
	 * 
	 * @throws IOException
	 */
	public void clickOrderPeriods() throws IOException {
		ConfigurationOrderPeriodsPage sp = new ConfigurationOrderPeriodsPage(driver);
		log.info("Click on Order Periods");
		JavaScriptExec.sleep();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url2") + "/orderPeriod/list";
		driver.get(url);
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add New']")
	private WebElement clickAddNewButton;

	/**
	 * Method to click on Add New Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddNewButton() throws IOException {
		ConfigurationOrderPeriodsPage sp = new ConfigurationOrderPeriodsPage(driver);
		log.info("Click on Add New");
		Assert.assertTrue(clickAddNewButton.isDisplayed());
		clickAddNewButton.click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='description']")
	private WebElement enterDescription;

	/**
	 * Method to enter Description.
	 * 
	 * @throws IOException
	 */
	public void enterDescription() throws IOException {
		ConfigurationOrderPeriodsPage sp = new ConfigurationOrderPeriodsPage(driver);
		log.info("Verifying the Description is available or not");
		Assert.assertTrue(enterDescription.isDisplayed());
		enterDescription.sendKeys(sp.ExcelRead(sheetName).get(3));

	}

	/**
	 * Method to select Unit.
	 * 
	 * @throws IOException
	 */
	public void selectUnit() throws IOException {
		ConfigurationOrderPeriodsPage sp = new ConfigurationOrderPeriodsPage(driver);
		WebElement Unitelement = driver.findElement(By.xpath("//select[@name='periodUnitId']"));
		Select se = new Select(Unitelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(4));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='value']")
	private WebElement enterValue;

	/**
	 * Method to enter Value.
	 * 
	 * @throws IOException
	 */
	public void enterValue() throws IOException {
		ConfigurationOrderPeriodsPage sp = new ConfigurationOrderPeriodsPage(driver);
		log.info("Verifying the Description is available or not");
		Assert.assertTrue(enterValue.isDisplayed());
		enterValue.sendKeys(sp.ExcelRead(sheetName).get(5));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickSaveChangesButton() throws IOException {
		ConfigurationOrderPeriodsPage sp = new ConfigurationOrderPeriodsPage(driver);
		log.info("Click on Save Changes Button");
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		clickSaveChangesButton.click();

	}

	@FindBy(how = How.XPATH, using = "//div[@class='msg-box successfully']//*[text()='Done']")
	private WebElement verifyConfirmationMsg;

	/**
	 * Method to verify Order Period is created Successfully.
	 * 
	 * @throws IOException
	 */
	public void verifyConfirmationMsg() throws IOException {
		ConfigurationOrderPeriodsPage sp = new ConfigurationOrderPeriodsPage(driver);
		log.info("Verifying if Order Period is created Successfully or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyConfirmationMsg.isDisplayed(),
				"Assert Failed as its unable to search text in Logged in Page");
	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}

}
