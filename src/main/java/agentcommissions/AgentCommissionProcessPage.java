package agentcommissions;

import baseClassPackage.BasePage;
import categoryProducts.AddProductPage;
import customer.CustomerPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

public class AgentCommissionProcessPage extends BasePage{
    /**
     * This constructor is used to initialize the webdriver in BasePage class, if the user does not want to use page factory
     * then this will take care of initialization of the driver
     *
     * @param webdriver
     */
    public AgentCommissionProcessPage(WebDriver webdriver) {
        super(webdriver);
    }

    Logger log=Logger.getLogger(AgentCommissionProcessPage.class);
    AgentCommissionProcessPage agentCommissionProcessPage;
    PropertyValExtractors p = new PropertyValExtractors();
  
    public  ArrayList<String> ExcelRead() throws IOException{
    	

		ArrayList<String> rl=new ArrayList<String>();
		File file=new File(System.getProperty("user.dir") +"/Webdata_TestData.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("AgentComProcess");
		
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
    	AgentCommissionProcessPage sp=new AgentCommissionProcessPage(driver);
    	
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
    	AgentCommissionProcessPage sp=new AgentCommissionProcessPage(driver);
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
    	AgentCommissionProcessPage sp=new AgentCommissionProcessPage(driver);
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
    	AgentCommissionProcessPage sp=new AgentCommissionProcessPage(driver);
        log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
        Assert.assertTrue(clickLoginButton.isDisplayed());
        clickLoginButton.click();
    }

    @FindBy(how=How.XPATH, using="//a[.='Agents']")
    private WebElement clickAgentTab;
    /**
     * Method to click on Agent tab after successful login.
     * @throws IOException 
     */
    public void clickAgentTab() throws IOException{
    	AgentCommissionProcessPage sp=new AgentCommissionProcessPage(driver);
        log.info("Click on Agent Tab after successful login");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAgentTab);
        Assert.assertTrue(clickAgentTab.isDisplayed());
        clickAgentTab.click();
        
    }
    
