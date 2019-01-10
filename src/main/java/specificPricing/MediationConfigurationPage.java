package specificPricing;

import baseClassPackage.BasePage;
import mediation.MediationPage;
import specificPricing.CreateProductAndCategoryPage;
import specificPricing.CreateProductAndCategoryPage;
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
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
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

	public void clickMediationLink() throws IOException {
		MediationConfigurationPage sp = new MediationConfigurationPage(driver);
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
		MediationConfigurationPage sp = new MediationConfigurationPage(driver);
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

	@FindBy(how = How.XPATH, using = "//a[.='Plug-ins']")
	private WebElement clickPlugins;

	/**
	 * Method to click on plugins link.
	 * 
	 * @throws IOException
	 */
	public void clickPluginsLink() throws IOException {
		MediationConfigurationPage sp = new MediationConfigurationPage(driver);
		JavaScriptExec.sleep();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url2") + "/plugin/list";
		driver.get(url);
	}

	public void clickfileFormatTab() throws IOException {
		MediationConfigurationPage sp = new MediationConfigurationPage(driver);
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
		MediationConfigurationPage sp = new MediationConfigurationPage(driver);
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

	@FindBy(how = How.XPATH, using = "//select[@name='typeId']")
	private WebElement selectPluginType;

	/**
	 * Method to click on Mediation Processor link.
	 * 
	 * @throws IOException
	 */
	public void selectPluginType(int rowNum) throws IOException {
		MediationConfigurationPage sp = new MediationConfigurationPage(driver);
		Select se = new Select(selectPluginType);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 5, rowNum));
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='fileFormat.name']")
	private WebElement enterName;

	/**
	 * Method to enter Password.
	 * 
	 * @throws IOException
	 */
	public void enterName() throws IOException {
		MediationConfigurationPage sp = new MediationConfigurationPage(driver);
		log.info("Enter File Format Name");
		Assert.assertTrue(enterName.isDisplayed());
		enterName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 6, 0));
	}

	public void uploadFile() throws IOException {
		CreateRateCardPage sp = new CreateRateCardPage(driver);
		log.info("upload Rating csv file");
		WebElement FileUpload = driver.findElement(By.xpath("//input[@name='format_file']"));
		FileUpload.sendKeys(System.getProperty("user.dir") + "/asterisk.xml");
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit cancel']//*[text()='Save As It is']")
	private WebElement clickSaveAsItIs;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickUpdateChangesButton() throws IOException {
		CreateRateCardPage sp = new CreateRateCardPage(driver);
		log.info("Click on Save As it is Button");
		JavaScriptExec.scrolltoBottomofPage(driver);
		Assert.assertTrue(clickSaveAsItIs.isDisplayed());
		clickSaveAsItIs.click();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='plg-parm-format_file']")
	private WebElement selectFileFormat;

	/**
	 * Method to enter value for Order.
	 * 
	 * @throws IOException
	 */
	public void selectFileFormat() throws IOException {
		MediationConfigurationPage sp = new MediationConfigurationPage(driver);
		log.info("enter value for Order.");
		Assert.assertTrue(selectFileFormat.isDisplayed());
		String fileName = selectFileFormat.getText();
		if (!fileName.contains("asterisk")) {
			clickfileFormatTab();
			clickAddNewButton();
			enterName();
			uploadFile();
			clickSaveChangesButton();
			clickUpdateChangesButton();
			clickPluginsLink();
			clickMediationReader();
			clickAddNewButton();
			selectPluginType(0);
		}
	}

	@FindBy(how = How.XPATH, using = "//input[@name='plg-parm-suffix']")
	private WebElement enterSufix;

	/**
	 * Method to enter value for Sufix.
	 * 
	 * @throws IOException
	 */
	public void enterSufix() throws IOException {
		MediationConfigurationPage sp = new MediationConfigurationPage(driver);
		log.info("enter value for Sufix.");
		Assert.assertTrue(enterSufix.isDisplayed());
		enterSufix.sendKeys(BasePage.getCellData(xlsxName, sheetName, 7, 0));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='plg-parm-date_format']")
	private WebElement enterDateFormat;

	/**
	 * Method to enter value for Date Format.
	 * 
	 * @throws IOException
	 */
	public void enterDateFormat() throws IOException {
		MediationConfigurationPage sp = new MediationConfigurationPage(driver);
		log.info("enter value for Sufix.");
		Assert.assertTrue(enterDateFormat.isDisplayed());
		enterDateFormat.sendKeys(BasePage.getCellData(xlsxName, sheetName, 8, 0));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='plg-parm-separator']")
	private WebElement enterSeparator;

	/**
	 * Method to enter value for Separator.
	 * 
	 * @throws IOException
	 */
	public void enterSeparator() throws IOException {
		MediationConfigurationPage sp = new MediationConfigurationPage(driver);
		log.info("enter value for Sufix.");
		Assert.assertTrue(enterSeparator.isDisplayed());
		enterSeparator.sendKeys(BasePage.getCellData(xlsxName, sheetName, 9, 0));
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Plug-in']")
	private WebElement clickSavePluginButton;

	/**
	 * Method to click on Save Plugin Button.
	 * 
	 * @throws IOException
	 */
	public void clickSavePluginButton() throws IOException {
		MediationConfigurationPage sp = new MediationConfigurationPage(driver);
		log.info("Click on Save Plugin Button");
		JavaScriptExec.scrolltoBottomofPage(driver);
		Assert.assertTrue(clickSavePluginButton.isDisplayed());
		clickSavePluginButton.click();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='plg-parm-Call Item ID']")
	private WebElement enterDefaultItemId;

	/**
	 * Method to enter value for Default Item ID.
	 * 
	 * @throws IOException
	 */
	public void enterDefaultItemIDMediationProcessor(String ItemId) throws IOException {
		JavaScriptExec.sleep();
		MediationConfigurationPage sp = new MediationConfigurationPage(driver);
		log.info("enter value for Default Item ID.");
		Assert.assertTrue(enterDefaultItemId.isDisplayed());
		enterDefaultItemId.sendKeys(ItemId);
	}

	public String fetchDefaultItemID() throws IOException {
		MediationConfigurationPage sp = new MediationConfigurationPage(driver);
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

	public void verifyPlugInData(int rowNum) throws IOException {
		MediationConfigurationPage sp = new MediationConfigurationPage(driver);
		String actualTypeId = BasePage.getCellData(xlsxName, sheetName, 5, rowNum);
		String expectedTypeId = driver.findElement(By.xpath("//em[@class='small']")).getText();
		System.out.println(expectedTypeId);
		Assert.assertEquals(actualTypeId, expectedTypeId);

		if (rowNum == 2) {
			String expectedProductId = driver.findElement(By.xpath("//td[@class='innerContent'][2]")).getText();
			String actualProductId = sp.fetchDefaultItemID();
			System.out.println("Expected Product ID=" + expectedProductId);
			System.out.println("Actual Product ID=" + actualProductId);
			Assert.assertEquals(actualProductId, expectedProductId);
		}
	}

	public void verifyMediationName() throws IOException {
		MediationConfigurationPage sp = new MediationConfigurationPage(driver);
		String actualMediationName = BasePage.getCellData(xlsxName, sheetName, 3, 0);
		String expectedMediationName = driver.findElement(By.xpath("//a[@class='cell double']/strong")).getText();
		System.out.println(expectedMediationName);
		Assert.assertEquals(actualMediationName, expectedMediationName);
	}

	@FindBy(how = How.XPATH, using = "//select[@id='readerPluginId']")
	private WebElement selectPluginReader;

	/**
	 * Method to click on Mediation Processor link.
	 * 
	 * @throws IOException
	 */
	public void selectPluginReader() throws IOException {
		MediationConfigurationPage sp = new MediationConfigurationPage(driver);
		selectPluginReader.click();
		Select select = new Select(selectPluginReader);
		int selectOptions = select.getOptions().size();
		select.selectByIndex(selectOptions - 1);
	}

	@FindBy(how = How.XPATH, using = "//select[@name='mediationProcessorId']")
	private WebElement selectPluginProcessor;

	/**
	 * Method to click on Mediation Processor link.
	 * 
	 * @throws IOException
	 */
	public void selectPluginProcessor() throws IOException {
		MediationConfigurationPage sp = new MediationConfigurationPage(driver);
		selectPluginProcessor.click();
		Select select = new Select(selectPluginProcessor);
		int selectOptions = select.getOptions().size();
		select.selectByIndex(selectOptions - 1);
	}
}
