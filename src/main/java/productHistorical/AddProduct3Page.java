package productHistorical;

import baseClassPackage.BasePage;
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

import org.openqa.selenium.support.ui.Select;

public class AddProduct3Page extends BasePage {

	public AddProduct3Page(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(AddProduct3Page.class);
	AddProduct3Page AddProductCategoryPage;
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
		AddProduct3Page sp = new AddProduct3Page(driver);

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
		AddProduct3Page sp = new AddProduct3Page(driver);
		log.info("Verifying the First Name is available or not");
		Assert.assertTrue(enterPassword.isDisplayed());
		enterPassword.sendKeys(BasePage.getCellData(xlsxName, sheetName, 1, 0));

	}

	@FindBy(how = How.XPATH, using = "//select[@name='j_client_id']")
	private WebElement selectCompany;

	/**
	 * Method to select Company.
	 * 
	 * @throws IOException
	 */
	public void selectCompany() throws Exception {
		AddProduct3Page sp = new AddProduct3Page(driver);
		Select se = new Select(selectCompany);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 2, 0));
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']")
	private WebElement clickLoginButton;

	/**
	 * Method to Click on Save Changes Button
	 */
	public void clickLoginButton() {
		AddProduct3Page sp = new AddProduct3Page(driver);
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
		AddProduct3Page sp = new AddProduct3Page(driver);
		log.info("Click on Products Tab after successful login");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickProductsTab.isDisplayed());
		clickProductsTab.click();
	}

	/**
	 * Method to click on a category name.
	 * 
	 * @throws IOException
	 */
	public void selectCategoryName() throws IOException {
		AddProduct3Page sp = new AddProduct3Page(driver);
		String CategoryName = BasePage.getCellData(xlsxName, sheetName, 3, 0);
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
		AddProduct3Page sp = new AddProduct3Page(driver);
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
		AddProduct3Page sp = new AddProduct3Page(driver);
		log.info("Enter English Description");
		JavaScriptExec.sleep();
		Assert.assertTrue(enterEnglishDescription.isDisplayed());
		enterEnglishDescription.sendKeys(BasePage.getCellData(xlsxName, sheetName, 5, 2));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.number']")
	private WebElement enterProductCode;

	/**
	 * Method to Enter Product Code.
	 * 
	 * @throws IOException
	 */
	public void enterProductCode() throws IOException {
		AddProduct3Page sp = new AddProduct3Page(driver);
		log.info("Enter Product Code");
		JavaScriptExec.sleep();
		Assert.assertTrue(enterProductCode.isDisplayed());
		enterProductCode.sendKeys(BasePage.getCellData(xlsxName, sheetName, 5, 2));

	}
		
	public void deselectProductCompany1() throws IOException {
		WebElement Companyelement = driver.findElement(By.xpath("//select[@name='product.entities']"));
		Select se = new Select(Companyelement);
		se.deselectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 2, 0));
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//select[@name='product.entities']")
	private WebElement selectChildCompany;

	/**
	 * Method to select companies.
	 * 
	 * @throws IOException
	 */
	public void selectChildCompany() throws IOException {
		AddProduct3Page sp = new AddProduct3Page(driver);
		Select se = new Select(selectChildCompany);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 4, 0));
	}

	public void selectHistoricalPrices() throws IOException {
		AddProduct3Page sp = new AddProduct3Page(driver);
		for (int i = 0; i <= 8; i++) {
			WebElement enterPastPriceDate = driver.findElement(By.xpath("//*[@name=\"mydate\"]"));
			Assert.assertTrue(enterPastPriceDate.isDisplayed());
			enterPastPriceDate.clear();
			enterPastPriceDate.sendKeys(BasePage.getCellData(xlsxName, sheetName, 6, i));
			JavaScriptExec.sleep();
			
			WebElement Companieselement = driver.findElement(By.xpath("//select[@name='product.entity']"));
	        Select se = new Select(Companieselement);
	        se.selectByVisibleText(BasePage.getCellData(xlsxName,sheetName,4,0));

			WebElement Currencyelement = driver.findElement(By.xpath("//select[@name='product.currencies']"));
			Select sel = new Select(Currencyelement);
			sel.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 7, i));
			JavaScriptExec.sleep();

			WebElement enterPriceRatePastUSD = driver.findElement(By.xpath("//input[@name='product.rate']"));
			Assert.assertTrue(enterPriceRatePastUSD.isDisplayed());
			enterPriceRatePastUSD.clear();
			enterPriceRatePastUSD.sendKeys(BasePage.getCellData(xlsxName, sheetName, 11, i));
			JavaScriptExec.sleep();

			WebElement clickAddPriceButton = driver
					.findElement(By.xpath("//a[@class='submit add']//*[text()='Add Price']"));
			Assert.assertTrue(clickAddPriceButton.isDisplayed());
			clickAddPriceButton.click();

		}

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickSaveChangesButton() throws IOException {
		AddProduct3Page sp = new AddProduct3Page(driver);
		log.info("Click on Save Changes Button");
		navigateBottom();
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		clickSaveChangesButton.click();

	}

	@FindBy(how = How.XPATH, using = "//div[@class='msg-box successfully']//*[text()='Done']")
	private WebElement verifyConfirmationMsg;

	/**
	 * Method to verify Account Type is created Successfully.
	 * 
	 * @throws IOException
	 */
	public void verifyConfirmationMsg() throws IOException {
		AddProduct3Page sp = new AddProduct3Page(driver);
		log.info("Verifying if Account Type is created Successfully or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyConfirmationMsg.isDisplayed(),
				"Assert Failed as its unable to search text in Logged in Page");
	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}

}
