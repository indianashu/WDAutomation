package ProductDependency;

import baseClassPackage.BasePage;
import categoryProducts.AddProductPage;
import orderHierarchies.OrderHierarchiesPage;
import ProductDependency.CreateDependentProduct4Page;
import ProductDependency.CreateDependentProduct4Page;

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

public class CreateDependentProduct4Page extends BasePage {
	
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public CreateDependentProduct4Page(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(CreateDependentProduct4Page.class);
	CreateDependentProduct4Page addProductPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "AddProductcategory1";
	String xlsxName = "/ProductDependency_TestData.xlsx";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		CreateDependentProduct4Page sp = new CreateDependentProduct4Page(driver);

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
		CreateDependentProduct4Page sp = new CreateDependentProduct4Page(driver);
		log.info("Verifying the First Name is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, enterPassword);
		Assert.assertTrue(enterPassword.isDisplayed());
		enterPassword.sendKeys(BasePage.getCellData(xlsxName, sheetName, 1, 0));

	}

	private WebElement selectCompany;

	/**
	 * Method to select Company.
	 * 
	 * @throws IOException
	 */
	public void selectCompany() throws IOException {
		CreateDependentProduct4Page sp = new CreateDependentProduct4Page(driver);
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
		CreateDependentProduct4Page sp = new CreateDependentProduct4Page(driver);
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
		CreateDependentProduct4Page sp = new CreateDependentProduct4Page(driver);
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
		CreateDependentProduct4Page sp = new CreateDependentProduct4Page(driver);
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
		CreateDependentProduct4Page sp = new CreateDependentProduct4Page(driver);
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
		CreateDependentProduct4Page sp = new CreateDependentProduct4Page(driver);
		log.info("Enter English Description");
		Assert.assertTrue(enterEnglishDescription.isDisplayed());
		enterEnglishDescription.sendKeys(BasePage.getCellData(xlsxName, sheetName, 5, 6));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.number']")
	private WebElement enterProductCode;

	/**
	 * Method to Enter Product Code.
	 * 
	 * @throws IOException
	 */
	public void enterProductCode() throws IOException {
		CreateDependentProduct4Page sp = new CreateDependentProduct4Page(driver);
		log.info("Enter Product Code");
		Assert.assertTrue(enterProductCode.isDisplayed());
		enterProductCode.sendKeys(BasePage.getCellData(xlsxName, sheetName, 5, 6));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.standardAvailability']")
	private WebElement selectStandardAvailability;

	/**
	 * Method to Uncheck Standard Availability Checkbox.
	 * 
	 * @throws IOException
	 */
	public void selectStandardAvailability() throws IOException {
		CreateDependentProduct4Page sp = new CreateDependentProduct4Page(driver);
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
		CreateDependentProduct4Page sp = new CreateDependentProduct4Page(driver);
		WebElement Accountelement = driver.findElement(By.xpath("//select[@name='product.accountTypes']"));
		Select se = new Select(Accountelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 4, 0));

	}

	private WebElement selectCompanies;

	/**
	 * Method to select companies.
	 * 
	 * @throws IOException
	 */
	public void selectCompanies() throws IOException {
		CreateDependentProduct4Page sp = new CreateDependentProduct4Page(driver);
		WebElement Companieselement = driver.findElement(By.xpath("//select[@name='product.entities']"));
		Select se = new Select(Companieselement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 2, 0));

	}

	@FindBy(how = How.XPATH, using = "//*[@name=\"mydate\"]")
	private WebElement enterPriceDate;

	/**
	 * Method to Enter Price Date.
	 * 
	 * @throws IOException
	 */
	public void enterPriceDate() throws IOException {
		WebElement enterPastPriceDate = driver.findElement(By.xpath("//*[@name=\"mydate\"]"));
		Assert.assertTrue(enterPastPriceDate.isDisplayed());
		enterPastPriceDate.clear();
		enterPastPriceDate.sendKeys(BasePage.getCellData(xlsxName, sheetName, 6, 3));
		JavaScriptExec.sleep();

	}

	private WebElement selectPriceCompany;

	/**
	 * Method to select company in Prices.
	 * 
	 * @throws IOException
	 */
	public void selectPriceCompany() throws IOException {
		CreateDependentProduct4Page sp = new CreateDependentProduct4Page(driver);
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
		CreateDependentProduct4Page sp = new CreateDependentProduct4Page(driver);
		WebElement Currencyelement = driver.findElement(By.xpath("//select[@name='product.currencies']"));
		Select se = new Select(Currencyelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 7, 0));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.rate']")
	private WebElement enterPriceRate;

	/**
	 * Method to Enter Price Rate.
	 * 
	 * @throws IOException
	 */
	public void enterPriceRate() throws IOException {
		CreateDependentProduct4Page sp = new CreateDependentProduct4Page(driver);
		log.info("Enter Price Rate");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, enterPriceRate);
		Assert.assertTrue(enterPriceRate.isDisplayed());
		//enterPriceRate1.clear();
		enterPriceRate.sendKeys(BasePage.getCellData(xlsxName, sheetName, 8, 6));

}
	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add Price']")
	private WebElement clickAddPriceButton;

