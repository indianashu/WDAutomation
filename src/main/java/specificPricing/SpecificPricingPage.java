package specificPricing;

import baseClassPackage.BasePage;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utilPackages.JavaScriptExec;
import utilPackages.PropertyValExtractors;
import org.openqa.selenium.support.ui.Select;

public class SpecificPricingPage extends BasePage {
	
	public SpecificPricingPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(SpecificPricingPage.class);
	PropertyValExtractors p = new PropertyValExtractors();
	Actions actions = new Actions(driver);
	String sheetName = "Orders";
	String xlsxName = "/SpecificPricing_TestData.xlsx";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws Exception
	 */
	public void enterLoginID() throws Exception {
		SpecificPricingPage sp = new SpecificPricingPage(driver);
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
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		log.info("Verifying the First Name is available or not");
		Assert.assertTrue(enterPassword.isDisplayed());
		enterPassword.sendKeys(BasePage.getCellData(xlsxName, sheetName, 1, 0));
	}

	private WebElement selectCompany;

	/**
	 * Method to select Company.
	 * 
	 * @throws IOException
	 */
	public void selectCompany() throws Exception {
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		WebElement Companyelement = driver.findElement(By.xpath("//select[@name='j_client_id']"));
		Select se = new Select(Companyelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 2, 0));
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']")
	private WebElement clickLoginButton;

	/**
	 * Method to Click on Save Changes Button
	 */
	public void clickLoginButton() {
		SpecificPricingPage sp = new SpecificPricingPage(driver);
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
		SpecificPricingPage sp = new SpecificPricingPage(driver);
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
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		log.info("click on create order button.");
		Assert.assertTrue(clickCreateOrder.isDisplayed());
		clickCreateOrder.click();
		JavaScriptExec.sleep();
	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='period']")
	private WebElement selectPeriod;

	/**
	 * Method to Click Products tab.
	 * 
	 * @throws IOException
	 */
	public void selectPeriod() throws IOException {
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		Select se = new Select(selectPeriod);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 4, 0));
	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='billingTypeId']")
	private WebElement selectOrderType;

	/**
	 * Method to Click Products tab.
	 * 
	 * @throws IOException
	 */
	public void selectOrderType() throws IOException {
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		Select se = new Select(selectOrderType);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 5, 0));
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='ui-id-8']")
	private WebElement clickProductsSubTab;

	/**
	 * Method to Click Products tab.
	 * 
	 * @throws IOException
	 */
	public void clickProductsSubTab() throws IOException {
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		log.info("Click Products Tab");
		Assert.assertTrue(clickProductsSubTab.isDisplayed());
		clickProductsSubTab.click();
		JavaScriptExec.sleep();
	}
	
	public void selectProduct(int column) throws IOException {
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		JavaScriptExec.sleep();
		String ProductName = BasePage.getCellData(xlsxName, sheetName, 6, column);
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
		SpecificPricingPage sp = new SpecificPricingPage(driver);
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
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		log.info("Click on Save Changes Button");
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		JavaScriptExec.sleep();
		clickSaveChangesButton.click();
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='column2']/div[1]/div[6]/div/table/tbody/tr/td[5]")
	private WebElement verifyAmount;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void verifyAmount(){
		String amount= verifyAmount.getText();
				Assert.assertEquals(amount,"US$10.00");
	}
	
	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}
}
