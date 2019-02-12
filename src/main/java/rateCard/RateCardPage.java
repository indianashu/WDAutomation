package rateCard;

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
import utilPackages.JavaScriptExec;
import utilPackages.PropertyValExtractors;

public class RateCardPage extends BasePage {

	public RateCardPage(WebDriver driver) {
		super(driver);
	}

	Logger log = Logger.getLogger(RateCardPage.class);
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "RateCard";
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
		JavaScriptExec.sleep();
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

	public void enterRateCardName(int i) throws IOException {
		log.info("");
		enterRateCardName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 3, i));
	}

	@FindBy(how = How.XPATH, using = "//*[@id='priceFieldName']")
	private WebElement enterRateCardPrice;

	public void enterRateCardPrice() throws IOException {
		log.info("");
		Assert.assertTrue(enterRateCardPrice.isDisplayed());
		enterRateCardPrice.sendKeys("rate");
	}

	public void uploadRatingCSVFile(int i) throws IOException {
		log.info("upload csv file");
		WebElement FileUpload = driver.findElement(By.xpath("//input[@name='rates']"));
		FileUpload.sendKeys(System.getProperty("user.dir") + BasePage.getCellData(xlsxName, sheetName, 4, i));
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//*[@id='messages']")
	private WebElement verifyConfirmationMsg;

	public void verifyConfirmationMsg(int i) throws IOException {
		log.info("Verifying if Rate Card is created Successfully or not");
		Assert.assertTrue(verifyConfirmationMsg.isDisplayed(), BasePage.getCellData(xlsxName, sheetName, 4, i));
	}
}
