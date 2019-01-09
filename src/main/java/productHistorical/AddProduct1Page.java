package productHistorical;

import baseClassPackage.BasePage;
import categoryProducts.AddProductPage;
import categoryProducts.AddProductWithAssetPage;
import categoryProducts.ProductCategoryPage;
import companyHierarchy.ViewAssignedInfoPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import utilPackages.JavaScriptExec;
import utilPackages.PropertyValExtractors;
import utilPackages.WaitClass;
import webDataPages.ImpersonatePage;
import webDataPages.SignupChildCompanyInvoiceAsSellerPage;

import org.openqa.selenium.support.ui.Select;

public class AddProduct1Page extends BasePage  {
	
	public AddProduct1Page(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(AddProduct1Page.class);

	PropertyValExtractors p = new PropertyValExtractors();
	Actions actions = new Actions(driver);
	String sheetName = "AddProductCategory1";
	String xlsxName = "/ProductHistorical_TestData.xlsx";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws Exception
	 */
	public void enterLoginID() throws Exception {
		AddProduct1Page sp = new AddProduct1Page(driver);

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
		AddProduct1Page sp = new AddProduct1Page(driver);
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
		AddProduct1Page sp = new AddProduct1Page(driver);
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
		AddProduct1Page sp = new AddProduct1Page(driver);
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
		AddProduct1Page sp = new AddProduct1Page(driver);
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
		AddProduct1Page sp = new AddProduct1Page(driver);
		log.info("Click on Add Category Button");
		//navigateBottom();
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
		AddProduct1Page sp = new AddProduct1Page(driver);
		log.info("Enter Category Name");
		JavaScriptExec.sleep();
		Assert.assertTrue(enterCategoryName.isDisplayed());
		enterCategoryName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 3, 0));

	}

	@FindBy(how=How.XPATH, using="//*[@id='global-checkbox']")
    private WebElement clickGlobalCheckbox;
    /**
     * Method to click Global checkbox.
     * @throws IOException 
     */
    public void clickGlobalCheckbox() throws IOException{
        JavaScriptExec.sleep();
        Assert.assertTrue(clickGlobalCheckbox.isDisplayed());
        clickGlobalCheckbox.click(); 
    }

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickSaveChangesButton() throws IOException {
		AddProduct1Page sp = new AddProduct1Page(driver);
		log.info("Click on Save Changes Button");
		navigateBottom();
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		clickSaveChangesButton.click();

	}
	
	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add Product']")
	private WebElement clickAddProductButton;

	/**
	 * Method to click on Add Product Button".
	 * 
	 * @throws IOException
	 */
	public void clickAddProductButton() throws IOException {
		AddProduct1Page sp = new AddProduct1Page(driver);
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
		AddProduct1Page sp = new AddProduct1Page(driver);
		log.info("Enter English Description");
		JavaScriptExec.sleep();
		Assert.assertTrue(enterEnglishDescription.isDisplayed());
		enterEnglishDescription.sendKeys(BasePage.getCellData(xlsxName, sheetName, 5, 0));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.number']")
	private WebElement enterProductCode;

	/**
	 * Method to Enter Product Code.
	 * 
	 * @throws IOException
	 */
	public void enterProductCode() throws IOException {
		AddProduct1Page sp = new AddProduct1Page(driver);
		log.info("Enter Product Code");
		JavaScriptExec.sleep();
		Assert.assertTrue(enterProductCode.isDisplayed());
		enterProductCode.sendKeys(BasePage.getCellData(xlsxName, sheetName, 5, 0));

	}
	private WebElement selectProductCompany1;

	/**
	 * Method to select companies.
	 * 
	 * @throws IOException
	 */
	public void selectProductCompany1() throws IOException {
		AddProduct1Page sp = new AddProduct1Page(driver);
		WebElement Companyelement = driver.findElement(By.xpath("//select[@name='product.entities']"));
		Select se = new Select(Companyelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 2, 0));

	}

	private WebElement selectProductCompany2;

	/**
	 * Method to select companies.
	 * 
	 * @throws IOException
	 */
	public void selectProductCompany2() throws IOException {
		AddProduct1Page sp = new AddProduct1Page(driver);
		WebElement Companyelement = driver.findElement(By.xpath("//select[@name='product.entities']"));
		Select se = new Select(Companyelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 4, 0));
		//navigateBottom();

	}
	
	public void selectHistoricalPriceForParent() throws IOException {
		AddProduct1Page sp = new AddProduct1Page(driver);
		for (int i = 0; i <= 8; i++) {
			WebElement enterPastPriceDate = driver.findElement(By.xpath("//*[@name=\"mydate\"]"));
			Assert.assertTrue(enterPastPriceDate.isDisplayed());
			enterPastPriceDate.clear();
			enterPastPriceDate.sendKeys(BasePage.getCellData(xlsxName, sheetName, 6, i));
			JavaScriptExec.sleep();

			WebElement Currencyelement = driver.findElement(By.xpath("//select[@name='product.currencies']"));
			Select se = new Select(Currencyelement);
			se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 7, i));
			JavaScriptExec.sleep();

			WebElement enterPriceRatePastUSD = driver.findElement(By.xpath("//input[@name='product.rate']"));
			Assert.assertTrue(enterPriceRatePastUSD.isDisplayed());
			enterPriceRatePastUSD.clear();
			enterPriceRatePastUSD.sendKeys(BasePage.getCellData(xlsxName, sheetName, 8, i));
			JavaScriptExec.sleep();

			WebElement clickAddPriceButton = driver
					.findElement(By.xpath("//a[@class='submit add']//*[text()='Add Price']"));
			Assert.assertTrue(clickAddPriceButton.isDisplayed());
			clickAddPriceButton.click();
		}

		}
		public void selectHistoricalPricesForChild() throws IOException {
			AddProduct1Page sp = new AddProduct1Page(driver);
			for (int i = 0; i <= 8; i++) {
				WebElement enterPastPriceDate = driver.findElement(By.xpath("//*[@name=\"mydate\"]"));
				Assert.assertTrue(enterPastPriceDate.isDisplayed());
				enterPastPriceDate.clear();
				enterPastPriceDate.sendKeys(BasePage.getCellData(xlsxName, sheetName, 6, i));
				JavaScriptExec.sleep();

				WebElement Companieselement = driver.findElement(By.xpath("//select[@name='product.entity']"));
				Select se = new Select(Companieselement);
				se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 4, 0));
				JavaScriptExec.sleep();
				
				WebElement Currencyelement = driver.findElement(By.xpath("//select[@name='product.currencies']"));
				Select sel = new Select(Currencyelement);
				sel.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 7, i));
				JavaScriptExec.sleep();

				WebElement enterPriceRatePastUSD = driver.findElement(By.xpath("//input[@name='product.rate']"));
				Assert.assertTrue(enterPriceRatePastUSD.isDisplayed());
				enterPriceRatePastUSD.clear();
				enterPriceRatePastUSD.sendKeys(BasePage.getCellData(xlsxName, sheetName, 9, i));
				JavaScriptExec.sleep();

				WebElement clickAddPriceButton = driver
						.findElement(By.xpath("//a[@class='submit add']//*[text()='Add Price']"));
				Assert.assertTrue(clickAddPriceButton.isDisplayed());
				clickAddPriceButton.click();

			}
	
	}
		public void navigateBottom() {
			JavaScriptExec.scrolltoBottomofPage(driver);
			JavaScriptExec.sleep();
		}
}


