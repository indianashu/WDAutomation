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

public class DiscountPage extends BasePage {
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public DiscountPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(DiscountPage.class);
	DiscountPage discountPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "Discount";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		DiscountPage sp = new DiscountPage(driver);

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
		DiscountPage sp = new DiscountPage(driver);
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
		DiscountPage sp = new DiscountPage(driver);
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
		DiscountPage sp = new DiscountPage(driver);
		log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
		Assert.assertTrue(clickLoginButton.isDisplayed());
		clickLoginButton.click();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu.link.discounts']/a")
	private WebElement clickDiscountTab;

	/**
	 * Method to click on Discount tab after successful login.
	 * 
	 * @throws IOException
	 */
	public void clickDiscountTab() throws IOException {
		DiscountPage sp = new DiscountPage(driver);
		log.info("Click on Discount Tab after successful login");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickDiscountTab.isDisplayed());
		clickDiscountTab.click();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add New']")
	private WebElement clickAddNewButton;

	/**
	 * Method to click on Add New Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddNewButton() throws IOException {
		DiscountPage sp = new DiscountPage(driver);
		log.info("Click on Add New Button");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickAddNewButton.isDisplayed());
		clickAddNewButton.click();

	}

	@FindBy(how = How.XPATH, using = "//div[@class='msg-box error']//*[text()='Error']")
	private WebElement verifyErrorMsg;

	/**
	 * Method to verify Error message is shown when click on save changes button
	 * without entering data.
	 * 
	 * @throws IOException
	 */
	public void verifyErrorMsg() throws IOException {
		DiscountPage sp = new DiscountPage(driver);
		log.info("verify Error message is shown when click on save changes button without entering data.");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyErrorMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
	}

	@FindBy(how = How.XPATH, using = "//input[@name='discount.code']")
	private WebElement enterDiscountCode;

	/**
	 * Method to enter discount code.
	 * 
	 * @throws IOException
	 */
	public void enterDiscountCode() throws IOException {
		DiscountPage sp = new DiscountPage(driver);
		log.info("Enter Discount Code.");
		Assert.assertTrue(enterDiscountCode.isDisplayed());
		enterDiscountCode.sendKeys(sp.ExcelRead(sheetName).get(3));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='discount.descriptions[0].content']")
	private WebElement enterDiscountDescription;

	/**
	 * Method to enter discount description.
	 * 
	 * @throws IOException
	 */
	public void enterDiscountDescription() throws IOException {
		DiscountPage sp = new DiscountPage(driver);
		log.info("Enter Discount Description");
		Assert.assertTrue(enterDiscountDescription.isDisplayed());
		enterDiscountDescription.sendKeys(sp.ExcelRead(sheetName).get(4));

	}

	private WebElement selectDiscountType;

	/**
	 * Method to select Discount Type.
	 * 
	 * @throws IOException
	 */
	public void selectDiscountType() throws IOException {
		DiscountPage sp = new DiscountPage(driver);
		WebElement DTelement = driver.findElement(By.xpath("//select[@name='discount.type']"));
		Select se = new Select(DTelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(5));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='discount.rate']")
	private WebElement enterDiscountRate;

