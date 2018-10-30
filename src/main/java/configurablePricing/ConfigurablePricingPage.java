package configurablePricing;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import baseClassPackage.BasePage;
import utilPackages.JavaScriptExec;
import utilPackages.PropertyValExtractors;

public class ConfigurablePricingPage extends BasePage {

	public ConfigurablePricingPage(WebDriver driver) {
		super(driver);
	}

	Logger log = Logger.getLogger(ConfigurablePricingPage.class);
	PropertyValExtractors p = new PropertyValExtractors();
	Actions actions = new Actions(driver);
	String sheetName = "Order";
	String xlsxName = "/ConfigurablePricing_TestData.xlsx";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws Exception
	 */
	public void enterLoginID() throws Exception {
		ConfigurablePricingPage sp = new ConfigurablePricingPage(driver);
		log.info("Verifying the Login ID is available or not");
		Assert.assertTrue(enterLoginID.isDisplayed());
		enterLoginID.sendKeys(BasePage.getCellData(xlsxName, sheetName, 0, 0));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='j_password']")
	private WebElement enterPassword;

	/**
	 * Method to enter Password.
	 * 
	 * @throws Exception
	 */
	public void enterPassword() throws Exception {
		ConfigurablePricingPage sp = new ConfigurablePricingPage(driver);
		log.info("Verifying the First Name is available or not");
		Assert.assertTrue(enterPassword.isDisplayed());
		enterPassword.sendKeys(BasePage.getCellData(xlsxName, sheetName, 1, 0));
	}

	@FindBy(how = How.XPATH, using = "//select[@name='j_client_id']")
	private WebElement selectCompany;

	/**
	 * Method to select Company.
	 * 
	 * @throws IOException
	 */
	public void selectCompany() throws Exception {
		ConfigurablePricingPage sp = new ConfigurablePricingPage(driver);
		Select se = new Select(selectCompany);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 2, 0));
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']")
	private WebElement clickLoginButton;

	/**
	 * Method to Click on Save Changes Button
	 */
	public void clickLoginButton() {
		ConfigurablePricingPage sp = new ConfigurablePricingPage(driver);
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
		log.info("Click on Products Tab after successful login");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickCustomerTab.isDisplayed());
		clickCustomerTab.click();
	}

	public void selectCustomer(int column) throws IOException {
		ConfigurablePricingPage sp = new ConfigurablePricingPage(driver);
		String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, column);
		WebElement selectCustomer = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']"));
		navigateBottom();
		actions.moveToElement(selectCustomer).click().perform();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit order']//*[text()='Create Order']")
	private WebElement clickCreateOrder;

	/**
	 * Method to click on create order button.
	 * 
	 * @throws IOException
	 */
	public void clickCreateOrder() throws IOException {
		JavaScriptExec.scrollToElementOnPage(driver, clickCreateOrder);
		ConfigurablePricingPage sp = new ConfigurablePricingPage(driver);
		log.info("click on create order button.");
		Assert.assertTrue(clickCreateOrder.isDisplayed());
		clickCreateOrder.click();
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
		ConfigurablePricingPage sp = new ConfigurablePricingPage(driver);
		log.info("Click Products Tab");
		Assert.assertTrue(enterQuantity.isDisplayed());
		enterQuantity.clear();
		enterQuantity.sendKeys(BasePage.getCellData(xlsxName, sheetName, 5, rowNum));
	}

	@FindBy(how = How.XPATH, using = "//*[@id='ui-id-8']")
	private WebElement clickProductsSubTab;

	/**
	 * Method to Click Products tab.
	 * 
	 * @throws IOException
	 */
	public void clickProductsSubTab() throws IOException {
		ConfigurablePricingPage sp = new ConfigurablePricingPage(driver);
		log.info("Click Products Tab");
		Assert.assertTrue(clickProductsSubTab.isDisplayed());
		clickProductsSubTab.click();
		JavaScriptExec.sleep();
	}

	public void selectProduct(int column) throws IOException {
		ConfigurablePricingPage sp = new ConfigurablePricingPage(driver);
		JavaScriptExec.sleep();
		String ProductName = BasePage.getCellData(xlsxName, sheetName, 4, column);
		WebElement selectProduct = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']"));
		actions.moveToElement(selectProduct).click().perform();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Update']")
	private WebElement clickUpdateButton;

	/**
	 * Method to click on Update button.
	 * 
	 * @throws IOException
	 */
	public void clickUpdateButton() throws IOException {
		ConfigurablePricingPage sp = new ConfigurablePricingPage(driver);
		log.info("click on Update button.");
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
		ConfigurablePricingPage sp = new ConfigurablePricingPage(driver);
		log.info("Click on Save Changes Button");
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		JavaScriptExec.sleep();
		clickSaveChangesButton.click();
	}

	@FindBy(how = How.XPATH, using = "//div[@class='msg-box successfully']//*[text()='Done']")
	private WebElement verifyConfirmationMsg;

	/**
	 * Method to verify Pricing is created Successfully.
	 * 
	 * @throws IOException
	 */
	public void verifyConfirmationMsg() throws IOException {
		ConfigurablePricingPage sp = new ConfigurablePricingPage(driver);
		log.info("Verifying if Pricing is created Successfully or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyConfirmationMsg.isDisplayed(),
				"Assert Failed as its unable to search text in Logged in Page");
	}

	@FindBy(how = How.XPATH, using = "//div[@class='total']")
	private WebElement verifyTotalTieredAmount;

	/**
	 * Method to Verifying the orderAmount is correct or not.
	 * 
	 * @throws IOException
	 */
	public void verifyTotalTieredAmount(int RowNum) throws IOException {
		ConfigurablePricingPage sp = new ConfigurablePricingPage(driver);
		log.info("Verifying the orderAmount is correct or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyTotalTieredAmount.isDisplayed(),
				"Assert Failed as its unable to search text in Logged in Page");
		String amount = verifyTotalTieredAmount.getText();
		String expectedAmount = amount.substring(8);
		String actualAmount = BasePage.getCellData(xlsxName, sheetName, 6, RowNum);
		System.out.println("Print the Amount of tiered Order" + expectedAmount);
		Assert.assertEquals(actualAmount, expectedAmount);
	}

	@FindBy(how = How.XPATH, using = "//div[@class='total']")
	private WebElement verifyTotalVolumeAmount;

	/**
	 * Method to Verifying the orderAmount is correct or not.
	 * 
	 * @throws IOException
	 */
	public void verifyTotalVolumeAmount(int RowNum) throws IOException {
		ConfigurablePricingPage sp = new ConfigurablePricingPage(driver);
		log.info("Verifying the orderAmount is correct or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyTotalVolumeAmount.isDisplayed(),
				"Assert Failed as its unable to search text in Logged in Page");
		String amount = verifyTotalVolumeAmount.getText();
		String expectedAmount = amount.substring(8);
		String actualAmount = BasePage.getCellData(xlsxName, sheetName, 7, RowNum);
		System.out.println("Print the Amount of Volume Order" + expectedAmount);
		Assert.assertEquals(actualAmount, expectedAmount);
	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}
}
