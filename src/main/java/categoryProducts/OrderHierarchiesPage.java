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
     * Method to select Comapny.
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

    @FindBy(how=How.XPATH, using="//*[@id='navList']/li[10]/a/span")
    private WebElement clickProductsTab;
    /**
     * Method to click on Products tab after successful login.
     * @throws IOException 
     */
    public void clickProductsTab() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("Click on Products Tab after successful login");
        WaitClass.sleep(10000);
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
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddCategoryButton);
        Assert.assertTrue(clickAddCategoryButton.isDisplayed());
        clickAddCategoryButton.click();
        
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
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("Enter English Description");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterEnglishDescription);
        Assert.assertTrue(enterEnglishDescription.isDisplayed());
        enterEnglishDescription.sendKeys(sp.ExcelRead().get(3));
        
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
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterProductCode);
        Assert.assertTrue(enterProductCode.isDisplayed());
        enterProductCode.sendKeys(sp.ExcelRead().get(4));
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Dependant Product']")
    private WebElement selectProduct;
    /**
     * Method to Select Previous created product.
     * @throws IOException 
     */
    public void selectProduct() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("Select Previous created product");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, selectProduct);
        Assert.assertTrue(selectProduct.isDisplayed());
        selectProduct.click();
        
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
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterEnglishDescription1);
        Assert.assertTrue(enterEnglishDescription1.isDisplayed());
        enterEnglishDescription1.sendKeys(sp.ExcelRead().get(5));
        
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
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterProductCode1);
        Assert.assertTrue(enterProductCode1.isDisplayed());
        enterProductCode1.sendKeys(sp.ExcelRead().get(6));
        
    }
    private WebElement selectCompanies;
    /**
     * Method to select companies.
     * @throws IOException 
     */
    public void selectCompanies() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        WebElement Companieselement = driver.findElement(By.xpath("//select[@name='product.entities']"));
        Select se = new Select(Companieselement);
        se.selectByVisibleText(sp.ExcelRead().get(7));

    }

    @FindBy(how=How.XPATH, using="//input[@name='product.number']")
    private WebElement enterPriceDate;
    /**
     * Method to enter price date.
     * @throws IOException 
     */
    public void enterPriceDate() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("enter price date");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterPriceDate);
        Assert.assertTrue(enterPriceDate.isDisplayed());
        enterPriceDate.sendKeys(sp.ExcelRead().get(8));;
        
    }
    
    private WebElement selectPriceCompany;
    /**
     * Method to select company in Prices.
     * @throws IOException 
     */
    public void selectPriceCompany() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        WebElement Companieselement = driver.findElement(By.xpath("//select[@name='product.entity']"));
        Select se = new Select(Companieselement);
        se.selectByVisibleText(sp.ExcelRead().get(9));

    }
    
    private WebElement selectPriceCurrency;
    /**
     * Method to select price currency.
     * @throws IOException 
     */
    public void selectPriceCurrency() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        WebElement Currencyelement = driver.findElement(By.xpath("//select[@name='product.currencies']"));
        Select se = new Select(Currencyelement);
        se.selectByVisibleText(sp.ExcelRead().get(10));

    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.rate']")
    private WebElement enterPriceRate;
    /**
     * Method to Enter Price Rate.
     * @throws IOException 
     */
    public void enterPriceRate() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("Enter Price Rate");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterPriceRate);
        Assert.assertTrue(enterPriceRate.isDisplayed());
        enterPriceRate.sendKeys(sp.ExcelRead().get(11));;
        
    }
    
    
    @FindBy(how=How.XPATH, using="//input[@name='product.number']")
    private WebElement enterPriceDate1;
    /**
     * Method to Uncheck Standard Availability Checkbox.
     * @throws IOException 
     */
    public void enterPriceDate1() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("Uncheck Standard Availability Checkbox");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterPriceDate1);
        Assert.assertTrue(enterPriceDate1.isDisplayed());
        enterPriceDate1.sendKeys(sp.ExcelRead().get(12));;
        
    }
    
    private WebElement selectPriceCompany1;
    /**
     * Method to select company in Prices.
     * @throws IOException 
     */
    public void selectPriceCompany1() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        WebElement Companieselement = driver.findElement(By.xpath("//select[@name='product.entity']"));
        Select se = new Select(Companieselement);
        se.selectByVisibleText(sp.ExcelRead().get(13));

    }
    
    private WebElement selectPriceCurrency1;
    /**
     * Method to select price currency.
     * @throws IOException 
     */
    public void selectPriceCurrency1() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        WebElement Currencyelement = driver.findElement(By.xpath("//select[@name='product.currencies']"));
        Select se = new Select(Currencyelement);
        se.selectByVisibleText(sp.ExcelRead().get(14));

    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.rate']")
    private WebElement enterPriceRate1;
    /**
     * Method to Enter Price Rate.
     * @throws IOException 
     */
    public void enterPriceRate1() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("Enter Price Rate");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterPriceRate1);
        Assert.assertTrue(enterPriceRate1.isDisplayed());
        enterPriceRate1.sendKeys(sp.ExcelRead().get(15));;
        
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
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddPriceButton);
        Assert.assertTrue(clickAddPriceButton.isDisplayed());
        clickAddPriceButton.click();
        
    }
    
    
    @FindBy(how=How.XPATH, using="//input[@name='product.descriptions[0].content']")
    private WebElement enterEnglishDescription2;
    /**
     * Method to Enter English Description.
     * @throws IOException 
     */
    public void enterEnglishDescription2() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("Enter English Description");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterEnglishDescription2);
        Assert.assertTrue(enterEnglishDescription2.isDisplayed());
        enterEnglishDescription2.sendKeys(sp.ExcelRead().get(16));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.number']")
    private WebElement enterProductCode2;
    /**
     * Method to Enter Product Code.
     * @throws IOException 
     */
    public void enterProductCode2() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("Enter Product Code");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterProductCode2);
        Assert.assertTrue(enterProductCode2.isDisplayed());
        enterProductCode2.sendKeys(sp.ExcelRead().get(17));
        
    }
    
    @FindBy(how=How.XPATH, using="//*[@id='dependency']/div[1]/a/span")
    private WebElement clickDependenciesIcon;
    /**
     * Method to Click Dependencies Plus Icon.
     * @throws IOException 
     */
    public void clickDependenciesIcon() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("Click Dependencies Plus Icon");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickDependenciesIcon);
        Assert.assertTrue(clickDependenciesIcon.isDisplayed());
        clickDependenciesIcon.click();
        
    }
    
    private WebElement selectProductCategory;
    /**
     * Method to select product category.
     * @throws IOException 
     */
    public void selectProductCategory() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        WebElement PCelement = driver.findElement(By.xpath("//select[@name='product.dependencyItemTypes']"));
        Select se = new Select(PCelement);
        se.selectByVisibleText(sp.ExcelRead().get(18));

    }

    private WebElement selectProductDropdown;
    /**
     * Method to select product .
     * @throws IOException 
     */
    public void selectProductDropdown() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        WebElement Productelement = driver.findElement(By.xpath("//select[@name='product.dependencyItems']"));
        Select se = new Select(Productelement);
        se.selectByVisibleText(sp.ExcelRead().get(19));

    }
    
    private WebElement selectPeriod;
    /**
     * Method to select period .
     * @throws IOException 
     */
    public void selectPeriod() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        WebElement Periodelement = driver.findElement(By.xpath("//select[@name='period']"));
        Select se = new Select(Periodelement);
        se.selectByVisibleText(sp.ExcelRead().get(20));

    }
    
    @FindBy(how=How.XPATH, using="//*[@id='dependency']/div[2]/div/table/tbody/tr/td[6]/a/img")
    private WebElement clickAddDependencyPlus;
    /**
     * Method to Click add dependency plus icon.
     * @throws IOException 
     */
    public void clickAddDependencyPlus() throws IOException{
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("Click Dependencies Plus Icon");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddDependencyPlus);
        Assert.assertTrue(clickAddDependencyPlus.isDisplayed());
        clickAddDependencyPlus.click();
        
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
    	OrderHierarchiesPage sp=new OrderHierarchiesPage(driver);
        log.info("Verifying if Account Type is created Successfully or not");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyConfirmationMsg);
        Assert.assertTrue(verifyConfirmationMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
    
    
    
    
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        WaitClass.sleep(5000);
    }


}

