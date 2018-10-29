package specificPricing;

import baseClassPackage.BasePage;
import specificPricing.CreateProductAndCategoryPage;
import specificPricing.CreateProductAndCategoryPage;
import productDependency.CreateOrderPeriodPage;
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
import webDataPages.LoginPage;
import org.openqa.selenium.support.ui.Select;

public class CreateProductAndCategoryPage extends BasePage {
	
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public CreateProductAndCategoryPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(CreateOrderPeriodPage.class);
	CreateOrderPeriodPage configurationOrderPeriodsPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "CreateCategory";
	String xlsxName = "/SpecificPricing_TestData.xlsx"; 
		
		@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
		private WebElement enterLoginID;

		/**
		 * Method to enter login ID.
		 * 
		 * @throws IOException
		 */
		public void enterLoginID() throws IOException {
			LoginPage sp = new LoginPage(driver);

			log.info("Enter Login ID for logging in.");
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
			LoginPage sp = new LoginPage(driver);
			log.info("Enter Password for login");
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
			LoginPage sp = new LoginPage(driver);
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
			CreateProductAndCategoryPage sp = new CreateProductAndCategoryPage(driver);
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
			CreateProductAndCategoryPage sp = new CreateProductAndCategoryPage(driver);
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
		public void enterCategoryName(int column) throws IOException {
			CreateProductAndCategoryPage sp = new CreateProductAndCategoryPage(driver);
			log.info("Enter Category Name");
			Assert.assertTrue(enterCategoryName.isDisplayed());
			enterCategoryName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 3,column));
		}
		
		@FindBy(how = How.XPATH, using = "//select[@name='orderLineTypeId']")
		private WebElement enterCategoryType;

		/**
		 * Method to Enter Category Name.
		 * 
		 * @throws IOException
		 */
		public void enterCategoryType() throws IOException {
			CreateProductAndCategoryPage sp = new CreateProductAndCategoryPage(driver);
			log.info("Enter Category Name");
			Assert.assertTrue(enterCategoryType.isDisplayed());
			enterCategoryType.sendKeys(BasePage.getCellData(xlsxName, sheetName, 7,1));
		}
		
		@FindBy(how = How.XPATH, using = "//select[@name='entities']")
		private WebElement selectEntity;

		/**
		 * Method to select companies.
		 * 
		 * @throws IOException
		 */
		public void selectEntity() throws IOException {
			CreateProductAndCategoryPage sp = new CreateProductAndCategoryPage(driver);
			Select se = new Select(selectEntity);
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
			CreateProductAndCategoryPage sp = new CreateProductAndCategoryPage(driver);
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
			CreateProductAndCategoryPage sp = new CreateProductAndCategoryPage(driver);
			log.info("Verifying if Product is created Successfully or not");
			JavaScriptExec.sleep();
			Assert.assertTrue(verifyConfirmationMsg.isDisplayed(),
					"Assert Failed as its unable to search text in Logged in Page");
		}
		
		public void selectCategoryName(int column) throws IOException {
			CreateProductAndCategoryPage sp = new CreateProductAndCategoryPage(driver);
			log.info("Click on a category name.");
			String CategoryName = BasePage.getCellData(xlsxName, sheetName, 3,column);
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
			CreateProductAndCategoryPage sp = new CreateProductAndCategoryPage(driver);
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
		public void enterEnglishDescription(int column) throws IOException {
			CreateProductAndCategoryPage sp = new CreateProductAndCategoryPage(driver);
			log.info("Enter English Description");
			Assert.assertTrue(enterEnglishDescription.isDisplayed());
			enterEnglishDescription.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, column));
		}

		@FindBy(how = How.XPATH, using = "//input[@name='product.number']")
		private WebElement enterProductCode;

		/**
		 * Method to Enter Product Code.
		 * 
		 * @throws IOException
		 */
		public void enterProductCode(int column) throws IOException {
			CreateProductAndCategoryPage sp = new CreateProductAndCategoryPage(driver);
			log.info("Enter Product Code");
			Assert.assertTrue(enterProductCode.isDisplayed());
			enterProductCode.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, column));
		}
		
		private WebElement selectPriceCompany;

		/**
		 * Method to select company in Prices.
		 * 
		 * @throws IOException
		 */
		public void selectPriceCompany() throws IOException {
			CreateProductAndCategoryPage sp = new CreateProductAndCategoryPage(driver);
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
			CreateProductAndCategoryPage sp = new CreateProductAndCategoryPage(driver);
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
		public void enterPriceRate(int column) throws IOException {
			CreateProductAndCategoryPage sp = new CreateProductAndCategoryPage(driver);
			log.info("Enter Price Rate");
			JavaScriptExec.sleep();
			Assert.assertTrue(enterPriceRate.isDisplayed());
			enterPriceRate.sendKeys(BasePage.getCellData(xlsxName, sheetName, 6, column));
		}

		@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add Price']")
		private WebElement clickAddPriceButton;

		/**
		 * Method to click on Add Price Button.
		 * 
		 * @throws IOException
		 */
		public void clickAddPriceButton() throws IOException {
			CreateProductAndCategoryPage sp = new CreateProductAndCategoryPage(driver);
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
		public void enterPlanProduct() throws IOException {
			CreateProductAndCategoryPage sp = new CreateProductAndCategoryPage(driver);
			log.info("Enter Plan Product");
			JavaScriptExec.sleep();
			Select dropdown1 = new Select(driver.findElement(By.name("product.confPricingProduct")));
			Assert.assertTrue(enterPlanProduct.isDisplayed());
			enterPlanProduct.sendKeys(BasePage.getCellData(xlsxName, sheetName, 11, 0));
		}
		
		@FindBy(how = How.XPATH, using = "//select[@name='product.confPricingList']")
		private WebElement enterPricing;

		/**
		 * Method to Enter .
		 * 
		 * @throws IOException
		 */
		public void enterPricing() throws IOException {
			CreateProductAndCategoryPage sp = new CreateProductAndCategoryPage(driver);
			log.info("Enter Pricing");
			JavaScriptExec.sleep();
			Select dropdown2 = new Select(driver.findElement(By.name("product.confPricingList")));
			Assert.assertTrue(enterPricing.isDisplayed());
			enterPricing.sendKeys(BasePage.getCellData(xlsxName, sheetName, 12, 0));
		}
		
		@FindBy(how = How.XPATH, using = "//*[@id='confPricingList']/div[2]/a/span")
		private WebElement clickOnAddPrice;

		/**
		 * Method to click on Add Price Button.
		 * 
		 * @throws IOException
		 */
		public void clickOnAddPrice() throws IOException {
			CreateProductAndCategoryPage sp = new CreateProductAndCategoryPage(driver);
			log.info("Click on Add Price Button");
			Assert.assertTrue(clickOnAddPrice.isDisplayed());
			clickOnAddPrice.click();
			navigateBottom();
		}
		
		public void verifyCategoryData(int column) throws IOException {
			String actualCategoryName = BasePage.getCellData(xlsxName, sheetName, 3, column);
			String expectedCategoryName = driver.findElement(By.xpath("//tbody//tr[1]//a[@class='cell double']/strong")).getText();
			System.out.println(expectedCategoryName);
			Assert.assertEquals(actualCategoryName, expectedCategoryName);
			
			String actualCategoryType = BasePage.getCellData(xlsxName, sheetName, 7, column);
			String expectedCategoryType = driver.findElement(By.xpath("//tbody//tr[1]//td[3]//a[@class='cell']/span"))
					.getText();
			System.out.println(expectedCategoryType);
			Assert.assertEquals(actualCategoryType, expectedCategoryType);
		}
		
	public void verifyProductData(int column) throws IOException {
		String actualProductName = BasePage.getCellData(xlsxName, sheetName, 4, column);

		String expectedProductName = driver
				.findElement(By.xpath("//table[@id='products']//tr[1]//a[@class='cell double']/strong")).getText();
		System.out.println(expectedProductName);
		Assert.assertEquals(actualProductName, expectedProductName);

		if (actualProductName == "Plan Pricing Product") {
			driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + actualProductName + "']")).click();
			JavaScriptExec.sleep();

			String expectedComponentPricesProduct = driver
					.findElement(By.xpath("//*[@id='column2']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[1]"))
					.getText();
			String actualComponentPricesProduct = BasePage.getCellData(xlsxName, sheetName, 4, 0);
			System.out.println(expectedComponentPricesProduct);
			Assert.assertEquals(actualComponentPricesProduct, expectedComponentPricesProduct);

			String expectedComponentPricePricing = driver
					.findElement(By.xpath("//*[@id='column2']/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[1]"))
					.getText();
			String actualComponentPricesPricing = BasePage.getCellData(xlsxName, sheetName, 8, 0);
			System.out.println(expectedComponentPricePricing);
			Assert.assertEquals(actualComponentPricesPricing, expectedComponentPricePricing);
		}

	}
	
		public void navigateBottom() {
			JavaScriptExec.scrolltoBottomofPage(driver);
			JavaScriptExec.sleep();

		}
		
}