	/**
	 * Method to enter discount rate.
	 * 
	 * @throws IOException
	 */
	public void enterDiscountRate() throws IOException {
		DiscountPage sp = new DiscountPage(driver);
		log.info("Enter Discount rate.");
		Assert.assertTrue(enterDiscountRate.isDisplayed());
		enterDiscountRate.sendKeys(sp.ExcelRead(sheetName).get(6));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickSaveChangesButton() throws IOException {
		DiscountPage sp = new DiscountPage(driver);
		log.info("Click on Save Changes Button");
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		clickSaveChangesButton.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu.link.customers']/a")
	private WebElement clickCustomersTab;

	/**
	 * Method to click on customers tab.
	 * 
	 * @throws IOException
	 */
	public void clickCustomersTab() throws IOException {
		DiscountPage sp = new DiscountPage(driver);
		log.info("click on customers tab");
		Assert.assertTrue(clickCustomersTab.isDisplayed());
		clickCustomersTab.click();
		JavaScriptExec.sleep();

	}

	/**
	 * Method to Click on Customer A.
	 * 
	 * @throws IOException
	 */
	public void clickCustomerA() throws IOException {
		DiscountPage sp = new DiscountPage(driver);
		log.info("Click on customer A");
		String CustomerName = sp.ExcelRead(sheetName).get(7);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']")).click();
		JavaScriptExec.sleep();
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='filters.CUSTOMER-LIKE_UserName.stringValue']")
	private WebElement enterCustomerNameFilter;

	/**
	 * Method to enter the customer name in the Login name Filter.
	 * 
	 * @throws IOException
	 */
	public void enterCustomerNameFilter() throws IOException {
		DiscountPage sp = new DiscountPage(driver);
		log.info("Click on customer A");
		Assert.assertTrue(enterCustomerNameFilter.isDisplayed());
		enterCustomerNameFilter.sendKeys(sp.ExcelRead(sheetName).get(7));
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
		DiscountPage sp = new DiscountPage(driver);
		log.info("Click on Apply Filter");
		Assert.assertTrue(applyFilter.isDisplayed());
		applyFilter.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit order']//*[text()='Create Order']")
	private WebElement clickCreateOrderButton;

	/**
	 * Method to Click on Create Order Button.
	 * 
	 * @throws IOException
	 */
	public void clickCreateOrderButton() throws IOException {
		JavaScriptExec.scrollToElementOnPage(driver, clickCreateOrderButton);
		DiscountPage sp = new DiscountPage(driver);
		log.info("Click on Create Order Button.");
		Assert.assertTrue(clickCreateOrderButton.isDisplayed());
		clickCreateOrderButton.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='ui-id-8']")
	private WebElement clickProductSubTab;

	/**
	 * Method to click on Product sub tab.
	 * 
	 * @throws IOException
	 */
	public void clickProductSubTab() throws IOException {
		DiscountPage sp = new DiscountPage(driver);
		log.info("Click on Product Sub Tab.");
		Assert.assertTrue(clickProductSubTab.isDisplayed());
		clickProductSubTab.click();
		JavaScriptExec.sleep();
	}

	// @FindBy(how=How.XPATH, using="//a[@class='cell
	// double']//*[text()='BillingFl']")
	private WebElement selectProduct;

	/**
	 * Method to Select a Product.
	 * 
	 * @throws IOException
	 */
	public void selectProduct() throws IOException {
		DiscountPage sp = new DiscountPage(driver);
		log.info("Select a product.");
		String ProductName = sp.ExcelRead(sheetName).get(8);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']")).click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='ui-id-9']")
	private WebElement clickDiscountSubTab;

	/**
	 * Method to click on Discount sub tab.
	 * 
	 * @throws IOException
	 */
	public void clickDiscountSubTab() throws IOException {
		DiscountPage sp = new DiscountPage(driver);
		log.info("Click on Discount Sub Tab.");
		Assert.assertTrue(clickDiscountSubTab.isDisplayed());
		clickDiscountSubTab.click();
		JavaScriptExec.sleep();

	}

	private WebElement selectDiscount;

	/**
	 * Method to select Discount.
	 * 
	 * @throws IOException
	 */
	public void selectDiscount() throws IOException {
		DiscountPage sp = new DiscountPage(driver);
		WebElement Discountelement = driver.findElement(By.xpath("//select[@name='discount.0.id']"));
		Select se = new Select(Discountelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(9));

	}

	// @FindBy(how=How.XPATH, using="//*[@id='discount-messages']/ul/li")
	private WebElement verifyErrorMessage;

	/**
	 * Method to Verify Error Message shown on selecting Discount.
	 * 
	 * @throws IOException
	 */
	public void verifyErrorMessage() throws IOException {
		DiscountPage sp = new DiscountPage(driver);
		log.info("Verify Error Message shown on selecting Discount.");
		JavaScriptExec.sleep();
		String ExpectedErrorMsg = sp.ExcelRead(sheetName).get(10);
		String ActualErrorMsg = driver.findElement(By.xpath("//*[@id='discount-messages']/ul/li")).getText();
		Assert.assertEquals(ActualErrorMsg, ExpectedErrorMsg);

	}

	private WebElement selectDiscountableItem;

	/**
	 * Method to select Discountable Item.
	 * 
	 * @throws IOException
	 */
	public void selectDiscountableItem() throws IOException {
		DiscountPage sp = new DiscountPage(driver);
		WebElement Discountelement = driver
				.findElement(By.xpath("//select[@name='discountableItem.0.lineLevelDetails']"));
		Select se = new Select(Discountelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(11));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Update']")
	private WebElement clickUpdateButton;

	/**
	 * Method to click on update button.
	 * 
	 * @throws IOException
	 */
	public void clickUpdateButton() throws IOException {
		DiscountPage sp = new DiscountPage(driver);
		log.info("click on update button.");
		Assert.assertTrue(clickUpdateButton.isDisplayed());
		clickUpdateButton.click();
		JavaScriptExec.sleep();

	}

	// @FindBy(how=How.XPATH, using="//a[@class='cell
	// double']//*[text()='BillingFl']")
	private WebElement selectProduct1;

	/**
	 * Method to Select a Product.
	 * 
	 * @throws IOException
	 */
	public void selectProduct1() throws IOException {
		DiscountPage sp = new DiscountPage(driver);
		log.info("Select a product.");
		String ProductName = sp.ExcelRead(sheetName).get(12);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']")).click();
		JavaScriptExec.sleep();

	}

	// @FindBy(how=How.XPATH, using="//*[@id='review-box']/div[3]")
	private WebElement verifyAmount;

	/**
	 * Method to Verify Amount is shown with discount.
	 * 
	 * @throws IOException
	 */
	public void verifyAmount() throws IOException {
		DiscountPage sp = new DiscountPage(driver);
		log.info("Verify Amount is shown with discount.");
		JavaScriptExec.sleep();
		String ExpectedErrorMsg = sp.ExcelRead(sheetName).get(14);
		String ActualErrorMsg = driver.findElement(By.xpath("//*[@id='review-box']/div[3]")).getText();
		Assert.assertEquals(ActualErrorMsg, ExpectedErrorMsg);

	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu.link.orders']/a")
	private WebElement clickOrdersTab;

	/**
	 * Method to click on Orders Tab.
	 * 
	 * @throws IOException
	 */
	public void clickOrdersTab() throws IOException {
		DiscountPage sp = new DiscountPage(driver);
		log.info("click on Orders Tab.");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, clickOrdersTab);
		Assert.assertTrue(clickOrdersTab.isDisplayed());
		clickOrdersTab.click();

	}

	// @FindBy(how=How.XPATH, using="//a[@class='cell']//*[text()='604']")
	private WebElement clickOrder;

	/**
	 * Method to click on Order..
	 * 
	 * @throws IOException
	 */
	public void clickOrder() throws IOException {
		DiscountPage sp = new DiscountPage(driver);
		log.info("click on Order.");
		JavaScriptExec.sleep();
		String OrderNumber = sp.ExcelRead(sheetName).get(13);
		driver.findElement(By.xpath("//a[@class='cell']//*[text()='" + OrderNumber + "']")).click();

	}

	private WebElement verifyAmountDifference;

	/**
	 * Method to Verify Amount is shown with discount.
	 * 
	 * @throws IOException
	 */
	public void verifyAmountDifference() throws IOException {
		DiscountPage sp = new DiscountPage(driver);
		log.info("Verify Amount is shown with discount.");
		JavaScriptExec.sleep();
		String Amount1 = driver.findElement(By.xpath("//*[@id='column2']/div/div[6]/div/table/tbody/tr/td[4]"))
				.getText();
		System.out.println("Amount 1 --->: " + Amount1);
		String Amount2 = driver.findElement(By.xpath("//*[@id='column2']/div/div[6]/div/table/tbody/tr/td[5]"))
				.getText();
		System.out.println("Amount 2 --->: " + Amount2);
		// Assert.assertEquals(Amount1, Amount2);
		Assert.assertNotEquals(Amount1, Amount2);

	}

	/**
	 * Method to Create Plan Type Category after successful login.
	 * 
	 * @throws IOException
	 */
	public void createPlanCategory() throws IOException {
		DiscountPage sp = new DiscountPage(driver);
		log.info("Create Plan Type Category");

		log.info("Click Products Tab");
		JavaScriptExec.sleep();
		WebElement clickProductsTab = driver.findElement(By.xpath("//*[@id='menu.link.products']/a"));
		Assert.assertTrue(clickProductsTab.isDisplayed());
		clickProductsTab.click();

		log.info("Click on Add Category Button");
		navigateBottom();
		WebElement clickAddCategoryButton = driver
				.findElement(By.xpath("//a[@class='submit add']//*[text()='Add Category']"));
		Assert.assertTrue(clickAddCategoryButton.isDisplayed());
		clickAddCategoryButton.click();

		log.info("Enter Category Name");
		WebElement enterCategoryName = driver.findElement(By.xpath("//input[@name='description']"));
		Assert.assertTrue(enterCategoryName.isDisplayed());
		enterCategoryName.sendKeys(sp.ExcelRead(sheetName).get(15));

		log.info("Select Plan order line type");
		WebElement orderLineTypeId = driver.findElement(By.xpath("//*[@name='orderLineTypeId']"));
		Select se = new Select(orderLineTypeId);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(16));

		log.info("Click on Save Changes Button");
		WebElement clickSaveChangesButton = driver
				.findElement(By.xpath("//a[@class='submit save']//*[text()='Save Changes']"));
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		clickSaveChangesButton.click();
		JavaScriptExec.sleep();
	}

	/**
	 * Method to Create Plan Type Product.
	 * 
	 * @throws IOException
	 */
	public void createPlanTypeProduct() throws IOException {
		DiscountPage sp = new DiscountPage(driver);
		log.info("Create Plan Type Product");

		log.info("Click on a category name.");
		JavaScriptExec.sleep();
		String CategoryName = sp.ExcelRead(sheetName).get(15);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CategoryName + "']")).click();

		log.info("Click on Add Product Button");
		JavaScriptExec.sleep();
		WebElement clickAddProductButton = driver
				.findElement(By.xpath("//a[@class='submit add']//*[text()='Add Product']"));
		Assert.assertTrue(clickAddProductButton.isDisplayed());
		clickAddProductButton.click();

		log.info("Enter English Description");
		WebElement enterEnglishDescription = driver
				.findElement(By.xpath("//input[@name='product.descriptions[0].content']"));
		Assert.assertTrue(enterEnglishDescription.isDisplayed());
		enterEnglishDescription.sendKeys(sp.ExcelRead(sheetName).get(17));

		log.info("Enter Product Code");
		WebElement enterProductCode = driver.findElement(By.xpath("//input[@name='product.number']"));
		Assert.assertTrue(enterProductCode.isDisplayed());
		enterProductCode.sendKeys(sp.ExcelRead(sheetName).get(17));

		JavaScriptExec.scrolltoBottomofPage(driver);

		log.info("Enter Price Rate");
		WebElement enterPriceRate = driver.findElement(By.xpath("//input[@name='product.rate']"));
		Assert.assertTrue(enterPriceRate.isDisplayed());
		enterPriceRate.sendKeys(sp.ExcelRead(sheetName).get(18));

		log.info("Click on Add Price Button");
		WebElement clickAddPriceButton = driver
				.findElement(By.xpath("//a[@class='submit add']//*[text()='Add Price']"));
		Assert.assertTrue(clickAddPriceButton.isDisplayed());
		clickAddPriceButton.click();

		log.info("Click on Save Changes Button");
		WebElement clickSaveChangesButton = driver
				.findElement(By.xpath("//a[@class='submit save']//*[text()='Save Changes']"));
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		clickSaveChangesButton.click();
		JavaScriptExec.sleep();
	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}

}
