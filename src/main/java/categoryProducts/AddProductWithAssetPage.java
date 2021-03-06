package categoryProducts;

import baseClassPackage.BasePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utilPackages.JavaScriptExec;
import utilPackages.PropertyValExtractors;
import utilPackages.StaleException;
import utilPackages.WaitClass;
import webDataPages.LoginPage;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Ashutosh
 *
 */

public class AddProductWithAssetPage extends BasePage {
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public AddProductWithAssetPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(AddProductWithAssetPage.class);
	AddProductWithAssetPage addProductWithAssetPage;
	PropertyValExtractors p = new PropertyValExtractors();
	Actions actions = new Actions(driver);
	String sheetName = "AddProductWithAsset";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		AddProductWithAssetPage sp = new AddProductWithAssetPage(driver);

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
		AddProductWithAssetPage sp = new AddProductWithAssetPage(driver);
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
		AddProductWithAssetPage sp = new AddProductWithAssetPage(driver);
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
		AddProductWithAssetPage sp = new AddProductWithAssetPage(driver);
		log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
		Assert.assertTrue(clickLoginButton.isDisplayed());
		clickLoginButton.click();
	}

	@FindBy(how = How.XPATH, using = "//a[.='Plug-ins']")
	private WebElement clickPluginsLink;

	/**
	 * Method to click on Plugins Link.
	 * 
	 * @throws IOException
	 */
	public void clickPluginsLink() throws IOException {
		AddProductWithAssetPage sp = new AddProductWithAssetPage(driver);
		log.info("Click on Plugins Link.");
		JavaScriptExec.sleep();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url2") + "/plugin/list";
		driver.get(url);
	}

	@FindBy(how = How.XPATH, using = "//td[preceding-sibling::td[contains(.,'17')]]")
	private WebElement clickCategory17;

	/**
	 * Method to click on Category 17 - Generic internal events listener.
	 * 
	 * @throws IOException
	 */
	public void clickCategory17() throws IOException {
		AddProductWithAssetPage sp = new AddProductWithAssetPage(driver);
		log.info("click on Category 17 - Generic internal events listener.");
		Assert.assertTrue(clickCategory17.isDisplayed());
		clickCategory17.click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add New']")
	private WebElement clickAddNewButton;

	/**
	 * Method to click on Add New button.
	 * 
	 * @throws IOException
	 */
	public void clickAddNewButton() throws IOException {
		AddProductWithAssetPage sp = new AddProductWithAssetPage(driver);
		log.info("click on Add New Button.");
		Assert.assertTrue(clickAddNewButton.isDisplayed());
		clickAddNewButton.click();
		JavaScriptExec.sleep();
	}

	private WebElement selectTypeId;

	/**
	 * Method to select Type ID.
	 * 
	 * @throws IOException
	 */
	public void selectTypeId() throws IOException {
		AddProductWithAssetPage sp = new AddProductWithAssetPage(driver);
		WebElement TypeIDelement = driver.findElement(By.xpath("//select[@name='typeId']"));
		Select se = new Select(TypeIDelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(3));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='processingOrder']")
	private WebElement enterProcessingOrder;

	/**
	 * Method to enter processing order.
	 * 
	 * @throws IOException
	 */
	public void enterProcessingOrder() throws IOException {
		AddProductWithAssetPage sp = new AddProductWithAssetPage(driver);
		log.info("Enter Processing Order.");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, enterProcessingOrder);
		Assert.assertTrue(enterProcessingOrder.isDisplayed());
		enterProcessingOrder.clear();
		enterProcessingOrder.sendKeys(sp.ExcelRead(sheetName).get(4));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Plug-in']")
	private WebElement clickSavePluginButton;

	/**
	 * Method to Click on Save Plugin Button.
	 * 
	 * @throws IOException
	 */
	public void clickSavePluginButton() throws IOException {
		AddProductWithAssetPage sp = new AddProductWithAssetPage(driver);
		log.info("Click on Save Plugin Button.");
		Assert.assertTrue(clickSavePluginButton.isDisplayed());
		clickSavePluginButton.click();

	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu.link.products']/a")
	private WebElement clickProductsTab;

	/**
	 * Method to click on Products tab after successful login.
	 * 
	 * @throws IOException
	 */
	public void clickProductsTab() throws IOException {
		AddProductWithAssetPage sp = new AddProductWithAssetPage(driver);
		log.info("Click on Products Tab after successful login");
		Assert.assertTrue(clickProductsTab.isDisplayed());
		clickProductsTab.click();
		JavaScriptExec.sleep();
	}

	/**
	 * Method to click on a category name.
	 * 
	 * @throws IOException
	 */
	public void selectCategoryName() throws IOException {
		AddProductWithAssetPage sp = new AddProductWithAssetPage(driver);
		String CategoryName = sp.ExcelRead(sheetName).get(5);
		WebElement selectCategoryName = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CategoryName + "']"));
		actions.moveToElement(selectCategoryName).click(selectCategoryName).perform();
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
		JavaScriptExec.scrollToElementOnPage(driver, clickAddProductButton);
		AddProductWithAssetPage sp = new AddProductWithAssetPage(driver);
		log.info("Click on Add Product Button");
		//StaleException.retryingFindClick(By.xpath("//a[@class='submit add']//*[text()='Add Product']"), driver);
		actions.moveToElement(clickAddProductButton).click().perform();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.descriptions[0].content']")
	private WebElement enterEnglishDescription;

	/**
	 * Method to Enter English Description.
	 * 
	 * @throws IOException
	 */
	public void enterEnglishDescription() throws IOException {
		AddProductWithAssetPage sp = new AddProductWithAssetPage(driver);
		log.info("Enter English Description");
		Assert.assertTrue(enterEnglishDescription.isDisplayed());
		enterEnglishDescription.sendKeys(sp.ExcelRead(sheetName).get(6));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.number']")
	private WebElement enterProductCode;

	/**
	 * Method to Enter Product Code.
	 * 
	 * @throws IOException
	 */
	public void enterProductCode() throws IOException {
		AddProductWithAssetPage sp = new AddProductWithAssetPage(driver);
		log.info("Enter Product Code");
		Assert.assertTrue(enterProductCode.isDisplayed());
		enterProductCode.sendKeys(sp.ExcelRead(sheetName).get(7));
		

	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.assetManagementEnabled']")
	private WebElement selectAllowAssetManagement;

	/**
	 * Method to Check Allow Assest Management Checkbox.
	 * 
	 * @throws IOException
	 */
	public void selectAllowAssetManagement() throws IOException {
		AddProductWithAssetPage sp = new AddProductWithAssetPage(driver);
		log.info("Check Allow Assest Management Checkbox.");
		Assert.assertTrue(selectAllowAssetManagement.isDisplayed());
		
		if (!selectAllowAssetManagement.isSelected()) {
			selectAllowAssetManagement.click();
		}
		
	}

	@FindBy(how = How.XPATH, using = "//*[@id='global-checkbox']")
	private WebElement clickGlobalCheckbox;

	/**
	 * Method to click Global checkbox.
	 * 
	 * @throws IOException
	 */
	public void clickGlobalCheckbox() throws IOException {
		ProductCategoryPage sp = new ProductCategoryPage(driver);
		log.info("Click Allow Assest Mgmt checkbox");
		Assert.assertTrue(clickGlobalCheckbox.isDisplayed());
		clickGlobalCheckbox.click();
	}

	private WebElement selectPriceCompany;

	/**
	 * Method to select company in Prices.
	 * 
	 * @throws IOException
	 */
	public void selectPriceCompany() throws IOException {
		AddProductWithAssetPage sp = new AddProductWithAssetPage(driver);
		WebElement Companieselement = driver.findElement(By.xpath("//select[@name='product.entity']"));
		Select se = new Select(Companieselement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(8));

	}

	private WebElement selectPriceCurrency;

	/**
	 * Method to select price currency.
	 * 
	 * @throws IOException
	 */
	public void selectPriceCurrency() throws IOException {
		AddProductWithAssetPage sp = new AddProductWithAssetPage(driver);
		WebElement Currencyelement = driver.findElement(By.xpath("//select[@name='product.currencies']"));
		Select se = new Select(Currencyelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(9));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.rate']")
	private WebElement enterPriceRate;

	/**
	 * Method to Enter Price Rate.
	 * 
	 * @throws IOException
	 */
	public void enterPriceRate() throws IOException {
		AddProductWithAssetPage sp = new AddProductWithAssetPage(driver);
		log.info("Enter Price Rate");
		Assert.assertTrue(enterPriceRate.isDisplayed());
		enterPriceRate.sendKeys(sp.ExcelRead(sheetName).get(10));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add Price']")
	private WebElement clickAddPriceButton;

	/**
	 * Method to click on Add Price Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddPriceButton() throws IOException {
		AddProductWithAssetPage sp = new AddProductWithAssetPage(driver);
		log.info("Click on Add Price Button");
		Assert.assertTrue(clickAddPriceButton.isDisplayed());
		clickAddPriceButton.click();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickSaveChangesButton() throws IOException {
		AddProductWithAssetPage sp = new AddProductWithAssetPage(driver);
		log.info("Click on Save Changes Button");
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		clickSaveChangesButton.click();

	}

	// @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='SIM
	// Cards']")
	private WebElement clickProductName;

	/**
	 * Method to click on Product Name.
	 * 
	 * @throws IOException
	 */
	public void clickProductName() throws IOException {
		AddProductWithAssetPage sp = new AddProductWithAssetPage(driver);
		log.info("Click on Product Name");
		JavaScriptExec.sleep();
		String ProductName = sp.ExcelRead(sheetName).get(6);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']")).click();
		

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add Asset']")
	private WebElement clickAddAssetButton;

	/**
	 * Method to click on Add Asset Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddAssetButton() throws IOException {
		JavaScriptExec.scrollToElementOnPage(driver, clickAddAssetButton);
		AddProductWithAssetPage sp = new AddProductWithAssetPage(driver);
		log.info("Click on Add Asset Button");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickAddAssetButton.isDisplayed());
		clickAddAssetButton.click();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='identifier']")
	private WebElement enterIdentifier1;

	/**
	 * Method to enter value for Identifier.
	 * 
	 * @throws IOException
	 */
	public void enterIdentifier1() throws IOException {
		AddProductWithAssetPage sp = new AddProductWithAssetPage(driver);
		log.info("Enter value for Identifier");
		Assert.assertTrue(enterIdentifier1.isDisplayed());
		enterIdentifier1.sendKeys(sp.ExcelRead(sheetName).get(11));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='global']")
	private WebElement checkIsGlobal;

	/**
	 * Method to Check Is Global Checkbox.
	 * 
	 * @throws IOException
	 */
	public void checkIsGlobal() throws IOException {
		AddProductWithAssetPage sp = new AddProductWithAssetPage(driver);
		log.info("Check Is Global Checkbox.");
		Assert.assertTrue(checkIsGlobal.isDisplayed());
		checkIsGlobal.click();
		JavaScriptExec.sleep();
	}
	@FindBy(how=How.XPATH, using="//input[@class='field text']")
	private WebElement enterTaxID;

	/**
	 * Method to enter value for TaxID.
	 * 
	 * @throws IOException
	 */
	public void enterTaxID() throws IOException {
		AddProductWithAssetPage sp = new AddProductWithAssetPage(driver);
		log.info("Enter value for TaxID.");
		Assert.assertTrue(enterTaxID.isDisplayed());
		enterTaxID.sendKeys(sp.ExcelRead(sheetName).get(12));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='identifier']")
	private WebElement enterIdentifier2;

	/**
	 * Method to enter value for Identifier.
	 * 
	 * @throws IOException
	 */
	public void enterIdentifier2() throws IOException {
		AddProductWithAssetPage sp = new AddProductWithAssetPage(driver);
		log.info("Enter value for Identifier");
		Assert.assertTrue(enterIdentifier2.isDisplayed());
		enterIdentifier2.sendKeys(sp.ExcelRead(sheetName).get(13));

	}

	@FindBy(how=How.XPATH, using="//input[@class='field text']")
	private WebElement enterTaxID1;

	/**
	 * Method to enter value for TaxID.
	 * 
	 * @throws IOException
	 */
	public void enterTaxID1() throws IOException {
		AddProductWithAssetPage sp = new AddProductWithAssetPage(driver);
		log.info("Enter value for TaxID.");
		Assert.assertTrue(enterTaxID1.isDisplayed());
		enterTaxID1.sendKeys(sp.ExcelRead(sheetName).get(14));

	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}

}
