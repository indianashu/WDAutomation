package webDataPages;

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

public class ImpersonatePage extends BasePage{
    /**
     * This constructor is used to initialize the webdriver in BasePage class, if the user does not want to use page factory
     * then this will take care of initialization of the driver
     *
     * @param webdriver
     */
    public ImpersonatePage(WebDriver webdriver) {
        super(webdriver);
    }

    Logger log=Logger.getLogger(ImpersonatePage.class);
    ImpersonatePage impersonatePage;
    PropertyValExtractors p = new PropertyValExtractors();
  
    public  ArrayList<String> ExcelRead() throws IOException{
    	

		ArrayList<String> rl=new ArrayList<String>();
		File file=new File(System.getProperty("user.dir") +"/Webdata_TestData.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("Impersonate");
		
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
    	ImpersonatePage sp=new ImpersonatePage(driver);
    	
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
    	ImpersonatePage sp=new ImpersonatePage(driver);
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
    	ImpersonatePage sp=new ImpersonatePage(driver);
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
    	ImpersonatePage sp=new ImpersonatePage(driver);
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
    	ImpersonatePage sp=new ImpersonatePage(driver);
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
    	ImpersonatePage sp=new ImpersonatePage(driver);
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
    	ImpersonatePage sp=new ImpersonatePage(driver);
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
    	ImpersonatePage sp=new ImpersonatePage(driver);
        log.info("Verify Child Company Name is shown.");
        String ExpectedName = sp.ExcelRead().get(3);
        String ActualName = driver.findElement(By.xpath("//*[@id='header']/ul/a")).getText();
        Assert.assertEquals(ActualName, ExpectedName);
    }
    
    
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        WaitClass.sleep(5000);
    }


}
