package productHistorical;

import baseClassPackage.BasePage;
import categoryProducts.AddProductPage;
import companyHierarchy.ViewAssignedInfoPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.log4j.Logger;
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

public class AddProductCategoryPage1 extends BasePage {
	
	public AddProductCategoryPage1(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(AddProductCategoryPage1.class);
	AddProductCategoryPage1 AddProductCategoryPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "AddProductCategory1";
	String xlsxName = "/ProductHistorical_TestData.xlsx";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * @throws Exception 
	 */
	public void enterLoginID() throws Exception {
		AddProductCategoryPage1 sp = new AddProductCategoryPage1(driver);

		log.info("Verifying the Login ID is available or not");
		Assert.assertTrue(enterLoginID.isDisplayed());
		enterLoginID.sendKeys(BasePage.getCellData(xlsxName,sheetName,0,0));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='j_password']")
	private WebElement enterPassword;

	/**
	 * Method to enter Password.
	 * @throws Exception 
	 */
	public void enterPassword() throws Exception {
		AddProductCategoryPage1 sp = new AddProductCategoryPage1(driver);
		log.info("Verifying the First Name is available or not");
		Assert.assertTrue(enterPassword.isDisplayed());
		enterPassword.sendKeys(BasePage.getCellData(xlsxName,sheetName,1,0));

	}

	private WebElement selectCompany;

	/**
	 * Method to select Company.
	 * 
	 * @throws IOException
	 */
	public void selectCompany() throws Exception {
		AddProductCategoryPage1 sp = new AddProductCategoryPage1(driver);
		WebElement Companyelement = driver.findElement(By.xpath("//select[@name='j_client_id']"));
		Select se = new Select(Companyelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName,sheetName,2,0));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']")
	private WebElement clickLoginButton;

	/**
	 * Method to Click on Save Changes Button
	 */
	public void clickLoginButton() {
		AddProductCategoryPage1 sp = new AddProductCategoryPage1(driver);
		log.info("Verifying the login button is available or not");
		Assert.assertTrue(clickLoginButton.isDisplayed());
		clickLoginButton.click();
	}
	@FindBy(how=How.XPATH, using="//*[@id='menu.link.products']/a")
    private WebElement clickProductsTab;
    /**
     * Method to click on Products tab after successful login.
     * @throws IOException 
     */
    public void clickProductsTab() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        log.info("Click on Products Tab after successful login");
        JavaScriptExec.sleep();
        Assert.assertTrue(clickProductsTab.isDisplayed());
        clickProductsTab.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add Category']")
    private WebElement clickAddCategoryButton;
    /**
     * Method to click on Add Category Button.
     * @throws IOException 
     */
    public void clickAddCategoryButton() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        log.info("Click on Add Category Button");
        navigateBottom();
        Assert.assertTrue(clickAddCategoryButton.isDisplayed());
        clickAddCategoryButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='description']")
    private WebElement enterCategoryName;
    /**
     * Method to Enter Category Name.
     * @throws IOException 
     */
    public void enterCategoryName() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        log.info("Enter Category Name");
        JavaScriptExec.sleep();
        Assert.assertTrue(enterCategoryName.isDisplayed());
        enterCategoryName.sendKeys(BasePage.getCellData(xlsxName,sheetName,3,0));
        
    }
    
    
    @FindBy(how = How.XPATH, using = "//input[@name='global']")
	private WebElement checkGlobal;

	/**
	 * Method to Check Global CheckBox.
	 * 
	 * @throws IOException
	 */
	public void checkGlobal() throws IOException {
		AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
		log.info("Check Canadian Currency Checkbox.");
		WaitClass.WaitForElementisDisplay(driver, 5, checkGlobal);
		Assert.assertTrue(checkGlobal.isDisplayed());
		sp.checkGlobal.click();

	}

    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Save Changes']")
    private WebElement clickSaveChangesButton;
    /**
     * Method to click on Save Changes Button.
     * @throws IOException 
     */
    public void clickSaveChangesButton() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        log.info("Click on Save Changes Button");
        navigateBottom();
        WaitClass.WaitForElementisDisplay(driver, 10, clickSaveChangesButton);
        Assert.assertTrue(clickSaveChangesButton.isDisplayed());
        clickSaveChangesButton.click();
        
    }
    @FindBy(how=How.XPATH, using="//div[@class='msg-box successfully']//*[text()='Done']")
    private WebElement verifyConfirmationMsg;
    /**
     * Method to verify Account Type is created Successfully.
     * @throws IOException 
     */
    public void verifyConfirmationMsg() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        log.info("Verifying if Account Type is created Successfully or not");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, verifyConfirmationMsg);
        Assert.assertTrue(verifyConfirmationMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add Product']")
    private WebElement clickAddProductButton;
    /**
     * Method to click on Add Product Button".
     * @throws IOException 
     */
    public void clickAddProductButton() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        log.info("Click on Add Product Button");
        WaitClass.WaitForElementisDisplay(driver, 5, clickAddProductButton);
        Assert.assertTrue(clickAddProductButton.isDisplayed());
        clickAddProductButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.descriptions[0].content']")
    private WebElement enterEnglishDescription;
    /**
     * Method to Enter English Description.
     * @throws IOException 
     */
    public void enterEnglishDescription() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        log.info("Enter English Description");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 5, enterEnglishDescription);
        Assert.assertTrue(enterEnglishDescription.isDisplayed());
        enterEnglishDescription.sendKeys(BasePage.getCellData(xlsxName,sheetName,5,0));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.number']")
    private WebElement enterProductCode;
    /**
     * Method to Enter Product Code.
     * @throws IOException 
     */
    public void enterProductCode() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        log.info("Enter Product Code");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 5, enterProductCode);
        Assert.assertTrue(enterProductCode.isDisplayed());
        enterProductCode.sendKeys(BasePage.getCellData(xlsxName,sheetName,5,0));
        
    }
    
    private WebElement selectProductCompany1;
    /**
     * Method to select companies.
     * @throws IOException 
     */
    public void selectProductCompany1() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        WebElement Companyelement = driver.findElement(By.xpath("//select[@name='product.entities']"));
        Select se = new Select(Companyelement);
        se.selectByVisibleText(BasePage.getCellData(xlsxName,sheetName,2,0));

    }
    
    private WebElement selectProductCompany2;
    /**
     * Method to select companies.
     * @throws IOException 
     */
    public void selectProductCompany2() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        WebElement Companyelement = driver.findElement(By.xpath("//select[@name='product.entities']"));
        Select se = new Select(Companyelement);
        se.selectByVisibleText(BasePage.getCellData(xlsxName,sheetName,4,0));
        navigateBottom();

    }
    
    public void selectHistoricalPrices() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
    	for (int i= 0; i <= 8; i++ ) {
    			WebElement enterPastPriceDate = driver.findElement(By.xpath("//*[@name=\"mydate\"]"));
    			Assert.assertTrue(enterPastPriceDate.isDisplayed());
    	        enterPastPriceDate.clear();
    	        enterPastPriceDate.sendKeys(BasePage.getCellData(xlsxName,sheetName,6,i));
    	        JavaScriptExec.sleep();
    	        
    	        WebElement Currencyelement = driver.findElement(By.xpath("//select[@name='product.currencies']"));
    	        Select se = new Select(Currencyelement);
    	        se.selectByVisibleText(BasePage.getCellData(xlsxName,sheetName,7,i));
    	        JavaScriptExec.sleep();
    	        
    	        WebElement enterPriceRatePastUSD = driver.findElement(By.xpath("//input[@name='product.rate']"));
    	        Assert.assertTrue(enterPriceRatePastUSD.isDisplayed());
    	        enterPriceRatePastUSD.clear();
    	        enterPriceRatePastUSD.sendKeys(BasePage.getCellData(xlsxName,sheetName,8,i));
    	        JavaScriptExec.sleep();
    	        
    	        WebElement clickAddPriceButton = driver.findElement(By.xpath("//a[@class='submit add']//*[text()='Add Price']"));
    	        Assert.assertTrue(clickAddPriceButton.isDisplayed());
    	        clickAddPriceButton.click();
    	            
    	}
    	
    }
    
    public void selectHistoricalPrices1() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
    	for (int i= 0; i <= 8; i++ ) {
    			WebElement enterPastPriceDate = driver.findElement(By.xpath("//*[@name=\"mydate\"]"));
    			Assert.assertTrue(enterPastPriceDate.isDisplayed());
    	        enterPastPriceDate.clear();
    	        enterPastPriceDate.sendKeys(BasePage.getCellData(xlsxName,sheetName,6,i));
    	        JavaScriptExec.sleep();
    	        
    	        WebElement Companieselement = driver.findElement(By.xpath("//select[@name='product.entity']"));
    	        Select se = new Select(Companieselement);
    	        se.selectByVisibleText(BasePage.getCellData(xlsxName,sheetName,4,0));
    	        
    	        WebElement Currencyelement = driver.findElement(By.xpath("//select[@name='product.currencies']"));
    	        Select sel = new Select(Currencyelement);
    	        sel.selectByVisibleText(BasePage.getCellData(xlsxName,sheetName,7,i));
    	        JavaScriptExec.sleep();
    	        
    	        WebElement enterPriceRatePastUSD = driver.findElement(By.xpath("//input[@name='product.rate']"));
    	        Assert.assertTrue(enterPriceRatePastUSD.isDisplayed());
    	        enterPriceRatePastUSD.clear();
    	        enterPriceRatePastUSD.sendKeys(BasePage.getCellData(xlsxName,sheetName,9,i));
    	        JavaScriptExec.sleep();
    	        
    	        WebElement clickAddPriceButton = driver.findElement(By.xpath("//a[@class='submit add']//*[text()='Add Price']"));
    	        Assert.assertTrue(clickAddPriceButton.isDisplayed());
    	        clickAddPriceButton.click();
    	            
    	}
    	
    }
   
    
	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}

}
