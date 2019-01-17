package productHistorical;

import baseClassPackage.BasePage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

	@FindBy(how = How.XPATH, using = "//select[@name='j_client_id']")
	private WebElement selectCompany;

	/**
	 * Method to select Company.
	 * 
	 * @throws IOException
	 */
	public void selectCompany() throws Exception {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		Select se = new Select(selectCompany);
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
		Assert.assertTrue(verifyLabelSuccessfulLogin.getText().contains(BasePage.getCellData(xlsxName, sheetName, 3, 0)),
				"Assert Failed as its unable to search text in Logged in Page");
	}

	/**
	 * Method to enter signup url to create child company.
	 * 
	 * @throws IOException
	 */
	public void enterURL() throws IOException {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		log.info("enter signup url to create child company");
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url");
		driver.get(url);
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='company-edit-form']//h")
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
		String ActualRootCompany = labelRootCompany.getText();
		System.out.println("Company Name:********" + ActualRootCompany + "*********");
		log.info("Click on customer name");
		JavaScriptExec.sleep();
		Assert.assertEquals(ActualRootCompany, RootCompanyName);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='user.userName']")
	private WebElement enterLoginName;

	/**
	 * Method to enter login Name.
	 * 
	 * @throws IOException
	 */
	public void enterLoginName() throws IOException {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		log.info("Verifying the Login Name is available or not");
		Assert.assertTrue(enterLoginName.isDisplayed());
		enterLoginName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 4, 0));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='contact.firstName']")
	private WebElement enterFirstName;

	/**
	 * Method to enter First Name.
	 * 
	 * @throws IOException
	 */
	public void enterFirstName() throws IOException {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		log.info("Verifying the First Name is available or not");
		Assert.assertTrue(enterFirstName.isDisplayed());
		enterFirstName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 5, 0));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='contact.lastName']")
	private WebElement enterLastName;

	/**
	 * Method to enter Last Name.
	 * 
	 * @throws IOException
	 */
	public void enterLastName() throws IOException {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		log.info("Verifying the Last Name is available or not");
		Assert.assertTrue(enterLastName.isDisplayed());
		enterLastName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 6, 0));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='contact.phoneCountryCode1']")
	private WebElement enterPhoneCountryCode;

	/**
	 * Method to enter Phone Country Code.
	 * 
	 * @throws IOException
	 */
	public void enterPhoneCountryCode() throws IOException {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		log.info("Verifying the Phone Country Code is available or not");
		Assert.assertTrue(enterPhoneCountryCode.isDisplayed());
		enterPhoneCountryCode.sendKeys(BasePage.getCellData(xlsxName, sheetName, 7, 0));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='contact.phoneAreaCode']")
	private WebElement enterPhoneAreaCode;

	/**
	 * Method to enter Phone Area Code.
	 * 
	 * @throws IOException
	 */
	public void enterPhoneAreaCode() throws IOException {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		log.info("Verifying the Phone Area Code is available or not");
		Assert.assertTrue(enterPhoneAreaCode.isDisplayed());
		enterPhoneAreaCode.sendKeys(BasePage.getCellData(xlsxName, sheetName, 8, 0));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='contact.phoneNumber']")
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

	@FindBy(how = How.XPATH, using = "//input[@name='contact.email']")
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
	
	@FindBy(how = How.XPATH, using = "//select[@name='languageId']")
	private WebElement selectLanguage;

	/**
	 * Method to select Language.
	 * 
	 * @throws IOException
	 */
	public void selectLanguage() throws IOException {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		Select se = new Select(selectLanguage);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 11, 0));

	}

	@FindBy(how = How.XPATH, using = "//select[@name='currencyId']")
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

	@FindBy(how = How.XPATH, using = "//input[@name='contact.organizationName']")
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

	@FindBy(how = How.XPATH, using = "//input[@name='contact.address1']")
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

	@FindBy(how = How.XPATH, using = "//input[@name='contact.address2']")
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

	@FindBy(how = How.XPATH, using = "//input[@name='contact.city']")
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

	@FindBy(how = How.XPATH, using = "//input[@name='contact.stateProvince']")
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

	@FindBy(how = How.XPATH, using = "//select[@name='contact.countryCode']")
	private WebElement selectCounty;

	/**
	 * Method to select Country.
	 * 
	 * @throws IOException
	 */
	public void selectCountry() throws IOException {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		Select se = new Select(selectCounty);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 18, 0));

	}

	@FindBy(how = How.XPATH, using = "//input[@name='contact.postalCode']")
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

	@FindBy(how = How.XPATH, using = "//div[@class='msg-box error']")
	private WebElement verifyErrorMsg;

	/**
	 * Method to verify Label is present after successful login.
	 * 
	 * @throws IOException
	 */
	public void verifyLabelConfirmationMessage() throws IOException {
		LoginSignupCompanyPage sp = new LoginSignupCompanyPage(driver);
		JavaScriptExec.sleep();
		try {
			Assert.assertTrue(labelConfirmationMessage.isDisplayed(),
					"Assert Failed if the Child Company Signup is Failed");
		} catch (NoSuchElementException e) {
			if (verifyErrorMsg.isDisplayed()) {
				String failureMsg = verifyErrorMsg.getText();
				throw new RuntimeException(failureMsg);
			}
		}
	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}
}
