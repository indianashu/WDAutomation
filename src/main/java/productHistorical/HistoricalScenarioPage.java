package productHistorical;

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

public class HistoricalScenarioPage extends BasePage {

	public HistoricalScenarioPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(HistoricalScenarioPage.class);

	PropertyValExtractors p = new PropertyValExtractors();
	Actions actions = new Actions(driver);
	String sheetName = "CreateOrder";
	String xlsxName = "/ProductHistorical_TestData.xlsx";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws Exception
	 */
	public void enterLoginID() throws Exception {
		HistoricalScenarioPage sp = new HistoricalScenarioPage(driver);

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
		HistoricalScenarioPage sp = new HistoricalScenarioPage(driver);
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
		HistoricalScenarioPage sp = new HistoricalScenarioPage(driver);
		Select se = new Select(selectCompany);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 2, 0));
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']")
	private WebElement clickLoginButton;

	/**
	 * Method to Click on Save Changes Button
	 */
	public void clickLoginButton() {
		HistoricalScenarioPage sp = new HistoricalScenarioPage(driver);
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

	/**
	 * Method to select customer.
	 * 
	 * @throws IOException
	 */
	public void selectCustomer(int colNum) throws IOException {
		HistoricalScenarioPage sp = new HistoricalScenarioPage(driver);
		JavaScriptExec.sleep();
		String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, colNum);
		WebElement selectCustomer = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']"));
		navigateBottom();
		actions.moveToElement(selectCustomer).click().perform();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit order']//*[text()='Create Order']")
	private WebElement clickCreateOrder;

	/**
	 * Method to click on Create order Button.
	 * 
	 * @throws IOException
	 */
	public void clickCreateOrder() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.scrollToElementOnPage(driver, clickCreateOrder);
		Assert.assertTrue(clickCreateOrder.isDisplayed());
		clickCreateOrder.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='activeSince']")
	private WebElement activeSince;

	/**
	 * Method to click on Fill the active since Date.
	 * 
	 * @throws IOException
	 */
	public void activeSince(int colNum) throws IOException {
		HistoricalScenarioPage sp = new HistoricalScenarioPage(driver);
		activeSince.clear();
		activeSince.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, colNum));
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='ui-id-8']")
	private WebElement clickProductSubTab;

	/**
	 * Method to click on Product Sub Tab.
	 * 
	 * @throws IOException
	 */
	public void clickProductSubTab() {
		Assert.assertTrue(clickProductSubTab.isDisplayed());
		actions.moveToElement(clickProductSubTab).click().perform();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//select[@name='typeId']")
	private WebElement selectCategory;

	/**
	 * Method to Select the Category Name From the ItemType Filter.
	 * 
	 * @throws IOException
	 */
	public void selectCategory() throws IOException {
		Assert.assertTrue(selectCategory.isDisplayed());
		Select select = new Select(selectCategory);
		select.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 5, 0));
	}

	public void selectProduct(int colNum) throws IOException {
		String ProductName1 = BasePage.getCellData(xlsxName, sheetName, 6, colNum);
		JavaScriptExec.sleep();
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName1 + "']")).click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='change--3.appliedManually']")
	private WebElement checkApplyNow;

	/**
	 * Method to Check ApplyNow CheckBox.
	 * 
	 * @throws IOException
	 */
	public void checkApplyNow() throws IOException {
		log.info("Check ApplyNow Checkbox.");
		Assert.assertTrue(checkApplyNow.isDisplayed());
		if (!checkApplyNow.isSelected()) {
			checkApplyNow.click();
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='change--3-update-form']/div[2]/a[1]")
	private WebElement clickUpdateButton1;

	/**
	 * Method to click on update button.
	 * 
	 * @throws IOException
	 */
	public void clickUpdateButton1() throws IOException {
		log.info("click on update button.");
		Assert.assertTrue(clickUpdateButton1.isDisplayed());
		clickUpdateButton1.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='change--5.appliedManually']")
	private WebElement checkApplyNow2;

	/**
	 * Method to Check ApplyNow CheckBox.
	 * 
	 * @throws IOException
	 */
	public void checkApplyNow2() throws IOException {
		log.info("Check ApplyNow Checkbox.");
		Assert.assertTrue(checkApplyNow2.isDisplayed());
		if (!checkApplyNow2.isSelected()) {
			checkApplyNow2.click();
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='change--5-update-form']/div[2]/a[1]")
	private WebElement clickUpdateButton2;

	/**
	 * Method to click on update button.
	 * 
	 * @throws IOException
	 */
	public void clickUpdateButton2() throws IOException {
		log.info("click on update button.");
		Assert.assertTrue(clickUpdateButton2.isDisplayed());
		clickUpdateButton2.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//*[@class='fa fa-plus-square']")
	private WebElement clickImpersonate;

	/**
	 * Method to Click on Impersonate Link
	 */
	public void clickImpersonate() {
		HistoricalScenarioPage sp = new HistoricalScenarioPage(driver);
		log.info("Click on Impersonate Link");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickImpersonate.isDisplayed());
		clickImpersonate.click();
	}

	@FindBy(how = How.XPATH, using = "//select[@name='entityId']")
	private WebElement selectChildCompany;

	/**
	 * Method to select Child Company.
	 * 
	 * @throws IOException
	 */
	public void selectChildCompany() throws IOException {
		HistoricalScenarioPage sp = new HistoricalScenarioPage(driver);
		JavaScriptExec.sleep();
		Select se = new Select(selectChildCompany);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 2, 1));

	}

	@FindBy(how = How.XPATH, using = "//*[text()='OK']")
	private WebElement clickOKButton;

	/**
	 * Method to Click on Select Button
	 */
	public void clickOKButton() {
		HistoricalScenarioPage sp = new HistoricalScenarioPage(driver);
		log.info("Click on Select Button");
		Assert.assertTrue(clickOKButton.isDisplayed());
		clickOKButton.click();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='change--7.appliedManually']")
	private WebElement checkApplyNow3;

	/**
	 * Method to Check ApplyNow CheckBox.
	 * 
	 * @throws IOException
	 */
	public void checkApplyNow3() throws IOException {
		log.info("Check ApplyNow Checkbox.");
		Assert.assertTrue(checkApplyNow3.isDisplayed());
		if (!checkApplyNow3.isSelected()) {
			checkApplyNow3.click();
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='change--7-update-form']/div[2]/a[1]")
	private WebElement clickUpdateButton;

	/**
	 * Method to click on update button.
	 * 
	 * @throws IOException
	 */
	public void clickUpdateButton() throws IOException {
		log.info("click on update button.");
		Assert.assertTrue(clickUpdateButton.isDisplayed());
		clickUpdateButton.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='review-box']/div[3]")
	private WebElement amount;

	/**
	 * Method to Verify Amount of the product.
	 * 
	 * @throws IOException
	 */
	public void expectedAmount(int rowNum, int colNum) throws IOException {
		String expectedAmount = BasePage.getCellData(xlsxName, sheetName, rowNum, colNum);
		String actualAmount = amount.getText();
		Assert.assertEquals(actualAmount, expectedAmount);
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
	private WebElement clickSaveChanges;

	/**
	 * Method to click on update button.
	 * 
	 * @throws IOException
	 */
	public void clickSaveChanges() {
		Assert.assertTrue(clickSaveChanges.isDisplayed());
		actions.moveToElement(clickSaveChanges).click().perform();
	}

	public void addCompanyFilter() throws IOException {
		WebElement addFilter = driver.findElement(By.xpath("//a[@class='submit add open']"));
		addFilter.click();
		navigateBottom();
		String CompanyName = BasePage.getCellData(xlsxName, sheetName, 2, 0);
		WebElement selectCompany = driver.findElement(By.xpath("//*[@id='filters']/div[2]/div[1]/div/ul/li[3]/a"));
		selectCompany.click();
		JavaScriptExec.sleep();
		WebElement company = driver
				.findElement(By.xpath("//select[@name='filters.CUSTOMER-EQ_U_company_id.integerValue']"));
		Select se = new Select(company);
		se.selectByVisibleText(CompanyName);
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='filters.CUSTOMER-LIKE_UserName.stringValue']")
	private WebElement enterCustomerNameFilter;

	/**
	 * Method to enter the customer name in the Login name Filter.
	 * 
	 * @throws IOException
	 */
	public void enterCustomerNameFilter(int colNum) throws IOException {
		log.info("Enter the name of the Customer in the Filte Login name");
		Assert.assertTrue(enterCustomerNameFilter.isDisplayed());
		enterCustomerNameFilter.clear();
		enterCustomerNameFilter.sendKeys(BasePage.getCellData(xlsxName, sheetName, 3, colNum));
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
		log.info("Click on Apply Filter");
		Assert.assertTrue(applyFilter.isDisplayed());
		applyFilter.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//span[@class='right-text']//a")
	private WebElement clickRedCross;

	/**
	 * Method to click on Red Cross
	 * 
	 * @throws IOException
	 */
	public void clickRedCross() throws IOException {
		log.info("Click on Red Cross");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickRedCross.isDisplayed());
		clickRedCross.click();

	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}
}
