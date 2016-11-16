package customer;

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

public class DiscountPage extends BasePage{
    /**
     * This constructor is used to initialize the webdriver in BasePage class, if the user does not want to use page factory
     * then this will take care of initialization of the driver
     *
     * @param webdriver
     */
    public DiscountPage(WebDriver webdriver) {
        super(webdriver);
    }

    Logger log=Logger.getLogger(DiscountPage.class);
    DiscountPage discountPage;
    PropertyValExtractors p = new PropertyValExtractors();
  
    public  ArrayList<String> ExcelRead() throws IOException{
    	

		ArrayList<String> rl=new ArrayList<String>();
		File file=new File(System.getProperty("user.dir") +"/Webdata_TestData.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("Discount");
		
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
    	DiscountPage sp=new DiscountPage(driver);
    	
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
    	DiscountPage sp=new DiscountPage(driver);
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
    	DiscountPage sp=new DiscountPage(driver);
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
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
        Assert.assertTrue(clickLoginButton.isDisplayed());
        clickLoginButton.click();
    }

    @FindBy(how=How.XPATH, using="//*[@id='navList']/li[7]/a/span")
    private WebElement clickDiscountTab;
    /**
     * Method to click on Discount tab after successful login.
     * @throws IOException 
     */
    public void clickCustomerTab() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Click on Discount Tab after successful login");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickDiscountTab);
        Assert.assertTrue(clickDiscountTab.isDisplayed());
        clickDiscountTab.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add New']")
    private WebElement clickAddNewButton;
    /**
     * Method to click on Add New Button.
     * @throws IOException 
     */
    public void clickAddNewButton() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Click on Add New Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddNewButton);
        Assert.assertTrue(clickAddNewButton.isDisplayed());
        clickAddNewButton.click();
        
    }
    
    
    @FindBy(how=How.XPATH, using="//div[@class='msg-box error']//*[text()='Error']")
    private WebElement verifyErrorMsg;
    /**
     * Method to verify Error message is shown when click on save changes button without entering data.
     * @throws IOException 
     */
    public void verifyErrorMsg() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("verify Error message is shown when click on save changes button without entering data.");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyErrorMsg);
        Assert.assertTrue(verifyErrorMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
  
    @FindBy(how=How.XPATH, using="//input[@name='discount.code']")
    private WebElement enterDiscountCode;
    /**
     * Method to enter discount code.
     * @throws IOException 
     */
    public void enterDiscountCode() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Enter Discount Code.");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterDiscountCode);
        Assert.assertTrue(enterDiscountCode.isDisplayed());
        enterDiscountCode.sendKeys(sp.ExcelRead().get(3));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='discount.descriptions[0].content']")
    private WebElement enterDiscountDescription;
    /**
     * Method to enter discount description.
     * @throws IOException 
     */
    public void enterDiscountDescription() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Enter Discount Description");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterDiscountDescription);
        Assert.assertTrue(enterDiscountDescription.isDisplayed());
        enterDiscountDescription.sendKeys(sp.ExcelRead().get(4));
        
    }
  
    private WebElement selectDiscountType;
    /**
     * Method to select Discount Type.
     * @throws IOException 
     */
    public void selectDiscountType() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        WebElement DTelement = driver.findElement(By.xpath("//select[@name='discount.type']"));
        Select se = new Select(DTelement);
        se.selectByVisibleText(sp.ExcelRead().get(5));

    }
    
  
    @FindBy(how=How.XPATH, using="//input[@name='discount.rate']")
    private WebElement enterDiscountRate;
    /**
     * Method to enter discount rate.
     * @throws IOException 
     */
    public void enterDiscountRate() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Enter Discount rate.");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterDiscountRate);
        Assert.assertTrue(enterDiscountRate.isDisplayed());
        enterDiscountRate.sendKeys(sp.ExcelRead().get(6));
        
    }
    
      
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Save Changes']")
    private WebElement clickSaveChangesButton;
    /**
     * Method to click on Save Changes Button.
     * @throws IOException 
     */
    public void clickSaveChangesButton() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Click on Save Changes Button");
        WaitClass.sleep(10000);
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
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Verifying if Account Type is created Successfully or not");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyConfirmationMsg);
        Assert.assertTrue(verifyConfirmationMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
    @FindBy(how=How.XPATH, using="//*[@id='navList']/li[1]/a/span")
    private WebElement clickCustomersTab;
    /**
     * Method to click on customers tab.
     * @throws IOException 
     */
    public void clickCustomersTab() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("click on customers tab");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickCustomersTab);
        Assert.assertTrue(clickCustomersTab.isDisplayed());
        clickCustomersTab.click();
        
    }
    
    //@FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Customer A']")
    private WebElement clickCustomerA;
    /**
     * Method to Click on Customer A.
     * @throws IOException 
     */
    public void clickCustomerA() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Click on customer A");
        WaitClass.sleep(10000);
        String CustomerName = sp.ExcelRead().get(7);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+CustomerName+"']")).click();
    }
    
    
    @FindBy(how=How.XPATH, using="//a[@class='submit order']//*[text()='Create Order']")
    private WebElement clickCreateOrderButton;
    /**
     * Method to Click on Create Order Button.
     * @throws IOException 
     */
    public void clickCreateOrderButton() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Click on Create Order Button.");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickCreateOrderButton);
        Assert.assertTrue(clickCreateOrderButton.isDisplayed());
        clickCreateOrderButton.click();
        
    }
    
    
    @FindBy(how=How.XPATH, using="//*[@id='ui-id-8']n")
    private WebElement clickProductSubTab;
    /**
     * Method to click on Product sub tab.
     * @throws IOException 
     */
    public void clickProductSubTab() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Click on Product Sub Tab.");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickProductSubTab);
        Assert.assertTrue(clickProductSubTab.isDisplayed());
        clickProductSubTab.click();
        
    }
    
    //@FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='BillingFl']")
    private WebElement selectProduct;
    /**
     * Method to Select a Product.
     * @throws IOException 
     */
    public void selectProduct() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Select a product.");
        WaitClass.sleep(10000);
        String ProductName = sp.ExcelRead().get(8);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+ProductName+"']")).click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Update']")
    private WebElement clickUpdateButton;
    /**
     * Method to click on update button.
     * @throws IOException 
     */
    public void clickUpdateButton() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("click on update button.");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickUpdateButton);
        Assert.assertTrue(clickUpdateButton.isDisplayed());
        clickUpdateButton.click();
        
    }
        
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        WaitClass.sleep(5000);
    }


}
