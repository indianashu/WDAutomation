package configurablePricing;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import baseClassPackage.BasePage;
import configurablePricing.ProductPage;
import utilPackages.JavaScriptExec;
import utilPackages.PropertyValExtractors;
import utilPackages.WaitClass;

public class ProductPage extends BasePage {
	public ProductPage(WebDriver driver) {
		super(driver);
	}

	Logger log = Logger.getLogger(ProductPage.class);
	ProductPage configurationOrderPeriodsPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "Product";
	String xlsxName = "/ConfigurablePricing_TestData.xlsx";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		ProductPage sp = new ProductPage(driver);

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
		ProductPage sp = new ProductPage(driver);
		log.info("Verifying the First Name is available or not");
		Assert.assertTrue(enterPassword.isDisplayed());
		enterPassword.sendKeys(BasePage.getCellData(xlsxName, sheetName, 1, 0));

	}

	public void selectCompany() throws IOException {
		ProductPage sp = new ProductPage(driver);
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
		ProductPage sp = new ProductPage(driver);
		log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
		Assert.assertTrue(clickLoginButton.isDisplayed());
		clickLoginButton.click();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu.link.products']/a")
	private WebElement clickProductTab;

	/**
	 * Method to click on Products tab after successful login.
	 * 
	 * @throws IOException
	 */
	public void clickProductTab() throws IOException {
		ProductPage sp = new ProductPage(driver);
		log.info("Click on Product Tab after successful login");
		Assert.assertTrue(clickProductTab.isDisplayed());
		clickProductTab.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add Category']")
	private WebElement clickAddNewButton;

	/**
	 * Method to click on Add New Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddNewButton() throws IOException {
		ProductPage sp = new ProductPage(driver);
		log.info("Click on Add New");
		Assert.assertTrue(clickAddNewButton.isDisplayed());
		clickAddNewButton.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='description']")
	private WebElement enterCategoryName;

	/**
	 * Method to enter Password.
	 * 
	 * @throws IOException
	 */
	public void enterCategoryName(int rowNum) throws IOException {
		ProductPage sp = new ProductPage(driver);
		log.info("Verifying the Product Name is available or not");
		Assert.assertTrue(enterCategoryName.isDisplayed());
		enterCategoryName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 3, rowNum));

	}

	@FindBy(how = How.XPATH, using = "//*[@id='pricing.name']")
	private WebElement enterProductName;

	/**
	 * Method to enter Password.
	 * 
	 * @throws IOException
	 */
	public void enterProductName(int rowNum) throws IOException {
		ProductPage sp = new ProductPage(driver);
		log.info("Verifying the Product Name is available or not");
		Assert.assertTrue(enterCategoryName.isDisplayed());
		enterCategoryName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 3, rowNum));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add Product']")
	private WebElement clickAddProductButton;

	/**
	 * Method to click on Add Product Button".
	 * 
	 * @throws IOException
	 */
	public void clickAddProductButton() throws IOException {
		ProductPage sp = new ProductPage(driver);
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
	public void enterEnglishDescription(int rowNum) throws IOException {
		ProductPage sp = new ProductPage(driver);
		log.info("Enter English Description");
		Assert.assertTrue(enterEnglishDescription.isDisplayed());
		enterEnglishDescription.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, rowNum));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.number']")
	private WebElement enterProductCode;

	/**
	 * Method to Enter Product Code.
	 * 
	 * @throws IOException
	 */
	public void enterProductCode(int rowNum) throws IOException {
		ProductPage sp = new ProductPage(driver);
		log.info("Enter Product Code");
		Assert.assertTrue(enterProductCode.isDisplayed());
		enterProductCode.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, rowNum));
	}

	@FindBy(how = How.XPATH, using = "//*[@id='orderLineTypeId']")
	private WebElement selectTypeId;

	/**
	 * Method to Enter Product Code.
	 * 
	 * @throws IOException
	 */
	public void selectOrderLineTypeId() throws IOException {
		ProductPage sp = new ProductPage(driver);
		selectTypeId.click();
		Select select = new Select(selectTypeId);
		select.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 7, 1));
	}

	@FindBy(how = How.XPATH, using = "//select[@name='product.currencies']")
	private WebElement selectPriceCurrency;

	/**
	 * Method to select price currency.
	 * 
	 * @throws IOException
	 */
	public void selectPriceCurrency() throws IOException {
		ProductPage sp = new ProductPage(driver);
		Select se = new Select(selectPriceCurrency);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 5, 0));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.rate']")
	private WebElement enterPriceRate;

	/**
	 * Method to Enter Price Rate.
	 * 
	 * @throws IOException
	 */
	public void enterPriceRate(int rowNum) throws IOException {
		ProductPage sp = new ProductPage(driver);
		log.info("Enter Price Rate");
		JavaScriptExec.sleep();
		Assert.assertTrue(enterPriceRate.isDisplayed());
		enterPriceRate.sendKeys(BasePage.getCellData(xlsxName, sheetName, 6, rowNum));
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add Price']")
	private WebElement clickAddPriceButton;

	/**
	 * Method to click on Add Price Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddPriceButton() throws IOException {
		ProductPage sp = new ProductPage(driver);
		log.info("Click on Add Price Button");
		Assert.assertTrue(clickAddPriceButton.isDisplayed());
		clickAddPriceButton.click();
		navigateBottom();
	}

	@FindBy(how = How.XPATH, using = "//select[@name='product.confPricingProduct']")
	private WebElement enterPlanProduct;

	/**
	 * Method to Enter .
	 * 
	 * @throws IOException
	 */
	public void enterPlanProduct(int rowNum) throws IOException {
		ProductPage sp = new ProductPage(driver);
		log.info("Enter Plan Product");
		JavaScriptExec.sleep();
		Assert.assertTrue(enterPlanProduct.isDisplayed());
		enterPlanProduct.sendKeys(BasePage.getCellData(xlsxName, sheetName, 9, rowNum));
	}

	@FindBy(how = How.XPATH, using = "//select[@name='product.confPricingList']")
	private WebElement enterPricing;

	/**
	 * Method to Enter .
	 * 
	 * @throws IOException
	 */
	public void enterPricing(int rowNum) throws IOException {
		ProductPage sp = new ProductPage(driver);
		log.info("Enter Pricing");
		JavaScriptExec.sleep();
		Assert.assertTrue(enterPricing.isDisplayed());
		enterPricing.sendKeys(BasePage.getCellData(xlsxName, sheetName, 8, rowNum));
	}

	@FindBy(how = How.XPATH, using = "//*[@id='confPricingList']/div[2]/a/span")
	private WebElement clickOnAddPrice;

	/**
	 * Method to click on Add Price Button.
	 * 
	 * @throws IOException
	 */
	public void clickOnAddPrice() throws IOException {
		ProductPage sp = new ProductPage(driver);
		log.info("Click on Add Price Button");
		Assert.assertTrue(clickOnAddPrice.isDisplayed());
		clickOnAddPrice.click();
		navigateBottom();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickSaveChangesButton() throws IOException {
		ProductPage sp = new ProductPage(driver);
		log.info("Click on Save Changes Button");
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		clickSaveChangesButton.click();
	}

	public void selectCategory(int rowNum) throws IOException {
		ProductPage sp = new ProductPage(driver);
		String categoryName = BasePage.getCellData(xlsxName, sheetName, 3, rowNum);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + categoryName + "']")).click();
		JavaScriptExec.sleep();

	}
	public void addCompanyFilter() throws IOException {
		WebElement addFilter = driver.findElement(By.xpath("//a[@class='submit add open']"));
		addFilter.click();
		navigateBottom();
		String CompanyName = BasePage.getCellData(xlsxName, sheetName, 2, 0);
		WebElement selectCompany = driver.findElement(By.xpath("//*[@id=\"filters\"]/div[2]/div[1]/div/ul/li[3]/a"));
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
	public void verifyCategoryData(int rowNum) throws IOException {
		String actualCategoryName = BasePage.getCellData(xlsxName, sheetName, 3, rowNum);
		WebElement expectedCategoryName = driver.findElement(By.xpath("//table[@id='categories']//strong[contains(text(),'"+actualCategoryName+"')]"));
		System.out.println(expectedCategoryName);
		Assert.assertEquals(expectedCategoryName.isDisplayed(), true);
		
		WebElement addCategoryFilter = driver.findElement(By.xpath("//*[@id='filters']//a[@class='submit add open']"));
		addCategoryFilter.click();
		JavaScriptExec.sleep();
		
		WebElement selectDescription = driver.findElement(By.xpath("//*[@id='filters']/div[2]/div[1]/div/ul/li[3]/a"));
		selectDescription.click();
		JavaScriptExec.sleep();
		
		WebElement category = driver
				.findElement(By.xpath("//input[@name='filters.CATEGORY-LIKE_Description.stringValue']"));
		category.sendKeys(actualCategoryName);
		JavaScriptExec.sleep();
		
		WebElement applyFilter = driver.findElement(By.xpath("//*[@class='submit apply']//*[text()='Apply Filters']"));
		applyFilter.click();
		JavaScriptExec.sleep();

		String actualCategoryType = BasePage.getCellData(xlsxName, sheetName, 7, rowNum);
		String expectedCategoryType = driver.findElement(By.xpath("//tr[1]//td[3]//a[@class='cell']/span"))
				.getText();
		System.out.println(expectedCategoryType);
		Assert.assertEquals(actualCategoryType, expectedCategoryType);
	}
	
	

	public void verifyProductData(int rowNum) throws IOException {
		String actualProductName = BasePage.getCellData(xlsxName, sheetName, 10, rowNum);
		String expectedProductName = driver
				.findElement(By.xpath("//table[@id='products']//tr[1]//a[@class='cell double']/strong")).getText();
		System.out.println(expectedProductName);
		Assert.assertEquals(actualProductName, expectedProductName);
		
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + actualProductName + "']")).click();
		JavaScriptExec.sleep();
		
		String expectedComponentPricesProduct = driver
				.findElement(By.xpath("//*[@id='column2']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[1]")).getText();
		String actualComponentPricesProduct = BasePage.getCellData(xlsxName, sheetName, 9, rowNum);
		System.out.println(expectedComponentPricesProduct);
		Assert.assertTrue(expectedComponentPricesProduct.contains(actualComponentPricesProduct));
		
		String expectedComponentPricePricing = driver
				.findElement(By.xpath("//*[@id='column2']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[2]")).getText();
		String actualComponentPricesPricing = BasePage.getCellData(xlsxName, sheetName, 8, rowNum);
		System.out.println(expectedComponentPricePricing);
		Assert.assertTrue(expectedComponentPricePricing.contains(actualComponentPricesPricing));

	}

	public void verifyProductName(int rowNum) throws IOException {
		String actualProductName = BasePage.getCellData(xlsxName, sheetName, 9, rowNum);
		String expectedProductName = driver
				.findElement(By.xpath("//table[@id='products']//tr[1]//a[@class='cell double']/strong")).getText();
		System.out.println(expectedProductName);
		Assert.assertEquals(actualProductName, expectedProductName);
	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();

	}
}
