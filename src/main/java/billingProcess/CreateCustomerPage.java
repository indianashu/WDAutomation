package billingProcess;

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

public class CreateCustomerPage extends BasePage {
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public CreateCustomerPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(CreateCustomerPage.class);
	CreateCustomerPage createCustomerPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "BillCreateCustomers";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		CreateCustomerPage sp = new CreateCustomerPage(driver);

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
		CreateCustomerPage sp = new CreateCustomerPage(driver);
		log.info("Verifying the First Name is available or not");
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
		CreateCustomerPage sp = new CreateCustomerPage(driver);
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
		CreateCustomerPage sp = new CreateCustomerPage(driver);
		log.info("Verifying the login button is available or not");
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
		CreateCustomerPage sp = new CreateCustomerPage(driver);
		log.info("Click on Customer Tab after successful login");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickCustomerTab.isDisplayed());
		clickCustomerTab.click();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add New']")
	private WebElement clickAddNewButton;

	/**
	 * Method to click on Add New Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddNewButton() throws IOException {
		JavaScriptExec.scrollToElementOnPage(driver, clickAddNewButton);
		CreateCustomerPage sp = new CreateCustomerPage(driver);
		log.info("Click on Add New Button");
		Assert.assertTrue(clickAddNewButton.isDisplayed());
		clickAddNewButton.click();
		JavaScriptExec.sleep();

	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='user.entityId']")
	private WebElement selectUserCompany;

	/**
	 * Method to select user company.
	 * 
	 * @throws IOException
	 */
	public void selectUserCompany() throws IOException {
		CreateCustomerPage sp = new CreateCustomerPage(driver);
		Select se = new Select(selectUserCompany);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(3));

	}

	private WebElement selectAccountType;

	/**
	 * Method to select account type.
	 * 
	 * @throws IOException
	 */
	public void selectAccountType() throws IOException {
		CreateCustomerPage sp = new CreateCustomerPage(driver);
		WebElement AccountTypeelement = driver.findElement(By.xpath("//select[@name='accountTypeId']"));
		Select se = new Select(AccountTypeelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(4));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Select']")
	private WebElement clickSelectButton;

	/**
	 * Method to click on select Button.
	 * 
	 * @throws IOException
	 */
	public void clickSelectButton() throws IOException {
		CreateCustomerPage sp = new CreateCustomerPage(driver);
		log.info("Click on select Button");
		Assert.assertTrue(clickSelectButton.isDisplayed());
		clickSelectButton.click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='user.userName']")
	private WebElement enterLoginName;

	/**
	 * Method to Enter Login Name.
	 * 
	 * @throws IOException
	 */
	public void enterLoginName() throws IOException {
		CreateCustomerPage sp = new CreateCustomerPage(driver);
		log.info("Enter Login Name");
		Assert.assertTrue(enterLoginName.isDisplayed());
		enterLoginName.sendKeys(sp.ExcelRead(sheetName).get(5));

	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='user.currencyId']")
	private WebElement selectCurrency;

	/**
	 * Method to select billing cycle unit.
	 * 
	 * @throws IOException
	 */
	public void selectCurrency() throws IOException {
		CreateCustomerPage sp = new CreateCustomerPage(driver);
		log.info("Enter Login Name");
		Select se = new Select(selectCurrency);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(18));
	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='mainSubscription.periodId']")
	private WebElement selectBillingCycleUnit;

	/**
	 * Method to select billing cycle unit.
	 * 
	 * @throws IOException
	 */
	public void selectBillingCycleUnit() throws IOException {
		CreateCustomerPage sp = new CreateCustomerPage(driver);
		Select se = new Select(selectBillingCycleUnit);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(6));

	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='mainSubscription.nextInvoiceDayOfPeriod']")
	private WebElement selectBillingCycleDay;

	/**
	 * Method to select billing cycle day.
	 * 
	 * @throws IOException
	 */
	public void selectBillingCycleDay() throws IOException {
		CreateCustomerPage sp = new CreateCustomerPage(driver);
		Select se = new Select(selectBillingCycleDay);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(7));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='paymentMethod_0.processingOrder']")
	private WebElement enterProcessingOrder;

	/**
	 * Method to Enter Processing Order.
	 * 
	 * @throws IOException
	 */
	public void enterProcessingOrder() throws IOException {
		CreateCustomerPage sp = new CreateCustomerPage(driver);
		log.info("Click on Save Changes Button");
		JavaScriptExec.scrolltoBottomofPage(driver);
		Assert.assertTrue(enterProcessingOrder.isDisplayed());
		enterProcessingOrder.sendKeys(sp.ExcelRead(sheetName).get(8));

	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='paymentMethod_0.paymentMethodTypeId']")
	private WebElement selectPaymentMethodType;
	/**
	 * Method to select payment method type.
	 * 
	 * @throws IOException
	 */
	public void selectPaymentMethodType() throws IOException {
		CreateCustomerPage sp = new CreateCustomerPage(driver);
		Select se = new Select(selectPaymentMethodType);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(17));
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//label[contains(.,'cc.cardholder.name')]/following::input[1]")
	private WebElement enterCardHolderName;

	/**
	 * Method to Enter card holder name.
	 * 
	 * @throws IOException
	 */
	public void enterCardHolderName() throws IOException {
		CreateCustomerPage sp = new CreateCustomerPage(driver);
		log.info("Enter card holder name");
		Assert.assertTrue(enterCardHolderName.isDisplayed());
		enterCardHolderName.sendKeys(sp.ExcelRead(sheetName).get(9));

	}

	@FindBy(how = How.XPATH, using = "//label[contains(.,'cc.number')]/following::input[1]")
	private WebElement enterCardNumber;

	/**
	 * Method to Enter card number.
	 * 
	 * @throws IOException
	 */
	public void enterCardNumber() throws IOException {
		CreateCustomerPage sp = new CreateCustomerPage(driver);
		log.info("Enter card number");
		Assert.assertTrue(enterCardNumber.isDisplayed());
		enterCardNumber.sendKeys(sp.ExcelRead(sheetName).get(10));

	}

	@FindBy(how = How.XPATH, using = "//label[contains(.,'cc.expiry.date')]/following::input[1]")
	private WebElement enterCardExpiry;

	/**
	 * Method to Enter card expiry date.
	 * 
	 * @throws IOException
	 */
	public void enterCardExpiry() throws IOException {
		CreateCustomerPage sp = new CreateCustomerPage(driver);
		log.info("Enter card number");
		Assert.assertTrue(enterCardExpiry.isDisplayed());
		enterCardExpiry.sendKeys(sp.ExcelRead(sheetName).get(11));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickSaveChangesButton() throws IOException {
		CreateCustomerPage sp = new CreateCustomerPage(driver);
		log.info("Click on Save Changes Button");
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		clickSaveChangesButton.click();

	}

	// @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Bill
	// Cust1']")
	private WebElement clickCustomer1;

	/**
	 * Method to Click on Customer 1.
	 * 
	 * @throws IOException
	 */
	public void clickCustomer1() throws IOException {
		CreateCustomerPage sp = new CreateCustomerPage(driver);
		log.info("Click on Customer 1");
		String CustomerName = sp.ExcelRead(sheetName).get(5);
		clickCustomer1 = driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']"));
		JavaScriptExec.sleep();
		Assert.assertTrue(clickCustomer1.isDisplayed());
		clickCustomer1.click();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit edit']//*[text()='Edit']")
	private WebElement clickEditButton;

	/**
	 * Method to Click on Edit Button.
	 * 
	 * @throws IOException
	 */
	public void clickEditButton() throws IOException {
		JavaScriptExec.scrollToElementOnPage(driver, clickEditButton);
		CreateCustomerPage sp = new CreateCustomerPage(driver);
		log.info("Click Edit Button");
		Assert.assertTrue(clickEditButton.isDisplayed());
		clickEditButton.click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='user.nextInvoiceDate']")
	private WebElement enterNextInvoiceDate;

	/**
	 * Method to Enter Next Invoice Date.
	 * 
	 * @throws IOException
	 */
	public void enterNextInvoiceDate() throws IOException {
		CreateCustomerPage sp = new CreateCustomerPage(driver);
		log.info("Enter Login Name");
		Assert.assertTrue(enterNextInvoiceDate.isDisplayed());
		enterNextInvoiceDate.clear();
		enterNextInvoiceDate.sendKeys(sp.ExcelRead(sheetName).get(12));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='user.userName']")
	private WebElement enterLoginName1;

	/**
	 * Method to Enter Login Name.
	 * 
	 * @throws IOException
	 */
	public void enterLoginName1() throws IOException {
		CreateCustomerPage sp = new CreateCustomerPage(driver);
		log.info("Enter Login Name");
		Assert.assertTrue(enterLoginName.isDisplayed());
		enterLoginName.sendKeys(sp.ExcelRead(sheetName).get(13));

	}

	@FindBy(how = How.XPATH, using = "//label[contains(.,'cc.cardholder.name')]/following::input[1]")
	private WebElement enterCardHolderName1;

	/**
	 * Method to Enter card holder name.
	 * 
	 * @throws IOException
	 */
	public void enterCardHolderName1() throws IOException {
		CreateCustomerPage sp = new CreateCustomerPage(driver);
		log.info("Enter card holder name");
		Assert.assertTrue(enterCardHolderName1.isDisplayed());
		enterCardHolderName1.sendKeys(sp.ExcelRead(sheetName).get(14));

	}

	// @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Bill
	// Cust1']")
	private WebElement clickCustomer2;

	/**
	 * Method to Click on Customer 2.
	 * 
	 * @throws IOException
	 */
	public void clickCustomer2() throws IOException {
		CreateCustomerPage sp = new CreateCustomerPage(driver);
		log.info("Click on Customer 2");
		String CustomerName = sp.ExcelRead(sheetName).get(13);
		clickCustomer2 = driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']"));
		JavaScriptExec.sleep();
		Assert.assertTrue(clickCustomer2.isDisplayed());
		clickCustomer2.click();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='user.dueDateValue']")
	private WebElement enterDueDateDays;

	/**
	 * Method to Enter Due Date Days.
	 * 
	 * @throws IOException
	 */
	public void enterDueDateDays() throws IOException {
		CreateCustomerPage sp = new CreateCustomerPage(driver);
		log.info("Enter Due Date Days");
		JavaScriptExec.sleep();
		Assert.assertTrue(enterDueDateDays.isDisplayed());
		enterDueDateDays.sendKeys(sp.ExcelRead(sheetName).get(15));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='user.nextInvoiceDate']")
	private WebElement enterNextInvoiceDate1;

	/**
	 * Method to Enter Next Invoice Date1.
	 * 
	 * @throws IOException
	 */
	public void enterNextInvoiceDate1() throws IOException {
		CreateCustomerPage sp = new CreateCustomerPage(driver);
		log.info("Enter Login Name");
		Assert.assertTrue(enterNextInvoiceDate1.isDisplayed());
		enterNextInvoiceDate1.clear();
		enterNextInvoiceDate1.sendKeys(sp.ExcelRead(sheetName).get(16));

	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}

}
