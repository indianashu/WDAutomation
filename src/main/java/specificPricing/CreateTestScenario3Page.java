package specificPricing;

import baseClassPackage.BasePage;
import mediation.MediationPage;
import orderHierarchies.OrderHierarchiesPage;
import productDependency.CreateOrderPage;
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

public class CreateTestScenario3Page extends BasePage {
	public CreateTestScenario3Page(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(CreateOrderPage.class);
	PropertyValExtractors p = new PropertyValExtractors();
	Actions actions = new Actions(driver);
	String sheetName = "CreateOrder";
	String xlsxName = "/SpecificPricing_TestData.xlsx";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws Exception
	 */
	public void enterLoginID() throws Exception {
		CreateOrderPage sp = new CreateOrderPage(driver);
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
		CreateOrderPage sp = new CreateOrderPage(driver);
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
		CreateOrderPage sp = new CreateOrderPage(driver);
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
		CreateOrderPage sp = new CreateOrderPage(driver);
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

	public void selectCustomer() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, 2);
		WebElement selectCustomer = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']"));
		navigateBottom();
		actions.moveToElement(selectCustomer).click().perform();
	}

	@FindBy(how = How.XPATH, using = "//img[@alt='inspect customer']")
	private WebElement clickCustomerInspectIcon;

	/**
	 * Method to click on Customer tab after successful login.
	 * 
	 * @throws IOException
	 */
	public void clickCustomerInspectIcon() throws IOException {
		log.info("Click on Products Tab after successful login");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickCustomerInspectIcon.isDisplayed());
		clickCustomerInspectIcon.click();
	}

	@FindBy(how = How.XPATH, using = "//select[@name='product.confPricingProduct']")
	private WebElement enterPlanProduct;

	/**
	 * Method to Enter .
	 * 
	 * @throws IOException
	 */
	public void enterPlanProduct() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		log.info("Enter Plan Product");
		JavaScriptExec.sleep();
		Select dropdown1 = new Select(driver.findElement(By.name("product.confPricingProduct")));
		Assert.assertTrue(enterPlanProduct.isDisplayed());
		enterPlanProduct.sendKeys(BasePage.getCellData(xlsxName, sheetName, 6, 0));
	}

	@FindBy(how = How.XPATH, using = "//select[@name='product.confPricingList']")
	private WebElement enterPricing;

	/**
	 * Method to Enter .
	 * 
	 * @throws IOException
	 */
	public void enterPricing() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		log.info("Enter Pricing");
		JavaScriptExec.sleep();
		Select dropdown2 = new Select(driver.findElement(By.name("product.confPricingList")));
		Assert.assertTrue(enterPricing.isDisplayed());
		enterPricing.sendKeys(BasePage.getCellData(xlsxName, sheetName, 7, 0));
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickSaveChangesButton() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		log.info("Click on Save Changes Button");
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		clickSaveChangesButton.click();
	}

	@FindBy(how = How.XPATH, using = "//div[@class='msg-box successfully']//*[text()='Done']")
	private WebElement verifyConfirmationMsg;

	/**
	 * Method to verify Product is created Successfully.
	 * 
	 * @throws IOException
	 */
	public void verifyConfirmationMsg() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		log.info("Verifying if Product is created Successfully or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyConfirmationMsg.isDisplayed(),
				"Assert Failed as its unable to search text in Logged in Page");
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']")
	private WebElement clickOnAddPrice;

	/**
	 * Method to click on Add Price Button.
	 * 
	 * @throws IOException
	 */
	public void clickOnAddPrice() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		log.info("Click on Add Price Button");
		Assert.assertTrue(clickOnAddPrice.isDisplayed());
		clickOnAddPrice.click();
		navigateBottom();
	}

	// @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Test
	// Mediation 2.0']")
	private WebElement clickMediation;

	/**
	 * Method to Click on Mediation.
	 * 
	 * @throws IOException
	 */
	public void clickMediation() throws IOException {
		MediationPage sp = new MediationPage(driver);
		log.info("Click on Mediation");
		String Mediation = sp.ExcelRead(sheetName).get(16);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + Mediation + "']")).click();
		JavaScriptExec.sleep();
	}

	public void uploadMediationCSVFile() throws IOException {
		MediationPage sp = new MediationPage(driver);
		log.info("upload Mediation csv file");
		WebElement FileUpload = driver.findElement(By.xpath("//input[@name='cdrs']"));
		FileUpload.sendKeys(System.getProperty("user.dir") + "/MediationTest.csv");
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Trigger this Config']")
	private WebElement clickTriggerConfigButton;

	/**
	 * Method to click on trigger this config button.
	 * 
	 * @throws IOException
	 */
	public void clickTriggerConfigButton() throws IOException {
		MediationPage sp = new MediationPage(driver);
		log.info("click on trigger this config button");
		Assert.assertTrue(clickTriggerConfigButton.isDisplayed());
		clickTriggerConfigButton.click();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu.link.mediation']/a")
	private WebElement clickMediationsTab;

	/**
	 * Method to click on Mediations Tab.
	 * 
	 * @throws IOException
	 */
	public void clickMediationsTab() throws IOException {
		MediationPage sp = new MediationPage(driver);
		log.info("click on Mediations Tabs");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickMediationsTab.isDisplayed());
		clickMediationsTab.click();
	}

	@FindBy(how = How.XPATH, using = "//table/tbody/tr[1]/td[6]")
	private WebElement verifyNumberOrders;

	/**
	 * Method to Verify Orders created are greater than Zero.
	 * 
	 * @throws IOException
	 */
	public void verifyNumberOrders() throws IOException {
		MediationPage sp = new MediationPage(driver);
		log.info("Verify Orders created are greater than Zero.");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyNumberOrders.isDisplayed());
		String OrderNumber = driver.findElement(By.xpath("//table/tbody/tr[1]/td[6]")).getText();
		int OrderValue = Integer.parseInt(OrderNumber);
		if (OrderValue > 0) {
			Assert.assertTrue(true, "Number Orders created are greater than Zero.");
		} else {
			Assert.assertFalse(false, "Number Orders created are Zero.");
		}
	}

	// @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Test
	// Mediation 2.0']")
	private WebElement clickMediationName;

	/**
	 * Method to click on Mediation Created.
	 * 
	 * @throws IOException
	 */
	public void clickMediationName() throws IOException {
		MediationPage sp = new MediationPage(driver);
		log.info("click on Mediation name");
		JavaScriptExec.sleep();
		String MediationName = sp.ExcelRead(sheetName).get(16);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + MediationName + "']")).click();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='column2']/div/div[2]/div/table[2]/tbody/tr[3]/td[3]/a")
	private WebElement clickDoneBillableViewLink;

	/**
	 * Method to click on Done Billable View Link.
	 * 
	 * @throws IOException
	 */
	public void clickDoneBillableViewLink() throws IOException {
		MediationPage sp = new MediationPage(driver);
		log.info("click on Done Billable View Link.");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickDoneBillableViewLink.isDisplayed());
		clickDoneBillableViewLink.click();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu.link.orders']/a")
	private WebElement clickOrdersTab;

	/**
	 * Method to click on Orders Tab.
	 * 
	 * @throws IOException
	 */
	public void clickOrdersTab() throws IOException {
		MediationPage sp = new MediationPage(driver);
		log.info("click on Orders Tabs");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickOrdersTab.isDisplayed());
		clickOrdersTab.click();
	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}

}
