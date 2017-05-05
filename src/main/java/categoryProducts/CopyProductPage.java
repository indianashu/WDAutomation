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

public class CopyProductPage extends BasePage{
    /**
     * This constructor is used to initialize the webdriver in BasePage class, if the user does not want to use page factory
     * then this will take care of initialization of the driver
     *
     * @param webdriver
     */
    public CopyProductPage(WebDriver webdriver) {
        super(webdriver);
    }

    Logger log=Logger.getLogger(CopyProductPage.class);
    CopyProductPage addProductPage;
    PropertyValExtractors p = new PropertyValExtractors();
  
    public  ArrayList<String> ExcelRead() throws IOException{
    	

		ArrayList<String> rl=new ArrayList<String>();
		File file=new File(System.getProperty("user.dir") +"/Webdata_TestData.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("CopyProduct");
		
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
    	CopyProductPage sp=new CopyProductPage(driver);
    	
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
    	CopyProductPage sp=new CopyProductPage(driver);
        log.info("Verifying the First Name is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterPassword);
        Assert.assertTrue(enterPassword.isDisplayed());
        enterPassword.sendKeys(sp.ExcelRead().get(1));

    }

    private WebElement selectCompany;
    /**
     * Method to select Company.
     * @throws IOException 
     */
    public void selectCompany() throws IOException{
    	CopyProductPage sp=new CopyProductPage(driver);
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
    	CopyProductPage sp=new CopyProductPage(driver);
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
    	CopyProductPage sp=new CopyProductPage(driver);
        log.info("Click on Products Tab after successful login");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, clickProductsTab);
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
    	ProductCategoryPage sp=new ProductCategoryPage(driver);
        log.info("Click on Add Category Button");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddCategoryButton);
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
        CopyProductPage sp=new CopyProductPage(driver);
        log.info("Enter Category Name");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, enterCategoryName);
        Assert.assertTrue(enterCategoryName.isDisplayed());
        enterCategoryName.sendKeys(sp.ExcelRead().get(3));
        
    }
    
    
    //@FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='New Test Category1']")
    private WebElement selectCategoryName;
    /**
     * Method to click on a category name.
     * @throws IOException 
     */
    public void selectCategoryName() throws IOException{
    	CopyProductPage sp=new CopyProductPage(driver);
        log.info("Click on a category name.");
        JavaScriptExec.sleep();
        String CategoryName = sp.ExcelRead().get(3);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+CategoryName+"']")).click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add Product']")
    private WebElement clickAddProductButton;
    /**
     * Method to click on Add Product Button".
     * @throws IOException 
     */
    public void clickAddProductButton() throws IOException{
    	CopyProductPage sp=new CopyProductPage(driver);
        log.info("Click on Add Product Button");
        JavaScriptExec.sleep();
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
    	CopyProductPage sp=new CopyProductPage(driver);
        log.info("Enter English Description");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, enterEnglishDescription);
        Assert.assertTrue(enterEnglishDescription.isDisplayed());
        enterEnglishDescription.sendKeys(sp.ExcelRead().get(4));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.number']")
    private WebElement enterProductCode;
    /**
     * Method to Enter Product Code.
     * @throws IOException 
     */
    public void enterProductCode() throws IOException{
    	CopyProductPage sp=new CopyProductPage(driver);
        log.info("Enter Product Code");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, enterProductCode);
        Assert.assertTrue(enterProductCode.isDisplayed());
        enterProductCode.sendKeys(sp.ExcelRead().get(5));
        
    }
        
    private WebElement selectCompanies;
    /**
     * Method to select companies.
     * @throws IOException 
     */
    public void selectCompanies() throws IOException{
    	CopyProductPage sp=new CopyProductPage(driver);
        WebElement Companieselement = driver.findElement(By.xpath("//select[@name='product.entities']"));
        Select se = new Select(Companieselement);
        se.selectByVisibleText(sp.ExcelRead().get(6));

    }

    @FindBy(how=How.XPATH, using="//*[@name=\"mydate\"]")
    private WebElement enterPriceDate;
    /**
     * Method to Enter Price Date.
     * @throws IOException 
     */
    public void enterPriceDate() throws IOException{
    	CopyProductPage sp=new CopyProductPage(driver);
        log.info("Enter Price Date");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, enterPriceDate);
        Assert.assertTrue(enterPriceDate.isDisplayed());
        enterPriceDate.clear();
        enterPriceDate.sendKeys(sp.ExcelRead().get(7));
        
    }
    
    private WebElement selectPriceCompany;
    /**
     * Method to select company in Prices.
     * @throws IOException 
     */
    public void selectPriceCompany() throws IOException{
    	CopyProductPage sp=new CopyProductPage(driver);
        WebElement Companieselement = driver.findElement(By.xpath("//select[@name='product.entity']"));
        Select se = new Select(Companieselement);
        se.selectByVisibleText(sp.ExcelRead().get(8));

    }
    
    private WebElement selectPriceCurrency;
    /**
     * Method to select price currency.
     * @throws IOException 
     */
    public void selectPriceCurrency() throws IOException{
    	CopyProductPage sp=new CopyProductPage(driver);
        WebElement Currencyelement = driver.findElement(By.xpath("//select[@name='product.currencies']"));
        Select se = new Select(Currencyelement);
        se.selectByVisibleText(sp.ExcelRead().get(9));

    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.rate']")
    private WebElement enterPriceRate;
    /**
     * Method to Enter Price Rate.
     * @throws IOException 
     */
    public void enterPriceRate() throws IOException{
    	CopyProductPage sp=new CopyProductPage(driver);
        log.info("Enter Price Rate");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, enterPriceRate);
        Assert.assertTrue(enterPriceRate.isDisplayed());
        enterPriceRate.clear();
        enterPriceRate.sendKeys(sp.ExcelRead().get(10));
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add Price']")
    private WebElement clickAddPriceButton;
    /**
     * Method to click on Add Price Button.
     * @throws IOException 
     */
    public void clickAddPriceButton() throws IOException{
    	CopyProductPage sp=new CopyProductPage(driver);
        log.info("Click on Add Price Button");
        JavaScriptExec.sleep();
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
    	CopyProductPage sp=new CopyProductPage(driver);
        log.info("Click on Save Changes Button");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, clickSaveChangesButton);
        Assert.assertTrue(clickSaveChangesButton.isDisplayed());
        clickSaveChangesButton.click();
        
    }
    @FindBy(how=How.XPATH, using="//div[@class='msg-box successfully']//*[text()='Done']")
    private WebElement verifyConfirmationMsg;
    /**
     * Method to verify Product Category is created Successfully.
     * @throws IOException 
     */
    public void verifyConfirmationMsg() throws IOException{
    	CopyProductPage sp=new CopyProductPage(driver);
        log.info("Verifying if Product Category is created Successfully or not");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, verifyConfirmationMsg);
        Assert.assertTrue(verifyConfirmationMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
    
    //////////////////////////////////////////////////////////////////////
    

    //@FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Test Copy Product Desc']")
    private WebElement selectCopyCategory;
    /**
     * Method to select copy category.
     * @throws IOException 
     */
    public void selectCopyCategory() throws IOException{
    	CopyProductPage sp=new CopyProductPage(driver);
        log.info("Enter English Description");
        JavaScriptExec.sleep();
        String CategoryName = sp.ExcelRead().get(3);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+CategoryName+"']")).click();
        
    }

    
    //@FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Test Copy Product Desc']")
    private WebElement selectProduct;
    /**
     * Method to select product.
     * @throws IOException 
     */
    public void selectProduct() throws IOException{
    	CopyProductPage sp=new CopyProductPage(driver);
        log.info("Enter English Description");
        JavaScriptExec.sleep();
        String ProductName = sp.ExcelRead().get(4);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+ProductName+"']")).click();
        
    }
    
  
    @FindBy(how=How.XPATH, using="//a[@class='submit copy']//*[text()='Copy Product']")
    private WebElement clickCopyProductButton;
    /**
     * Method to click copy product button.
     * @throws IOException 
     */
    public void clickCopyProductButton() throws IOException{
        JavaScriptExec.scrollToElementOnPage(driver,clickCopyProductButton);
    	CopyProductPage sp=new CopyProductPage(driver);
        log.info("Click Copy Product Button");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, clickCopyProductButton);
        Assert.assertTrue(clickCopyProductButton.isDisplayed());
        clickCopyProductButton.click();
        
    }
    
       
    @FindBy(how=How.XPATH, using="//input[@name='product.rate']")
    private WebElement enterPriceRate1;
    /**
     * Method to Enter Price Rate.
     * @throws IOException 
     */
    public void enterPriceRate1() throws IOException{
    	CopyProductPage sp=new CopyProductPage(driver);
        log.info("Enter Price Rate");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, enterPriceRate1);
        Assert.assertTrue(enterPriceRate1.isDisplayed());
        enterPriceRate1.clear();
        enterPriceRate1.sendKeys(sp.ExcelRead().get(11));
        
    }

    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        JavaScriptExec.sleep();
    }

}
