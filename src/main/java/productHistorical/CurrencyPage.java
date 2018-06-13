package productHistorical;

import baseClassPackage.BasePage;
import companyHierarchy.ViewAssignedInfoPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
import webDataPages.ImpersonatePage;
import webDataPages.SignupChildCompanyInvoiceAsSellerPage;

import org.openqa.selenium.support.ui.Select;

/**
 * @author Rinky
 *
 */

public class CurrencyPage extends BasePage {

	public CurrencyPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(CurrencyPage.class);
	CurrencyPage CurrencyPage;
	PropertyValExtractors p = new PropertyValExtractors();

	public ArrayList<String> ExcelRead() throws IOException {

		ArrayList<String> rl = new ArrayList<String>();
		File file = new File(System.getProperty("user.dir") + "/ProductHistorical_TestData.xlsx");
		FileInputStream fs = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sheet = wb.getSheet("AddCurrency");

		Iterator<Row> row = sheet.iterator();
		// System.out.println();
		while (row.hasNext()) {
			Iterator<Cell> cell = row.next().iterator();
			int i = 0;

			while (cell.hasNext()) {

				Cell c1 = cell.next();
				c1.setCellType(c1.CELL_TYPE_STRING);
				String sample = c1.getStringCellValue();
				// log.info("***************************"+sample+"********************");

				rl.add(sample);

			}
			System.out.println(rl);
		}

		return rl;
	}

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		CurrencyPage sp = new CurrencyPage(driver);

		log.info("Verifying the Login ID is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, enterLoginID);
		Assert.assertTrue(enterLoginID.isDisplayed());
		enterLoginID.sendKeys(sp.ExcelRead().get(0));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='j_password']")
	private WebElement enterPassword;

