package customer;

import baseClassPackage.BasePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utilPackages.JavaScriptExec;
import utilPackages.PropertyValExtractors;
import utilPackages.WaitClass;
import webDataPages.LoginPage;

import org.openqa.selenium.support.ui.Select;

/**
 * @author Ashutosh
 *
 */

public class ImpersonateCustomerPage extends BasePage {
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public ImpersonateCustomerPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(ImpersonateCustomerPage.class);
	ImpersonateCustomerPage customerPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "ImpersonateCust";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		ImpersonateCustomerPage sp = new ImpersonateCustomerPage(driver);

		log.info("Verifying the Login ID is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, enterLoginID);
		Assert.assertTrue(enterLoginID.isDisplayed());
		enterLoginID.sendKeys(sp.ExcelRead(sheetName).get(0));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='j_password']")
	private WebElement enterPassword;

	/**
	 * Method to enter Password.
	 * 
	 * @throws IOException
	 */
	public void enterPassword() throws IOException {
		ImpersonateCustomerPage sp = new ImpersonateCustomerPage(driver);
		log.info("Verifying the First Name is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, enterPassword);
		Assert.assertTrue(enterPassword.isDisplayed());
		enterPassword.sendKeys(sp.ExcelRead(sheetName).get(1));

	}

	private WebElement selectCompany;

	/**
	 * Method to select Company.
	 * 
	 * @throws IOException
	 */
	public void selectCompany() throws IOException {
		ImpersonateCustomerPage sp = new ImpersonateCustomerPage(driver);
		WebElement Companyelement = driver.findElement(By.xpath("//select[@name='j_client_id']"));
		Select se = new Select(Companyelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(2));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']")
	private WebElement clickLoginButton;

	/**
	 * Method to Click on Save Changes Button
	 */
	public void clickLoginButton() {
		ImpersonateCustomerPage sp = new ImpersonateCustomerPage(driver);
		log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
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
		ImpersonateCustomerPage sp = new ImpersonateCustomerPage(driver);
		log.info("Click on Customer Tab after successful login");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickCustomerTab.isDisplayed());
		clickCustomerTab.click();

	}

	/**
	 * Method to select customer.
	 * 
	 * @throws IOException
	 */
	public void selectCustomer() throws IOException {
		ImpersonateCustomerPage sp = new ImpersonateCustomerPage(driver);
		log.info("Select Customer");
		String CustomerName = sp.ExcelRead(sheetName).get(3);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']")).click();

	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='filters.CUSTOMER-LIKE_UserName.stringValue']")
	private WebElement enterCustomerNameFilter;

	/**
	 * Method to enter the customer name in the Login name Filter.
	 * 
	 * @throws IOException
	 */
	public void enterCustomerNameFilter() throws IOException {
		ImpersonateCustomerPage sp = new ImpersonateCustomerPage(driver);
		log.info("Enter the name of the Customer in the Filte Login name");
		Assert.assertTrue(enterCustomerNameFilter.isDisplayed());
		enterCustomerNameFilter.sendKeys(sp.ExcelRead(sheetName).get(3));
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
		ImpersonateCustomerPage sp = new ImpersonateCustomerPage(driver);
		log.info("Click on Apply Filter");
		Assert.assertTrue(applyFilter.isDisplayed());
		applyFilter.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='column2']/div[4]/div/table/tbody/tr[2]/td[2]/a/img")
	private WebElement clickImpersonateUserImage;

	/**
	 * Method to click on Impersonate This User Image.
	 * 
	 * @throws IOException
	 */
	public void clickImpersonateUserImage() throws IOException {
		ImpersonateCustomerPage sp = new ImpersonateCustomerPage(driver);
		log.info("Click on Impersonate This User Image");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickImpersonateUserImage.isDisplayed());
		clickImpersonateUserImage.click();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='cell double']")
	private WebElement verifyCustomerName;

	/**
	 * Method to Verify Customer Name.
	 * 
	 * @throws IOException
	 */
	public void verifyCustomerName() throws IOException {
		ImpersonateCustomerPage sp = new ImpersonateCustomerPage(driver);
		log.info("Verify Customer Name");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyCustomerName.isDisplayed());
		String ActualCustomer = verifyCustomerName.getText();
		String ExpectedCustomer = sp.ExcelRead(sheetName).get(3);
		Assert.assertEquals(ActualCustomer, ExpectedCustomer);

	}

	@FindBy(how = How.XPATH, using = "//span[@class='right-text']//a")
	private WebElement clickResumeAsAdmin;

	/**
	 * Method to click on Resume as Admin Link.
	 * 
	 * @throws IOException
	 */
	public void clickResumeAsAdmin() throws IOException {
		ImpersonateCustomerPage sp = new ImpersonateCustomerPage(driver);
		log.info("click on Resume as Admin Link.");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickResumeAsAdmin.isDisplayed());
		clickResumeAsAdmin.click();

	}

	@FindBy(how = How.XPATH, using = "//span[@class='right-text']")
	private WebElement verifyAdminLogin;

	/**
	 * Method to verify Label shown is of admin.
	 * 
	 * @throws IOException
	 */
	public void verifyAdminLogin() throws IOException {
		ImpersonateCustomerPage sp = new ImpersonateCustomerPage(driver);
		log.info("Verify Label shown is of admin.");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyAdminLogin.getText().contains(sp.ExcelRead(sheetName).get(2)),
				"Assert Failed as its unable to search text in Logged in Page");
	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}

}
