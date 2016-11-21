package companyHierarchy;

import baseClassPackage.BasePage;
import companySetUp.ConfigurationAccountTypePage;

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

public class ViewAssignedInfoPage extends BasePage{
    /**
     * This constructor is used to initialize the webdriver in BasePage class, if the user does not want to use page factory
     * then this will take care of initialization of the driver
     *
     * @param webdriver
     */
    public ViewAssignedInfoPage(WebDriver webdriver) {
        super(webdriver);
    }

    Logger log=Logger.getLogger(ViewAssignedInfoPage.class);
    ViewAssignedInfoPage viewAssignedInfoPage;
    PropertyValExtractors p = new PropertyValExtractors();
  
    public  ArrayList<String> ExcelRead() throws IOException{
    	

		ArrayList<String> rl=new ArrayList<String>();
		File file=new File(System.getProperty("user.dir") +"/Webdata_TestData.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("ImpersonateInfo");
		
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
    	ViewAssignedInfoPage sp=new ViewAssignedInfoPage(driver);
    	
        log.info("Enter Login ID for logging in.");
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
    	ViewAssignedInfoPage sp=new ViewAssignedInfoPage(driver);
        log.info("Enter Password for login");
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
    	ViewAssignedInfoPage sp=new ViewAssignedInfoPage(driver);
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
    	ViewAssignedInfoPage sp=new ViewAssignedInfoPage(driver);
        log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
        Assert.assertTrue(clickLoginButton.isDisplayed());
        clickLoginButton.click();
    }

  
    @FindBy(how=How.XPATH,using="//*[@id='impersonate']")
    private WebElement clickImpersonate;
    /**
     * Method to Click on  Impersonate Link
     */
    public void clickImpersonate(){
    	ViewAssignedInfoPage sp=new ViewAssignedInfoPage(driver);
        log.info("Click on Impersonate Link");
		WaitClass.WaitForElementisDisplay(driver, 5, clickImpersonate);
        Assert.assertTrue(clickImpersonate.isDisplayed());
        clickImpersonate.click();
    }
    
  
    private WebElement selectChildCompany;
    /**
     * Method to select Child Company.
     * @throws IOException 
     */
    public void selectChildCompany() throws IOException{
    	ViewAssignedInfoPage sp=new ViewAssignedInfoPage(driver);
        WebElement Companyelement = driver.findElement(By.xpath("//select[@name='entityId']"));
        Select se = new Select(Companyelement);
        se.selectByVisibleText(sp.ExcelRead().get(3));

    }
  
    
    @FindBy(how=How.XPATH,using="//a[@class='submit select']//*[text()='Select']")
    private WebElement clickSelectButton;
    /**
     * Method to Click on  Select Button
     */
    public void clickSelectButton(){
    	ViewAssignedInfoPage sp=new ViewAssignedInfoPage(driver);
        log.info("Click on Select Button");
		WaitClass.WaitForElementisDisplay(driver, 5, clickSelectButton);
        Assert.assertTrue(clickSelectButton.isDisplayed());
        clickSelectButton.click();
    }

    
    //@FindBy(how=How.XPATH,using="//*[@id='header']/ul/a")
    private WebElement verifyChildCompanyName;
    /**
     * Method to Verify Child Company Name is shown
     * @throws IOException 
     */
    public void verifyChildCompanyName() throws IOException{
    	ViewAssignedInfoPage sp=new ViewAssignedInfoPage(driver);
        log.info("Verify Child Company Name is shown.");
        String ExpectedName = sp.ExcelRead().get(3);
        String ActualName = driver.findElement(By.xpath("//*[@id='header']/ul/a")).getText();
        Assert.assertEquals(ActualName, ExpectedName);
    }
    
    
  
    @FindBy(how=How.XPATH, using="//*[@id='navList']/li[7]/a/span")
    private WebElement clickProductsTab;
    /**
     * Method to click on Products Tab
     * @throws IOException 
     */
    public void clickProductsTab() throws IOException{
    	ViewAssignedInfoPage sp=new ViewAssignedInfoPage(driver);
        log.info("Click on Products Tab");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickProductsTab);
        Assert.assertTrue(clickProductsTab.isDisplayed());
        clickProductsTab.click();
        
    }
    
  
    @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Asset Category1']")
    private WebElement clickCategoryName;
    /**
     * Method to click on CategoryName
     * @throws IOException 
     */
    public void clickCategoryName() throws IOException{
    	ViewAssignedInfoPage sp=new ViewAssignedInfoPage(driver);
        log.info("Click on Category Name");
        WaitClass.sleep(10000);
        String CategoryName = sp.ExcelRead().get(4);
        String ActualName = driver.findElement(By.xpath("//a[@class='cell double']//*[text()='Asset Category1']")).getText();
        Assert.assertEquals(ActualName, CategoryName);
        WaitClass.sleep(5000);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='Asset Category1']")).click();
        
    }
  
    @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='SIM Cards']")
    private WebElement clickProductName;
    /**
     * Method to click on Product Name
     * @throws IOException 
     */
    public void clickProductName() throws IOException{
    	ViewAssignedInfoPage sp=new ViewAssignedInfoPage(driver);
        log.info("Click on Product Name");
        WaitClass.sleep(10000);
        String ProductName = sp.ExcelRead().get(5);
        String ActualName = driver.findElement(By.xpath("//a[@class='cell double']//*[text()='SIM Cards']")).getText();
        Assert.assertEquals(ActualName, ProductName);
        WaitClass.sleep(5000);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='SIM Cards']")).click();
        
    }
    
  
    @FindBy(how=How.XPATH, using="//a[@class='submit show']//*[text()='Show Assets']")
    private WebElement clickShowAssetsButton;
    /**
     * Method to click on Show Assets Button
     * @throws IOException 
     */
    public void clickShowAssetsButton() throws IOException{
    	ViewAssignedInfoPage sp=new ViewAssignedInfoPage(driver);
        log.info("Click on Show Assets Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickShowAssetsButton);
        Assert.assertTrue(clickShowAssetsButton.isDisplayed());
        clickShowAssetsButton.click();
        
        
    }
    
  
    @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='SIM-001']")
    private WebElement verifyAssetName;
    /**
     * Method to verify Asset Name
     * @throws IOException 
     */
    public void verifyAssetName() throws IOException{
    	ViewAssignedInfoPage sp=new ViewAssignedInfoPage(driver);
        log.info("Verify Asset Name.");
        WaitClass.sleep(10000);
        String AssetName = sp.ExcelRead().get(6);
        String ActualName = driver.findElement(By.xpath("//a[@class='cell double']//*[text()='SIM Cards']")).getText();
        Assert.assertEquals(ActualName, AssetName);
        
    } 

 
    
    @FindBy(how=How.XPATH, using="//*[@id='header']/ul/a")
    private WebElement clickRedCross;
    /**
     * Method to click on Red Cross
     * @throws IOException 
     */
    public void clickRedCross() throws IOException{
    	ViewAssignedInfoPage sp=new ViewAssignedInfoPage(driver);
        log.info("Click on Red Cross");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickRedCross);
        Assert.assertTrue(clickRedCross.isDisplayed());
        clickRedCross.click();
        
    }
    
    
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        WaitClass.sleep(5000);
    }


}
