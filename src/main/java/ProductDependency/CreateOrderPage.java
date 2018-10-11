package ProductDependency;

import baseClassPackage.BasePage;
import orderHierarchies.OrderHierarchiesPage;
import productHistorical.AddCustomerPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import utilPackages.JavaScriptExec;
import utilPackages.PropertyValExtractors;
import utilPackages.WaitClass;

import org.openqa.selenium.support.ui.Select;

public class CreateOrderPage extends BasePage {
	
	public CreateOrderPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(CreateOrderPage.class);

	PropertyValExtractors p = new PropertyValExtractors();
	Actions actions = new Actions(driver);
	String sheetName = "CreateOrder";
	String xlsxName = "/ProductDependency_TestData.xlsx";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws Exception
	 */
	public void enterLoginID() throws Exception {
		CreateOrderPage sp = new CreateOrderPage(driver);

		log.info("Verifying the Login ID is available or not");
		Assert.assertTrue(enterLoginID.isDisplayed());
		enterLoginID.sendKeys(BasePage.getCellData(xlsxName, sheetName, 0, 0));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='j_password']")
	private WebElement enterPassword;

	/**
	 * Method to enter Password.
	 * 
	 * @throws Exception
	 */
	public void enterPassword() throws Exception {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("Verifying the First Name is available or not");
		Assert.assertTrue(enterPassword.isDisplayed());
		enterPassword.sendKeys(BasePage.getCellData(xlsxName, sheetName, 1, 0));

	}

	private WebElement selectCompany;

	/**
	 * Method to select Company.
	 * 
	 * @throws IOException
	 */
	public void selectCompany() throws Exception {
		CreateOrderPage sp = new CreateOrderPage(driver);
		WebElement Companyelement = driver.findElement(By.xpath("//select[@name='j_client_id']"));
		Select se = new Select(Companyelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 2, 0));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']")
	private WebElement clickLoginButton;

	/**
	 * Method to Click on Save Changes Button
	 */
	public void clickLoginButton() {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("Verifying the login button is available or not");
		Assert.assertTrue(clickLoginButton.isDisplayed());
		clickLoginButton.click();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu.link.customers']/a")
	private WebElement clickCustomerTab;

	/**
	 * Method to click on Customer tab after successful login.
	 * 
	 * @throws IOException
	 */
	public void clickCustomerTab() throws IOException {
		log.info("Click on Products Tab after successful login");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickCustomerTab.isDisplayed());
		clickCustomerTab.click();
	}
	
