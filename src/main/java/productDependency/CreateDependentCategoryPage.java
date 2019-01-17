package productDependency;

import baseClassPackage.BasePage;
import productDependency.CreateDependentCategoryPage;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utilPackages.JavaScriptExec;
import utilPackages.PropertyValExtractors;
import org.openqa.selenium.support.ui.Select;

public class CreateDependentCategoryPage extends BasePage {

	/**
	 * This constructor is used to initialize the webdriver in BasePage class,
	 * if the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public CreateDependentCategoryPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(CreateDependentCategoryPage.class);
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "AddProductCategory";
	String xlsxName = "/ProductDependency_TestData.xlsx";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		CreateDependentCategoryPage sp = new CreateDependentCategoryPage(driver);
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
		CreateDependentCategoryPage sp = new CreateDependentCategoryPage(driver);
		log.info("Verifying the First Name is available or not");
		Assert.assertTrue(enterPassword.isDisplayed());
		enterPassword.sendKeys(BasePage.getCellData(xlsxName, sheetName, 1, 0));
	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='j_client_id']")
	private WebElement selectCompany;

	/**
	 * Method to enter Password.
	 * 
	 * @throws IOException
	 */
	public void selectCompany() throws IOException {
		CreateDependentCategoryPage sp = new CreateDependentCategoryPage(driver);
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
		CreateDependentCategoryPage sp = new CreateDependentCategoryPage(driver);
		log.info("Verifying the login button is available or not");
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
		CreateDependentCategoryPage sp = new CreateDependentCategoryPage(driver);
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
		CreateDependentCategoryPage sp = new CreateDependentCategoryPage(driver);
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
		CreateDependentCategoryPage sp = new CreateDependentCategoryPage(driver);
		log.info("Enter Category Name");
		Assert.assertTrue(enterCategoryName.isDisplayed());
		enterCategoryName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 3, 3));
	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='entities']")
	private WebElement selectCompanies;

	/**
	 * Method to select companies.
	 * 
	 * @throws IOException
	 */
	public void selectCompanies() throws IOException {
		CreateDependentCategoryPage sp = new CreateDependentCategoryPage(driver);
		Select se = new Select(selectCompanies);
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
		CreateDependentCategoryPage sp = new CreateDependentCategoryPage(driver);
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
		CreateDependentCategoryPage sp = new CreateDependentCategoryPage(driver);
		log.info("Verifying if Product is created Successfully or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyConfirmationMsg.isDisplayed(),
				"Assert Failed as its unable to search text in Logged in Page");
	}

	public void selectCategoryName() throws IOException {
		CreateDependentCategoryPage sp = new CreateDependentCategoryPage(driver);
		log.info("Click on a category name.");
		String CategoryName = BasePage.getCellData(xlsxName, sheetName, 3, 3);
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
		CreateDependentCategoryPage sp = new CreateDependentCategoryPage(driver);
		log.info("Click on Add Product Button");
		Assert.assertTrue(clickAddProductButton.isDisplayed());
		clickAddProductButton.click();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.descriptions[0].content']")
	private WebElement enterEnglishDescription;

	/**
	 * Method to Enter English Description.
	 * 
	 * @throws IOException
	 */
	public void enterEnglishDescription(int colNum) throws IOException {
		CreateDependentCategoryPage sp = new CreateDependentCategoryPage(driver);
		log.info("Enter English Description");
		Assert.assertTrue(enterEnglishDescription.isDisplayed());
		enterEnglishDescription.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, colNum));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.number']")
	private WebElement enterProductCode;

	/**
	 * Method to Enter Product Code.
	 * 
	 * @throws IOException
	 */
	public void enterProductCode(int colNum) throws IOException {
		CreateDependentCategoryPage sp = new CreateDependentCategoryPage(driver);
		log.info("Enter Product Code");
		Assert.assertTrue(enterProductCode.isDisplayed());
		enterProductCode.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, colNum));
	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='product.entities']")
	private WebElement selectItemCompany;

	/**
	 * Method to Enter Product Code.
	 * 
	 * @throws IOException
	 */
	public void selectItemCompany() throws IOException {
		CreateDependentCategoryPage sp = new CreateDependentCategoryPage(driver);
		Select se = new Select(selectItemCompany);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 2, 0));
	}
	
	public void selectPriceCurrency() throws IOException {
		CreateDependentCategoryPage sp = new CreateDependentCategoryPage(driver);
		WebElement Currencyelement = driver.findElement(By.xpath("//select[@name='product.currencies']"));
		Select se = new Select(Currencyelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 5, 0));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.rate']")
	private WebElement enterPriceRate;

	/**
	 * Method to Enter Price Rate.
	 * 
	 * @throws IOException
	 */
	public void enterPriceRate(int colNum) throws IOException {
		CreateDependentCategoryPage sp = new CreateDependentCategoryPage(driver);
		log.info("Enter Price Rate");
		JavaScriptExec.sleep();
		Assert.assertTrue(enterPriceRate.isDisplayed());
		enterPriceRate.sendKeys(BasePage.getCellData(xlsxName, sheetName, 6, colNum));
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add Price']")
	private WebElement clickAddPriceButton;

	/**
	 * Method to click on Add Price Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddPriceButton() throws IOException {
		CreateDependentCategoryPage sp = new CreateDependentCategoryPage(driver);
		log.info("Click on Add Price Button");
		Assert.assertTrue(clickAddPriceButton.isDisplayed());
		clickAddPriceButton.click();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='dependency']")
	private WebElement clickDependenciesPlus;

	/**
	 * Method to click on Dependencies plus icon.
	 * 
	 * @throws IOException
	 */
	public void clickDependenciesPlus() throws IOException {
		CreateDependentCategoryPage sp = new CreateDependentCategoryPage(driver);
		log.info("click on Dependencies plus icon");
		Assert.assertTrue(clickDependenciesPlus.isDisplayed());
		clickDependenciesPlus.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//select[@name='product.dependencyItemTypes']")
	private WebElement selectProductCategoryDependency;

	/**
	 * Method to click on Dependencies plus icon.
	 * 
	 * @throws IOException
	 */
	public void selectProductCategoryDependency() throws IOException {
		CreateDependentCategoryPage sp = new CreateDependentCategoryPage(driver);
		Select select = new Select(selectProductCategoryDependency);
		select.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 3, 0));
	}

	public void selectProductDependency1() throws IOException {
		CreateDependentCategoryPage sp = new CreateDependentCategoryPage(driver);
		JavaScriptExec.sleep();
		driver.findElement(By.xpath("//*[@id='product.dependencyItems']/option[4]")).click();
	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='period']")
	private WebElement selectProductPeriod;

	/**
	 * Method to click on Dependencies plus icon.
	 * 
	 * @throws IOException
	 */
	public void selectProductPeriod(int colNum) throws IOException {
		CreateDependentCategoryPage sp = new CreateDependentCategoryPage(driver);
		Select select = new Select(selectProductPeriod);
		select.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 7, colNum));
	}

	@FindBy(how = How.XPATH, using = "//input[@id='product.dependencyMin']")
	private WebElement enterMin;

	/**
	 * Method to Enter Minimum Value.
	 * 
	 * @throws IOException
	 */
	public void enterMin(String value) throws IOException {
		CreateDependentCategoryPage sp = new CreateDependentCategoryPage(driver);
		log.info("Enter Min value");
		JavaScriptExec.sleep();
		Assert.assertTrue(enterMin.isDisplayed());
		enterMin.clear();
		enterMin.sendKeys(value);
	}

	@FindBy(how = How.XPATH, using = "//img[@name='add']")
	private WebElement addDependencyLine;

	/**
	 * Method to click on dependency plus icon to add the product.
	 * 
	 * @throws IOException
	 */
	public void addDependencyLine() throws IOException {
		CreateDependentCategoryPage sp = new CreateDependentCategoryPage(driver);
		JavaScriptExec.scrollToElementOnPage(driver, addDependencyLine);
		log.info("click on dependency plus icon to add the product.");
		JavaScriptExec.sleep();
		Assert.assertTrue(addDependencyLine.isDisplayed());
		addDependencyLine.click();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='product.dependencyMax']")
	private WebElement enterMax;

	/**
	 * Method to Enter Price Rate.
	 * 
	 * @throws IOException
	 */
	public void enterMax(String value) throws IOException {
		CreateDependentCategoryPage sp = new CreateDependentCategoryPage(driver);
		log.info("Enter Max value");
		JavaScriptExec.sleep();
		Assert.assertTrue(enterPriceRate.isDisplayed());
		enterMax.clear();
		enterMax.sendKeys(value);
	}
	
	public void selectProductDependency2() throws IOException {
		CreateDependentCategoryPage sp = new CreateDependentCategoryPage(driver);
		JavaScriptExec.sleep();
		driver.findElement(By.xpath("//*[@id='product.dependencyItems']/option[3]")).click();
	}

	public void selectProductDependency3() throws IOException {
		CreateDependentCategoryPage sp = new CreateDependentCategoryPage(driver);
		JavaScriptExec.sleep();
		driver.findElement(By.xpath("//*[@id='product.dependencyItems']/option[2]")).click();
	}
	
	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}
}
