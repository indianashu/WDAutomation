package specificPricing;

import baseClassPackage.BasePage;
import mediation.MediationPage;
import specificPricing.PluginConfigurationPage;
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
import utilPackages.WaitClass;
import org.openqa.selenium.support.ui.Select;

public class PluginConfigurationPage extends BasePage {
	
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public PluginConfigurationPage(WebDriver webdriver) {
		super(webdriver);
	}
	Logger log = Logger.getLogger(PluginConfigurationPage.class);
	PluginConfigurationPage pluginPage;
	PropertyValExtractors p = new PropertyValExtractors();
	Actions actions = new Actions(driver);
	String sheetName = "ConfigurePlugIn";
	String xlsxName = "/SpecificPricing_TestData.xlsx";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		PluginConfigurationPage sp = new PluginConfigurationPage(driver);
		log.info("Verifying the Login ID is available or not");
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
		PluginConfigurationPage sp = new PluginConfigurationPage(driver);
		log.info("Verifying the First Name is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, enterPassword);
		Assert.assertTrue(enterPassword.isDisplayed());
		enterPassword.sendKeys(BasePage.getCellData(xlsxName, sheetName, 1, 0));
	}

	private WebElement selectCompany;

	/**
	 * Method to select Company.
	 * 
	 * @throws IOException
	 */
	public void selectCompany() throws IOException {
		PluginConfigurationPage sp = new PluginConfigurationPage(driver);
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
		PluginConfigurationPage sp = new PluginConfigurationPage(driver);
		log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
		Assert.assertTrue(clickLoginButton.isDisplayed());
		clickLoginButton.click();
	}
	@FindBy(how = How.XPATH, using = "//a[.='Configuration']")
	private WebElement clickConfigurationsTab;

