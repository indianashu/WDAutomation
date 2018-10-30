package configurablePricing;

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
import configurablePricing.PricingPage;
import productDependency.CreateOrderPage;
import utilPackages.JavaScriptExec;
import utilPackages.PropertyValExtractors;
import utilPackages.WaitClass;

public class PricingPage extends BasePage {
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public PricingPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(PricingPage.class);
	PricingPage configurationOrderPeriodsPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "Pricing";
	String xlsxName = "/ConfigurablePricing_TestData.xlsx";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		PricingPage sp = new PricingPage(driver);

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
		PricingPage sp = new PricingPage(driver);
		log.info("Verifying the First Name is available or not");
		Assert.assertTrue(enterPassword.isDisplayed());
		enterPassword.sendKeys(BasePage.getCellData(xlsxName, sheetName, 1, 0));

	}

	private WebElement selectCompany;

	/**
	 * Method to select Comapny.
	 * 
	 * @throws IOException
	 */
	public void selectCompany() throws IOException {
		PricingPage sp = new PricingPage(driver);
		WebElement Companyelement = driver.findElement(By.xpath("//select[@name='j_client_id']"));
		Select se = new Select(Companyelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 2, 0));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']")
	private WebElement clickLoginButton;

	/**
	 * Method to Click on Login Button
	 */
	public void clickLoginButton() {
		PricingPage sp = new PricingPage(driver);
		log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
		Assert.assertTrue(clickLoginButton.isDisplayed());
		clickLoginButton.click();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu.link.pricing']/a")
	private WebElement clickPricingTab;

	/**
	 * Method to click on Products tab after successful login.
	 * 
	 * @throws IOException
	 */
	public void clickPricingTab() throws IOException {
		PricingPage sp = new PricingPage(driver);
		log.info("Click on Pricing Tab after successful login");
		Assert.assertTrue(clickPricingTab.isDisplayed());
		clickPricingTab.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add New']")
	private WebElement clickAddNewButton;

	/**
	 * Method to click on Add New Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddNewButton() throws IOException {
		PricingPage sp = new PricingPage(driver);
		log.info("Click on Add New");
		Assert.assertTrue(clickAddNewButton.isDisplayed());
		clickAddNewButton.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='pricing.name']")
	private WebElement enterPricingName;

	/**
	 * Method to enter Password.
	 * 
	 * @throws IOException
	 */
	public void enterPricingName(int rowNum) throws IOException {
		PricingPage sp = new PricingPage(driver);
		log.info("Verifying the Pricing Name is available or not");
		Assert.assertTrue(enterPricingName.isDisplayed());
		enterPricingName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 3, rowNum));

	}

	@FindBy(how = How.XPATH, using = "//input[@id='pricing.attribute.2.value' and contains(@value, 'TIER')]")
	private WebElement selectTierRadioButton;

	/**
	 * Method to click on Add New Button.
	 * 
	 * @throws IOException
	 */
	public void selectTierRadioButton() throws IOException {
		PricingPage sp = new PricingPage(driver);
		log.info("Click on Tier Radio Button");
		Assert.assertTrue(selectTierRadioButton.isDisplayed());
		selectTierRadioButton.click();
		JavaScriptExec.sleep();
	}

	public void fillTierData() throws IOException {
		for (int i = 0; i < 6; i++) {

			PricingPage sp = new PricingPage(driver);
			WebElement endTier = driver.findElement(By.xpath("//*[@id='discount_usage." + i + ".usageEnd']"));
			endTier.sendKeys(BasePage.getCellData(xlsxName, sheetName, 5, i));

			WebElement enterRate = driver.findElement(By.xpath("//*[@id='discount_usage." + i + ".rate']"));
			enterRate.sendKeys(BasePage.getCellData(xlsxName, sheetName, 6, i));

			WebElement clickOnPlus = driver.findElement(By.xpath("//*[@id='add." + i + "']/img"));
			clickOnPlus.click();
		}
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickSaveChangesButton() throws IOException {
		PricingPage sp = new PricingPage(driver);
		log.info("Click on Save Changes Button");
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
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
		PricingPage sp = new PricingPage(driver);
		log.info("Verifying if Pricing is created Successfully or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyConfirmationMsg.isDisplayed(),
				"Assert Failed as its unable to search text in Logged in Page");
	}

	public void verifyPricingName(int rowNum) throws IOException {
		String actualPricingName = BasePage.getCellData(xlsxName, sheetName, 5, rowNum);
		String expectedPricingName = driver
				.findElement(By.xpath("//*[@id='column2']/div/div[2]/table/tbody/tr[2]/td[2]")).getText();
		System.out.println(expectedPricingName);
		Assert.assertEquals(actualPricingName, expectedPricingName);
	}

	public void selectPricing() throws IOException {
		PricingPage sp = new PricingPage(driver);
		String pricingName = BasePage.getCellData(xlsxName, sheetName, 3, 0);
		WebElement selectPricing = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + pricingName + "']"));
		navigateBottom();
		selectPricing.click();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit edit']//*[text()='Edit']")
	private WebElement clickEditButton;

	/**
	 * Method to click on Edit Button.
	 * 
	 * @throws IOException
	 */
	public void clickEditButton() throws IOException {
		PricingPage sp = new PricingPage(driver);
		log.info("Click on Edit Button");
		Assert.assertTrue(clickDeleteButton.isDisplayed());
		clickDeleteButton.click();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='pricing.name']")
	private WebElement editPricingName;

	/**
	 * Method to enter Password.
	 * 
	 * @throws IOException
	 */
	public void editPricingName() throws IOException {
		PricingPage sp = new PricingPage(driver);
		log.info("Verifying the Pricing Name is available or not");
		Assert.assertTrue(editPricingName.isDisplayed());
		editPricingName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 7, 0));
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit delete']//*[text()='Delete']")
	private WebElement clickDeleteButton;

	/**
	 * Method to click on Edit Button.
	 * 
	 * @throws IOException
	 */
	public void clickDeleteButton() throws IOException {
		PricingPage sp = new PricingPage(driver);
		log.info("Click on Delete Button");
		Assert.assertTrue(clickDeleteButton.isDisplayed());
		clickDeleteButton.click();
	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}
}
