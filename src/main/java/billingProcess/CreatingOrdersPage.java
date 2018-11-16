package billingProcess;

import baseClassPackage.BasePage;
import categoryProducts.AddProductPage;
import customer.MakePaymentPage;

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

public class CreatingOrdersPage extends BasePage {
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public CreatingOrdersPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(CreatingOrdersPage.class);
	CreatingOrdersPage creatingOrdersPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "BillCreateOrders";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);

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
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
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
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
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
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
		Assert.assertTrue(clickLoginButton.isDisplayed());
		clickLoginButton.click();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickSaveChangesButton() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
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
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("Verifying if Account Type is created Successfully or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyConfirmationMsg.isDisplayed(),
				"Assert Failed as its unable to search text in Logged in Page");
	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu.link.products']/a")
	private WebElement clickProductsTab;

	/**
	 * Method to Click on Products Tab.
	 * 
	 * @throws IOException
	 */
	public void clickProductsTab() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("Click on Products Tab");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickProductsTab.isDisplayed());
		clickProductsTab.click();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add Category']")
	private WebElement clickAddCategoryButton;

	/**
	 * Method to Click on Add Category Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddCategoryButton() throws IOException {
		JavaScriptExec.scrollToElementOnPage(driver, clickAddCategoryButton);
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("Click on Add Category Button");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickAddCategoryButton.isDisplayed());
		clickAddCategoryButton.click();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='description']")
	private WebElement enterProductCategoryName;

	/**
	 * Method to enter product category name.
	 * 
	 * @throws IOException
	 */
	public void enterProductCategoryName() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("Click on Add Category Button");
		Assert.assertTrue(enterProductCategoryName.isDisplayed());
		enterProductCategoryName.sendKeys(sp.ExcelRead(sheetName).get(3));

	}

	// a[@class='cell double']//*[text()='Billing Category']
	private WebElement clickProductCategoryName;

	/**
	 * Method to click on product category name.
	 * 
	 * @throws IOException
	 */
	public void clickProductCategoryName() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		String CategoryName = sp.ExcelRead(sheetName).get(3);
		clickProductCategoryName = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CategoryName + "']"));
		log.info("Click on Add Category Button");
		Assert.assertTrue(clickProductCategoryName.isDisplayed());
		clickProductCategoryName.click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add Product']")
	private WebElement clickAddProductButton;

	/**
	 * Method to Click on Add Product Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddProductButton() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("Click on Add Product Button");
		Assert.assertTrue(clickAddProductButton.isDisplayed());
		clickAddProductButton.click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.descriptions[0].content']")
	private WebElement enterProductDescription;

	/**
	 * Method to enter product description.
	 * 
	 * @throws IOException
	 */
	public void enterProductDescription() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("enter product description");
		Assert.assertTrue(enterProductDescription.isDisplayed());
		enterProductDescription.sendKeys(sp.ExcelRead(sheetName).get(4));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.number']")
	private WebElement enterProductCode;

	/**
	 * Method to enter product code.
	 * 
	 * @throws IOException
	 */
	public void enterProductCode() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("enter product code");
		Assert.assertTrue(enterProductCode.isDisplayed());
		enterProductCode.sendKeys(sp.ExcelRead(sheetName).get(5));

	}
	
	public void selectPriceCurrency() throws IOException {
		AddProductPage sp = new AddProductPage(driver);
		WebElement Currencyelement = driver.findElement(By.xpath("//select[@name='product.currencies']"));
		Select se = new Select(Currencyelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(30));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='mydate']")
	private WebElement enterPriceDate;

	/**
	 * Method to enter Price Date.
	 * 
	 * @throws IOException
	 */
	public void enterPriceDate() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("enter product code");
		Assert.assertTrue(enterPriceDate.isDisplayed());
		enterPriceDate.clear();
		enterPriceDate.sendKeys(sp.ExcelRead(sheetName).get(6));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.rate']")
	private WebElement enterPriceRate;

	/**
	 * Method to enter Price Rate.
	 * 
	 * @throws IOException
	 */
	public void enterPriceRate() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("enter product code");
		Assert.assertTrue(enterPriceRate.isDisplayed());
		enterPriceRate.sendKeys(sp.ExcelRead(sheetName).get(7));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.descriptions[0].content']")
	private WebElement enterProductDescription1;

	/**
	 * Method to enter product description.
	 * 
	 * @throws IOException
	 */
	public void enterProductDescription1() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("enter product description");
		Assert.assertTrue(enterProductDescription1.isDisplayed());
		enterProductDescription1.sendKeys(sp.ExcelRead(sheetName).get(8));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.number']")
	private WebElement enterProductCode1;

	/**
	 * Method to enter product code.
	 * 
	 * @throws IOException
	 */
	public void enterProductCode1() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("enter product code");
		Assert.assertTrue(enterProductCode1.isDisplayed());
		enterProductCode1.sendKeys(sp.ExcelRead(sheetName).get(9));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='mydate']")
	private WebElement enterPriceDate1;

	/**
	 * Method to enter Price Date.
	 * 
	 * @throws IOException
	 */
	public void enterPriceDate1() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("enter product code");
		Assert.assertTrue(enterPriceDate1.isDisplayed());
		enterPriceDate1.clear();
		enterPriceDate1.sendKeys(sp.ExcelRead(sheetName).get(10));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.rate']")
	private WebElement enterPriceRate1;

	/**
	 * Method to enter Price Rate.
	 * 
	 * @throws IOException
	 */
	public void enterPriceRate1() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("enter product code");
		Assert.assertTrue(enterPriceRate1.isDisplayed());
		enterPriceRate1.sendKeys(sp.ExcelRead(sheetName).get(11));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add Price']")
	private WebElement clickAddPriceButton;

	/**
	 * Method to click on add price button.
	 * 
	 * @throws IOException
	 */
	public void clickAddPriceButton() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("Click on Add Price Button");
		Assert.assertTrue(clickAddPriceButton.isDisplayed());
		clickAddPriceButton.click();

	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu.link.customers']/a")
	private WebElement clickCustomerTab;

	/**
	 * Method to click on Customer tab after successful login.
	 * 
	 * @throws IOException
	 */
	public void clickCustomerTab() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("Click on Customer Tab after successful login");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickCustomerTab.isDisplayed());
		clickCustomerTab.click();

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
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("Click on Customer 1");
		String CustomerName = sp.ExcelRead(sheetName).get(12);
		clickCustomer1 = driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']"));
		JavaScriptExec.sleep();
		Assert.assertTrue(clickCustomer1.isDisplayed());
		clickCustomer1.click();

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
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
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
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		JavaScriptExec.sleep();
		WebElement Periodelement = driver.findElement(By.xpath("//select[@name='period']"));
		Select se = new Select(Periodelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(13));

	}

	private WebElement selectOrderType;

	/**
	 * Method to select Order Type.
	 * 
	 * @throws IOException
	 */
	public void selectOrderType() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		JavaScriptExec.sleep();
		WebElement OrderTypeelement = driver.findElement(By.xpath("//select[@name='billingTypeId']"));
		Select se = new Select(OrderTypeelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(14));

	}

	private WebElement selectActiveSince;

	/**
	 * Method to select Active since.
	 * 
	 * @throws IOException
	 */
	public void selectActiveSince() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		WebElement ASelement = driver.findElement(By.xpath("//input[@name='activeSince']"));
		ASelement.clear();
		ASelement.sendKeys(sp.ExcelRead(sheetName).get(15));

	}

	@FindBy(how = How.XPATH, using = "//*[@id='ui-id-8']")
	private WebElement clickProductSubTab;

	/**
	 * Method to Click Products Subtab.
	 * 
	 * @throws IOException
	 */
	public void clickProductSubTab() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("Click Products Tab");
		Assert.assertTrue(clickProductSubTab.isDisplayed());
		clickProductSubTab.click();
		JavaScriptExec.sleep();
	}

	// @FindBy(how=How.XPATH, using="//a[@class='cell
	// double']//*[text()='BillingGrad']")
	private WebElement selectProduct;

	/**
	 * Method to Select Product from list.
	 * 
	 * @throws IOException
	 */
	public void selectProduct() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("Click Product from list");
		String ProductName = sp.ExcelRead(sheetName).get(8);
		selectProduct = driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']"));
		Assert.assertTrue(selectProduct.isDisplayed());
		selectProduct.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='change--3.startDate']")
	private WebElement enterEffectiveDate;

	/**
	 * Method to Enter Effective Date.
	 * 
	 * @throws IOException
	 */
	public void enterEffectiveDate() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("Enter Effective Date");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, enterEffectiveDate);
		Assert.assertTrue(enterEffectiveDate.isDisplayed());
		enterEffectiveDate.sendKeys(sp.ExcelRead(sheetName).get(16));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='change--3.quantityAsDecimal']")
	private WebElement enterQuantity;

	/**
	 * Method to Enter Quantity.
	 * 
	 * @throws IOException
	 */
	public void enterQuantity() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("Enter Quantity");
		Assert.assertTrue(enterQuantity.isDisplayed());
		enterQuantity.clear();
		enterQuantity.sendKeys(sp.ExcelRead(sheetName).get(17));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Update']")
	private WebElement clickUpdateButton;

	/**
	 * Method to Click Update Button.
	 * 
	 * @throws IOException
	 */
	public void clickUpdateButton() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("Click Update Button");
		Assert.assertTrue(clickUpdateButton.isDisplayed());
		clickUpdateButton.click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//span[@class='newOrderLine']")
	private WebElement verifyNewOrder;

	/**
	 * Method to verify NEW is shown.
	 * 
	 * @throws IOException
	 */
	public void verifyNewOrder() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("Verifying if NEW is shown or not");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, verifyNewOrder);
		Assert.assertTrue(verifyNewOrder.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
	}

	// #############################################

	private WebElement selectPeriod1;

	/**
	 * Method to select Period.
	 * 
	 * @throws IOException
	 */
	public void selectPeriod1() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		WebElement Periodelement = driver.findElement(By.xpath("//select[@name='period']"));
		Select se = new Select(Periodelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(18));

	}

	private WebElement selectOrderType1;

	/**
	 * Method to select Order Type.
	 * 
	 * @throws IOException
	 */
	public void selectOrderType1() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		WebElement OrderTypeelement = driver.findElement(By.xpath("//select[@name='billingTypeId']"));
		Select se = new Select(OrderTypeelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(19));

	}

	private WebElement selectActiveSince1;

	/**
	 * Method to select Active since.
	 * 
	 * @throws IOException
	 */
	public void selectActiveSince1() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		WebElement ASelement = driver.findElement(By.xpath("//input[@name='activeSince']"));
		ASelement.clear();
		ASelement.sendKeys(sp.ExcelRead(sheetName).get(20));
	}

	// @FindBy(how=How.XPATH, using="//a[@class='cell
	// double']//*[text()='BillingGrad']")
	private WebElement selectProduct1;

	/**
	 * Method to Select Product from list.
	 * 
	 * @throws IOException
	 */
	public void selectProduct1() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("Click Product from list");
		String ProductName = sp.ExcelRead(sheetName).get(4);
		selectProduct1 = driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']"));
		Assert.assertTrue(selectProduct1.isDisplayed());
		selectProduct1.click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='change--3.startDate']")
	private WebElement enterEffectiveDate1;

	/**
	 * Method to Enter Effective Date.
	 * 
	 * @throws IOException
	 */
	public void enterEffectiveDate1() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("Enter Effective Date");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, enterEffectiveDate1);
		Assert.assertTrue(enterEffectiveDate1.isDisplayed());
		enterEffectiveDate1.sendKeys(sp.ExcelRead(sheetName).get(21));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='change--3.quantityAsDecimal']")
	private WebElement enterQuantity1;

	/**
	 * Method to Enter Quantity.
	 * 
	 * @throws IOException
	 */
	public void enterQuantity1() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("Enter Quantity");
		Assert.assertTrue(enterQuantity1.isDisplayed());
		enterQuantity1.clear();
		enterQuantity1.sendKeys(sp.ExcelRead(sheetName).get(22));

	}

	// #############################################

	// @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Bill
	// Cust1']")
	private WebElement clickCustomer2;

	/**
	 * Method to Click on Customer 2.
	 * 
	 * @throws IOException
	 */
	public void clickCustomer2() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("Click on Customer 1");
		String CustomerName = sp.ExcelRead(sheetName).get(23);
		clickCustomer2 = driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']"));
		JavaScriptExec.sleep();
		Assert.assertTrue(clickCustomer2.isDisplayed());
		clickCustomer2.click();

	}

	private WebElement selectPeriod2;

	/**
	 * Method to select Period.
	 * 
	 * @throws IOException
	 */
	public void selectPeriod2() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		WebElement Periodelement = driver.findElement(By.xpath("//select[@name='period']"));
		Select se = new Select(Periodelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(24));

	}

	private WebElement selectOrderType2;

	/**
	 * Method to select Order Type.
	 * 
	 * @throws IOException
	 */
	public void selectOrderType2() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		WebElement OrderTypeelement = driver.findElement(By.xpath("//select[@name='billingTypeId']"));
		Select se = new Select(OrderTypeelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(25));

	}

	private WebElement selectActiveSince3;

	/**
	 * Method to select Active since.
	 * 
	 * @throws IOException
	 */
	public void selectActiveSince3() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		WebElement ASelement = driver.findElement(By.xpath("//input[@name='activeSince']"));
		ASelement.clear();
		ASelement.sendKeys(sp.ExcelRead(sheetName).get(26));

	}

	// @FindBy(how=How.XPATH, using="//a[@class='cell
	// double']//*[text()='BillingGrad']")
	private WebElement selectProduct2a;

	/**
	 * Method to Select Product from list.
	 * 
	 * @throws IOException
	 */
	public void selectProduct2a() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("Click Product from list");
		String ProductName = sp.ExcelRead(sheetName).get(8);
		selectProduct2a = driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']"));
		Assert.assertTrue(selectProduct2a.isDisplayed());
		selectProduct2a.click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='change--3.startDate']")
	private WebElement enterEffectiveDate2;

	/**
	 * Method to Enter Effective Date.
	 * 
	 * @throws IOException
	 */
	public void enterEffectiveDate2() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("Enter Effective Date");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, enterEffectiveDate2);
		Assert.assertTrue(enterEffectiveDate2.isDisplayed());
		enterEffectiveDate2.sendKeys(sp.ExcelRead(sheetName).get(27));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='change--3.quantityAsDecimal']")
	private WebElement enterQuantity2;

	/**
	 * Method to Enter Quantity.
	 * 
	 * @throws IOException
	 */
	public void enterQuantity2() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("Enter Quantity");
		Assert.assertTrue(enterQuantity2.isDisplayed());
		enterQuantity2.clear();
		enterQuantity2.sendKeys(sp.ExcelRead(sheetName).get(28));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='change--5.quantityAsDecimal']")
	private WebElement enterQuantity3;

	/**
	 * Method to Enter Quantity.
	 * 
	 * @throws IOException
	 */
	public void enterQuantity3() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("Enter Quantity");
		Assert.assertTrue(enterQuantity3.isDisplayed());
		enterQuantity3.clear();
		enterQuantity3.sendKeys(sp.ExcelRead(sheetName).get(29));

	}

	@FindBy(how = How.XPATH, using = "//*[text()='Update']/following::a[@class='submit save']/span")
	private WebElement clickUpdateButton2;

	/**
	 * Method to Click Update Button.
	 * 
	 * @throws IOException
	 */
	public void clickUpdateButton2() throws IOException {
		CreatingOrdersPage sp = new CreatingOrdersPage(driver);
		log.info("Click Update Button");
		Assert.assertTrue(clickUpdateButton2.isDisplayed());
		clickUpdateButton2.click();
		JavaScriptExec.sleep();

	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}

}
