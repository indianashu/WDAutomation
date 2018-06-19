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

public class ProductCategoryPage extends BasePage{
    /**
     * This constructor is used to initialize the webdriver in BasePage class, if the user does not want to use page factory
     * then this will take care of initialization of the driver
     *
     * @param webdriver
     */
    public ProductCategoryPage(WebDriver webdriver) {
        super(webdriver);
    }

    Logger log=Logger.getLogger(ProductCategoryPage.class);
    ProductCategoryPage productCategoryPage;
    PropertyValExtractors p = new PropertyValExtractors();
  
    public  ArrayList<String> ExcelRead() throws IOException{
    	

		ArrayList<String> rl=new ArrayList<String>();
		File file=new File(System.getProperty("user.dir") +"/Webdata_TestData.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("AddEditCategory");
		
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
    	ProductCategoryPage sp=new ProductCategoryPage(driver);
    	
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
    	ProductCategoryPage sp=new ProductCategoryPage(driver);
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
    	ProductCategoryPage sp=new ProductCategoryPage(driver);
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
    	ProductCategoryPage sp=new ProductCategoryPage(driver);
        log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
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
    	ProductCategoryPage sp=new ProductCategoryPage(driver);
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
    	ProductCategoryPage sp=new ProductCategoryPage(driver);
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
    	ProductCategoryPage sp=new ProductCategoryPage(driver);
        log.info("Enter Category Name");
        Assert.assertTrue(enterCategoryName.isDisplayed());
        enterCategoryName.sendKeys(sp.ExcelRead().get(3));
        
    }
    
    
    private WebElement selectCompanies;
    /**
     * Method to select companies.
     * @throws IOException 
     */
    public void selectCompanies() throws IOException{
    	ProductCategoryPage sp=new ProductCategoryPage(driver);
        WebElement Companieselement = driver.findElement(By.xpath("//select[@name='entities']"));
        Select se = new Select(Companieselement);
        se.selectByVisibleText(sp.ExcelRead().get(4));

    }

    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Save Changes']")
    private WebElement clickSaveChangesButton;
    /**
     * Method to click on Save Changes Button.
     * @throws IOException 
     */
    public void clickSaveChangesButton() throws IOException{
    	ProductCategoryPage sp=new ProductCategoryPage(driver);
        log.info("Click on Save Changes Button");
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
    	ProductCategoryPage sp=new ProductCategoryPage(driver);
        log.info("Verifying if Account Type is created Successfully or not");
        JavaScriptExec.sleep();
        Assert.assertTrue(verifyConfirmationMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
    //@FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Test Category1']")
    private WebElement clickCategoryName;
    /**
     * Method to click on Category Name.
     * @throws IOException 
     */
    public void clickCategoryName() throws IOException{
    	ProductCategoryPage sp=new ProductCategoryPage(driver);
        log.info("Click on Save Changes Button");
        JavaScriptExec.sleep();
        String CategoryName = sp.ExcelRead().get(3);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+CategoryName+"']")).click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit edit']//*[text()='Edit']")
    private WebElement clickEditButton;
    /**
     * Method to click on Edit Button.
     * @throws IOException 
     */
    public void clickEditButton() throws IOException{
    	ProductCategoryPage sp=new ProductCategoryPage(driver);
        log.info("Click on Save Changes Button");
        navigateBottom();
        Assert.assertTrue(clickEditButton.isDisplayed());
        clickEditButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='description']")
    private WebElement enterNewCategoryName;
    /**
     * Method to Enter Category Name.
     * @throws IOException 
     */
    public void enterNewCategoryName() throws IOException{
    	ProductCategoryPage sp=new ProductCategoryPage(driver);
        log.info("Enter Category Name");
        Assert.assertTrue(enterNewCategoryName.isDisplayed());
        enterNewCategoryName.clear();
        enterNewCategoryName.sendKeys(sp.ExcelRead().get(5));
        
    }

    @FindBy(how=How.XPATH, using="//input[@name='description']")
    private WebElement enterAssetCategoryName;
    /**
     * Method to Enter Category Name.
     * @throws IOException
     */
    public void enterAssetCategoryName() throws IOException{
        ProductCategoryPage sp=new ProductCategoryPage(driver);
        log.info("Enter Asset Category Name");
        Assert.assertTrue(enterAssetCategoryName.isDisplayed());
        enterAssetCategoryName.sendKeys(sp.ExcelRead().get(6));

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
        Assert.assertTrue(clickGlobalCheckbox.isDisplayed());
        clickGlobalCheckbox.click(); 
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='allowAssetManagement']")
    private WebElement clickAllowAssestMgmt;
    /**
     * Method to click Allow Assest Mgmt checkbox.
     * @throws IOException 
     */
    public void clickAllowAssestMgmt() throws IOException{
    	ProductCategoryPage sp=new ProductCategoryPage(driver);
        log.info("Click Allow Assest Mgmt checkbox");
        Assert.assertTrue(clickAllowAssestMgmt.isDisplayed());
        clickAllowAssestMgmt.click(); 
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='assetStatus.1.description']")
    private WebElement enterAssetName;
    /**
     * Method to enter Asset Name.
     * @throws IOException 
     */
    public void enterAssetName() throws IOException{
    	ProductCategoryPage sp=new ProductCategoryPage(driver);
        log.info("Enter Asset Name");
        Assert.assertTrue(enterAssetName.isDisplayed());
        enterAssetName.sendKeys(sp.ExcelRead().get(7));
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='assetStatus.1.isAvailable']")
    private WebElement clickAvaiableCheckbox;
    /**
     * Method to click Available Checkbox.
     * @throws IOException 
     */
    public void clickAvaiableCheckbox() throws IOException{
    	ProductCategoryPage sp=new ProductCategoryPage(driver);
        log.info("Click Available Checkbox");
        Assert.assertTrue(clickAvaiableCheckbox.isDisplayed());
        clickAvaiableCheckbox.click(); 
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='assetStatus.1.isDefault']")
    private WebElement clickDefaultCheckbox;
    /**
     * Method to click Default Checkbox.
     * @throws IOException 
     */
    public void clickDefaultCheckbox() throws IOException{
    	ProductCategoryPage sp=new ProductCategoryPage(driver);
        log.info("Click Default Checkbox");
        Assert.assertTrue(clickDefaultCheckbox.isDisplayed());
        clickDefaultCheckbox.click(); 
    }
    
    @FindBy(how=How.XPATH, using="//a[@onclick='addModelStatus()']")
    private WebElement clickAddPlus;
    /**
     * Method to click Add Plus.
     * @throws IOException 
     */
    public void clickAddPlus() throws IOException{
    	ProductCategoryPage sp=new ProductCategoryPage(driver);
        log.info("Click Add Plus in Asset Statuses");
        Assert.assertTrue(clickAddPlus.isDisplayed());
        clickAddPlus.click(); 
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='assetStatus.1.description']")
    private WebElement enterAssetName2;
    /**
     * Method to enter Asset Name2.
     * @throws IOException 
     */
    public void enterAssetName2() throws IOException{
    	ProductCategoryPage sp=new ProductCategoryPage(driver);
        log.info("Enter Asset Name2");
        Assert.assertTrue(enterAssetName2.isDisplayed());
        enterAssetName2.sendKeys(sp.ExcelRead().get(8));
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='assetStatus.1.isOrderSaved']")
    private WebElement clickOrderSavedCheckbox;
    /**
     * Method to click Order Saved Checkbox.
     * @throws IOException 
     */
    public void clickOrderSavedCheckbox() throws IOException{
    	ProductCategoryPage sp=new ProductCategoryPage(driver);
        log.info("Click Order Saved Checkbox");
        Assert.assertTrue(clickOrderSavedCheckbox.isDisplayed());
        clickOrderSavedCheckbox.click(); 
    }
    
    @FindBy(how=How.XPATH, using="//a[@onclick='addMetaField()']")
    private WebElement clickAddMetaFieldPlus;
    /**
     * Method to click on Add Metafield plus.
     * @throws IOException 
     */
    public void clickAddMetaFieldPlus() throws IOException{
    	ProductCategoryPage sp=new ProductCategoryPage(driver);
        log.info("Click Add Metafield Plus");
        Assert.assertTrue(clickAddMetaFieldPlus.isDisplayed());
        clickAddMetaFieldPlus.click(); 
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='metaField2.name']")
    private WebElement enterMetafieldName;
    /**
     * Method to enter metafield name.
     * @throws IOException 
     */
    public void enterMetafieldName() throws IOException{
    	ProductCategoryPage sp=new ProductCategoryPage(driver);
        log.info("Enter Meta field name");
        Assert.assertTrue(enterMetafieldName.isDisplayed());
        enterMetafieldName.sendKeys(sp.ExcelRead().get(9));
    }
    
    
    
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        JavaScriptExec.sleep();
    }

}