package billingProcess;

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

public class CreatingOrdersPage extends BasePage{
    /**
     * This constructor is used to initialize the webdriver in BasePage class, if the user does not want to use page factory
     * then this will take care of initialization of the driver
     *
     * @param webdriver
     */
    public CreatingOrdersPage(WebDriver webdriver) {
        super(webdriver);
    }

    Logger log=Logger.getLogger(CreatingOrdersPage.class);
    CreatingOrdersPage orderPage;
    PropertyValExtractors p = new PropertyValExtractors();
  
    public  ArrayList<String> ExcelRead() throws IOException{
    	

		ArrayList<String> rl=new ArrayList<String>();
		File file=new File(System.getProperty("user.dir") +"/Webdata_TestData.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("CreatingOrders");
		
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
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
    	
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
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
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
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
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
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
        Assert.assertTrue(clickLoginButton.isDisplayed());
        clickLoginButton.click();
    }

    @FindBy(how=How.XPATH, using="//*[@id='navList']/li[1]/a/span")
    private WebElement clickCustomerTab;
    /**
     * Method to click on Customer tab after successful login.
     * @throws IOException 
     */
    public void clickCustomerTab() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Click on Customer Tab after successful login");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickCustomerTab);
        Assert.assertTrue(clickCustomerTab.isDisplayed());
        clickCustomerTab.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add New']")
    private WebElement clickAddNewButton;
    /**
     * Method to click on Add New Button.
     * @throws IOException 
     */
    public void clickAddNewButton() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Click on Add New Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddNewButton);
        Assert.assertTrue(clickAddNewButton.isDisplayed());
        clickAddNewButton.click();
        
    }
    
    
    private WebElement selectUserCompany;
    /**
     * Method to select user company.
     * @throws IOException 
     */
    public void selectUserCompany() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        WebElement Usercompanyelement = driver.findElement(By.xpath("//select[@name='user.entityId']"));
        Select se = new Select(Usercompanyelement);
        se.selectByVisibleText(sp.ExcelRead().get(3));

    }
    
    private WebElement selectAccountType;
    /**
     * Method to select account type.
     * @throws IOException 
     */
    public void selectAccountType() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        WebElement AccountTypeelement = driver.findElement(By.xpath("//select[@name='accountTypeId']"));
        Select se = new Select(AccountTypeelement);
        se.selectByVisibleText(sp.ExcelRead().get(4));

    }    

    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Select']")
    private WebElement clickSelectButton;
    /**
     * Method to click on select Button.
     * @throws IOException 
     */
    public void clickSelectButton() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Click on select Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickSelectButton);
        Assert.assertTrue(clickSelectButton.isDisplayed());
        clickSelectButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='user.userName']")
    private WebElement enterLoginName;
    /**
     * Method to Enter Login Name.
     * @throws IOException 
     */
    public void enterLoginName() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Enter Login Name");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterLoginName);
        Assert.assertTrue(enterLoginName.isDisplayed());
        enterLoginName.sendKeys(sp.ExcelRead().get(5));
        
    }
    
    private WebElement selectBillingCycleUnit;
    /**
     * Method to select billing cycle unit.
     * @throws IOException 
     */
    public void selectBillingCycleUnit() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        WebElement BCUelement = driver.findElement(By.xpath("//select[@name='mainSubscription.periodId']"));
        Select se = new Select(BCUelement);
        se.selectByVisibleText(sp.ExcelRead().get(6));

    }

    private WebElement selectBillingCycleDay;
    /**
     * Method to select billing cycle day.
     * @throws IOException 
     */
    public void selectBillingCycleDay() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        WebElement BCDelement = driver.findElement(By.xpath("//select[@name='mainSubscription.nextInvoiceDayOfPeriod']"));
        Select se = new Select(BCDelement);
        se.selectByVisibleText(sp.ExcelRead().get(7));

    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Save Changes']")
    private WebElement clickSaveChangesButton;
    /**
     * Method to click on Save Changes Button.
     * @throws IOException 
     */
    public void clickSaveChangesButton() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
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
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Verifying if Account Type is created Successfully or not");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyConfirmationMsg);
        Assert.assertTrue(verifyConfirmationMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
    
  //@FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Bill Cust1']")
    private WebElement clickCustomer1;
    /**
     * Method to Click on Customer 1.
     * @throws IOException 
     */
    public void clickCustomer1() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Click on Customer 1");
        String CustomerName = sp.ExcelRead().get(5);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+CustomerName+"']"));
        WaitClass.sleep(10000);  
        WaitClass.WaitForElementisDisplay(driver, 10, clickCustomer1);
        Assert.assertTrue(clickCustomer1.isDisplayed());
        clickCustomer1.click();
        
    }
    
    
    @FindBy(how=How.XPATH, using="//a[@class='submit edit']//*[text()='Edit']")
    private WebElement clickEditButton;
    /**
     * Method to Click on Edit Button.
     * @throws IOException 
     */
    public void clickEditButton() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Click Edit Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickEditButton);
        Assert.assertTrue(clickEditButton.isDisplayed());
        clickEditButton.click();
        
    }
    
    
    @FindBy(how=How.XPATH, using="//input[@name='user.nextInvoiceDate']")
    private WebElement enterNextInvoiceDate;
    /**
     * Method to Enter Next Invoice Date.
     * @throws IOException 
     */
    public void enterNextInvoiceDate() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Enter Login Name");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterNextInvoiceDate);
        Assert.assertTrue(enterNextInvoiceDate.isDisplayed());
        enterNextInvoiceDate.sendKeys(sp.ExcelRead().get(8));
        
    }
    
   
    @FindBy(how=How.XPATH, using="//input[@name='user.userName']")
    private WebElement enterLoginName1;
    /**
     * Method to Enter Login Name.
     * @throws IOException 
     */
    public void enterLoginName1() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Enter Login Name");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterLoginName);
        Assert.assertTrue(enterLoginName.isDisplayed());
        enterLoginName.sendKeys(sp.ExcelRead().get(9));
        
    }
    
  //@FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Bill Cust1']")
    private WebElement clickCustomer2;
    /**
     * Method to Click on Customer 2.
     * @throws IOException 
     */
    public void clickCustomer2() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Click on Customer 2");
        String CustomerName = sp.ExcelRead().get(9);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+CustomerName+"']"));
        WaitClass.sleep(10000);  
        WaitClass.WaitForElementisDisplay(driver, 10, clickCustomer2);
        Assert.assertTrue(clickCustomer2.isDisplayed());
        clickCustomer2.click();
        
    }
  
    
    @FindBy(how=How.XPATH, using="//input[@name='user.dueDateValue']")
    private WebElement enterDueDateDays;
    /**
     * Method to Enter Due Date Days.
     * @throws IOException 
     */
    public void enterDueDateDays() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Enter Due Date Days");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterDueDateDays);
        Assert.assertTrue(enterDueDateDays.isDisplayed());
        enterDueDateDays.sendKeys(sp.ExcelRead().get(10));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='user.nextInvoiceDate']")
    private WebElement enterNextInvoiceDate1;
    /**
     * Method to Enter Next Invoice Date1.
     * @throws IOException 
     */
    public void enterNextInvoiceDate1() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Enter Login Name");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterNextInvoiceDate1);
        Assert.assertTrue(enterNextInvoiceDate1.isDisplayed());
        enterNextInvoiceDate1.sendKeys(sp.ExcelRead().get(11));
        
    }
  
    
    @FindBy(how=How.XPATH, using="//*[@id='navList']/li[7]/a/span")
    private WebElement clickProductsTab;
    /**
     * Method to Click on Products Tab.
     * @throws IOException 
     */
    public void clickProductsTab() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Click on Products Tab");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickProductsTab);
        Assert.assertTrue(clickProductsTab.isDisplayed());
        clickProductsTab.click();
        
    }
    
  
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add Category']")
    private WebElement clickAddCategoryButton;
    /**
     * Method to Click on Add Category Button.
     * @throws IOException 
     */
    public void clickAddCategoryButton() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Click on Add Category Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddCategoryButton);
        Assert.assertTrue(clickAddCategoryButton.isDisplayed());
        clickAddCategoryButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='description']")
    private WebElement enterProductCategoryName;
    /**
     * Method to enter product category name.
     * @throws IOException 
     */
    public void enterProductCategoryName() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Click on Add Category Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterProductCategoryName);
        Assert.assertTrue(enterProductCategoryName.isDisplayed());
        enterProductCategoryName.sendKeys(sp.ExcelRead().get(12));
        
    }
    
    //a[@class='cell double']//*[text()='Billing Category']
    private WebElement clickProductCategoryName;
    /**
     * Method to click on product category name.
     * @throws IOException 
     */
    public void clickProductCategoryName() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
    	String CategoryName = sp.ExcelRead().get(12);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+CategoryName+"']"));
    	log.info("Click on Add Category Button");
        WaitClass.sleep(10000);
         WaitClass.WaitForElementisDisplay(driver, 10, clickProductCategoryName);
        Assert.assertTrue(clickProductCategoryName.isDisplayed());
        clickProductCategoryName.click();
        
    }
    
  
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add Product']")
    private WebElement clickAddProductButton;
    /**
     * Method to Click on Add Product Button.
     * @throws IOException 
     */
    public void clickAddProductButton() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Click on Add Product Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddProductButton);
        Assert.assertTrue(clickAddProductButton.isDisplayed());
        clickAddProductButton.click();
        
    }  
    
  
    @FindBy(how=How.XPATH, using="//input[@name='product.descriptions[0].content']")
    private WebElement enterProductDescription;
    /**
     * Method to enter product description.
     * @throws IOException 
     */
    public void enterProductDescription() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("enter product description");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterProductDescription);
        Assert.assertTrue(enterProductDescription.isDisplayed());
        enterProductDescription.sendKeys(sp.ExcelRead().get(13));
        
    }
  
    @FindBy(how=How.XPATH, using="//input[@name='product.number']")
    private WebElement enterProductCode;
    /**
     * Method to enter product code.
     * @throws IOException 
     */
    public void enterProductCode() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("enter product code");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterProductCode);
        Assert.assertTrue(enterProductCode.isDisplayed());
        enterProductCode.sendKeys(sp.ExcelRead().get(14));
        
    }
    
    
    @FindBy(how=How.XPATH, using="//a[@class='submit order']//*[text()='Create Order']")
    private WebElement clickCreateOrderButton;
    /**
     * Method to Click Create Order Button.
     * @throws IOException 
     */
    public void clickCreateOrderButton() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Click Add Sub Account Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickCreateOrderButton);
        Assert.assertTrue(clickCreateOrderButton.isDisplayed());
        clickCreateOrderButton.click();
        
    }
    
    private WebElement selectPeriod;
    /**
     * Method to select Period.
     * @throws IOException 
     */
    public void selectPeriod() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        WebElement Periodelement = driver.findElement(By.xpath("//select[@name='period']"));
        Select se = new Select(Periodelement);
        se.selectByVisibleText(sp.ExcelRead().get(8));

    }

    private WebElement selectOrderType;
    /**
     * Method to select Order Type.
     * @throws IOException 
     */
    public void selectOrderType() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        WebElement OrderTypeelement = driver.findElement(By.xpath("//select[@name='billingTypeId']"));
        Select se = new Select(OrderTypeelement);
        se.selectByVisibleText(sp.ExcelRead().get(9));

    }
    
    private WebElement selectActiveSince;
    /**
     * Method to select Active since.
     * @throws IOException 
     */
    public void selectActiveSince() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        WebElement ASelement = driver.findElement(By.xpath("//input[@name='activeSince']"));
        Select se = new Select(ASelement);
        se.selectByVisibleText(sp.ExcelRead().get(10));

    }  
    
    @FindBy(how=How.XPATH, using="//*[@id='ui-id-8']")
    private WebElement clickProducts;
    /**
     * Method to Click Products tab.
     * @throws IOException 
     */
    public void clickProducts() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Click Products Tab");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickProducts);
        Assert.assertTrue(clickProducts.isDisplayed());
        clickProducts.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='abc']")
    private WebElement selectProduct;
    /**
     * Method to Select Product from list.
     * @throws IOException 
     */
    public void selectProduct() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Click Product from list");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, selectProduct);
        Assert.assertTrue(selectProduct.isDisplayed());
        selectProduct.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='change--3.startDate']")
    private WebElement enterEffectiveDate;
    /**
     * Method to Enter Effective Date.
     * @throws IOException 
     */
    public void enterEffectiveDate() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Enter Effective Date");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterEffectiveDate);
        Assert.assertTrue(enterEffectiveDate.isDisplayed());
        enterEffectiveDate.sendKeys(sp.ExcelRead().get(11));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='change--3.quantityAsDecimal']")
    private WebElement enterQuantity;
    /**
     * Method to Enter Quantity.
     * @throws IOException 
     */
    public void enterQuantity() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Enter Quantity");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterQuantity);
        Assert.assertTrue(enterQuantity.isDisplayed());
        enterQuantity.sendKeys(sp.ExcelRead().get(12));
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Update']")
    private WebElement clickUpdateButton;
    /**
     * Method to Click Update Button.
     * @throws IOException 
     */
    public void clickUpdateButton() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Click Update Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickUpdateButton);
        Assert.assertTrue(clickUpdateButton.isDisplayed());
        clickUpdateButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//span[@class='newOrderLine']")
    private WebElement verifyNewOrder;
    /**
     * Method to verify NEW is shown.
     * @throws IOException 
     */
    public void verifyNewOrder() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Verifying if NEW is shown or not");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyNewOrder);
        Assert.assertTrue(verifyNewOrder.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
    
    @FindBy(how=How.XPATH, using="//a[@class='submit edit']//*[text()='Edit this Order']")
    private WebElement clickEditOrderButton;
    /**
     * Method to Click Edit This Order Button.
     * @throws IOException 
     */
    public void clickEditOrderButton() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Click Edit This Order Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickEditOrderButton);
        Assert.assertTrue(clickEditOrderButton.isDisplayed());
        clickEditOrderButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//*[@id='ui-id-11']")
    private WebElement clickChangeLog;
    /**
     * Method to Click ChangeLog.
     * @throws IOException 
     */
    public void clickChangeLog() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Click Change Log");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickChangeLog);
        Assert.assertTrue(clickChangeLog.isDisplayed());
        clickChangeLog.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit order']//*[text()='Generate Invoice']")
    private WebElement clickGenerateInvoiceButton;
    /**
     * Method to Click on Generate Invoice Button.
     * @throws IOException 
     */
    public void clickGenerateInvoiceButton() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Click on Generate Invoice Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickGenerateInvoiceButton);
        Assert.assertTrue(clickGenerateInvoiceButton.isDisplayed());
        clickGenerateInvoiceButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//span[@class='description']")
    private WebElement clickSelectedProduct;
    /**
     * Method to Click Selected Product.
     * @throws IOException 
     */
    public void clickSelectedProduct() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Click Selected Product");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickSelectedProduct);
        Assert.assertTrue(clickSelectedProduct.isDisplayed());
        clickSelectedProduct.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Change']")
    private WebElement clickChangeButton;
    /**
     * Method to Click ChangeButton.
     * @throws IOException 
     */
    public void clickChangeButton() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Click Change Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickChangeButton);
        Assert.assertTrue(clickChangeButton.isDisplayed());
        clickChangeButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@class='field quantity']")
    private WebElement enterChangeQty;
    /**
     * Method to Enter New Quantity.
     * @throws IOException 
     */
    public void enterChangeQty() throws IOException{
    	CreatingOrdersPage sp=new CreatingOrdersPage(driver);
        log.info("Enter New Quantity");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterChangeQty);
        Assert.assertTrue(enterChangeQty.isDisplayed());
        enterChangeQty.sendKeys(sp.ExcelRead().get(13));
        
    }
    
    
    
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        WaitClass.sleep(5000);
    }


}

