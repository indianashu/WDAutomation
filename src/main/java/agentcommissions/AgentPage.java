package agentcommissions;

import baseClassPackage.BasePage;
import categoryProducts.AddProductPage;
import customer.CustomerPage;
import customer.MakePaymentPage;
import reports.ReportsPage;

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
import webDataPages.LoginPage;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Ashutosh
 *
 */

public class AgentPage extends BasePage {
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public AgentPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(AgentPage.class);
	AgentPage agentPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "Agent";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		AgentPage sp = new AgentPage(driver);

		log.info("Verifying the Login ID is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, enterLoginID);
		Assert.assertTrue(enterLoginID.isDisplayed());
		enterLoginID.sendKeys(sp.ExcelRead(sheetName).get(0));
	}

    @FindBy(how=How.XPATH,using="//input[@name='j_password']")
    private WebElement enterPassword;
    /**
     * Method to enter Password.
     * @throws IOException 
     */
    public void enterPassword() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Verifying the First Name is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterPassword);
        Assert.assertTrue(enterPassword.isDisplayed());
        enterPassword.sendKeys(sp.ExcelRead(sheetName).get(1));

    }

    private WebElement selectCompany;
    /**
     * Method to select Company.
     * @throws IOException 
     */
    public void selectCompany() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        WebElement Companyelement = driver.findElement(By.xpath("//select[@name='j_client_id']"));
        Select se = new Select(Companyelement);
        se.selectByVisibleText(sp.ExcelRead(sheetName).get(2));

    }

    @FindBy(how=How.XPATH,using="//a[@class='submit save']")
    private WebElement clickLoginButton;
    /**
     * Method to Click on  Save Changes Button
     */
    public void clickLoginButton(){
    	AgentPage sp=new AgentPage(driver);
        log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
        Assert.assertTrue(clickLoginButton.isDisplayed());
        clickLoginButton.click();
    }

    @FindBy(how=How.XPATH, using="//*[@id='menu.link.partners']/a")
    private WebElement clickAgentTab;
    /**
     * Method to click on Agent tab after successful login.
     * @throws IOException 
     */
    public void clickAgentTab() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Click on Agent Tab after successful login");
        JavaScriptExec.sleep();
        clickAgentTab.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add New']")
    private WebElement clickAddNewButton;
    /**
     * Method to click on add new button".
     * @throws IOException 
     */
    public void clickAddNewButton() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Click on add new button");
        Assert.assertTrue(clickAddNewButton.isDisplayed());
        clickAddNewButton.click();
        JavaScriptExec.sleep();
        
    }
    
    
    @FindBy(how=How.XPATH, using="//input[@name='user.userName']")
    private WebElement enterLoginName;
    /**
     * Method to Enter Login Name.
     * @throws IOException 
     */
    public void enterLoginName() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Enter Login Name");
        Assert.assertTrue(enterLoginName.isDisplayed());
        enterLoginName.sendKeys(sp.ExcelRead(sheetName).get(3));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='contact.email']")
    private WebElement enterEmail;
    /**
     * Method to Enter Email.
     * @throws IOException 
     */
    public void enterEmail() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Enter Product Code");
        Assert.assertTrue(enterEmail.isDisplayed());
        enterEmail.sendKeys(sp.ExcelRead(sheetName).get(4));
        
    }
    
    
    private WebElement selectAgentType;
    /**
     * Method to select agent type.
     * @throws IOException 
     */
    public void selectAgentType() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        WebElement AgentTypeelement = driver.findElement(By.xpath("//select[@name='type']"));
        Select se = new Select(AgentTypeelement);
        se.selectByVisibleText(sp.ExcelRead(sheetName).get(5));

    }

    private WebElement selectCommissionType;
    /**
     * Method to select commission type.
     * @throws IOException 
     */
    public void selectCommissionType() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        WebElement CommissionTypeelement = driver.findElement(By.xpath("//select[@name='commissionType']"));
        Select se = new Select(CommissionTypeelement);
        se.selectByVisibleText(sp.ExcelRead(sheetName).get(6));

    }
    
    public WebElement getAgentID;
    /**
     * Method to Get Agent ID.
     * @throws IOException 
     */
    public void getAgentID() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Get Customer ID");
        JavaScriptExec.sleep();
        String AgentID = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
        System.out.print("Agent ID is ------>" + AgentID + "<------- Got it.");
        return;
        
    }
    
    @FindBy(how=How.XPATH, using="//*[@id='menu.link.customers']/a")
    private WebElement clickCustomerTab;
    /**
     * Method to click on Customer Tab.
     * @throws IOException 
     */
    public void clickCustomerTab() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Click on Customer Tab");
        JavaScriptExec.sleep();
        Assert.assertTrue(clickCustomerTab.isDisplayed());
        clickCustomerTab.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add New']")
    private WebElement clickAddNewCustomerButton;
    /**
     * Method to click on Add new customer button.
     * @throws IOException 
     */
    public void clickAddNewCustomerButton() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Click on Customer Tab");
        navigateBottom();
        Assert.assertTrue(clickAddNewCustomerButton.isDisplayed());
        clickAddNewCustomerButton.click();
        
    }
        
    private WebElement selectUserCompany;
    /**
     * Method to select user company.
     * @throws IOException 
     */
    public void selectUserCompany() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        WebElement Usercompanyelement = driver.findElement(By.xpath("//select[@name='user.entityId']"));
        Select se = new Select(Usercompanyelement);
        se.selectByVisibleText(sp.ExcelRead(sheetName).get(7));

    }
    
    private WebElement selectAccountType;
    /**
     * Method to select account type.
     * @throws IOException 
     */
    public void selectAccountType() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        WebElement AccountTypeelement = driver.findElement(By.xpath("//select[@name='accountTypeId']"));
        Select se = new Select(AccountTypeelement);
        se.selectByVisibleText(sp.ExcelRead(sheetName).get(8));

    }    

    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Select']")
    private WebElement clickSelectButton;
    /**
     * Method to click on select Button.
     * @throws IOException 
     */
    public void clickSelectButton() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Click on select Button");
        Assert.assertTrue(clickSelectButton.isDisplayed());
        clickSelectButton.click();
        JavaScriptExec.sleep();
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='user.userName']")
    private WebElement enterLoginName1;
    /**
     * Method to Enter Login Name.
     * @throws IOException 
     */
    public void enterLoginName1() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Enter Login Name");
        Assert.assertTrue(enterLoginName1.isDisplayed());
        enterLoginName1.sendKeys(sp.ExcelRead(sheetName).get(9));
        
    }
    
    public void selectCurrency() throws IOException {
    	AgentPage sp=new AgentPage(driver);
		WebElement Currencyelement = driver.findElement(By.xpath("//select[@name='user.currencyId']"));
		Select se = new Select(Currencyelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(21));
	}
    
    @FindBy(how=How.XPATH, using="//input[@name='user.partnerId']")
    private WebElement enterAgentID;
    /**
     * Method to Enter Agent ID.
     * @throws IOException 
     */
    public void enterAgentID(String AgentId) throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Enter Agent ID");
        Assert.assertTrue(enterAgentID.isDisplayed());
        enterAgentID.sendKeys(AgentId);
        
    }

    private WebElement selectPaymentMethodType;
    /**
     * Method to select payment method type.
     * @throws IOException
     */
    public void selectPaymentMethodType() throws IOException{
        AgentPage sp=new AgentPage(driver);
        WebElement PMTelement = driver.findElement(By.xpath("//select[@name='paymentMethod_0.paymentMethodTypeId']"));
        Select se = new Select(PMTelement);
        se.selectByVisibleText(sp.ExcelRead(sheetName).get(20));
        JavaScriptExec.sleep();

    }
    
    @FindBy(how=How.XPATH, using="//input[@name='paymentMethod_0.processingOrder']")
    private WebElement enterProcessingOrder;
    /**
     * Method to Enter Processing Order.
     * @throws IOException 
     */
    public void enterProcessingOrder() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Click on Save Changes Button");
        JavaScriptExec.scrolltoBottomofPage(driver);
        Assert.assertTrue(enterProcessingOrder.isDisplayed());
        enterProcessingOrder.sendKeys(sp.ExcelRead(sheetName).get(17));
        
    }
    
    @FindBy(how=How.XPATH, using="//label[contains(.,'cc.cardholder.name')]/following::input[1]")
    private WebElement enterCardHolderName;
    /**
     * Method to Enter card holder name.
     * @throws IOException 
     */
    public void enterCardHolderName() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Enter card holder name");
        Assert.assertTrue(enterCardHolderName.isDisplayed());
        enterCardHolderName.sendKeys(sp.ExcelRead(sheetName).get(9));
        
    }
    
    @FindBy(how=How.XPATH, using="//label[contains(.,'cc.number')]/following::input[1]")
    private WebElement enterCardNumber;
    /**
     * Method to Enter card number.
     * @throws IOException 
     */
    public void enterCardNumber() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Enter card number");
        Assert.assertTrue(enterCardNumber.isDisplayed());
        enterCardNumber.sendKeys(sp.ExcelRead(sheetName).get(18));
        
    }
    
    @FindBy(how=How.XPATH, using="//label[contains(.,'cc.expiry.date')]/following::input[1]")
    private WebElement enterCardExpiry;
    /**
     * Method to Enter card expiry date.
     * @throws IOException 
     */
    public void enterCardExpiry() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Enter card number");
        Assert.assertTrue(enterCardExpiry.isDisplayed());
        enterCardExpiry.sendKeys(sp.ExcelRead(sheetName).get(19));
        
    }
    //////////////
    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Save Changes']")
    private WebElement clickSaveChangesButton;
    /**
     * Method to click on Save Changes Button.
     * @throws IOException 
     */
    public void clickSaveChangesButton() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Click on Save Changes Button");
        JavaScriptExec.scrolltoBottomofPage(driver);
        Assert.assertTrue(clickSaveChangesButton.isDisplayed());
        clickSaveChangesButton.click();
        
    }

    @FindBy(how=How.XPATH, using="//div[@class='msg-box successfully']//*[text()='Done']")
    private WebElement verifyAgentAndFetchAgentId;
    /**
     * Method to verify Agent is created Successfully.
     * @throws IOException
     */
    public String verifyAgentAndFetchAgentId() throws IOException{
        AgentPage sp=new AgentPage(driver);
        log.info("Verifying if Agent is created Successfully or not");
        JavaScriptExec.sleep();
        Assert.assertTrue(verifyAgentAndFetchAgentId.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
        String AgentId = driver.findElement(By.xpath("//td[text()='Agent ID']/following::td[1]")).getText();
        return AgentId;
    }

    @FindBy(how=How.XPATH, using="//div[@class='msg-box successfully']//*[text()='Done']")
    private WebElement verifyConfirmationMsg;
    /**
     * Method to verify Account Type is created Successfully.
     * @throws IOException 
     */
    public void verifyConfirmationMsg() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Verifying if Account Type is created Successfully or not");
        JavaScriptExec.sleep();
        Assert.assertTrue(verifyConfirmationMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
    @FindBy(how=How.XPATH, using="//*[@id='menu.link.products']/a")
    private WebElement clickProductTab;
    /**
     * Method to click on Product Tab.
     * @throws IOException 
     */
    public void clickProductTab() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Click on Product Tab");
        JavaScriptExec.sleep();
        Assert.assertTrue(clickProductTab.isDisplayed());
        clickProductTab.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add Category']")
    private WebElement clickAddCategoryButton;
    /**
     * Method to click on Add Category Button.
     * @throws IOException 
     */
    public void clickAddCategoryButton() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Click on Add Category Button");
        JavaScriptExec.scrolltoBottomofPage(driver);
        Assert.assertTrue(clickAddCategoryButton.isDisplayed());
        clickAddCategoryButton.click();
        JavaScriptExec.sleep();
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='description']")
    private WebElement enterCategoryName;
    /**
     * Method to Enter Name for Category.
     * @throws IOException 
     */
    public void enterCategoryName() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Enter Name for Category");
        Assert.assertTrue(enterCategoryName.isDisplayed());
        enterCategoryName.sendKeys(sp.ExcelRead(sheetName).get(11));
        
    }
    
    //@FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Commissioned Product']")
    private WebElement clickProductCategoryName;
    /**
     * Method to click on Product Category Name - Commissioned Product.
     * @throws IOException 
     */
    public void clickProductCategoryName() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Click on Product Category Name - Commissioned Product");
        String ProductName = sp.ExcelRead(sheetName).get(11);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+ProductName+"']")).click();
        JavaScriptExec.sleep();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add Product']")
    private WebElement clickAddProductButton;
    /**
     * Method to click on Add Product Button".
     * @throws IOException 
     */
    public void clickAddProductButton() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Click on Add Product Button");
        Assert.assertTrue(clickAddProductButton.isDisplayed());
        clickAddProductButton.click();
        JavaScriptExec.sleep();
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.descriptions[0].content']")
    private WebElement enterEnglishDescription;
    /**
     * Method to Enter English Description.
     * @throws IOException 
     */
    public void enterEnglishDescription() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Enter English Description");
        Assert.assertTrue(enterEnglishDescription.isDisplayed());
        enterEnglishDescription.sendKeys(sp.ExcelRead(sheetName).get(12));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.number']")
    private WebElement enterProductCode;
    /**
     * Method to Enter Product Code.
     * @throws IOException 
     */
    public void enterProductCode() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Enter Product Code");
        Assert.assertTrue(enterProductCode.isDisplayed());
        enterProductCode.sendKeys(sp.ExcelRead(sheetName).get(13));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.standardPartnerPercentageAsDecimal']")
    private WebElement enterStdCommission;
    /**
     * Method to Enter Standard Agent Commission.
     * @throws IOException 
     */
    public void enterStdCommission() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Enter Standard Agent Commission");
        Assert.assertTrue(enterStdCommission.isDisplayed());
        enterStdCommission.sendKeys(sp.ExcelRead(sheetName).get(14));
        
    }
   
    
    @FindBy(how=How.XPATH, using="//input[@name='product.masterPartnerPercentageAsDecimal']")
    private WebElement enterMasterCommission;
    /**
     * Method to Enter Master Agent Commission.
     * @throws IOException 
     */
    public void enterMasterCommission() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Enter Master Agent Commission");
        Assert.assertTrue(enterMasterCommission.isDisplayed());
        enterMasterCommission.sendKeys(sp.ExcelRead(sheetName).get(15));
        
    }
    
    public void selectPriceCurrency() throws IOException {
		AddProductPage sp = new AddProductPage(driver);
		WebElement Currencyelement = driver.findElement(By.xpath("//select[@name='product.currencies']"));
		Select se = new Select(Currencyelement);
		se.selectByVisibleText(sp.ExcelRead(sheetName).get(21));
	}
    
    @FindBy(how=How.XPATH, using="//input[@name='product.rate']")
    private WebElement enterPriceRate;
    /**
     * Method to Enter Price Rate.
     * @throws IOException 
     */
    public void enterPriceRate() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Enter Price Rate");
        JavaScriptExec.scrolltoBottomofPage(driver);
        Assert.assertTrue(enterPriceRate.isDisplayed());
        enterPriceRate.sendKeys(sp.ExcelRead(sheetName).get(16));
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add Price']")
    private WebElement clickAddPriceButton;
    /**
     * Method to click on Add Price Button.
     * @throws IOException 
     */
    public void clickAddPriceButton() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Click on Add Price Button");
        Assert.assertTrue(clickAddPriceButton.isDisplayed());
        clickAddPriceButton.click();
        
    }
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        JavaScriptExec.sleep();
    }

}

