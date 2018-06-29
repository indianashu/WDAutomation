package addOn;

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
import productHistorical.AddCustomerPage;
import utilPackages.JavaScriptExec;

public class AddOnCreateCustomerPage extends BasePage{
	public AddOnCreateCustomerPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(AddOnCreateCustomerPage.class);
	String sheetName = "AddCustomer";
	String xlsxName = "/AddOn_TestData.xlsx";
	Actions actions = new Actions(driver);

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws Exception
	 */
	public void enterLoginID() throws Exception {
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
		log.info("Verifying the First Name is available or not");
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

	/**
	 * Method to Click on Save Changes Button
	 */
	public void clickLoginButton() {
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
		log.info("Click on Products Tab after successful login");
		Assert.assertTrue(clickCustomerTab.isDisplayed());
		clickCustomerTab.click();
		JavaScriptExec.sleep();

	}
	
	public void createCustomer() throws IOException {
		AddCustomerPage sp = new AddCustomerPage(driver);
		for (int i = 0; i <= 2; i++) {
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
			enterLoginName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, i));
			JavaScriptExec.sleep();
			
			navigateBottom();

			WebElement clickSaveChangesButton = driver
					.findElement(By.xpath("//a[@class='submit save']//*[text()='Save Changes']"));
			Assert.assertTrue(clickSaveChangesButton.isDisplayed());
			clickSaveChangesButton.click();

			WebElement verifyConfirmationMsg = driver
					.findElement(By.xpath("//div[@class='msg-box successfully']//*[text()='Done']"));
			Assert.assertTrue(verifyConfirmationMsg.isDisplayed(),
					"Assert Failed as its unable to search text in Logged in Page");
			JavaScriptExec.sleep();

		}

	}
	
	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}

}
