package companyHierarchy;

import baseClassPackage.BasePage;
import companySetUp.ConfigurationAccountTypePage;

import java.awt.List;
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
import org.openqa.selenium.support.ui.Select;

/**
 * @author Ashutosh
 *
 */

public class ViewAssignedInfoPage extends BasePage {
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public ViewAssignedInfoPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(ViewAssignedInfoPage.class);
	ViewAssignedInfoPage viewAssignedInfoPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "ImpersonateInfo";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		ViewAssignedInfoPage sp = new ViewAssignedInfoPage(driver);

		log.info("Enter Login ID for logging in.");
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
		ViewAssignedInfoPage sp = new ViewAssignedInfoPage(driver);
		log.info("Enter Password for login");
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
		ViewAssignedInfoPage sp = new ViewAssignedInfoPage(driver);
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
		ViewAssignedInfoPage sp = new ViewAssignedInfoPage(driver);
		log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
		Assert.assertTrue(clickLoginButton.isDisplayed());
		clickLoginButton.click();
	}

	@FindBy(how = How.XPATH, using = "//*[@class='fa fa-plus-square']")
	private WebElement clickImpersonate;

	/**
	 * Method to Click on Impersonate Link
	 */
	public void clickImpersonate() {
		ViewAssignedInfoPage sp = new ViewAssignedInfoPage(driver);
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
		ViewAssignedInfoPage sp = new ViewAssignedInfoPage(driver);
		JavaScriptExec.sleep();
		WebElement Companyelement = driver.findElement(By.xpath("//select[@name='entityId']"));
		Select se = new Select(Companyelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(3));

	}

	@FindBy(how = How.XPATH, using = "//*[text()='OK']")
	private WebElement clickSelectButton;

	/**
	 * Method to Click on Select Button
	 */
	public void clickSelectButton() {
		ViewAssignedInfoPage sp = new ViewAssignedInfoPage(driver);
		log.info("Click on Select Button");
		Assert.assertTrue(clickSelectButton.isDisplayed());
		clickSelectButton.click();
	}

	// @FindBy(how=How.XPATH,using="//*[@id='header']/ul/a")
	private WebElement verifyChildCompanyName;

	/**
	 * Method to Verify Child Company Name is shown
	 * 
	 * @throws IOException
	 */
	public void verifyChildCompanyName() throws IOException {
		ViewAssignedInfoPage sp = new ViewAssignedInfoPage(driver);
		log.info("Verify Child Company Name is shown.");
		JavaScriptExec.sleep();
		String ExpectedName = sp.ExcelRead(sheetName).get(9);
		String ActualName = driver.findElement(By.xpath("//*[@id='header']//span[@class='right-text']")).getText();
		Assert.assertEquals(ActualName, ExpectedName);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu.link.products']/a")
	private WebElement clickProductsTab;

	/**
	 * Method to click on Products Tab
	 * 
	 * @throws IOException
	 */
	public void clickProductsTab() throws IOException {
		ViewAssignedInfoPage sp = new ViewAssignedInfoPage(driver);
		log.info("Click on Products Tab");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickProductsTab.isDisplayed());
		clickProductsTab.click();

	}

	// @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Asset
	// Category1']")
	private WebElement clickCategoryName;

	/**
	 * Method to click on CategoryName
	 * 
	 * @throws IOException
	 */
	public void clickCategoryName() throws IOException {
		ViewAssignedInfoPage sp = new ViewAssignedInfoPage(driver);
		log.info("Click on Category Name");
		JavaScriptExec.sleep();
		String CategoryName = sp.ExcelRead(sheetName).get(4);
		String ActualName = driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CategoryName + "']"))
				.getText();
		Assert.assertEquals(ActualName, CategoryName);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CategoryName + "']")).click();

	}

	// @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='SIM
	// Cards']")
	private WebElement clickProductName;

	/**
	 * Method to click on Product Name
	 * 
	 * @throws IOException
	 */
	public void clickProductName() throws IOException {
		ViewAssignedInfoPage sp = new ViewAssignedInfoPage(driver);
		log.info("Click on Product Name");
		JavaScriptExec.sleep();
		String ProductName = sp.ExcelRead(sheetName).get(5);
		String ActualName = driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']"))
				.getText();
		Assert.assertEquals(ActualName, ProductName);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']")).click();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit show']//*[text()='Show Assets']")
	private WebElement clickShowAssetsButton;

	/**
	 * Method to click on Show Assets Button
	 * 
	 * @throws IOException
	 */
	public void clickShowAssetsButton() throws IOException {
		JavaScriptExec.scrollToElementOnPage(driver, clickShowAssetsButton);
		ViewAssignedInfoPage sp = new ViewAssignedInfoPage(driver);
		log.info("Click on Show Assets Button");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, clickShowAssetsButton);
		Assert.assertTrue(clickShowAssetsButton.isDisplayed());
		clickShowAssetsButton.click();

	}

	// @FindBy(how=How.XPATH, using="//a[@class='cell
	// double']//*[text()='SIM-001']")
	private WebElement verifyAssetName;

	/**
	 * Method to verify Asset Name
	 * 
	 * @throws IOException
	 */
	public void verifyAssetName() throws IOException {
		ViewAssignedInfoPage sp = new ViewAssignedInfoPage(driver);
		log.info("Verify Asset Name.");
		JavaScriptExec.sleep();
		String AssetName = sp.ExcelRead(sheetName).get(6);
		String ActualName = driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + AssetName + "']"))
				.getText();
		Assert.assertEquals(ActualName, AssetName);

	}

	// @FindBy(how=How.XPATH, using="//a[@class='cell
	// double']//*[text()='SIM-001']")
	private WebElement verifyAssetName1;

	/**
	 * Method to verify Asset Name
	 * 
	 * @throws IOException
	 */
	public void verifyAssetName1() throws IOException {
		ViewAssignedInfoPage sp = new ViewAssignedInfoPage(driver);
		log.info("Verify Asset Name.");
		String AssetName = sp.ExcelRead(sheetName).get(7);
		String ActualName = driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + AssetName + "']"))
				.getText();
		Assert.assertEquals(ActualName, AssetName);

	}

	@FindBy(how = How.XPATH, using = "//span[@class='right-text']//a")
	private WebElement clickRedCross;

	/**
	 * Method to click on Red Cross
	 * 
	 * @throws IOException
	 */
	public void clickRedCross() throws IOException {
		ViewAssignedInfoPage sp = new ViewAssignedInfoPage(driver);
		log.info("Click on Red Cross");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickRedCross.isDisplayed());
		clickRedCross.click();

	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu.link.customers']/a")
	private WebElement clickCustomersTab;

	/**
	 * Method to click on Customers Tab
	 * 
	 * @throws IOException
	 */
	public void clickCustomersTab() throws IOException {
		ViewAssignedInfoPage sp = new ViewAssignedInfoPage(driver);
		log.info("Click on Customers Tab");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickCustomersTab.isDisplayed());
		clickCustomersTab.click();

	}

	// @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='ashutosh
	// sandhal']")
	private WebElement verifyChildCustomer;

	/**
	 * Method to Verify Child Customer is created or not.
	 * 
	 * @throws IOException
	 */
	public void verifyChildCustomer() throws IOException {
		ViewAssignedInfoPage sp = new ViewAssignedInfoPage(driver);
		log.info("Verify Child Customer is created or not");
		String CustomerName = sp.ExcelRead(sheetName).get(8);
		String ActualName = driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']"))
				.getText();
		Assert.assertEquals(ActualName, CustomerName);
	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}

}