	/**
	 * Method to click on Configurations tab after successful login.
	 * 
	 * @throws IOException
	 */
	public void clickConfigurationsTab() throws IOException {
		PluginConfigurationPage sp = new PluginConfigurationPage(driver);
		log.info("Click on Configurations Tab after successful login");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickConfigurationsTab.isDisplayed());
		clickConfigurationsTab.click();
	}

	@FindBy(how = How.XPATH, using = "//a[.='Plug-ins']")
	private WebElement clickPluginsLink;

	/**
	 * Method to click on plugins link.
	 * 
	 * @throws IOException
	 */
	public void clickPluginsLink() throws IOException {
		PluginConfigurationPage sp = new PluginConfigurationPage(driver);
		log.info("Click on plugins link");
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url2") + "/plugin/list";
		driver.get(url);
		JavaScriptExec.sleep();
	}
	
	@FindBy(how = How.XPATH, using = "//a[.='File Format']")
	private WebElement clickFileFormatLink;

	/**
	 * Method to click on File Format link.
	 * 
	 * @throws IOException
	 */
	public void clickFileFormatLink() throws IOException {
		PluginConfigurationPage sp = new PluginConfigurationPage(driver);
		log.info("Click on File Format link");
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url2") + "/fileFormats/index";
		driver.get(url);
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//td[preceding-sibling::td[contains(.,'15')]]")
	private WebElement clickMediationReader;

	/**
	 * Method to click on Mediation Reader link.
	 * 
	 * @throws IOException
	 */
	public void clickMediationReader() throws IOException {
		PluginConfigurationPage sp = new PluginConfigurationPage(driver);
		log.info("click on Mediation Reader link.");
		Assert.assertTrue(clickMediationReader.isDisplayed());
		clickMediationReader.click();
		JavaScriptExec.sleep();
	}
	
	@FindBy(how = How.XPATH, using = "//td[preceding-sibling::td[contains(.,'16')]]")
	private WebElement clickMediationProcessor;

	/**
	 * Method to click on Mediation Processor link.
	 * 
	 * @throws IOException
	 */
	public void clickMediationProcessor() throws IOException {
		MediationPage sp = new MediationPage(driver);
		log.info("click on Mediation Processor link.");
		Assert.assertTrue(clickMediationProcessor.isDisplayed());
		clickMediationProcessor.click();
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

	public void selectTypeIdMediationReader() throws IOException {
		PluginConfigurationPage sp = new PluginConfigurationPage(driver);
		WebElement PCelement = driver.findElement(By.xpath("//select[@name='typeId']"));
		Select se = new Select(PCelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 3, 0));
		JavaScriptExec.sleep();
	}
	
	@FindBy(how = How.XPATH, using = "//a[.='Rate Cards']")
	private WebElement clickFileFormat;

	/**
	 * Method to click on File Format.
	 * 
	 * @throws IOException
	 */
	public void clickFileFormat() throws IOException {
		PluginConfigurationPage sp = new PluginConfigurationPage(driver);
		log.info("Click on File Format");
		JavaScriptExec.sleep();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url2") + "/fileFormats/index";
		driver.get(url);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='fileFormat.name']")
	private WebElement enterName;

	/**
	 * Method to enter Password.
	 * 
	 * @throws IOException
	 */
	public void enterName() throws IOException {
		PluginConfigurationPage sp = new PluginConfigurationPage(driver);
		log.info("Enter File Format Name");
		//WaitClass.WaitForElementisDisplay(driver, 5, enterPassword);
		Assert.assertTrue(enterName.isDisplayed());
		enterName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, 0));
	}
	
	public void uploadFile() throws IOException {
		CreateRateCardPage sp = new CreateRateCardPage(driver);
		log.info("upload Rating csv file");
		WebElement FileUpload = driver.findElement(By.xpath("//input[@name='format_file']"));
		FileUpload.sendKeys("/home/mayank/asterisk.xml");
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
		CreateRateCardPage sp = new CreateRateCardPage(driver);
		log.info("Click on Save Changes Button");
		JavaScriptExec.scrolltoBottomofPage(driver);
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		clickSaveChangesButton.click();
	}
	
	@FindBy(how = How.XPATH, using = "//a[@class='submit save']")
	private WebElement clickUpdateChangesButton;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickUpdateChangesButton() throws IOException {
		CreateRateCardPage sp = new CreateRateCardPage(driver);
		log.info("Click on Save Changes Button");
		JavaScriptExec.scrolltoBottomofPage(driver);
		Assert.assertTrue(clickUpdateChangesButton.isDisplayed());
		clickUpdateChangesButton.click();
	}
	
	

	public void uploadFileFormatXML() throws IOException {
		PluginConfigurationPage sp = new PluginConfigurationPage(driver);
		log.info("upload File Formats xml file");
		JavaScriptExec.sleep();
		WebElement FileUpload = driver.findElement(By.xpath("//select[@name='plg-parm-format_file']"));
		Select fileformatdd=new Select(FileUpload);
		FileUpload.sendKeys("/home/mayank/asterisk.xml");
	}

	@FindBy(how = How.XPATH, using = "//input[@name='processingOrder']")
	private WebElement enterOrderMediationReader;

	/**
	 * Method to enter value for Order.
	 * 
	 * @throws IOException
	 */
	public void enterOrderMediationReader() throws IOException {
		PluginConfigurationPage sp = new PluginConfigurationPage(driver);
		log.info("enter value for Order.");
		JavaScriptExec.sleep();
		Assert.assertTrue(enterOrderMediationReader.isDisplayed());
		enterOrderMediationReader.sendKeys(BasePage.getCellData(xlsxName, sheetName, 5, 0));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='plg-parm-suffix']")
	private WebElement enterSufix;

	/**
	 * Method to enter value for Sufix.
	 * 
	 * @throws IOException
	 */
	public void enterSufix() throws IOException {
		PluginConfigurationPage sp = new PluginConfigurationPage(driver);
		log.info("enter value for Sufix.");
		Assert.assertTrue(enterSufix.isDisplayed());
		enterSufix.sendKeys(BasePage.getCellData(xlsxName, sheetName, 6, 0));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='plg-parm-date_format']")
	private WebElement enterDateFormat;

	/**
	 * Method to enter value for Date Format.
	 * 
	 * @throws IOException
	 */
	public void enterDateFormat() throws IOException {
		PluginConfigurationPage sp = new PluginConfigurationPage(driver);
		log.info("enter value for Sufix.");
		Assert.assertTrue(enterDateFormat.isDisplayed());
		enterDateFormat.sendKeys(BasePage.getCellData(xlsxName, sheetName, 7, 0));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='plg-parm-separator']")
	private WebElement enterSeparator;

	/**
	 * Method to enter value for Separator.
	 * 
	 * @throws IOException
	 */
	public void enterSeparator() throws IOException {
		PluginConfigurationPage sp = new PluginConfigurationPage(driver);
		log.info("enter value for Sufix.");
		Assert.assertTrue(enterSeparator.isDisplayed());
		enterSeparator.sendKeys(BasePage.getCellData(xlsxName, sheetName, 8, 0));
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Plug-in']")
	private WebElement clickSavePluginButton;

	/**
	 * Method to click on Save Plugin Button.
	 * 
	 * @throws IOException
	 */
	public void clickSavePluginButton() throws IOException {
		PluginConfigurationPage sp = new PluginConfigurationPage(driver);
		log.info("Click on Save Plugin Button");
		JavaScriptExec.scrolltoBottomofPage(driver);
		Assert.assertTrue(clickSavePluginButton.isDisplayed());
		clickSavePluginButton.click();
	}

	@FindBy(how = How.XPATH, using = "//div[@class='msg-box successfully']//*[text()='Done']")
	private WebElement verifyConfirmationMsg;

	/**
	 * Method to verify Account Type is created Successfully.
	 * 
	 * @throws IOException
	 */
	public void verifyConfirmationMsg() throws IOException {
		PluginConfigurationPage sp = new PluginConfigurationPage(driver);
		JavaScriptExec.sleep();
		log.info("Verifying if Account Type is created Successfully or not");
		Assert.assertTrue(verifyConfirmationMsg.isDisplayed(),
				"Assert Failed as its unable to search text in Logged in Page");
	}

	public void selectTypeIdMediationProcessor() throws IOException {
		PluginConfigurationPage sp = new PluginConfigurationPage(driver);
		WebElement PCelement = driver.findElement(By.xpath("//select[@name='typeId']"));
		Select se = new Select(PCelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 9, 0));
		JavaScriptExec.sleep();
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='plg-parm-Call Item ID']")
	private WebElement enterDefaultItemIDMediationProcessor;

	/**
	 * Method to enter value for Default Item ID.
	 * 
	 * @throws IOException
	 */
	public void enterDefaultItemIDMediationProcessor(String ItemId) throws IOException {
		JavaScriptExec.sleep();
		PluginConfigurationPage sp = new PluginConfigurationPage(driver);
		log.info("enter value for Default Item ID.");
		Assert.assertTrue(enterDefaultItemIDMediationProcessor.isDisplayed());
		enterDefaultItemIDMediationProcessor.sendKeys(ItemId);
	}
	
	public String fetchDefaultItemID() throws IOException {
		PluginConfigurationPage sp = new PluginConfigurationPage(driver);
		driver.findElement(By.xpath("//*[@id='menu.link.products']/a")).click();
		driver.findElement(By.xpath("//a[@class='submit show']//*[text()='Show All']")).click();
		JavaScriptExec.sleep();

		String ItemName = (BasePage.getCellData(xlsxName, sheetName, 10, 0));
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ItemName + "']")).click();
		JavaScriptExec.sleep();
		String ItemId = driver.findElement(By.xpath("//*[@id='column2']/div/div[2]/div/table[1]/tbody/tr[1]/td[2]"))
				.getText();
		System.out.println(ItemId);
		log.info("Item ID." + ItemId);
		return ItemId;
	}

}
