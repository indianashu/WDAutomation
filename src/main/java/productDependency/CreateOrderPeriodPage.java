package productDependency;

import baseClassPackage.BasePage;
import productDependency.CreateOrderPeriodPage;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utilPackages.JavaScriptExec;
import utilPackages.PropertyValExtractors;
import utilPackages.WaitClass;
import org.openqa.selenium.support.ui.Select;



public class CreateOrderPeriodPage extends BasePage {
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public CreateOrderPeriodPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(CreateOrderPeriodPage.class);
	CreateOrderPeriodPage configurationOrderPeriodsPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "OrderPeriod";
	String xlsxName = "/ProductDependency_TestData.xlsx";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		CreateOrderPeriodPage sp = new CreateOrderPeriodPage(driver);

		log.info("Verifying the Login ID is available or not");
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
		CreateOrderPeriodPage sp = new CreateOrderPeriodPage(driver);
		log.info("Verifying the First Name is available or not");
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
		CreateOrderPeriodPage sp = new CreateOrderPeriodPage(driver);
		WebElement Companyelement = driver.findElement(By.xpath("//select[@name='j_client_id']"));
		Select se = new Select(Companyelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 2, 0));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']")
	private WebElement clickLoginButton;

	/**
	 * Method to Click on Login Button
	 */
	public void clickLoginButton() {
		CreateOrderPeriodPage sp = new CreateOrderPeriodPage(driver);
		log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
		Assert.assertTrue(clickLoginButton.isDisplayed());
		clickLoginButton.click();
	}

	

	@FindBy(how = How.XPATH, using = "//a[.='Order Periods']")
	private WebElement clickOrderPeriods;

	/**
	 * Method to click on Order Periods.
	 * 
	 * @throws IOException
	 */
	public void clickOrderPeriods() throws IOException {
		CreateOrderPeriodPage sp = new CreateOrderPeriodPage(driver);
		log.info("Click on Order Periods");
		JavaScriptExec.sleep();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url2") + "/orderPeriod/list";
		driver.get(url);
	}
	
	public boolean checkSemiMonthlyisPresent() throws IOException {
		log.info("Check Semi Monthly Order Periods is present or not");
		JavaScriptExec.sleep();
		 try {
		WebElement checkSemiMonthlyisPresent = driver.findElement(By.xpath("//table[@id='periods']//*[contains(text(),'Semi-monthly')]"));
			if (!checkSemiMonthlyisPresent.isDisplayed()) {
				return false;
			}
		} catch (NoSuchElementException e) {
			return true;
		}
		 return false;
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add New']")
	private WebElement clickAddNewButton;

	/**
	 * Method to click on Add New Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddNewButton() throws IOException {
		CreateOrderPeriodPage sp = new CreateOrderPeriodPage(driver);
		log.info("Click on Add New");
		Assert.assertTrue(clickAddNewButton.isDisplayed());
		clickAddNewButton.click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='description']")
	private WebElement enterDescription;

	/**
	 * Method to enter Description.
	 * 
	 * @throws IOException
	 */
	public void enterDescription() throws IOException {
		CreateOrderPeriodPage sp = new CreateOrderPeriodPage(driver);
		log.info("Verifying the Description is available or not");
		Assert.assertTrue(enterDescription.isDisplayed());
		enterDescription.sendKeys(BasePage.getCellData(xlsxName, sheetName, 3, 0));

	}

	private WebElement selectUnit;

	/**
	 * Method to select Unit.
	 * 
	 * @throws IOException
	 */
	public void selectUnit() throws IOException {
		CreateOrderPeriodPage sp = new CreateOrderPeriodPage(driver);
		WebElement Unitelement = driver.findElement(By.xpath("//select[@name='periodUnitId']"));
		Select se = new Select(Unitelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 4, 0));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='value']")
	private WebElement enterValue;

	/**
	 * Method to enter Value.
	 * 
	 * @throws IOException
	 */
	public void enterValue() throws IOException {
		CreateOrderPeriodPage sp = new CreateOrderPeriodPage(driver);
		log.info("Verifying the Description is available or not");
		Assert.assertTrue(enterValue.isDisplayed());
		enterValue.sendKeys(BasePage.getCellData(xlsxName, sheetName, 5, 0));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickSaveChangesButton() throws IOException {
		CreateOrderPeriodPage sp = new CreateOrderPeriodPage(driver);
		log.info("Click on Save Changes Button");
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		clickSaveChangesButton.click();

	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}

}

	
