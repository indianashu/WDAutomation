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
import webDataPages.LoginPage;

import org.openqa.selenium.support.ui.Select;

/**
 * @author Ashutosh
 *
 */

public class ImpersonateCustomerPage extends BasePage{
    /**
     * This constructor is used to initialize the webdriver in BasePage class, if the user does not want to use page factory
     * then this will take care of initialization of the driver
     *
     * @param webdriver
     */
    public ImpersonateCustomerPage(WebDriver webdriver) {
        super(webdriver);
    }

    Logger log=Logger.getLogger(ImpersonateCustomerPage.class);
    ImpersonateCustomerPage customerPage;
    PropertyValExtractors p = new PropertyValExtractors();
  
    public  ArrayList<String> ExcelRead() throws IOException{
    	

		ArrayList<String> rl=new ArrayList<String>();
		File file=new File(System.getProperty("user.dir") +"/Webdata_TestData.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("ImpersonateCust");
		
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
    	ImpersonateCustomerPage sp=new ImpersonateCustomerPage(driver);
    	
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
    	ImpersonateCustomerPage sp=new ImpersonateCustomerPage(driver);
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
    	ImpersonateCustomerPage sp=new ImpersonateCustomerPage(driver);
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
    	ImpersonateCustomerPage sp=new ImpersonateCustomerPage(driver);
        log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
        Assert.assertTrue(clickLoginButton.isDisplayed());
        clickLoginButton.click();
    }

    @FindBy(how=How.XPATH, using="//a[.='Customers']")
    private WebElement clickCustomerTab;
    /**
     * Method to click on Customer tab after successful login.
     * @throws IOException 
     */
    public void clickCustomerTab() throws IOException{
    	ImpersonateCustomerPage sp=new ImpersonateCustomerPage(driver);
        log.info("Click on Customer Tab after successful login");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickCustomerTab);
        Assert.assertTrue(clickCustomerTab.isDisplayed());
        clickCustomerTab.click();
        
    }
    
    
    //@FindBy(how=How.XPATH, using="//a[@class='cell double']")
    private WebElement selectCustomer;
    /**
     * Method to select customer.
     * @throws IOException 
     */
    public void selectCustomer() throws IOException{
    	ImpersonateCustomerPage sp=new ImpersonateCustomerPage(driver);
        log.info("Select Customer");
        WaitClass.sleep(2000);
        String CustomerName = sp.ExcelRead().get(3);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+CustomerName+"']")).click();
        
    }
  
    @FindBy(how = How.XPATH, using = "//*[@id='column2']/div[4]/div/table/tbody/tr[2]/td[2]/a/img")
	private WebElement clickImpersonateUserImage;

	/**
	 * Method to click on Impersonate This User Image.
	 * 
	 * @throws IOException
	 */
	public void clickImpersonateUserImage() throws IOException {
		ImpersonateCustomerPage sp = new ImpersonateCustomerPage(driver);
		log.info("Click on Impersonate This User Image");
		WaitClass.sleep(2000);
		WaitClass.WaitForElementisDisplay(driver, 10, clickImpersonateUserImage);
		Assert.assertTrue(clickImpersonateUserImage.isDisplayed());
		clickImpersonateUserImage.click();

	}
    
	
	  @FindBy(how = How.XPATH, using = "//a[@class='cell double']")
		private WebElement verifyCustomerName;

		/**
		 * Method to Verify Customer Name.
		 * 
		 * @throws IOException
		 */
		public void verifyCustomerName() throws IOException {
			ImpersonateCustomerPage sp = new ImpersonateCustomerPage(driver);
			log.info("Verify Customer Name");
			WaitClass.sleep(2000);
			WaitClass.WaitForElementisDisplay(driver, 10, verifyCustomerName);
			Assert.assertTrue(verifyCustomerName.isDisplayed());
			String ActualCustomer = verifyCustomerName.getText();
			String ExpectedCustomer = sp.ExcelRead().get(3);
			Assert.assertEquals(ActualCustomer, ExpectedCustomer);

		}
	
    
    @FindBy(how=How.XPATH, using="//*[@id='header']/ul/li[2]/a")
    private WebElement clickResumeAsAdmin;
    /**
     * Method to click on Resume as Admin Link.
     * @throws IOException 
     */
    public void clickResumeAsAdmin() throws IOException{
    	ImpersonateCustomerPage sp=new ImpersonateCustomerPage(driver);
        log.info("click on Resume as Admin Link.");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickResumeAsAdmin);
        Assert.assertTrue(clickResumeAsAdmin.isDisplayed());
        clickResumeAsAdmin.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//*[@id='header']/ul/li[1]")
    private WebElement verifyAdminLogin;
    /**
     * Method to verify Label shown is of admin.
     * @throws IOException 
     */
    public void verifyAdminLogin() throws IOException{
    	ImpersonateCustomerPage sp=new ImpersonateCustomerPage(driver);
        log.info("Verify Label shown is of admin.");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyAdminLogin);
        Assert.assertTrue(verifyAdminLogin.getText().contains(sp.ExcelRead().get(2)), "Assert Failed as its unable to search text in Logged in Page");
    }
        
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        WaitClass.sleep(2000);
    }


}
