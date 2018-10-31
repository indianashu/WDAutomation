package discount;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import baseClassPackage.BasePage;
import configurablePricing.ConfigurablePricingPage;
import utilPackages.JavaScriptExec;
import utilPackages.PropertyValExtractors;
import utilPackages.WaitClass;

public class DiscountScenarioPage extends BasePage{
	
	public DiscountScenarioPage(WebDriver driver) {
		super(driver);
	}

	Logger log = Logger.getLogger(DiscountScenarioPage.class);
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "Order";
	String xlsxName = "/Discount_TestData.xlsx";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		DiscountScenarioPage sp = new DiscountScenarioPage(driver);

		log.info("Verifying the Login ID is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, enterLoginID);
		Assert.assertTrue(enterLoginID.isDisplayed());
		enterLoginID.sendKeys(BasePage.getCellData(xlsxName, sheetName, 0, 0));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='j_password']")
	private WebElement enterPassword;

	/**
	 * Method to enter Password.
	 * 
	 * @throws IOException
	 */
	public void enterPassword() throws IOException {
		DiscountScenarioPage sp = new DiscountScenarioPage(driver);
		log.info("Verifying the First Name is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, enterPassword);
		Assert.assertTrue(enterPassword.isDisplayed());
		enterPassword.sendKeys(BasePage.getCellData(xlsxName, sheetName, 1, 0));

	}

	@FindBy(how = How.XPATH, using = "//select[@name='j_client_id']")
	private WebElement selectCompany;

	/**
	 * Method to Select Company to Login
	 */
	public void selectCompany() throws IOException {
		DiscountScenarioPage sp = new DiscountScenarioPage(driver);
		Select se = new Select(selectCompany);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 2, 0));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']")
	private WebElement clickLoginButton;

	/**
	 * Method to Click on Save Changes Button
	 */
	public void clickLoginButton() {
		DiscountScenarioPage sp = new DiscountScenarioPage(driver);
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
		DiscountScenarioPage sp = new DiscountScenarioPage(driver);
		log.info("Click on Customer Tab after successful login");
		Assert.assertTrue(clickCustomerTab.isDisplayed());
		clickCustomerTab.click();
		JavaScriptExec.sleep();
	}
	
