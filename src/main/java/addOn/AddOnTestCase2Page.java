package addOn;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import baseClassPackage.BasePage;
import utilPackages.JavaScriptExec;

public class AddOnTestCase2Page extends BasePage {

	public AddOnTestCase2Page(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(AddOnTestCase2Page.class);
	String sheetName = "AddOrder";
	String xlsxName = "/AddOn_TestData.xlsx";
	Actions actions = new Actions(driver);

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws Exception
	 */
	public void enterLoginID() throws Exception {
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
		log.info("Verifying the First Name is available or not");
		Assert.assertTrue(enterPassword.isDisplayed());
		enterPassword.sendKeys(BasePage.getCellData(xlsxName, sheetName, 1, 0));

	}

	public void selectCompany() throws Exception {
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

	@FindBy(how = How.XPATH, using = "//*[@id='menu.link.customers']/a")
	private WebElement clickCustomerTab;

	/**
	 * Method to click on Products tab after successful login.
	 * 
	 * @throws IOException
	 */
	public void clickCustomerTab() throws IOException {
		log.info("Click on Products Tab after successful login");
		Assert.assertTrue(clickCustomerTab.isDisplayed());
		clickCustomerTab.click();
		JavaScriptExec.sleep();

	}

	public void subscriptionOfPlan() throws IOException {

		WebElement clickCustomerTab = driver.findElement(By.xpath("//*[@id='menu.link.customers']/a"));
		Assert.assertTrue(clickCustomerTab.isDisplayed());
		clickCustomerTab.click();
		JavaScriptExec.sleep();

		String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, 1);
		WebElement selectCustomer = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']"));
		selectCustomer.click();
		JavaScriptExec.sleep();

		JavaScriptExec.scrolltoBottomofPage(driver);
		WebElement clickCreateOrderButton = driver
				.findElement(By.xpath("//a[@class='submit order']//*[text()='Create Order']"));
		JavaScriptExec.scrollToElementOnPage(driver, clickCreateOrderButton);
		Assert.assertTrue(clickCreateOrderButton.isDisplayed());
		clickCreateOrderButton.click();
		JavaScriptExec.sleep();

		WebElement Periodelement = driver.findElement(By.xpath("//select[@name='period']"));
		Select se = new Select(Periodelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 5, 0));

		WebElement OrderTypeelement = driver.findElement(By.xpath("//select[@name='billingTypeId']"));
		Select se1 = new Select(OrderTypeelement);
		se1.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 6, 0));

		WebElement activeSince = driver.findElement(By.xpath("//input[@name='activeSince']"));
		activeSince.clear();
		activeSince.sendKeys(BasePage.getCellData(xlsxName, sheetName, 7, 0));

		WebElement activeUntil = driver.findElement(By.xpath("//input[@name='activeUntil']"));
		activeUntil.clear();
		activeUntil.sendKeys(BasePage.getCellData(xlsxName, sheetName, 8, 1));

		WebElement productSubTab = driver.findElement(By.xpath("//*[@id='ui-id-8']"));
		Assert.assertTrue(productSubTab.isDisplayed());
		actions.moveToElement(productSubTab).click().perform();
		JavaScriptExec.sleep();

		WebElement categoryElement = driver.findElement(By.xpath("//select[@name='typeId']"));
		Select se2 = new Select(categoryElement);
		se2.selectByVisibleText("SMSBundle");
		JavaScriptExec.sleep();

		String ProductName = BasePage.getCellData(xlsxName, sheetName, 4, 1);
		WebElement selectProduct = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']"));
		selectProduct.click();
		JavaScriptExec.sleep();

		WebElement clickUpdateButton = driver.findElement(By.xpath("//a[@class='submit save']//*[text()='Update']"));
		JavaScriptExec.scrolltoBottomofPage(driver);
		Assert.assertTrue(clickUpdateButton.isDisplayed());
		clickUpdateButton.click();
		JavaScriptExec.sleep();

		WebElement clickSaveButton = driver
				.findElement(By.xpath("//a[@class='submit save']//*[text()='Save Changes']"));
		Assert.assertTrue(clickSaveButton.isDisplayed());
		actions.moveToElement(clickSaveButton).click().perform();
	}

	public void consumptionOfPlan() throws IOException {
		int i = 0;
		while(i <= 2){

			WebElement clickCustomerTab = driver.findElement(By.xpath("//*[@id='menu.link.customers']/a"));
			Assert.assertTrue(clickCustomerTab.isDisplayed());
			clickCustomerTab.click();
			JavaScriptExec.sleep();

			String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, 1);
			WebElement selectCustomer = driver
					.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']"));
			selectCustomer.click();
			JavaScriptExec.sleep();

			JavaScriptExec.scrolltoBottomofPage(driver);
			WebElement clickCreateOrderButton = driver
					.findElement(By.xpath("//a[@class='submit order']//*[text()='Create Order']"));
			JavaScriptExec.scrollToElementOnPage(driver, clickCreateOrderButton);
			Assert.assertTrue(clickCreateOrderButton.isDisplayed());
			clickCreateOrderButton.click();
			JavaScriptExec.sleep();

			WebElement Periodelement = driver.findElement(By.xpath("//select[@name='period']"));
			Select se = new Select(Periodelement);
			se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 5, 0));

			WebElement OrderTypeelement = driver.findElement(By.xpath("//select[@name='billingTypeId']"));
			Select se1 = new Select(OrderTypeelement);
			se1.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 6, 0));

			WebElement activeSince = driver.findElement(By.xpath("//input[@name='activeSince']"));
			activeSince.clear();
			activeSince.sendKeys(BasePage.getCellData(xlsxName, sheetName, 7, i));

			WebElement productSubTab = driver.findElement(By.xpath("//*[@id='ui-id-8']"));
			Assert.assertTrue(productSubTab.isDisplayed());
			actions.moveToElement(productSubTab).click().perform();
			JavaScriptExec.sleep();

			WebElement categoryElement = driver.findElement(By.xpath("//select[@name='typeId']"));
			Select se2 = new Select(categoryElement);
			se2.selectByVisibleText("SMS");
			JavaScriptExec.sleep();

			WebElement selectProduct = driver
					.findElement(By.xpath("//a[@class='cell double']//*[text()='SMS Local']"));
			actions.moveToElement(selectProduct).click().perform();
			JavaScriptExec.sleep();

			WebElement enterChangeQty = driver.findElement(By.xpath("//input[@class='field quantity']"));
			log.info("Enter New Quantity");
			Assert.assertTrue(enterChangeQty.isDisplayed());
			enterChangeQty.clear();
			actions.sendKeys(BasePage.getCellData(xlsxName, sheetName, 11, i));

			WebElement clickUpdateButton = driver
					.findElement(By.xpath("//a[@class='submit save']//*[text()='Update']"));
			Assert.assertTrue(clickUpdateButton.isDisplayed());
			actions.moveToElement(clickUpdateButton).click().perform();
			JavaScriptExec.sleep();

			String expectedAmount = BasePage.getCellData(xlsxName, sheetName, 12, i);
			String actualAmount = driver.findElement(By.xpath("//*[@id='review-box']//*[@class='total']")).getText();
			Assert.assertEquals(actualAmount, expectedAmount);

			WebElement clickSaveButton = driver
					.findElement(By.xpath("//a[@class='submit save']//*[text()='Save Changes']"));
			Assert.assertTrue(clickSaveButton.isDisplayed());
			actions.moveToElement(clickSaveButton).click().perform();

			i++;
		}
	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}
}

