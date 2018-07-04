package invoice;

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

public class GeneratingInvoicePage extends BasePage {
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public GeneratingInvoicePage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(GeneratingInvoicePage.class);
	GeneratingInvoicePage generatingInvoicePage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "GenerateInvoice";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);

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
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
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
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
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
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
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
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
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
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
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
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
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
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
		log.info("Select Customer");
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
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
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
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
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
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
		WebElement OrderTypeelement = driver.findElement(By.xpath("//select[@name='billingTypeId']"));
		Select se = new Select(OrderTypeelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(5));

	}

	private WebElement selectActiveSince;

	/**
	 * Method to select Active since.
	 * 
	 * @throws IOException
	 */
	public void selectActiveSince() throws IOException {
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
		JavaScriptExec.sleep();
		WebElement ASelement = driver.findElement(By.xpath("//input[@name='activeSince']"));
		Select se = new Select(ASelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(6));

	}

	@FindBy(how = How.XPATH, using = "//*[@id='ui-id-8']")
	private WebElement clickProductSubTab;

	/**
	 * Method to Click Products tab.
	 * 
	 * @throws IOException
	 */
	public void clickProductSubTab() throws IOException {
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
		log.info("Click Products Tab");
		Assert.assertTrue(clickProductSubTab.isDisplayed());
		clickProductSubTab.click();
		JavaScriptExec.sleep();

	}
	
	private WebElement selectCategory;
    /**
     * Method to select account type.
     * @throws IOException 
     */
    public void selectCategory() throws IOException{
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
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
		log.info("Click Product from list");
		String ProductName = sp.ExcelRead(sheetName).get(7);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']")).click();
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
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
		log.info("Enter Effective Date");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, enterEffectiveDate);
		Assert.assertTrue(enterEffectiveDate.isDisplayed());
		enterEffectiveDate.sendKeys(sp.ExcelRead(sheetName).get(12));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='change--3.quantityAsDecimal']")
	private WebElement enterQuantity;

	/**
	 * Method to Enter Quantity.
	 * 
	 * @throws IOException
	 */
	public void enterQuantity() throws IOException {
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
		log.info("Enter Quantity");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, enterQuantity);
		Assert.assertTrue(enterQuantity.isDisplayed());
		enterQuantity.sendKeys(sp.ExcelRead(sheetName).get(13));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Update']")
	private WebElement clickUpdateButton;

	/**
	 * Method to Click Update Button.
	 * 
	 * @throws IOException
	 */
	public void clickUpdateButton() throws IOException {
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
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
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
		log.info("Verifying if NEW is shown or not");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, verifyNewOrder);
		Assert.assertTrue(verifyNewOrder.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu.link.orders']/a")
	private WebElement clickOrdersTab;

	/**
	 * Method to Click on Orders Tab.
	 * 
	 * @throws IOException
	 */
	public void clickOrdersTab() throws IOException {
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
		log.info("Click on Orders Tab.");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickOrdersTab.isDisplayed());
		clickOrdersTab.click();

	}

	// @FindBy(how=How.XPATH, using="//a[@class='double cell']//*[text()='Ashish']")
	private WebElement selectOrder;

	/**
	 * Method to Click on Order.
	 * 
	 * @throws IOException
	 */
	public void selectOrder() throws IOException {
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
		log.info("Click on Order.");
		JavaScriptExec.sleep();
		String CustomerName = sp.ExcelRead(sheetName).get(3);
		driver.findElement(By.xpath("//a[@class='double cell']//*[text()='" + CustomerName + "']")).click();
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
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
		log.info("Click on Generate Invoice Button");
		Assert.assertTrue(clickGenerateInvoiceButton.isDisplayed());
		clickGenerateInvoiceButton.click();

	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu.link.products']/a")
	private WebElement clickProductsTab;

	/**
	 * Method to Click on Products Tab.
	 * 
	 * @throws IOException
	 */
	public void clickProductsTab() throws IOException {
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
		log.info("Click on Products Tab.");
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
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
		log.info("Click on Add Category Button.");
		navigateBottom();
		Assert.assertTrue(clickAddCategoryButton.isDisplayed());
		clickAddCategoryButton.click();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='description']")
	private WebElement enterCategoryName;

	/**
	 * Method to Enter Category Name.
	 * 
	 * @throws IOException
	 */
	public void enterCategoryName() throws IOException {
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
		log.info("Enter Category Name.");
		Assert.assertTrue(enterCategoryName.isDisplayed());
		enterCategoryName.sendKeys(sp.ExcelRead(sheetName).get(10));

	}

	// @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Test
	// Code']")
	private WebElement clickCategoryName;

	/**
	 * Method to Click on Category Name.
	 * 
	 * @throws IOException
	 */
	public void clickCategoryName() throws IOException {
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
		log.info("Click on Category Name.");
		String CategoryName = sp.ExcelRead(sheetName).get(10);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CategoryName + "']")).click();
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
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
		log.info("Click on Add Product Button.");
		Assert.assertTrue(clickAddProductButton.isDisplayed());
		clickAddProductButton.click();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.descriptions[0].content']")
	private WebElement enterProductDescription;

	/**
	 * Method to Enter Product Description.
	 * 
	 * @throws IOException
	 */
	public void enterProductDescription() throws IOException {
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
		log.info("Enter Product Description.");
		Assert.assertTrue(enterProductDescription.isDisplayed());
		enterProductDescription.sendKeys(sp.ExcelRead(sheetName).get(11));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.number']")
	private WebElement enterProductCode;

	/**
	 * Method to Enter Product Code.
	 * 
	 * @throws IOException
	 */
	public void enterProductCode() throws IOException {
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
		log.info("Enter Product Code.");
		Assert.assertTrue(enterProductCode.isDisplayed());
		enterProductCode.sendKeys(sp.ExcelRead(sheetName).get(12));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.rate']")
	private WebElement enterProductRate;

	/**
	 * Method to Enter Product Rate.
	 * 
	 * @throws IOException
	 */
	public void enterProductRate() throws IOException {
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
		log.info("Enter Product Rate.");
		navigateBottom();
		Assert.assertTrue(enterProductRate.isDisplayed());
		enterProductRate.sendKeys(sp.ExcelRead(sheetName).get(13));

		log.info("Click on Add Price Button");
		WebElement clickAddPriceButton = driver
				.findElement(By.xpath("//a[@class='submit add']//*[text()='Add Price']"));
		Assert.assertTrue(clickAddPriceButton.isDisplayed());
		clickAddPriceButton.click();

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
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
		log.info("Click on Customer Name.");
		JavaScriptExec.sleep();
		String CustomerName = sp.ExcelRead(sheetName).get(3);
		driver.findElement(By.xpath("//*[text()='" + CustomerName + "']/following::a[1]")).click();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='dueDateValue']")
	private WebElement enterDueDate;

	/**
	 * Method to Enter Due Date.
	 * 
	 * @throws IOException
	 */
	public void enterDueDate() throws IOException {
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
		log.info("Enter Due Date.");
		Assert.assertTrue(enterDueDate.isDisplayed());
		enterDueDate.sendKeys(sp.ExcelRead(sheetName).get(14));

	}

	// @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='abc']")
	private WebElement selectProduct1;

	/**
	 * Method to Select Product from list.
	 * 
	 * @throws IOException
	 */
	public void selectProduct1() throws IOException {
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
		log.info("Click Product from list");
		String ProductName = sp.ExcelRead(sheetName).get(11);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']")).click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//*[@id='review-messages']/div/ul/li")
	private WebElement verifyErrorMessage;

	/**
	 * Method to Verify Error Message.
	 * 
	 * @throws IOException
	 */
	public void verifyErrorMessage() throws IOException {
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
		log.info("Verify Error Message.");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyErrorMessage.isDisplayed(),
				"Assert Failed as its unable to search text in Logged in Page");

	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}

}
