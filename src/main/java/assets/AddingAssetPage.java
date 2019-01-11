package assets;

import baseClassPackage.BasePage;
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

/**
 * @author Ashutosh
 *
 */

public class AddingAssetPage extends BasePage {
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public AddingAssetPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(AddingAssetPage.class);
	AddingAssetPage discountPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "AddingAsset";
	String xlsxName = "/Webdata_TestData.xlsx";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		AddingAssetPage sp=new AddingAssetPage(driver);
		log.info("Verifying the Login ID is available or not");
		Assert.assertTrue(enterLoginID.isDisplayed());
		enterLoginID.sendKeys(sp.ExcelRead(sheetName).get(0));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='j_password']")
	private WebElement enterPassword;

	/**
	 * Method to enter Password.
	 * 
	 * @throws IOException
	 */
	public void enterPassword() throws IOException {
		AddingAssetPage sp = new AddingAssetPage(driver);
		log.info("Verifying the First Name is available or not");
		Assert.assertTrue(enterPassword.isDisplayed());
		enterPassword.sendKeys(sp.ExcelRead(sheetName).get(1));

	}

	private WebElement selectCompany;

	/**
	 * Method to select Company.
	 * 
	 * @throws IOException
	 */
	public void selectCompany() throws IOException {
		AddingAssetPage sp = new AddingAssetPage(driver);
		WebElement Companyelement = driver.findElement(By.xpath("//select[@name='j_client_id']"));
		Select se = new Select(Companyelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(2));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']")
	private WebElement clickLoginButton;

	/**
	 * Method to Click on Save Changes Button
	 */
	public void clickLoginButton() {
		AddingAssetPage sp = new AddingAssetPage(driver);
		log.info("Verifying the login button is available or not");
		Assert.assertTrue(clickLoginButton.isDisplayed());
		clickLoginButton.click();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu.link.customers']/a")
	private WebElement clickCustomersTab;

	/**
	 * Method to click on Customer tab after successful login.
	 * 
	 * @throws IOException
	 */
	public void clickCustomersTab() throws IOException {
		log.info("Click on Customer Tab after successful login");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickCustomersTab.isDisplayed());
		clickCustomersTab.click();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']")
	private WebElement clickAddNewButton;

	/**
	 * Method to click on Add New Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddNewButton() throws IOException {
		log.info("Click on Add New Button");
		Assert.assertTrue(clickAddNewButton.isDisplayed());
		JavaScriptExec.sleep();
		clickAddNewButton.click();

	}

	@FindBy(how = How.XPATH, using = "//select[@name='user.entityId']")
	private WebElement selectUserCompany;

	/**
	 * Method to select user company.
	 * 
	 * @throws IOException
	 */
	public void selectUserCompany() throws IOException {
		AddingAssetPage sp = new AddingAssetPage(driver);
		Select se = new Select(selectUserCompany);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(3));

	}

	@FindBy(how = How.XPATH, using = "//select[@name='accountTypeId']")
	private WebElement selectAccountType;

	/**
	 * Method to select account type.
	 * 
	 * @throws IOException
	 */
	public void selectAccountType() throws IOException {
		AddingAssetPage sp = new AddingAssetPage(driver);
		Select se = new Select(selectAccountType);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(4));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Select']")
	private WebElement clickSelectButton;

	/**
	 * Method to click on select Button.
	 * 
	 * @throws IOException
	 */
	public void clickSelectButton() throws IOException {
		log.info("Click on select Button");
		Assert.assertTrue(clickSelectButton.isDisplayed());
		clickSelectButton.click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='user.userName']")
	private WebElement enterCustomerLoginName;

	/**
	 * Method to Enter Login Name.
	 * 
	 * @throws IOException
	 */
	public void enterCustomerLoginName() throws IOException {
		AddingAssetPage sp = new AddingAssetPage(driver);
		log.info("Enter Login Name");
		Assert.assertTrue(enterCustomerLoginName.isDisplayed());
		enterCustomerLoginName.sendKeys(sp.ExcelRead(sheetName).get(5));
	}

	@FindBy(how = How.XPATH, using = "//select[@name='user.currencyId']")
	private WebElement selectCurrency;

	/**
	 * Method to Enter New Quantity.
	 * 
	 * @throws IOException
	 */
	public void selectCurrency() throws IOException {
		AddingAssetPage sp = new AddingAssetPage(driver);
		log.info("Select Currency United State");
		Select sel = new Select(selectCurrency);
		sel.selectByVisibleText(sp.ExcelRead(sheetName).get(13));
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickSaveChangesButton() throws IOException {
		log.info("Click on Save Changes Button");
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
		log.info("Verifying if Account Type is created Successfully or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyConfirmationMsg.isDisplayed(),
				"Assert Failed as its unable to search text in Logged in Page");
	}

	/**
	 * Method to Click on Customer from the customer list.
	 * 
	 * @throws IOException
	 */
	public void clickCustomerA() throws IOException {
		log.info("Click on customer from the customer list.");
		JavaScriptExec.sleep();
		String CustomerName = AddingAssetPage.ExcelRead(sheetName).get(5);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']")).click();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit order']//*[text()='Create Order']")
	private WebElement clickCreateOrderButton;

	/**
	 * Method to Click on Create Order Button.
	 * 
	 * @throws IOException
	 */
	public void clickCreateOrderButton() throws IOException {
		JavaScriptExec.scrollToElementOnPage(driver, clickCreateOrderButton);
		log.info("Click on Create Order Button.");
		Assert.assertTrue(clickCreateOrderButton.isDisplayed());
		clickCreateOrderButton.click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//select[@name='period']")
	private WebElement selectPeriod;

	/**
	 * Method to select Period.
	 * 
	 * @throws IOException
	 */
	public void selectPeriod() throws IOException {
		AddingAssetPage sp = new AddingAssetPage(driver);
		JavaScriptExec.sleep();
		Select se = new Select(selectPeriod);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(6));

	}

	@FindBy(how = How.XPATH, using = "//select[@name='billingTypeId']")
	private WebElement selectOrderType;

	/**
	 * Method to select Order Type.
	 * 
	 * @throws IOException
	 */
	public void selectOrderType() throws IOException {
		AddingAssetPage sp = new AddingAssetPage(driver);
		log.info("Select Order type.");
		Select se = new Select(selectOrderType);
		se.selectByVisibleText(AddingAssetPage.ExcelRead(sheetName).get(7));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='activeSince']")
	private WebElement selectActiveSince;

	/**
	 * Method to select Active since.
	 * 
	 * @throws IOException
	 */
	public void selectActiveSince() throws IOException {
		AddingAssetPage sp = new AddingAssetPage(driver);
		log.info("Select Active Since date of the order.");
		JavaScriptExec.sleep();
		selectActiveSince.clear();
		selectActiveSince.sendKeys(AddingAssetPage.ExcelRead(sheetName).get(8));
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='ui-id-8']")
	private WebElement clickProductSubTab;

	/**
	 * Method to click on Product sub tab.
	 * 
	 * @throws IOException
	 */
	public void clickProductSubTab() throws IOException {
		log.info("Click on Product Sub Tab.");
		Assert.assertTrue(clickProductSubTab.isDisplayed());
		clickProductSubTab.click();
		JavaScriptExec.sleep();

	}

	/**
	 * Method to Select a Product.
	 * 
	 * @throws IOException
	 */
	public void selectProduct() throws IOException {
		log.info("Select a product.");
		String ProductName = AddingAssetPage.ExcelRead(sheetName).get(9);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']")).click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Update']")
	private WebElement clickUpdateButton;

	/**
	 * Method to click on update button.
	 * 
	 * @throws IOException
	 */
	public void clickUpdateButton() throws IOException {
		log.info("click on update button.");
		Assert.assertTrue(clickUpdateButton.isDisplayed());
		clickUpdateButton.click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//input[@name='asset.select.1']")
	private WebElement clickAssetCheckbox;

	/**
	 * Method to click on selected asset checkbox.
	 * 
	 * @throws IOException
	 */
	public void clickAssetCheckbox() throws IOException {
		log.info("click on update button.");
		Assert.assertTrue(clickAssetCheckbox.isDisplayed());
		clickAssetCheckbox.click();
		JavaScriptExec.sleep();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add Selected']")
	private WebElement clickAddSelectedButton;

	/**
	 * Method to click on add selected button.
	 * 
	 * @throws IOException
	 */
	public void clickAddSelectedButton() throws IOException {
		log.info("click on add selected button.");
		Assert.assertTrue(clickAddSelectedButton.isDisplayed());
		clickAddSelectedButton.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add to Order']")
	private WebElement clickAddToOrderButton;

	/**
	 * Method to click on add to order button.
	 * 
	 * @throws IOException
	 */
	public void clickAddToOrderButton() throws IOException {
		log.info("click on add to order button.");
		Assert.assertTrue(clickAddToOrderButton.isDisplayed());
		clickAddToOrderButton.click();
		JavaScriptExec.sleep();
	}

	/**
	 * Method to verify added asset.
	 * 
	 * @throws IOException
	 */
	public void verifyAddedAsset() throws IOException {
		AddingAssetPage sp = new AddingAssetPage(driver);
		log.info("verify added asset.");
		String ExpectedAsset = sp.ExcelRead(sheetName).get(10);
		String ActualAsset = driver
				.findElement(By.xpath("//*[@id='change--3-update-form']//label[@for='change--3.asset.0']")).getText();
		Assert.assertEquals(ActualAsset, ExpectedAsset);
		JavaScriptExec.sleep();
	}

	/**
	 * Method to verify asset is shown in order preview pane.
	 * 
	 * @throws IOException
	 */
	public void verifyAssetOrderPreview() throws IOException {
		AddingAssetPage sp = new AddingAssetPage(driver);
		log.info("Verify asset is shown in order preview pane.");
		String ExpectedAsset = sp.ExcelRead(sheetName).get(10);
		String ActualAsset = driver
				.findElement(By.xpath("//div[@class='box-card-hold']//td[2]")).getText();
		Assert.assertEquals(ActualAsset, ExpectedAsset);
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu.link.products']/a")
	private WebElement clickProductsTab;

	/**
	 * Method to click on Products Tab.
	 * 
	 * @throws IOException
	 */
	public void clickProductsTab() throws IOException {
		log.info("click on Products Tab.");
		Assert.assertTrue(clickProductsTab.isDisplayed());
		clickProductsTab.click();
		JavaScriptExec.sleep();
	}

	/**
	 * Method to click on Products Category.
	 * 
	 * @throws IOException
	 */
	public void clickProductCategory() throws IOException {
		AddingAssetPage sp = new AddingAssetPage(driver);
		log.info("click on Product category.");
		String ProductCategory = sp.ExcelRead(sheetName).get(11);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductCategory + "']")).click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit show']//*[text()='Show Assets']")
	private WebElement clickShowAssetsButton;

	/**
	 * Method to click on show assets button.
	 * 
	 * @throws IOException
	 */
	public void clickShowAssetsButton() throws IOException {
		JavaScriptExec.scrollToElementOnPage(driver, clickShowAssetsButton);
		log.info("click on show assets button.");
		Assert.assertTrue(clickShowAssetsButton.isDisplayed());
		clickShowAssetsButton.click();
		JavaScriptExec.sleep();

	}

	private WebElement verifyAssetStatus;

	/**
	 * Method to verify asset status.
	 * 
	 * @throws IOException
	 */
	public void verifyAssetStatus() throws IOException {
		log.info("Verify asset is shown in order preview pane.");
		String ExpectedStatus = AddingAssetPage.ExcelRead(sheetName).get(12);
		String ActualStatus = driver.findElement(By.xpath("//a[@class='cell']//*[text()='In Use']")).getText();
		Assert.assertEquals(ActualStatus, ExpectedStatus);
		JavaScriptExec.sleep();
	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}

}
