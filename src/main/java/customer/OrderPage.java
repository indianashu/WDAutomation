package customer;

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
import utilPackages.WaitClass;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Ashutosh
 *
 */

public class OrderPage extends BasePage {
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public OrderPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(OrderPage.class);
	OrderPage orderPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "CustOrder";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		OrderPage sp = new OrderPage(driver);

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
		OrderPage sp = new OrderPage(driver);
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
		OrderPage sp = new OrderPage(driver);
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
		OrderPage sp = new OrderPage(driver);
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
		OrderPage sp = new OrderPage(driver);
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
		OrderPage sp = new OrderPage(driver);
		log.info("Click on Add New Button");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickAddNewButton.isDisplayed());
		clickAddNewButton.click();

	}

	/**
	 * Method to select user company.
	 * 
	 * @throws IOException
	 */
	public void selectUserCompany() throws IOException {
		OrderPage sp = new OrderPage(driver);
		WebElement Usercompanyelement = driver.findElement(By.xpath("//select[@name='user.entityId']"));
		Select se = new Select(Usercompanyelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(3));
	}

	/**
	 * Method to select account type.
	 * 
	 * @throws IOException
	 */
	public void selectAccountType() throws IOException {
		OrderPage sp = new OrderPage(driver);
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
		OrderPage sp = new OrderPage(driver);
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
		OrderPage sp = new OrderPage(driver);
		log.info("Enter Login Name");
		Assert.assertTrue(enterLoginName.isDisplayed());
		enterLoginName.sendKeys(sp.ExcelRead(sheetName).get(5));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Use Company Billing Cycle']")
	private WebElement clickUseCompanyBillingCycleButton;

	/**
	 * Method to Click Use Company Billing Cycle Button.
	 * 
	 * @throws IOException
	 */
	public void clickUseCompanyBillingCycleButton() throws IOException {
		OrderPage sp = new OrderPage(driver);
		log.info("Click Use Company Billing Cycle Button");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, clickUseCompanyBillingCycleButton);
		Assert.assertTrue(clickUseCompanyBillingCycleButton.isDisplayed());
		clickUseCompanyBillingCycleButton.click();

	}

	/**
	 * Method to select billing cycle unit.
	 * 
	 * @throws IOException
	 */
	public void selectBillingCycleUnit() throws IOException {
		OrderPage sp = new OrderPage(driver);
		WebElement BCUelement = driver.findElement(By.xpath("//select[@name='mainSubscription.periodId']"));
		Select se = new Select(BCUelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(6));

	}

	/**
	 * Method to select billing cycle day.
	 * 
	 * @throws IOException
	 */
	public void selectBillingCycleDay() throws IOException {
		OrderPage sp = new OrderPage(driver);
		WebElement BCDelement = driver
				.findElement(By.xpath("//select[@name='mainSubscription.nextInvoiceDayOfPeriod']"));
		Select se = new Select(BCDelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(7));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickSaveChangesButton() throws IOException {
		OrderPage sp = new OrderPage(driver);
		log.info("Click on Save Changes Button");
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		clickSaveChangesButton.click();

	}

	@FindBy(how = How.XPATH, using = "//div[@class='msg-box successfully']//*[text()='Done']")
	private WebElement verifyConfirmationMsg;

	/**
	 * Method to verify Account Type is created Successfully.
	 * 
	 * @throws IOException
	 */
	public void verifyConfirmationMsg() throws IOException {
		OrderPage sp = new OrderPage(driver);
		log.info("Verifying if Account Type is created Successfully or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyConfirmationMsg.isDisplayed(),
				"Assert Failed as its unable to search text in Logged in Page");
	}

	/**
	 * Method to select customer.
	 * 
	 * @throws IOException
	 */
	public void selectCustomer() throws IOException {
		OrderPage sp = new OrderPage(driver);
		log.info("Select Customer");
		JavaScriptExec.sleep();
		String CustomerName = sp.ExcelRead(sheetName).get(5);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']")).click();

	}

	@FindBy(how = How.XPATH, using = "//*[@id='payment-methods']/div[1]/a/span")
	private WebElement expandPaymentMethod;

	/**
	 * Method to Expand Payment Method in add customer page.
	 * 
	 * @throws IOException
	 */
	public void expandPaymentMethod() throws IOException {
		OrderPage sp = new OrderPage(driver);
		log.info("Expand Payment Method in add customer page");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, expandPaymentMethod);
		Assert.assertTrue(expandPaymentMethod.isDisplayed());
		expandPaymentMethod.click();

	}

	private WebElement selectPaymentMethodType;

	/**
	 * Method to select payment method type.
	 * 
	 * @throws IOException
	 */
	public void selectPaymentMethodType() throws IOException {
		OrderPage sp = new OrderPage(driver);
		WebElement PMTelement = driver.findElement(By.xpath("//select[@name='paymentMethod_0.paymentMethodTypeId']"));
		Select se = new Select(PMTelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(6));
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//label[contains(.,'cc.cardholder.name')]/following::input[1]")
	private WebElement enterCCCardholderName;

	/**
	 * Method to Enter CC Cardholder name.
	 * 
	 * @throws IOException
	 */
	public void enterCCCardholderName() throws IOException {
		OrderPage sp = new OrderPage(driver);
		log.info("Enter CC Cardholder name");
		Assert.assertTrue(enterCCCardholderName.isDisplayed());
		enterCCCardholderName.sendKeys(sp.ExcelRead(sheetName).get(7));

	}

	@FindBy(how = How.XPATH, using = "//label[contains(.,'cc.number')]/following::input[1]")
	private WebElement enterCCNumber;

	/**
	 * Method to Enter CC Number.
	 * 
	 * @throws IOException
	 */
	public void enterCCNumber() throws IOException {
		OrderPage sp = new OrderPage(driver);
		log.info("Enter CC Number");
		Assert.assertTrue(enterCCNumber.isDisplayed());
		enterCCNumber.sendKeys(sp.ExcelRead(sheetName).get(8));

	}

	@FindBy(how = How.XPATH, using = "//label[contains(.,'cc.expiry.date')]/following::input[1]")
	private WebElement enterCCExpiryDate;

	/**
	 * Method to Enter CC Number.
	 * 
	 * @throws IOException
	 */
	public void enterCCExpiryDate() throws IOException {
		OrderPage sp = new OrderPage(driver);
		log.info("Enter CC Number");
		Assert.assertTrue(enterCCExpiryDate.isDisplayed());
		enterCCExpiryDate.sendKeys(sp.ExcelRead(sheetName).get(9));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add Instrument']")
	private WebElement clickAddInstrumentButton;

	/**
	 * Method to click add instrument button.
	 * 
	 * @throws IOException
	 */
	public void clickAddInstrumentButton() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		log.info("Click Add Instrument Button");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, clickAddInstrumentButton);
		Assert.assertTrue(clickAddInstrumentButton.isDisplayed());
		clickAddInstrumentButton.click();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit order']//*[text()='Create Order']")
	private WebElement clickCreateOrderButton;

	/**
	 * Method to Click Create Order Button.
	 * 
	 * @throws IOException
	 */
	public void clickCreateOrderButton() throws IOException {
		JavaScriptExec.scrollToElementOnPage(driver, clickCreateOrderButton);
		OrderPage sp = new OrderPage(driver);
		log.info("Click Add Sub Account Button");
		Assert.assertTrue(clickCreateOrderButton.isDisplayed());
		clickCreateOrderButton.click();
		JavaScriptExec.sleep();

	}

	/**
	 * Method to select Period.
	 * 
	 * @throws IOException
	 */
	public void selectPeriod() throws IOException {
		OrderPage sp = new OrderPage(driver);
		WebElement Periodelement = driver.findElement(By.xpath("//select[@name='period']"));
		Select se = new Select(Periodelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(10));

	}
	
	/**
	 * Method to select Order Type.
	 * 
	 * @throws IOException
	 */
	public void selectOrderType() throws IOException {
		OrderPage sp = new OrderPage(driver);
		WebElement OrderTypeelement = driver.findElement(By.xpath("//select[@name='billingTypeId']"));
		Select se = new Select(OrderTypeelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(11));

	}

	/**
	 * Method to select Active since.
	 * 
	 * @throws IOException
	 */
	public void selectActiveSince() throws IOException {
		OrderPage sp = new OrderPage(driver);
		WebElement ASelement = driver.findElement(By.xpath("//input[@name='activeSince']"));
		ASelement.clear();
		ASelement.sendKeys(sp.ExcelRead(sheetName).get(12));
	}

	@FindBy(how = How.XPATH, using = "//*[@id='ui-id-8']")
	private WebElement clickProductsSubTab;

	/**
	 * Method to Click Products tab.
	 * 
	 * @throws IOException
	 */
	public void clickProductsSubTab() throws IOException {
		OrderPage sp = new OrderPage(driver);
		log.info("Click Products Tab");
		Assert.assertTrue(clickProductsSubTab.isDisplayed());
		clickProductsSubTab.click();
		JavaScriptExec.sleep();

	}

	/**
	 * Method to Select Product from list.
	 * 
	 * @throws IOException
	 */
	public void selectProduct() throws IOException {
		OrderPage sp = new OrderPage(driver);
		log.info("Click Product from list");
		String ProductName = sp.ExcelRead(sheetName).get(13);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']")).click();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='change--3.startDate']")
	private WebElement enterEffectiveDate;

	/**
	 * Method to Enter Effective Date.
	 * 
	 * @throws IOException
	 */
	public void enterEffectiveDate() throws IOException {
		OrderPage sp = new OrderPage(driver);
		log.info("Enter Effective Date");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, enterEffectiveDate);
		Assert.assertTrue(enterEffectiveDate.isDisplayed());
		enterEffectiveDate.sendKeys(sp.ExcelRead(sheetName).get(14));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='change--3.quantityAsDecimal']")
	private WebElement enterQuantity;

	/**
	 * Method to Enter Quantity.
	 * 
	 * @throws IOException
	 */
	public void enterQuantity() throws IOException {
		OrderPage sp = new OrderPage(driver);
		log.info("Enter Quantity");
		JavaScriptExec.sleep();
		Assert.assertTrue(enterQuantity.isDisplayed());
		enterQuantity.clear();
		enterQuantity.sendKeys(sp.ExcelRead(sheetName).get(15));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Update']")
	private WebElement clickUpdateButton;

	/**
	 * Method to Click Update Button.
	 * 
	 * @throws IOException
	 */
	public void clickUpdateButton() throws IOException {
		OrderPage sp = new OrderPage(driver);
		log.info("Click Update Button");
		Assert.assertTrue(clickUpdateButton.isDisplayed());
		clickUpdateButton.click();

	}

	@FindBy(how = How.XPATH, using = "//span[@class='newOrderLine']")
	private WebElement verifyNewOrder;

	/**
	 * Method to verify NEW is shown.
	 * 
	 * @throws IOException
	 */
	public void verifyNewOrder() throws IOException {
		OrderPage sp = new OrderPage(driver);
		log.info("Verifying if NEW is shown or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyNewOrder.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit edit']//*[text()='Edit this Order']")
	private WebElement clickEditOrderButton;

	/**
	 * Method to Click Edit This Order Button.
	 * 
	 * @throws IOException
	 */
	public void clickEditOrderButton() throws IOException {
		JavaScriptExec.scrollToElementOnPage(driver, clickEditOrderButton);
		OrderPage sp = new OrderPage(driver);
		log.info("Click Edit This Order Button");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickEditOrderButton.isDisplayed());
		clickEditOrderButton.click();

	}

	@FindBy(how = How.XPATH, using = "//*[@id='ui-id-11']")
	private WebElement clickChangeLog;

	/**
	 * Method to Click ChangeLog.
	 * 
	 * @throws IOException
	 */
	public void clickChangeLog() throws IOException {
		OrderPage sp = new OrderPage(driver);
		log.info("Click Change Log");
		Assert.assertTrue(clickChangeLog.isDisplayed());
		clickChangeLog.click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit order']//*[text()='Generate Invoice']")
	private WebElement clickGenerateInvoiceButton;

	/**
	 * Method to Click on Generate Invoice Button.
	 * 
	 * @throws IOException
	 */
	public void clickGenerateInvoiceButton() throws IOException {
		OrderPage sp = new OrderPage(driver);
		log.info("Click on Generate Invoice Button");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, clickGenerateInvoiceButton);
		Assert.assertTrue(clickGenerateInvoiceButton.isDisplayed());
		clickGenerateInvoiceButton.click();

	}

	@FindBy(how = How.XPATH, using = "//span[@class='description']")
	private WebElement clickSelectedProduct;

	/**
	 * Method to Click Selected Product.
	 * 
	 * @throws IOException
	 */
	public void clickSelectedProduct() throws IOException {
		OrderPage sp = new OrderPage(driver);
		log.info("Click Selected Product");
		Assert.assertTrue(clickSelectedProduct.isDisplayed());
		clickSelectedProduct.click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Change']")
	private WebElement clickChangeButton;

	/**
	 * Method to Click ChangeButton.
	 * 
	 * @throws IOException
	 */
	public void clickChangeButton() throws IOException {
		OrderPage sp = new OrderPage(driver);
		log.info("Click Change Button");
		Assert.assertTrue(clickChangeButton.isDisplayed());
		clickChangeButton.click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//input[@class='field quantity']")
	private WebElement enterChangeQty;

	/**
	 * Method to Enter New Quantity.
	 * 
	 * @throws IOException
	 */
	public void enterChangeQty() throws IOException {
		OrderPage sp = new OrderPage(driver);
		log.info("Enter New Quantity");
		Assert.assertTrue(enterChangeQty.isDisplayed());
		enterChangeQty.clear();
		enterChangeQty.sendKeys(sp.ExcelRead(sheetName).get(16));

		/**
		 * Click Update Button.
		 */
		log.info("Click Update Button");
		WebElement clickUpdateButton = driver
				.findElement(By.xpath("//a[@class='submit save']//following::span[text()='Update']"));
		Assert.assertTrue(clickUpdateButton.isDisplayed());
		clickUpdateButton.click();
		JavaScriptExec.sleep();

	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//select[@name='user.currencyId']")
	private WebElement selectCurrency;

	/**
	 * Method to Enter New Quantity.
	 * 
	 * @throws IOException
	 */
	public void selectCurrency() throws IOException {
		OrderPage sp = new OrderPage(driver);
		log.info("Select Currency United State Dollar");
		Select sel = new Select(selectCurrency);
		sel.selectByVisibleText(sp.ExcelRead(sheetName).get(17));
		JavaScriptExec.sleep();

	}

}