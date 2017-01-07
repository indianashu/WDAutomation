package orderHierarchies;

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

public class OrderHierarchiesPage extends BasePage{
    /**
     * This constructor is used to initialize the webdriver in BasePage class, if the user does not want to use page factory
     * then this will take care of initialization of the driver
     *
     * @param webdriver
     */
    public OrderHierarchiesPage(WebDriver webdriver) {
        super(webdriver);
    }

    Logger log=Logger.getLogger(OrderHierarchiesPage.class);
    OrderHierarchiesPage orderHierarchiesPage;
    PropertyValExtractors p = new PropertyValExtractors();
  
    public  ArrayList<String> ExcelRead() throws IOException{
    	

		ArrayList<String> rl=new ArrayList<String>();
		File file=new File(System.getProperty("user.dir") +"/Webdata_TestData.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("OrderHierarcy");
		
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
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
    	
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
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
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
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
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
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
        Assert.assertTrue(clickLoginButton.isDisplayed());
        clickLoginButton.click();
    }

    @FindBy(how=How.XPATH, using="//a[.='Products']")
    private WebElement clickProductsTab;
    /**
     * Method to click on Products tab after successful login.
     * @throws IOException 
     */
    public void clickProductsTab() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("Click on Products Tab after successful login");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickProductsTab);
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
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("Click on Add Category Button");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddCategoryButton);
        Assert.assertTrue(clickAddCategoryButton.isDisplayed());
        clickAddCategoryButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='description']")
    private WebElement enterProductCategoryName;
    /**
     * Method to enter product category name.
     * @throws IOException 
     */
    public void enterProductCategoryName() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("enter product category name.");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterProductCategoryName);
        Assert.assertTrue(enterProductCategoryName.isDisplayed());
        enterProductCategoryName.sendKeys(sp.ExcelRead().get(3));
        
    }
    
  
    private WebElement clickProductCategory;
    /**
     * Method to click on a product category.
     * @throws IOException 
     */
    public void clickProductCategory() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("enter product category name.");
        WaitClass.sleep(2000);
        String ProductCategory = sp.ExcelRead().get(3);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+ProductCategory+"']")).click();
        
    }
    
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add Product']")
    private WebElement clickAddProductButton;
    /**
     * Method to click on Add Product Button".
     * @throws IOException 
     */
    public void clickAddProductButton() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
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
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("Enter English Description");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterEnglishDescription);
        Assert.assertTrue(enterEnglishDescription.isDisplayed());
        enterEnglishDescription.sendKeys(sp.ExcelRead().get(4));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.number']")
    private WebElement enterProductCode;
    /**
     * Method to Enter Product Code.
     * @throws IOException 
     */
    public void enterProductCode() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("Enter Product Code");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterProductCode);
        Assert.assertTrue(enterProductCode.isDisplayed());
        enterProductCode.sendKeys(sp.ExcelRead().get(5));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.rate']")
    private WebElement enterProductRate;
    /**
     * Method to enter product rate.
     * @throws IOException 
     */
    public void enterProductRate() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("enter product rate.");
        WaitClass.sleep(1000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterProductRate);
        Assert.assertTrue(enterProductRate.isDisplayed());
        enterProductRate.sendKeys(sp.ExcelRead().get(6));
    }

    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add Price']")
    private WebElement clickAddPriceButton;
    /**
     * Method to click on Add Price Button.
     * @throws IOException
     */
    public void clickAddPriceButton() throws IOException{
        OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("Click on Add Price Button");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddPriceButton);
        Assert.assertTrue(clickAddPriceButton.isDisplayed());
        clickAddPriceButton.click();

    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.descriptions[0].content']")
    private WebElement enterEnglishDescription1;
    /**
     * Method to Enter English Description.
     * @throws IOException 
     */
    public void enterEnglishDescription1() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("Enter English Description");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterEnglishDescription1);
        Assert.assertTrue(enterEnglishDescription1.isDisplayed());
        enterEnglishDescription1.sendKeys(sp.ExcelRead().get(7));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.number']")
    private WebElement enterProductCode1;
    /**
     * Method to Enter Product Code.
     * @throws IOException 
     */
    public void enterProductCode1() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("Enter Product Code");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterProductCode1);
        Assert.assertTrue(enterProductCode1.isDisplayed());
        enterProductCode1.sendKeys(sp.ExcelRead().get(8));
        
    }
    
       
    @FindBy(how=How.XPATH, using="//input[@name='product.rate']")
    private WebElement enterProducteRate1;
    /**
     * Method to Enter product Rate.
     * @throws IOException 
     */
    public void enterProducteRate1() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("Enter product Rate");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterProducteRate1);
        Assert.assertTrue(enterProducteRate1.isDisplayed());
        enterProducteRate1.sendKeys(sp.ExcelRead().get(9));
        
    }
    
    
    @FindBy(how=How.XPATH, using="//*[@id='dependency']/div[1]/a/span")
    private WebElement clickDependenciesPlus;
    /**
     * Method to click on Dependencies plus icon.
     * @throws IOException 
     */
    public void clickDependenciesPlus() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("click on Dependencies plus icon");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickDependenciesPlus);
        Assert.assertTrue(clickDependenciesPlus.isDisplayed());
        clickDependenciesPlus.click();
        
    }
    
    private WebElement selectProductCategoryDependency;
    /**
     * Method to select product category in dependencies section.
     * @throws IOException 
     */
    public void selectProductCategoryDependency() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        WaitClass.sleep(1000);
        WebElement PCelement = driver.findElement(By.xpath("//select[@name='product.dependencyItemTypes']"));
        Select se = new Select(PCelement);
        se.selectByVisibleText(sp.ExcelRead().get(10));

    }
    
    private WebElement selectProductDependency;
    /**
     * Method to select product in dependencies section.
     * @throws IOException 
     */
    public void selectProductDependency() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        WaitClass.sleep(1000);
        driver.findElement(By.xpath("//*[@id='product.dependencyItems']/option[2]")).click();

    }
    
    private WebElement selectProductPeriod;
    /**
     * Method to select product period in dependencies section.
     * @throws IOException 
     */
    public void selectProductPeriod() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        WebElement Productelement = driver.findElement(By.xpath("//select[@name='period']"));
        Select se = new Select(Productelement);
        se.selectByVisibleText(sp.ExcelRead().get(12));

    }
    
    @FindBy(how=How.XPATH, using="//*[@id='dependency']/div[2]/div/table/tbody/tr/td[6]/a/img")
    private WebElement clickDependencyPlusIcon;
    /**
     * Method to click on dependency plus icon to add the product.
     * @throws IOException 
     */
    public void clickDependencyPlusIcon() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("click on dependency plus icon to add the product.");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickDependencyPlusIcon);
        Assert.assertTrue(clickDependencyPlusIcon.isDisplayed());
        clickDependencyPlusIcon.click();
        JavaScriptExec.scrollToElementOnPage(driver,clickDependencyPlusIcon);
    }
    
    
    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Save Changes']")
    private WebElement clickSaveChangesButton;
    /**
     * Method to click on Save Changes Button.
     * @throws IOException 
     */
    public void clickSaveChangesButton() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("Click on Save Changes Button");
        WaitClass.sleep(1000);
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
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("Verifying if Account Type is created Successfully or not");
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
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("click on customers tab.");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickCustomersTab);
        Assert.assertTrue(clickCustomersTab.isDisplayed());
        clickCustomersTab.click();
        
    }
    
  
    //@FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Customer A']")
    private WebElement clickCustomerA;
    /**
     * Method to click on a customer.
     * @throws IOException 
     */
    public void clickCustomerA() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("click on a customer.");
        WaitClass.sleep(1000);
        String CustomerName = sp.ExcelRead().get(13);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+CustomerName+"']")).click();
        WaitClass.sleep(1000);
    }
    
  
    @FindBy(how=How.XPATH, using="//a[@class='submit order']//*[text()='Create Order']")
    private WebElement clickCreateOrderButton;
    /**
     * Method to click on create order button.
     * @throws IOException 
     */
    public void clickCreateOrderButton() throws IOException{
        JavaScriptExec.scrollToElementOnPage(driver,clickCreateOrderButton);
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("click on create order button.");
        WaitClass.sleep(1000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickCreateOrderButton);
        Assert.assertTrue(clickCreateOrderButton.isDisplayed());
        clickCreateOrderButton.click();
        WaitClass.sleep(1000);
    }

    private WebElement selectOrderPeriod;
    /**
     * Method to select order period.
     * @throws IOException 
     */
    public void selectOrderPeriod() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        WaitClass.sleep(1000);
        WebElement Periodelement = driver.findElement(By.xpath("//select[@name='period']"));
        Select se = new Select(Periodelement);
        se.selectByVisibleText(sp.ExcelRead().get(14));

    }

    private WebElement selectOrderType;
    /**
     * Method to select order type.
     * @throws IOException 
     */
    public void selectOrderType() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        WaitClass.sleep(1000);
        WebElement OrderTypeelement = driver.findElement(By.xpath("//select[@name='billingTypeId']"));
        Select se = new Select(OrderTypeelement);
        se.selectByVisibleText(sp.ExcelRead().get(15));

    }
    
  
    @FindBy(how=How.XPATH, using="//*[@id='ui-id-8']")
    private WebElement clickProductsSubTab;
    /**
     * Method to click on products sub tab.
     * @throws IOException 
     */
    public void clickProductsSubTab() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("click on products sub tab.");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickProductsSubTab);
        Assert.assertTrue(clickProductsSubTab.isDisplayed());
        clickProductsSubTab.click();
        
    }
    
  
    private WebElement selectProductsSubTab;
    /**
     * Method to select a products sub tab.
     * @throws IOException 
     */
    public void selectProductsSubTab() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("select a products sub tab.");
        WaitClass.sleep(2000);
        String ProductName=sp.ExcelRead().get(16);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+ProductName+"']")).click();
        
    }
    
    private WebElement verifyWarningMsg;
    /**
     * Method to verify warning message.
     * @throws IOException 
     */
    public void verifyWarningMsg() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("verify warning message.");
        WaitClass.sleep(2000);
        String ExpectedMsg = sp.ExcelRead().get(17);
        String ActualMsg = driver.findElement(By.xpath("//*[@id='messages']/div/ul/li")).getText();
        Assert.assertEquals(ActualMsg, ExpectedMsg);
        
    }
    
  
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Dependency']")
    private WebElement clickDependencyButton;
    /**
     * Method to click on dependency button.
     * @throws IOException 
     */
    public void clickDependencyButton() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("click on dependency button.");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickDependencyButton);
        Assert.assertTrue(clickDependencyButton.isDisplayed());
        clickDependencyButton.click();
        
    }
  
    //@FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Local Minutes']")
    private WebElement clickDependentProduct;
    /**
     * Method to click on dependent product.
     * @throws IOException 
     */
    public void clickDependentProduct() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("click on dependenct product.");
        WaitClass.sleep(2000);
        String DependentProduct = sp.ExcelRead().get(18);
        driver.findElement(By.xpath("//a[not(@href)]/strong[text()='"+DependentProduct+"']")).click();
    }
    
  
    @FindBy(how=How.XPATH, using="//button[@id='currentOrder']//*[text()='Current order']")
    private WebElement clickCurrentOrderButton;
    /**
     * Method to click on Current Order button.
     * @throws IOException 
     */
    public void clickCurrentOrderButton() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("click on Current Order button.");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickCurrentOrderButton);
        Assert.assertTrue(clickCurrentOrderButton.isDisplayed());
        clickCurrentOrderButton.click();
        
    } 
    
  
    @FindBy(how=How.XPATH, using="//a[3]//following::span[text()='Update']")
    private WebElement clickUpdateButton;
    /**
     * Method to click on Update button.
     * @throws IOException 
     */
    public void clickUpdateButton() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("click on Update button.");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickUpdateButton);
        Assert.assertTrue(clickUpdateButton.isDisplayed());
        clickUpdateButton.click();
        
    }
    
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        WaitClass.sleep(2000);
    }


}

