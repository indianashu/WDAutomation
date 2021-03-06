package collections;

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
 * @author Ashutosh
 *
 */

public class CollectionConfigurationPage extends BasePage {
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public CollectionConfigurationPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(CollectionConfigurationPage.class);
	CollectionConfigurationPage collectionConfigurationPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "Collections";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		CollectionConfigurationPage sp = new CollectionConfigurationPage(driver);

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
		CollectionConfigurationPage sp = new CollectionConfigurationPage(driver);
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
		CollectionConfigurationPage sp = new CollectionConfigurationPage(driver);
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
		CollectionConfigurationPage sp = new CollectionConfigurationPage(driver);
		log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
		Assert.assertTrue(clickLoginButton.isDisplayed());
		clickLoginButton.click();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu.link.customers']/a")
	private WebElement clickCustomerTab;

	/**
	 * Method to click on Customer tab after successful login.
	 * 
	 * @throws IOException
	 */
	public void clickCustomerTab() throws IOException {
		CollectionConfigurationPage sp = new CollectionConfigurationPage(driver);
		log.info("Click on Customer Tab after successful login");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickCustomerTab.isDisplayed());
		clickCustomerTab.click();

	}


	/**
	 * Method to Click on Billing Customer2.
	 * 
	 * @throws IOException
	 */
	public void clickBillingCustomer(int rownum) throws IOException {
		CollectionConfigurationPage sp = new CollectionConfigurationPage(driver);
		log.info("Click on Billing Customer2");
		String BillingCustomer = sp.ExcelRead(sheetName).get(rownum);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + BillingCustomer + "']")).click();

	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='filters.CUSTOMER-LIKE_UserName.stringValue']")
	private WebElement enterCustomerNameFilter;

	/**
	 * Method to enter the customer name in the Login name Filter.
	 * 
	 * @throws IOException
	 */
	public void enterCustomerNameFilter(int rownum) throws IOException {
		CollectionConfigurationPage sp = new CollectionConfigurationPage(driver);
		log.info("Enter the name of the Customer in the Filte Login name");
		Assert.assertTrue(enterCustomerNameFilter.isDisplayed());
		enterCustomerNameFilter.clear();
		enterCustomerNameFilter.sendKeys(sp.ExcelRead(sheetName).get(rownum));
		JavaScriptExec.sleep();
	}
	
	@FindBy(how = How.XPATH, using = "//*[@class='submit apply']//*[text()='Apply Filters']")
	private WebElement applyFilter;

	/**
	 * Method to Click on the Apply Filter Button.
	 * 
	 * @throws IOException
	 */
	public void applyFilter() throws IOException {
		CollectionConfigurationPage sp = new CollectionConfigurationPage(driver);
		log.info("Click on Apply Filter");
		Assert.assertTrue(applyFilter.isDisplayed());
		applyFilter.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit edit']//*[text()='Edit']")
	private WebElement clickEditButton;

	/**
	 * Method to click on edit button.
	 * 
	 * @throws IOException
	 */
	public void clickEditButton() throws IOException {
		JavaScriptExec.scrollToElementOnPage(driver, clickEditButton);
		CollectionConfigurationPage sp = new CollectionConfigurationPage(driver);
		log.info("Click on Edit Button");
		Assert.assertTrue(clickEditButton.isDisplayed());
		clickEditButton.click();
		JavaScriptExec.sleep();

	}

	private WebElement selectPaymentMethod;

	/**
	 * Method to select Payment Method.
	 * 
	 * @throws IOException
	 */
	public void selectPaymentMethod() throws IOException {
		CollectionConfigurationPage sp = new CollectionConfigurationPage(driver);
		WebElement PMelement = driver.findElement(By.xpath("//select[@name='paymentMethod_0.paymentMethodTypeId']"));
		Select se = new Select(PMelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(4));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='0_metaField_86.value']")
	private WebElement enterCardHolderName;

	/**
	 * Method to enter Card Holder Name.
	 * 
	 * @throws IOException
	 */
	public void enterCardHolderName() throws IOException {
		CollectionConfigurationPage sp = new CollectionConfigurationPage(driver);
		log.info("Enter Cardholder Name");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, enterCardHolderName);
		Assert.assertTrue(enterCardHolderName.isDisplayed());
		enterCardHolderName.sendKeys(sp.ExcelRead(sheetName).get(5));

	}

	@FindBy(how = How.XPATH, using = "//label[contains(.,'cc.number')]/following::input[1]")
	private WebElement enterCardNumber;

	/**
	 * Method to enter Card Number.
	 * 
	 * @throws IOException
	 */
	public void enterCardNumber() throws IOException {
		CollectionConfigurationPage sp = new CollectionConfigurationPage(driver);
		log.info("Enter Cardholder Number");
		Assert.assertTrue(enterCardNumber.isDisplayed());
		enterCardNumber.clear();
		enterCardNumber.sendKeys(sp.ExcelRead(sheetName).get(6));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='0_metaField_83.value']")
	private WebElement enterCardExpiry;

	/**
	 * Method to enter Card Expiry.
	 * 
	 * @throws IOException
	 */
	public void enterCardExpiry() throws IOException {
		CollectionConfigurationPage sp = new CollectionConfigurationPage(driver);
		log.info("Enter Cardholder Number");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, enterCardExpiry);
		Assert.assertTrue(enterCardExpiry.isDisplayed());
		enterCardExpiry.sendKeys(sp.ExcelRead(sheetName).get(7));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickSaveChangesButton() throws IOException {
		CollectionConfigurationPage sp = new CollectionConfigurationPage(driver);
		log.info("Click on Save Changes Button");
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		clickSaveChangesButton.click();

	}
	
	@FindBy(how = How.XPATH, using = "//a[.='Configuration']")
	private WebElement clickConfigurationTab;

	/**
	 * Method to click on Configuration tab after successful login.
	 * 
	 * @throws IOException
	 */
	public void clickConfigurationTab() throws IOException {
		CollectionConfigurationPage sp = new CollectionConfigurationPage(driver);
		log.info("Click on Configuration Tab after successful login");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, clickConfigurationTab);
		Assert.assertTrue(clickConfigurationTab.isDisplayed());
		clickConfigurationTab.click();

	}

	@FindBy(how = How.XPATH, using = "//a[.='Collections']")
	private WebElement clickCollectionsLink;

	/**
	 * Method to Click on Collections Link.
	 * 
	 * @throws IOException
	 */
	public void clickCollectionsLink() throws IOException {
		CollectionConfigurationPage sp = new CollectionConfigurationPage(driver);
		log.info("Click on Collections Link.");
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url2") + "/config/aging";
		driver.get(url);
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='collectionsRunDate']")
	private WebElement enterRunCollectionDate;

	/**
	 * Method to enter Run Collection Date.
	 * 
	 * @throws IOException
	 */
	public void enterRunCollectionDate() throws IOException {
		CollectionConfigurationPage sp = new CollectionConfigurationPage(driver);
		log.info("Enter Run Collection Date");
		Assert.assertTrue(enterRunCollectionDate.isDisplayed());
		enterRunCollectionDate.clear();
		enterRunCollectionDate.sendKeys(sp.ExcelRead(sheetName).get(8));

	}

	@FindBy(how = How.XPATH, using = "//input[@value='Run Collections']")
	private WebElement clickRunCollectionsButton;

	/**
	 * Method to Click on Run Collections Button.
	 * 
	 * @throws IOException
	 */
	public void clickRunCollectionsButton() throws IOException {
		CollectionConfigurationPage sp = new CollectionConfigurationPage(driver);
		log.info("Click on Run Collections Button.");
		String value = sp.ExcelRead(sheetName).get(12);
		driver.findElement(By.xpath("//input[@value='" + value + "']")).click();
		JavaScriptExec.sleep();
		Assert.assertTrue(clickRunCollectionsButton.isDisplayed());
		clickRunCollectionsButton.click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//*[@id='runCollection']")
	private WebElement clickRunCollectionsPopup;

	/**
	 * Method to Click on Run Collections Popup.
	 * 
	 * @throws IOException
	 */
	public void clickRunCollectionsPopup() throws IOException {
		CollectionConfigurationPage sp = new CollectionConfigurationPage(driver);
		log.info("Click on Run Collections Popup.");
		Assert.assertTrue(clickRunCollectionsPopup.isDisplayed());
		clickRunCollectionsPopup.click();
		JavaScriptExec.sleep();

	}

	// @FindBy(how=How.XPATH, using="//a[@id='41']//*[text()='Active']")
	private WebElement verifyBillingCustomer1Status;

	/**
	 * Method to Verify status of Billing Customer1.
	 * 
	 * @throws IOException
	 */
	public void verifyBillingCustomer1Status() throws IOException {
		CollectionConfigurationPage sp = new CollectionConfigurationPage(driver);
		log.info("Verify status of Billing Customer1");
		String CustomerID = sp.ExcelRead(sheetName).get(19);
		String ActualStatus = driver.findElement(By.xpath("//*[text()='" + CustomerID + "']/following::span[2]"))
				.getText();
		System.out.println("Status of the Billing Customer1---->" + ActualStatus);
		JavaScriptExec.sleep();
		String StatusExpected = sp.ExcelRead(sheetName).get(10);
		Assert.assertEquals(ActualStatus, StatusExpected);

	}

	// @FindBy(how=How.XPATH, using="//a[@id='42']//*[text()='Active']")
	private WebElement verifyBillingCustomer2Status;

	/**
	 * Method to Verify status of Billing Customer2.
	 * 
	 * @throws IOException
	 */
	public void verifyBillingCustomer2Status() throws IOException {
		CollectionConfigurationPage sp = new CollectionConfigurationPage(driver);
		log.info("Verify status of Billing Customer2");
		JavaScriptExec.sleep();
		String ActualStatus = driver.findElement(By.xpath("//td[text()='Status']/following::td[1]")).getText();
		System.out.println("Status of the Billing Customer2---->" + ActualStatus);
		String StatusExpected = sp.ExcelRead(sheetName).get(12);
		Assert.assertEquals(ActualStatus, StatusExpected);

	}

	@FindBy(how = How.XPATH, using = "//input[@name='collectionsRunDate']")
	private WebElement enterRunCollectionDate1;

	/**
	 * Method to enter Run Collection Date.
	 * 
	 * @throws IOException
	 */
	public void enterRunCollectionDate1() throws IOException {
		CollectionConfigurationPage sp = new CollectionConfigurationPage(driver);
		log.info("Enter Run Collection Date");
		JavaScriptExec.sleep();
		Assert.assertTrue(enterRunCollectionDate1.isDisplayed());
		enterRunCollectionDate1.clear();
		enterRunCollectionDate1.sendKeys(sp.ExcelRead(sheetName).get(13));

	}

	// @FindBy(how=How.XPATH, using="//a[@id='42']//*[text()='Active']")
	private WebElement verifyBillingCustomer2Status1;

	/**
	 * Method to Verify status of Billing Customer2.
	 * 
	 * @throws IOException
	 */
	public void verifyBillingCustomer2Status1() throws IOException {
		CollectionConfigurationPage sp = new CollectionConfigurationPage(driver);
		log.info("Verify status of Billing Customer2");
		JavaScriptExec.sleep();
		String ActualStatus = driver.findElement(By.xpath("//td[text()='Status']/following::td[1]")).getText();
		System.out.println("Status of the Billing Customer2---->" + ActualStatus);
		String StatusExpected = sp.ExcelRead(sheetName).get(14);
		Assert.assertEquals(ActualStatus, StatusExpected);

	}

	@FindBy(how = How.XPATH, using = "//input[@name='collectionsRunDate']")
	private WebElement enterRunCollectionDate2;

	/**
	 * Method to enter Run Collection Date.
	 * 
	 * @throws IOException
	 */
	public void enterRunCollectionDate2() throws IOException {
		CollectionConfigurationPage sp = new CollectionConfigurationPage(driver);
		log.info("Enter Run Collection Date");
		Assert.assertTrue(enterRunCollectionDate2.isDisplayed());
		enterRunCollectionDate2.clear();
		enterRunCollectionDate2.sendKeys(sp.ExcelRead(sheetName).get(15));

	}

	// @FindBy(how=How.XPATH, using="//a[@id='42']//*[text()='Active']")
	private WebElement verifyBillingCustomer2Status2;

	/**
	 * Method to Verify status of Billing Customer2.
	 * 
	 * @throws IOException
	 */
	public void verifyBillingCustomer2Status2() throws IOException {
		CollectionConfigurationPage sp = new CollectionConfigurationPage(driver);
		log.info("Verify status of Billing Customer2");
		JavaScriptExec.sleep();
		String ActualStatus = driver.findElement(By.xpath("//td[text()='Status']/following::td[1]")).getText();
		System.out.println("Status of the Billing Customer2---->" + ActualStatus);
		String StatusExpected = sp.ExcelRead(sheetName).get(16);
		Assert.assertEquals(ActualStatus, StatusExpected);

	}

	@FindBy(how = How.XPATH, using = "//input[@name='collectionsRunDate']")
	private WebElement enterRunCollectionDate3;

	/**
	 * Method to enter Run Collection Date.
	 * 
	 * @throws IOException
	 */
	public void enterRunCollectionDate3() throws IOException {
		CollectionConfigurationPage sp = new CollectionConfigurationPage(driver);
		log.info("Enter Run Collection Date");
		Assert.assertTrue(enterRunCollectionDate3.isDisplayed());
		enterRunCollectionDate3.clear();
		enterRunCollectionDate3.sendKeys(sp.ExcelRead(sheetName).get(17));

	}

	// @FindBy(how=How.XPATH, using="//a[@id='42']//*[text()='Active']")
	private WebElement verifyBillingCustomer2Status3;

	/**
	 * Method to Verify status of Billing Customer2.
	 * 
	 * @throws IOException
	 */
	public void verifyBillingCustomer2Status3() throws IOException {
		CollectionConfigurationPage sp = new CollectionConfigurationPage(driver);
		log.info("Verify status of Billing Customer2");
		JavaScriptExec.sleep();
		String ActualStatus = driver.findElement(By.xpath("//td[text()='Status']/following::td[1]")).getText();
		System.out.println("Status of the Billing Customer2---->" + ActualStatus);
		String StatusExpected = sp.ExcelRead(sheetName).get(18);
		Assert.assertEquals(ActualStatus, StatusExpected);

	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}

}
