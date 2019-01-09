package specificPricing;

import baseClassPackage.BasePage;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import agentcommissions.AgentCommissionProcessPage;
import utilPackages.JavaScriptExec;
import utilPackages.PropertyValExtractors;
import utilPackages.Verify;

import org.openqa.selenium.support.ui.Select;

public class SpecificPricingPage extends BasePage {

	public SpecificPricingPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(SpecificPricingPage.class);
	PropertyValExtractors p = new PropertyValExtractors();
	Actions actions = new Actions(driver);
	String sheetName = "Orders";
	String xlsxName = "/SpecificPricing_TestData.xlsx";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws Exception
	 */
	public void enterLoginID() throws Exception {
		SpecificPricingPage sp = new SpecificPricingPage(driver);
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
		SpecificPricingPage sp = new SpecificPricingPage(driver);
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
		SpecificPricingPage sp = new SpecificPricingPage(driver);
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
		SpecificPricingPage sp = new SpecificPricingPage(driver);
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

	public void selectCustomer(int column) throws IOException {
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, column);
		WebElement selectCustomer = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']"));
		actions.moveToElement(selectCustomer).click().perform();
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
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		log.info("Enter the name of the Customer in the Filte Login name");
		Assert.assertTrue(enterCustomerNameFilter.isDisplayed());
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
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		log.info("Click on Apply Filter");
		Assert.assertTrue(applyFilter.isDisplayed());
		applyFilter.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit order']//*[text()='Create Order']")
	private WebElement clickCreateOrder;

	/**
	 * Method to click on create order button.
	 * 
	 * @throws IOException
	 */
	public void clickCreateOrder() throws IOException {
		navigateBottom();
		JavaScriptExec.scrollToElementOnPage(driver, clickCreateOrder);
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		log.info("click on create order button.");
		Assert.assertTrue(clickCreateOrder.isDisplayed());
		clickCreateOrder.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//select[@name='period']")
	private WebElement selectPeriod;

	/**
	 * Method to Click Products tab.
	 * 
	 * @throws IOException
	 */
	public void selectPeriod() throws IOException {
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		Select se = new Select(selectPeriod);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 4, 0));
	}

	@FindBy(how = How.XPATH, using = "//select[@name='billingTypeId']")
	private WebElement selectOrderType;

