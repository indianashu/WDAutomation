package agentcommissions;

import baseClassPackage.BasePage;
import categoryProducts.AddProductPage;
import customer.CustomerPage;

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

public class AgentPage extends BasePage{
    /**
     * This constructor is used to initialize the webdriver in BasePage class, if the user does not want to use page factory
     * then this will take care of initialization of the driver
     *
     * @param webdriver
     */
    public AgentPage(WebDriver webdriver) {
        super(webdriver);
    }

    Logger log=Logger.getLogger(AgentPage.class);
    AgentPage agentPage;
    PropertyValExtractors p = new PropertyValExtractors();
  
    public  ArrayList<String> ExcelRead() throws IOException{
    	

		ArrayList<String> rl=new ArrayList<String>();
		File file=new File(System.getProperty("user.dir") +"/Webdata_TestData.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("Agent");
		
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
    	AgentPage sp=new AgentPage(driver);
    	
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
    	AgentPage sp=new AgentPage(driver);
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
    	AgentPage sp=new AgentPage(driver);
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
    	AgentPage sp=new AgentPage(driver);
        log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
        Assert.assertTrue(clickLoginButton.isDisplayed());
        clickLoginButton.click();
    }

    @FindBy(how=How.XPATH, using="//*[@id='navList']/li[2]/a/span")
    private WebElement clickAgentTab;
    /**
     * Method to click on Agent tab after successful login.
     * @throws IOException 
     */
    public void clickAgentTab() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Click on Agent Tab after successful login");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAgentTab);
        Assert.assertTrue(clickAgentTab.isDisplayed());
        clickAgentTab.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add New']")
    private WebElement clickAddNewButton;
    /**
     * Method to click on add new button".
     * @throws IOException 
     */
    public void clickAddNewButton() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Click on add new button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddNewButton);
        Assert.assertTrue(clickAddNewButton.isDisplayed());
        clickAddNewButton.click();
        
    }
    
    
    @FindBy(how=How.XPATH, using="//input[@name='user.userName']")
    private WebElement enterLoginName;
    /**
     * Method to Enter Login Name.
     * @throws IOException 
     */
    public void enterLoginName() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Enter Login Name");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterLoginName);
        Assert.assertTrue(enterLoginName.isDisplayed());
        enterLoginName.sendKeys(sp.ExcelRead().get(3));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='contact.email']")
    private WebElement enterEmail;
    /**
     * Method to Enter Email.
     * @throws IOException 
     */
    public void enterEmail() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Enter Product Code");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterEmail);
        Assert.assertTrue(enterEmail.isDisplayed());
        enterEmail.sendKeys(sp.ExcelRead().get(4));
        
    }
    
    
    private WebElement selectAgentType;
    /**
     * Method to select agent type.
     * @throws IOException 
     */
    public void selectCompanies() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        WebElement AgentTypeelement = driver.findElement(By.xpath("//select[@name='type']"));
        Select se = new Select(AgentTypeelement);
        se.selectByVisibleText(sp.ExcelRead().get(5));

    }

    private WebElement selectCommissionType;
    /**
     * Method to select commission type.
     * @throws IOException 
     */
    public void selectCommissionType() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        WebElement CommissionTypeelement = driver.findElement(By.xpath("//select[@name='commissionType']"));
        Select se = new Select(CommissionTypeelement);
        se.selectByVisibleText(sp.ExcelRead().get(6));

    }
    
    @FindBy(how=How.XPATH, using="//*[@id='navList']/li[1]/a/span")
    private WebElement clickCustomerTab;
    /**
     * Method to click on Customer Tab.
     * @throws IOException 
     */
    public void clickCustomerTab() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Click on Customer Tab");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickCustomerTab);
        Assert.assertTrue(clickCustomerTab.isDisplayed());
        clickCustomerTab.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add New']")
    private WebElement clickAddNewCustomerButton;
    /**
     * Method to click on Add new customer button.
     * @throws IOException 
     */
    public void clickAddNewCustomerButton() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Click on Customer Tab");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddNewCustomerButton);
        Assert.assertTrue(clickAddNewCustomerButton.isDisplayed());
        clickAddNewCustomerButton.click();
        
    }
        
    private WebElement selectUserCompany;
    /**
     * Method to select user company.
     * @throws IOException 
     */
    public void selectUserCompany() throws IOException{
    	CustomerPage sp=new CustomerPage(driver);
        WebElement Usercompanyelement = driver.findElement(By.xpath("//select[@name='user.entityId']"));
        Select se = new Select(Usercompanyelement);
        se.selectByVisibleText(sp.ExcelRead().get(7));

    }
    
    private WebElement selectAccountType;
    /**
     * Method to select account type.
     * @throws IOException 
     */
    public void selectAccountType() throws IOException{
    	CustomerPage sp=new CustomerPage(driver);
        WebElement AccountTypeelement = driver.findElement(By.xpath("//select[@name='accountTypeId']"));
        Select se = new Select(AccountTypeelement);
        se.selectByVisibleText(sp.ExcelRead().get(8));

    }    

    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Select']")
    private WebElement clickSelectButton;
    /**
     * Method to click on select Button.
     * @throws IOException 
     */
    public void clickSelectButton() throws IOException{
    	CustomerPage sp=new CustomerPage(driver);
        log.info("Click on select Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickSelectButton);
        Assert.assertTrue(clickSelectButton.isDisplayed());
        clickSelectButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='user.userName']")
    private WebElement enterLoginName1;
    /**
     * Method to Enter Login Name.
     * @throws IOException 
     */
    public void enterLoginName1() throws IOException{
    	CustomerPage sp=new CustomerPage(driver);
        log.info("Enter Login Name");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterLoginName1);
        Assert.assertTrue(enterLoginName1.isDisplayed());
        enterLoginName1.sendKeys(sp.ExcelRead().get(9));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='user.userName']")
    private WebElement enterAgentID;
    /**
     * Method to Enter Agent ID.
     * @throws IOException 
     */
    public void enterAgentID() throws IOException{
    	CustomerPage sp=new CustomerPage(driver);
        log.info("Enter Agent ID");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterAgentID);
        Assert.assertTrue(enterAgentID.isDisplayed());
        enterAgentID.sendKeys(sp.ExcelRead().get(10));
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Save Changes']")
    private WebElement clickSaveChangesButton;
    /**
     * Method to click on Save Changes Button.
     * @throws IOException 
     */
    public void clickSaveChangesButton() throws IOException{
    	AgentPage sp=new AgentPage(driver);
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
    	AgentPage sp=new AgentPage(driver);
        log.info("Verifying if Account Type is created Successfully or not");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyConfirmationMsg);
        Assert.assertTrue(verifyConfirmationMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
    @FindBy(how=How.XPATH, using="//*[@id='navList']/li[7]/a/span")
    private WebElement clickProductTab;
    /**
     * Method to click on Product Tab.
     * @throws IOException 
     */
    public void clickProductTab() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Click on Product Tab");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickProductTab);
        Assert.assertTrue(clickProductTab.isDisplayed());
        clickProductTab.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add Category']")
    private WebElement clickAddCategoryButton;
    /**
     * Method to click on Add Category Button.
     * @throws IOException 
     */
    public void clickAddCategoryButton() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Click on Add Category Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddCategoryButton);
        Assert.assertTrue(clickAddCategoryButton.isDisplayed());
        clickAddCategoryButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='description']")
    private WebElement enterCategoryName;
    /**
     * Method to Enter Name for Category.
     * @throws IOException 
     */
    public void enterCategoryName() throws IOException{
    	CustomerPage sp=new CustomerPage(driver);
        log.info("Enter Name for Category");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterCategoryName);
        Assert.assertTrue(enterCategoryName.isDisplayed());
        enterCategoryName.sendKeys(sp.ExcelRead().get(11));
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Commissioned Product']")
    private WebElement clickProductCategoryName;
    /**
     * Method to click on Product Category Name - Commissioned Product.
     * @throws IOException 
     */
    public void clickProductCategoryName() throws IOException{
    	AgentPage sp=new AgentPage(driver);
        log.info("Click on Product Category Name - Commissioned Product");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickProductCategoryName);
        Assert.assertTrue(clickProductCategoryName.isDisplayed());
        clickProductCategoryName.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add Product']")
    private WebElement clickAddProductButton;
    /**
     * Method to click on Add Product Button".
     * @throws IOException 
     */
    public void clickAddProductButton() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        log.info("Click on Add Product Button");
        WaitClass.sleep(10000);
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
    	AddProductPage sp=new AddProductPage(driver);
        log.info("Enter English Description");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterEnglishDescription);
        Assert.assertTrue(enterEnglishDescription.isDisplayed());
        enterEnglishDescription.sendKeys(sp.ExcelRead().get(12));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.number']")
    private WebElement enterProductCode;
    /**
     * Method to Enter Product Code.
     * @throws IOException 
     */
    public void enterProductCode() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        log.info("Enter Product Code");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterProductCode);
        Assert.assertTrue(enterProductCode.isDisplayed());
        enterProductCode.sendKeys(sp.ExcelRead().get(13));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.standardPartnerPercentageAsDecimal']")
    private WebElement enterStdCommission;
    /**
     * Method to Enter Standard Agent Commission.
     * @throws IOException 
     */
    public void enterStdCommission() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        log.info("Enter Standard Agent Commission");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterStdCommission);
        Assert.assertTrue(enterStdCommission.isDisplayed());
        enterStdCommission.sendKeys(sp.ExcelRead().get(14));
        
    }
   
    
    @FindBy(how=How.XPATH, using="//input[@name='product.masterPartnerPercentageAsDecimal']")
    private WebElement enterMasterCommission;
    /**
     * Method to Enter Master Agent Commission.
     * @throws IOException 
     */
    public void enterMasterCommission() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        log.info("Enter Master Agent Commission");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterMasterCommission);
        Assert.assertTrue(enterMasterCommission.isDisplayed());
        enterMasterCommission.sendKeys(sp.ExcelRead().get(15));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.rate']")
    private WebElement enterPriceRate;
    /**
     * Method to Enter Price Rate.
     * @throws IOException 
     */
    public void enterPriceRate() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        log.info("Enter Price Rate");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterPriceRate);
        Assert.assertTrue(enterPriceRate.isDisplayed());
        enterPriceRate.sendKeys(sp.ExcelRead().get(16));
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add Price']")
    private WebElement clickAddPriceButton;
    /**
     * Method to click on Add Price Button.
     * @throws IOException 
     */
    public void clickAddPriceButton() throws IOException{
    	AddProductPage sp=new AddProductPage(driver);
        log.info("Click on Add Price Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddPriceButton);
        Assert.assertTrue(clickAddPriceButton.isDisplayed());
        clickAddPriceButton.click();
        
    }
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        WaitClass.sleep(5000);
    }


}
