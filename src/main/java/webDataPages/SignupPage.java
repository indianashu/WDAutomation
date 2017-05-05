package webDataPages;

import baseClassPackage.BasePage;

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
import org.openqa.selenium.support.ui.Select;

/**
 * @author Ashutosh
 *
 */

public class SignupPage extends BasePage{
    /**
     * This constructor is used to initialize the webdriver in BasePage class, if the user does not want to use page factory
     * then this will take care of initialization of the driver
     *
     * @param webdriver
     */
    public SignupPage(WebDriver webdriver) {
        super(webdriver);
    }

    Logger log=Logger.getLogger(SignupPage.class);
    SignupPage signupPage;
    PropertyValExtractors p = new PropertyValExtractors();
  
    public  ArrayList<String> ExcelRead() throws IOException{
    	

		ArrayList<String> rl=new ArrayList<String>();
		File file=new File(System.getProperty("user.dir") +"/Webdata_TestData.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("SignupData");
	
		Iterator<Row> row=sheet.iterator();
		//System.out.println();
		while(row.hasNext()){
			Iterator<Cell> cell=row.next().iterator();
			int i=0;
			
			while(cell.hasNext()){
					
				Cell c1=cell.next();
				c1.setCellType(c1.CELL_TYPE_STRING);
				String sample=c1.getStringCellValue();
				//log.info("***************************"+sample+"********************");
				
		rl.add(sample);
		
			}
			System.out.println(rl);
		}
		
		return rl;
    }
    

    @FindBy(how=How.XPATH,using="//input[@name='user.userName']")
    private WebElement enterLoginName;
    /**
     * Method to enter login Name.
     * @throws IOException 
     */
    public void enterLoginName() throws IOException{
    	SignupPage sp=new SignupPage(driver);
    	
        log.info("Verifying the Login Name is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterLoginName);
        Assert.assertTrue(enterLoginName.isDisplayed());
        enterLoginName.sendKeys(sp.ExcelRead().get(0));
    }

    @FindBy(how=How.XPATH,using="//input[@name='contact.firstName']")
    private WebElement enterFirstName;
    /**
     * Method to enter First Name.
     * @throws IOException 
     */
    public void enterFirstName() throws IOException{
    	SignupPage sp=new SignupPage(driver);
        log.info("Verifying the First Name is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterFirstName);
        Assert.assertTrue(enterFirstName.isDisplayed());
        enterFirstName.sendKeys(sp.ExcelRead().get(1));

    }

    @FindBy(how=How.XPATH,using="//input[@name='contact.lastName']")
    private WebElement enterLastName;
    /**
     * Method to enter Last Name.
     * @throws IOException 
     */
    public void enterLastName() throws IOException{
    	SignupPage sp=new SignupPage(driver);
        log.info("Verifying the Last Name is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterLastName);
        Assert.assertTrue(enterLastName.isDisplayed());
        enterLastName.sendKeys(sp.ExcelRead().get(2));

    }

    @FindBy(how=How.XPATH,using="//input[@name='contact.phoneCountryCode1']")
    private WebElement enterPhoneCountryCode;
    /**
     * Method to enter Phone Country Code.
     * @throws IOException 
     */
    public void enterPhoneCountryCode() throws IOException{
    	SignupPage sp=new SignupPage(driver);
    	log.info("Verifying the Phone Country Code is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterPhoneCountryCode);
        Assert.assertTrue(enterPhoneCountryCode.isDisplayed());        
        enterPhoneCountryCode.sendKeys(sp.ExcelRead().get(3));

    }

    @FindBy(how=How.XPATH,using="//input[@name='contact.phoneAreaCode']")
    private WebElement enterPhoneAreaCode;
    /**
     * Method to enter Phone Area Code.
     * @throws IOException 
     */
    public void enterPhoneAreaCode() throws IOException{
    	SignupPage sp=new SignupPage(driver);
        log.info("Verifying the Phone Area Code is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterPhoneAreaCode);
        Assert.assertTrue(enterPhoneAreaCode.isDisplayed());
         enterPhoneAreaCode.sendKeys(sp.ExcelRead().get(4));

    }

    @FindBy(how=How.XPATH,using="//input[@name='contact.phoneNumber']")
    private WebElement enterPhoneNumber;
    /**
     * Method to enter Phone Number.
     * @throws IOException 
     */
    public void enterPhoneNumber() throws IOException{
    	SignupPage sp=new SignupPage(driver);
        log.info("Verifying the Phone Number is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterPhoneNumber);
        Assert.assertTrue(enterPhoneNumber.isDisplayed());
        enterPhoneNumber.sendKeys(sp.ExcelRead().get(5));

    }

    @FindBy(how=How.XPATH,using="//input[@name='contact.email']")
    private WebElement enterEmail;
    /**
     * Method to enter Email.
     * @throws IOException 
     */
    public void enterEmail() throws IOException{
    	SignupPage sp=new SignupPage(driver);
        log.info("Verifying the Email is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterEmail);
        Assert.assertTrue(enterEmail.isDisplayed());
        enterEmail.sendKeys(sp.ExcelRead().get(6));

    }

    private WebElement selectLanguage;
    /**
     * Method to select Language.
     * @throws IOException 
     */
    public void selectLanguage() throws IOException{
    	SignupPage sp=new SignupPage(driver);
        WebElement languageelement = driver.findElement(By.xpath("//select[@name='languageId']"));
        Select se = new Select(languageelement);
        se.selectByVisibleText(sp.ExcelRead().get(7));
        
    }

    private WebElement selectCurrency;
    /**
     * Method to select Currency.
     * @throws IOException 
     */
    public void selectCurrency() throws IOException{
    	SignupPage sp=new SignupPage(driver);
        WebElement currencyelement = driver.findElement(By.xpath("//select[@name='currencyId']"));
        Select se = new Select(currencyelement);
        se.selectByVisibleText(sp.ExcelRead().get(8));

    }

    @FindBy(how=How.XPATH,using="//input[@name='contact.organizationName']")
    private WebElement enterOrgName;
    /**
     * Method to enter Organization Name.
     * @throws IOException 
     */
    public void enterOrgName() throws IOException{
    	SignupPage sp=new SignupPage(driver);
    	log.info("Verifying the OrgName is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterOrgName);
        Assert.assertTrue(enterOrgName.isDisplayed());
        enterOrgName.sendKeys(sp.ExcelRead().get(9));

    }

    @FindBy(how=How.XPATH,using="//input[@name='contact.address1']")
    private WebElement enterAddress;
    /**
     * Method to enter Address.
     * @throws IOException 
     */
    public void enterAddress() throws IOException{
    	SignupPage sp=new SignupPage(driver);
        log.info("Verifying the Address is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterAddress);
        Assert.assertTrue(enterAddress.isDisplayed());
        
        enterAddress.sendKeys(sp.ExcelRead().get(10));

    }

    @FindBy(how=How.XPATH,using="//input[@name='contact.address2']")
    private WebElement enterAddress2;
    /**
     * Method to enter Address2.
     * @throws IOException 
     */
    public void enterAddress2() throws IOException{
    	SignupPage sp=new SignupPage(driver);
        log.info("Verifying the Address2 is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterAddress2);
        Assert.assertTrue(enterAddress2.isDisplayed());
        enterAddress2.sendKeys(sp.ExcelRead().get(11));

    }

    @FindBy(how=How.XPATH,using="//input[@name='contact.city']")
    private WebElement enterCity;
    /**
     * Method to enter City.
     * @throws IOException 
     */
    public void enterCity() throws IOException{
    	SignupPage sp=new SignupPage(driver);
        log.info("Verifying the City is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterCity);
        Assert.assertTrue(enterCity.isDisplayed());
        enterCity.sendKeys(sp.ExcelRead().get(12));

    }

    @FindBy(how=How.XPATH,using="//input[@name='contact.stateProvince']")
    private WebElement enterStateProvince;
    /**
     * Method to enter State/Province.
     * @throws IOException 
     */
    public void enterStateProvince() throws IOException{
    	SignupPage sp=new SignupPage(driver);
        log.info("Verifying the City is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterStateProvince);
        Assert.assertTrue(enterStateProvince.isDisplayed());
        enterStateProvince.sendKeys(sp.ExcelRead().get(13));

    }

    private WebElement selectCounty;
    /**
     * Method to select Country.
     * @throws IOException 
     */
    public void selectCountry() throws IOException{
    	SignupPage sp=new SignupPage(driver);
        WebElement countryelement = driver.findElement(By.xpath("//select[@name='contact.countryCode']"));
        Select se = new Select(countryelement);
        se.selectByVisibleText(sp.ExcelRead().get(14));

    }

    @FindBy(how=How.XPATH,using="//input[@name='contact.postalCode']")
    private WebElement enterZipCode;
    /**
     * Method to enter ZipCode.
     * @throws IOException 
     */
    public void enterZipCode() throws IOException{
    	SignupPage sp=new SignupPage(driver);
        log.info("Verifying the City is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterZipCode);
        Assert.assertTrue(enterZipCode.isDisplayed());
        enterZipCode.sendKeys(sp.ExcelRead().get(15));

    }

    @FindBy(how=How.XPATH,using="//a[@class='submit save']")
    private WebElement clickSaveChangesButton;
    /**
     * Method to Click on  Save Changes Button
     */
    public void clickSaveChangesButton(){
        log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickSaveChangesButton);
        Assert.assertTrue(clickSaveChangesButton.isDisplayed());
        clickSaveChangesButton.click();
    }

    @FindBy(how=How.XPATH, using="//div[@class='msg-box successfully']")
    private WebElement labelConfirmationMessage;
    /**
     * Method to verify Label is present after successful login.
     * @throws IOException 
     */
    public void verifyLabelConfirmationMessage() throws IOException{
    	SignupPage sp=new SignupPage(driver);
        log.info("Verifying if Label is available or not");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, labelConfirmationMessage);
        Assert.assertTrue(labelConfirmationMessage.getText().contains(sp.ExcelRead().get(16)), "Assert Failed as its unable to search text in Logged in Page");
    }

    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        JavaScriptExec.sleep();
    }

}