	public void selectCustomer(int rowNum) throws IOException {
		DiscountScenarioPage sp = new DiscountScenarioPage(driver);
		log.info("Click on customer A");
		String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, rowNum);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']")).click();
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
		DiscountScenarioPage sp = new DiscountScenarioPage(driver);
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
		DiscountScenarioPage sp = new DiscountScenarioPage(driver);
		log.info("Click on Product Sub Tab.");
		Assert.assertTrue(clickProductSubTab.isDisplayed());
		clickProductSubTab.click();
		JavaScriptExec.sleep();
	}

	public void selectPricingProduct(int rowNum) throws IOException {
		DiscountScenarioPage sp = new DiscountScenarioPage(driver);
		log.info("Select a product.");
		String ProductName = BasePage.getCellData(xlsxName, sheetName, 5, rowNum);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']")).click();
		JavaScriptExec.sleep();
	}
	
	public void selectProduct(int rowNum) throws IOException {
		DiscountScenarioPage sp = new DiscountScenarioPage(driver);
		log.info("Select a product.");
		String ProductName = BasePage.getCellData(xlsxName, sheetName, 4, rowNum);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']")).click();
		JavaScriptExec.sleep();
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='change--3.quantityAsDecimal']")
	private WebElement enterQuantity;

	/**
	 * Method to Click Products tab.
	 * 
	 * @throws IOException
	 */
	public void enterQuantity(int rowNum) throws IOException {
		DiscountScenarioPage sp = new DiscountScenarioPage(driver);
		log.info("Click Products Tab");
		Assert.assertTrue(enterQuantity.isDisplayed());
		enterQuantity.clear();
		enterQuantity.sendKeys(BasePage.getCellData(xlsxName, sheetName, 7, rowNum));
	}

	@FindBy(how = How.XPATH, using = "//*[@id='ui-id-9']")
	private WebElement clickDiscountSubTab;

	/**
	 * Method to click on Discount sub tab.
	 * 
	 * @throws IOException
	 */
	public void clickDiscountSubTab() throws IOException {
		DiscountScenarioPage sp = new DiscountScenarioPage(driver);
		log.info("Click on Discount Sub Tab.");
		Assert.assertTrue(clickDiscountSubTab.isDisplayed());
		clickDiscountSubTab.click();
		JavaScriptExec.sleep();

	}
	@FindBy(how=How.XPATH, using="//select[@name='discount.0.id']")
		private WebElement selectDiscount;

		/**
		 * Method to Verify Error Message shown on selecting Discount.
		 * 
		 * @throws IOException
		 */
	public void selectDiscount(int rowNum) throws IOException {
		DiscountScenarioPage sp = new DiscountScenarioPage(driver);
		Select se = new Select(selectDiscount);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 6, rowNum));

	}

	@FindBy(how=How.XPATH, using="//*[@id='discount-messages']/ul/li")
	private WebElement verifyErrorMessage;

	/**
	 * Method to Verify Error Message shown on selecting Discount.
	 * 
	 * @throws IOException
	 */
	public void verifyErrorMessage() throws IOException {
		DiscountScenarioPage sp = new DiscountScenarioPage(driver);
		log.info("Verify Error Message shown on selecting Discount.");
		JavaScriptExec.sleep();
		String ActualErrorMsg = BasePage.getCellData(xlsxName, sheetName, 12, 0);
		String ExpectedErrorMsg = verifyErrorMessage.getText();
		Assert.assertEquals(ActualErrorMsg, ExpectedErrorMsg);
		JavaScriptExec.sleep();
	}
	@FindBy(how=How.XPATH, using="//select[@name='discountableItem.0.lineLevelDetails']")
	private WebElement selectDiscountableItem;

	/**
	 * Method to select Discountable Item.
	 * 
	 * @throws IOException
	 */
	public void selectDiscountableItem(int rowNum) throws IOException {
		DiscountScenarioPage sp = new DiscountScenarioPage(driver);
		Select se = new Select(selectDiscountableItem);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 4, rowNum));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Update']")
	private WebElement clickUpdateButton;

	/**
	 * Method to click on update button.
	 * 
	 * @throws IOException
	 */
	public void clickUpdateButton() throws IOException {
		DiscountScenarioPage sp = new DiscountScenarioPage(driver);
		log.info("click on update button.");
		Assert.assertTrue(clickUpdateButton.isDisplayed());
		clickUpdateButton.click();
		JavaScriptExec.sleep();

	}
	
	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickSaveChangesButton() throws IOException {
		DiscountScenarioPage sp = new DiscountScenarioPage(driver);
		log.info("Click on Save Changes Button");
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		clickSaveChangesButton.click();
	}

	@FindBy(how = How.XPATH, using = "//div[@class='msg-box successfully']//*[text()='Done']")
	private WebElement verifyConfirmationMsg;

	/**
	 * Method to verify Discount is created Successfully.
	 * 
	 * @throws IOException
	 */
	public void verifyConfirmationMsg() throws IOException {
		DiscountScenarioPage sp = new DiscountScenarioPage(driver);
		log.info("Verifying if Discount is created Successfully or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyConfirmationMsg.isDisplayed(),
				"Assert Failed as its unable to search text in Logged in Page");
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='total']")
	private WebElement verifyTotalAmount;

	/**
	 * Method to Verifying the order Amount is correct or not.
	 * 
	 * @throws IOException
	 */
	public void verifyTotalAmount(int colNum, int RowNum) throws IOException {
		DiscountScenarioPage sp = new DiscountScenarioPage(driver);
		log.info("Verifying the orderAmount is correct or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyTotalAmount.isDisplayed(),
				"Assert Failed as its unable to search text in Logged in Page");
		String amount = verifyTotalAmount.getText();
		String expectedAmount = amount.substring(8);
		String actualAmount = BasePage.getCellData(xlsxName, sheetName, colNum, RowNum);
		System.out.println("Print the Amount  Orders = " + expectedAmount);
		Assert.assertEquals(actualAmount, expectedAmount);
	}
	
	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}
}
