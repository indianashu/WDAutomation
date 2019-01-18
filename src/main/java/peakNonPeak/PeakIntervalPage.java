package peakNonPeak;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import baseClassPackage.BasePage;
import utilPackages.JavaScriptExec;
import utilPackages.PropertyValExtractors;

public class PeakIntervalPage extends BasePage {

	public PeakIntervalPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(PeakIntervalPage.class);
	PeakIntervalPage productCategoryPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "Pricing";
	String xlsxName = "/Peak_Non_Peak_Test_Data.xlsx";
	
	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		PeakIntervalPage sp = new PeakIntervalPage(driver);
		log.info("Verifying the Login ID is available or not");
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
		PeakIntervalPage sp = new PeakIntervalPage(driver);
		log.info("Verifying the First Name is available or not");
		Assert.assertTrue(enterPassword.isDisplayed());
		enterPassword.sendKeys(BasePage.getCellData(xlsxName, sheetName, 1, 0));
	}

	@FindBy(how = How.XPATH, using = "//select[@name='j_client_id']")
	private WebElement selectCompany;

	/**
	 * Method to select Comapny.
	 * 
	 * @throws IOException
	 */
	public void selectCompany() throws IOException {
		PeakIntervalPage sp = new PeakIntervalPage(driver);
		Select se = new Select(selectCompany);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 2, 0));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']")
	private WebElement clickLoginButton;

	/**
	 * Method to Click on Save Changes Button
	 */
	public void clickLoginButton() {
		PeakIntervalPage sp = new PeakIntervalPage(driver);
		log.info("Verifying the login button is available or not");
		Assert.assertTrue(clickLoginButton.isDisplayed());
		clickLoginButton.click();
	}

	public void getPeakIntervalPage() throws IOException {
		PeakIntervalPage sp = new PeakIntervalPage(driver);
		log.info("Click on Products Tab after successful login");
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url2") + "/peakDayTime/list";
		driver.get(url);
		JavaScriptExec.sleep();
	}
	@FindBy(how = How.XPATH, using = "//*[@id='peakDayTimeType']")
	private WebElement selectPeakInterval;

	/**
	 * Method to select PeakInterval.
	 * 
	 * @throws IOException
	 */
	public void selectPeakInterval(int rowNum) throws IOException {
		PeakIntervalPage sp = new PeakIntervalPage(driver);
		selectPeakInterval.click();
		Select se = new Select(selectPeakInterval);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 6, rowNum));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add addButton']//*[text()='Add']")
	private WebElement clickAddButton;

	/**
	 * Method to click on Add Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddButton() throws IOException {
		PeakIntervalPage sp = new PeakIntervalPage(driver);
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
		PeakIntervalPage sp = new PeakIntervalPage(driver);
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
		PeakIntervalPage sp = new PeakIntervalPage(driver);
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
		enterStartDate.sendKeys(BasePage.getCellData(xlsxName, sheetName, 7, rowNum));
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
		enterEndDate.sendKeys(BasePage.getCellData(xlsxName, sheetName, 8, rowNum));
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
		PeakIntervalPage sp = new PeakIntervalPage(driver);
		Select se = new Select(selectDayofWeek);
		se.selectByVisibleText("MONDAY");
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//*[@class='submit save']//*[text()='Save Changes']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickSaveChangesButton() throws IOException {
		PeakIntervalPage sp = new PeakIntervalPage(driver);
		log.info("Click on Save Changes Button");
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		clickSaveChangesButton.click();
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
	
	@FindBy(how = How.XPATH, using = "//input[@id='peakDayTime.descriptions[0].content']")
	private WebElement enterDescription;

	/**
	 * Method to End Date.
	 * 
	 * @throws IOException
	 */
	public void enterDescription() throws IOException {
		Assert.assertTrue(enterDescription.isDisplayed());
		enterDescription.sendKeys("Work Anniversary");
		JavaScriptExec.sleep();
	}
	
	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();

	}

}
