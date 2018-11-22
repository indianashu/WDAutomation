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
 * @author Ashutosh Add Collections
 */

public class ConfigurationCollectionsPage extends BasePage {
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public ConfigurationCollectionsPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(ConfigurationCollectionsPage.class);
	ConfigurationCollectionsPage configurationCollectionsPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "ConfigCollection";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		ConfigurationCollectionsPage sp = new ConfigurationCollectionsPage(driver);

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
		ConfigurationCollectionsPage sp = new ConfigurationCollectionsPage(driver);
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
		ConfigurationCollectionsPage sp = new ConfigurationCollectionsPage(driver);
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
		ConfigurationCollectionsPage sp = new ConfigurationCollectionsPage(driver);
		log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
		Assert.assertTrue(clickLoginButton.isDisplayed());
		clickLoginButton.click();
	}

	@FindBy(how = How.XPATH, using = "//a[.='Collections']")
	private WebElement clickCollections;

	/**
	 * Method to click on Collections.
	 * 
	 * @throws IOException
	 */
	public void clickCollections() throws IOException {
		ConfigurationCollectionsPage sp = new ConfigurationCollectionsPage(driver);
		log.info("Click on Collection");
		JavaScriptExec.sleep();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url2") + "/config/aging";
		driver.get(url);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='obj[0].statusStr']")
	private WebElement enterIDSteps;

	/**
	 * Method to enter IDSteps.
	 * 
	 * @throws IOException
	 */
	public void enterIDSteps() throws IOException {
		ConfigurationCollectionsPage sp = new ConfigurationCollectionsPage(driver);
		log.info("Verifying the IDStep is available or not");
		Assert.assertTrue(enterIDSteps.isDisplayed());
		enterIDSteps.sendKeys(sp.ExcelRead(sheetName).get(3));
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='obj[0].days']")
	private WebElement enterForDays;

	/**
	 * Method to enter For Days.
	 * 
	 * @throws IOException
	 */
	public void enterForDays() throws IOException {
		ConfigurationCollectionsPage sp = new ConfigurationCollectionsPage(driver);
		log.info("Verifying the For Days is available or not");
		Assert.assertTrue(enterForDays.isDisplayed());
		enterForDays.click();
		enterForDays.sendKeys(sp.ExcelRead(sheetName).get(4));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='obj[0].paymentRetry']")
	private WebElement selectPaymentCheckbox;

	/**
	 * Method to select Payment Checkbox.
	 * 
	 * @throws IOException
	 */
	public void selectPaymentCheckbox() throws IOException {
		ConfigurationCollectionsPage sp = new ConfigurationCollectionsPage(driver);
		log.info("Verifying the Payment Checkbox is available or not");
		Assert.assertTrue(selectPaymentCheckbox.isDisplayed());
		selectPaymentCheckbox.click();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='obj[1].statusStr']")
	private WebElement enterIDSteps1;

	/**
	 * Method to enter IDSteps1.
	 * 
	 * @throws IOException
	 */
	public void enterIDSteps1() throws IOException {
		ConfigurationCollectionsPage sp = new ConfigurationCollectionsPage(driver);
		log.info("Verifying the Description is available or not");
		Assert.assertTrue(enterIDSteps1.isDisplayed());
		enterIDSteps1.sendKeys(sp.ExcelRead(sheetName).get(5));
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='obj[1].days']")
	private WebElement enterForDays1;

	/**
	 * Method to enter For Days1.
	 * 
	 * @throws IOException
	 */
	public void enterForDays1() throws IOException {
		ConfigurationCollectionsPage sp = new ConfigurationCollectionsPage(driver);
		log.info("Verifying the For Days is available or not");
		Assert.assertTrue(enterForDays1.isDisplayed());
		enterForDays1.click();
		enterForDays1.sendKeys(sp.ExcelRead(sheetName).get(6));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='obj[1].sendNotification']")
	private WebElement selectNotificationCheckbox;

	/**
	 * Method to select Notification Checkbox.
	 * 
	 * @throws IOException
	 */
	public void selectNotificationCheckbox() throws IOException {
		ConfigurationCollectionsPage sp = new ConfigurationCollectionsPage(driver);
		log.info("Verifying the Notification Checkbox is available or not");
		Assert.assertTrue(selectNotificationCheckbox.isDisplayed());
		selectNotificationCheckbox.click();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='obj[2].statusStr']")
	private WebElement enterIDSteps2;

	/**
	 * Method to enter IDSteps2.
	 * 
	 * @throws IOException
	 */
	public void enterIDSteps2() throws IOException {
		ConfigurationCollectionsPage sp = new ConfigurationCollectionsPage(driver);
		log.info("Verifying the ID Step2 is available or not");
		Assert.assertTrue(enterIDSteps2.isDisplayed());
		enterIDSteps2.sendKeys(sp.ExcelRead(sheetName).get(7));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='obj[2].days']")
	private WebElement enterForDays2;

	/**
	 * Method to enter For Days2.
	 * 
	 * @throws IOException
	 */
	public void enterForDays2() throws IOException {
		ConfigurationCollectionsPage sp = new ConfigurationCollectionsPage(driver);
		log.info("Verifying the For Days is available or not");
		Assert.assertTrue(enterForDays2.isDisplayed());
		enterForDays2.click();
		enterForDays2.sendKeys(sp.ExcelRead(sheetName).get(8));
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='obj[2].paymentRetry']")
	private WebElement selectPaymentCheckbox1;

	/**
	 * Method to select Payment Checkbox.
	 * 
	 * @throws IOException
	 */
	public void selectPaymentCheckbox1() throws IOException {
		ConfigurationCollectionsPage sp = new ConfigurationCollectionsPage(driver);
		log.info("Verifying the Payment Checkbox is available or not");
		Assert.assertTrue(selectPaymentCheckbox1.isDisplayed());
		selectPaymentCheckbox1.click();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='obj[3].statusStr']")
	private WebElement enterIDSteps3;

	/**
	 * Method to enter IDSteps3.
	 * 
	 * @throws IOException
	 */
	public void enterIDSteps3() throws IOException {
		ConfigurationCollectionsPage sp = new ConfigurationCollectionsPage(driver);
		log.info("Verifying the ID Step3 is available or not");
		Assert.assertTrue(enterIDSteps3.isDisplayed());
		enterIDSteps3.sendKeys(sp.ExcelRead(sheetName).get(9));
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='obj[3].days']")
	private WebElement enterForDays3;

	/**
	 * Method to enter For Days3.
	 * 
	 * @throws IOException
	 */
	public void enterForDays3() throws IOException {
		ConfigurationCollectionsPage sp = new ConfigurationCollectionsPage(driver);
		log.info("Verifying the For Days is available or not");
		Assert.assertTrue(enterForDays3.isDisplayed());
		enterForDays3.click();
		enterForDays3.sendKeys(sp.ExcelRead(sheetName).get(10));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='obj[3].suspended']")
	private WebElement selectSuspendCheckbox1;

	/**
	 * Method to select Suspend Checkbox.
	 * 
	 * @throws IOException
	 */
	public void selectSuspendCheckbox1() throws IOException {
		ConfigurationCollectionsPage sp = new ConfigurationCollectionsPage(driver);
		log.info("Verifying the Suspend Checkbox is available or not");
		Assert.assertTrue(selectSuspendCheckbox1.isDisplayed());
		selectSuspendCheckbox1.click();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public String clickSaveChangesButton() throws IOException {
		ConfigurationCollectionsPage sp = new ConfigurationCollectionsPage(driver);
		log.info("Click on Save Changes Button");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		clickSaveChangesButton.click();
		JavaScriptExec.sleep();
		String gracePeriodId = driver.findElement(By.xpath("//*[@id='ageingStepTable']/tbody/tr[2]/td[1]/strong"))
				.getText();
		System.out.println(gracePeriodId);
		return gracePeriodId;
	}

	@FindBy(how = How.XPATH, using = "//div[@class='msg-box successfully']//*[text()='Done']")
	private WebElement verifyConfirmationMsg;

	/**
	 * Method to verify Collections are created/updated Successfully.
	 * 
	 * @throws IOException
	 */
	public void verifyConfirmationMsg() throws IOException {
		ConfigurationCollectionsPage sp = new ConfigurationCollectionsPage(driver);
		log.info("Verifying if Collections are created/updated Successfully or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyConfirmationMsg.isDisplayed(),
				"Assert Failed as its unable to search text in Logged in Page");
	}

	// Configure Collections Plugins - userAgeingNotificationTask

	@FindBy(how = How.XPATH, using = "//a[.='Plug-ins']")
	private WebElement clickPluginsLink;

	/**
	 * Method to click on Plugins Link.
	 * 
	 * @throws IOException
	 */
	public void clickPluginsLink() throws IOException {
		ConfigurationCollectionsPage sp = new ConfigurationCollectionsPage(driver);
		log.info("Click on Plugins Link");
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url2") + "/plugin/list";
		driver.get(url);
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//td[preceding-sibling::td[contains(.,'17')]]")
	private WebElement clickCategory17;

	/**
	 * Method to click on category 17 - Generic internal events listener.
	 * 
	 * @throws IOException
	 */
	public void clickCategory17() throws IOException {
		ConfigurationCollectionsPage sp = new ConfigurationCollectionsPage(driver);
		log.info("click on category 17 - Generic internal events listener.");
		Assert.assertTrue(clickCategory17.isDisplayed());
		clickCategory17.click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add New']")
	private WebElement clickAddNewButton;

	/**
	 * Method to click on Add New button.
	 * 
	 * @throws IOException
	 */
	public void clickAddNewButton() throws IOException {
		ConfigurationCollectionsPage sp = new ConfigurationCollectionsPage(driver);
		log.info("click on Add New button.");
		Assert.assertTrue(clickAddNewButton.isDisplayed());
		clickAddNewButton.click();
		JavaScriptExec.sleep();

	}

	private WebElement selectTypeID;

	/**
	 * Method to select TypeID.
	 * 
	 * @throws IOException
	 */
	public void selectTypeID() throws IOException {
		ConfigurationCollectionsPage sp = new ConfigurationCollectionsPage(driver);
		WebElement TypeIDelement = driver.findElement(By.xpath("//select[@name='typeId']"));
		Select se = new Select(TypeIDelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(11));
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='processingOrder']")
	private WebElement enterProcessingOrder;

	/**
	 * Method to Enter Processing Order.
	 * 
	 * @throws IOException
	 */
	public void enterProcessingOrder() throws IOException {
		ConfigurationCollectionsPage sp = new ConfigurationCollectionsPage(driver);
		log.info("Enter Processing Order.");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, enterProcessingOrder);
		Assert.assertTrue(enterProcessingOrder.isDisplayed());
		enterProcessingOrder.sendKeys(sp.ExcelRead(sheetName).get(12));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='plgDynamic.1.name']")
	private WebElement enterLeftAttribute;

	/**
	 * Method to Enter Left Attribute.
	 * 
	 * @throws IOException
	 */
	public void enterLeftAttribute() throws IOException {
		ConfigurationCollectionsPage sp = new ConfigurationCollectionsPage(driver);
		log.info("Enter Left Attribute.");
		Assert.assertTrue(enterLeftAttribute.isDisplayed());
		enterLeftAttribute.sendKeys(sp.ExcelRead(sheetName).get(13));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='plgDynamic.1.value']")
	private WebElement enterRightAttribute;

	/**
	 * Method to Enter Right Attribute.
	 * 
	 * @throws IOException
	 */
	public void enterRightAttribute(String gracePeriodId) throws IOException {
		ConfigurationCollectionsPage sp = new ConfigurationCollectionsPage(driver);
		log.info("Enter Right Attribute.");
		JavaScriptExec.sleep();
		Assert.assertTrue(enterRightAttribute.isDisplayed());
		enterRightAttribute.sendKeys(gracePeriodId);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='plugin-parameters']/div/div/div[2]/table/tbody/tr/td[3]/a/img")
	private WebElement clickPlusIcon;

	/**
	 * Method to click on Plus Icon.
	 * 
	 * @throws IOException
	 */
	public void clickPlusIcon() throws IOException {
		ConfigurationCollectionsPage sp = new ConfigurationCollectionsPage(driver);
		log.info("Click on Plus Icon.");
		Assert.assertTrue(clickPlusIcon.isDisplayed());
		clickPlusIcon.click();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Plug-in']")
	private WebElement clickSavePluginButton;

	/**
	 * Method to click on Save Plugin Button.
	 * 
	 * @throws IOException
	 */
	public void clickSavePluginButton() throws IOException {
		ConfigurationCollectionsPage sp = new ConfigurationCollectionsPage(driver);
		log.info("Click on Save Plugin Button.");
		navigateBottom();
		Assert.assertTrue(clickSavePluginButton.isDisplayed());
		clickSavePluginButton.click();
	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}

}
