package specificPricing;

import baseClassPackage.BasePage;
import specificPricing.CreateRateCardPage;
import specificPricing.CreateRateCardPage;
import productDependency.CreateOrderPeriodPage;
import java.io.IOException;
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
import webDataPages.LoginPage;

import org.openqa.selenium.support.ui.Select;

public class CreateRateCardPage extends BasePage {
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public CreateRateCardPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(CreateOrderPeriodPage.class);
	CreateOrderPeriodPage configurationOrderPeriodsPage;
	PropertyValExtractors p = new PropertyValExtractors();
	Actions actions = new Actions(driver);
	String sheetName = "RateCard & Pricing";
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
		
		public void clickRateCards() throws IOException {
			CreateRateCardPage sp = new CreateRateCardPage(driver);
			log.info("Click on Rate Cards");
			p.getPropertyFile("test", "configuration.properties");
			String url = p.getVal("url2") + "/rateCard/list";
			driver.get(url);
			JavaScriptExec.sleep();
		}
		
		@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add New']")
		private WebElement clickAddNewButton;

		/**
		 * Method to click on Add New Button.
		 * 
		 * @throws IOException
		 */
		public void clickAddNewButton() throws IOException {
			CreateRateCardPage sp = new CreateRateCardPage(driver);
			log.info("Click on Add New");
			Assert.assertTrue(clickAddNewButton.isDisplayed());
			clickAddNewButton.click();
			JavaScriptExec.sleep();
		}
		
		@FindBy(how = How.XPATH, using = "//input[@name='name']")
		private WebElement enterRateCardName;

		/**
		 * Method to enter Description.
		 * 
		 * @throws IOException
		 */
		public void enterRateCardName(int column) throws IOException {
			CreateRateCardPage sp = new CreateRateCardPage(driver);
			log.info("Verifying the Description is available or not");
			Assert.assertTrue(enterRateCardName.isDisplayed());
			enterRateCardName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 3, column));
			
		}
		
		
		
		@FindBy(how = How.XPATH, using = "//input[@name='priceFieldName']")
		private WebElement enterPriceColumn;

		/**
		 * Method to enter Description.
		 * 
		 * @throws IOException
		 */
		public void enterPriceColumn() throws IOException {
			CreateRateCardPage sp = new CreateRateCardPage(driver);
			log.info("Verifying the Description is available or not");
			Assert.assertTrue(enterPriceColumn.isDisplayed());
			enterPriceColumn.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, 0));
		}
		@FindBy(how = How.XPATH, using = "//input[@name='rates']")
		private WebElement uploadRatingCSVFile;

		/**
		 * Method to enter Description.
		 * 
		 * @throws IOException
		 */
		
	public void uploadRatingCSVFile(int rowNum) throws IOException {
		CreateRateCardPage sp = new CreateRateCardPage(driver);
		log.info("upload Rating csv file");
		uploadRatingCSVFile.sendKeys(System.getProperty("user.dir") + BasePage.getCellData(xlsxName, sheetName, 10, rowNum));
		
	}
		
		@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
		private WebElement clickSaveChangesButton;

		/**
		 * Method to click on Save Changes Button.
		 * 
		 * @throws IOException
		 */
		public void clickSaveChangesButton() throws IOException {
			CreateRateCardPage sp = new CreateRateCardPage(driver);
			log.info("Click on Save Changes Button");
			JavaScriptExec.scrolltoBottomofPage(driver);
			Assert.assertTrue(clickSaveChangesButton.isDisplayed());
			clickSaveChangesButton.click();
		}
	
	public void selectRateCard(int rowNum) throws IOException {
		CreateRateCardPage sp = new CreateRateCardPage(driver);
		String RateCardName = BasePage.getCellData(xlsxName, sheetName, 3, rowNum);
		WebElement selectRateCard = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + RateCardName + "']"));
		actions.moveToElement(selectRateCard).click().perform();
		JavaScriptExec.sleep();
	}
	
	@FindBy(how = How.XPATH, using = "//*[text()='Edit']")
	private WebElement clickEdit;

	/**
	 * Method to click on Edit Button.
	 * 
	 * @throws IOException
	 */
	public void clickEdit() throws IOException {
		CreateRateCardPage sp = new CreateRateCardPage(driver);
		log.info("Click on Edit Button");
		navigateBottom();
		Assert.assertTrue(clickEdit.isDisplayed());
		clickEdit.click();
		JavaScriptExec.sleep();
	}
	
	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//select[@name='consumptionUnitId']")
	private WebElement consumptionUnit;
 	/**
	 * Method to select Rate Consumption Unit
	 * 
	 * @throws IOException
	 */
	public void consumptionUnit() throws IOException {
		CreateRateCardPage sp = new CreateRateCardPage(driver);
		Select se = new Select(consumptionUnit);
		se.selectByVisibleText("Units");
	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='chargeProductConsumptionTypeId']")
	private WebElement rateCardRateConsumptionUnit;

	/**
	 * Method to select Rate Consumption Unit
	 * 
	 * @throws IOException
	 */
	public void rateCardRateConsumptionUnit() throws IOException {
		CreateRateCardPage sp = new CreateRateCardPage(driver);
		Select se = new Select(rateCardRateConsumptionUnit);
		se.selectByVisibleText("Units");
	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='mediatedUnitConsumptionTypeId']")
	private WebElement mediatedQuantityConsumptionUnit;

	/**
	 * Method to select Quantity Consumption Unit
	 * 
	 * @throws IOException
	 */
	public void mediatedQuantityConsumptionUnit() throws IOException {
		CreateRateCardPage sp = new CreateRateCardPage(driver);
		Select se = new Select(mediatedQuantityConsumptionUnit);
		se.selectByVisibleText("Units");
	}

	public void verifyRateCardData(int rowNum) throws IOException {
		String actualRateCardName = BasePage.getCellData(xlsxName, sheetName, 3, rowNum);
		String expectedRateCardName = driver.findElement(By.xpath("//*[@id='column2']/div/div[2]/fieldset/div/div[1]/span"))
				.getText();
		System.out.println(expectedRateCardName);
		Assert.assertEquals(actualRateCardName, expectedRateCardName);
		
		String actualRateCardCSV = BasePage.getCellData(xlsxName, sheetName, 9, rowNum);
		String expectedRateCardCSV = driver.findElement(By.xpath("//*[@id='column2']/div/div[2]/fieldset/div/div[2]/span"))
				.getText();
		System.out.println(expectedRateCardCSV);
		Assert.assertEquals(actualRateCardCSV, expectedRateCardCSV);
	}
	
}

