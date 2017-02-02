package tearDown;

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

public class TearDownProcessPage extends BasePage{
    /**
     * This constructor is used to initialize the webdriver in BasePage class, if the user does not want to use page factory
     * then this will take care of initialization of the driver
     *
     * @param webdriver
     */
    public TearDownProcessPage(WebDriver webdriver) {
        super(webdriver);
    }

    Logger log=Logger.getLogger(TearDownProcessPage.class);
    TearDownProcessPage orderPage;
    PropertyValExtractors p = new PropertyValExtractors();
  
    public  ArrayList<String> ExcelRead() throws IOException{
    	

		ArrayList<String> rl=new ArrayList<String>();
		File file=new File(System.getProperty("user.dir") +"/Webdata_TestData.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("TearDown");
		
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
    	TearDownProcessPage sp=new TearDownProcessPage(driver);
    	
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
    	TearDownProcessPage sp=new TearDownProcessPage(driver);
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
    	TearDownProcessPage sp=new TearDownProcessPage(driver);
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
    	TearDownProcessPage sp=new TearDownProcessPage(driver);
        log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
        Assert.assertTrue(clickLoginButton.isDisplayed());
        clickLoginButton.click();
    }

    
    @FindBy(how=How.XPATH, using="//a[.='Payments']")
    private WebElement clickPaymentsTab;
    /**
     * Method to click on Payments tab after successful login.
     * @throws IOException 
     */
    public void clickPaymentsTab() throws IOException{
    	TearDownProcessPage sp=new TearDownProcessPage(driver);
        log.info("Click on Customer Tab after successful login");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickPaymentsTab);
        Assert.assertTrue(clickPaymentsTab.isDisplayed());
        clickPaymentsTab.click();
        
    }
    
