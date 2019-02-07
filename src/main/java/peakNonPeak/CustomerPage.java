package peakNonPeak;

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

public class CustomerPage extends BasePage{
	public CustomerPage(WebDriver driver) {
		super(driver);
	}

	Logger log = Logger.getLogger(CustomerPage.class);

	PropertyValExtractors p = new PropertyValExtractors();
	Actions actions = new Actions(driver);
	String sheetName = "Customer";
	String xlsxName = "/Peak_Non_Peak_Test_Data.xlsx";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws Exception
	 */
	public void enterLoginID() throws Exception {
		CustomerPage sp = new CustomerPage(driver);

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
		CustomerPage sp = new CustomerPage(driver);
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
		CustomerPage sp = new CustomerPage(driver);
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
		CustomerPage sp = new CustomerPage(driver);
		log.info("Verifying the login button is available or not");
		Assert.assertTrue(clickLoginButton.isDisplayed());
		clickLoginButton.click();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu.link.customers']/a")
	private WebElement clickCustomerTab;

	/**
	 * Method to click on Products tab after successful login.
	 * 
	 * @throws IOException
	 */
	public void clickCustomerTab() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		log.info("Click on Products Tab after successful login");
		Assert.assertTrue(clickCustomerTab.isDisplayed());
		clickCustomerTab.click();
		JavaScriptExec.sleep();

	}
	
	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add New']")
	private WebElement clickAddNewButton;

