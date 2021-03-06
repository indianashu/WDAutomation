package rateCard;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import baseClassPackage.BasePage;
import specificPricing.CreateRateCardPage;
import utilPackages.JavaScriptExec;
import utilPackages.PropertyValExtractors;

public class CRUDRateCardPage extends BasePage {

	public CRUDRateCardPage(WebDriver driver) {
		super(driver);
	}

	Logger log = Logger.getLogger(CRUDRateCardPage.class);

	PropertyValExtractors p = new PropertyValExtractors();
	Actions actions = new Actions(driver);
	String sheetName = "CRUDRateCard";
	String xlsxName = "/RateCard_TestData.xlsx";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginName;

	public void enterLoginName() throws IOException {
		log.info("");
		Assert.assertTrue(enterLoginName.isDisplayed());
		enterLoginName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 0, 0));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='j_password']")
	private WebElement enterPassword;

	public void enterPassword() throws IOException {
		log.info("");
		Assert.assertTrue(enterPassword.isDisplayed());
		enterPassword.sendKeys(BasePage.getCellData(xlsxName, sheetName, 1, 0));
	}

	public void selectCompany() throws Exception {
		WebElement Companyelement = driver.findElement(By.xpath("//select[@name='j_client_id']"));
		Select se = new Select(Companyelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 2, 0));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']")
	private WebElement clickLoginButton;

	public void clickLoginButton() {
		log.info("Verifying the login button is available or not");
		Assert.assertTrue(clickLoginButton.isDisplayed());
		clickLoginButton.click();
	}

	@FindBy(how = How.XPATH, using = "//a[.='Rate Cards']")
	private WebElement selectRateCardConfig;

	public void selectRateCardConfig() {
		log.info("");
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url2") + "/rateCard/list";
		driver.get(url);
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add New']")
	private WebElement clickAddNewButton;

	public void clickAddNewButton() throws IOException {
		log.info("Click on Add New");
		Assert.assertTrue(clickAddNewButton.isDisplayed());
		clickAddNewButton.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//input[@id='name']")
	private WebElement enterRateCardName;

	/**
	 * Method to enter Description.
	 * 
	 * @throws IOException
	 */
	public void enterRateCardName(int row) throws IOException {
		CreateRateCardPage sp = new CreateRateCardPage(driver);
		log.info("Verifying the Description is available or not");
		Assert.assertTrue(enterRateCardName.isDisplayed());
		enterRateCardName.sendKeys(BasePage.getCellData(xlsxName, sheetName, row, 0));
		
	}

	@FindBy(how = How.XPATH, using = "//*[@id='priceFieldName']")
	private WebElement enterRateCardPrice;

	public void enterRateCardPrice() throws IOException {
		log.info("");
		Assert.assertTrue(enterRateCardPrice.isDisplayed());
		enterRateCardPrice.sendKeys("rate");
	}

	public void uploadRatingCSVFile() throws IOException {
		log.info("upload csv file");
		WebElement FileUpload = driver.findElement(By.xpath("//input[@name='rates']"));
		FileUpload.sendKeys(System.getProperty("user.dir") + "/RateCard_files/aRateCardTest.csv");
		JavaScriptExec.sleep();

	}

	public void selectRateCard() throws IOException {
		log.info("");
		String RateCard = BasePage.getCellData(xlsxName, sheetName, 4, 0);
		WebElement selectRateCard = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + RateCard + "']"));
		selectRateCard.click();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit edit']//*[text()='Edit']")
	private WebElement clickEditButton;

	public void clickEditButton() throws IOException {
		log.info("");
		Assert.assertTrue(clickEditButton.isDisplayed());
		clickEditButton.click();
		JavaScriptExec.sleep();
	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='chargeProductConsumptionTypeId']")
	private WebElement rateCardRateConsumptionUnit;
 	/**
	 * Method to select Rate Consumption Unit
	 * 
	 * @throws IOException
	 */
	public void rateCardRateConsumptionUnit() throws IOException {
		CRUDRateCardPage sp = new CRUDRateCardPage(driver);
		Select se = new Select(rateCardRateConsumptionUnit);
		se.selectByVisibleText("Units");
	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='consumptionUnitId']")
	private WebElement consumptionUnit;
 	/**
	 * Method to select Rate Consumption Unit
	 * 
	 * @throws IOException
	 */
	public void consumptionUnit() throws IOException {
		CRUDRateCardPage sp = new CRUDRateCardPage(driver);
		Select se = new Select(consumptionUnit);
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
		CRUDRateCardPage sp = new CRUDRateCardPage(driver);
		Select se = new Select(mediatedQuantityConsumptionUnit);
		se.selectByVisibleText("Units");
	}

	public void selectRateCardForDelete() throws IOException {
		log.info("");
		String RateCard = BasePage.getCellData(xlsxName, sheetName, 4, 0);
		WebElement selectRateCard = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + RateCard + "']"));
		selectRateCard.click();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit delete']//*[text()='Delete']")
	private WebElement clickDeleteButton;

	public void clickDeleteButton() throws IOException {
		log.info("");
		Assert.assertTrue(clickDeleteButton.isDisplayed());
		clickDeleteButton.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//button[text()='Yes']")
	private WebElement clickYesDeleteInvoicePopup;

	public void clickYesDeleteInvoicePopup() throws IOException {
		log.info("Click on Yes delete invoice/product popup.");
		Assert.assertTrue(clickYesDeleteInvoicePopup.isDisplayed());
		clickYesDeleteInvoicePopup.click();
		JavaScriptExec.sleep();
	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}
}