	/**
	 * Method to Click Products tab.
	 * 
	 * @throws IOException
	 */
	public void selectOrderType() throws IOException {
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		Select se = new Select(selectOrderType);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 5, 0));
	}

	@FindBy(how = How.XPATH, using = "//*[@id='ui-id-8']")
	private WebElement clickProductsSubTab;

	/**
	 * Method to Click Products tab.
	 * 
	 * @throws IOException
	 */
	public void clickProductsSubTab() throws IOException {
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		log.info("Click Products Tab");
		Assert.assertTrue(clickProductsSubTab.isDisplayed());
		clickProductsSubTab.click();
		JavaScriptExec.sleep();
	}

	public void selectProduct(int column) throws IOException {
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		JavaScriptExec.sleep();
		String ProductName = BasePage.getCellData(xlsxName, sheetName, 6, column);
		WebElement selectProduct = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']"));
		actions.moveToElement(selectProduct).click().perform();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Update']")
	private WebElement clickUpdateButton;

	/**
	 * Method to click on Update button.
	 * 
	 * @throws IOException
	 */
	public void clickUpdateButton() throws IOException {
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		log.info("click on Update button.");
		Assert.assertTrue(clickUpdateButton.isDisplayed());
		clickUpdateButton.click();
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
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		log.info("Click on Save Changes Button");
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		JavaScriptExec.sleep();
		clickSaveChangesButton.click();
	}

	public void verifyProductPriceData() throws IOException {

		String actualName =BasePage.getCellData(xlsxName, sheetName, 3, 0);
		String expectedName = driver.findElement(By.xpath("//*[@id='column2']//*[text()='"+actualName+"']")).getText();
		System.out.println(expectedName);
		Assert.assertEquals(actualName, expectedName);
		
		String expectedAmount = driver.findElement(By.xpath("//*[@id='column2']/div[1]/div[6]/div/table/tbody/tr/td[5]")).getText();
		System.out.println(expectedAmount);
		Assert.assertEquals("US$10.00", expectedAmount);
	}

	public void clickMediationLink() throws IOException {
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		log.info("Click Mediation Config Tab");
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url2") + "/mediationConfig/list";
		driver.get(url);
		JavaScriptExec.sleep();
	}

	public void selectMediation() throws IOException {
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		log.info("Click on Mediation");
		String Mediation = BasePage.getCellData(xlsxName, sheetName, 8, 0);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + Mediation + "']")).click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='cdrs']")
	private WebElement uploadPlanCSVFile;

	/**
	 * Method to click on trigger this config button.
	 * 
	 * @throws IOException
	 */
	public void uploadPlanCSVFile() throws IOException {
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		log.info("upload Mediation csv file");
		uploadPlanCSVFile.sendKeys(System.getProperty("user.dir") + "/MediationPlanPricing.csv");
		JavaScriptExec.sleep();
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='cdrs']")
	private WebElement uploadTestCSVFile;

	/**
	 * Method to click on trigger this config button.
	 * 
	 * @throws IOException
	 */
	public void uploadTestCSVFile() throws IOException {
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		log.info("upload Mediation csv file");
		uploadTestCSVFile.sendKeys(System.getProperty("user.dir") + "/MediationTestPricing.csv");
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
		SpecificPricingPage sp = new SpecificPricingPage(driver);
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
		SpecificPricingPage sp = new SpecificPricingPage(driver);
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
		SpecificPricingPage sp = new SpecificPricingPage(driver);
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

	public void clickMediationName() throws IOException {
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		log.info("click on Mediation name");
		JavaScriptExec.sleep();
		String MediationName = BasePage.getCellData(xlsxName, sheetName, 8, 0);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + MediationName + "']")).click();
	}

	@FindBy(how = How.LINK_TEXT, using = "View")
	private WebElement clickDoneBillableViewLink;

	/**
	 * Method to click on Done Billable View Link.
	 * 
	 * @throws IOException
	 */
	public void clickDoneBillableViewLink() throws IOException {
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		log.info("click on Done Billable View Link.");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickDoneBillableViewLink.isDisplayed());
		clickDoneBillableViewLink.click();
	}
	
	public void verifyCSVData(int rowNum) throws IOException {
		for (int i = 1; i < 6; i++) {
			String expectedQuantity = driver
					.findElement(By.xpath("//*[@id='users']/tbody/tr[" + i + "]/td[9]")).getText();
			String actualQuantity = BasePage.getCellData(xlsxName, sheetName, rowNum, i);
			Verify.verifyEquals(expectedQuantity, actualQuantity, "Expected Quantity is not correct for Test Customer3");
			System.out.println("Expected Quantity of the TestCustomer3="+expectedQuantity);
			
			String expectedRate = driver
					.findElement(By.xpath("//*[@id='users']/tbody/tr[" + i + "]/td[10]")).getText();
			String actualRate = BasePage.getCellData(xlsxName, sheetName, rowNum+1, i);
			Verify.verifyEquals(expectedRate, actualRate,"Expected Rate is not correct for Test Customer3");
			System.out.println("Expected Rate of the TestCustomer3="+expectedRate);
			JavaScriptExec.sleep();

			String expectedAmount = driver
					.findElement(By.xpath("//*[@id='users']/tbody/tr[" + i + "]/td[11]")).getText();
			String actualAmount = BasePage.getCellData(xlsxName, sheetName, rowNum+2, i);
			Verify.verifyEquals(expectedAmount, actualAmount,"Expected Amount is not correct for Test Customer3");
			System.out.println("Expected Amount of the TestCustomer3="+expectedAmount);
		}
		driver.navigate().back();
	}
	@FindBy(how = How.XPATH, using = "//a[@class='submit apply']//*[text()='Show Orders']")
	private WebElement clickShowOrder;

	/**
	 * Method to click on Mediations Tab.
	 * 
	 * @throws IOException
	 */
	public void clickShowOrder() throws IOException {
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		log.info("click on Mediations Tabs");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickShowOrder.isDisplayed());
		clickShowOrder.click();
	}

	public void clickOrder(int column) throws IOException {
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		log.info("click on Mediations Tabs");
		JavaScriptExec.sleep();
		String ordername = BasePage.getCellData(xlsxName, sheetName, 3, column);
		WebElement clickOrder = driver
				.findElement(By.xpath("//a[@class='double cell']//*[text()='" + ordername + "']"));
		Assert.assertTrue(clickOrder.isDisplayed());
		clickOrder.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit show']//*[text()='View Events']")
	private WebElement clickViewEvents;

	/**
	 * Method to click on Mediations Tab.
	 * 
	 * @throws IOException
	 */

	public void clickViewEvents() throws IOException {
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		log.info("click on Mediations Tabs");
		p.getPropertyFile("test", "configuration.properties");
		String orderId = driver.findElement(By.xpath("//*[@id='column2']/div[1]/div[1]/strong/em")).getText();
		System.out.println(orderId);
		String url = p.getVal("url2") + "/mediation/order/" + orderId;
		System.out.println(url);
		driver.get(url);
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
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		log.info("click on Mediations Tabs");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickCustomerInspectIcon.isDisplayed());
		clickCustomerInspectIcon.click();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='btn-open']//*[text()='Plan Component Prices']")
	private WebElement clickPlanComponentPricesSection;

	/**
	 * Method to click on Mediations Tab.
	 * 
	 * @throws IOException
	 */
	public void clickPlanComponentPricesSection() throws IOException {
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		log.info("click on Mediations Tabs");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickPlanComponentPricesSection.isDisplayed());
		clickPlanComponentPricesSection.click();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='confPricingList']")
	private WebElement enterPricing;
	/**
	 * Method to select Pricing.
	 * 
	 * @throws IOException
	 */
	public void enterPricing() throws IOException {
		MediationConfigurationPage sp = new MediationConfigurationPage(driver);
		enterPricing.click();
		Select se = new Select(enterPricing);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 7, 0));
	}

	@FindBy(how = How.XPATH, using = "//*[@id='confPricingProduct']")
	private WebElement enterPlanProduct;

	/**
	 * Method to select Plan Product.
	 * 
	 * @throws IOException
	 */
	public void enterPlanProduct() throws IOException {
		MediationConfigurationPage sp = new MediationConfigurationPage(driver);
		enterPlanProduct.click();
		Select se = new Select(enterPlanProduct);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 6, 0));
	}

	@FindBy(how = How.XPATH, using = "//*[@id='user-edit-form']/div[1]/div[2]/a")
	private WebElement clickAddPrice;

	/**
	 * Method to click on Add Price Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddPrice() throws IOException {
		SpecificPricingPage sp = new SpecificPricingPage(driver);
		log.info("Click on Save Changes Button");
		Assert.assertTrue(clickAddPrice.isDisplayed());
		clickAddPrice.click();
	}

	public void verifyPlanPricingData() throws IOException {
		String expectedTotal = driver.findElement(By.xpath("//*[@id='main']/div[4]/em[2]/strong")).getText();
		String actualTotal = BasePage.getCellData(xlsxName, sheetName, 9, 0);
		Verify.verifyEquals(expectedTotal, actualTotal,"Expected Total is not correct for Test Customer2");
		System.out.println("Expected Total Amount of the TestCustomer2="+expectedTotal);
	}

	public void verifyCustomerPricingData() throws IOException {
		String expectedTotal = driver.findElement(By.xpath("//*[@id='main']/div[4]/em[2]/strong")).getText();
		String actualTotal = BasePage.getCellData(xlsxName, sheetName, 13, 0);
		Verify.verifyEquals(expectedTotal, actualTotal,"Expected Total is not correct for Test Customer3");
		System.out.println("Expected Total Amount of the TestCustomer3="+expectedTotal);
	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}
}
