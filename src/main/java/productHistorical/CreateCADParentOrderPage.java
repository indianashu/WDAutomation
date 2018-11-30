package productHistorical;

import baseClassPackage.BasePage;

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

import org.openqa.selenium.support.ui.Select;

public class CreateCADParentOrderPage extends BasePage {

	public CreateCADParentOrderPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(CreateCADParentOrderPage.class);

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
		CreateCADParentOrderPage sp = new CreateCADParentOrderPage(driver);

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
		CreateCADParentOrderPage sp = new CreateCADParentOrderPage(driver);
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
		CreateCADParentOrderPage sp = new CreateCADParentOrderPage(driver);
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
		CreateCADParentOrderPage sp = new CreateCADParentOrderPage(driver);
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
	
	// @FindBy(how=How.XPATH, using="//a[@class='cell double']")
    private WebElement selectCustomer;
    /**
     * Method to select customer.
     * @throws IOException 
     */
    public void selectCustomer() throws IOException{
    	CreateUSDParentOrderPage sp=new CreateUSDParentOrderPage(driver);
    	JavaScriptExec.sleep();
    	String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, 1);
		WebElement selectCustomer = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']"));
		navigateBottom();
		actions.moveToElement(selectCustomer).click().perform();
		JavaScriptExec.sleep();
      
    
      
    }

	public void clickCreateOrder() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		WebElement clickCreateOrderButton = driver
				.findElement(By.xpath("//a[@class='submit order']//*[text()='Create Order']"));
		JavaScriptExec.scrollToElementOnPage(driver, clickCreateOrderButton);
		Assert.assertTrue(clickCreateOrderButton.isDisplayed());
		clickCreateOrderButton.click();
		JavaScriptExec.sleep();
	}
	
	public void selectActiveSincePast() throws IOException {
		CreateCADParentOrderPage sp = new CreateCADParentOrderPage(driver);
		WebElement activeSince = driver.findElement(By.xpath("//input[@name='activeSince']"));
		activeSince.clear();
		activeSince.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, 0));
		JavaScriptExec.sleep();
	}

	public void selectActiveSinceBetweenPastPresent() throws IOException {
		CreateCADParentOrderPage sp = new CreateCADParentOrderPage(driver);
		WebElement activeSince = driver.findElement(By.xpath("//input[@name='activeSince']"));
		activeSince.clear();
		activeSince.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, 1));
		JavaScriptExec.sleep();
	}
	
	public void selectActiveSinceBetweenPresentFuture() throws IOException {
		CreateCADParentOrderPage sp = new CreateCADParentOrderPage(driver);
		WebElement activeSince = driver.findElement(By.xpath("//input[@name='activeSince']"));
		activeSince.clear();
		activeSince.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, 2));
		JavaScriptExec.sleep();
	}
	
	public void selectActiveSinceFuture() throws IOException {
		CreateCADParentOrderPage sp = new CreateCADParentOrderPage(driver);
		WebElement activeSince = driver.findElement(By.xpath("//input[@name='activeSince']"));
		activeSince.clear();
		activeSince.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, 3));
		JavaScriptExec.sleep();
	}

	public void clickProductSubTab() {
		WebElement productSubTab = driver.findElement(By.xpath("//*[@id='ui-id-8']"));
		Assert.assertTrue(productSubTab.isDisplayed());
		actions.moveToElement(productSubTab).click().perform();
		JavaScriptExec.sleep();
	}

	public void selectCategory() {
		WebElement categoryElement = driver.findElement(By.xpath("//select[@name='typeId']"));
		Select se1 = new Select(categoryElement);
		se1.selectByVisibleText("Test Category");
	}

	public void selectProduct1() throws IOException {
		String ProductName1 = BasePage.getCellData(xlsxName, sheetName, 5, 0);
		JavaScriptExec.sleep();
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName1 + "']")).click();
		/*Assert.assertTrue(selectProduct.isDisplayed());
		actions.moveToElement(selectProduct).click().perform();*/
		JavaScriptExec.sleep();
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='change--3.appliedManually']")
	private WebElement checkApplyNow;

	/**
	 * Method to Check ApplyNow CheckBox.
	 * 
	 * @throws IOException
	 */
	public void checkApplyNow() throws IOException {
		log.info("Check ApplyNow Checkbox.");
		Assert.assertTrue(checkApplyNow.isDisplayed());
		if ( !checkApplyNow.isSelected() )
		{
			checkApplyNow.click();
		}

	}
	
	@FindBy(how=How.XPATH, using="//*[@id='change--3-update-form']//*[text()='Update']")
	private WebElement clickUpdateButton1;
	/**
	 * Method to click on update button.
	 * @throws IOException 
	 */
	public void clickUpdateButton1() throws IOException{
		log.info("click on update button.");
		Assert.assertTrue(clickUpdateButton1.isDisplayed());
		clickUpdateButton1.click();
        JavaScriptExec.sleep();
		//actions.moveToElement(clickUpdateButton).click().perform();
	}

	public void selectProduct2() throws IOException {
		String ProductName2 = BasePage.getCellData(xlsxName, sheetName, 5, 1);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName2 + "']")).click();
		/*Assert.assertTrue(selectProduct1.isDisplayed());
		actions.moveToElement(selectProduct1).click().perform();*/
		JavaScriptExec.sleep();
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='change--5.appliedManually']")
	private WebElement checkApplyNow2;

	/**
	 * Method to Check ApplyNow CheckBox.
	 * 
	 * @throws IOException
	 */
	public void checkApplyNow2() throws IOException {
		log.info("Check ApplyNow Checkbox.");
		Assert.assertTrue(checkApplyNow2.isDisplayed());
		if ( !checkApplyNow2.isSelected() )
		{
			checkApplyNow2.click();
		}

	}
	
	@FindBy(how=How.XPATH, using="//*[@id='change--5-update-form']//*[text()='Update']")
	private WebElement clickUpdateButton2;
	/**
	 * Method to click on update button.
	 * @throws IOException 
	 */
	public void clickUpdateButton2() throws IOException{
		log.info("click on update button.");
		Assert.assertTrue(clickUpdateButton2.isDisplayed());
		clickUpdateButton2.click();
        JavaScriptExec.sleep();
		//actions.moveToElement(clickUpdateButton).click().perform();
	}

	public void selectProduct3() throws IOException {
		String ProductName3 = BasePage.getCellData(xlsxName, sheetName, 5, 2);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName3 + "']")).click();
		/*Assert.assertTrue(selectProduct2.isDisplayed());
		actions.moveToElement(selectProduct2).click().perform();*/
		JavaScriptExec.sleep();
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='change--7.appliedManually']")
	private WebElement checkApplyNow3;

	/**
	 * Method to Check ApplyNow CheckBox.
	 * 
	 * @throws IOException
	 */
	public void checkApplyNow3() throws IOException {
		log.info("Check ApplyNow Checkbox.");
		Assert.assertTrue(checkApplyNow3.isDisplayed());
		if ( !checkApplyNow3.isSelected() )
		{
			checkApplyNow3.click();
		}

	}

	@FindBy(how=How.XPATH, using="//*[@id='change--7-update-form']//*[text()='Update']")
	private WebElement clickUpdateButton;
	/**
	 * Method to click on update button.
	 * @throws IOException 
	 */
	public void clickUpdateButton() throws IOException{
		log.info("click on update button.");
		Assert.assertTrue(clickUpdateButton.isDisplayed());
		clickUpdateButton.click();
        JavaScriptExec.sleep();
		//actions.moveToElement(clickUpdateButton).click().perform();
	}

	public void expectedAmount1() throws IOException {
		String expectedAmount = BasePage.getCellData(xlsxName, sheetName, 9, 0);
		String actualAmount = driver.findElement(By.xpath("//*[@class='total']")).getText();
		Assert.assertEquals(actualAmount, expectedAmount);
	}
	public void expectedAmount2() throws IOException {
		String expectedAmount = BasePage.getCellData(xlsxName, sheetName, 9, 1);
		String actualAmount = driver.findElement(By.xpath("//*[@class='total']")).getText();
		Assert.assertEquals(actualAmount, expectedAmount);
	}
	public void expectedAmount3() throws IOException {
		String expectedAmount = BasePage.getCellData(xlsxName, sheetName, 9, 2);
		String actualAmount = driver.findElement(By.xpath("//*[@class='total']")).getText();
		Assert.assertEquals(actualAmount, expectedAmount);
	}
	public void expectedAmount4() throws IOException {
		String expectedAmount = BasePage.getCellData(xlsxName, sheetName, 9, 3);
		String actualAmount = driver.findElement(By.xpath("//*[@class='total']")).getText();
		Assert.assertEquals(actualAmount, expectedAmount);
	}

	public void clickSave() {
		WebElement clickSaveButton = driver
				.findElement(By.xpath("//a[@class='submit save']//*[text()='Save Changes']"));
		Assert.assertTrue(clickSaveButton.isDisplayed());
		actions.moveToElement(clickSaveButton).click().perform();
	}

	public void addCompanyFilter() throws IOException {
		WebElement addFilter = driver.findElement(By.xpath("//a[@class='submit add open']"));
		addFilter.click();
		navigateBottom();
		String CompanyName = BasePage.getCellData(xlsxName, sheetName, 2, 0);
		WebElement selectCompany = driver.findElement(By.xpath("//*[@class='drop']/ul/li[3]/a"));
		selectCompany.click();
		JavaScriptExec.sleep();
		WebElement company = driver
				.findElement(By.xpath("//select[@name='filters.CUSTOMER-EQ_U_company_id.integerValue']"));
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