package peakNonPeak;

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
import peakNonPeak.PricingPage;
import utilPackages.JavaScriptExec;
import utilPackages.PropertyValExtractors;

public class PricingPage extends BasePage {
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public PricingPage(WebDriver driver) {
		super(driver);
	}

	Logger log = Logger.getLogger(PricingPage.class);
	PricingPage configurationOrderPeriodsPage;
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
	 * Method to enter Description.
	 * 
	 * @throws IOException
	 */
	public void enterPricingName() throws IOException {
		PricingPage sp = new PricingPage(driver);
		log.info("Verifying the Pricing Name is available or not");
		Assert.assertTrue(enterPricingName.isDisplayed());
		enterPricingName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 3, 0));
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='pricingType']")
	private WebElement selectPricingType;

	/**
	 * Method to enter Description.
	 * 
	 * @throws IOException
	 */
	public void selectPricingType() throws IOException {
		PricingPage sp = new PricingPage(driver);
		Select se = new Select(selectPricingType);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 4, 0));
		JavaScriptExec.sleep();
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='pricing.attribute.1.value']")
	private WebElement enterPeakPrice;

	/**
	 * Method to enter Description.
	 * 
	 * @throws IOException
	 */
	public void enterPeakPrice() throws IOException {
		PricingPage sp = new PricingPage(driver);
		log.info("Verifying the Peak Price is available or not");
		Assert.assertTrue(enterPeakPrice.isDisplayed());
		enterPeakPrice.sendKeys(BasePage.getCellData(xlsxName, sheetName, 5, 0));
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='pricing.attribute.2.value']")
	private WebElement enterNonPeakPrice;

	/**
	 * Method to enter Description.
	 * 
	 * @throws IOException
	 */
	public void enterNonPeakPrice() throws IOException {
		PricingPage sp = new PricingPage(driver);
		log.info("Verifying the  Non Peak Price is available or not");
		Assert.assertTrue(enterNonPeakPrice.isDisplayed());
		enterNonPeakPrice.sendKeys(BasePage.getCellData(xlsxName, sheetName, 5, 1));
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
	
}
