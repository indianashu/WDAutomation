package assets;

import baseClassPackage.BasePage;
import customer.CustomerPage;
import customer.OrderPage;

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

public class AddingAssetPage extends BasePage{
    /**
     * This constructor is used to initialize the webdriver in BasePage class, if the user does not want to use page factory
     * then this will take care of initialization of the driver
     *
     * @param webdriver
     */
    public AddingAssetPage(WebDriver webdriver) {
        super(webdriver);
    }

    Logger log=Logger.getLogger(AddingAssetPage.class);
    AddingAssetPage discountPage;
    PropertyValExtractors p = new PropertyValExtractors();
  
    public  ArrayList<String> ExcelRead() throws IOException{
    	

		ArrayList<String> rl=new ArrayList<String>();
		File file=new File(System.getProperty("user.dir") +"/Webdata_TestData.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("AddingAsset");
		
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
    	AddingAssetPage sp=new AddingAssetPage(driver);
    	
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
    	AddingAssetPage sp=new AddingAssetPage(driver);
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
    	AddingAssetPage sp=new AddingAssetPage(driver);
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
    	AddingAssetPage sp=new AddingAssetPage(driver);
        log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
        Assert.assertTrue(clickLoginButton.isDisplayed());
        clickLoginButton.click();
    }

    @FindBy(how=How.XPATH, using="//a[.='Customers']")
    private WebElement clickCustomersTab;
    /**
     * Method to click on Customer tab after successful login.
     * @throws IOException 
     */
    public void clickCustomersTab() throws IOException{
    	AddingAssetPage sp=new AddingAssetPage(driver);
        log.info("Click on Customer Tab after successful login");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickCustomersTab);
        Assert.assertTrue(clickCustomersTab.isDisplayed());
        clickCustomersTab.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add New']")
    private WebElement clickAddNewButton;
    /**
     * Method to click on Add New Button.
     * @throws IOException 
     */
    public void clickAddNewButton() throws IOException{
    	AddingAssetPage sp=new AddingAssetPage(driver);
        log.info("Click on Add New Button");
        WaitClass.sleep(2000);
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
    	AddingAssetPage sp=new AddingAssetPage(driver);
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
    	AddingAssetPage sp=new AddingAssetPage(driver);
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
    	AddingAssetPage sp=new AddingAssetPage(driver);
        log.info("Click on select Button");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickSelectButton);
        Assert.assertTrue(clickSelectButton.isDisplayed());
        clickSelectButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='user.userName']")
    private WebElement enterCustomerLoginName;
    /**
     * Method to Enter Login Name.
     * @throws IOException 
     */
    public void enterCustomerLoginName() throws IOException{
    	AddingAssetPage sp=new AddingAssetPage(driver);
        log.info("Enter Login Name");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterCustomerLoginName);
        Assert.assertTrue(enterCustomerLoginName.isDisplayed());
        enterCustomerLoginName.sendKeys(sp.ExcelRead().get(5));
        
    }
      
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Save Changes']")
    private WebElement clickSaveChangesButton;
    /**
     * Method to click on Save Changes Button.
     * @throws IOException 
     */
    public void clickSaveChangesButton() throws IOException{
    	AddingAssetPage sp=new AddingAssetPage(driver);
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
    	AddingAssetPage sp=new AddingAssetPage(driver);
        log.info("Verifying if Account Type is created Successfully or not");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyConfirmationMsg);
        Assert.assertTrue(verifyConfirmationMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
    
    //@FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Customer A']")
    private WebElement clickAssetCustomer;
    /**
     * Method to Click on Customer from the customer list.
     * @throws IOException 
     */
    public void clickCustomerA() throws IOException{
    	AddingAssetPage sp=new AddingAssetPage(driver);
        log.info("Click on customer from the customer list.");
        WaitClass.sleep(2000);
        String CustomerName = sp.ExcelRead().get(5);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+CustomerName+"']")).click();
    }
    
    
    @FindBy(how=How.XPATH, using="//a[@class='submit order']//*[text()='Create Order']")
    private WebElement clickCreateOrderButton;
    /**
     * Method to Click on Create Order Button.
     * @throws IOException 
     */
    public void clickCreateOrderButton() throws IOException{
    	AddingAssetPage sp=new AddingAssetPage(driver);
        log.info("Click on Create Order Button.");
        WaitClass.sleep(2000);
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
    	AddingAssetPage sp=new AddingAssetPage(driver);
        WebElement Periodelement = driver.findElement(By.xpath("//select[@name='period']"));
        Select se = new Select(Periodelement);
        se.selectByVisibleText(sp.ExcelRead().get(6));

    }

    private WebElement selectOrderType;
    /**
     * Method to select Order Type.
     * @throws IOException 
     */
    public void selectOrderType() throws IOException{
    	AddingAssetPage sp=new AddingAssetPage(driver);
        WebElement OrderTypeelement = driver.findElement(By.xpath("//select[@name='billingTypeId']"));
        Select se = new Select(OrderTypeelement);
        se.selectByVisibleText(sp.ExcelRead().get(7));

    }
    
    private WebElement selectActiveSince;
    /**
     * Method to select Active since.
     * @throws IOException 
     */
    public void selectActiveSince() throws IOException{
    	AddingAssetPage sp=new AddingAssetPage(driver);
        WebElement ASelement = driver.findElement(By.xpath("//input[@name='activeSince']"));
        Select se = new Select(ASelement);
        se.selectByVisibleText(sp.ExcelRead().get(8));

    }  
    
    @FindBy(how=How.XPATH, using="//*[@id='ui-id-8']n")
    private WebElement clickProductSubTab;
    /**
     * Method to click on Product sub tab.
     * @throws IOException 
     */
    public void clickProductSubTab() throws IOException{
    	AddingAssetPage sp=new AddingAssetPage(driver);
        log.info("Click on Product Sub Tab.");
        WaitClass.sleep(2000);
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
    	AddingAssetPage sp=new AddingAssetPage(driver);
        log.info("Select a product.");
        WaitClass.sleep(2000);
        String ProductName = sp.ExcelRead().get(9);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+ProductName+"']")).click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Update']")
    private WebElement clickUpdateButton;
    /**
     * Method to click on update button.
     * @throws IOException 
     */
    public void clickUpdateButton() throws IOException{
    	AddingAssetPage sp=new AddingAssetPage(driver);
        log.info("click on update button.");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickUpdateButton);
        Assert.assertTrue(clickUpdateButton.isDisplayed());
        clickUpdateButton.click();
        
    }
        
  
    @FindBy(how=How.XPATH, using="//input[@name='asset.select.1']")
    private WebElement clickAssetCheckbox;
    /**
     * Method to click on selected asset checkbox.
     * @throws IOException 
     */
    public void clickAssetCheckbox() throws IOException{
    	AddingAssetPage sp=new AddingAssetPage(driver);
        log.info("click on update button.");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAssetCheckbox);
        Assert.assertTrue(clickAssetCheckbox.isDisplayed());
        clickAssetCheckbox.click();
        
    }

    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add Selected']")
    private WebElement clickAddSelectedButton;
    /**
     * Method to click on add selected button.
     * @throws IOException 
     */
    public void clickAddSelectedButton() throws IOException{
    	AddingAssetPage sp=new AddingAssetPage(driver);
        log.info("click on add selected button.");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddSelectedButton);
        Assert.assertTrue(clickAddSelectedButton.isDisplayed());
        clickAddSelectedButton.click();
        
    }
    
  
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add to Order']")
    private WebElement clickAddToOrderButton;
    /**
     * Method to click on add to order button.
     * @throws IOException 
     */
    public void clickAddToOrderButton() throws IOException{
    	AddingAssetPage sp=new AddingAssetPage(driver);
        log.info("click on add to order button.");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddToOrderButton);
        Assert.assertTrue(clickAddToOrderButton.isDisplayed());
        clickAddToOrderButton.click();
        
    }
 
    private WebElement verifyAddedAsset;
    /**
     * Method to verify added asset.
     * @throws IOException 
     */
    public void verifyAddedAsset() throws IOException{
    	AddingAssetPage sp=new AddingAssetPage(driver);
        log.info("verify added asset.");
        WaitClass.sleep(2000);
        String ExpectedAsset = sp.ExcelRead().get(10);
        String ActualAsset = driver.findElement(By.xpath("//*[@id='change--3-update-form']/div[1]/div/div[10]/div/label[2]")).getText();
        Assert.assertEquals(ActualAsset, ExpectedAsset);
        
    }
    
    private WebElement verifyAssetOrderPreview;
    /**
     * Method to verify asset is shown in order preview pane.
     * @throws IOException 
     */
    public void verifyAssetOrderPreview() throws IOException{
    	AddingAssetPage sp=new AddingAssetPage(driver);
        log.info("Verify asset is shown in order preview pane.");
        WaitClass.sleep(2000);
        String ExpectedAsset = sp.ExcelRead().get(10);
        String ActualAsset = driver.findElement(By.xpath("//*[@id='column2']/div/div[7]/div[2]/table/tbody/tr/td[2]")).getText();
        Assert.assertEquals(ActualAsset, ExpectedAsset);
        
    }
    
    @FindBy(how=How.XPATH, using="//a[.='Products']")
    private WebElement clickProductsTab;
    /**
     * Method to click on Products Tab.
     * @throws IOException 
     */
    public void clickProductsTab() throws IOException{
    	AddingAssetPage sp=new AddingAssetPage(driver);
        log.info("click on Products Tab.");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickProductsTab);
        Assert.assertTrue(clickProductsTab.isDisplayed());
        clickProductsTab.click();
        
    } 
    
  
    private WebElement clickProductCategory;
    /**
     * Method to click on Products Category.
     * @throws IOException 
     */
    public void clickProductCategory() throws IOException{
    	AddingAssetPage sp=new AddingAssetPage(driver);
        log.info("click on Product category.");
        WaitClass.sleep(2000);
        String ProductCategory = sp.ExcelRead().get(11);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+ProductCategory+"']")).click();
    }
    
  
    @FindBy(how=How.XPATH, using="//a[@class='submit show']//*[text()='Show Assets']")
    private WebElement clickShowAssetsButton;
    /**
     * Method to click on show assets button.
     * @throws IOException 
     */
    public void clickShowAssetsButton() throws IOException{
    	AddingAssetPage sp=new AddingAssetPage(driver);
        log.info("click on show assets button.");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickShowAssetsButton);
        Assert.assertTrue(clickShowAssetsButton.isDisplayed());
        clickShowAssetsButton.click();
        
    } 
    
  
    private WebElement verifyAssetStatus;
    /**
     * Method to verify asset status.
     * @throws IOException 
     */
    public void verifyAssetStatus() throws IOException{
    	AddingAssetPage sp=new AddingAssetPage(driver);
        log.info("Verify asset is shown in order preview pane.");
        WaitClass.sleep(2000);
        String ExpectedStatus = sp.ExcelRead().get(12);
        String ActualStatus = driver.findElement(By.xpath("//a[@class='cell']//*[text()='Inuse']")).getText();
        Assert.assertEquals(ActualStatus, ExpectedStatus);
        
    }
    
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        WaitClass.sleep(2000);
    }


}
