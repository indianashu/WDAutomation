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
    
    
    private WebElement selectCompany1;
    /**
     * Method to select companies.
     * @throws IOException 
     */
    public void selectCompany1() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        WebElement Companyelement = driver.findElement(By.xpath("//select[@name='entities']"));
        Select se = new Select(Companyelement);
        se.selectByVisibleText(BasePage.getCellData(xlsxName,sheetName,2,0));

    }
    
    private WebElement selectCompany2;
    /**
     * Method to select companies.
     * @throws IOException 
     */
    public void selectCompany2() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        WebElement Companyelement = driver.findElement(By.xpath("//select[@name='entities']"));
        Select se = new Select(Companyelement);
        se.selectByVisibleText(BasePage.getCellData(xlsxName,sheetName,4,0));

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
    	int row = 0;
    	for (int i= row; row <=8; i++ ) {
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
   /* @FindBy(how=How.XPATH, using="//*[@name=\"mydate\"]")
    private WebElement enterPastPriceDate;
    *//**
     * Method to Enter Price Date.
     * @throws IOException 
     *//*
    public void enterPastPriceDate() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        log.info("Enter Price Date");
        navigateBottom();
        WaitClass.WaitForElementisDisplay(driver, 5, enterPastPriceDate);
        Assert.assertTrue(enterPastPriceDate.isDisplayed());
        enterPastPriceDate.clear();
        enterPastPriceDate.sendKeys(BasePage.getCellData(xlsxName,sheetName,6,0));
        
    }*/
    
    private WebElement selectPriceCompany;
    /**
     * Method to select company in Prices.
     * @throws IOException 
     */
    public void selectPriceCompany() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        WebElement Companieselement = driver.findElement(By.xpath("//select[@name='product.entity']"));
        Select se = new Select(Companieselement);
        se.selectByVisibleText(BasePage.getCellData(xlsxName,sheetName,2,0));

    }
    
    private WebElement selectPastCurrencyUSD;
    /**
     * Method to select price currency.
     * @throws IOException 
     */
    public void selectCurrencyUSD() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        WebElement Currencyelement = driver.findElement(By.xpath("//select[@name='product.currencies']"));
        Select se = new Select(Currencyelement);
        se.selectByVisibleText(sp.ExcelRead(sheetName,xlsxName).get(7));

    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.rate']")
    private WebElement enterPriceRatePastUSD;
    /**
     * Method to Enter Price Rate.
     * @throws IOException 
     */
    public void enterPriceRatePastUSD() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        log.info("Enter Price Rate");
        JavaScriptExec.sleep();
        Assert.assertTrue(enterPriceRatePastUSD.isDisplayed());
        enterPriceRatePastUSD.clear();
        enterPriceRatePastUSD.sendKeys(sp.ExcelRead(sheetName,xlsxName).get(8));
        
    }
    
    private WebElement selectPastCurrencyCAD;
    /**
     * Method to select price currency.
     * @throws IOException 
     */
    public void selectCurrencyCAD() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        WebElement Currencyelement = driver.findElement(By.xpath("//select[@name='product.currencies']"));
        Select se = new Select(Currencyelement);
        se.selectByVisibleText(sp.ExcelRead(sheetName,xlsxName).get(9));

    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.rate']")
    private WebElement enterPriceRatePastCAD;
    /**
     * Method to Enter Price Rate.
     * @throws IOException 
     */
    public void enterPriceRatePastCAD() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        log.info("Enter Price Rate");
        JavaScriptExec.sleep();
        Assert.assertTrue(enterPriceRatePastCAD.isDisplayed());
        enterPriceRatePastCAD.clear();
        enterPriceRatePastCAD.sendKeys(sp.ExcelRead(sheetName,xlsxName).get(10));
        
    }
    
    private WebElement selectPastCurrencyEuro;
    /**
     * Method to select price currency.
     * @throws IOException 
     */
    public void selectCurrencyEuro() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        WebElement Currencyelement = driver.findElement(By.xpath("//select[@name='product.currencies']"));
        Select se = new Select(Currencyelement);
        se.selectByVisibleText(sp.ExcelRead(sheetName,xlsxName).get(11));

    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.rate']")
    private WebElement enterPriceRatePastEuro;
    /**
     * Method to Enter Price Rate.
     * @throws IOException 
     */
    public void enterPriceRatePastEuro() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        log.info("Enter Price Rate");
        JavaScriptExec.sleep();
        Assert.assertTrue(enterPriceRatePastEuro.isDisplayed());
        enterPriceRatePastEuro.clear();
        enterPriceRatePastEuro.sendKeys(sp.ExcelRead(sheetName,xlsxName).get(12));
        
    }
    
    @FindBy(how=How.XPATH, using="//*[@name=\"mydate\"]")
    private WebElement enterPresentPriceDate;
    /**
     * Method to Enter Price Date.
     * @throws IOException 
     */
    public void enterPresentPriceDate() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        log.info("Enter Price Date");
        navigateBottom();
        WaitClass.WaitForElementisDisplay(driver, 5, enterPresentPriceDate);
        Assert.assertTrue(enterPresentPriceDate.isDisplayed());
        SimpleDateFormat DtFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        enterPresentPriceDate.sendKeys(DtFormat.format(date).toString());
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.rate']")
    private WebElement enterPriceRatePresentUSD;
    /**
     * Method to Enter Price Rate.
     * @throws IOException 
     */
    public void enterPriceRatePresentUSD() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        log.info("Enter Price Rate");
        JavaScriptExec.sleep();
        Assert.assertTrue(enterPriceRatePresentUSD.isDisplayed());
        enterPriceRatePresentUSD.clear();
        enterPriceRatePresentUSD.sendKeys(sp.ExcelRead(sheetName,xlsxName).get(14));
        
    }
    
    
    @FindBy(how=How.XPATH, using="//input[@name='product.rate']")
    private WebElement enterPriceRatePresentCAD;
    /**
     * Method to Enter Price Rate.
     * @throws IOException 
     */
    public void enterPriceRatePresentCAD() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        log.info("Enter Price Rate");
        JavaScriptExec.sleep();
        Assert.assertTrue(enterPriceRatePresentCAD.isDisplayed());
        enterPriceRatePresentCAD.clear();
        enterPriceRatePresentCAD.sendKeys(sp.ExcelRead(sheetName,xlsxName).get(15));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.rate']")
    private WebElement enterPriceRatePresentEuro;
    /**
     * Method to Enter Price Rate.
     * @throws IOException 
     */
    public void enterPriceRatePresentEuro() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        log.info("Enter Price Rate");
        JavaScriptExec.sleep();
        Assert.assertTrue(enterPriceRatePresentEuro.isDisplayed());
        enterPriceRatePresentEuro.clear();
        enterPriceRatePresentEuro.sendKeys(sp.ExcelRead(sheetName,xlsxName).get(16));
        
    }
    
    @FindBy(how=How.XPATH, using="//*[@name=\"mydate\"]")
    private WebElement enterFuturePriceDate;
    /**
     * Method to Enter Price Date.
     * @throws IOException 
     */
    public void enterFuturePriceDate() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        log.info("Enter Price Date");
        navigateBottom();
        WaitClass.WaitForElementisDisplay(driver, 5, enterPresentPriceDate);
        Assert.assertTrue(enterFuturePriceDate.isDisplayed());
        enterFuturePriceDate.clear();
        enterFuturePriceDate.sendKeys(sp.ExcelRead(sheetName,xlsxName).get(17));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.rate']")
    private WebElement enterPriceRateFutureUSD;
    /**
     * Method to Enter Price Rate.
     * @throws IOException 
     */
    public void enterPriceRateFutureUSD() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        log.info("Enter Price Rate");
        JavaScriptExec.sleep();
        Assert.assertTrue(enterPriceRateFutureUSD.isDisplayed());
        enterPriceRateFutureUSD.clear();
        enterPriceRateFutureUSD.sendKeys(sp.ExcelRead(sheetName,xlsxName).get(18));
        
    }
    
    
    @FindBy(how=How.XPATH, using="//input[@name='product.rate']")
    private WebElement enterPriceRateFutureCAD;
    /**
     * Method to Enter Price Rate.
     * @throws IOException 
     */
    public void enterPriceRateFutureCAD() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        log.info("Enter Price Rate");
        JavaScriptExec.sleep();
        Assert.assertTrue(enterPriceRateFutureCAD.isDisplayed());
        enterPriceRateFutureCAD.clear();
        enterPriceRateFutureCAD.sendKeys(sp.ExcelRead(sheetName,xlsxName).get(19));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.rate']")
    private WebElement enterPriceRateFutureEuro;
    /**
     * Method to Enter Price Rate.
     * @throws IOException 
     */
    public void enterPriceRateFutureEuro() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        log.info("Enter Price Rate");
        JavaScriptExec.sleep();
        Assert.assertTrue(enterPriceRateFutureEuro.isDisplayed());
        enterPriceRateFutureEuro.clear();
        enterPriceRateFutureEuro.sendKeys(sp.ExcelRead(sheetName,xlsxName).get(16));
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add Price']")
    private WebElement clickAddPriceButton;
    /**
     * Method to click on Add Price Button.
     * @throws IOException 
     */
    public void clickAddPriceButton() throws IOException{
    	AddProductCategoryPage1 sp=new AddProductCategoryPage1(driver);
        log.info("Click on Add Price Button");
        JavaScriptExec.sleep();
        Assert.assertTrue(clickAddPriceButton.isDisplayed());
        clickAddPriceButton.click();
        
    }
    
	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}

}