	/**
	 * Method to enter Password.
	 * 
	 * @throws IOException
	 */
	public void enterPassword() throws IOException {
		CurrencyPage sp = new CurrencyPage(driver);
		log.info("Verifying the First Name is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, enterPassword);
		Assert.assertTrue(enterPassword.isDisplayed());
		enterPassword.sendKeys(sp.ExcelRead().get(1));

	}

	private WebElement selectCompany;

	/**
	 * Method to select Company.
	 * 
	 * @throws IOException
	 */
	public void selectCompany() throws IOException {
		CurrencyPage sp = new CurrencyPage(driver);
		WebElement Companyelement = driver.findElement(By.xpath("//select[@name='j_client_id']"));
		Select se = new Select(Companyelement);
		se.selectByVisibleText(sp.ExcelRead().get(2));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']")
	private WebElement clickLoginButton;

	/**
	 * Method to Click on Save Changes Button
	 */
	public void clickLoginButton() {
		CurrencyPage sp = new CurrencyPage(driver);
		log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
		Assert.assertTrue(clickLoginButton.isDisplayed());
		clickLoginButton.click();
	}

	@FindBy(how = How.XPATH, using = "//a[.='Currencies']")
	private WebElement clickCurrencies;

	/**
	 * Method to click on Account Type.
	 * 
	 * @throws IOException
	 */
	public void clickCurrencies() throws IOException {
		CurrencyPage sp = new CurrencyPage(driver);
		log.info("Click on Account Type");
		JavaScriptExec.sleep();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url2") + "/config/currency";
		driver.get(url);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='currencies.2.inUse']")
	private WebElement checkCADcurrency;

	/**
	 * Method to Check Canadian Currency CheckBox.
	 * 
	 * @throws IOException
	 */
	public void checkCADcurrency() throws IOException {
		CurrencyPage sp = new CurrencyPage(driver);
		log.info("Check Canadian Currency Checkbox.");
		WaitClass.WaitForElementisDisplay(driver, 5, checkCADcurrency);
		Assert.assertTrue(checkCADcurrency.isDisplayed());
		checkCADcurrency.click();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='currencies.3.inUse']")
	private WebElement checkEUROcurrency;

	/**
	 * Method to Check Euro Currency CheckBox.
	 * 
	 * @throws IOException
	 */
	public void checkEUROcurrency() throws IOException {
		CurrencyPage sp = new CurrencyPage(driver);
		log.info("Check Euro Currency Checkbox.");
		WaitClass.WaitForElementisDisplay(driver, 5, checkEUROcurrency);
		Assert.assertTrue(checkEUROcurrency.isDisplayed());
		checkEUROcurrency.click();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to Click on Save Changes Button
	 */
	public void clickSaveChangesButton() {
		log.info("Verifying the login button is available or not");
		navigateBottom();
		WaitClass.WaitForElementisDisplay(driver, 5, clickSaveChangesButton);
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		clickSaveChangesButton.click();
	}

	@FindBy(how = How.XPATH, using = "//div[@class='msg-box successfully']")
	private WebElement labelConfirmationMessage;

	/**
	 * Method to verify Label is present after successful login.
	 * 
	 * @throws IOException
	 */
	public void verifyLabelConfirmationMessage() throws IOException {
		CurrencyPage sp = new CurrencyPage(driver);
		log.info("Verifying if Label is available or not");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 5, labelConfirmationMessage);
		Assert.assertTrue(labelConfirmationMessage.getText().contains(sp.ExcelRead().get(4)),
				"Assert Failed as its unable to search text in Logged in Page");
	}

	@FindBy(how = How.XPATH, using = "//*[@class='fa fa-plus-square']")
	private WebElement clickImpersonate;

	/**
	 * Method to Click on Impersonate Link
	 */
	public void clickImpersonate() {
		CurrencyPage sp = new CurrencyPage(driver);
		log.info("Click on Impersonate Link");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 5, clickImpersonate);
		Assert.assertTrue(clickImpersonate.isDisplayed());
		clickImpersonate.click();
	}

	private WebElement selectChildCompany;

	/**
	 * Method to select Child Company.
	 * 
	 * @throws IOException
	 */
	public void selectChildCompany() throws IOException {
		CurrencyPage sp = new CurrencyPage(driver);
		JavaScriptExec.sleep();
		WebElement Companyelement = driver.findElement(By.xpath("//select[@name='entityId']"));
		Select se = new Select(Companyelement);
		se.selectByVisibleText(sp.ExcelRead().get(3));

	}

	@FindBy(how = How.XPATH, using = "//*[text()='OK']")
	private WebElement clickOKButton;

	/**
	 * Method to Click on Select Button
	 */
	public void clickOKButton() {
		CurrencyPage sp = new CurrencyPage(driver);
		log.info("Click on Select Button");
		WaitClass.WaitForElementisDisplay(driver, 5, clickOKButton);
		Assert.assertTrue(clickOKButton.isDisplayed());
		clickOKButton.click();
	}

	// @FindBy(how=How.XPATH,using="//*[@id='header']/ul/a")
	private WebElement verifyChildCompanyName;

	/**
	 * Method to Verify Child Company Name is shown
	 * 
	 * @throws IOException
	 */
	public void verifyChildCompanyName() throws IOException {
		CurrencyPage sp = new CurrencyPage(driver);
		log.info("Verify Child Company Name is shown.");
		String ExpectedName = sp.ExcelRead().get(5);
		String ActualName = driver.findElement(By.xpath("//*[@id='header']//span[@class='right-text']")).getText();
		Assert.assertEquals(ActualName, ExpectedName);
	}

	@FindBy(how = How.XPATH, using = "//span[@class='right-text']//a")
	private WebElement clickRedCross;

	/**
	 * Method to click on Red Cross
	 * 
	 * @throws IOException
	 */
	public void clickRedCross() throws IOException {
		CurrencyPage sp = new CurrencyPage(driver);
		log.info("Click on Red Cross");
		WaitClass.WaitForElementisDisplay(driver, 5, clickRedCross);
		Assert.assertTrue(clickRedCross.isDisplayed());
		clickRedCross.click();

	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}
}
