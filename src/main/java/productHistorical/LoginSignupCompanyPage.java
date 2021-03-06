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
import utilPackages.WaitClass;


import org.openqa.selenium.support.ui.Select;

public class LoginSignupCompanyPage extends BasePage {
	
	public LoginSignupCompanyPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(LoginSignupCompanyPage.class);

	PropertyValExtractors p = new PropertyValExtractors();
	Actions actions = new Actions(driver);
	String sheetName = "LoginSignup";
	String xlsxName = "/ProductHistorical_TestData.xlsx";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws Exception
	 */
	public void enterLoginID() throws Exception {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);

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
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
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
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
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
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		log.info("Verifying the login button is available or not");
		Assert.assertTrue(clickLoginButton.isDisplayed());
		clickLoginButton.click();
	}

	@FindBy(how = How.XPATH, using = "//span[@class='right-text']")
	private WebElement verifyLabelSuccessfulLogin;

	/**
	 * Method to verify Label is present after successful login.
	 * 
	 * @throws IOException
	 */
	public void verifyLabelSuccessfulLogin() throws IOException {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		log.info("Verifying if Label is available or not");
		//JavaScriptExec.sleep();
		Assert.assertTrue(verifyLabelSuccessfulLogin.getText().contains(BasePage.getCellData(xlsxName, sheetName, 3, 0)),
				"Assert Failed as its unable to search text in Logged in Page");
	}

	private WebElement enterURL;

	/**
	 * Method to enter signup url to create child company.
	 * 
	 * @throws IOException
	 */
	public void enterURL() throws IOException {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		log.info("enter signup url to create child company");
		// driver.get("http://www.simplebilling.co.in:8080/signup");
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url");
		driver.get(url);
	}
	
	//@FindBy(how=How.XPATH, using="//*[@id="company-edit-form"]/fieldset/div[1]/div[2]/div[1]/span/h")
	private WebElement labelRootCompany;

	/**
	 * Method to verify Label root company is present after successful login.
	 * 
	 * @throws IOException
	 */
	public void labelRootCompany() throws IOException {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		log.info("Verifying if Label is available or not");
		String RootCompanyName = BasePage.getCellData(xlsxName, sheetName, 3, 0);
		String ActualRootCompany = driver
				.findElement(By.xpath("//*[@id='company-edit-form']/fieldset/div[1]/div[2]/div[1]/span/h")).getText();
		System.out.println("Company Name:********" + ActualRootCompany + "*********");
		log.info("Click on customer name");
		JavaScriptExec.sleep();
		Assert.assertEquals(ActualRootCompany, RootCompanyName);
	}

	@FindBy(how = How.XPATH, using = "//input[@name=\"user.userName\"]")
	private WebElement enterLoginName;

	/**
	 * Method to enter login Name.
	 * 
	 * @throws IOException
	 */
	public void enterLoginName() throws IOException {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);

		log.info("Verifying the Login Name is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, enterLoginName);
		Assert.assertTrue(enterLoginName.isDisplayed());
		enterLoginName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, 0));
	}

	@FindBy(how = How.XPATH, using = "//input[@name=\"contact.firstName\"]")
	private WebElement enterFirstName;

	/**
	 * Method to enter First Name.
	 * 
	 * @throws IOException
	 */
	public void enterFirstName() throws IOException {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		log.info("Verifying the First Name is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, enterFirstName);
		Assert.assertTrue(enterFirstName.isDisplayed());
		enterFirstName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 5, 0));

	}

	@FindBy(how = How.XPATH, using = "//input[@name=\"contact.lastName\"]")
	private WebElement enterLastName;

	/**
	 * Method to enter Last Name.
	 * 
	 * @throws IOException
	 */
	public void enterLastName() throws IOException {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		log.info("Verifying the Last Name is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, enterLastName);
		Assert.assertTrue(enterLastName.isDisplayed());
		enterLastName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 6, 0));

	}

	@FindBy(how = How.XPATH, using = "//input[@name=\"contact.phoneCountryCode1\"]")
	private WebElement enterPhoneCountryCode;

	/**
	 * Method to enter Phone Country Code.
	 * 
	 * @throws IOException
	 */
	public void enterPhoneCountryCode() throws IOException {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		log.info("Verifying the Phone Country Code is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, enterPhoneCountryCode);
		Assert.assertTrue(enterPhoneCountryCode.isDisplayed());
		enterPhoneCountryCode.sendKeys(BasePage.getCellData(xlsxName, sheetName, 7, 0));

	}

	@FindBy(how = How.XPATH, using = "//input[@name=\"contact.phoneAreaCode\"]")
	private WebElement enterPhoneAreaCode;

	/**
	 * Method to enter Phone Area Code.
	 * 
	 * @throws IOException
	 */
	public void enterPhoneAreaCode() throws IOException {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		log.info("Verifying the Phone Area Code is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, enterPhoneAreaCode);
		Assert.assertTrue(enterPhoneAreaCode.isDisplayed());
		enterPhoneAreaCode.sendKeys(BasePage.getCellData(xlsxName, sheetName, 8, 0));

	}

	@FindBy(how = How.XPATH, using = "//input[@name=\"contact.phoneNumber\"]")
	private WebElement enterPhoneNumber;

	/**
	 * Method to enter Phone Number.
	 * 
	 * @throws IOException
	 */
	public void enterPhoneNumber() throws IOException {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		log.info("Verifying the Phone Number is available or not");
		Assert.assertTrue(enterPhoneNumber.isDisplayed());
		enterPhoneNumber.sendKeys(BasePage.getCellData(xlsxName, sheetName, 9, 0));

	}

	@FindBy(how = How.XPATH, using = "//input[@name=\"contact.email\"]")
	private WebElement enterEmail;

	/**
	 * Method to enter Email.
	 * 
	 * @throws IOException
	 */
	public void enterEmail() throws IOException {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		log.info("Verifying the Email is available or not");
		Assert.assertTrue(enterEmail.isDisplayed());
		enterEmail.sendKeys(BasePage.getCellData(xlsxName, sheetName, 10, 0));

	}

	private WebElement selectLanguage;

	/**
	 * Method to select Language.
	 * 
	 * @throws IOException
	 */
	public void selectLanguage() throws IOException {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		WebElement languageelement = driver.findElement(By.xpath("//select[@name='languageId']"));
		Select se = new Select(languageelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 11, 0));

	}

	private WebElement selectCurrency;

	/**
	 * Method to select Currency.
	 * 
	 * @throws IOException
	 */
	public void selectCurrency() throws IOException {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		WebElement currencyelement = driver.findElement(By.xpath("//select[@name='currencyId']"));
		Select se = new Select(currencyelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 12, 0));

	}

	@FindBy(how = How.XPATH, using = "//input[@name=\"contact.organizationName\"]")
	private WebElement enterOrgName;

	/**
	 * Method to enter Organization Name.
	 * 
	 * @throws IOException
	 */
	public void enterOrgName() throws IOException {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		log.info("Verifying the OrgName is available or not");
		Assert.assertTrue(enterOrgName.isDisplayed());
		enterOrgName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 13, 0));

	}

	@FindBy(how = How.XPATH, using = "//input[@name=\"contact.address1\"]")
	private WebElement enterAddress;

	/**
	 * Method to enter Address.
	 * 
	 * @throws IOException
	 */
	public void enterAddress() throws IOException {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		log.info("Verifying the Address is available or not");
		Assert.assertTrue(enterAddress.isDisplayed());

		enterAddress.sendKeys(BasePage.getCellData(xlsxName, sheetName, 14, 0));

	}

	@FindBy(how = How.XPATH, using = "//input[@name=\"contact.address2\"]")
	private WebElement enterAddress2;

	/**
	 * Method to enter Address2.
	 * 
	 * @throws IOException
	 */
	public void enterAddress2() throws IOException {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		log.info("Verifying the Address2 is available or not");
		Assert.assertTrue(enterAddress2.isDisplayed());
		enterAddress2.sendKeys(BasePage.getCellData(xlsxName, sheetName, 15, 0));

	}

	@FindBy(how = How.XPATH, using = "//input[@name=\"contact.city\"]")
	private WebElement enterCity;

	/**
	 * Method to enter City.
	 * 
	 * @throws IOException
	 */
	public void enterCity() throws IOException {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		log.info("Verifying the City is available or not");
		Assert.assertTrue(enterCity.isDisplayed());
		enterCity.sendKeys(BasePage.getCellData(xlsxName, sheetName, 16, 0));

	}

	@FindBy(how = How.XPATH, using = "//input[@name=\"contact.stateProvince\"]")
	private WebElement enterStateProvince;

	/**
	 * Method to enter State/Province.
	 * 
	 * @throws IOException
	 */
	public void enterStateProvince() throws IOException {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		log.info("Verifying the City is available or not");
		Assert.assertTrue(enterStateProvince.isDisplayed());
		enterStateProvince.sendKeys(BasePage.getCellData(xlsxName, sheetName, 17, 0));

	}

	private WebElement selectCounty;

	/**
	 * Method to select Country.
	 * 
	 * @throws IOException
	 */
	public void selectCountry() throws IOException {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		WebElement countryelement = driver.findElement(By.xpath("//select[@name='contact.countryCode']"));
		Select se = new Select(countryelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 18, 0));

	}

	@FindBy(how = How.XPATH, using = "//input[@name=\"contact.postalCode\"]")
	private WebElement enterZipCode;

	/**
	 * Method to enter ZipCode.
	 * 
	 * @throws IOException
	 */
	public void enterZipCode() throws IOException {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		log.info("Verifying the City is available or not");
		Assert.assertTrue(enterZipCode.isDisplayed());
		enterZipCode.sendKeys(BasePage.getCellData(xlsxName, sheetName, 19, 0));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to Click on Save Changes Button
	 */
	public void clickSaveChangesButton() {
		log.info("Verifying the login button is available or not");
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
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		log.info("Verifying if Label is available or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(labelConfirmationMessage.getText().contains(BasePage.getCellData(xlsxName, sheetName, 20, 0)),
				"Assert Failed as its unable to search text in Logged in Page");
	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}
}
