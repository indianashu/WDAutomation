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
     * Method to select Company.
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

    @FindBy(how=How.XPATH, using="//a[.='Discounts']")
    private WebElement clickDiscountTab;
    /**
     * Method to click on Discount tab after successful login.
     * @throws IOException 
     */
    public void clickDiscountTab() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Click on Discount Tab after successful login");
        WaitClass.sleep(2000);
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
        WaitClass.sleep(2000);
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
        WaitClass.sleep(2000);
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
        WaitClass.sleep(2000);
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
        WaitClass.sleep(2000);
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
        WaitClass.sleep(2000);
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
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickSaveChangesButton);
        Assert.assertTrue(clickSaveChangesButton.isDisplayed());
        clickSaveChangesButton.click();
        WaitClass.sleep(1000);
    }
    
    @FindBy(how=How.XPATH, using="//div[@class='msg-box successfully']//*[text()='Done']")
    private WebElement verifyConfirmationMsg;
    /**
     * Method to verify Discount is created Successfully.
     * @throws IOException 
     */
    public void verifyConfirmationMsg() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Verifying if Discount is created Successfully or not");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyConfirmationMsg);
        Assert.assertTrue(verifyConfirmationMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
    @FindBy(how=How.XPATH, using="//a[.='Customers']")
    private WebElement clickCustomersTab;
    /**
     * Method to click on customers tab.
     * @throws IOException 
     */
    public void clickCustomersTab() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("click on customers tab");
        WaitClass.sleep(2000);
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
        WaitClass.sleep(2000);
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
        JavaScriptExec.scrollToElementOnPage(driver,clickCreateOrderButton);
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Click on Create Order Button.");
        WaitClass.sleep(1000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickCreateOrderButton);
        Assert.assertTrue(clickCreateOrderButton.isDisplayed());
        clickCreateOrderButton.click();
        WaitClass.sleep(3000);
    }
    
    
    @FindBy(how=How.XPATH, using="//*[@id='ui-id-8']")
    private WebElement clickProductSubTab;
    /**
     * Method to click on Product sub tab.
     * @throws IOException 
     */
    public void clickProductSubTab() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Click on Product Sub Tab.");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickProductSubTab);
        Assert.assertTrue(clickProductSubTab.isDisplayed());
        clickProductSubTab.click();
        WaitClass.sleep(1000);
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
        WaitClass.sleep(2000);
        String ProductName = sp.ExcelRead().get(8);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+ProductName+"']")).click();
        WaitClass.sleep(1000);
    }
    
  
    @FindBy(how=How.XPATH, using="//*[@id='ui-id-9']")
    private WebElement clickDiscountSubTab;
    /**
     * Method to click on Discount sub tab.
     * @throws IOException 
     */
    public void clickDiscountSubTab() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Click on Discount Sub Tab.");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickDiscountSubTab);
        Assert.assertTrue(clickDiscountSubTab.isDisplayed());
        clickDiscountSubTab.click();
        
    }
    
  
    private WebElement selectDiscount;
    /**
     * Method to select Discount.
     * @throws IOException 
     */
    public void selectDiscount() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        WaitClass.sleep(1000);
        WebElement Discountelement = driver.findElement(By.xpath("//select[@name='discount.0.id']"));
        Select se = new Select(Discountelement);
        se.selectByVisibleText(sp.ExcelRead().get(9));

    }
    
  
    //@FindBy(how=How.XPATH, using="//*[@id='discount-messages']/ul/li")
    private WebElement verifyErrorMessage;
    /**
     * Method to Verify Error Message shown on selecting Discount.
     * @throws IOException 
     */
    public void verifyErrorMessage() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Verify Error Message shown on selecting Discount.");
        WaitClass.sleep(2000);
        String ExpectedErrorMsg = sp.ExcelRead().get(10);
        String ActualErrorMsg = driver.findElement(By.xpath("//*[@id='discount-messages']/ul/li")).getText();
        Assert.assertEquals(ActualErrorMsg, ExpectedErrorMsg);
        
    }
    
    private WebElement selectDiscountableItem;
    /**
     * Method to select Discountable Item.
     * @throws IOException 
     */
    public void selectDiscountableItem() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        WebElement Discountelement = driver.findElement(By.xpath("//select[@name='discountableItem.0.lineLevelDetails']"));
        Select se = new Select(Discountelement);
        se.selectByVisibleText(sp.ExcelRead().get(11));

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
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickUpdateButton);
        Assert.assertTrue(clickUpdateButton.isDisplayed());
        clickUpdateButton.click();
        
    }
    
    //@FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='BillingFl']")
    private WebElement selectProduct1;
    /**
     * Method to Select a Product.
     * @throws IOException 
     */
    public void selectProduct1() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Select a product.");
        WaitClass.sleep(2000);
        String ProductName = sp.ExcelRead().get(12);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+ProductName+"']")).click();
        
    }
    
  //@FindBy(how=How.XPATH, using="//*[@id='review-box']/div[3]")
    private WebElement verifyAmount;
    /**
     * Method to Verify Amount is shown with discount.
     * @throws IOException 
     */
    public void verifyAmount() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Verify Amount is shown with discount.");
        WaitClass.sleep(2000);
        String ExpectedErrorMsg = sp.ExcelRead().get(14);
        String ActualErrorMsg = driver.findElement(By.xpath("//*[@id='review-box']/div[3]")).getText();
        Assert.assertEquals(ActualErrorMsg, ExpectedErrorMsg);
        
    }
    
  
    @FindBy(how=How.XPATH, using="//a[.='Orders']")
    private WebElement clickOrdersTab;
    /**
     * Method to click on Orders Tab.
     * @throws IOException 
     */
    public void clickOrdersTab() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("click on Orders Tab.");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickOrdersTab);
        Assert.assertTrue(clickOrdersTab.isDisplayed());
        clickOrdersTab.click();
        
    }
  
    //@FindBy(how=How.XPATH, using="//a[@class='cell']//*[text()='604']")
    private WebElement clickOrder;
    /**
     * Method to click on Order..
     * @throws IOException 
     */
    public void clickOrder() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("click on Order.");
        WaitClass.sleep(2000);
        String OrderNumber = sp.ExcelRead().get(13);
        driver.findElement(By.xpath("//a[@class='cell']//*[text()='"+OrderNumber+"']")).click();
        
    }
  
    private WebElement verifyAmountDifference;
    /**
     * Method to Verify Amount is shown with discount.
     * @throws IOException 
     */
    public void verifyAmountDifference() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Verify Amount is shown with discount.");
        WaitClass.sleep(2000);
       String Amount1 = driver.findElement(By.xpath("//*[@id='column2']/div/div[6]/div/table/tbody/tr/td[4]")).getText();
       System.out.println("Amount 1 --->: " +Amount1);
       String Amount2 = driver.findElement(By.xpath("//*[@id='column2']/div/div[6]/div/table/tbody/tr/td[5]")).getText();
       System.out.println("Amount 2 --->: " +Amount2);
       //Assert.assertEquals(Amount1, Amount2);
       Assert.assertNotEquals(Amount1, Amount2);
       
        
    }

    /**
     * Method to Create Plan Type Category after successful login.
     * @throws IOException
     */
    public void createPlanCategory() throws IOException{
        DiscountPage sp=new DiscountPage(driver);
        log.info("Create Plan Type Category");

        log.info("Click Products Tab");
        WaitClass.sleep(1000);
        WebElement clickProductsTab = driver.findElement(By.xpath("//a[.='Products']"));
        Assert.assertTrue(clickProductsTab.isDisplayed());
        clickProductsTab.click();

        log.info("Click on Add Category Button");
        WaitClass.sleep(2000);
        WebElement clickAddCategoryButton = driver.findElement(By.xpath("//a[@class='submit add']//*[text()='Add Category']"));
        Assert.assertTrue(clickAddCategoryButton.isDisplayed());
        clickAddCategoryButton.click();

        log.info("Enter Category Name");
        WaitClass.sleep(1000);
        WebElement enterCategoryName = driver.findElement(By.xpath("//input[@name='description']"));
        Assert.assertTrue(enterCategoryName.isDisplayed());
        enterCategoryName.sendKeys(sp.ExcelRead().get(15));

        log.info("Select Plan order line type");
        WaitClass.sleep(1000);
        WebElement orderLineTypeId = driver.findElement(By.xpath("//*[@name='orderLineTypeId']"));
        Select se = new Select(orderLineTypeId);
        se.selectByVisibleText(sp.ExcelRead().get(16));

        log.info("Click on Save Changes Button");
        WaitClass.sleep(1000);
        WebElement clickSaveChangesButton = driver.findElement(By.xpath("//a[@class='submit save']//*[text()='Save Changes']"));
        Assert.assertTrue(clickSaveChangesButton.isDisplayed());
        clickSaveChangesButton.click();
        WaitClass.sleep(1000);
    }

    /**
     * Method to Create Plan Type Product.
     * @throws IOException
     */
    public void createPlanTypeProduct() throws IOException{
        DiscountPage sp=new DiscountPage(driver);
        log.info("Create Plan Type Product");

        log.info("Click on a category name.");
        WaitClass.sleep(1000);
        String CategoryName = sp.ExcelRead().get(15);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+CategoryName+"']")).click();

        log.info("Click on Add Product Button");
        WaitClass.sleep(1000);
        WebElement clickAddProductButton = driver.findElement(By.xpath("//a[@class='submit add']//*[text()='Add Product']"));
        Assert.assertTrue(clickAddProductButton.isDisplayed());
        clickAddProductButton.click();

        log.info("Enter English Description");
        WaitClass.sleep(2000);
        WebElement enterEnglishDescription = driver.findElement(By.xpath("//input[@name='product.descriptions[0].content']"));
        Assert.assertTrue(enterEnglishDescription.isDisplayed());
        enterEnglishDescription.sendKeys(sp.ExcelRead().get(17));

        log.info("Enter Product Code");
        WaitClass.sleep(1000);
        WebElement enterProductCode = driver.findElement(By.xpath("//input[@name='product.number']"));
        Assert.assertTrue(enterProductCode.isDisplayed());
        enterProductCode.sendKeys(sp.ExcelRead().get(17));

        WaitClass.sleep(1000);
        JavaScriptExec.scrolltoBottomofPage(driver);

        log.info("Enter Price Rate");
        WaitClass.sleep(1000);
        WebElement enterPriceRate = driver.findElement(By.xpath("//input[@name='product.rate']"));
        Assert.assertTrue(enterPriceRate.isDisplayed());
        enterPriceRate.sendKeys(sp.ExcelRead().get(18));

        log.info("Click on Add Price Button");
        WaitClass.sleep(1000);
        WebElement clickAddPriceButton = driver.findElement(By.xpath("//a[@class='submit add']//*[text()='Add Price']"));
        Assert.assertTrue(clickAddPriceButton.isDisplayed());
        clickAddPriceButton.click();

        log.info("Click on Save Changes Button");
        WaitClass.sleep(1000);
        WebElement clickSaveChangesButton = driver.findElement(By.xpath("//a[@class='submit save']//*[text()='Save Changes']"));
        Assert.assertTrue(clickSaveChangesButton.isDisplayed());
        clickSaveChangesButton.click();
        WaitClass.sleep(1000);
    }

    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        WaitClass.sleep(2000);
    }


}
