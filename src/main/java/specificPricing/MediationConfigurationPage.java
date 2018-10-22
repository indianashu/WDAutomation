package specificPricing;

import baseClassPackage.BasePage;
import mediation.MediationPage;
import specificPricing.CreateCategoryPage;
import specificPricing.CreateCategoryPage;
import productDependency.CreateOrderPeriodPage;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utilPackages.JavaScriptExec;
import utilPackages.PropertyValExtractors;
import utilPackages.WaitClass;
import specificPricing.MediationConfigurationPage;
import org.openqa.selenium.support.ui.Select;

public class MediationConfigurationPage extends BasePage {

	/**
	 * This constructor is used to initialize the webdriver in BasePage class,
	 * if the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public MediationConfigurationPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(CreateOrderPeriodPage.class);
	CreateOrderPeriodPage configurationOrderPeriodsPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "Mediation";
	String xlsxName = "/SpecificPricing_TestData.xlsx";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		MediationConfigurationPage sp = new MediationConfigurationPage(driver);
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
		MediationConfigurationPage sp = new MediationConfigurationPage(driver);
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
		MediationConfigurationPage sp = new MediationConfigurationPage(driver);
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
		MediationConfigurationPage sp = new MediationConfigurationPage(driver);
		log.info("Verifying the login button is available or not");
		Assert.assertTrue(clickLoginButton.isDisplayed());
		clickLoginButton.click();
	}

	@FindBy(how = How.XPATH, using = "//a[@href='/jbilling/mediationConfig/list']")
	private WebElement clickMediationLink;

	/**
	 * Method to click on plugins link.
	 * 
	 * @throws IOException
	 */
	public void clickMediationLink() throws IOException {
		PluginConfigurationPage sp = new PluginConfigurationPage(driver);
		log.info("Click on Mediation link");
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url2") + "/mediationConfig/list";
		driver.get(url);
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add New']")
	private WebElement clickAddNewButton;

	/**
	 * Method to click on Add New Button".
	 * 
	 * @throws IOException
	 */
	public void clickAddNewButton() throws IOException {
		PluginConfigurationPage sp = new PluginConfigurationPage(driver);
		log.info("Click on Add New Button");
		Assert.assertTrue(clickAddNewButton.isDisplayed());
		clickAddNewButton.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='name']")
	private WebElement enterConfigurationName;

	/**
	 * Method to Enter Configuration Name.
	 * 
	 * @throws IOException
	 */
	public void enterConfigurationName() throws IOException {
		MediationPage sp = new MediationPage(driver);
		log.info("Enter Configuration Name");
		Assert.assertTrue(enterConfigurationName.isDisplayed());
		enterConfigurationName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 3, 0));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='orderValue']")
	private WebElement enterExecutionOrder;

	/**
	 * Method to Enter Execution Order.
	 * 
	 * @throws IOException
	 */
	public void enterExecutionOrder() throws IOException {
		MediationPage sp = new MediationPage(driver);
		log.info("Enter Execution Order");
		Assert.assertTrue(enterExecutionOrder.isDisplayed());
		enterExecutionOrder.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, 0));
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickSaveChangesButton() throws IOException {
		MediationPage sp = new MediationPage(driver);
		log.info("Click on Save Changes Button");
		JavaScriptExec.scrolltoBottomofPage(driver);
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		clickSaveChangesButton.click();
	}

}
