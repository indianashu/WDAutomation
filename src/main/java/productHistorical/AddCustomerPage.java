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

public class AddCustomerPage extends BasePage {

	public AddCustomerPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(AddCustomerPage.class);

	PropertyValExtractors p = new PropertyValExtractors();
	Actions actions = new Actions(driver);
	String sheetName = "AddCustomer";
	String xlsxName = "/ProductHistorical_TestData.xlsx";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws Exception
	 */
	public void enterLoginID() throws Exception {
		AddCustomerPage sp = new AddCustomerPage(driver);

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
		AddCustomerPage sp = new AddCustomerPage(driver);
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
		AddCustomerPage sp = new AddCustomerPage(driver);
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
		AddCustomerPage sp = new AddCustomerPage(driver);
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
		AddCustomerPage sp = new AddCustomerPage(driver);
		log.info("Click on Products Tab after successful login");
		Assert.assertTrue(clickCustomerTab.isDisplayed());
		clickCustomerTab.click();
		JavaScriptExec.sleep();

	}

	public void createCustomerForParent() throws IOException {
		AddCustomerPage sp = new AddCustomerPage(driver);
		for (int i = 0; i <= 2; i++) {
			WebElement clickAddNewButton = driver
					.findElement(By.xpath("//a[@class='submit add']//*[text()='Add New']"));
			JavaScriptExec.scrollToElementOnPage(driver, clickAddNewButton);
			Assert.assertTrue(clickAddNewButton.isDisplayed());
			clickAddNewButton.click();
			JavaScriptExec.sleep();

			WebElement AccountTypeelement = driver.findElement(By.xpath("//select[@name='accountTypeId']"));
			Select sel = new Select(AccountTypeelement);
			sel.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 3, 0));

			WebElement clickSelectButton = driver
					.findElement(By.xpath("//a[@class='submit save']//*[text()='Select']"));
			Assert.assertTrue(clickSelectButton.isDisplayed());
			clickSelectButton.click();
			JavaScriptExec.sleep();

			WebElement enterLoginName = driver.findElement(By.xpath("//input[@name='user.userName']"));
			Assert.assertTrue(enterLoginName.isDisplayed());
			enterLoginName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, i));
			JavaScriptExec.sleep();

			WebElement selectCurrency = driver.findElement(By.xpath("//select[@name='user.currencyId']"));
			selectCurrency.click();
			Select select = new Select(selectCurrency);
			select.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 5, i));
			JavaScriptExec.sleep();

			navigateBottom();

			WebElement clickSaveChangesButton = driver
					.findElement(By.xpath("//a[@class='submit save']//*[text()='Save Changes']"));
			Assert.assertTrue(clickSaveChangesButton.isDisplayed());
			clickSaveChangesButton.click();

			WebElement verifyConfirmationMsg = driver
					.findElement(By.xpath("//div[@class='msg-box successfully']//*[text()='Done']"));
			Assert.assertTrue(verifyConfirmationMsg.isDisplayed(),
					"Assert Failed as its unable to search text in Logged in Page");
			JavaScriptExec.sleep();

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

	public void createCustomerForChild() throws IOException {
		AddCustomerPage sp = new AddCustomerPage(driver);
		for (int i = 0; i <= 2; i++) {
			WebElement clickAddNewButton = driver
					.findElement(By.xpath("//a[@class='submit add']//*[text()='Add New']"));
			Assert.assertTrue(clickAddNewButton.isDisplayed());
			clickAddNewButton.click();
			JavaScriptExec.sleep();

			WebElement clickSelectButton = driver
					.findElement(By.xpath("//a[@class='submit save']//*[text()='Select']"));
			Assert.assertTrue(clickSelectButton.isDisplayed());
			clickSelectButton.click();
			JavaScriptExec.sleep();

			WebElement enterLoginName = driver.findElement(By.xpath("//input[@name='user.userName']"));
			Assert.assertTrue(enterLoginName.isDisplayed());
			enterLoginName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, i));
			JavaScriptExec.sleep();

			WebElement selectCurrency = driver.findElement(By.xpath("//select[@name='user.currencyId']"));
			selectCurrency.click();
			Select select = new Select(selectCurrency);
			select.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 5, i));
			JavaScriptExec.sleep();

			navigateBottom();
			
			WebElement clickSaveChangesButton = driver
					.findElement(By.xpath("//a[@class='submit save']//*[text()='Save Changes']"));
			Assert.assertTrue(clickSaveChangesButton.isDisplayed());
			clickSaveChangesButton.click();

			WebElement verifyConfirmationMsg = driver
					.findElement(By.xpath("//div[@class='msg-box successfully']//*[text()='Done']"));
			Assert.assertTrue(verifyConfirmationMsg.isDisplayed(),
					"Assert Failed as its unable to search text in Logged in Page");
			JavaScriptExec.sleep();

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

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}
}