	/**
	 * Method to click on Add Price Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddPriceButton() throws IOException {
		CreateDependentProduct4Page sp = new CreateDependentProduct4Page(driver);
		log.info("Click on Add Price Button");
		Assert.assertTrue(clickAddPriceButton.isDisplayed());
		clickAddPriceButton.click();
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
		CreateDependentProduct4Page sp = new CreateDependentProduct4Page(driver);
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
		CreateDependentProduct4Page sp = new CreateDependentProduct4Page(driver);
		log.info("Verifying if Product is created Successfully or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyConfirmationMsg.isDisplayed(),
				"Assert Failed as its unable to search text in Logged in Page");
		navigateBottom();
	}
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='dependency']/div[1]/a/span")
	private WebElement clickDependenciesPlus;

	/**
	 * Method to click on Dependencies plus icon.
	 * 
	 * @throws IOException
	 */
	public void clickDependenciesPlus() throws IOException {
		CreateDependentProduct4Page sp = new CreateDependentProduct4Page(driver);
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
		CreateDependentProduct4Page sp = new CreateDependentProduct4Page(driver);
		WebElement PCelement = driver.findElement(By.xpath("//select[@name='product.dependencyItemTypes']"));
		Select se = new Select(PCelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 3, 0));

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
		//*[@id="product.dependencyItems"]/option[4]
		driver.findElement(By.xpath("//*[@id='product.dependencyItems']/option[4]")).click();
	}

	private WebElement selectProductPeriod;

	/**
	 * Method to select product period in dependencies section.
	 * 
	 * @throws IOException
	 */
	public void selectProductPeriod() throws IOException {
		CreateDependentProduct4Page sp = new CreateDependentProduct4Page(driver);
		WebElement Productelement = driver.findElement(By.xpath("//select[@name='period']"));
		Select se = new Select(Productelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 9, 6));

	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='product.dependencyMin']")
	
	//*[@id="product.dependencyMin"]
	private WebElement enterMin;

	/**
	 * Method to Enter Price Rate.
	 * 
	 * @throws IOException
	 */
	public void enterMin() throws IOException {
		CreateDependentProduct4Page sp = new CreateDependentProduct4Page(driver);
		log.info("Enter Min value");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, enterMin);
		Assert.assertTrue(enterPriceRate.isDisplayed());
		//enterPriceRate1.clear();
		enterMin.clear();
		enterMin.sendKeys(BasePage.getCellData(xlsxName, sheetName, 10, 6));

}
	@FindBy(how = How.XPATH, using = "//input[@id='product.dependencyMax']")
	private WebElement enterMax;

	/**
	 * Method to Enter Price Rate.
	 * 
	 * @throws IOException
	 */
	public void enterMax() throws IOException {
		CreateDependentProduct2Page sp = new CreateDependentProduct2Page(driver);
		log.info("Enter Max value");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, enterMin);
		Assert.assertTrue(enterMax.isDisplayed());
		//enterPriceRate1.clear();
		enterMax.clear();
		enterMax.sendKeys(BasePage.getCellData(xlsxName, sheetName, 11, 5));

}


	@FindBy(how = How.XPATH, using = "//*[@id='dependency']/div[2]/div/table/tbody/tr/td[6]/a/img")
	private WebElement clickDependencyPlusIcon;

	/**
	 * Method to click on dependency plus icon to add the product.
	 * 
	 * @throws IOException
	 */
	public void clickDependencyPlusIcon() throws IOException {
		CreateDependentProduct4Page sp = new CreateDependentProduct4Page(driver);
		log.info("click on dependency plus icon to add the product.");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickDependencyPlusIcon.isDisplayed());
		clickDependencyPlusIcon.click();
		JavaScriptExec.scrollToElementOnPage(driver, clickDependencyPlusIcon);
	}
	
	private WebElement selectProductCategoryDependency1;

	/**
	 * Method to select product category in dependencies section.
	 * 
	 * @throws IOException
	 */
	public void selectProductCategoryDependency1() throws IOException {
		CreateDependentProduct4Page sp = new CreateDependentProduct4Page(driver);
		WebElement PCelement = driver.findElement(By.xpath("//select[@name='product.dependencyItemTypes']"));
		Select se = new Select(PCelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 3, 0));

	}

	private WebElement selectProductDependency1;

	/**
	 * Method to select product in dependencies section.
	 * 
	 * @throws IOException
	 */
	public void selectProductDependency1() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		JavaScriptExec.sleep();
		//*[@id="product.dependencyItems"]/option[3]
		driver.findElement(By.xpath("//*[@id='product.dependencyItems']/option[3]")).click();
	}

	

	private WebElement selectProductPeriod1;

	/**
	 * Method to select product period in dependencies section.
	 * 
	 * @throws IOException
	 */
	public void selectProductPeriod1() throws IOException {
		CreateDependentProduct4Page sp = new CreateDependentProduct4Page(driver);
		WebElement Productelement = driver.findElement(By.xpath("//select[@name='period']"));
		Select se = new Select(Productelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 14, 6));

	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='product.dependencyMin']")
	
	//*[@id="product.dependencyMin"]
	private WebElement enterMin1;

	/**
	 * Method to Enter Price Rate.
	 * 
	 * @throws IOException
	 */
	public void enterMin1() throws IOException {
		CreateDependentProduct4Page sp = new CreateDependentProduct4Page(driver);
		log.info("Enter Min value");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, enterMin);
		Assert.assertTrue(enterPriceRate.isDisplayed());
		//enterPriceRate1.clear();
		enterMin.clear();
		enterMin.sendKeys(BasePage.getCellData(xlsxName, sheetName, 10, 6));

}
	@FindBy(how = How.XPATH, using = "//input[@id='product.dependencyMax']")
	private WebElement enterMax1;

	/**
	 * Method to Enter Price Rate.
	 * 
	 * @throws IOException
	 */
	public void enterMax1() throws IOException {
		CreateDependentProduct2Page sp = new CreateDependentProduct2Page(driver);
		log.info("Enter Max value");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, enterMin);
		Assert.assertTrue(enterMax.isDisplayed());
		//enterPriceRate1.clear();
		enterMax.clear();
		enterMax.sendKeys(BasePage.getCellData(xlsxName, sheetName, 15, 6));
	}

	
	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
}
}