  //@FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Customer A']")
    private WebElement clickPaymentCustomer;
    /**
     * Method to Click on Customer A.
     * @throws IOException 
     */
    public void clickPaymentCustomer() throws IOException{
    	TearDownProcessPage sp=new TearDownProcessPage(driver);
        log.info("Click on Payment Customer");
        WaitClass.sleep(10000);
        String Customer= sp.ExcelRead().get(3);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+Customer+"']")).click();
        
    }
   
    
    @FindBy(how=How.XPATH, using="//*[@id='column2']/div/div[2]/div/table[4]/tbody/tr/td[4]/a/span")
    private WebElement clickUnlink;
    /**
     * Method to click on unlink link.
     * @throws IOException 
     */
    public void clickUnlink() throws IOException{
    	TearDownProcessPage sp=new TearDownProcessPage(driver);
        log.info("Click on unlink link");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickUnlink);
        Assert.assertTrue(clickUnlink.isDisplayed());
        clickUnlink.click();
        
    }
    
    
    @FindBy(how=How.XPATH, using="/html/body/div[5]/div[3]/div/button[1]/span")
    private WebElement clickYesPopup;
    /**
     * Method to click on yes popup.
     * @throws IOException 
     */
    public void clickYesPopup() throws IOException{
    	TearDownProcessPage sp=new TearDownProcessPage(driver);
        log.info("click on yes button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickYesPopup);
        Assert.assertTrue(clickYesPopup.isDisplayed());
        clickYesPopup.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//div[@class='msg-box successfully']")
    private WebElement verifyPaymentUnlinkedSuccessfully;
    /**
     * Method to Verify Payment is unlinked successfully.
     * @throws IOException 
     */
    public void verifyPaymentUnlinkedSuccessfully() throws IOException{
    	TearDownProcessPage sp=new TearDownProcessPage(driver);
        log.info("Verify Payment is unlinked successfully");
        WaitClass.sleep(10000);
        //WaitClass.WaitForElementisDisplay(driver, 10, verifyPaymentUnlinkedSuccessfully);
        String PaymentMsgExpected = "Payment unlinked successfully";
        String PaymentMsgActual = driver.findElement(By.xpath("//div[@class='msg-box successfully']//*[text()='Done']/following::p")).getText();
        Assert.assertEquals(PaymentMsgActual, PaymentMsgExpected);
        
    }
    
    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Save Changes']")
    private WebElement clickSaveChangesButton;
    /**
     * Method to click on Save Changes Button.
     * @throws IOException 
     */
    public void clickSaveChangesButton() throws IOException{
    	TearDownProcessPage sp=new TearDownProcessPage(driver);
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
    	TearDownProcessPage sp=new TearDownProcessPage(driver);
        log.info("Verifying if Account Type is created Successfully or not");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyConfirmationMsg);
        Assert.assertTrue(verifyConfirmationMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
    
    @FindBy(how=How.XPATH, using="//a[.='Invoices']")
    private WebElement clickInvoicesTab;
    /**
     * Method to click on Invoices tab after successful login.
     * @throws IOException 
     */
    public void clickInvoicesTab() throws IOException{
    	TearDownProcessPage sp=new TearDownProcessPage(driver);
        log.info("Click on Invoices Tab after successful login");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickInvoicesTab);
        Assert.assertTrue(clickInvoicesTab.isDisplayed());
        clickInvoicesTab.click();
        
    }
    
  //@FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Billing Customer2']")
  private WebElement clickInvoiceCustomer;
  /**
   * Method to Click on Customer B.
   * @throws IOException 
   */
  public void clickInvoiceCustomer() throws IOException{
  	TearDownProcessPage sp=new TearDownProcessPage(driver);
      log.info("Click on Invoice Customer");
      WaitClass.sleep(10000);
      String Customer= sp.ExcelRead().get(3);
      driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+Customer+"']")).click();
      WaitClass.sleep(10000);
  }
    
  
    @FindBy(how=How.XPATH, using="//a[@class='submit delete']//*[text()='Delete Invoice']")
    private WebElement clickDeleteInvoiceButton;
    /**
     * Method to click on delete invoice button.
     * @throws IOException 
     */
    public void clickDeleteInvoiceButton() throws IOException{
        JavaScriptExec.scrollToElementOnPage(driver,clickDeleteInvoiceButton);
    	TearDownProcessPage sp=new TearDownProcessPage(driver);
        log.info("click on delete invoice button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickDeleteInvoiceButton);
        Assert.assertTrue(clickDeleteInvoiceButton.isDisplayed());
        clickDeleteInvoiceButton.click();
        
    } 
    
    @FindBy(how=How.XPATH, using="//following::span[text()='Yes'][2]")
    private WebElement clickYesDeleteInvoicePopup;
    /**
     * Method to Click on Yes delete invoice/product popup.
     * @throws IOException 
     */
    public void clickYesDeleteInvoicePopup() throws IOException{
    	TearDownProcessPage sp=new TearDownProcessPage(driver);
        log.info("Click on Yes delete invoice/product popup.");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickYesDeleteInvoicePopup);
        Assert.assertTrue(clickYesDeleteInvoicePopup.isDisplayed());
        clickYesDeleteInvoicePopup.click();
        WaitClass.sleep(10000);
        
    }

    @FindBy(how=How.XPATH, using="//following::span[text()='Yes'][3]")
    private WebElement clickYesDeleteProductPopup;
    /**
     * Method to Click on Yes delete invoice/product popup.
     * @throws IOException
     */
    public void clickYesDeleteProductPopup() throws IOException{
        TearDownProcessPage sp=new TearDownProcessPage(driver);
        log.info("Click on Yes delete invoice/product popup.");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickYesDeleteProductPopup);
        Assert.assertTrue(clickYesDeleteProductPopup.isDisplayed());
        clickYesDeleteProductPopup.click();
        WaitClass.sleep(10000);

    }

    @FindBy(how=How.XPATH, using="//a[.='Orders']")
    private WebElement clickOrdersTab;
    /**
     * Method to Click on Orders Tab.
     * @throws IOException 
     */
    public void clickOrdersTab() throws IOException{
    	TearDownProcessPage sp=new TearDownProcessPage(driver);
        log.info("Click on Orders Tab.");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickOrdersTab);
        Assert.assertTrue(clickOrdersTab.isDisplayed());
        clickOrdersTab.click();
        
    }
    
  //@FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Billing Customer2']")
    private WebElement clickOrderCustomer;
    /**
     * Method to Click on Customer C.
     * @throws IOException 
     */
    public void clickOrderCustomer() throws IOException{
    	TearDownProcessPage sp=new TearDownProcessPage(driver);
        log.info("Click on Customer C");
        WaitClass.sleep(10000);
        String Customer= sp.ExcelRead().get(3);
        driver.findElement(By.xpath("//a[@class='double cell']//*[text()='"+Customer+"']")).click();
        
    }
      
    @FindBy(how=How.XPATH, using="//a[@class='submit delete']//*[text()='Delete']")
    private WebElement clickDeleteButton;
    /**
     * Method to click on delete button.
     * @throws IOException 
     */
    public void clickDeleteButton() throws IOException{
        JavaScriptExec.scrollToElementOnPage(driver,clickDeleteButton);
    	TearDownProcessPage sp=new TearDownProcessPage(driver);
        log.info("click on delete button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickDeleteButton);
        Assert.assertTrue(clickDeleteButton.isDisplayed());
        clickDeleteButton.click();
        
    }

    @FindBy(how=How.XPATH, using="//following::span[text()='Yes'][2]")
    private WebElement clickYesDeletePaymentPopup;
    /**
     * Method to Click on Yes delete invoice/product popup.
     * @throws IOException
     */
    public void clickYesDeletePaymentPopup() throws IOException{
        TearDownProcessPage sp=new TearDownProcessPage(driver);
        log.info("Click on Yes delete payment popup.");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickYesDeletePaymentPopup);
        Assert.assertTrue(clickYesDeletePaymentPopup.isDisplayed());
        clickYesDeletePaymentPopup.click();
        WaitClass.sleep(10000);

    }

    @FindBy(how=How.XPATH, using="//following::span[text()='Yes']")
    private WebElement clickYesDeleteOrderPopup;
    /**
     * Method to Click on Yes delete invoice/product popup.
     * @throws IOException
     */
    public void clickYesDeleteOrderPopup() throws IOException{
        TearDownProcessPage sp=new TearDownProcessPage(driver);
        log.info("Click on Yes delete order popup.");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickYesDeleteOrderPopup);
        Assert.assertTrue(clickYesDeleteOrderPopup.isDisplayed());
        clickYesDeleteOrderPopup.click();
        WaitClass.sleep(10000);

    }

    @FindBy(how=How.XPATH, using="//a[.='Products']")
    private WebElement clickProductsTab;
    /**
     * Method to click on Products Tab.
     * @throws IOException 
     */
    public void clickProductsTab() throws IOException{
    	TearDownProcessPage sp=new TearDownProcessPage(driver);
        log.info("click on products tab.");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickProductsTab);
        Assert.assertTrue(clickProductsTab.isDisplayed());
        clickProductsTab.click();
        
    }
    
    //a[@class='cell double']//*[text()='plans']
    private WebElement clickProductCategory;
    /**
     * Method to Click on a product category.
     * @throws IOException 
     */
    public void clickProductCategory() throws IOException{
    	TearDownProcessPage sp=new TearDownProcessPage(driver);
        log.info("Click on a product category");
        WaitClass.sleep(10000);
        String ProductCategory= sp.ExcelRead().get(4);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+ProductCategory+"']")).click();
        
    }
    
  //a[@class='cell double']//*[text()='plans']
    private WebElement clickProduct;
    /**
     * Method to Click on a product.
     * @throws IOException 
     */
    public void clickProduct() throws IOException{
    	TearDownProcessPage sp=new TearDownProcessPage(driver);
        log.info("Click on a product.");
        WaitClass.sleep(10000);
        String ProductName= sp.ExcelRead().get(5);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+ProductName+"']")).click();
        
    }
    
  
    //@FindBy(how=How.XPATH, using="//*[@id='column2']/div[1]/strong/em")
    private WebElement verifyNoProducts;
    /**
     * Method to Verify there are no products in the selected category.
     * @throws IOException 
     */
    public void verifyNoProducts() throws IOException{
    	TearDownProcessPage sp=new TearDownProcessPage(driver);
        log.info("Verify there are no products in the selected category");
        WaitClass.sleep(10000);
        String MsgExpected = "NO PRODUCTS FOUND.";
        String MsgActual = driver.findElement(By.xpath("//*[@id='column2']/div[1]/strong/em")).getText();
        Assert.assertEquals(MsgActual, MsgExpected);
        
    }   
    
  
    @FindBy(how=How.XPATH, using="//a[@class='submit delete']//*[text()='Delete Category']")
    private WebElement clickDeleteCategoryButton;
    /**
     * Method to click on delete category button.
     * @throws IOException 
     */
    public void clickDeleteCategoryButton() throws IOException{
    	TearDownProcessPage sp=new TearDownProcessPage(driver);
        log.info("click on delete category button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickDeleteCategoryButton);
        Assert.assertTrue(clickDeleteCategoryButton.isDisplayed());
        clickDeleteCategoryButton.click();
        WaitClass.sleep(10000);
    }
    
    @FindBy(how=How.XPATH, using="//following::span[text()='Yes']/following::span[5]")
    private WebElement clickDeleteYesCategoryPopup;
    /**
     * Method to click on delete category popup.
     * @throws IOException 
     */
    public void clickDeleteYesCategoryPopup() throws IOException{
    	TearDownProcessPage sp=new TearDownProcessPage(driver);
        log.info("click on delete category popup");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickDeleteYesCategoryPopup);
        Assert.assertTrue(clickDeleteYesCategoryPopup.isDisplayed());
        clickDeleteYesCategoryPopup.click();
        WaitClass.sleep(10000);
    }
    
  
    @FindBy(how=How.XPATH, using="//a[.='Customers']")
    private WebElement clickCustomersTab;
    /**
     * Method to click on customers tab.
     * @throws IOException 
     */
    public void clickCustomersTab() throws IOException{
    	TearDownProcessPage sp=new TearDownProcessPage(driver);
        log.info("click on customers tab");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickCustomersTab);
        Assert.assertTrue(clickCustomersTab.isDisplayed());
        clickCustomersTab.click();
        
    }

    @FindBy(how=How.XPATH, using="//following::span[text()='Yes']")
    private WebElement clickDeleteYesCustomerPopup;
    /**
     * Method to click on delete customer popup.
     * @throws IOException 
     */
    public void clickDeleteYesCustomerPopup() throws IOException{
    	TearDownProcessPage sp=new TearDownProcessPage(driver);
        log.info("click on delete customer popup");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickDeleteYesCustomerPopup);
        Assert.assertTrue(clickDeleteYesCustomerPopup.isDisplayed());
        clickDeleteYesCustomerPopup.click();
        WaitClass.sleep(10000);
    }

    
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        WaitClass.sleep(10000);
    }


}

