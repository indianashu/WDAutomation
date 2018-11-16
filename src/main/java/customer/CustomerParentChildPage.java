package customer;

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
import org.openqa.selenium.JavascriptExecutor;
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

public class CustomerParentChildPage extends BasePage {
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public CustomerParentChildPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(CustomerParentChildPage.class);
	CustomerParentChildPage customerParentChildPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "AddCustomerChild";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);

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
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
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
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
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
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
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
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
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
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
		log.info("Click on Add New Button");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickAddNewButton.isDisplayed());
		clickAddNewButton.click();

	}

	private WebElement selectUserCompany;

	/**
	 * Method to select user company.
	 * 
	 * @throws IOException
	 */
	public void selectUserCompany() throws IOException {
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
		WebElement Usercompanyelement = driver.findElement(By.xpath("//select[@name='user.entityId']"));
		Select se = new Select(Usercompanyelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(3));

	}

	private WebElement selectAccountType;

	/**
	 * Method to select account type.
	 * 
	 * @throws IOException
	 */
	public void selectAccountType() throws IOException {
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
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
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
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
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
		log.info("Enter Login Name");
		Assert.assertTrue(enterLoginName.isDisplayed());
		enterLoginName.sendKeys(sp.ExcelRead(sheetName).get(5));

	}
	
	public void selectCurrency() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		WebElement Currencyelement = driver.findElement(By.xpath("//select[@name='user.currencyId']"));
		Select se = new Select(Currencyelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(18));
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


	@FindBy(how = How.XPATH, using = "//input[@name='user.isParent']")
	private WebElement clickAllowSubAccountCheckbox;

	/**
	 * Method to Click on Allow Sub-Account Checkbox.
	 * 
	 * @throws IOException
	 */
	public void clickAllowSubAccountCheckbox() throws IOException {
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
		log.info("Click Allow SubAccount Checkbox");
		Assert.assertTrue(clickAllowSubAccountCheckbox.isDisplayed());
		clickAllowSubAccountCheckbox.click();

	}

	@FindBy(how = How.XPATH, using = "//*[@id='payment-methods']/div[1]/a/span")
	private WebElement expandPaymentMethod;

	/**
	 * Method to Expand Payment Method in add customer page.
	 * 
	 * @throws IOException
	 */
	public void expandPaymentMethod() throws IOException {
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
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
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
		WebElement PMTelement = driver.findElement(By.xpath("//select[@name='paymentMethod_0.paymentMethodTypeId']"));
		Select se = new Select(PMTelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(7));
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//label[contains(.,'cc.cardholder.name')]/following::input[1]")
	private WebElement enterCCCardholderParentName;

	/**
	 * Method to Enter CC Cardholder name.
	 * 
	 * @throws IOException
	 */
	public void enterCCCardholderParentName() throws IOException {
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
		log.info("Enter CC Cardholder Parent name");
		Assert.assertTrue(enterCCCardholderParentName.isDisplayed());
		enterCCCardholderParentName.sendKeys(sp.ExcelRead(sheetName).get(8));

	}

	@FindBy(how = How.XPATH, using = "//label[contains(.,'cc.cardholder.name')]/following::input[1]")
	private WebElement enterCCCardholderChildName;

	/**
	 * Method to Enter CC Cardholder name.
	 * 
	 * @throws IOException
	 */
	public void enterCCCardholderChildName() throws IOException {
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
		log.info("Enter CC Cardholder Child name");
		Assert.assertTrue(enterCCCardholderChildName.isDisplayed());
		enterCCCardholderChildName.sendKeys(sp.ExcelRead(sheetName).get(11));

	}

	@FindBy(how = How.XPATH, using = "//label[contains(.,'cc.number')]/following::input[1]")
	private WebElement enterCCNumber;

	/**
	 * Method to Enter CC Number.
	 * 
	 * @throws IOException
	 */
	public void enterCCNumber() throws IOException {
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
		log.info("Enter CC Number");
		Assert.assertTrue(enterCCNumber.isDisplayed());
		enterCCNumber.sendKeys(sp.ExcelRead(sheetName).get(9));

	}

	@FindBy(how = How.XPATH, using = "//label[contains(.,'cc.expiry.date')]/following::input[1]")
	private WebElement enterCCExpiryDate;

	/**
	 * Method to Enter CC Number.
	 * 
	 * @throws IOException
	 */
	public void enterCCExpiryDate() throws IOException {
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
		log.info("Enter CC Number");
		Assert.assertTrue(enterCCExpiryDate.isDisplayed());
		enterCCExpiryDate.sendKeys(sp.ExcelRead(sheetName).get(10));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add Instrument']")
	private WebElement clickAddInstrumentButton;

	/**
	 * Method to click add instrument button.
	 * 
	 * @throws IOException
	 */
	public void clickAddInstrumentButton() throws IOException {
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
		log.info("Click Add Instrument Button");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, clickAddInstrumentButton);
		Assert.assertTrue(clickAddInstrumentButton.isDisplayed());
		clickAddInstrumentButton.click();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickSaveChangesButton() throws IOException {
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
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
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
		log.info("Verifying if Account Type is created Successfully or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyConfirmationMsg.isDisplayed(),
				"Assert Failed as its unable to search text in Logged in Page");
	}

	// @FindBy(how=How.XPATH, using="//a[@class='cell double']")
	private WebElement selectCustomer;

	/**
	 * Method to select customer.
	 * 
	 * @throws IOException
	 */
	public void selectCustomer() throws IOException {
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
		log.info("Select Customer");
		String CustomerName = sp.ExcelRead(sheetName).get(5);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']")).click();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add Sub-Account']")
	private WebElement clickAddSubAccountButton;

	/**
	 * Method to Click Add Sub Account Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddSubAccountButton() throws IOException {
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
		log.info("Click Add Sub Account Button");
		navigateBottom();
		Assert.assertTrue(clickAddSubAccountButton.isDisplayed());
		clickAddSubAccountButton.click();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='user.userName']")
	private WebElement enterLoginName1;

	/**
	 * Method to Enter Login Name.
	 * 
	 * @throws IOException
	 */
	public void enterLoginName1() throws IOException {
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
		log.info("Enter Login Name");
		Assert.assertTrue(enterLoginName1.isDisplayed());
		enterLoginName1.sendKeys(sp.ExcelRead(sheetName).get(11));

	}

	// @FindBy(how=How.XPATH, using="//a[@class='cell double']")
	private WebElement selectChildCustomer;

	/**
	 * Method to select child customer.
	 * 
	 * @throws IOException
	 */
	public void selectChildCustomer() throws IOException {
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
		log.info("Select Child Customer");
		String CustomerName = sp.ExcelRead(sheetName).get(11);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']")).click();

	}

	@FindBy(how = How.XPATH, using = "//*[@id='ait-20']/div[1]/a/span")
	private WebElement expandContactInfo;

	/**
	 * Method to Expand Contact Info in add customer page.
	 * 
	 * @throws IOException
	 */
	public void expandContactInfo() throws IOException {
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
		log.info("Expand Contact Info in add customer page");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, expandContactInfo);
		Assert.assertTrue(expandContactInfo.isDisplayed());
		expandContactInfo.click();

	}

	@FindBy(how = How.XPATH, using = "//input[@class='field text']")
	private WebElement enterEmailID1;

	/**
	 * Method to Enter Email.
	 * 
	 * @throws IOException
	 */
	public void enterEmailID1() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		log.info("Enter Email");
		Assert.assertTrue(enterEmailID1.isDisplayed());
		enterEmailID1.sendKeys(sp.ExcelRead(sheetName).get(12));

	}


	// @FindBy(how=How.XPATH, using="//div[@class='row']//*[text()='22 Brian
	// Smith']")
	private WebElement verifyParentID;

	/**
	 * Method to Verify Parent ID.
	 * 
	 * @throws IOException
	 */
	public void verifyParentID() throws IOException {
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
		log.info("Verify Parent ID");
		JavaScriptExec.sleep();
		String ParentID = driver.findElement(By.xpath("//*[@name='user.parentId']")).getAttribute("value");
		String Parent = sp.ExcelRead(sheetName).get(13);
		String ActualParentID = driver.findElement(By.xpath("//label[contains(.,'Parent ID')]/following::a[1]"))
				.getText();
		Assert.assertEquals(ActualParentID, ParentID + " " + Parent);

	}

	// @FindBy(how=How.XPATH, using="//*[@id='22']/img")
	private WebElement verifyParentChildImage;

	/**
	 * Method to verify parent child image is present or not.
	 * 
	 * @throws IOException
	 */
	public void verifyParentChildImage() throws IOException {
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
		log.info("verify parent child image is present or not");
		JavaScriptExec.sleep();
		String ParentID = sp.ExcelRead(sheetName).get(14);
		WebElement image1 = driver.findElement(By.xpath("//*[@id='" + ParentID + "']/img"));
		Boolean imageLoaded1 = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				image1);
		if (!imageLoaded1) {
			System.out.println("1. Image is not present");
			Assert.assertFalse(false);
		} else {
			System.out.println("1. Got it");
			Assert.assertFalse(true);
		}

	}

	private WebElement verifyChildImage;

	/**
	 * Method to verify child image is present or not.
	 * 
	 * @throws IOException
	 */
	public void verifyChildImage() throws IOException {
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
		log.info("verify child image is present or not");
		JavaScriptExec.sleep();
		String ChildID = sp.ExcelRead(sheetName).get(15);
		WebElement image1 = driver.findElement(By.xpath("//*[@id='" + ChildID + "']/td[6]/img"));
		Boolean imageLoaded1 = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				image1);
		if (!imageLoaded1) {
			System.out.println("1. Image is not present");
			Assert.assertFalse(false);
		} else {
			System.out.println("1. Got it");
			Assert.assertFalse(true);
		}

	}

	private WebElement verifyParentCustomer;

	/**
	 * Method to verify Parent customer.
	 * 
	 * @throws IOException
	 */
	public void verifyParentCustomer() throws IOException {
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
		log.info("Verify Parent customer");
		JavaScriptExec.sleep();
		String ParentID = sp.ExcelRead(sheetName).get(14);
		String ParentName = sp.ExcelRead(sheetName).get(16);
		String ActualParentName = driver.findElement(By.xpath("//*[@id='" + ParentID + "']")).getText();
		Assert.assertEquals(ActualParentName, ParentName);

	}

	private WebElement verifyChildInvoicingText;

	/**
	 * Method to verify Child Invoicing Text.
	 * 
	 * @throws IOException
	 */
	public void verifyChildInvoicingText() throws IOException {
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
		log.info("Verify child customer");
		JavaScriptExec.sleep();
		String ChildInvoicing = sp.ExcelRead(sheetName).get(17);
		String ActualChildInvoicing = driver
				.findElement(By.xpath("//*[@id='column2']/div[4]/div/table/tbody/tr[10]/td[1]")).getText();
		Assert.assertEquals(ActualChildInvoicing, ChildInvoicing);

	}

	private WebElement verifyChildCustomer;

	/**
	 * Method to verify Child customer.
	 * 
	 * @throws IOException
	 */
	public void verifyChildCustomer() throws IOException {
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
		log.info("Verify child customer");
		JavaScriptExec.sleep();
		String ChildName = sp.ExcelRead(sheetName).get(11);
		String ActualChildName = driver.findElement(By.xpath("//*[@id='column2']/div[4]/div/table/tbody/tr[9]/td[1]"))
				.getText();
		Assert.assertEquals(ActualChildName, ChildName);

	}

	private WebElement verifySubAccount;

	/**
	 * Method to verify Sub Account.
	 * 
	 * @throws IOException
	 */
	public void verifySubAccount() throws IOException {
		CustomerParentChildPage sp = new CustomerParentChildPage(driver);
		log.info("Verify child customer");
		JavaScriptExec.sleep();
		String ChildName = sp.ExcelRead(sheetName).get(11);
		String ActualChildName = driver.findElement(By.xpath("//*[@id='column2']/div[4]/div/table/tbody/tr[9]"))
				.getText();
		Assert.assertEquals(ActualChildName, ChildName);
		// System.out.println("The value is ------>" + ActualChildName);

	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}

}
