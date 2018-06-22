package invoice;

import baseClassPackage.BasePage;
import customer.MakePaymentPage;
import reports.ReportsPage;

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
import org.openqa.selenium.interactions.Actions;
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

public class GeneratingPayingInvoicePage extends BasePage {
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public GeneratingPayingInvoicePage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(GeneratingPayingInvoicePage.class);
	GeneratingPayingInvoicePage generatingPayingInvoicePage;
	PropertyValExtractors p = new PropertyValExtractors();
	Actions actions = new Actions(driver);
	String sheetName = "GeneratePayInvoice";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);

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
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
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
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
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
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
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
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Click on Customer Tab after successful login");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickCustomerTab.isDisplayed());
		clickCustomerTab.click();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickSaveChangesButton() throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
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
	public String verifyConfirmationMsg() throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Verifying if Account Type is created Successfully or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyConfirmationMsg.isDisplayed(),
				"Assert Failed as its unable to search text in Logged in Page");
		String OrderId = driver.findElement(By.xpath("//*[@id='column2']/div[1]/div[1]/strong/em")).getText();
		return OrderId;
	}

	// @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Customer
	// A']")
	private WebElement clickCustomerName;

	/**
	 * Method to click on customer name.
	 * 
	 * @throws IOException
	 */
	public void clickCustomerName() throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Click on Customer Name.");
		JavaScriptExec.sleep();
		String CustomerName = sp.ExcelRead(sheetName).get(3);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']")).click();
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
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Click Add Sub Account Button");
		Assert.assertTrue(clickCreateOrderButton.isDisplayed());
		clickCreateOrderButton.click();
		JavaScriptExec.sleep();

	}

	private WebElement selectPeriod;

	/**
	 * Method to select Period.
	 * 
	 * @throws IOException
	 */
	public void selectPeriod() throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		WebElement Periodelement = driver.findElement(By.xpath("//select[@name='period']"));
		Select se = new Select(Periodelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(4));

	}

	private WebElement selectOrderType;

	/**
	 * Method to select Order Type.
	 * 
	 * @throws IOException
	 */
	public void selectOrderType() throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		WebElement OrderTypeelement = driver.findElement(By.xpath("//select[@name='billingTypeId']"));
		Select se = new Select(OrderTypeelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(5));

	}

	@FindBy(how = How.XPATH, using = "//*[@id='ui-id-8']")
	private WebElement clickProductSubTab;

	/**
	 * Method to Click Products tab.
	 * 
	 * @throws IOException
	 */
	public void clickProductSubTab() throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Click Products Tab");
		Assert.assertTrue(clickProductSubTab.isDisplayed());
		clickProductSubTab.click();
		JavaScriptExec.sleep();

	}

	private WebElement selectCategory;

	/**
	 * Method to select account type.
	 * 
	 * @throws IOException
	 */
	public void selectCategory() throws IOException {
		ReportsPage sp = new ReportsPage(driver);
		WebElement categoryElement = driver.findElement(By.xpath("//select[@name='typeId']"));
		Select se = new Select(categoryElement);
		se.selectByVisibleText("New Test category");
		JavaScriptExec.sleep();

	}

	// @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='abc']")
	private WebElement selectProduct;

	/**
	 * Method to Select Product from list.
	 * 
	 * @throws IOException
	 */
	public void selectProduct() throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Click Product from list");
		String ProductName = sp.ExcelRead(sheetName).get(6);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']")).click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//input[@id='change--3.useItem']")
	private WebElement clickCheckboxToChangeName;

	/**
	 * Method to Click Checkbox to change product description.
	 * 
	 * @throws IOException
	 */
	public void clickCheckboxToChangeName() throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Click Checkbox to change product description");
		Assert.assertTrue(clickCheckboxToChangeName.isDisplayed());
		clickCheckboxToChangeName.click();

	}

	@FindBy(how = How.XPATH, using = " //input[@name='change--3.description']")
	private WebElement changeProductDescription;

	/**
	 * Method to Change product description.
	 * 
	 * @throws IOException
	 */
	public void changeProductDescription() throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Change product description");
		Assert.assertTrue(changeProductDescription.isDisplayed());
		changeProductDescription.clear();
		changeProductDescription.sendKeys(sp.ExcelRead(sheetName).get(7));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Update']")
	private WebElement clickUpdateButton;

	/**
	 * Method to Click Update Button.
	 * 
	 * @throws IOException
	 */
	public void clickUpdateButton() throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Click Update Button");
		Assert.assertTrue(clickUpdateButton.isDisplayed());
		clickUpdateButton.click();
		JavaScriptExec.sleep();

	}

	private WebElement selectPeriod1;

	/**
	 * Method to select Period.
	 * 
	 * @throws IOException
	 */
	public void selectPeriod1() throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		JavaScriptExec.sleep();
		WebElement Periodelement = driver.findElement(By.xpath("//select[@name='period']"));
		Select se = new Select(Periodelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(8));

	}

	private WebElement selectOrderType1;

	/**
	 * Method to select Order Type.
	 * 
	 * @throws IOException
	 */
	public void selectOrderType1() throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		JavaScriptExec.sleep();
		WebElement OrderTypeelement = driver.findElement(By.xpath("//select[@name='billingTypeId']"));
		Select se = new Select(OrderTypeelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(9));

	}

	private WebElement selectProduct1;

	/**
	 * Method to Select Product from list.
	 * 
	 * @throws IOException
	 */
	public void selectProduct1() throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Click Product from list");
		String ProductName = sp.ExcelRead(sheetName).get(10);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']")).click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = " //input[@name='change--3.description']")
	private WebElement changeProductDescription1;

	/**
	 * Method to Change product description.
	 * 
	 * @throws IOException
	 */
	public void changeProductDescription1() throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Change product description");
		Assert.assertTrue(changeProductDescription1.isDisplayed());
		changeProductDescription1.clear();
		changeProductDescription1.sendKeys(sp.ExcelRead(sheetName).get(11));

	}

	// @FindBy(how=How.XPATH, using="//a[@class='cell']//*[text()='401']")
	private WebElement selectMonthlyOrder;

	/**
	 * Method to Select Monthly Order from list.
	 * 
	 * @throws IOException
	 */
	public void selectMonthlyOrder(String orderId) throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Click Monthly Order from list");
		JavaScriptExec.sleep();
		driver.findElement(By.xpath("//a[@class='cell']//*[text()='" + orderId + "']")).click();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit order']//*[text()='Generate Invoice']")
	private WebElement clickGenerateInvoiceButton;

	/**
	 * Method to Click on Generate Invoice Button.
	 * 
	 * @throws IOException
	 */
	public void clickGenerateInvoiceButton() throws IOException {
		JavaScriptExec.scrollToElementOnPage(driver, clickGenerateInvoiceButton);
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Click on Generate Invoice Button");
		Assert.assertTrue(clickGenerateInvoiceButton.isDisplayed());
		clickGenerateInvoiceButton.click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu.link.orders']/a")
	private WebElement clickOrdersTab;

	/**
	 * Method to Click on Orders Tab.
	 * 
	 * @throws IOException
	 */
	public void clickOrdersTab() throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Click on Orders Tab");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickOrdersTab.isDisplayed());
		clickOrdersTab.click();

	}

	// @FindBy(how=How.XPATH, using="//a[@class='cell']//*[text()='501']")
	private WebElement selectOneTimeOrder;

	/**
	 * Method to Select One Time Order from list.
	 * 
	 * @throws IOException
	 */
	public void selectOneTimeOrder(String orderId) throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Click OneTime Order from list");
		JavaScriptExec.sleep();
		driver.findElement(By.xpath("//a[@class='cell']//*[text()='" + orderId + "']")).click();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit order']//*[text()='Apply to Invoice']")
	private WebElement clickApplyToInvoiceButton;

	/**
	 * Method to Click on Apply to invoice button.
	 * 
	 * @throws IOException
	 */
	public void clickApplyToInvoiceButton() throws IOException {
		JavaScriptExec.scrollToElementOnPage(driver, clickApplyToInvoiceButton);
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Click on Apply to invoice button");
		Assert.assertTrue(clickApplyToInvoiceButton.isDisplayed());
		clickApplyToInvoiceButton.click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='invoiceId']")
	private WebElement clickInvoiceRadioButton;

	/**
	 * Method to Click on Invoice Radio button.
	 * 
	 * @throws IOException
	 */
	public void clickInvoiceRadioButton() throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Click on Invoice Radio button");
		Assert.assertTrue(clickInvoiceRadioButton.isDisplayed());
		clickInvoiceRadioButton.click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit okay']//*[text()='Apply']")
	private WebElement clickApplyButton;

	/**
	 * Method to Click on Apply button.
	 * 
	 * @throws IOException
	 */
	public void clickApplyButton() throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Click on Apply button");
		Assert.assertTrue(clickApplyButton.isDisplayed());
		clickApplyButton.click();

	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu.link.invoices']/a")
	private WebElement clickInvoicesTab;

	/**
	 * Method to Click on Invoices Tab.
	 * 
	 * @throws IOException
	 */
	public void clickInvoicesTab() throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Click on Invoices Tab");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickInvoicesTab.isDisplayed());
		clickInvoicesTab.click();

	}

	// @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Sarah
	// Wilson']")
	private WebElement clickInvoiceCreated;

	/**
	 * Method to Click on Invoice Created.
	 * 
	 * @throws IOException
	 */
	public void clickInvoiceCreated() throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Click on Invoice created.");
		String CustomerName = sp.ExcelRead(sheetName).get(15);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']")).click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit payment']//*[text()='Pay Invoice']")
	private WebElement clickPayInvoiceButton;

	/**
	 * Method to Click on Pay Invoice Button.
	 * 
	 * @throws IOException
	 */
	public void clickPayInvoiceButton() throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Click on Pay Invoice Button");
		JavaScriptExec.scrolltoBottomofPage(driver);
		Assert.assertTrue(clickPayInvoiceButton.isDisplayed());
		actions.moveToElement(clickPayInvoiceButton).click(clickPayInvoiceButton).perform();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//input[@id='processNow']")
	private WebElement clickProcessRealTimeCheckbox;

	/**
	 * Method to Click on Process Payment in Real-Time checkbox.
	 * 
	 * @throws IOException
	 */
	public void clickProcessRealTimeCheckbox() throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Click on Process Payment in Real-Time checkbox");
		Assert.assertTrue(clickProcessRealTimeCheckbox.isDisplayed());
		actions.moveToElement(clickProcessRealTimeCheckbox).click().perform();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='paymentMethod_0.processingOrder']")
	private WebElement enterProcessOrder;

	/**
	 * Method to Enter value for Process Order.
	 * 
	 * @throws IOException
	 */
	public void enterProcessOrder() throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Enter value for Process Order.");
		Assert.assertTrue(enterProcessOrder.isDisplayed());
		enterProcessOrder.sendKeys(sp.ExcelRead(sheetName).get(14));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='0_metaField_86.value']")
	private WebElement enterCardHolderName;

	/**
	 * Method to Enter card holder name.
	 * 
	 * @throws IOException
	 */
	public void enterCardHolderName() throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Enter card holder name");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, enterCardHolderName);
		Assert.assertTrue(enterCardHolderName.isDisplayed());
		enterCardHolderName.sendKeys(sp.ExcelRead(sheetName).get(15));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='0_metaField_85.value']")
	private WebElement enterCardNumber;

	/**
	 * Method to Enter card number.
	 * 
	 * @throws IOException
	 */
	public void enterCardNumber() throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Enter card number");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, enterCardNumber);
		Assert.assertTrue(enterCardNumber.isDisplayed());
		enterCardNumber.sendKeys(sp.ExcelRead(sheetName).get(16));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='0_metaField_83.value']")
	private WebElement enterCardExpiry;

	/**
	 * Method to Enter card expiry date.
	 * 
	 * @throws IOException
	 */
	public void enterCardExpiry() throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Enter card number");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, enterCardExpiry);
		Assert.assertTrue(enterCardExpiry.isDisplayed());
		enterCardExpiry.sendKeys(sp.ExcelRead(sheetName).get(17));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit payment']//*[text()='Review Payment']")
	private WebElement clickReviewPaymentButton;

	/**
	 * Method to Click on Review Payment Button.
	 * 
	 * @throws IOException
	 */
	public void clickReviewPaymentButton() throws IOException {
		JavaScriptExec.scrollToElementOnPage(driver, clickReviewPaymentButton);
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Click on Review Payment Button");
		Assert.assertTrue(clickReviewPaymentButton.isDisplayed());
		clickReviewPaymentButton.click();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit payment']//*[text()='Make Payment']")
	private WebElement clickMakePaymentButton;

	/**
	 * Method to Click on Make Payment Button.
	 * 
	 * @throws IOException
	 */
	public void clickMakePaymentButton() throws IOException {
		JavaScriptExec.scrollToElementOnPage(driver, clickMakePaymentButton);
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Click on Review Payment Button");
		Assert.assertTrue(clickMakePaymentButton.isDisplayed());
		clickMakePaymentButton.click();

	}

	// @FindBy(how=How.XPATH,
	// using="//*[@id='column2']/div/div[7]/div/table/tbody/tr/td[6]")
	private WebElement verifyPaymentSuccessfulMsg;

	/**
	 * Method to verify payment status is successful.
	 * 
	 * @throws IOException
	 */
	public void verifyPaymentSuccessfulMsg() throws IOException {
		GeneratingPayingInvoicePage sp = new GeneratingPayingInvoicePage(driver);
		log.info("Verifying if payment status is successful.");
		JavaScriptExec.sleep();
		String ExpectedMsg = "Successful";
		String CustomerName = sp.ExcelRead(sheetName).get(15);
		String ActualMsg = driver.findElement(By.xpath("//*[text()='" + CustomerName + "']/following::span[5]"))
				.getText();
		Assert.assertEquals(ActualMsg, ExpectedMsg);
	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}

}
