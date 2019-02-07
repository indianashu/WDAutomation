package specificPricing;

import baseClassPackage.BasePage;
import specificPricing.CreatePricingPage;
import specificPricing.CreatePricingPage;
import productDependency.CreateOrderPeriodPage;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utilPackages.JavaScriptExec;
import utilPackages.PropertyValExtractors;
import utilPackages.WaitClass;
import webDataPages.LoginPage;


public class CreatePricingPage extends BasePage {
	
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public CreatePricingPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(CreateOrderPeriodPage.class);
	CreateOrderPeriodPage configurationOrderPeriodsPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "RateCard & Pricing";
	String xlsxName = "/SpecificPricing_TestData.xlsx"; 
	
	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		LoginPage sp = new LoginPage(driver);
		log.info("Enter Login ID for logging in.");
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
		LoginPage sp = new LoginPage(driver);
		log.info("Enter Password for login");
		WaitClass.WaitForElementisDisplay(driver, 5, enterPassword);
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
		CreatePricingPage sp = new CreatePricingPage(driver);
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
		CreatePricingPage sp = new CreatePricingPage(driver);
		log.info("Click on Products Tab after successful login");
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
		CreatePricingPage sp = new CreatePricingPage(driver);
		log.info("Click on Add New");
		Assert.assertTrue(clickAddNewButton.isDisplayed());
		clickAddNewButton.click();
		JavaScriptExec.sleep();
	}
	
	
	
	@FindBy(how = How.XPATH, using = "//input[@name='pricing.name']")
	private WebElement enterPricingName;

	/**
	 * Method to enter Description.
	 * 
	 * @throws IOException
	 */
	public void enterPricingName(int i) throws IOException {
		CreatePricingPage sp = new CreatePricingPage(driver);
		log.info("Verifying the Description is available or not");
		Assert.assertTrue(enterPricingName.isDisplayed());
		enterPricingName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 5, i));
	}
	
	@FindBy(how = How.XPATH, using = "//select[@id='pricingType']")
	private WebElement enterPricingType;

	/**
	 * Method to enter Description.
	 * 
	 * @throws IOException
	 */
	public void enterPricingType() throws IOException {
		CreatePricingPage sp = new CreatePricingPage(driver);
		log.info("Verifying the Description is available or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(enterPricingType.isDisplayed());
		enterPricingType.sendKeys(BasePage.getCellData(xlsxName, sheetName, 6, 0));
	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='pricing.attribute.1.value']")
	private WebElement enterRateCard;

	/**
	 * Method to enter Description.
	 * 
	 * @throws IOException
	 */
	public void enterRateCard(int col) throws IOException {
		CreatePricingPage sp = new CreatePricingPage(driver);
		log.info("Verifying the Description is available or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(enterRateCard.isDisplayed());
		enterRateCard.click();
		enterRateCard.sendKeys(BasePage.getCellData(xlsxName, sheetName, 3, col));
	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='rateCardColumnName']")
	private WebElement enterrateCardColumn;

	/**
	 * Method to enter Description.
	 * 
	 * @throws IOException
	 */
	public void enterRateCardColumn() throws IOException {
		CreatePricingPage sp = new CreatePricingPage(driver);
		log.info("Verifying the Description is available or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(enterrateCardColumn.isDisplayed());
		enterrateCardColumn.sendKeys(BasePage.getCellData(xlsxName, sheetName, 7, 0));
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='pricingField']")
	private WebElement enterpricingFieldName;

	/**
	 * Method to enter Description.
	 * 
	 * @throws IOException
	 */
	public void enterPricingFieldName() throws IOException {
		CreatePricingPage sp = new CreatePricingPage(driver);
		log.info("Verifying the Description is available or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(enterpricingFieldName.isDisplayed());
		enterpricingFieldName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 8, 0));
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='mandatoryMatch']")
	private WebElement clickMadatoryMatch;

	/**
	 * Method to click on Add New Button.
	 * 
	 * @throws IOException
	 */
	public void clickMadatoryMatch() throws IOException {
		CreatePricingPage sp = new CreatePricingPage(driver);
		log.info("Click on Add New");
		Assert.assertTrue(clickMadatoryMatch.isDisplayed());
		clickMadatoryMatch.click();
		JavaScriptExec.sleep();
	}
	
	@FindBy(how = How.XPATH, using = "//a[@class='add_matching']")
	private WebElement clickPlusIcon;

	/**
	 * Method to click on Add New Button.
	 * 
	 * @throws IOException
	 */
	public void clickPlusIcon() throws IOException {
		CreatePricingPage sp = new CreatePricingPage(driver);
		log.info("Click on Plus Icon");
		Assert.assertTrue(clickPlusIcon.isDisplayed());
		clickPlusIcon.click();
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
		CreatePricingPage sp = new CreatePricingPage(driver);
		log.info("Click on Save Changes Button");
		JavaScriptExec.scrolltoBottomofPage(driver);
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		clickSaveChangesButton.click();
	}
	
	public void verifyPricingData(int column) throws IOException {
		String actualPricingName = BasePage.getCellData(xlsxName, sheetName, 5, column);
		String expectedPricingName = driver.findElement(By.xpath("//*[@id='column2']/div/div[2]/table/tbody/tr[2]/td[2]"))
				.getText();
		System.out.println(expectedPricingName);
		Assert.assertEquals(actualPricingName, expectedPricingName);
		
		String actualPricingType = BasePage.getCellData(xlsxName, sheetName, 6, 0);
		String expectedPricingType = driver.findElement(By.xpath("//*[@id='column2']/div/div[2]/table/tbody/tr[3]/td[2]")).getText();
		System.out.println(expectedPricingType);
		Assert.assertEquals(actualPricingType, expectedPricingType);
	}
}