	 // @FindBy(how=How.XPATH, using="//a[@class='cell double']")
    private WebElement selectCustomer;
    /**
     * Method to select customer.
     * @throws IOException 
     */
    public void selectCustomer() throws IOException{
    	CreateOrderPage sp=new CreateOrderPage(driver);
    	JavaScriptExec.sleep();
    	String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, 0);
		WebElement selectCustomer = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']"));
		navigateBottom();
		actions.moveToElement(selectCustomer).click().perform();
		JavaScriptExec.sleep();
      
    }

	public void clickCreateOrder() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		WebElement clickCreateOrderButton = driver
				.findElement(By.xpath("//a[@class='submit order']//*[text()='Create Order']"));
		JavaScriptExec.scrollToElementOnPage(driver, clickCreateOrderButton);
		Assert.assertTrue(clickCreateOrderButton.isDisplayed());
		clickCreateOrderButton.click();
		JavaScriptExec.sleep();
	}
	
	private WebElement selectPeriod;
    /**
     * Method to select Period.
     * @throws IOException 
     */
    public void selectPeriod() throws IOException{
    	CreateOrderPage sp=new CreateOrderPage(driver);
        WebElement Periodelement = driver.findElement(By.xpath("//select[@name='period']"));
        Select se = new Select(Periodelement);
        se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 4, 0));

    }

    private WebElement selectOrderType;
    /**
     * Method to select Order Type.
     * @throws IOException 
     */
    public void selectOrderType() throws IOException{
    	CreateOrderPage sp=new CreateOrderPage(driver);
        WebElement OrderTypeelement = driver.findElement(By.xpath("//select[@name='billingTypeId']"));
        Select se = new Select(OrderTypeelement);
        se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 5, 0));

    }
    
    @FindBy(how=How.XPATH, using="//*[@id='ui-id-8']")
    private WebElement clickProductsSubTab;
    /**
     * Method to Click Products tab.
     * @throws IOException 
     */
    public void clickProductsSubTab() throws IOException{
    	CreateOrderPage sp=new CreateOrderPage(driver);
        log.info("Click Products Tab");
        Assert.assertTrue(clickProductsSubTab.isDisplayed());
        clickProductsSubTab.click();
        JavaScriptExec.sleep();
    }
    
    public void selectCategory() {
		WebElement categoryElement = driver.findElement(By.xpath("//select[@name='typeId']"));
		Select se1 = new Select(categoryElement);
		se1.selectByVisibleText("Dependent Category");
	}
    
    private WebElement selectProduct;
    /**
     * Method to select customer.
     * @throws IOException 
     */
    public void selectProduct() throws IOException{
    	CreateOrderPage sp=new CreateOrderPage(driver);
    	JavaScriptExec.sleep();
    	String ProductName = BasePage.getCellData(xlsxName, sheetName, 6, 0);
		WebElement selectProduct = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']"));
		navigateBottom();
		actions.moveToElement(selectProduct).click().perform();
		JavaScriptExec.sleep();
    }
    
    @FindBy(how = How.XPATH, using = "//*[@id='change--3-update-form']/div[2]/a[3]/span")
  
	private WebElement clickPlusdependency;

	/**
	 * Method to click on Products tab after successful login.
	 * 
	 * @throws IOException
	 */
	public void clickPlusdependency() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("Click on plusDependency");
		Assert.assertTrue(clickCustomerTab.isDisplayed());
		clickPlusdependency.click();
		JavaScriptExec.sleep();
	}
	
	// @FindBy(how=How.XPATH, using="//*[@id="dependencies-products-change_-3"]/tbody/tr[3]/td[1]/a/strong
		private WebElement clickDependentProduct;

		/**
		 * Method to click on dependent product.
		 * 
		 * @throws IOException
		 */
		public void clickDependentProduct() throws IOException {
			CreateOrderPage sp = new CreateOrderPage(driver);
			log.info("click on dependenct product.");
			String DependentProduct = BasePage.getCellData(xlsxName, sheetName, 7, 0);
			driver.findElement(By.xpath("//a[not(@href)]/strong[text()='" + DependentProduct + "']")).click();
		}
		
	
		
	@FindBy(how = How.XPATH, using = "//button[@id='currentOrder']")
	private WebElement clickCurrentOrderButton;

	/**
	 * Method to click on Current Order button.
	 * 
	 * @throws IOException
	 */
	public void clickCurrentOrderButton() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("click on Current Order button.");
		Assert.assertTrue(clickCurrentOrderButton.isDisplayed());
		clickCurrentOrderButton.click();
		JavaScriptExec.sleep();
	}
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='change--5.quantityAsDecimal']']")
	//*[@id="change--5.quantityAsDecimal"]
	private WebElement enterQuantity;

	/**
	 * Method to Enter Product Code.
	 * 
	 * @throws IOException
	 */
	public void enterQuantity() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("Enter Product Code");
		Assert.assertTrue(enterQuantity.isDisplayed());
		enterQuantity.sendKeys(BasePage.getCellData(xlsxName, sheetName, 8, 0));

	}
	
	@FindBy(how = How.XPATH, using = "//a//following::span[text()='Update'][2]")
	private WebElement clickUpdateButton;

	/**
	 * Method to click on Update button.
	 * 
	 * @throws IOException
	 */
	public void clickUpdateButton() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("click on Update button.");
		Assert.assertTrue(clickUpdateButton.isDisplayed());
		clickUpdateButton.click();
		JavaScriptExec.sleep();

	}
	
	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickSaveChangesButton() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("Click on Save Changes Button");
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		clickSaveChangesButton.click();

	}

	@FindBy(how = How.XPATH, using = "//div[@class='msg-box successfully']//*[text()='Done']")
	private WebElement verifyConfirmationMsg;

	/**
	 * Method to verify Account Type is created Successfully.
	 * 
	 * @throws IOException
	 */
	public void verifyConfirmationMsg() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("Verifying if Account Type is created Successfully or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyConfirmationMsg.isDisplayed(),
				"Assert Failed as its unable to search text in Logged in Page");
	}
	
	
	
	// @FindBy(how=How.XPATH, using="//a[@class='cell double']")
    private WebElement selectCustomer1;
    /**
     * Method to select customer.
     * @throws IOException 
     */
    public void selectCustomer1() throws IOException{
    	CreateOrderPage sp=new CreateOrderPage(driver);
    	JavaScriptExec.sleep();
    	String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, 1);
		WebElement selectCustomer = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']"));
		navigateBottom();
		actions.moveToElement(selectCustomer).click().perform();
		JavaScriptExec.sleep();
    }
    private WebElement selectProduct1;
    /**
     * Method to select customer.
     * @throws IOException 
     */
    public void selectProduct1() throws IOException{
    	CreateOrderPage sp=new CreateOrderPage(driver);
    	JavaScriptExec.sleep();
    	String ProductName = BasePage.getCellData(xlsxName, sheetName, 6, 1);
		WebElement selectProduct = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']"));
		navigateBottom();
		actions.moveToElement(selectProduct).click().perform();
		JavaScriptExec.sleep();
    }
	
 // @FindBy(how=How.XPATH, using="//*[@id="dependencies-products-change_-3"]/tbody/tr[3]/td[1]/a/strong
 		private WebElement clickDependentProduct1;

 		/**
 		 * Method to click on dependent product.
 		 * 
 		 * @throws IOException
 		 */
 		public void clickDependentProduct1() throws IOException {
 			CreateOrderPage sp = new CreateOrderPage(driver);
 			log.info("click on dependenct product.");
 			String DependentProduct = BasePage.getCellData(xlsxName, sheetName, 7, 1);
 			driver.findElement(By.xpath("//a[not(@href)]/strong[text()='" + DependentProduct + "']")).click();
 		}
 		
 		@FindBy(how = How.XPATH, using = "//button[@id='newSubOrder']")
 		//*[@id="newSubOrder"]
 		private WebElement clickAddSubOrderButton;

 		/**
 		 * Method to click on Current Order button.
 		 * 
 		 * @throws IOException
 		 */
 		public void clickAddSubOrderButton() throws IOException {
 			CreateOrderPage sp = new CreateOrderPage(driver);
 			log.info("click on Current Order button.");
 			Assert.assertTrue(clickCurrentOrderButton.isDisplayed());
 			clickCurrentOrderButton.click();
 			JavaScriptExec.sleep();
 		}
 	// @FindBy(how=How.XPATH, using="//a[@class='cell double']")
 	    private WebElement selectCustomer2;
 	    /**
 	     * Method to select customer.
 	     * @throws IOException 
 	     */
 	    public void selectCustomer2() throws IOException{
 	    	CreateOrderPage sp=new CreateOrderPage(driver);
 	    	JavaScriptExec.sleep();
 	    	String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, 2);
 			WebElement selectCustomer = driver
 					.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']"));
 			navigateBottom();
 			actions.moveToElement(selectCustomer).click().perform();
 			JavaScriptExec.sleep();
 	    }
 	    
 	   private WebElement selectProduct2;
 	    /**
 	     * Method to select customer.
 	     * @throws IOException 
 	     */
 	    public void selectProduct2() throws IOException{
 	    	CreateOrderPage sp=new CreateOrderPage(driver);
 	    	JavaScriptExec.sleep();
 	    	String ProductName = BasePage.getCellData(xlsxName, sheetName, 6, 2);
 			WebElement selectProduct = driver
 					.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']"));
 			navigateBottom();
 			actions.moveToElement(selectProduct).click().perform();
 			JavaScriptExec.sleep();
 	    }
 	    
 	   // @FindBy(how=How.XPATH, using="//*[@id="dependencies-products-change_-3"]/tbody/tr[3]/td[1]/a/strong
 		private WebElement clickDependentProduct2;

 		/**
 		 * Method to click on dependent product.
 		 * 
 		 * @throws IOException
 		 */
 		public void clickDependentProduct2() throws IOException {
 			CreateOrderPage sp = new CreateOrderPage(driver);
 			log.info("click on dependenct product.");
 			String DependentProduct = BasePage.getCellData(xlsxName, sheetName, 7, 2);
 			driver.findElement(By.xpath("//a[not(@href)]/strong[text()='" + DependentProduct + "']")).click();
 		}
 		
 		@FindBy(how=How.XPATH, using="//*[@id='ui-id-6']")
 		//*[@id="ui-id-6"]
 	    private WebElement clickDetailsTab;
 	    /**
 	     * Method to Click Products tab.
 	     * @throws IOException 
 	     */
 	    public void clickDetailsTab() throws IOException{
 	    	CreateOrderPage sp=new CreateOrderPage(driver);
 	        log.info("Click Details Tab");
 	        Assert.assertTrue(clickDetailsTab.isDisplayed());
 	        clickProductsSubTab.click();
 	        JavaScriptExec.sleep();
 	    }
 	    
 	// @FindBy(how=How.XPATH, using="//*[@id="dependencies-products-change_-3"]/tbody/tr[3]/td[1]/a/strong
 	 		private WebElement clickDependentProduct3;

 	 		/**
 	 		 * Method to click on dependent product.
 	 		 * 
 	 		 * @throws IOException
 	 		 */
 	 		public void clickDependentProduct3() throws IOException {
 	 			CreateOrderPage sp = new CreateOrderPage(driver);
 	 			log.info("click on dependenct product.");
 	 			String DependentProduct = BasePage.getCellData(xlsxName, sheetName, 7, 3);
 	 			driver.findElement(By.xpath("//a[not(@href)]/strong[text()='" + DependentProduct + "']")).click();
 	 		}
	
	public void addCompanyFilter() throws IOException {
		WebElement addFilter = driver.findElement(By.xpath("//a[@class='submit add open']"));
		addFilter.click();
		navigateBottom();
		String CompanyName = BasePage.getCellData(xlsxName, sheetName, 2, 0);
		WebElement selectCompany = driver.findElement(By.xpath("//*[@id=\"filters\"]/div[2]/div[1]/div/ul/li[3]/a"));
		selectCompany.click();
		JavaScriptExec.sleep();
		WebElement company = driver
				.findElement(By.xpath("//select[@name='filters.CUSTOMER-EQ_U_company_id.integerValue']"));
		Select se = new Select(company);
		se.selectByVisibleText(CompanyName);
		JavaScriptExec.sleep();
		WebElement applyFilter = driver.findElement(By.xpath("//*[@class='submit apply']//*[text()='Apply Filters']"));
		applyFilter.click();
		JavaScriptExec.sleep();
	}
	
	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();

}
}
