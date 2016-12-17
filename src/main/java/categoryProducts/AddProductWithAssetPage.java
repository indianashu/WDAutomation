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

public class AddProductWithAssetPage extends BasePage{
    /**
     * This constructor is used to initialize the webdriver in BasePage class, if the user does not want to use page factory
     * then this will take care of initialization of the driver
     *
     * @param webdriver
     */
    public AddProductWithAssetPage(WebDriver webdriver) {
        super(webdriver);
    }

    Logger log=Logger.getLogger(AddProductWithAssetPage.class);
    AddProductWithAssetPage addProductWithAssetPage;
    PropertyValExtractors p = new PropertyValExtractors();
  
    public  ArrayList<String> ExcelRead() throws IOException{
    	

		ArrayList<String> rl=new ArrayList<String>();
		File file=new File(System.getProperty("user.dir") +"/Webdata_TestData.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("AddProductWithAsset");
		
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
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
    	
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
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
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
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
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
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
        log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
        Assert.assertTrue(clickLoginButton.isDisplayed());
        clickLoginButton.click();
    }

  
   
    @FindBy(how=How.XPATH, using="//a[.='Configuration']")
    private WebElement clickConfigurationsTab;
    /**
     * Method to click on Configurations tab after successful login.
     * @throws IOException 
     */
    public void clickConfigurationsTab() throws IOException{
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
        log.info("Click on Configurations Tab after successful login");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickConfigurationsTab);
        Assert.assertTrue(clickConfigurationsTab.isDisplayed());
        clickConfigurationsTab.click();
        
    }
    
  
    @FindBy(how=How.XPATH, using="//a[.='Plug-ins']")
    private WebElement clickPluginsLink;
    /**
     * Method to click on Plugins Link.
     * @throws IOException 
     */
    public void clickPluginsLink() throws IOException{
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
        log.info("Click on Plugins Link.");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickPluginsLink);
        Assert.assertTrue(clickPluginsLink.isDisplayed());
        clickPluginsLink.click();
        
    }
    
  
    @FindBy(how=How.XPATH, using="//td[preceding-sibling::td[contains(.,'17')]]")
    private WebElement clickCategory17;
    /**
     * Method to click on Category 17 - Generic internal events listener.
     * @throws IOException 
     */
    public void clickCategory17() throws IOException{
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
        log.info("click on Category 17 - Generic internal events listener.");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickCategory17);
        Assert.assertTrue(clickCategory17.isDisplayed());
        clickCategory17.click();
        
    }
  
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add New']")
    private WebElement clickAddNewButton;
    /**
     * Method to click on Add New button.
     * @throws IOException 
     */
    public void clickAddNewButton() throws IOException{
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
        log.info("click on Add New Button.");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddNewButton);
        Assert.assertTrue(clickAddNewButton.isDisplayed());
        clickAddNewButton.click();
        
    }
    
  
    private WebElement selectTypeId;
    /**
     * Method to select Type ID.
     * @throws IOException 
     */
    public void selectTypeId() throws IOException{
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
        WebElement TypeIDelement = driver.findElement(By.xpath("//select[@name='typeId']"));
        Select se = new Select(TypeIDelement);
        se.selectByVisibleText(sp.ExcelRead().get(3));

    }
    
  
    @FindBy(how=How.XPATH, using="//input[@name='processingOrder']")
    private WebElement enterProcessingOrder;
    /**
     * Method to enter processing order.
     * @throws IOException 
     */
    public void enterProcessingOrder() throws IOException{
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
        log.info("Enter Processing Order.");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterProcessingOrder);
        Assert.assertTrue(enterProcessingOrder.isDisplayed());
        enterProcessingOrder.clear();
        enterProcessingOrder.sendKeys(sp.ExcelRead().get(4));
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Save Plug-in']")
    private WebElement clickSavePluginButton;
    /**
     * Method to Click on Save Plugin Button.
     * @throws IOException 
     */
    public void clickSavePluginButton() throws IOException{
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
        log.info("Click on Save Plugin Button.");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickSavePluginButton);
        Assert.assertTrue(clickSavePluginButton.isDisplayed());
        clickSavePluginButton.click();
        
    }
    
    
    @FindBy(how=How.XPATH, using="//a[.='Products']")
    private WebElement clickProductsTab;
    /**
     * Method to click on Products tab after successful login.
     * @throws IOException 
     */
    public void clickProductsTab() throws IOException{
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
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
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
        log.info("Click on a category name.");
        WaitClass.sleep(2000);
        String CategoryName = sp.ExcelRead().get(5);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+CategoryName+"']")).click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add Product']")
    private WebElement clickAddProductButton;
    /**
     * Method to click on Add Product Button".
     * @throws IOException 
     */
    public void clickAddProductButton() throws IOException{
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
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
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
        log.info("Enter English Description");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterEnglishDescription);
        Assert.assertTrue(enterEnglishDescription.isDisplayed());
        enterEnglishDescription.sendKeys(sp.ExcelRead().get(6));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.number']")
    private WebElement enterProductCode;
    /**
     * Method to Enter Product Code.
     * @throws IOException 
     */
    public void enterProductCode() throws IOException{
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
        log.info("Enter Product Code");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterProductCode);
        Assert.assertTrue(enterProductCode.isDisplayed());
        enterProductCode.sendKeys(sp.ExcelRead().get(7));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.assetManagementEnabled']")
    private WebElement selectAllowAssetManagement;
    /**
     * Method to Check Allow Assest Management Checkbox.
     * @throws IOException 
     */
    public void selectAllowAssetManagement() throws IOException{
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
        log.info("Check Allow Assest Management Checkbox.");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, selectAllowAssetManagement);
        Assert.assertTrue(selectAllowAssetManagement.isDisplayed());
        selectAllowAssetManagement.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='global']")
    private WebElement clickGlobalCheckbox;
    /**
     * Method to click Global checkbox.
     * @throws IOException 
     */
    public void clickGlobalCheckbox() throws IOException{
    	ProductCategoryPage sp=new ProductCategoryPage(driver);
        log.info("Click Allow Assest Mgmt checkbox");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickGlobalCheckbox);
        Assert.assertTrue(clickGlobalCheckbox.isDisplayed());
        clickGlobalCheckbox.click(); 
    }
    
    
    private WebElement selectPriceCompany;
    /**
     * Method to select company in Prices.
     * @throws IOException 
     */
    public void selectPriceCompany() throws IOException{
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
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
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
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
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
        log.info("Enter Price Rate");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterPriceRate);
        Assert.assertTrue(enterPriceRate.isDisplayed());
        enterPriceRate.sendKeys(sp.ExcelRead().get(10));
        
    }

    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add Price']")
    private WebElement clickAddPriceButton;
    /**
     * Method to click on Add Price Button.
     * @throws IOException 
     */
    public void clickAddPriceButton() throws IOException{
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
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
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
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
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
        log.info("Verifying if Account Type is created Successfully or not");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyConfirmationMsg);
        Assert.assertTrue(verifyConfirmationMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
    
   // @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='SIM Cards']")
    private WebElement clickProductName;
    /**
     * Method to click on Product Name.
     * @throws IOException 
     */
    public void clickProductName() throws IOException{
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
        log.info("Click on Product Name");
        WaitClass.sleep(2000);
        String ProductName = sp.ExcelRead().get(6);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+ProductName+"']")).click();
        
    }
  
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add Asset']")
    private WebElement clickAddAssetButton;
    /**
     * Method to click on Add Asset Button.
     * @throws IOException 
     */
    public void clickAddAssetButton() throws IOException{
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
        log.info("Click on Add Asset Button");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddAssetButton);
        Assert.assertTrue(clickAddAssetButton.isDisplayed());
        clickAddAssetButton.click();
        
    }
    
  
    @FindBy(how=How.XPATH, using="//input[@name='identifier']")
    private WebElement enterIdentifier1;
    /**
     * Method to enter value for Identifier.
     * @throws IOException 
     */
    public void enterIdentifier1() throws IOException{
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
        log.info("Enter value for Identifier");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterIdentifier1);
        Assert.assertTrue(enterIdentifier1.isDisplayed());
        enterIdentifier1.sendKeys(sp.ExcelRead().get(11));
        
    }
    
  
    @FindBy(how=How.XPATH, using="//input[@name='isGroup']")
    private WebElement checkIsGlobal;
    /**
     * Method to Check Is Global Checkbox.
     * @throws IOException 
     */
    public void checkIsGlobal() throws IOException{
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
        log.info("Check Is Global Checkbox.");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, checkIsGlobal);
        Assert.assertTrue(checkIsGlobal.isDisplayed());
        checkIsGlobal.click();
        
    }
  
    @FindBy(how=How.XPATH, using="//input[@name='metaField_180.value']")
    private WebElement enterTaxID;
    /**
     * Method to enter value for TaxID.
     * @throws IOException 
     */
    public void enterTaxID() throws IOException{
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
        log.info("Enter value for TaxID.");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterTaxID);
        Assert.assertTrue(enterTaxID.isDisplayed());
        enterTaxID.sendKeys(sp.ExcelRead().get(12));
        
    }
 
    
    @FindBy(how=How.XPATH, using="//input[@name='identifier']")
    private WebElement enterIdentifier2;
    /**
     * Method to enter value for Identifier.
     * @throws IOException 
     */
    public void enterIdentifier2() throws IOException{
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
        log.info("Enter value for Identifier");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterIdentifier2);
        Assert.assertTrue(enterIdentifier2.isDisplayed());
        enterIdentifier2.sendKeys(sp.ExcelRead().get(13));
        
    }
  
    @FindBy(how=How.XPATH, using="//input[@name='metaField_180.value']")
    private WebElement enterTaxID1;
    /**
     * Method to enter value for TaxID.
     * @throws IOException 
     */
    public void enterTaxID1() throws IOException{
    	AddProductWithAssetPage sp=new AddProductWithAssetPage(driver);
        log.info("Enter value for TaxID.");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterTaxID1);
        Assert.assertTrue(enterTaxID1.isDisplayed());
        enterTaxID1.sendKeys(sp.ExcelRead().get(14));
        
    }
    
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        WaitClass.sleep(5000);
    }


}