    //@FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Agent A']")
    private WebElement selectAgent;
    /**
     * Method to select an Agent - Agent A".
     * @throws IOException 
     */
    public void selectAgent() throws IOException{
    	AgentCommissionProcessPage sp=new AgentCommissionProcessPage(driver);
        log.info("select an Agent - Agent A");
        WaitClass.sleep(10000);
        String AgentName = sp.ExcelRead().get(3);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+AgentName+"']")).click();
        
    }
    
    
    @FindBy(how=How.XPATH, using="//*[@id='column2']/div/div[7]/div/a[5]/span")
    private WebElement clickShowCommissionButton;
    /**
     * Method to Click on Show Commission Button.
     * @throws IOException 
     */
    public void clickShowCommissionButton() throws IOException{
    	AgentCommissionProcessPage sp=new AgentCommissionProcessPage(driver);
        log.info("Click on Show Commission Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickShowCommissionButton);
        Assert.assertTrue(clickShowCommissionButton.isDisplayed());
        clickShowCommissionButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//*[@id='column1']/div[2]")
    private WebElement verifyCommissionDisplay;
    /**
     * Method to Verify No Commission is Display.
     * @throws IOException 
     */
    public void verifyCommissionDisplay() throws IOException{
    	AgentCommissionProcessPage sp=new AgentCommissionProcessPage(driver);
        log.info("Verifiy No Commission is Display");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyCommissionDisplay);
        Assert.assertTrue(verifyCommissionDisplay.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
        
    }
    
    
    @FindBy(how=How.XPATH, using="//a[.='Customers']")
    private WebElement clickCustomerTab;
    /**
     * Method to click on Customer Tab.
     * @throws IOException 
     */
    public void clickCustomerTab() throws IOException{
    	AgentCommissionProcessPage sp=new AgentCommissionProcessPage(driver);
        log.info("Click on Customer Tab");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickCustomerTab);
        Assert.assertTrue(clickCustomerTab.isDisplayed());
        clickCustomerTab.click();
        
    }
    
    //@FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Customer A']")
    private WebElement clickCustomerB;
    /**
     * Method to click on Customer - CustomerB.
     * @throws IOException 
     */
    public void clickCustomerB() throws IOException{
    	AgentCommissionProcessPage sp=new AgentCommissionProcessPage(driver);
        log.info("Click on Customer - CustomerB");
        WaitClass.sleep(10000);
        String CustomerName = sp.ExcelRead().get(4);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+CustomerName+"']")).click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit order']//*[text()='Create Order']")
    private WebElement clickCreateOrderButton;
    /**
     * Method to click on Create Order Button.
     * @throws IOException 
     */
    public void clickCreateOrderButton() throws IOException{
        JavaScriptExec.scrollToElementOnPage(driver,clickCreateOrderButton);
    	AgentCommissionProcessPage sp=new AgentCommissionProcessPage(driver);
        log.info("Click on Create Order Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickCreateOrderButton);
        Assert.assertTrue(clickCreateOrderButton.isDisplayed());
        clickCreateOrderButton.click();
        WaitClass.sleep(10000);
    }
    
    private WebElement selectOrderPeriod;
    /**
     * Method to select Order Period.
     * @throws IOException 
     */
    public void selectOrderPeriod() throws IOException{
    	AgentCommissionProcessPage sp=new AgentCommissionProcessPage(driver);
        WaitClass.sleep(10000);
        WebElement Periodelement = driver.findElement(By.xpath("//select[@id='orderPeriod']"));
        Select se = new Select(Periodelement);
        se.selectByVisibleText(sp.ExcelRead().get(5));

    }
    
    private WebElement selectType;
    /**
     * Method to select type.
     * @throws IOException 
     */
    public void selectType() throws IOException{
    	AgentCommissionProcessPage sp=new AgentCommissionProcessPage(driver);
        WaitClass.sleep(10000);
        WebElement Typeelement = driver.findElement(By.xpath("//select[@id='billingTypeId']"));
        Select se = new Select(Typeelement);
        se.selectByVisibleText(sp.ExcelRead().get(6));

    }    

    
    @FindBy(how=How.XPATH, using="//*[@id='ui-id-8']")
    private WebElement clickProductsSubTab;
    /**
     * Method to click on product sub tab.
     * @throws IOException 
     */
    public void clickProductsSubTab() throws IOException{
    	AgentCommissionProcessPage sp=new AgentCommissionProcessPage(driver);
        log.info("Click on Product Tab");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickProductsSubTab);
        Assert.assertTrue(clickProductsSubTab.isDisplayed());
        clickProductsSubTab.click();
        
    }
    
   // @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Commission Product']")
    private WebElement clickOnProduct;
    /**
     * Method to click on a product listed in the list.
     * @throws IOException 
     */
    public void clickOnProduct() throws IOException{
    	AgentCommissionProcessPage sp=new AgentCommissionProcessPage(driver);
        log.info("click on a product listed in the list");
        WaitClass.sleep(10000);
        String ProductName = sp.ExcelRead().get(7);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+ProductName+"']")).click();
        WaitClass.sleep(10000);
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Update']")
    private WebElement clickUpdateButton;
    /**
     * Method to Click on Update Button to add the product to order.
     * @throws IOException 
     */
    public void clickUpdateButton() throws IOException{
    	AgentCommissionProcessPage sp=new AgentCommissionProcessPage(driver);
        log.info("Click on Update Button to add the product to order");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickUpdateButton);
        Assert.assertTrue(clickUpdateButton.isDisplayed());
        clickUpdateButton.click();
        WaitClass.sleep(10000);
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit order']//*[text()='Generate Invoice']")
    private WebElement clickGenerateInvoiceButton;
    /**
     * Method to Click on Generate Invoice button.
     * @throws IOException 
     */
    public void clickGenerateInvoiceButton() throws IOException{
        JavaScriptExec.scrollToElementOnPage(driver,clickGenerateInvoiceButton);
    	AgentCommissionProcessPage sp=new AgentCommissionProcessPage(driver);
        log.info("Click on Generate Invoice button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickGenerateInvoiceButton);
        Assert.assertTrue(clickGenerateInvoiceButton.isDisplayed());
        clickGenerateInvoiceButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[.='Configuration']")
    private WebElement clickConfigurationTab;
    /**
     * Method to click on configuration tab.
     * @throws IOException 
     */
    public void clickConfigurationTab() throws IOException{
    	AgentCommissionProcessPage sp=new AgentCommissionProcessPage(driver);
        log.info("Click on Configuration Tab");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickConfigurationTab);
        Assert.assertTrue(clickConfigurationTab.isDisplayed());
        clickConfigurationTab.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[.='Agent Commission Process']")
    private WebElement clickAgentCommissionProcess;
    /**
     * Method to click on Agent Commission Process Link in left menu bar.
     * @throws IOException 
     */
    public void clickAgentCommissionProcess() throws IOException{
    	AgentCommissionProcessPage sp=new AgentCommissionProcessPage(driver);
        log.info("Click on Agent Commission Process Link in left menu bar");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAgentCommissionProcess);
        Assert.assertTrue(clickAgentCommissionProcess.isDisplayed());
        clickAgentCommissionProcess.click();
        
    }
   
    @FindBy(how=How.XPATH, using="//input[@name='nextRunDate']")
    private WebElement enterNextRunDate;
    /**
     * Method to enter next run date.
     * @throws IOException 
     */
    public void enterNextRunDate() throws IOException{
    	AgentCommissionProcessPage sp=new AgentCommissionProcessPage(driver);
        log.info("Enter next run date");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterNextRunDate);
        Assert.assertTrue(enterNextRunDate.isDisplayed());
        SimpleDateFormat DtFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        enterNextRunDate.sendKeys(DtFormat.format(date).toString());
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='periodValue']")
    private WebElement enterPeriodValue;
    /**
     * Method to enter period value.
     * @throws IOException 
     */
    public void enterPeriodValue() throws IOException{
    	AgentCommissionProcessPage sp=new AgentCommissionProcessPage(driver);
        log.info("Enter Period Value");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterPeriodValue);
        Assert.assertTrue(enterPeriodValue.isDisplayed());
        enterPeriodValue.sendKeys(sp.ExcelRead().get(9));
        
    }
    
    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Save Changes']")
    private WebElement clickSaveChangesButton;
    /**
     * Method to click on Save Changes Button.
     * @throws IOException 
     */
    public void clickSaveChangesButton() throws IOException{
    	AgentCommissionProcessPage sp=new AgentCommissionProcessPage(driver);
        log.info("Click on Save Changes Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickSaveChangesButton);
        Assert.assertTrue(clickSaveChangesButton.isDisplayed());
        clickSaveChangesButton.click();
        WaitClass.sleep(10000);
    }
   
    @FindBy(how=How.XPATH, using="//a[@class='submit apply']//*[text()='Run Commission Process']")
    private WebElement clickRunCommissionButton;
    /**
     * Method to click on Save Changes Button.
     * @throws IOException 
     */
    public void clickRunCommissionButton() throws IOException{
    	AgentCommissionProcessPage sp=new AgentCommissionProcessPage(driver);
        log.info("Click on Save Changes Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickRunCommissionButton);
        Assert.assertTrue(clickRunCommissionButton.isDisplayed());
        clickRunCommissionButton.click();
        
    }

    @FindBy(how=How.XPATH, using="//*[@id='process-1']/td[2]/a")
    private WebElement clickCommission;
    /**
     * Method to click on Save Changes Button.
     * @throws IOException
     */
    public void clickCommission() throws IOException{
        AgentCommissionProcessPage sp=new AgentCommissionProcessPage(driver);
        log.info("Click on Save Changes Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickCommission);
        Assert.assertTrue(clickCommission.isDisplayed());
        clickCommission.click();
        WaitClass.sleep(10000);
    }

    @FindBy(how=How.XPATH, using="//*[@class='col02']/following::td[1]")
    private WebElement verifyCommissionAmount;
    /**
     * Method to verify Account Type is created Successfully.
     * @throws IOException 
     */
    public void verifyCommissionAmount() throws IOException{
    	AgentCommissionProcessPage sp=new AgentCommissionProcessPage(driver);
        log.info("Verifying Commission Amount");
        WaitClass.sleep(10000);
        String ExpectedAmount = sp.ExcelRead().get(10);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyCommissionAmount);
        Assert.assertEquals(verifyCommissionAmount.getText(), ExpectedAmount);
    }

    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        WaitClass.sleep(10000);
    }


}

