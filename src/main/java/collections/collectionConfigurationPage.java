package collections;

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

public class collectionConfigurationPage extends BasePage{
    /**
     * This constructor is used to initialize the webdriver in BasePage class, if the user does not want to use page factory
     * then this will take care of initialization of the driver
     *
     * @param webdriver
     */
    public collectionConfigurationPage(WebDriver webdriver) {
        super(webdriver);
    }

    Logger log=Logger.getLogger(collectionConfigurationPage.class);
    collectionConfigurationPage orderPage;
    PropertyValExtractors p = new PropertyValExtractors();
  
    public  ArrayList<String> ExcelRead() throws IOException{
    	

		ArrayList<String> rl=new ArrayList<String>();
		File file=new File(System.getProperty("user.dir") +"/Webdata_TestData.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("Collections");
		
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
    	collectionConfigurationPage sp=new collectionConfigurationPage(driver);
    	
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
    	collectionConfigurationPage sp=new collectionConfigurationPage(driver);
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
    	collectionConfigurationPage sp=new collectionConfigurationPage(driver);
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
    	collectionConfigurationPage sp=new collectionConfigurationPage(driver);
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
    	collectionConfigurationPage sp=new collectionConfigurationPage(driver);
        log.info("Click on Customer Tab after successful login");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickCustomerTab);
        Assert.assertTrue(clickCustomerTab.isDisplayed());
        clickCustomerTab.click();
        
    }
    
