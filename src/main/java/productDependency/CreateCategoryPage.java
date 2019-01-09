package productDependency;

import baseClassPackage.BasePage;
import productDependency.CreateCategoryPage;
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
import utilPackages.Verify;
import utilPackages.WaitClass;
import org.openqa.selenium.support.ui.Select;

public class CreateCategoryPage extends BasePage {

	/**
	 * This constructor is used to initialize the webdriver in BasePage class,
	 * if the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public CreateCategoryPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(CreateCategoryPage.class);
	CreateCategoryPage productCategoryPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "AddProductCategory1";
	String xlsxName = "/ProductDependency_TestData.xlsx";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		log.info("Verifying the Login ID is available or not");
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
		CreateCategoryPage sp = new CreateCategoryPage(driver);
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
		CreateCategoryPage sp = new CreateCategoryPage(driver);
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
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
		Assert.assertTrue(clickLoginButton.isDisplayed());
		clickLoginButton.click();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu.link.products']/a")
	private WebElement clickProductsTab;

	/**
	 * Method to click on Products tab after successful login.
	 * 
	 * @throws IOException
	 */
	public void clickProductsTab() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		log.info("Click on Products Tab after successful login");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickProductsTab.isDisplayed());
		clickProductsTab.click();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add Category']")
	private WebElement clickAddCategoryButton;

	/**
	 * Method to click on Add Category Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddCategoryButton() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		log.info("Click on Add Category Button");
		navigateBottom();
		Assert.assertTrue(clickAddCategoryButton.isDisplayed());
		clickAddCategoryButton.click();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='description']")
	private WebElement enterCategoryName;

	/**
	 * Method to Enter Category Name.
	 * 
	 * @throws IOException
	 */
	public void enterCategoryName() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		log.info("Enter Category Name");
		Assert.assertTrue(enterCategoryName.isDisplayed());
		enterCategoryName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 3,0));
	}

	private WebElement selectCompanies;

	/**
	 * Method to select companies.
	 * 
	 * @throws IOException
	 */
	public void selectCompanies() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		WebElement Companieselement = driver.findElement(By.xpath("//select[@name='entities']"));
		Select se = new Select(Companieselement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 2, 0));
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

	@FindBy(how = How.XPATH, using = "//input[@name='product.descriptions[0].content']")
	private WebElement enterEnglishDescription;

	/**
	 * Method to Enter English Description.
	 * 
	 * @throws IOException
	 */
	public void enterEnglishDescription() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		log.info("Enter English Description");
		Assert.assertTrue(enterEnglishDescription.isDisplayed());
		enterEnglishDescription.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, 0));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.number']")
	private WebElement enterProductCode;

	/**
	 * Method to Enter Product Code.
	 * 
	 * @throws IOException
	 */
	public void enterProductCode() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		log.info("Enter Product Code");
		Assert.assertTrue(enterProductCode.isDisplayed());
		enterProductCode.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, 0));
	}

	public void selectCompany1() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		WebElement Companieselement = driver.findElement(By.xpath("//select[@name='product.entities']"));
		Select se = new Select(Companieselement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 2, 0));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.rate']")
	private WebElement enterPriceRate;

	/**
	 * Method to Enter Price Rate.
	 * 
	 * @throws IOException
	 */
	public void enterPriceRate() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		log.info("Enter Price Rate");
		JavaScriptExec.sleep();
		Assert.assertTrue(enterPriceRate.isDisplayed());
		enterPriceRate.sendKeys(BasePage.getCellData(xlsxName, sheetName, 6, 0));
	}

	public void selectCategoryName() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		log.info("Click on a category name.");
		String CategoryName = BasePage.getCellData(xlsxName, sheetName, 3,0);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CategoryName + "']")).click();
		JavaScriptExec.sleep();
	}
	
	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add Product']")
	private WebElement clickAddProductButton;

	/**
	 * Method to click on Add Product Button".
	 * 
	 * @throws IOException
	 */
	public void clickAddProductButton() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		log.info("Click on Add Product Button");
		Assert.assertTrue(clickAddProductButton.isDisplayed());
		clickAddProductButton.click();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.descriptions[0].content']")
	private WebElement enterEnglishDescription1;

	/**
	 * Method to Enter English Description.
	 * 
	 * @throws IOException
	 */
	public void enterEnglishDescription1() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		log.info("Enter English Description");
		Assert.assertTrue(enterEnglishDescription.isDisplayed());
		enterEnglishDescription.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, 1));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.number']")
	private WebElement enterProductCode1;

	/**
	 * Method to Enter Product Code.
	 * 
	 * @throws IOException
	 */
	public void enterProductCode1() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		log.info("Enter Product Code");
		Assert.assertTrue(enterProductCode.isDisplayed());
		enterProductCode.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, 1));
	}

	private WebElement selectPriceCompany;

	/**
	 * Method to select company in Prices.
	 * 
	 * @throws IOException
	 */
	public void selectPriceCompany() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		WebElement Companieselement = driver.findElement(By.xpath("//select[@name='product.entity']"));
		Select se = new Select(Companieselement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 2, 0));
	}

	private WebElement selectPriceCurrency;

	/**
	 * Method to select price currency.
	 * 
	 * @throws IOException
	 */
	public void selectPriceCurrency() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		WebElement Currencyelement = driver.findElement(By.xpath("//select[@name='product.currencies']"));
		Select se = new Select(Currencyelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 5, 0));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.rate']")
	private WebElement enterPriceRate1;

	/**
	 * Method to Enter Price Rate.
	 * 
	 * @throws IOException
	 */
	public void enterPriceRate1() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		log.info("Enter Price Rate");
		JavaScriptExec.sleep();
		Assert.assertTrue(enterPriceRate.isDisplayed());
		enterPriceRate.sendKeys(BasePage.getCellData(xlsxName, sheetName, 6, 1));
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add Price']")
	private WebElement clickAddPriceButton;

	/**
	 * Method to click on Add Price Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddPriceButton() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		log.info("Click on Add Price Button");
		Assert.assertTrue(clickAddPriceButton.isDisplayed());
		clickAddPriceButton.click();
		navigateBottom();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.descriptions[0].content']")
	private WebElement enterEnglishDescription2;

	/**
	 * Method to Enter English Description.
	 * 
	 * @throws IOException
	 */
	public void enterEnglishDescription2() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		log.info("Enter English Description");
		Assert.assertTrue(enterEnglishDescription.isDisplayed());
		enterEnglishDescription.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, 2));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.number']")
	private WebElement enterProductCode2;

	/**
	 * Method to Enter Product Code.
	 * 
	 * @throws IOException
	 */
	public void enterProductCode2() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		log.info("Enter Product Code");
		Assert.assertTrue(enterProductCode.isDisplayed());
		enterProductCode.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, 2));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.rate']")
	private WebElement enterPriceRate2;

	/**
	 * Method to Enter Price Rate.
	 * 
	 * @throws IOException
	 */
	public void enterPriceRate2() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		log.info("Enter Price Rate");
		JavaScriptExec.sleep();
		Assert.assertTrue(enterPriceRate.isDisplayed());
		enterPriceRate.sendKeys(BasePage.getCellData(xlsxName, sheetName, 0, 0));
	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();

	}
}
