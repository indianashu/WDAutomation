package categoryProducts;

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

public class AddProductPage extends BasePage {
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public AddProductPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(AddProductPage.class);
	AddProductPage addProductPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "AddProduct";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		AddProductPage sp = new AddProductPage(driver);

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
		AddProductPage sp = new AddProductPage(driver);
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
		AddProductPage sp = new AddProductPage(driver);
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
		AddProductPage sp = new AddProductPage(driver);
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
		AddProductPage sp = new AddProductPage(driver);
		log.info("Click on Products Tab after successful login");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickProductsTab.isDisplayed());
		clickProductsTab.click();

	}

	// @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='New Test
	// Category1']")
	private WebElement selectCategoryName;

	/**
	 * Method to click on a category name.
	 * 
	 * @throws IOException
	 */
	public void selectCategoryName() throws IOException {
		AddProductPage sp = new AddProductPage(driver);
		log.info("Click on a category name.");
		String CategoryName = sp.ExcelRead(sheetName).get(3);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CategoryName + "']")).click();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add Product']")
	private WebElement clickAddProductButton;

	/**
	 * Method to click on Add Product Button".
	 * 
	 * @throws IOException
	 */
	public void clickAddProductButton() throws IOException {
		AddProductPage sp = new AddProductPage(driver);
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
	public void enterEnglishDescription() throws IOException {
		AddProductPage sp = new AddProductPage(driver);
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
		AddProductPage sp = new AddProductPage(driver);
		log.info("Enter Product Code");
		Assert.assertTrue(enterProductCode.isDisplayed());
		enterProductCode.sendKeys(sp.ExcelRead(sheetName).get(5));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.standardAvailability']")
	private WebElement selectStandardAvailability;

	/**
	 * Method to Uncheck Standard Availability Checkbox.
	 * 
	 * @throws IOException
	 */
	public void selectStandardAvailability() throws IOException {
		AddProductPage sp = new AddProductPage(driver);
		log.info("Uncheck Standard Availability Checkbox");
		Assert.assertTrue(selectStandardAvailability.isDisplayed());
		selectStandardAvailability.click();
	}

	private WebElement selectAvailableAccountTypes;

	/**
	 * Method to select Available Account Types.
	 * 
	 * @throws IOException
	 */
	public void selectAvailableAccountTypes() throws IOException {
		AddProductPage sp = new AddProductPage(driver);
		WebElement Accountelement = driver.findElement(By.xpath("//select[@name='product.accountTypes']"));
		Select se = new Select(Accountelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(6));

	}

	private WebElement selectCompanies;

	/**
	 * Method to select companies.
	 * 
	 * @throws IOException
	 */
	public void selectCompanies() throws IOException {
		AddProductPage sp = new AddProductPage(driver);
		WebElement Companieselement = driver.findElement(By.xpath("//select[@name='product.entities']"));
		Select se = new Select(Companieselement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(7));

	}

	@FindBy(how = How.XPATH, using = "//*[@name=\"mydate\"]")
	private WebElement enterPriceDate;

	/**
	 * Method to Enter Price Date.
	 * 
	 * @throws IOException
	 */
	public void enterPriceDate() throws IOException {
		AddProductPage sp = new AddProductPage(driver);
		log.info("Enter Price Date");
		Assert.assertTrue(enterPriceDate.isDisplayed());
		enterPriceDate.clear();
		SimpleDateFormat DtFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        enterPriceDate.sendKeys(DtFormat.format(date).toString());

	}

	private WebElement selectPriceCompany;

	/**
	 * Method to select company in Prices.
	 * 
	 * @throws IOException
	 */
	public void selectPriceCompany() throws IOException {
		AddProductPage sp = new AddProductPage(driver);
		WebElement Companieselement = driver.findElement(By.xpath("//select[@name='product.entity']"));
		Select se = new Select(Companieselement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(9));

	}

	private WebElement selectPriceCurrency;

	/**
	 * Method to select price currency.
	 * 
	 * @throws IOException
	 */
	public void selectPriceCurrency() throws IOException {
		AddProductPage sp = new AddProductPage(driver);
		WebElement Currencyelement = driver.findElement(By.xpath("//select[@name='product.currencies']"));
		Select se = new Select(Currencyelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(10));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.rate']")
	private WebElement enterPriceRate;

	/**
	 * Method to Enter Price Rate.
	 * 
	 * @throws IOException
	 */
	public void enterPriceRate() throws IOException {
		AddProductPage sp = new AddProductPage(driver);
		log.info("Enter Price Rate");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, enterPriceRate);
		Assert.assertTrue(enterPriceRate.isDisplayed());
		enterPriceRate1.clear();
		enterPriceRate.sendKeys(sp.ExcelRead(sheetName).get(11));

	}

	@FindBy(how = How.XPATH, using = "//*[@name=\"mydate\"]")
	private WebElement enterPriceDate1;

	/**
	 * Method to Uncheck Standard Availability Checkbox.
	 * 
	 * @throws IOException
	 */
	public void enterPriceDate1() throws IOException {
		AddProductPage sp = new AddProductPage(driver);
		log.info("Uncheck Standard Availability Checkbox");
		Assert.assertTrue(enterPriceDate1.isDisplayed());
		enterPriceDate1.clear();
		enterPriceDate1.sendKeys(sp.ExcelRead(sheetName).get(12));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.rate']")
	private WebElement enterPriceRate1;

	/**
	 * Method to Enter Price Rate.
	 * 
	 * @throws IOException
	 */
	public void enterPriceRate1() throws IOException {
		AddProductPage sp = new AddProductPage(driver);
		log.info("Enter Price Rate");
		Assert.assertTrue(enterPriceRate1.isDisplayed());
		enterPriceRate1.clear();
		enterPriceRate1.sendKeys(sp.ExcelRead(sheetName).get(15));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add Price']")
	private WebElement clickAddPriceButton;

	/**
	 * Method to click on Add Price Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddPriceButton() throws IOException {
		AddProductPage sp = new AddProductPage(driver);
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
		AddProductPage sp = new AddProductPage(driver);
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
		AddProductPage sp = new AddProductPage(driver);
		log.info("Verifying if Product is created Successfully or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyConfirmationMsg.isDisplayed(),
				"Assert Failed as its unable to search text in Logged in Page");
	}

	//////////////////////////////////////////////////////////////////////

	@FindBy(how = How.XPATH, using = "//input[@name='product.descriptions[0].content']")
	private WebElement enterEnglishDescription3;

	/**
	 * Method to Enter English Description.
	 * 
	 * @throws IOException
	 */
	public void enterEnglishDescription3() throws IOException {
		AddProductPage sp = new AddProductPage(driver);
		log.info("Enter English Description");
		Assert.assertTrue(enterEnglishDescription3.isDisplayed());
		enterEnglishDescription3.sendKeys(sp.ExcelRead(sheetName).get(16));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.number']")
	private WebElement enterProductCode3;

	/**
	 * Method to Enter Product Code.
	 * 
	 * @throws IOException
	 */
	public void enterProductCode3() throws IOException {
		AddProductPage sp = new AddProductPage(driver);
		log.info("Enter Product Code");
		Assert.assertTrue(enterProductCode3.isDisplayed());
		enterProductCode3.sendKeys(sp.ExcelRead(sheetName).get(17));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.rate']")
	private WebElement enterPriceRate3;

	/**
	 * Method to Enter Price Rate.
	 * 
	 * @throws IOException
	 */
	public void enterPriceRate3() throws IOException {
		AddProductPage sp = new AddProductPage(driver);
		log.info("Enter Price Rate");
		Assert.assertTrue(enterPriceRate3.isDisplayed());
		enterPriceRate3.clear();
		enterPriceRate3.sendKeys(sp.ExcelRead(sheetName).get(19));

	}

	// @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Test
	// Abc']")
	private WebElement clickProductName;

	/**
	 * Method to click on Product name Test Code.
	 * 
	 * @throws IOException
	 */
	public void clickProductName() throws IOException {
		AddProductPage sp = new AddProductPage(driver);
		log.info("Click on Product Name Test Code");
		JavaScriptExec.sleep();
		String ProductName = sp.ExcelRead(sheetName).get(16);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']")).click();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit edit']//*[text()='Edit']")
	private WebElement clickEditProduct;

	/**
	 * Method to Click Edit button.
	 * 
	 * @throws IOException
	 */
	public void clickEditProduct() throws IOException {
		JavaScriptExec.scrollToElementOnPage(driver, clickEditProduct);
		AddProductPage sp = new AddProductPage(driver);
		log.info("Enter Edit Button");
		Assert.assertTrue(clickEditProduct.isDisplayed());
		clickEditProduct.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.descriptions[0].content']")
	private WebElement editEnglishDescription;

	/**
	 * Method to Edit English Description.
	 * 
	 * @throws IOException
	 */
	public void editEnglishDescription() throws IOException {
		AddProductPage sp = new AddProductPage(driver);
		log.info("Edit English Description");
		Assert.assertTrue(editEnglishDescription.isDisplayed());
		editEnglishDescription.clear();
		editEnglishDescription.sendKeys(sp.ExcelRead(sheetName).get(20));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.number']")
	private WebElement editProductCode;

	/**
	 * Method to Edit Product Code.
	 * 
	 * @throws IOException
	 */
	public void editProductCode() throws IOException {
		AddProductPage sp = new AddProductPage(driver);
		log.info("Edit Product Code");
		Assert.assertTrue(editProductCode.isDisplayed());
		editProductCode.clear();
		editProductCode.sendKeys(sp.ExcelRead(sheetName).get(21));
	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}

}
