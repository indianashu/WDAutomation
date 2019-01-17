package companySetUp;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import baseClassPackage.BasePage;
import mediation.MediationPage;
import utilPackages.JavaScriptExec;
import utilPackages.PropertyValExtractors;

public class ConfigureInvoicePluginPage extends BasePage{
	
	public ConfigureInvoicePluginPage(WebDriver driver) {
		super(driver);
	}

	Logger log = Logger.getLogger(ConfigureInvoicePluginPage.class);
	ConfigureInvoicePluginPage configurationCollectionsPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "configInvoicePlugin";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		ConfigureInvoicePluginPage sp = new ConfigureInvoicePluginPage(driver);

		log.info("Verifying the Login ID is available or not");
		Assert.assertTrue(enterLoginID.isDisplayed());
		enterLoginID.sendKeys(BasePage.ExcelRead(sheetName).get(0));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='j_password']")
	private WebElement enterPassword;

	/**
	 * Method to enter Password.
	 * 
	 * @throws IOException
	 */
	public void enterPassword() throws IOException {
		ConfigureInvoicePluginPage sp = new ConfigureInvoicePluginPage(driver);
		log.info("Verifying the First Name is available or not");
		Assert.assertTrue(enterPassword.isDisplayed());
		enterPassword.sendKeys(BasePage.ExcelRead(sheetName).get(1));

	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='j_client_id']")
	private WebElement selectCompany;

	/**
	 * Method to select Comapny.
	 * 
	 * @throws IOException
	 */
	public void selectCompany() throws IOException {
		ConfigureInvoicePluginPage sp = new ConfigureInvoicePluginPage(driver);
		Select se = new Select(selectCompany);
		se.selectByVisibleText(BasePage.ExcelRead(sheetName).get(2));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']")
	private WebElement clickLoginButton;

	/**
	 * Method to Click on Login Button
	 */
	public void clickLoginButton() {
		ConfigureInvoicePluginPage sp = new ConfigureInvoicePluginPage(driver);
		log.info("Verifying the login button is available or not");
		Assert.assertTrue(clickLoginButton.isDisplayed());
		clickLoginButton.click();
	}
	
	@FindBy(how = How.XPATH, using = "//a[.='Plug-ins']")
	private WebElement clickPluginsLink;

	/**
	 * Method to click on plugins link.
	 * 
	 * @throws IOException
	 */
	public void clickPluginsLink() throws IOException {
		ConfigureInvoicePluginPage sp = new ConfigureInvoicePluginPage(driver);
		log.info("Click on plugins link");
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url2") + "/plugin/list";
		driver.get(url);
		JavaScriptExec.sleep();
	}
	
	@FindBy(how = How.XPATH, using = "//td[preceding-sibling::td[contains(.,'7')]]")
	private WebElement clickNotificationPlugin;

	/**
	 * Method to click on Notification link.
	 * 
	 * @throws IOException
	 */
	public void clickNotificationPlugin() throws IOException {
		ConfigureInvoicePluginPage sp = new ConfigureInvoicePluginPage(driver);
		log.info("click on Mediation Reader link.");
		Assert.assertTrue(clickNotificationPlugin.isDisplayed());
		clickNotificationPlugin.click();
		JavaScriptExec.sleep();
	}
	
	@FindBy(how = How.XPATH, using = "//*[text() = 'PDF invoice notification']")
	private WebElement selectPDFPlugin;

	/**
	 * Method to select PDF Notification Plugin.
	 * 
	 * @throws IOException
	 */
	public void selectPDFPlugin() throws IOException {
		ConfigureInvoicePluginPage sp = new ConfigureInvoicePluginPage(driver);
		log.info("Click on the PDF invoice Notification");
		Assert.assertTrue(selectPDFPlugin.isDisplayed());
		selectPDFPlugin.click();
		JavaScriptExec.sleep();
	}
	
	@FindBy(how = How.XPATH, using = "//a[@class='submit']//span[text()='Edit Plug-in']")
	private WebElement clickEditPlugin;

	/**
	 * Method to Click on Edit Plugin Button
	 */
	public void clickEditPlugin() {
		ConfigureInvoicePluginPage sp = new ConfigureInvoicePluginPage(driver);
		log.info("Click on the Edit plugin Button");
		Assert.assertTrue(clickEditPlugin.isDisplayed());
		clickEditPlugin.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='plg-parm-design']")
	private WebElement selectInvoice;

	/**
	 * Method to select PDF Notification Plugin.
	 * 
	 * @throws IOException
	 */
	public void selectInvoice() throws IOException {
		ConfigureInvoicePluginPage sp = new ConfigureInvoicePluginPage(driver);
		log.info("Click on the PDF invoice Notification");
		Assert.assertTrue(selectInvoice.isDisplayed());
		Select se = new Select(selectInvoice);
		se.selectByVisibleText(BasePage.ExcelRead(sheetName).get(3));
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='plgDynamic.1.name']")
	private WebElement enterSQLField;

	/**
	 * Method to enter sql_true.
	 * 
	 * @throws IOException
	 */
	public void enterSQLField() throws IOException {
		ConfigureInvoicePluginPage sp = new ConfigureInvoicePluginPage(driver);
		log.info("Added a sql field for the invoice designs");
		Assert.assertEquals(enterSQLField.getAttribute("value"), BasePage.ExcelRead(sheetName).get(4));		
	}

	@FindBy(how = How.XPATH, using = "//input[@name='plgDynamic.1.value']")
	private WebElement enterTrue;

	/**
	 * Method to enter value.
	 * 
	 * @throws IOException
	 */
	public void enterTrue() throws IOException {
		ConfigureInvoicePluginPage sp = new ConfigureInvoicePluginPage(driver);
		log.info("Enter the Value of sql value");
		Assert.assertEquals(enterTrue.getAttribute("value"), "true");	
	}
	
	@FindBy(how = How.XPATH, using = "//img[@src='/static/images/add.png']")
	private WebElement clickPlusButton;

	/**
	 * Method to Click on Edit Plugin Button
	 */
	public void clickPlusButton() {
		ConfigureInvoicePluginPage sp = new ConfigureInvoicePluginPage(driver);
		log.info("Click on the Edit plugin Button");
		Assert.assertTrue(clickPlusButton.isDisplayed());
		clickPlusButton.click();
	}
	
	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Plug-in']")
	private WebElement clickSavePluginButton;

	/**
	 * Method to click on Save Plugin Button.
	 * 
	 * @throws IOException
	 */
	public void clickSavePluginButton() throws IOException {
		ConfigureInvoicePluginPage sp = new ConfigureInvoicePluginPage(driver);
		log.info("Click on Save Plugin Button");
		JavaScriptExec.scrolltoBottomofPage(driver);
		Assert.assertTrue(clickSavePluginButton.isDisplayed());
		clickSavePluginButton.click();

	}
}