  //@FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Billing Customer2']")
    private WebElement clickBillingCustomer2;
    /**
     * Method to Click on Billing Customer2.
     * @throws IOException 
     */
    public void clickBillingCustomer2() throws IOException{
    	collectionConfigurationPage sp=new collectionConfigurationPage(driver);
        log.info("Click on Billing Customer2");
        WaitClass.sleep(10000);
        String BillingCustomer= sp.ExcelRead().get(3);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+BillingCustomer+"']")).click();
        
    }
   
    
    @FindBy(how=How.XPATH, using="//a[@class='submit edit']//*[text()='Edit']")
    private WebElement clickEditButton;
    /**
     * Method to click on edit button.
     * @throws IOException 
     */
    public void clickEditButton() throws IOException{
    	collectionConfigurationPage sp=new collectionConfigurationPage(driver);
        log.info("Click on Edit Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickEditButton);
        Assert.assertTrue(clickEditButton.isDisplayed());
        clickEditButton.click();
        
    }
    
    private WebElement selectPaymentMethod;
    /**
     * Method to select Payment Method.
     * @throws IOException 
     */
    public void selectPaymentMethod() throws IOException{
    	collectionConfigurationPage sp=new collectionConfigurationPage(driver);
        WebElement PMelement = driver.findElement(By.xpath("//select[@name='paymentMethod_0.paymentMethodTypeId']"));
        Select se = new Select(PMelement);
        se.selectByVisibleText(sp.ExcelRead().get(4));

    }
    
  
    @FindBy(how=How.XPATH, using="//input[@name='0_metaField_86.value']")
    private WebElement enterCardHolderName;
    /**
     * Method to enter Card Holder Name.
     * @throws IOException 
     */
    public void enterCardHolderName() throws IOException{
    	collectionConfigurationPage sp=new collectionConfigurationPage(driver);
        log.info("Enter Cardholder Name");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterCardHolderName);
        Assert.assertTrue(enterCardHolderName.isDisplayed());
        enterCardHolderName.sendKeys(sp.ExcelRead().get(5));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='0_metaField_85.value']")
    private WebElement enterCardNumber;
    /**
     * Method to enter Card Number.
     * @throws IOException 
     */
    public void enterCardNumber() throws IOException{
    	collectionConfigurationPage sp=new collectionConfigurationPage(driver);
        log.info("Enter Cardholder Number");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterCardNumber);
        Assert.assertTrue(enterCardNumber.isDisplayed());
        enterCardNumber.sendKeys(sp.ExcelRead().get(6));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='0_metaField_83.value']")
    private WebElement enterCardExpiry;
    /**
     * Method to enter Card Expiry.
     * @throws IOException 
     */
    public void enterCardExpiry() throws IOException{
    	collectionConfigurationPage sp=new collectionConfigurationPage(driver);
        log.info("Enter Cardholder Number");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterCardExpiry);
        Assert.assertTrue(enterCardExpiry.isDisplayed());
        enterCardExpiry.sendKeys(sp.ExcelRead().get(7));
        
    }
    
    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Save Changes']")
    private WebElement clickSaveChangesButton;
    /**
     * Method to click on Save Changes Button.
     * @throws IOException 
     */
    public void clickSaveChangesButton() throws IOException{
    	collectionConfigurationPage sp=new collectionConfigurationPage(driver);
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
    	collectionConfigurationPage sp=new collectionConfigurationPage(driver);
        log.info("Verifying if Account Type is created Successfully or not");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyConfirmationMsg);
        Assert.assertTrue(verifyConfirmationMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
    
    @FindBy(how=How.XPATH, using="//*[@id='navList']/li[12]/a/span")
    private WebElement clickConfigurationTab;
    /**
     * Method to click on Configuration tab after successful login.
     * @throws IOException 
     */
    public void clickConfigurationTab() throws IOException{
    	collectionConfigurationPage sp=new collectionConfigurationPage(driver);
        log.info("Click on Configuration Tab after successful login");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickConfigurationTab);
        Assert.assertTrue(clickConfigurationTab.isDisplayed());
        clickConfigurationTab.click();
        
    }
    
  @FindBy(how=How.XPATH, using="//*[@id='left-column']/div/ul/li[7]/a")
    private WebElement clickCollectionsLink;
    /**
     * Method to Click on Collections Link.
     * @throws IOException 
     */
    public void clickCollectionsLink() throws IOException{
    	collectionConfigurationPage sp=new collectionConfigurationPage(driver);
        log.info("Click on Collections Link.");
        WaitClass.sleep(10000);  
        WaitClass.WaitForElementisDisplay(driver, 10, clickCollectionsLink);
        Assert.assertTrue(clickCollectionsLink.isDisplayed());
        clickCollectionsLink.click();
        
    }
    
  
    @FindBy(how=How.XPATH, using="//input[@name='collectionsRunDate']")
    private WebElement enterRunCollectionDate;
    /**
     * Method to enter Run Collection Date.
     * @throws IOException 
     */
    public void enterRunCollectionDate() throws IOException{
    	collectionConfigurationPage sp=new collectionConfigurationPage(driver);
        log.info("Enter Run Collection Date");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterRunCollectionDate);
        Assert.assertTrue(enterRunCollectionDate.isDisplayed());
        enterRunCollectionDate.sendKeys(sp.ExcelRead().get(8));
        
    } 
    
    @FindBy(how=How.XPATH, using="//input[@class='submit confirm']")
    private WebElement clickRunCollectionsButton;
    /**
     * Method to Click on Run Collections Button.
     * @throws IOException 
     */
    public void clickRunCollectionsButton() throws IOException{
    	collectionConfigurationPage sp=new collectionConfigurationPage(driver);
        log.info("Click on Run Collections Button.");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickRunCollectionsButton);
        Assert.assertTrue(clickRunCollectionsButton.isDisplayed());
        clickRunCollectionsButton.click();
        
    }
    
  
    @FindBy(how=How.XPATH, using="//*[@id='runCollection']/span")
    private WebElement clickRunCollectionsPopup;
    /**
     * Method to Click on Run Collections Popup.
     * @throws IOException 
     */
    public void clickRunCollectionsPopup() throws IOException{
    	collectionConfigurationPage sp=new collectionConfigurationPage(driver);
        log.info("Click on Run Collections Popup.");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickRunCollectionsPopup);
        Assert.assertTrue(clickRunCollectionsPopup.isDisplayed());
        clickRunCollectionsPopup.click();
        
    }
    
    //@FindBy(how=How.XPATH, using="//a[@id='41']//*[text()='Active']")
    private WebElement verifyBillingCustomer1Status;
    /**
     * Method to Verify status of Billing Customer1.
     * @throws IOException 
     */
    public void verifyBillingCustomer1Status() throws IOException{
    	collectionConfigurationPage sp=new collectionConfigurationPage(driver);
        log.info("Verify status of Billing Customer1");
        String CustomerID=sp.ExcelRead().get(9);
        String ActualStatus = driver.findElement(By.xpath("//a[@id='"+CustomerID+"']//*[text()='Active']")).getText();
        System.out.println("Status of the Billing Customer1---->" +ActualStatus);
        WaitClass.sleep(10000);
        String StatusExpected = sp.ExcelRead().get(10);
        Assert.assertEquals(ActualStatus, StatusExpected);
        
    }
    
  //@FindBy(how=How.XPATH, using="//a[@id='42']//*[text()='Active']")
    private WebElement verifyBillingCustomer2Status;
    /**
     * Method to Verify status of Billing Customer2.
     * @throws IOException 
     */
    public void verifyBillingCustomer2Status() throws IOException{
    	collectionConfigurationPage sp=new collectionConfigurationPage(driver);
        log.info("Verify status of Billing Customer2");
        String CustomerID=sp.ExcelRead().get(11);
        String ActualStatus = driver.findElement(By.xpath("//a[@id='"+CustomerID+"']//*[text()='Active']")).getText();
        System.out.println("Status of the Billing Customer2---->" +ActualStatus);
        WaitClass.sleep(10000);
        String StatusExpected = sp.ExcelRead().get(12);
        Assert.assertEquals(ActualStatus, StatusExpected);
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='collectionsRunDate']")
    private WebElement enterRunCollectionDate1;
    /**
     * Method to enter Run Collection Date.
     * @throws IOException 
     */
    public void enterRunCollectionDate1() throws IOException{
    	collectionConfigurationPage sp=new collectionConfigurationPage(driver);
        log.info("Enter Run Collection Date");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterRunCollectionDate1);
        Assert.assertTrue(enterRunCollectionDate1.isDisplayed());
        enterRunCollectionDate1.sendKeys(sp.ExcelRead().get(13));
        
    }
  //@FindBy(how=How.XPATH, using="//a[@id='42']//*[text()='Active']")
    private WebElement verifyBillingCustomer2Status1;
    /**
     * Method to Verify status of Billing Customer2.
     * @throws IOException 
     */
    public void verifyBillingCustomer2Status1() throws IOException{
    	collectionConfigurationPage sp=new collectionConfigurationPage(driver);
        log.info("Verify status of Billing Customer2");
        String CustomerID=sp.ExcelRead().get(11);
        String ActualStatus = driver.findElement(By.xpath("//a[@id='"+CustomerID+"']//*[text()='Active']")).getText();
        System.out.println("Status of the Billing Customer2---->" +ActualStatus);
        WaitClass.sleep(10000);
        String StatusExpected = sp.ExcelRead().get(14);
        Assert.assertEquals(ActualStatus, StatusExpected);
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='collectionsRunDate']")
    private WebElement enterRunCollectionDate2;
    /**
     * Method to enter Run Collection Date.
     * @throws IOException 
     */
    public void enterRunCollectionDate2() throws IOException{
    	collectionConfigurationPage sp=new collectionConfigurationPage(driver);
        log.info("Enter Run Collection Date");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterRunCollectionDate2);
        Assert.assertTrue(enterRunCollectionDate2.isDisplayed());
        enterRunCollectionDate2.sendKeys(sp.ExcelRead().get(15));
        
    }
  //@FindBy(how=How.XPATH, using="//a[@id='42']//*[text()='Active']")
    private WebElement verifyBillingCustomer2Status2;
    /**
     * Method to Verify status of Billing Customer2.
     * @throws IOException 
     */
    public void verifyBillingCustomer2Status2() throws IOException{
    	collectionConfigurationPage sp=new collectionConfigurationPage(driver);
        log.info("Verify status of Billing Customer2");
        String CustomerID=sp.ExcelRead().get(11);
        String ActualStatus = driver.findElement(By.xpath("//a[@id='"+CustomerID+"']//*[text()='Active']")).getText();
        System.out.println("Status of the Billing Customer2---->" +ActualStatus);
        WaitClass.sleep(10000);
        String StatusExpected = sp.ExcelRead().get(16);
        Assert.assertEquals(ActualStatus, StatusExpected);
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='collectionsRunDate']")
    private WebElement enterRunCollectionDate3;
    /**
     * Method to enter Run Collection Date.
     * @throws IOException 
     */
    public void enterRunCollectionDate3() throws IOException{
    	collectionConfigurationPage sp=new collectionConfigurationPage(driver);
        log.info("Enter Run Collection Date");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterRunCollectionDate3);
        Assert.assertTrue(enterRunCollectionDate3.isDisplayed());
        enterRunCollectionDate3.sendKeys(sp.ExcelRead().get(17));
        
    }
  //@FindBy(how=How.XPATH, using="//a[@id='42']//*[text()='Active']")
    private WebElement verifyBillingCustomer2Status3;
    /**
     * Method to Verify status of Billing Customer2.
     * @throws IOException 
     */
    public void verifyBillingCustomer2Status3() throws IOException{
    	collectionConfigurationPage sp=new collectionConfigurationPage(driver);
        log.info("Verify status of Billing Customer2");
        String CustomerID=sp.ExcelRead().get(11);
        String ActualStatus = driver.findElement(By.xpath("//a[@id='"+CustomerID+"']//*[text()='Active']")).getText();
        System.out.println("Status of the Billing Customer2---->" +ActualStatus);
        WaitClass.sleep(10000);
        String StatusExpected = sp.ExcelRead().get(18);
        Assert.assertEquals(ActualStatus, StatusExpected);
        
    }
    
    
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        WaitClass.sleep(5000);
    }


}

