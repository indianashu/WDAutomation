package productHistorical;

import baseClassPackage.BasePage;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utilPackages.JavaScriptExec;
import utilPackages.PropertyValExtractors;
import org.openqa.selenium.support.ui.Select;

public class AddProduct4Page extends BasePage {
	
	public AddProduct4Page(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(AddProduct4Page.class);
	AddProduct4Page AddProductCategoryPage;
	PropertyValExtractors p = new PropertyValExtractors();
	Actions actions = new Actions(driver);
	String sheetName = "AddProductCategory1";
	String xlsxName = "/ProductHistorical_TestData.xlsx";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * @throws Exception 
	 */
	public void enterLoginID() throws Exception {
		AddProduct4Page sp = new AddProduct4Page(driver);

		log.info("Verifying the Login ID is available or not");
		Assert.assertTrue(enterLoginID.isDisplayed());
		enterLoginID.sendKeys(BasePage.getCellData(xlsxName,sheetName,0,0));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='j_password']")
	private WebElement enterPassword;

	/**
	 * Method to enter Password.
	 * @throws Exception 
	 */
	public void enterPassword() throws Exception {
		AddProduct4Page sp = new AddProduct4Page(driver);
		log.info("Verifying the First Name is available or not");
		Assert.assertTrue(enterPassword.isDisplayed());
		enterPassword.sendKeys(BasePage.getCellData(xlsxName,sheetName,1,0));

	}

	private WebElement selectCompany;

	/**
	 * Method to select Company.
	 * 
	 * @throws IOException
	 */
	public void selectCompany() throws Exception {
		AddProduct4Page sp = new AddProduct4Page(driver);
		WebElement Companyelement = driver.findElement(By.xpath("//select[@name='j_client_id']"));
		Select se = new Select(Companyelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName,sheetName,2,0));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']")
	private WebElement clickLoginButton;

	/**
	 * Method to Click on Save Changes Button
	 */
	public void clickLoginButton() {
		AddProduct4Page sp = new AddProduct4Page(driver);
		log.info("Verifying the login button is available or not");
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
    	AddProduct4Page sp=new AddProduct4Page(driver);
        log.info("Click on Products Tab after successful login");
        JavaScriptExec.sleep();
        Assert.assertTrue(clickProductsTab.isDisplayed());
        clickProductsTab.click();
        
    }
    
    /**
	 * Method to click on a category name.
	 * 
	 * @throws IOException
	 */
	public void selectCategoryName() throws IOException {
		String CategoryName = BasePage.getCellData(xlsxName, sheetName, 3, 0);
		WebElement selectCategoryName = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CategoryName + "']"));
		actions.moveToElement(selectCategoryName).click(selectCategoryName).perform();
        JavaScriptExec.sleep();

	}
	
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Save Changes']")
    private WebElement clickSaveChangesButton;
    /**
     * Method to click on Save Changes Button.
     * @throws IOException 
     */
    public void clickSaveChangesButton() throws IOException{
    	AddProduct4Page sp=new AddProduct4Page(driver);
        log.info("Click on Save Changes Button");
        navigateBottom();
        Assert.assertTrue(clickSaveChangesButton.isDisplayed());
        clickSaveChangesButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add Product']")
    private WebElement clickAddProductButton;
    /**
     * Method to click on Add Product Button".
     * @throws IOException 
     */
    public void clickAddProductButton() throws IOException{
        log.info("Click on Add Product Button");
        Assert.assertTrue(clickAddProductButton.isDisplayed());
        clickAddProductButton.click();
        JavaScriptExec.sleep();
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.descriptions[0].content']")
    private WebElement enterEnglishDescription;
    /**
     * Method to Enter English Description.
     * @throws IOException 
     */
    public void enterEnglishDescription() throws IOException{
    	AddProduct4Page sp=new AddProduct4Page(driver);
        log.info("Enter English Description");
        Assert.assertTrue(enterEnglishDescription.isDisplayed());
		enterEnglishDescription.sendKeys(BasePage.getCellData(xlsxName, sheetName, 5, 3));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='product.number']")
    private WebElement enterProductCode;
    /**
     * Method to Enter Product Code.
     * @throws IOException 
     */
    public void enterProductCode() throws IOException{
    	AddProduct4Page sp=new AddProduct4Page(driver);
        log.info("Enter Product Code");
        Assert.assertTrue(enterProductCode.isDisplayed());
        enterProductCode.sendKeys(BasePage.getCellData(xlsxName,sheetName,5,3));
        
    }
    
    private WebElement selectProductCompany1;
    /**
     * Method to select companies.
     * @throws IOException 
     */
    public void selectProductCompany1() throws IOException{
    	AddProduct4Page sp=new AddProduct4Page(driver);
        WebElement Companyelement = driver.findElement(By.xpath("//select[@name='product.entities']"));
        Select se = new Select(Companyelement);
        se.selectByVisibleText(BasePage.getCellData(xlsxName,sheetName,2,0));

    }
    
    private WebElement selectProductCompany2;
    /**
     * Method to select companies.
     * @throws IOException 
     */
    public void selectProductCompany2() throws IOException{
    	AddProduct4Page sp=new AddProduct4Page(driver);
        WebElement Companyelement = driver.findElement(By.xpath("//select[@name='product.entities']"));
        Select se = new Select(Companyelement);
        se.selectByVisibleText(BasePage.getCellData(xlsxName,sheetName,4,0));
        navigateBottom();

    }
    
    public void selectHistoricalPrices() throws IOException{
    	AddProduct4Page sp=new AddProduct4Page(driver);
    	for (int i= 0; i <= 8; i++ ) {
    			WebElement enterPastPriceDate = driver.findElement(By.xpath("//*[@name=\"mydate\"]"));
    			Assert.assertTrue(enterPastPriceDate.isDisplayed());
    	        enterPastPriceDate.clear();
    	        enterPastPriceDate.sendKeys(BasePage.getCellData(xlsxName,sheetName,6,i));
    	        JavaScriptExec.sleep();
    	        
    	        WebElement Currencyelement = driver.findElement(By.xpath("//select[@name='product.currencies']"));
    	        Select se = new Select(Currencyelement);
    	        se.selectByVisibleText(BasePage.getCellData(xlsxName,sheetName,7,i));
    	        JavaScriptExec.sleep();
    	        
    	        WebElement enterPriceRatePastUSD = driver.findElement(By.xpath("//input[@name='product.rate']"));
    	        Assert.assertTrue(enterPriceRatePastUSD.isDisplayed());
    	        enterPriceRatePastUSD.clear();
    	        enterPriceRatePastUSD.sendKeys(BasePage.getCellData(xlsxName,sheetName,12,i));
    	        JavaScriptExec.sleep();
    	        
    	        WebElement clickAddPriceButton = driver.findElement(By.xpath("//a[@class='submit add']//*[text()='Add Price']"));
    	        Assert.assertTrue(clickAddPriceButton.isDisplayed());
    	        clickAddPriceButton.click();
    	            
    	}
    	
    }
    
    public void selectHistoricalPrices1() throws IOException{
    	AddProduct4Page sp=new AddProduct4Page(driver);
    	for (int i= 0; i <= 8; i++ ) {
    			WebElement enterPastPriceDate = driver.findElement(By.xpath("//*[@name=\"mydate\"]"));
    			Assert.assertTrue(enterPastPriceDate.isDisplayed());
    	        enterPastPriceDate.clear();
    	        enterPastPriceDate.sendKeys(BasePage.getCellData(xlsxName,sheetName,6,i));
    	        JavaScriptExec.sleep();
    	        
    	        WebElement Companieselement = driver.findElement(By.xpath("//select[@name='product.entity']"));
    	        Select se = new Select(Companieselement);
    	        se.selectByVisibleText(BasePage.getCellData(xlsxName,sheetName,4,0));
    	        JavaScriptExec.sleep();
    	        
    	        WebElement Currencyelement = driver.findElement(By.xpath("//select[@name='product.currencies']"));
    	        Select sel = new Select(Currencyelement);
    	        sel.selectByVisibleText(BasePage.getCellData(xlsxName,sheetName,7,i));
    	        JavaScriptExec.sleep();
    	        
    	        WebElement enterPriceRatePastUSD = driver.findElement(By.xpath("//input[@name='product.rate']"));
    	        Assert.assertTrue(enterPriceRatePastUSD.isDisplayed());
    	        enterPriceRatePastUSD.clear();
    	        enterPriceRatePastUSD.sendKeys(BasePage.getCellData(xlsxName,sheetName,13,i));
    	        JavaScriptExec.sleep();
    	        
    	        WebElement clickAddPriceButton = driver.findElement(By.xpath("//a[@class='submit add']//*[text()='Add Price']"));
    	        Assert.assertTrue(clickAddPriceButton.isDisplayed());
    	        clickAddPriceButton.click();
    	            
    	}
    	
    }
   
    
	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}

}
