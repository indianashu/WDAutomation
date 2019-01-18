package configurablePricing;

import baseClassPackage.BasePage;
import configurablePricing.CustomerPage;
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
import org.openqa.selenium.support.ui.Select;

public class CustomerPage extends BasePage {

	public CustomerPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(CustomerPage.class);
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "Customer";
	String xlsxName = "/ConfigurablePricing_TestData.xlsx";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws Exception
	 */
	public void enterLoginID() throws Exception {
		CustomerPage sp = new CustomerPage(driver);
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
		CustomerPage sp = new CustomerPage(driver);
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
		CustomerPage sp = new CustomerPage(driver);
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
		CustomerPage sp = new CustomerPage(driver);
		log.info("Verifying the login button is available or not");
		Assert.assertTrue(clickLoginButton.isDisplayed());
		clickLoginButton.click();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu.link.customers']/a")
	private WebElement clickCustomerTab;

	/**
	 * Method to click on Products tab after successful login.
	 * 
	 * @throws IOException
	 */
	public void clickCustomerTab() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		log.info("Click on Products Tab after successful login");
		Assert.assertTrue(clickCustomerTab.isDisplayed());
		clickCustomerTab.click();
		JavaScriptExec.sleep();
	}

	public void createCustomer() throws IOException {
		CustomerPage sp = new CustomerPage(driver);
		for (int rowNum = 0; rowNum < 2; rowNum++) {
			WebElement clickAddNewButton = driver
					.findElement(By.xpath("//a[@class='submit add']//*[text()='Add New']"));
			JavaScriptExec.scrollToElementOnPage(driver, clickAddNewButton);
			Assert.assertTrue(clickAddNewButton.isDisplayed());
			clickAddNewButton.click();
			JavaScriptExec.sleep();

			WebElement AccountTypeelement = driver.findElement(By.xpath("//select[@name='accountTypeId']"));
			Select sel = new Select(AccountTypeelement);
			sel.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 3, 0));
			WebElement clickSelectButton = driver
					.findElement(By.xpath("//a[@class='submit save']//*[text()='Select']"));
			Assert.assertTrue(clickSelectButton.isDisplayed());
			clickSelectButton.click();
			JavaScriptExec.sleep();

			WebElement enterLoginName = driver.findElement(By.xpath("//input[@name='user.userName']"));
			Assert.assertTrue(enterLoginName.isDisplayed());
			enterLoginName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, rowNum));
			JavaScriptExec.sleep();

			WebElement selectCurrency = driver.findElement(By.xpath("//select[@name='user.currencyId']"));
			selectCurrency.click();
			Select select = new Select(selectCurrency);
			select.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 5, 0));
			JavaScriptExec.sleep();

			navigateBottom();

			WebElement clickSaveChangesButton = driver
					.findElement(By.xpath("//a[@class='submit save']//*[text()='Save Changes']"));
			Assert.assertTrue(clickSaveChangesButton.isDisplayed());
			clickSaveChangesButton.click();

			String actualName = BasePage.getCellData(xlsxName, sheetName, 4, rowNum);
			String expectedName = driver
					.findElement(By.xpath("//*[@id='column2']/div[4]/div/table/tbody/tr[2]/td[2]/a")).getText();
			System.out.println("Customer Name=" + expectedName);
			Assert.assertEquals(actualName, expectedName);
			
			verifyConfirmationMsg("Customer Saved Successfully");
		}
	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}
}