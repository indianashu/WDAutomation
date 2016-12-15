package categoryProducts;

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
import webDataPages.LoginPage;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Ashutosh
 *
 */

public class AddProductPage extends BasePage{
    /**
     * This constructor is used to initialize the webdriver in BasePage class, if the user does not want to use page factory
     * then this will take care of initialization of the driver
     *
     * @param webdriver
     */
    public AddProductPage(WebDriver webdriver) {
        super(webdriver);
    }

    Logger log=Logger.getLogger(AddProductPage.class);
    AddProductPage addProductPage;
    PropertyValExtractors p = new PropertyValExtractors();
  
    public  ArrayList<String> ExcelRead() throws IOException{
    	

		ArrayList<String> rl=new ArrayList<String>();
		File file=new File(System.getProperty("user.dir") +"/Webdata_TestData.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("AddProduct");
		
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
    

    @FindBy(how=How.XPATH,using="//input[@name='j_username']")
    private WebElement enterLoginID;
    /**
     * Method to enter login ID.
     * @throws IOException 
     */
    public void enterLoginID() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
    	
        log.info("Verifying the Login ID is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterLoginID);
        Assert.assertTrue(enterLoginID.isDisplayed());
        enterLoginID.sendKeys(sp.ExcelRead().get(0));
    }

    @FindBy(how=How.XPATH,using="//input[@name='j_password']")
    private WebElement enterPassword;
    /**
     * Method to enter Password.
     * @throws IOException 
     */
    public void enterPassword() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        log.info("Verifying the First Name is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterPassword);
        Assert.assertTrue(enterPassword.isDisplayed());
        enterPassword.sendKeys(sp.ExcelRead().get(1));

    }

    private WebElement selectCompany;
    /**
     * Method to select Comapny.
     * @throws IOException 
     */
    public void selectCompany() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        WebElement Companyelement = driver.findElement(By.xpath("//select[@name='j_client_id']"));
        Select se = new Select(Companyelement);
        se.selectByVisibleText(sp.ExcelRead().get(2));

    }

    @FindBy(how=How.XPATH,using="//a[@class='submit save']")
    private WebElement clickLoginButton;
    /**
     * Method to Click on  Save Changes Button
     */
    public void clickLoginButton(){
    	AddProductPage sp=new AddProductPage(driver);
        log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
        Assert.assertTrue(clickLoginButton.isDisplayed());
        clickLoginButton.click();
    }

    @FindBy(how=How.XPATH, using="//a[.='Products']")
    private WebElement clickProductsTab;
    /**
     * Method to click on Products tab after successful login.
     * @throws IOException 
     */
    public void clickProductsTab() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        log.info("Click on Products Tab after successful login");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickProductsTab);
        Assert.assertTrue(clickProductsTab.isDisplayed());
        clickProductsTab.click();
        
    }
    
    //@FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='New Test Category1']")
    private WebElement selectCategoryName;
    /**
     * Method to click on a category name.
     * @throws IOException 
     */
    public void selectCategoryName() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        log.info("Click on a category name.");
        WaitClass.sleep(2000);
        String CategoryName = "New Test Category1";
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+CategoryName+"']")).click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add Product']")
    private WebElement clickAddProductButton;
    /**
     * Method to click on Add Product Button".
     * @throws IOException 
     */
    public void clickAddProductButton() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        log.info("Click on Add Product Button");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddProductButton);
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
    	AddProductPage sp=new AddProductPage(driver);
        log.info("Enter English Description");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterEnglishDescription);
        Assert.assertTrue(enterEnglishDescription.isDisplayed());
        enterEnglishDescription.sendKeys(sp.ExcelRead().get(3));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.number']")
    private WebElement enterProductCode;
    /**
     * Method to Enter Product Code.
     * @throws IOException 
     */
    public void enterProductCode() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        log.info("Enter Product Code");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterProductCode);
        Assert.assertTrue(enterProductCode.isDisplayed());
        enterProductCode.sendKeys(sp.ExcelRead().get(4));
        
    }
    
    @FindBy(how=How.XPATH, using="//*[@name=\"product.standardAvailability\"]")
    private WebElement selectStandardAvailability;
    /**
     * Method to Uncheck Standard Availability Checkbox.
     * @throws IOException 
     */
    public void selectStandardAvailability() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        log.info("Uncheck Standard Availability Checkbox");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, selectStandardAvailability);
        Assert.assertTrue(selectStandardAvailability.isDisplayed());
        selectStandardAvailability.click();
        WaitClass.sleep(1000);
        driver.findElement(By.xpath("//*[@name=\"product.accountTypes\"]/option[2]")).click();
    }
    
    
    private WebElement selectCompanies;
    /**
     * Method to select companies.
     * @throws IOException 
     */
    public void selectCompanies() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        WebElement Companieselement = driver.findElement(By.xpath("//select[@name='product.entities']"));
        Select se = new Select(Companieselement);
        se.selectByVisibleText(sp.ExcelRead().get(5));

    }

    @FindBy(how=How.XPATH, using="//*[@name=\"mydate\"]")
    private WebElement enterPriceDate;
    /**
     * Method to Uncheck Standard Availability Checkbox.
     * @throws IOException 
     */
    public void enterPriceDate() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        log.info("Uncheck Standard Availability Checkbox");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterPriceDate);
        Assert.assertTrue(enterPriceDate.isDisplayed());
        enterPriceDate.clear();
        enterPriceDate.sendKeys(sp.ExcelRead().get(6));;
        
    }
    
    private WebElement selectPriceCompany;
    /**
     * Method to select company in Prices.
     * @throws IOException 
     */
    public void selectPriceCompany() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        WebElement Companieselement = driver.findElement(By.xpath("//select[@name='product.entity']"));
        Select se = new Select(Companieselement);
        se.selectByVisibleText(sp.ExcelRead().get(7));

    }
    
    private WebElement selectPriceCurrency;
    /**
     * Method to select price currency.
     * @throws IOException 
     */
    public void selectPriceCurrency() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        WebElement Currencyelement = driver.findElement(By.xpath("//select[@name='product.currencies']"));
        Select se = new Select(Currencyelement);
        se.selectByVisibleText(sp.ExcelRead().get(8));

    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.rate']")
    private WebElement enterPriceRate;
    /**
     * Method to Enter Price Rate.
     * @throws IOException 
     */
    public void enterPriceRate() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        log.info("Enter Price Rate");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterPriceRate);
        Assert.assertTrue(enterPriceRate.isDisplayed());
        enterPriceRate.sendKeys(sp.ExcelRead().get(9));;
        
    }
    
    
    @FindBy(how=How.XPATH, using="//*[@name=\"mydate\"]")
    private WebElement enterPriceDate1;
    /**
     * Method to Uncheck Standard Availability Checkbox.
     * @throws IOException 
     */
    public void enterPriceDate1() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        log.info("Uncheck Standard Availability Checkbox");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterPriceDate1);
        Assert.assertTrue(enterPriceDate1.isDisplayed());
        enterPriceDate1.clear();
        enterPriceDate1.sendKeys(sp.ExcelRead().get(10));;
        
    }
    
    private WebElement selectPriceCompany1;
    /**
     * Method to select company in Prices.
     * @throws IOException 
     */
    public void selectPriceCompany1() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        WebElement Companieselement = driver.findElement(By.xpath("//select[@name='product.entity']"));
        Select se = new Select(Companieselement);
        se.selectByVisibleText(sp.ExcelRead().get(11));

    }
    
    private WebElement selectPriceCurrency1;
    /**
     * Method to select price currency.
     * @throws IOException 
     */
    public void selectPriceCurrency1() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        WebElement Currencyelement = driver.findElement(By.xpath("//select[@name='product.currencies']"));
        Select se = new Select(Currencyelement);
        se.selectByVisibleText(sp.ExcelRead().get(12));

    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.rate']")
    private WebElement enterPriceRate1;
    /**
     * Method to Enter Price Rate.
     * @throws IOException 
     */
    public void enterPriceRate1() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        log.info("Enter Price Rate");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterPriceRate1);
        enterPriceRate1.clear();
        Assert.assertTrue(enterPriceRate1.isDisplayed());
        enterPriceRate1.sendKeys(sp.ExcelRead().get(13));;
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add Price']")
    private WebElement clickAddPriceButton;
    /**
     * Method to click on Add Price Button.
     * @throws IOException 
     */
    public void clickAddPriceButton() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        log.info("Click on Add Price Button");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddPriceButton);
        Assert.assertTrue(clickAddPriceButton.isDisplayed());
        clickAddPriceButton.click();
        
    }
    
    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Save Changes']")
    private WebElement clickSaveChangesButton;
    /**
     * Method to click on Save Changes Button.
     * @throws IOException 
     */
    public void clickSaveChangesButton() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        log.info("Click on Save Changes Button");
        WaitClass.sleep(2000);
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
    	AddProductPage sp=new AddProductPage(driver);
        log.info("Verifying if Account Type is created Successfully or not");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyConfirmationMsg);
        Assert.assertTrue(verifyConfirmationMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
    
    //@FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Test Abc']")
    private WebElement clickProductName;
    /**
     * Method to click on Product name Test Abc.
     * @throws IOException 
     */
    public void clickProductName() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        log.info("Click on Product Name Test Abc");
        WaitClass.sleep(2000);
        String ProductName = sp.ExcelRead().get(4);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+ProductName+"']")).click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit edit']//*[text()='Edit']")
    private WebElement clickEditProduct;
    /**
     * Method to Click Edit button.
     * @throws IOException 
     */
    public void clickEditProduct() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        log.info("Enter Edit Button");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickEditProduct);
        Assert.assertTrue(clickEditProduct.isDisplayed());
        clickEditProduct.click();
    }
    
    
    @FindBy(how=How.XPATH, using="//input[@name='product.descriptions[0].content']")
    private WebElement editEnglishDescription;
    /**
     * Method to Edit English Description.
     * @throws IOException 
     */
    public void editEnglishDescription() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        log.info("Edit English Description");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, editEnglishDescription);
        Assert.assertTrue(editEnglishDescription.isDisplayed());
        editEnglishDescription.sendKeys(sp.ExcelRead().get(14)); 
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.descriptions[0].content']")
    private WebElement editProductCode;
    /**
     * Method to Edit Product Code.
     * @throws IOException 
     */
    public void editProductCode() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        log.info("Edit Product Code");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, editProductCode);
        Assert.assertTrue(editProductCode.isDisplayed());
        editProductCode.sendKeys(sp.ExcelRead().get(15)); 
    }   
    
    @FindBy(how=How.XPATH, using="//a[@class='submit copy']//*[text()='Copy Product']")
    private WebElement clickCopyProductButton;
    /**
     * Method to Click Copy Product Button.
     * @throws IOException 
     */
    public void clickCopyProductButton() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        log.info("Click Copy Product Button");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickCopyProductButton);
        Assert.assertTrue(clickCopyProductButton.isDisplayed());
        clickCopyProductButton.sendKeys(sp.ExcelRead().get(15)); 
    }
    
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        WaitClass.sleep(5000);
    }


}
