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

public class CustomerPage extends BasePage {
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public CustomerPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(CustomerPage.class);
	CustomerPage customerPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "AddCustomer";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		CustomerPage sp = new CustomerPage(driver);

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
		CustomerPage sp = new CustomerPage(driver);
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
		CustomerPage sp = new CustomerPage(driver);
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
		CustomerPage sp = new CustomerPage(driver);
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
		CustomerPage sp = new CustomerPage(driver);
		log.info("Click on Customer Tab after successful login");
		Assert.assertTrue(clickCustomerTab.isDisplayed());
		clickCustomerTab.click();
		WebElement company = driver.findElement(By.xpath("//span[@class='right-text']//a"));
		if (company.isDisplayed()) {
			company.click();
		}

		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add New']")
	private WebElement clickAddNewButton;

	/**
	 * Method to click on Add New Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddNewButton() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
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
		CustomerPage sp = new CustomerPage(driver);
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
		CustomerPage sp = new CustomerPage(driver);
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
		CustomerPage sp = new CustomerPage(driver);
		log.info("Click on select Button");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickSelectButton.isDisplayed());
		clickSelectButton.click();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='user.userName']")
	private WebElement enterLoginName;

	/**
	 * Method to Enter Login Name.
	 * 
	 * @throws IOException
	 */
	public void enterLoginName() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		log.info("Enter Login Name");
		Assert.assertTrue(enterLoginName.isDisplayed());
		enterLoginName.sendKeys(sp.ExcelRead(sheetName).get(5));

	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='user.currencyId']")
	private WebElement selectCurrency;

	/**
	 * Method to Enter New Quantity.
	 * 
	 * @throws IOException
	 */
	public void selectCurrency() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		log.info("Select Currency United State");
		Select sel = new Select(selectCurrency);
		sel.selectByVisibleText(sp.ExcelRead(sheetName).get(14));
		
	}
	
	@FindBy(how = How.XPATH, using = "//input[@class='field text']")
	private WebElement enterEmail;

	/**
	 * Method to Enter Email.
	 * 
	 * @throws IOException
	 */
	public void enterEmail() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		log.info("Enter Email");
		Assert.assertTrue(enterEmail.isDisplayed());
		enterEmail.sendKeys(sp.ExcelRead(sheetName).get(6));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Use Company Billing Cycle']")
	private WebElement clickUseCompanyBillingCycleButton;

	/**
	 * Method to Click Use Company Billing Cycle Button.
	 * 
	 * @throws IOException
	 */
	public void clickUseCompanyBillingCycleButton() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		log.info("Click Use Company Billing Cycle Button");
		Assert.assertTrue(clickUseCompanyBillingCycleButton.isDisplayed());
		clickUseCompanyBillingCycleButton.click();

	}

	/**
	 * Method to select billing cycle unit.
	 * 
	 * @throws IOException
	 */
	public void selectBillingCycleUnit() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		WebElement BCUelement = driver.findElement(By.xpath("//select[@name='mainSubscription.periodId']"));
		Select se = new Select(BCUelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(7));

	}

	/**
	 * Method to select billing cycle day.
	 * 
	 * @throws IOException
	 */
	public void selectBillingCycleDay() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		WebElement BCDelement = driver
				.findElement(By.xpath("//select[@name='mainSubscription.nextInvoiceDayOfPeriod']"));
		Select se = new Select(BCDelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(8));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickSaveChangesButton() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
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
		CustomerPage sp = new CustomerPage(driver);
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
		CustomerPage sp = new CustomerPage(driver);
		log.info("Select Customer");
		JavaScriptExec.sleep();
		String CustomerName = sp.ExcelRead(sheetName).get(5);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']")).click();

	}

	/**
	 * Method to Get customer ID.
	 * 
	 * @throws IOException
	 */
	public void getCustomerID() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		log.info("Get Customer ID");
		JavaScriptExec.sleep();
		String CustomerID = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText();
		System.out.print("Customer ID is ------>" + CustomerID + "<------- Got it.");

	}

	// @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add
	// Sub-Account']")
	// private WebElement clickAddSubAccountButton;
	// /**
	// * Method to Click Add Sub Account Button.
	// * @throws IOException
	// */
	// public void clickAddSubAccountButton() throws IOException{
	// CustomerPage sp=new CustomerPage(driver);
	// log.info("Click Add Sub Account Button");
	// JavaScriptExec.sleep();
	// WaitClass.WaitForElementisDisplay(driver, 10, clickAddSubAccountButton);
	// Assert.assertTrue(clickAddSubAccountButton.isDisplayed());
	// clickAddSubAccountButton.click();
	//
	// }

	// @FindBy(how=How.XPATH, using="//input[@name='user.userName']")
	// private WebElement enterLoginName1;
	// /**
	// * Method to Enter Login Name.
	// * @throws IOException
	// */
	// public void enterLoginName1() throws IOException{
	// CustomerPage sp=new CustomerPage(driver);
	// log.info("Enter Login Name");
	// JavaScriptExec.sleep();
	// WaitClass.WaitForElementisDisplay(driver, 10, enterLoginName1);
	// Assert.assertTrue(enterLoginName1.isDisplayed());
	// enterLoginName1.sendKeys(sp.ExcelRead(sheetName).get(8));
	//
	// }
	//

	@FindBy(how = How.XPATH, using = "//*[@id='ait-20']/div[1]/a/span")
	private WebElement expandContactInfo;

	/**
	 * Method to Expand Contact Info in add customer page.
	 * 
	 * @throws IOException
	 */
	public void expandContactInfo() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		log.info("Expand Contact Info in add customer page");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, expandContactInfo);
		Assert.assertTrue(expandContactInfo.isDisplayed());
		expandContactInfo.click();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='metaField_224.value']")
	private WebElement enterEmailID;

	/**
	 * Method to Enter Email ID.
	 * 
	 * @throws IOException
	 */
	public void enterEmailID() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		log.info("Enter EmailID");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, enterEmailID);
		Assert.assertTrue(enterEmailID.isDisplayed());
		enterEmailID.sendKeys(sp.ExcelRead(sheetName).get(9));

	}

	@FindBy(how = How.XPATH, using = "//*[@id='payment-methods']/div[1]/a/span")
	private WebElement expandPaymentMethod;

	/**
	 * Method to Expand Payment Method in add customer page.
	 * 
	 * @throws IOException
	 */
	public void expandPaymentMethod() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		log.info("Expand Payment Method in add customer page");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, expandPaymentMethod);
		Assert.assertTrue(expandPaymentMethod.isDisplayed());
		expandPaymentMethod.click();

	}

	/**
	 * Method to select payment method type.
	 * 
	 * @throws IOException
	 */
	public void selectPaymentMethodType() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		WebElement PMTelement = driver.findElement(By.xpath("//select[@name='paymentMethod_0.paymentMethodTypeId']"));
		Select se = new Select(PMTelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(10));
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
		CustomerPage sp = new CustomerPage(driver);
		log.info("Enter CC Cardholder name");
		Assert.assertTrue(enterCCCardholderName.isDisplayed());
		enterCCCardholderName.sendKeys(sp.ExcelRead(sheetName).get(11));
	}

	@FindBy(how = How.XPATH, using = "//label[contains(.,'cc.number')]/following::input[1]")
	private WebElement enterCCNumber;

	/**
	 * Method to Enter CC Number.
	 * 
	 * @throws IOException
	 */
	public void enterCCNumber() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		log.info("Enter CC Number");
		Assert.assertTrue(enterCCNumber.isDisplayed());
		enterCCNumber.sendKeys(sp.ExcelRead(sheetName).get(12));

	}

	@FindBy(how = How.XPATH, using = "//label[contains(.,'cc.expiry.date')]/following::input[1]")
	private WebElement enterCCExpiryDate;

	/**
	 * Method to Enter CC Number.
	 * 
	 * @throws IOException
	 */
	public void enterCCExpiryDate() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		log.info("Enter CC Number");
		Assert.assertTrue(enterCCExpiryDate.isDisplayed());
		enterCCExpiryDate.sendKeys(sp.ExcelRead(sheetName).get(13));

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

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}

}