	/**
	 * Method to click on Products tab after successful login.
	 * 
	 * @throws IOException
	 */
	public void clickAddNewButton() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		log.info("Click on Products Tab after successful login");
		Assert.assertTrue(clickAddNewButton.isDisplayed());
		clickAddNewButton.click();
		JavaScriptExec.sleep();

	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='accountTypeId']")
	private WebElement selectAccountType;

	/**
	 * Method to click on Products tab after successful login.
	 * 
	 * @throws IOException
	 */
	public void selectAccountType() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		log.info("Click on Products Tab after successful login");
		Assert.assertTrue(selectAccountType.isDisplayed());
		Select sel = new Select(selectAccountType);
		sel.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 3, 0));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Select']")
	private WebElement clickSelectButton;

	/**
	 * Method to click on Products tab after successful login.
	 * 
	 * @throws IOException
	 */
	public void clickSelectButton() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		log.info("Click on Products Tab after successful login");
		Assert.assertTrue(clickSelectButton.isDisplayed());
		clickSelectButton.click();
		JavaScriptExec.sleep();

	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='user.userName']")
	private WebElement enterCustomerName;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws Exception
	 */
	public void enterCustomerName(int rowNum) throws Exception {
		CustomerPage sp = new CustomerPage(driver);
		log.info("Verifying the Login ID is available or not");
		Assert.assertTrue(enterCustomerName.isDisplayed());
		enterCustomerName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 3, rowNum));
	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='user.currencyId']")
	private WebElement selectCurrency;

	/**
	 * Method to click on Products tab after successful login.
	 * 
	 * @throws IOException
	 */
	public void selectCurrency() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		log.info("Click on Products Tab after successful login");
		Assert.assertTrue(selectCurrency.isDisplayed());
		Select sel = new Select(selectCurrency);
		sel.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 5, 0));
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

	@FindBy(how = How.XPATH, using = "//*[@id='peakDayTimeType']")
	private WebElement selectPeakInterval;

	/**
	 * Method to select PeakInterval.
	 * 
	 * @throws IOException
	 */
	public void selectPeakInterval(int rowNum) throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		selectPeakInterval.click();
		Select se = new Select(selectPeakInterval);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 4, rowNum));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add addButton']//*[text()='Add']")
	private WebElement clickAddButton;

	/**
	 * Method to click on Add Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddButton() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		log.info("Click on Add  Button");
		Assert.assertTrue(clickAddButton.isDisplayed());
		clickAddButton.click();
	}

	@FindBy(how = How.XPATH, using = "//select[@name='peakDayTime[0].recurring']")
	private WebElement selectisRecurring;

	/**
	 * Method to select PeakInterval.
	 * 
	 * @throws IOException
	 */
	public void selectisRecurring() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		selectisRecurring.click();
		Select se = new Select(selectisRecurring);
		se.selectByVisibleText("TRUE");

	}

	@FindBy(how = How.XPATH, using = "//*[@id='isPeak']")
	private WebElement checkIsPeak;

	/**
	 * Method to Check United States Dollar Currency CheckBox.
	 * 
	 * @throws IOException
	 */
	public void checkIsPeak() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		log.info("Check Is Peak Checkbox.");
		Assert.assertTrue(checkIsPeak.isDisplayed());
		if (!checkIsPeak.isSelected()) {
			checkIsPeak.click();
		}

	}

	@FindBy(how = How.XPATH, using = "//input[@name='peakDayTime[0].startDate']")
	private WebElement enterStartDate;

	/**
	 * Method to enter start date.
	 * 
	 * @throws IOException
	 */
	public void enterStartDate(int rowNum) throws IOException {
		Assert.assertTrue(enterStartDate.isDisplayed());
		enterStartDate.clear();
		enterStartDate.sendKeys(BasePage.getCellData(xlsxName, sheetName, 6, rowNum));
		JavaScriptExec.mouseclick(driver);
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='peakDayTime[0].endDate']")
	private WebElement enterEndDate;

	/**
	 * Method to End Date.
	 * 
	 * @throws IOException
	 */
	public void enterEndDate(int rowNum) throws IOException {
		Assert.assertTrue(enterEndDate.isDisplayed());
		enterEndDate.clear();
		enterEndDate.sendKeys(BasePage.getCellData(xlsxName, sheetName, 7, rowNum));
		JavaScriptExec.mouseclick(driver);
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//select[@name='peakDayTime[0].dayOfWeek']")
	private WebElement selectDayofWeek;

	/**
	 * Method to select PeakInterval.
	 * 
	 * @throws IOException
	 */
	public void selectDayofWeek() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		selectDayofWeek.click();
		Select se = new Select(selectDayofWeek);
		se.selectByVisibleText("MONDAY");

	}

	@FindBy(how = How.XPATH, using = "//button[@id='savePeak']")
	private WebElement clickSavePeakButton;

	/**
	 * Method to click on Add Button.
	 * 
	 * @throws IOException
	 */
	public void clickSavePeakButton() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		log.info("Click on Add  Button");
		Assert.assertTrue(clickSavePeakButton.isDisplayed());
		clickSavePeakButton.click();
	}
	@FindBy(how = How.XPATH, using = "//input[@name='peakDayTime[0].startTime']")
	private WebElement enterStartTime;

	/**
	 * Method to enter start date.
	 * 
	 * @throws IOException
	 */
	public void enterStartTime() throws IOException {
		Assert.assertTrue(enterStartDate.isDisplayed());
		enterStartTime.clear();
		enterStartTime.sendKeys("09:00");
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='peakDayTime[0].endTime']")
	private WebElement enterEndTime;

	/**
	 * Method to End Date.
	 * 
	 * @throws IOException
	 */
	public void enterEndTime() throws IOException {
		Assert.assertTrue(enterEndDate.isDisplayed());
		enterEndTime.clear();
		enterEndTime.sendKeys("18:00");
		JavaScriptExec.sleep();
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='filters.CUSTOMER-LIKE_UserName.stringValue']")
	private WebElement enterCustomerNameFilter;

	/**
	 * Method to enter the customer name in the Login name Filter.
	 * 
	 * @throws IOException
	 */
	public void enterCustomerNameFilter(int column) throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		log.info("Enter the name of the Customer in the Filte Login name");
		Assert.assertTrue(enterCustomerNameFilter.isDisplayed());
		enterCustomerNameFilter.clear();
		enterCustomerNameFilter.sendKeys(BasePage.getCellData(xlsxName, sheetName, 3, column));
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
		CustomerPage sp = new CustomerPage(driver);
		log.info("Click on Apply Filter");
		Assert.assertTrue(applyFilter.isDisplayed());
		applyFilter.click();
		JavaScriptExec.sleep();
	}
	
	public void selectCustomer(int rowNum) throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, rowNum);
		WebElement selectCustomer = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']"));
		actions.moveToElement(selectCustomer).click().perform();
		JavaScriptExec.sleep();
	}
	@FindBy(how = How.XPATH, using = "//img[@alt='inspect customer']")
	private WebElement clickCustomerInspectIcon;
	
	/**
	 * Method to click on Mediations Tab.
	 * 
	 * @throws IOException
	 */
	public void clickCustomerInspectIcon() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		log.info("click on Mediations Tabs");
		Assert.assertTrue(clickCustomerInspectIcon.isDisplayed());
		clickCustomerInspectIcon.click();
		JavaScriptExec.sleep();
	}
	
	@FindBy(how = How.XPATH, using = "//a[@class='btn-open']")
	private WebElement clickActiveSpecialPlusButton;
	
	/**
	 * Method to click on Mediations Tab.
	 * 
	 * @throws IOException
	 */
	public void clickActiveSpecialPlusButton() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		log.info("click on Mediations Tabs");
		Assert.assertTrue(clickActiveSpecialPlusButton.isDisplayed());
		clickActiveSpecialPlusButton.click();
		navigateBottom();
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='peakDayTime.descriptions[0].content']")
	private WebElement enterDescription;

	/**
	 * Method to End Date.
	 * 
	 * @throws IOException
	 */
	public void enterDescription(String content) throws IOException {
		Assert.assertTrue(enterDescription.isDisplayed());
		enterDescription.sendKeys(content);
		JavaScriptExec.sleep();
	}
	
	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add a Special Day']")
	private WebElement clickAddSpecialButton;

	/**
	 * Method to click on Add a Special Day Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddSpecialButton() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		log.info("Click on Add a Special Day Button");
		Assert.assertTrue(clickAddSpecialButton.isDisplayed());
		clickAddSpecialButton.click();
	}
	
	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}
}
