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
 * @author Ashutosh Add New Information Type for an Account
 */

public class ConfigurationNewInformationTypePage extends BasePage {
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public ConfigurationNewInformationTypePage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(ConfigurationNewInformationTypePage.class);
	ConfigurationNewInformationTypePage configurationNewInformationTypePage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "ConfigNewInfoType";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		ConfigurationNewInformationTypePage sp = new ConfigurationNewInformationTypePage(driver);

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
		ConfigurationNewInformationTypePage sp = new ConfigurationNewInformationTypePage(driver);
		log.info("Verifying the First Name is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, enterPassword);
		Assert.assertTrue(enterPassword.isDisplayed());
		enterPassword.sendKeys(sp.ExcelRead(sheetName).get(1));

	}

	private WebElement selectCompany;

	/**
	 * Method to select Company.
	 * 
	 * @throws IOException
	 */
	public void selectCompany() throws IOException {
		ConfigurationNewInformationTypePage sp = new ConfigurationNewInformationTypePage(driver);
		WebElement Companyelement = driver.findElement(By.xpath("//select[@name='j_client_id']"));
		Select se = new Select(Companyelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(2));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']")
	private WebElement clickLoginButton;

	/**
	 * Method to Click on Save Changes Button
	 */
	public void clickLoginButton() {
		ConfigurationNewInformationTypePage sp = new ConfigurationNewInformationTypePage(driver);
		log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
		Assert.assertTrue(clickLoginButton.isDisplayed());
		clickLoginButton.click();
	}

	@FindBy(how = How.XPATH, using = "//a[.='Account Type']")
	private WebElement clickAccountType;

	/**
	 * Method to click on Account Type.
	 * 
	 * @throws IOException
	 */
	public void clickAccountType() throws IOException {
		ConfigurationNewInformationTypePage sp = new ConfigurationNewInformationTypePage(driver);
		log.info("Click on Account Type");
		JavaScriptExec.sleep();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url2") + "/accountType/list";
		driver.get(url);
	}

	@FindBy(how = How.XPATH, using = "//a[@class='cell double']//*[text()='Direct Customer']")
	private WebElement clickAccountTypeCreated;

	/**
	 * Method to click on account type created.
	 * 
	 * @throws IOException
	 */
	public void clickAccountTypeCreated() throws IOException {
		ConfigurationNewInformationTypePage sp = new ConfigurationNewInformationTypePage(driver);
		log.info("Click on account type created");
		Assert.assertTrue(clickAccountTypeCreated.isDisplayed());
		clickAccountTypeCreated.click();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit edit']//*[text()='Add Information Type']")
	private WebElement clickAddInformationTypeButton;

	/**
	 * Method to Add Information Type Button.
	 * 
	 * @throws IOException
	 */
	public void enterAccountName() throws IOException {
		ConfigurationNewInformationTypePage sp = new ConfigurationNewInformationTypePage(driver);
		log.info("Add Information Type Button is available or not");
		Assert.assertTrue(clickAddInformationTypeButton.isDisplayed());
		clickAddInformationTypeButton.click();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='name']")
	private WebElement enterName;

	/**
	 * Method to Enter Name.
	 * 
	 * @throws IOException
	 */
	public void enterName() throws IOException {
		ConfigurationNewInformationTypePage sp = new ConfigurationNewInformationTypePage(driver);
		log.info("Name is available or not");
		Assert.assertTrue(enterName.isDisplayed());
		enterName.sendKeys(sp.ExcelRead(sheetName).get(3));

	}

	@FindBy(how = How.XPATH, using = "//*[@name='displayOrder']")
	private WebElement enterdisplayOrder;

	/**
	 * Method to Enter Name.
	 * 
	 * @throws IOException
	 */
	public void enterdisplayOrder() throws IOException {
		ConfigurationNewInformationTypePage sp = new ConfigurationNewInformationTypePage(driver);
		log.info("Display Order is available or not");
		Assert.assertTrue(enterdisplayOrder.isDisplayed());
		enterdisplayOrder.sendKeys(sp.ExcelRead(sheetName).get(6));

	}

	@FindBy(how = How.XPATH, using = "//*[@name='useForNotifications']")
	private WebElement checkuseForNotifications;

	/**
	 * Method to Enter Name.
	 * 
	 * @throws IOException
	 */
	public void checkuseForNotifications() throws IOException {
		ConfigurationNewInformationTypePage sp = new ConfigurationNewInformationTypePage(driver);
		log.info("Display Order is available or not");
		Assert.assertTrue(checkuseForNotifications.isDisplayed());
		checkuseForNotifications.click();
		log.info("click on yes button");
		WebElement clickYesPopup = driver.findElement(By.xpath("//*[text()='Yes']"));
		Assert.assertTrue(clickYesPopup.isDisplayed());
		clickYesPopup.click();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Add New Metafield']")
	private WebElement clickAddNewMetafieldButton;

	/**
	 * Method to Add New Metafield Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddNewMetafieldButton() throws IOException {
		ConfigurationNewInformationTypePage sp = new ConfigurationNewInformationTypePage(driver);
		log.info("Add Information Type Button is available or not");
		Assert.assertTrue(clickAddNewMetafieldButton.isDisplayed());
		clickAddNewMetafieldButton.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//span[@class='description']")
	private WebElement clickDecription;

	/**
	 * Method to Click Description "-".
	 * 
	 * @throws IOException
	 */
	public void clickDecription() throws IOException {
		ConfigurationNewInformationTypePage sp = new ConfigurationNewInformationTypePage(driver);
		log.info("Description - is available or not");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, clickDecription);
		Assert.assertTrue(clickDecription.isDisplayed());
		clickDecription.click();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='metaField0.name']")
	private WebElement enterMetafieldName;

	/**
	 * Method to Enter Name.
	 * 
	 * @throws IOException
	 */
	public void enterMetafieldName() throws IOException {
		ConfigurationNewInformationTypePage sp = new ConfigurationNewInformationTypePage(driver);
		log.info("Name is available or not");
		Assert.assertTrue(enterMetafieldName.isDisplayed());
		enterMetafieldName.sendKeys(sp.ExcelRead(sheetName).get(4));

	}

	private WebElement selectMetafieldType;

	/**
	 * Method to select Metafield Type.
	 * 
	 * @throws IOException
	 */
	public void selectMetafieldType() throws IOException {
		ConfigurationNewInformationTypePage sp = new ConfigurationNewInformationTypePage(driver);
		WebElement MetafieldTypeelement = driver.findElement(By.xpath("//select[@name='fieldType0']"));
		Select se = new Select(MetafieldTypeelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(5));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Update']")
	private WebElement clickUpdateButton;

	/**
	 * Method to click on Update Button.
	 * 
	 * @throws IOException
	 */
	public void clickUpdateButton() throws IOException {
		ConfigurationNewInformationTypePage sp = new ConfigurationNewInformationTypePage(driver);
		log.info("Click on Update Button");
		Assert.assertTrue(clickUpdateButton.isDisplayed());
		clickUpdateButton.click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickSaveChangesButton() throws IOException {
		ConfigurationNewInformationTypePage sp = new ConfigurationNewInformationTypePage(driver);
		log.info("Click on Save Changes Button");
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		clickSaveChangesButton.click();

	}

	@FindBy(how = How.XPATH, using = "//div[@class='msg-box successfully']//*[text()='Account Information Type created successfully']")
	private WebElement verifyConfirmationMsg;

	/**
	 * Method to verify Account Type is created Successfully.
	 * 
	 * @throws IOException
	 */
	public void verifyConfirmationMsg() throws IOException {
		ConfigurationNewInformationTypePage sp = new ConfigurationNewInformationTypePage(driver);
		log.info("Verifying if Account Type is created Successfully or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyConfirmationMsg.isDisplayed(),
				"Assert Failed as its unable to search text in Logged in Page");
	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}

}
