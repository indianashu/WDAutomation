package orderHierarchies;

import baseClassPackage.BasePage;
import customer.ImpersonateCustomerPage;
import invoice.GeneratingInvoicePage;

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
import utilPackages.WaitClass;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Ashutosh
 *
 */

public class OrderHierarchiesPage extends BasePage {
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public OrderHierarchiesPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(OrderHierarchiesPage.class);
	OrderHierarchiesPage orderHierarchiesPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "OrderHierarcy";
	
	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);

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
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
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
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
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
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
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
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
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
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("Click on Add Category Button");
		navigateBottom();
		Assert.assertTrue(clickAddCategoryButton.isDisplayed());
		clickAddCategoryButton.click();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='description']")
	private WebElement enterProductCategoryName;

	/**
	 * Method to enter product category name.
	 * 
	 * @throws IOException
	 */
	public void enterProductCategoryName() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("enter product category name.");
		Assert.assertTrue(enterProductCategoryName.isDisplayed());
		enterProductCategoryName.sendKeys(sp.ExcelRead(sheetName).get(3));

	}

	private WebElement clickProductCategory;

	/**
	 * Method to click on a product category.
	 * 
	 * @throws IOException
	 */
	public void clickProductCategory() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("enter product category name.");
		String ProductCategory = sp.ExcelRead(sheetName).get(3);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductCategory + "']")).click();
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
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("Click on Add Product Button");
		Assert.assertTrue(clickAddProductButton.isDisplayed());
		clickAddProductButton.click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.descriptions[0].content']")
	private WebElement enterEnglishDescription;

	/**
	 * Method to Enter English Description.
	 * 
	 * @throws IOException
	 */
	public void enterEnglishDescription() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("Enter English Description");
		Assert.assertTrue(enterEnglishDescription.isDisplayed());
		enterEnglishDescription.sendKeys(sp.ExcelRead(sheetName).get(4));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.number']")
	private WebElement enterProductCode;

	/**
	 * Method to Enter Product Code.
	 * 
	 * @throws IOException
	 */
	public void enterProductCode() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("Enter Product Code");
		Assert.assertTrue(enterProductCode.isDisplayed());
		enterProductCode.sendKeys(sp.ExcelRead(sheetName).get(5));

	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='product.currencies']")
	private WebElement selectCurrency;

	/**
	 * Method to Select Currency United State Dollar.
	 * 
	 * @throws IOException
	 */
	public void selectPriceCurrency() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("Select Currency United State Dollar");
		Select sel = new Select(selectCurrency);
		sel.selectByVisibleText(sp.ExcelRead(sheetName).get(19));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.rate']")
	private WebElement enterProductRate;

	/**
	 * Method to enter product rate.
	 * 
	 * @throws IOException
	 */
	public void enterProductRate() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("enter product rate.");
		JavaScriptExec.scrolltoBottomofPage(driver);
		Assert.assertTrue(enterProductRate.isDisplayed());
		enterProductRate.sendKeys(sp.ExcelRead(sheetName).get(6));
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add Price']")
	private WebElement clickAddPriceButton;

	/**
	 * Method to click on Add Price Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddPriceButton() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("Click on Add Price Button");
		Assert.assertTrue(clickAddPriceButton.isDisplayed());
		clickAddPriceButton.click();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.descriptions[0].content']")
	private WebElement enterEnglishDescription1;

	/**
	 * Method to Enter English Description.
	 * 
	 * @throws IOException
	 */
	public void enterEnglishDescription1() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("Enter English Description");
		Assert.assertTrue(enterEnglishDescription1.isDisplayed());
		enterEnglishDescription1.sendKeys(sp.ExcelRead(sheetName).get(7));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.number']")
	private WebElement enterProductCode1;

	/**
	 * Method to Enter Product Code.
	 * 
	 * @throws IOException
	 */
	public void enterProductCode1() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("Enter Product Code");
		Assert.assertTrue(enterProductCode1.isDisplayed());
		enterProductCode1.sendKeys(sp.ExcelRead(sheetName).get(8));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.rate']")
	private WebElement enterProducteRate1;

	/**
	 * Method to Enter product Rate.
	 * 
	 * @throws IOException
	 */
	public void enterProducteRate1() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("Enter product Rate");
		Assert.assertTrue(enterProducteRate1.isDisplayed());
		enterProducteRate1.sendKeys(sp.ExcelRead(sheetName).get(9));

	}

	@FindBy(how = How.XPATH, using = "//*[@id='dependency']/div[1]/a/span")
	private WebElement clickDependenciesPlus;

	/**
	 * Method to click on Dependencies plus icon.
	 * 
	 * @throws IOException
	 */
	public void clickDependenciesPlus() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("click on Dependencies plus icon");
		Assert.assertTrue(clickDependenciesPlus.isDisplayed());
		clickDependenciesPlus.click();
		JavaScriptExec.sleep();
	}

	private WebElement selectProductCategoryDependency;

	/**
	 * Method to select product category in dependencies section.
	 * 
	 * @throws IOException
	 */
	public void selectProductCategoryDependency() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		WebElement PCelement = driver.findElement(By.xpath("//select[@name='product.dependencyItemTypes']"));
		Select se = new Select(PCelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(10));

	}

	private WebElement selectProductDependency;

	/**
	 * Method to select product in dependencies section.
	 * 
	 * @throws IOException
	 */
	public void selectProductDependency() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		JavaScriptExec.sleep();
		driver.findElement(By.xpath("//*[@id='product.dependencyItems']/option[2]")).click();

	}

	private WebElement selectProductPeriod;

	/**
	 * Method to select product period in dependencies section.
	 * 
	 * @throws IOException
	 */
	public void selectProductPeriod() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		WebElement Productelement = driver.findElement(By.xpath("//select[@name='period']"));
		Select se = new Select(Productelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(12));

	}

	@FindBy(how = How.XPATH, using = "//*[@id='dependency']/div[2]/div/table/tbody/tr/td[6]/a/img")
	private WebElement clickDependencyPlusIcon;

	/**
	 * Method to click on dependency plus icon to add the product.
	 * 
	 * @throws IOException
	 */
	public void clickDependencyPlusIcon() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("click on dependency plus icon to add the product.");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickDependencyPlusIcon.isDisplayed());
		clickDependencyPlusIcon.click();
		JavaScriptExec.scrollToElementOnPage(driver, clickDependencyPlusIcon);
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickSaveChangesButton() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("Click on Save Changes Button");
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		clickSaveChangesButton.click();

	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu.link.customers']/a")
	private WebElement clickCustomersTab;

	/**
	 * Method to click on customers tab.
	 * 
	 * @throws IOException
	 */
	public void clickCustomersTab() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("click on customers tab.");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickCustomersTab.isDisplayed());
		clickCustomersTab.click();

	}

	/**
	 * Method to click on a customer.
	 * 
	 * @throws IOException
	 */
	public void clickCustomerA() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("click on a customer.");
		String CustomerName = sp.ExcelRead(sheetName).get(13);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']")).click();
		JavaScriptExec.sleep();
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='filters.CUSTOMER-LIKE_UserName.stringValue']")
	private WebElement enterCustomerNameFilter;

	/**
	 * Method to enter the customer name in the Login name Filter.
	 * 
	 * @throws IOException
	 */
	public void enterCustomerNameFilter() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("Enter the name of the Customer in the Filte Login name");
		Assert.assertTrue(enterCustomerNameFilter.isDisplayed());
		enterCustomerNameFilter.sendKeys(sp.ExcelRead(sheetName).get(13));
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
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("Click on Apply Filter");
		Assert.assertTrue(applyFilter.isDisplayed());
		applyFilter.click();
		JavaScriptExec.sleep();
	}


	@FindBy(how = How.XPATH, using = "//a[@class='submit order']//*[text()='Create Order']")
	private WebElement clickCreateOrderButton;

	/**
	 * Method to click on create order button.
	 * 
	 * @throws IOException
	 */
	public void clickCreateOrderButton() throws IOException {
		JavaScriptExec.scrollToElementOnPage(driver, clickCreateOrderButton);
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("click on create order button.");
		Assert.assertTrue(clickCreateOrderButton.isDisplayed());
		clickCreateOrderButton.click();
		JavaScriptExec.sleep();
	}

	private WebElement selectOrderPeriod;

	/**
	 * Method to select order period.
	 * 
	 * @throws IOException
	 */
	public void selectOrderPeriod() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		WebElement Periodelement = driver.findElement(By.xpath("//select[@name='period']"));
		Select se = new Select(Periodelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(14));

	}

	private WebElement selectOrderType;

	/**
	 * Method to select order type.
	 * 
	 * @throws IOException
	 */
	public void selectOrderType() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		WebElement OrderTypeelement = driver.findElement(By.xpath("//select[@name='billingTypeId']"));
		Select se = new Select(OrderTypeelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(15));

	}

	@FindBy(how = How.XPATH, using = "//*[@id='ui-id-8']")
	private WebElement clickProductsSubTab;

	/**
	 * Method to click on products sub tab.
	 * 
	 * @throws IOException
	 */
	public void clickProductsSubTab() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("click on products sub tab.");
		Assert.assertTrue(clickProductsSubTab.isDisplayed());
		clickProductsSubTab.click();
		JavaScriptExec.sleep();

	}

	private WebElement selectProductsSubTab;

	/**
	 * Method to select a products sub tab.
	 * 
	 * @throws IOException
	 */
	public void selectProductsSubTab() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("select a products sub tab.");
		String ProductName = sp.ExcelRead(sheetName).get(16);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']")).click();
		JavaScriptExec.sleep();
	}

	private WebElement verifyWarningMsg;

	/**
	 * Method to verify warning message.
	 * 
	 * @throws IOException
	 */
	public void verifyWarningMsg() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("verify warning message.");
		JavaScriptExec.sleep();
		String ExpectedMsg = sp.ExcelRead(sheetName).get(17);
		String ActualMsg = driver.findElement(By.xpath("//*[@id='messages']/div/ul/li")).getText();
		Assert.assertEquals(ActualMsg, ExpectedMsg);

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Dependency']")
	private WebElement clickDependencyButton;

	/**
	 * Method to click on dependency button.
	 * 
	 * @throws IOException
	 */
	public void clickDependencyButton() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("click on dependency button.");
		Assert.assertTrue(clickDependencyButton.isDisplayed());
		clickDependencyButton.click();
		JavaScriptExec.sleep();

	}

	// @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Local
	// Minutes']")
	private WebElement clickDependentProduct;

	/**
	 * Method to click on dependent product.
	 * 
	 * @throws IOException
	 */
	public void clickDependentProduct() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("click on dependenct product.");
		String DependentProduct = sp.ExcelRead(sheetName).get(18);
		driver.findElement(By.xpath("//a[not(@href)]/strong[text()='" + DependentProduct + "']")).click();
	}

	@FindBy(how = How.XPATH, using = "//button[@id='currentOrder']")
	private WebElement clickCurrentOrderButton;

	/**
	 * Method to click on Current Order button.
	 * 
	 * @throws IOException
	 */
	public void clickCurrentOrderButton() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("click on Current Order button.");
		Assert.assertTrue(clickCurrentOrderButton.isDisplayed());
		clickCurrentOrderButton.click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//a//following::span[text()='Update'][2]")
	private WebElement clickUpdateButton;

	/**
	 * Method to click on Update button.
	 * 
	 * @throws IOException
	 */
	public void clickUpdateButton() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("click on Update button.");
		Assert.assertTrue(clickUpdateButton.isDisplayed());
		clickUpdateButton.click();
		JavaScriptExec.sleep();

	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}

}
