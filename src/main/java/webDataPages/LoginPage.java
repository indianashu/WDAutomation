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

public class LoginPage extends BasePage {
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public LoginPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(LoginPage.class);
	LoginPage loginPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "LoginData";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		LoginPage sp = new LoginPage(driver);

		log.info("Enter Login ID for logging in.");
		WaitClass.WaitForElementisDisplay(driver, 5, enterLoginID);
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
		LoginPage sp = new LoginPage(driver);
		log.info("Enter Password for login");
		WaitClass.WaitForElementisDisplay(driver, 5, enterPassword);
		Assert.assertTrue(enterPassword.isDisplayed());
		enterPassword.sendKeys(sp.ExcelRead(sheetName).get(1));

	}

	private WebElement selectCompany;

	/**
	 * Method to select Comapny.
	 * 
	 * @throws IOException
	 */
	public void selectCompany() throws IOException {
		LoginPage sp = new LoginPage(driver);
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
		log.info("Verifying the login button is available or not");
        Assert.assertTrue(clickLoginButton.isDisplayed());
        clickLoginButton.click();
    }

    @FindBy(how=How.XPATH, using="//span[@class='right-text']")
    private WebElement labelSuccessfulLogin;
    /**
     * Method to verify Label is present after successful login.
     * @throws IOException 
     */
    public void verifyLabelSuccessfulLogin() throws IOException{
    	LoginPage sp=new LoginPage(driver);
        log.info("Verifying if Label is available or not");
        Assert.assertTrue(labelSuccessfulLogin.getText().contains(sp.ExcelRead(sheetName).get(3)), "Assert Failed as its unable to search text in Logged in Page");
    }

    
    private WebElement enterURL;
    /**
     * Method to enter signup url to create child company.
     * @throws IOException 
     */
    public void enterURL() throws IOException{
    	LoginPage sp=new LoginPage(driver);
        log.info("enter signup url to create child company");
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url");
        driver.get(url);
//        WaitClass.WaitForElementisDisplay(driver, 5, enterURL);
//        Assert.assertTrue(enterURL.isDisplayed());
//        ((WebDriver) enterURL).get("http://www.simplebilling.co.in:8080/signup");

    }
    
    //@FindBy(how=How.XPATH, using="//*[@id="company-edit-form"]/fieldset/div[1]/div[2]/div[1]/span/h")
    private WebElement labelRootCompany;
    /**
     * Method to verify Label root company is present after successful login.
     * @throws IOException 
     */
    public void labelRootCompany() throws IOException{
    	LoginPage sp=new LoginPage(driver);
        log.info("Verifying if Label is available or not");
        String RootCompanyName = sp.ExcelRead(sheetName).get(3); 
        String ActualRootCompany = driver.findElement(By.xpath("//*[@id='company-edit-form']/fieldset/div[1]/div[2]/div[1]/span/h")).getText();
        System.out.println("Company Name:********" +ActualRootCompany+ "*********");
        log.info("Click on customer name");
        JavaScriptExec.sleep();
        //WaitClass.WaitForElementisDisplay(driver, 10, labelRootCompany);
        //Assert.assertTrue(labelRootCompany.getText().contains(sp.ExcelRead().get(3)), "Assert Failed as its unable to search text in Logged in Page");
        Assert.assertEquals(ActualRootCompany, RootCompanyName);
    }
    
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        JavaScriptExec.sleep();
    }


}
