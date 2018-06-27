package productHistorical;

import baseClassPackage.BasePage;
import categoryProducts.AddProductPage;
import categoryProducts.AddProductWithAssetPage;
import companyHierarchy.ViewAssignedInfoPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
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
import webDataPages.ImpersonatePage;
import webDataPages.SignupChildCompanyInvoiceAsSellerPage;

import org.openqa.selenium.support.ui.Select;

public class CreateOrderPage extends BasePage {

	public CreateOrderPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(CreateOrderPage.class);

	PropertyValExtractors p = new PropertyValExtractors();
	Actions actions = new Actions(driver);
	String sheetName = "CreateOrder";
	String xlsxName = "/ProductHistorical_TestData.xlsx";

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
	 * Method to click on Products tab after successful login.
	 * 
	 * @throws IOException
	 */
	public void clickCustomerTab() throws IOException {
		log.info("Click on Products Tab after successful login");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickCustomerTab.isDisplayed());
		clickCustomerTab.click();

	}
	
	public void createOrder1() throws IOException {
		for (int i = 0; i <= 3; i++) {

			WebElement clickCustomerTab = driver.findElement(By.xpath("//*[@id='menu.link.customers']/a"));
			Assert.assertTrue(clickCustomerTab.isDisplayed());
			clickCustomerTab.click();
			JavaScriptExec.sleep();
			
			addCompanyFilter();

			String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, 0);
			WebElement selectCustomer = driver
					.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']"));
			actions.moveToElement(selectCustomer).click().perform();
			JavaScriptExec.sleep();

			JavaScriptExec.scrolltoBottomofPage(driver);
			WebElement clickCreateOrderButton = driver
					.findElement(By.xpath("//a[@class='submit order']//*[text()='Create Order']"));
			JavaScriptExec.scrollToElementOnPage(driver, clickCreateOrderButton);
			Assert.assertTrue(clickCreateOrderButton.isDisplayed());
			clickCreateOrderButton.click();
			JavaScriptExec.sleep();

			WebElement activeSince = driver.findElement(By.xpath("//input[@name='activeSince']"));
			activeSince.clear();
			activeSince.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, i));

			WebElement productSubTab = driver.findElement(By.xpath("//*[@id='ui-id-8']"));
			Assert.assertTrue(productSubTab.isDisplayed());
			actions.moveToElement(productSubTab).click().perform();
			JavaScriptExec.sleep();

			WebElement categoryElement = driver.findElement(By.xpath("//select[@name='typeId']"));
			Select se1 = new Select(categoryElement);
			se1.selectByVisibleText("Test Category");

			for (int j = 0; j <= 2; j++) {
				String ProductName = BasePage.getCellData(xlsxName, sheetName, 5, j);
				WebElement selectProduct = driver
						.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']"));
				Select sel = new Select(selectProduct);
				sel.selectByVisibleText(ProductName);
				JavaScriptExec.sleep();

				WebElement clickUpdateButton = driver
						.findElement(By.xpath("//a[@class='submit save']//*[text()='Update']"));
				Assert.assertTrue(clickUpdateButton.isDisplayed());
				actions.moveToElement(clickUpdateButton).click().perform();
				JavaScriptExec.sleep();
			}

			String expectedAmount = BasePage.getCellData(xlsxName, sheetName, 7, i);
			String actualAmount = driver.findElement(By.xpath("//*[@id='review-box']/div[3]")).getText();
			Assert.assertEquals(actualAmount, expectedAmount);

			WebElement clickSaveButton = driver
					.findElement(By.xpath("//a[@class='submit save']//*[text()='Save Changes']"));
			Assert.assertTrue(clickSaveButton.isDisplayed());
			actions.moveToElement(clickSaveButton).click().perform();

		}
	}

	public void createOrder3() throws IOException {
		for (int i = 0; i <= 3; i++) {

			WebElement clickCustomerTab = driver.findElement(By.xpath("//*[@id='menu.link.customers']/a"));
			Assert.assertTrue(clickCustomerTab.isDisplayed());
			clickCustomerTab.click();
			JavaScriptExec.sleep();
			
			addCompanyFilter();

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

			WebElement activeSince = driver.findElement(By.xpath("//input[@name='activeSince']"));
			activeSince.clear();
			activeSince.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, i));

			WebElement productSubTab = driver.findElement(By.xpath("//*[@id='ui-id-8']"));
			Assert.assertTrue(productSubTab.isDisplayed());
			actions.moveToElement(productSubTab).click().perform();
			JavaScriptExec.sleep();

			WebElement categoryElement = driver.findElement(By.xpath("//select[@name='typeId']"));
			Select se = new Select(categoryElement);
			se.selectByVisibleText("Test Category");

			for (int j = 0; j <= 2; j++) {
				String ProductName = BasePage.getCellData(xlsxName, sheetName, 5, j);
				WebElement selectProduct = driver
						.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']"));
				Select sel = new Select(selectProduct);
				sel.selectByVisibleText(ProductName);
				JavaScriptExec.sleep();

				WebElement clickUpdateButton = driver
						.findElement(By.xpath("//a[@class='submit save']//*[text()='Update']"));
				Assert.assertTrue(clickUpdateButton.isDisplayed());
				actions.moveToElement(clickUpdateButton).click().perform();
				JavaScriptExec.sleep();
			}

			String expectedAmount = BasePage.getCellData(xlsxName, sheetName, 9, i);
			String actualAmount = driver.findElement(By.xpath("//*[@id='review-box']/div[3]")).getText();
			Assert.assertEquals(actualAmount, expectedAmount);

			WebElement clickSaveButton = driver
					.findElement(By.xpath("//a[@class='submit save']//*[text()='Save Changes']"));
			Assert.assertTrue(clickSaveButton.isDisplayed());
			actions.moveToElement(clickSaveButton).click().perform();

		}
	}

	public void createOrder5() throws IOException {
		for (int i = 0; i <= 3; i++) {

			WebElement clickCustomerTab = driver.findElement(By.xpath("//*[@id='menu.link.customers']/a"));
			Assert.assertTrue(clickCustomerTab.isDisplayed());
			clickCustomerTab.click();
			JavaScriptExec.sleep();

			addCompanyFilter();
			
			String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, 2);
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

			WebElement activeSince = driver.findElement(By.xpath("//input[@name='activeSince']"));
			activeSince.clear();
			activeSince.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, i));

			WebElement productSubTab = driver.findElement(By.xpath("//*[@id='ui-id-8']"));
			Assert.assertTrue(productSubTab.isDisplayed());
			actions.moveToElement(productSubTab).click().perform();
			JavaScriptExec.sleep();

			WebElement categoryElement = driver.findElement(By.xpath("//select[@name='typeId']"));
			Select se = new Select(categoryElement);
			se.selectByVisibleText("Test Category");

			for (int j = 0; j <= 2; j++) {
				String ProductName = BasePage.getCellData(xlsxName, sheetName, 5, j);
				WebElement selectProduct = driver
						.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']"));
				Select sel = new Select(selectProduct);
				sel.selectByVisibleText(ProductName);
				JavaScriptExec.sleep();

				WebElement clickUpdateButton = driver
						.findElement(By.xpath("//a[@class='submit save']//*[text()='Update']"));
				Assert.assertTrue(clickUpdateButton.isDisplayed());
				actions.moveToElement(clickUpdateButton).click().perform();
				JavaScriptExec.sleep();
			}

			String expectedAmount = BasePage.getCellData(xlsxName, sheetName, 11, i);
			String actualAmount = driver.findElement(By.xpath("//*[@id='review-box']/div[3]")).getText();
			Assert.assertEquals(actualAmount, expectedAmount);

			WebElement clickSaveButton = driver
					.findElement(By.xpath("//a[@class='submit save']//*[text()='Save Changes']"));
			Assert.assertTrue(clickSaveButton.isDisplayed());
			actions.moveToElement(clickSaveButton).click().perform();

		}
	}

	@FindBy(how = How.XPATH, using = "//*[@class='fa fa-plus-square']")
	private WebElement clickImpersonate;

	/**
	 * Method to Click on Impersonate Link
	 */
	public void clickImpersonate() {
		log.info("Click on Impersonate Link");
		Assert.assertTrue(clickImpersonate.isDisplayed());
		clickImpersonate.click();
	}

	private WebElement selectChildCompany;

	/**
	 * Method to select Child Company.
	 * 
	 * @throws IOException
	 */
	public void selectChildCompany() throws IOException {
		WebElement Companyelement = driver.findElement(By.xpath("//select[@name='entityId']"));
		Select se = new Select(Companyelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 2, 1));

	}

	@FindBy(how = How.XPATH, using = "//*[text()='OK']")
	private WebElement clickSelectButton;

	/**
	 * Method to Click on Select Button
	 */
	public void clickSelectButton() {
		log.info("Click on Select Button");
		Assert.assertTrue(clickSelectButton.isDisplayed());
		clickSelectButton.click();
	}
	
	public void createOrder2() throws IOException {
		for (int i = 0; i <= 3; i++) {

			WebElement clickCustomerTab = driver.findElement(By.xpath("//*[@id='menu.link.customers']/a"));
			Assert.assertTrue(clickCustomerTab.isDisplayed());
			clickCustomerTab.click();
			JavaScriptExec.sleep();

			String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, 0);
			WebElement selectCustomer = driver
					.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']"));
			selectCustomer.click();
			navigateBottom();
			
			JavaScriptExec.scrolltoBottomofPage(driver);
			WebElement clickCreateOrderButton = driver
					.findElement(By.xpath("//a[@class='submit order']//*[text()='Create Order']"));
			JavaScriptExec.scrollToElementOnPage(driver, clickCreateOrderButton);
			Assert.assertTrue(clickCreateOrderButton.isDisplayed());
			clickCreateOrderButton.click();
			JavaScriptExec.sleep();

			WebElement activeSince = driver.findElement(By.xpath("//input[@name='activeSince']"));
			activeSince.clear();
			activeSince.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, i));

			WebElement productSubTab = driver.findElement(By.xpath("//*[@id='ui-id-8']"));
			Assert.assertTrue(productSubTab.isDisplayed());
			actions.moveToElement(productSubTab).click().perform();
			JavaScriptExec.sleep();

			WebElement categoryElement = driver.findElement(By.xpath("//select[@name='typeId']"));
			Select se = new Select(categoryElement);
			se.selectByVisibleText("Test Category");
			JavaScriptExec.sleep();

			for (int j = 0; j <= 2; j++) {
				String ProductName = BasePage.getCellData(xlsxName, sheetName, 6, j);
				WebElement selectProduct = driver
						.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']"));
				selectProduct.click();
				JavaScriptExec.sleep();

				WebElement clickUpdateButton = driver
						.findElement(By.xpath("//a[@class='submit save']//*[text()='Update']"));
				navigateBottom();
				JavaScriptExec.sleep();
				Assert.assertTrue(clickUpdateButton.isDisplayed());
				actions.moveToElement(clickUpdateButton).click().perform();
				JavaScriptExec.sleep();
			}

			String expectedAmount = BasePage.getCellData(xlsxName, sheetName, 8, i);
			String actualAmount = driver.findElement(By.xpath("//*[@id='review-box']/div[3]")).getText();
			Assert.assertEquals(actualAmount, expectedAmount);

			WebElement clickSaveButton = driver
					.findElement(By.xpath("//a[@class='submit save']//*[text()='Save Changes']"));
			Assert.assertTrue(clickSaveButton.isDisplayed());
			actions.moveToElement(clickSaveButton).click().perform();

		}
	}

	public void createOrder4() throws IOException {
		for (int i = 0; i <= 3; i++) {

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

			WebElement activeSince = driver.findElement(By.xpath("//input[@name='activeSince']"));
			activeSince.clear();
			activeSince.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, i));

			WebElement productSubTab = driver.findElement(By.xpath("//*[@id='ui-id-8']"));
			Assert.assertTrue(productSubTab.isDisplayed());
			actions.moveToElement(productSubTab).click().perform();
			JavaScriptExec.sleep();

			WebElement categoryElement = driver.findElement(By.xpath("//select[@name='typeId']"));
			Select se = new Select(categoryElement);
			se.selectByVisibleText("Test Category");
			JavaScriptExec.sleep();

			for (int j = 0; j <= 2; j++) {
				String ProductName = BasePage.getCellData(xlsxName, sheetName, 6, j);
				WebElement selectProduct = driver
						.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']"));
				Select sel = new Select(selectProduct);
				sel.selectByVisibleText(ProductName);
				JavaScriptExec.sleep();

				WebElement clickUpdateButton = driver
						.findElement(By.xpath("//a[@class='submit save']//*[text()='Update']"));
				Assert.assertTrue(clickUpdateButton.isDisplayed());
				actions.moveToElement(clickUpdateButton).click().perform();
				JavaScriptExec.sleep();
			}

			String expectedAmount = BasePage.getCellData(xlsxName, sheetName, 10, i);
			String actualAmount = driver.findElement(By.xpath("//*[@id='review-box']/div[3]")).getText();
			Assert.assertEquals(actualAmount, expectedAmount);

			WebElement clickSaveButton = driver
					.findElement(By.xpath("//a[@class='submit save']//*[text()='Save Changes']"));
			Assert.assertTrue(clickSaveButton.isDisplayed());
			actions.moveToElement(clickSaveButton).click().perform();

		}
	}

	public void createOrder6() throws IOException {
		for (int i = 0; i <= 3; i++) {

			WebElement clickCustomerTab = driver.findElement(By.xpath("//*[@id='menu.link.customers']/a"));
			Assert.assertTrue(clickCustomerTab.isDisplayed());
			clickCustomerTab.click();
			JavaScriptExec.sleep();

			String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, 2);
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

			WebElement activeSince = driver.findElement(By.xpath("//input[@name='activeSince']"));
			activeSince.clear();
			activeSince.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, i));

			WebElement productSubTab = driver.findElement(By.xpath("//*[@id='ui-id-8']"));
			Assert.assertTrue(productSubTab.isDisplayed());
			actions.moveToElement(productSubTab).click().perform();
			JavaScriptExec.sleep();

			WebElement categoryElement = driver.findElement(By.xpath("//select[@name='typeId']"));
			Select se = new Select(categoryElement);
			se.selectByVisibleText("Test Category");
			JavaScriptExec.sleep();

			for (int j = 0; j <= 2; j++) {
				String ProductName = BasePage.getCellData(xlsxName, sheetName, 6, j);
				WebElement selectProduct = driver
						.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']"));
				Select sel = new Select(selectProduct);
				sel.selectByVisibleText(ProductName);
				JavaScriptExec.sleep();

				WebElement clickUpdateButton = driver
						.findElement(By.xpath("//a[@class='submit save']//*[text()='Update']"));
				Assert.assertTrue(clickUpdateButton.isDisplayed());
				actions.moveToElement(clickUpdateButton).click().perform();
				JavaScriptExec.sleep();
			}

			String expectedAmount = BasePage.getCellData(xlsxName, sheetName, 12, i);
			String actualAmount = driver.findElement(By.xpath("//*[@id='review-box']/div[3]")).getText();
			Assert.assertEquals(actualAmount, expectedAmount);

			WebElement clickSaveButton = driver
					.findElement(By.xpath("//a[@class='submit save']//*[text()='Save Changes']"));
			Assert.assertTrue(clickSaveButton.isDisplayed());
			actions.moveToElement(clickSaveButton).click().perform();

		}
	}
	
	@FindBy(how = How.XPATH, using = "//span[@class='right-text']//a")
	private WebElement clickRedCross;

	/**
	 * Method to click on Red Cross
	 * 
	 * @throws IOException
	 */
	public void clickRedCross() throws IOException {
		log.info("Click on Red Cross");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickRedCross.isDisplayed());
		clickRedCross.click();

	}
	
	public void addCompanyFilter() throws IOException {
		WebElement addFilter = driver.findElement(By.xpath("//a[@class='submit add open']"));
		addFilter.click();
		navigateBottom();
		String CompanyName = BasePage.getCellData(xlsxName, sheetName, 2, 0);
		WebElement selectCompany = driver.findElement(By.xpath("//*[@id=\"filters\"]/div[2]/div[1]/div/ul/li[3]/a"));
		selectCompany.click();
		JavaScriptExec.sleep();
		WebElement company = driver.findElement(By.xpath("//select[@name='filters.CUSTOMER-EQ_U_company_id.integerValue']"));
		Select se = new Select(company);
		se.selectByVisibleText(CompanyName);
		JavaScriptExec.sleep();
		WebElement applyFilter = driver.findElement(By.xpath("//*[@class='submit apply']//*[text()='Apply Filters']"));
		applyFilter.click();
		JavaScriptExec.sleep();
	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}
}
