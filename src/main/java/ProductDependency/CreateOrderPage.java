package ProductDependency;

import baseClassPackage.BasePage;
import invoice.GeneratingInvoicePage;
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
	
		// @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Customer
		// A']")
		private WebElement clickCustomerName;

		/**
		 * Method to click on customer name.
		 * 
		 * @throws IOException
		 */
		public void clickCustomerName() throws IOException {
			CreateOrderPage sp = new CreateOrderPage(driver);
			log.info("Click on Customer Name.");
			JavaScriptExec.sleep();
			String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, 10);
			driver.findElement(By.xpath("//*[text()='" + CustomerName + "']/following::a[1]")).click();
		}
		
		// @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Customer
				// A']")
				private WebElement clickCustomerName1;

				/**
				 * Method to click on customer name.
				 * 
				 * @throws IOException
				 */
				public void clickCustomerName1() throws IOException {
					CreateOrderPage sp = new CreateOrderPage(driver);
					log.info("Click on Customer Name.");
					JavaScriptExec.sleep();
					String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, 8);
					driver.findElement(By.xpath("//*[text()='" + CustomerName + "']/following::a[1]")).click();
					navigateBottom();
				}
		
		// @FindBy(how=How.XPATH, using="//*[@id="18306"]/img
				// A']")
		//*[@id="18306"]/img
				private WebElement clickParentCustomerName;

				/**
				 * Method to click on customer name.
				 * 
				 * @throws IOException
				 */
				public void clickParentCustomerName() throws IOException {
					CreateOrderPage sp = new CreateOrderPage(driver);
					log.info("Click on Customer Name.");
					JavaScriptExec.sleep();
					String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, 10);
					driver.findElement(By.xpath("//*[text()='" + CustomerName + "']/following::a[1]")).click();
				}
	
	@FindBy(how = How.XPATH, using = "//*[@id='column2']/div[1]/div[7]/div[1]/a[3]/span")
	//*[@id="column2"]/div[1]/div[7]/div[1]/a[3]/span
	private WebElement clickEditthisorder;

	/**
	 * Method to click on Customer tab after successful login.
	 * 
	 * @throws IOException
	 */
	public void clickEditthisorder() throws IOException {
		log.info("Click on Edit this folder button");
		JavaScriptExec.sleep();
		navigateBottom();
		Assert.assertTrue(clickEditthisorder.isDisplayed());
		clickEditthisorder.click();
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
	    
	 //@FindBy(how=How.XPATH, using="//a[@class='cell double']")
	 private WebElement selectCustomer3;
	 	    /**
	 	     * Method to select customer.
	 	     * @throws IOException 
	 	     */
	 public void selectCustomer3() throws IOException{
	 	CreateOrderPage sp=new CreateOrderPage(driver);
	 	JavaScriptExec.sleep();
	 	String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, 5);
	 	WebElement selectCustomer = driver
	 					.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']"));
	 	navigateBottom();
	 	actions.moveToElement(selectCustomer).click().perform();
	 	JavaScriptExec.sleep();
	 	    }
	 
	 //@FindBy(how=How.XPATH, using="//a[@class='cell double']")
 	 private WebElement selectCustomer4;
 	 	 	    /**
 	 	 	     * Method to select customer.
 	 	 	     * @throws IOException 
 	 	 	     */
 	 public void selectCustomer4() throws IOException{
 	 	 CreateOrderPage sp=new CreateOrderPage(driver);
 	 	 JavaScriptExec.sleep();
 	 	 String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, 8);
 	 	 WebElement selectCustomer = driver
 	 	 					.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']"));
 	 	 navigateBottom();
 	 	 actions.moveToElement(selectCustomer).click().perform();
 	 	 JavaScriptExec.sleep();
 	 	 	  }

 	 //@FindBy(how=How.XPATH, using="//a[@class='cell double']")
 	 private WebElement selectCustomer5;
 	 	 	    /**
 	 	 	     * Method to select customer.
 	 	 	     * @throws IOException 
 	 	 	     */
 	 public void selectCustomer5() throws IOException{
 	 	 CreateOrderPage sp=new CreateOrderPage(driver);
 	 	 JavaScriptExec.sleep();
 	 	 String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, 10);
 	 	 WebElement selectCustomer = driver
 	 	 					.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']"));
 	 	 navigateBottom();
 	 	 actions.moveToElement(selectCustomer).click().perform();
 	 	 JavaScriptExec.sleep();
 	 	 	  }
 	 
 	@FindBy(how = How.XPATH, using = "//a[@class='submit order']//*[text()='Create Order']")
	private WebElement clickCreateOrder;

	/**
	 * Method to click on create order button.
	 * 
	 * @throws IOException
	 */
	public void clickCreateOrder() throws IOException {
		JavaScriptExec.scrollToElementOnPage(driver, clickCreateOrder);
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("click on create order button.");
		Assert.assertTrue(clickCreateOrder.isDisplayed());
		clickCreateOrder.click();
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
    
 	 private WebElement selectPeriod1;
 	 /**
     * Method to select Period.
     * @throws IOException 
     */
    public void selectPeriod1() throws IOException{
    	CreateOrderPage sp=new CreateOrderPage(driver);
        WebElement Periodelement = driver.findElement(By.xpath("//select[@name='period']"));
        Select se = new Select(Periodelement);
        se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 4, 2));

    }
    
    private WebElement selectPeriod2;
    /**
     * Method to select Period.
     * @throws IOException 
     */
    public void selectPeriod2() throws IOException{
    	CreateOrderPage sp=new CreateOrderPage(driver);
        WebElement Periodelement = driver.findElement(By.xpath("//select[@name='period']"));
        Select se = new Select(Periodelement);
        se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 4, 5));

    }
     
    private WebElement selectPeriod3;
    /**
     * Method to select Period.
     * @throws IOException 
     */
    public void selectPeriod3() throws IOException{
    	CreateOrderPage sp=new CreateOrderPage(driver);
        WebElement Periodelement = driver.findElement(By.xpath("//select[@name='period']"));
        Select se = new Select(Periodelement);
        se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 4, 8));

    }
    
    private WebElement selectPeriod5;
    /**
     * Method to select Period.
     * @throws IOException 
     */
    public void selectPeriod5() throws IOException{
    	CreateOrderPage sp=new CreateOrderPage(driver);
        WebElement Periodelement = driver.findElement(By.xpath("//select[@name='period']"));
        Select se = new Select(Periodelement);
        se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 4, 10));

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
    
    private WebElement selectOrderType1;
    /**
     * Method to select Order Type.
     * @throws IOException 
     */
    public void selectOrderType1() throws IOException{
    	CreateOrderPage sp=new CreateOrderPage(driver);
        WebElement OrderTypeelement = driver.findElement(By.xpath("//select[@name='billingTypeId']"));
        Select se = new Select(OrderTypeelement);
        se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 5, 2));

    }
    
    private WebElement selectOrderType2;
    /**
     * Method to select Order Type.
     * @throws IOException 
     */
    public void selectOrderType2() throws IOException{
    	CreateOrderPage sp=new CreateOrderPage(driver);
        WebElement OrderTypeelement = driver.findElement(By.xpath("//select[@name='billingTypeId']"));
        Select se = new Select(OrderTypeelement);
        se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 5, 5));

    }
    
    private WebElement selectOrderType3;
    /**
     * Method to select Order Type.
     * @throws IOException 
     */
    public void selectOrderType3() throws IOException{
    	CreateOrderPage sp=new CreateOrderPage(driver);
        WebElement OrderTypeelement = driver.findElement(By.xpath("//select[@name='billingTypeId']"));
        Select se = new Select(OrderTypeelement);
        se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 5, 8));

    }
    
    private WebElement selectOrderType5;
    /**
     * Method to select Order Type.
     * @throws IOException 
     */
    public void selectOrderType5() throws IOException{
    	CreateOrderPage sp=new CreateOrderPage(driver);
        WebElement OrderTypeelement = driver.findElement(By.xpath("//select[@name='billingTypeId']"));
        Select se = new Select(OrderTypeelement);
        se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 5, 10));

    }
    
    private WebElement selectOrderType4;

	/**
	 * Method to select Order Type.
	 * 
	 * @throws IOException
	 */
	public void selectOrderType4() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		JavaScriptExec.sleep();
		WebElement OrderTypeelement = driver.findElement(By.xpath("//select[@name='billingTypeId']"));
		Select se = new Select(OrderTypeelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 5, 9));

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
	    
	
    
	 private WebElement selectProduct3;
	    /**
	     * Method to select customer.
	     * @throws IOException 
	     */
	 public void selectProduct3() throws IOException{
	    	
	    	CreateOrderPage sp=new CreateOrderPage(driver);
	    	JavaScriptExec.sleep();
	    	String ProductName = BasePage.getCellData(xlsxName, sheetName, 6, 5);
			WebElement selectProduct = driver
					.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']"));
			navigateBottom();
			actions.moveToElement(selectProduct).click().perform();
			JavaScriptExec.sleep();
	    }
	    
	  private WebElement selectProduct4;
	    /**
	     * Method to select customer.
	     * @throws IOException 
	     */
	  public void selectProduct4() throws IOException{
	    	
	    	CreateOrderPage sp=new CreateOrderPage(driver);
	    	JavaScriptExec.sleep();
	    	String ProductName = BasePage.getCellData(xlsxName, sheetName, 6, 8);
			WebElement selectProduct = driver
					.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']"));
			navigateBottom();
			actions.moveToElement(selectProduct).click().perform();
			JavaScriptExec.sleep();
	    }
	  
	  private WebElement selectProduct5;
	    /**
	     * Method to select customer.
	     * @throws IOException 
	     */
	  public void selectProduct5() throws IOException{
	    	
	    	CreateOrderPage sp=new CreateOrderPage(driver);
	    	JavaScriptExec.sleep();
	    	String ProductName = BasePage.getCellData(xlsxName, sheetName, 6, 10);
			WebElement selectProduct = driver
					.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']"));
			navigateBottom();
			actions.moveToElement(selectProduct).click().perform();
			JavaScriptExec.sleep();
	    }
    
	  @FindBy(how = How.XPATH, using = "//*[@id='change--3-update-form']/div[2]/a[3]/span")
	  //*[@id="change--3-update-form"]/div[2]/a[3]/span
	
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
	
		@FindBy(how = How.XPATH, using = "//*[@id='edit_change_header_-3']/td[1]")
		//*[@id="edit_change_header_-3"]/td[1]
		private WebElement clickParentOrder;

		/**
		 * Method to click on Products tab after successful login.
		 * 
		 * @throws IOException
		 */
		public void clickParentOrder() throws IOException {
			
			CreateOrderPage sp = new CreateOrderPage(driver);
			log.info("Click on ParentOrder");
			Assert.assertTrue(clickParentOrder.isDisplayed());
			clickParentOrder.click();
			JavaScriptExec.sleep();
		}
		
		@FindBy(how = How.XPATH, using = "//*[@id='edit_change_header_-3']/td[1]")
		//*[@id="edit_change_header_-3"]/td[1]
		
		private WebElement clickParentOrder1;

		/**
		 * Method to click on Products tab after successful login.
		 * 
		 * @throws IOException
		 */
		public void clickParentOrder1() throws IOException {
			
			CreateOrderPage sp = new CreateOrderPage(driver);
			log.info("Click on ParentOrder");
			Assert.assertTrue(clickParentOrder1.isDisplayed());
			clickParentOrder1.click();
			JavaScriptExec.sleep();
		}
		
		@FindBy(how = How.XPATH, using = "//*[@id='edit_change_header_-3']/td[1]")
		//*[@id="edit_change_header_-3"]/td[1]
	
		
		private WebElement clickParentOrder2;

		/**
		 * Method to click on Products tab after successful login.
		 * 
		 * @throws IOException
		 */
		public void clickParentOrder2() throws IOException {
			
			CreateOrderPage sp = new CreateOrderPage(driver);
			log.info("Click on ParentOrder");
			Assert.assertTrue(clickParentOrder2.isDisplayed());
			clickParentOrder2.click();
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
		
	 // @FindBy(how=How.XPATH, using="//*[@id="dependencies-products-change_-3"]/tbody/tr[3]/td[1]/a/strong
	 private WebElement clickDependentProduct4;

	 	 		/**
	 	 		 * Method to click on dependent product.
	 	 		 * 
	 	 		 * @throws IOException
	 	 		 */
	 public void clickDependentProduct4() throws IOException {
		 
	 	 	CreateOrderPage sp = new CreateOrderPage(driver);
	 	 	log.info("click on dependenct product.");
	 	 	String DependentProduct = BasePage.getCellData(xlsxName, sheetName, 7, 4);
	 	 	driver.findElement(By.xpath("//a[not(@href)]/strong[text()='" + DependentProduct + "']")).click();
	 	 		}
	 	 		
	 // @FindBy(how=How.XPATH, using="//*[@id="dependencies-products-change_-3"]/tbody/tr[3]/td[1]/a/strong
	 private WebElement clickDependentProduct5;

	 	 		/**
	 	 		 * Method to click on dependent product.
	 	 		 * 
	 	 		 * @throws IOException
	 	 		 */
	 public void clickDependentProduct5() throws IOException {
	 	 	CreateOrderPage sp = new CreateOrderPage(driver);
	 	 	log.info("click on dependenct product.");
	 	 	String DependentProduct = BasePage.getCellData(xlsxName, sheetName, 7, 5);
	 	 	driver.findElement(By.xpath("//a[not(@href)]/strong[text()='" + DependentProduct + "']")).click();
	 	 		}
	 	 		
	 //@FindBy(how=How.XPATH, using="//*[@id="dependencies-products-change_-3"]/tbody/tr[3]/td[1]/a/strong
	//*[@id="dependencies-products-change_-3"]/tbody/tr[1]/td[1]/a/strong
	 private WebElement clickDependentProduct6;

	 	 		/**
	 	 		 * Method to click on dependent product.
	 	 		 * 
	 	 		 * @throws IOException
	 	 		 */
	 public void clickDependentProduct6() throws IOException {
	 	 	CreateOrderPage sp = new CreateOrderPage(driver);
	 	 	log.info("click on dependenct product.");
	 	 	String DependentProduct = BasePage.getCellData(xlsxName, sheetName, 7, 6);
	 	 	driver.findElement(By.xpath("//a[not(@href)]/strong[text()='" + DependentProduct + "']")).click();
	 	 		}
	 	 		
	 //@FindBy(how=How.XPATH, using="//*[@id="dependencies-products-change_-3"]/tbody/tr/td[1]/a/strong
	 private WebElement clickDependentProduct7;

	 	 		/**
	 	 		 * Method to click on dependent product.
	 	 		 * 
	 	 		 * @throws IOException
	 	 		 */
	 public void clickDependentProduct7() throws IOException {
	 	 	CreateOrderPage sp = new CreateOrderPage(driver);
	 	 	log.info("click on dependenct product.");
	 	 	String DependentProduct = BasePage.getCellData(xlsxName, sheetName, 7, 7);
	 	 	driver.findElement(By.xpath("//a[not(@href)]/strong[text()='" + DependentProduct + "']")).click();
	 	 		}
	 	 		
	 //@FindBy(how=How.XPATH, using="//*[@id="dependencies-products-change_-3"]/tbody/tr[3]/td[1]/a/strong
	 private WebElement clickDependentProduct8;

	 	 		/**
	 	 		 * Method to click on dependent product.
	 	 		 * 
	 	 		 * @throws IOException
	 	 		 */
	 public void clickDependentProduct8() throws IOException {
	 	 	CreateOrderPage sp = new CreateOrderPage(driver);
	 	 	log.info("click on dependenct product.");
	 	 	String DependentProduct = BasePage.getCellData(xlsxName, sheetName, 7, 8);
	 	 	driver.findElement(By.xpath("//a[not(@href)]/strong[text()='" + DependentProduct + "']")).click();
	 	 		}
	 
	 	
	 	
	 
	 //@FindBy(how=How.XPATH, using="//*[@id="dependencies-products-change_-3"]/tbody/tr[3]/td[1]/a/strong
	 private WebElement clickDependentProduct9;

	 	 		/**
	 	 		 * Method to click on dependent product.
	 	 		 * 
	 	 		 * @throws IOException
	 	 		 */
	 public void clickDependentProduct9() throws IOException {
	 	 	CreateOrderPage sp = new CreateOrderPage(driver);
	 	 	log.info("click on dependenct product.");
	 	 	String DependentProduct = BasePage.getCellData(xlsxName, sheetName, 7, 10);
	 	 	driver.findElement(By.xpath("//a[not(@href)]/strong[text()='" + DependentProduct + "']")).click();
	 	 		}
	 
	 //@FindBy(how=How.XPATH, using="//*[@id="dependencies-products-change_-3"]/tbody/tr[3]/td[1]/a/strong
	 	private WebElement clickDependentProduct10;

		 	 		/**
		 	 		 * Method to click on dependent product.
		 	 		 * 
		 	 		 * @throws IOException
		 	 		 */
		 public void clickDependentProduct10() throws IOException {
		 	 	CreateOrderPage sp = new CreateOrderPage(driver);
		 	 	log.info("click on dependenct product.");
		 	 	String DependentProduct = BasePage.getCellData(xlsxName, sheetName, 7, 11);
		 	 	driver.findElement(By.xpath("//a[not(@href)]/strong[text()='" + DependentProduct + "']")).click();
		 	 		}
		
	 @FindBy(how = How.XPATH, using = "//button[@id='currentOrder']")
	//*[@id="currentOrder"]
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
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='change--5.quantityAsDecimal']")
	//*[@id="change--5.quantityAsDecimal"]
	private WebElement enterQuantity;

	/**
	 * Method to Enter Price Rate.
	 * 
	 * @throws IOException
	 */
	public void enterQuantity() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("Enter Min value");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, enterQuantity);
		Assert.assertTrue(enterQuantity.isDisplayed());
		enterQuantity.clear();
		enterQuantity.sendKeys(BasePage.getCellData(xlsxName, sheetName, 8, 0));
	}
	@FindBy(how = How.XPATH, using = "//*[@id='change--6.quantityAsDecimal']")
	//*[@id="change--6.quantityAsDecimal"]
	
	private WebElement enterQuantity1;

	/**
	 * Method to Enter Price Rate.
	 * 
	 * @throws IOException
	 */
	public void enterQuantity1() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("Enter Min value");
		JavaScriptExec.sleep();
		WaitClass.WaitForElementisDisplay(driver, 10, enterQuantity1);
		Assert.assertTrue(enterQuantity1.isDisplayed());
		enterQuantity1.clear();
		enterQuantity1.sendKeys(BasePage.getCellData(xlsxName, sheetName, 8, 1));
	}
	
	 @FindBy(how = How.XPATH, using = "//*[@id='change--6.quantityAsDecimal']")
	 //*[@id="change--6.quantityAsDecimal"]
	  private WebElement enterQuantity2;

	 		/**
	 		 * Method to Enter Price Rate.
	 		 * 
	 		 * @throws IOException
	 		 */
	 public void enterQuantity2() throws IOException {
		 
		CreateOrderPage sp = new CreateOrderPage(driver);
	 	log.info("Enter Quantity");
	 	JavaScriptExec.sleep();
	 	WaitClass.WaitForElementisDisplay(driver, 10, enterQuantity2);
	 	Assert.assertTrue(enterQuantity1.isDisplayed());
	 	enterQuantity2.clear();
	 	enterQuantity2.sendKeys(BasePage.getCellData(xlsxName, sheetName, 8, 2));
	 		
	 }
	 
	 	@FindBy(how = How.XPATH, using = "//*[@id='change--6.quantityAsDecimal']")
	 	//*[@id="change--6.quantityAsDecimal"]
	 	private WebElement enterQuantity3;
	 		/**
	 		 * Method to Enter Price Rate.
	 		 * 
	 		 * @throws IOException
	 		 */
	 	public void enterQuantity3() throws IOException {
	 		
	 	CreateOrderPage sp = new CreateOrderPage(driver);
	 	log.info("Enter Quantity");
	 	JavaScriptExec.sleep();
	 	WaitClass.WaitForElementisDisplay(driver, 10, enterQuantity2);
	 	Assert.assertTrue(enterQuantity1.isDisplayed());
	 	enterQuantity2.clear();
	 	enterQuantity2.sendKeys(BasePage.getCellData(xlsxName, sheetName, 8, 3));
	 		}
	 	
	 	@FindBy(how = How.XPATH, using = "//*[@id='change--6.quantityAsDecimal']")
 	 	//*[@id="change--6.quantityAsDecimal"]
 	 	private WebElement enterQuantity4;

 	 		/**
 	 		 * Method to Enter Price Rate.
 	 		 * 
 	 		 * @throws IOException
 	 		 */
 	 	public void enterQuantity4() throws IOException {
 	 		
 	 		CreateOrderPage sp = new CreateOrderPage(driver);
 	 		log.info("Enter Quantity");
 	 		JavaScriptExec.sleep();
 	 		WaitClass.WaitForElementisDisplay(driver, 10, enterQuantity2);
 	 		Assert.assertTrue(enterQuantity1.isDisplayed());
 	 		enterQuantity4.clear();
 	 		enterQuantity4.sendKeys(BasePage.getCellData(xlsxName, sheetName, 8, 4));
 	 		}
 	 	
 	 	@FindBy(how = How.XPATH, using = "//*[@id='change--6.quantityAsDecimal']")
 	 	//*[@id="change--6.quantityAsDecimal"]
 	
 	 	private WebElement enterQuantity5;

 	 		/**
 	 		 * Method to Enter Price Rate.
 	 		 * 
 	 		 * @throws IOException
 	 		 */
 	 	public void enterQuantity5() throws IOException {
 	 		CreateOrderPage sp = new CreateOrderPage(driver);
 	 		log.info("Enter Quantity");
 	 		JavaScriptExec.sleep();
 	 		WaitClass.WaitForElementisDisplay(driver, 10, enterQuantity2);
 	 		Assert.assertTrue(enterQuantity1.isDisplayed());
 	 		enterQuantity5.clear();
 	 		enterQuantity5.sendKeys(BasePage.getCellData(xlsxName, sheetName, 9, 5));
 	 		}
 	 	
 	 	@FindBy(how = How.XPATH, using = "//*[@id='change--12.quantityAsDecimal']")
 	 	//*[@id="change--12.quantityAsDecimal"]
 	 	private WebElement enterQuantity6;

 	 		/**
 	 		 * Method to Enter Price Rate.
 	 		 * 
 	 		 * @throws IOException
 	 		 */
 	 	public void enterQuantity6() throws IOException {
 	 		CreateOrderPage sp = new CreateOrderPage(driver);
 	 		log.info("Enter Quantity");
 	 		JavaScriptExec.sleep();
 	 		WaitClass.WaitForElementisDisplay(driver, 10, enterQuantity6);
 	 		Assert.assertTrue(enterQuantity6.isDisplayed());
 	 		JavaScriptExec.sleep();
 	 		enterQuantity6.clear();
 	 		enterQuantity6.sendKeys(BasePage.getCellData(xlsxName, sheetName, 8, 7));
 	 		}
 	 	
 	 	
 	 	@FindBy(how = How.XPATH, using = "//*[@id='change--6.quantityAsDecimal']")
 	 	//*[@id="change--6.quantityAsDecimal"]
 	 	private WebElement enterQuantity8;

 	 		/**
 	 		 * Method to Enter Price Rate.
 	 		 * 
 	 		 * @throws IOException
 	 		 */
 	 	public void enterQuantity8() throws IOException {
 	 		CreateOrderPage sp = new CreateOrderPage(driver);
 	 		log.info("Enter Quantity");
 	 		JavaScriptExec.sleep();
 	 		WaitClass.WaitForElementisDisplay(driver, 10, enterQuantity8);
 	 		Assert.assertTrue(enterQuantity8.isDisplayed());
 	 		enterQuantity8.clear();
 	 		enterQuantity8.sendKeys(BasePage.getCellData(xlsxName, sheetName, 8, 7));
 	 		}
 	 	
 	 	@FindBy(how = How.XPATH, using = "//*[@id='change--6.quantityAsDecimal']")
 	 	//*[@id="change--9.quantityAsDecimal"]
 	 	private WebElement enterQuantity9;

 	 		/**
 	 		 * Method to Enter Price Rate.
 	 		 * 
 	 		 * @throws IOException
 	 		 */
 	 	public void enterQuantity9() throws IOException {
 	 		CreateOrderPage sp = new CreateOrderPage(driver);
 	 		log.info("Enter Quantity");
 	 		JavaScriptExec.sleep();
 	 		WaitClass.WaitForElementisDisplay(driver, 10, enterQuantity9);
 	 		Assert.assertTrue(enterQuantity9.isDisplayed());
 	 		enterQuantity9.clear();
 	 		enterQuantity9.sendKeys(BasePage.getCellData(xlsxName, sheetName, 8, 10));
 	 		}
 	 	
 	 	@FindBy(how = How.XPATH, using = "//*[@id='change--9.quantityAsDecimal']")
 	 //*[@id="change--9.quantityAsDecimal"]
 	 	private WebElement enterQuantity10;

 	 		/**
 	 		 * Method to Enter Price Rate.
 	 		 * 
 	 		 * @throws IOException
 	 		 */
 	 	public void enterQuantity10() throws IOException {
 	 		CreateOrderPage sp = new CreateOrderPage(driver);
 	 		log.info("Enter Quantity");
 	 		JavaScriptExec.sleep();
 	 		WaitClass.WaitForElementisDisplay(driver, 10, enterQuantity10);
 	 		Assert.assertTrue(enterQuantity10.isDisplayed());
 	 		enterQuantity10.clear();
 	 		enterQuantity10.sendKeys(BasePage.getCellData(xlsxName, sheetName, 8, 11));
 	 		}
 	 	
 	 	
 	 	@FindBy(how = How.XPATH, using = "//*[@id='change--5.quantityAsDecimal']")
 	 //*[@id="change--5.quantityAsDecimal"]
 	 	private WebElement enterQuantity7;
 	 		/**
 	 		 * Method to Enter Price Rate.
 	 		 * 
 	 		 * @throws IOException
 	 		 */
 	 	public void enterQuantity7() throws IOException {
 	 		CreateDependentCategoryPage sp = new CreateDependentCategoryPage(driver);
 	 		log.info("Enter Quantity");
 	 		JavaScriptExec.sleep();
 	 		WaitClass.WaitForElementisDisplay(driver, 10, enterQuantity7);
 	 		Assert.assertTrue(enterQuantity7.isDisplayed());
 	 		enterQuantity7.clear();
 	 		enterQuantity7.sendKeys(BasePage.getCellData(xlsxName, sheetName, 8, 8));
 	 		}
	
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='change--6-update-form']/div[2]/a[1]")
	//*[@id="change--6-update-form"]/div[2]/a[1]/span
	
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
	
	@FindBy(how = How.XPATH, using = "//*[@id='change--9-update-form']/div[2]/a[1]")
	//*[@id="change--9-update-form"]/div[2]/a[1]/span
	private WebElement clickUpdateButton1;

	/**
	 * Method to click on Update button.
	 * 
	 * @throws IOException
	 */
	public void clickUpdateButton1() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("click on Update button.");
		Assert.assertTrue(clickUpdateButton1.isDisplayed());
		clickUpdateButton1.click();
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
		JavaScriptExec.sleep();
		clickSaveChangesButton.click();

	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='order-18257']/td[1]")
	//*[@id="order-18257"]/td[1]
	//*[@id="18258"]/span
	private WebElement clickOrder;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickOrder() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("Click on Save Changes Button");
		Assert.assertTrue(clickOrder.isDisplayed());
		clickOrder.click();

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit order']//*[text()='Generate Invoice']")
	private WebElement clickGenerateInvoiceButton;

	/**
	 * Method to Click on Generate Invoice Button.
	 * 
	 * @throws IOException
	 */
	public void clickGenerateInvoiceButton() throws IOException {
		JavaScriptExec.scrollToElementOnPage(driver, clickGenerateInvoiceButton);
		GeneratingInvoicePage sp = new GeneratingInvoicePage(driver);
		log.info("Click on Generate Invoice Button");
		Assert.assertTrue(clickGenerateInvoiceButton.isDisplayed());
		clickGenerateInvoiceButton.click();

	}

	@FindBy(how = How.XPATH, using = "//div[@class='msg-box successfully']//*[text()='Done']")
	private WebElement verifyConfirmationMsg;

	/**
	 * Method to verify Account Type is created Successfully.
	 * 
	 * @throws IOException
	 */
	public void verifyConfirmationMsg() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("Verifying if Account Type is created Successfully or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyConfirmationMsg.isDisplayed(),
				"Assert Failed as its unable to search text in Logged in Page");
	}
	
	
 		@FindBy(how = How.XPATH, using = "//button[@id='newSubOrder']")
 		
 	private WebElement clickNewSubOrderButton;

 		/**
 		 * Method to click on New Sub Order Order button.
 		 * 
 		 * @throws IOException
 		 */
 	public void clickNewSubOrderButton() throws IOException {
 		CreateOrderPage sp = new CreateOrderPage(driver);
 		log.info("click on New Sub Order button.");
 		Assert.assertTrue(clickNewSubOrderButton.isDisplayed());
 		clickNewSubOrderButton.click();
 		JavaScriptExec.sleep();
 		}
 		
 	   @FindBy(how=How.XPATH, using="//*[@id='ui-id-6']")
 		//*[@id="ui-id-6"]
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
 	    clickDetailsTab.click();
 	    JavaScriptExec.sleep();
 	    }
 	    
 	 @FindBy(how=How.XPATH, using="//*[@id='order-details-form']/div[1]/div[1]/span/a")
 	//*[@id="order-details-form"]/div[1]/div[1]/span/a
	 private WebElement clickNew;
	    /**
	     * Method to Click Products tab.
	     * @throws IOException 
	     */
	  public void clickNew() throws IOException{
	    CreateOrderPage sp=new CreateOrderPage(driver);
	    log.info("Click Details Tab");
	    Assert.assertTrue(clickNew.isDisplayed());
	    clickNew.click();
	    JavaScriptExec.sleep();
	    }
 	    
 	 		
 	 	@FindBy(how = How.XPATH, using = "//*[@id='change--11-update-form']/div[2]/a[1]")
 	 	//*[@id="change--11-update-form"]/div[2]/a[1]/span
 	
 	 	private WebElement clickUpdateButton2;

 	 		/**
 	 		 * Method to click on Update button.
 	 		 * 
 	 		 * @throws IOException
 	 		 */
 	 	public void clickUpdateButton2() throws IOException {
 	 		CreateOrderPage sp = new CreateOrderPage(driver);
 	 		log.info("click on Update button.");
 	 		Assert.assertTrue(clickUpdateButton2.isDisplayed());
 	 		clickUpdateButton2.click();
 	 		JavaScriptExec.sleep();
 	 			}
 	 	
 	 	@FindBy(how = How.XPATH, using = "//*[@id='change--6-update-form']/div[2]/a[1]")
 	 	//*[@id="change--6-update-form"]/div[2]/a[1]/span
 	 
 	 
 	
 	 	private WebElement clickUpdateButton3;

 	 		/**
 	 		 * Method to click on Update button.
 	 		 * 
 	 		 * @throws IOException
 	 		 */
 	 	public void clickUpdateButton3() throws IOException {
 	 		CreateOrderPage sp = new CreateOrderPage(driver);
 	 		log.info("click on Update button.");
 	 		Assert.assertTrue(clickUpdateButton3.isDisplayed());
 	 		clickUpdateButton3.click();
 	 		JavaScriptExec.sleep();
 	 			}
 	 		
 	 	@FindBy(how = How.XPATH, using = "//*[@id='change--9-update-form']/div[2]/a[1]")
 	 //*[@id="change--9-update-form"]/div[2]/a[1]/span
 	 //*[@id="change--9-update-form"]/div[2]/a[1]/span
 	 
 	 	private WebElement clickUpdateButton4;

 	 		/**
 	 		 * Method to click on Update button.
 	 		 * 
 	 		 * @throws IOException
 	 		 */
 	 	public void clickUpdateButton4() throws IOException {
 	 		CreateOrderPage sp = new CreateOrderPage(driver);
 	 		log.info("click on Update button.");
 	 		Assert.assertTrue(clickUpdateButton4.isDisplayed());
 	 		clickUpdateButton4.click();
 	 		JavaScriptExec.sleep();
 	 		}
 	 		
 	 	@FindBy(how = How.XPATH, using = "//*[@id='change--12-update-form']/div[2]/a[1]")
 	 //*[@id="change--12-update-form"]/div[2]/a[1]/span
 	 	private WebElement clickUpdateButton5;

 	 		/**
 	 		 * Method to click on Update button.
 	 		 * 
 	 		 * @throws IOException
 	 		 */
 	 	public void clickUpdateButton5() throws IOException {
 	 		CreateOrderPage sp = new CreateOrderPage(driver);
 	 		log.info("click on Update button.");
 	 		Assert.assertTrue(clickUpdateButton5.isDisplayed());
 	 		clickUpdateButton5.click();
 	 		JavaScriptExec.sleep();
 	 		}
 	 		
 	 	@FindBy(how = How.XPATH, using = "//*[@id='change--6-update-form']/div[2]/a[1]")
 	 	//*[@id="change--6-update-form"]/div[2]/a[1]/span
 	 	private WebElement clickUpdateButton6;

 	 		/**
 	 		 * Method to click on Update button.
 	 		 * 
 	 		 * @throws IOException
 	 		 */
 	 	public void clickUpdateButton6() throws IOException {
 	 		CreateOrderPage sp = new CreateOrderPage(driver);
 	 		log.info("click on Update button.");
 	 		Assert.assertTrue(clickUpdateButton1.isDisplayed());
 	 		clickUpdateButton1.click();
 	 		JavaScriptExec.sleep();
 	 		}
 	 		
 	 	@FindBy(how = How.XPATH, using = "//*[@id='change--6-update-form']/div[2]/a[1]")
 	 	//*[@id="change--6-update-form"]/div[2]/a[1]/span
 	 	private WebElement clickUpdateButton7;

 	 		/**
 	 		 * Method to click on Update button.
 	 		 * 
 	 		 * @throws IOException
 	 		 */
 	 	public void clickUpdateButton7() throws IOException {
 	 		CreateOrderPage sp = new CreateOrderPage(driver);
 	 		log.info("click on Update button.");
 	 		Assert.assertTrue(clickUpdateButton1.isDisplayed());
 	 		clickUpdateButton1.click();
 	 		JavaScriptExec.sleep();
 	 		}
 	 		
 	 	@FindBy(how = How.XPATH, using = "//*[@id='change--5-update-form']/div[2]/a[1]")
 	 //*[@id="change--5-update-form"]/div[2]/a[1]/span
 	 	private WebElement clickUpdateButton8;

 	 		/**
 	 		 * Method to click on Update button.
 	 		 * 
 	 		 * @throws IOException
 	 		 */
 	 	public void clickUpdateButton8() throws IOException {
 	 		CreateOrderPage sp = new CreateOrderPage(driver);
 	 		log.info("click on Update button.");
 	 		Assert.assertTrue(clickUpdateButton8.isDisplayed());
 	 		clickUpdateButton8.click();
 	 		JavaScriptExec.sleep();
 	 		}
 	 		
 	 	@FindBy(how = How.XPATH, using = "//*[@id='change--5-update-form']/div[2]/a[1]")
 	
 	 //*[@id="change--5-update-form"]/div[2]/a[1]/span
 	 	private WebElement clickUpdateButton12;

 	 		/**
 	 		 * Method to click on Update button.
 	 		 * 
 	 		 * @throws IOException
 	 		 */
 	 	public void clickUpdateButton12() throws IOException {
 	 		CreateOrderPage sp = new CreateOrderPage(driver);
 	 		log.info("click on Update button.");
 	 		Assert.assertTrue(clickUpdateButton12.isDisplayed());
 	 		clickUpdateButton12.click();
 	 		JavaScriptExec.sleep();
 	 		}
 	 	
 	 	@FindBy(how = How.XPATH, using = "//*[@id='change--9-update-form']/div[2]/a[1]")
 	 	//*[@id="change--9-update-form"]/div[2]/a[1]/span
 	 	 	private WebElement clickUpdateButton10;

 	 	 		/**
 	 	 		 * Method to click on Update button.
 	 	 		 * 
 	 	 		 * @throws IOException
 	 	 		 */
 	 	 	public void clickUpdateButton10() throws IOException {
 	 	 		CreateOrderPage sp = new CreateOrderPage(driver);
 	 	 		log.info("click on Update button.");
 	 	 		Assert.assertTrue(clickUpdateButton10.isDisplayed());
 	 	 		clickUpdateButton10.click();
 	 	 		JavaScriptExec.sleep();
 	 	 		}
 	 	 	
 	 	 	@FindBy(how = How.XPATH, using = "//*[@id='change--9-update-form']/div[2]/a[1]")
 	 	//*[@id="change--9-update-form"]/div[2]/a[1]/span
 	 	 	 	private WebElement clickUpdateButton15;

 	 	 	 		/**
 	 	 	 		 * Method to click on Update button.
 	 	 	 		 * 
 	 	 	 		 * @throws IOException
 	 	 	 		 */
 	 	 	 	public void clickUpdateButton15() throws IOException {
 	 	 	 		CreateOrderPage sp = new CreateOrderPage(driver);
 	 	 	 		log.info("click on Update button.");
 	 	 	 		Assert.assertTrue(clickUpdateButton15.isDisplayed());
 	 	 	 		clickUpdateButton15.click();
 	 	 	 		JavaScriptExec.sleep();
 	 	 	 		}
 	 		
 	 	 	
 	 	 	@FindBy(how = How.XPATH, using = "//*[@id='change--6-update-form']/div[2]/a[1]")
 	 	 	
 	 	//*[@id="change--6-update-form"]/div[2]/a[1]/span
 	 	 	 	private WebElement clickUpdateButton13;

 	 	 	 		/**
 	 	 	 		 * Method to click on Update button.
 	 	 	 		 * 
 	 	 	 		 * @throws IOException
 	 	 	 		 */
 	 	 	 	public void clickUpdateButton13() throws IOException {
 	 	 	 		CreateOrderPage sp = new CreateOrderPage(driver);
 	 	 	 		log.info("click on Update button.");
 	 	 	 		Assert.assertTrue(clickUpdateButton13.isDisplayed());
 	 	 	 		clickUpdateButton13.click();
 	 	 	 		JavaScriptExec.sleep();
 	 	 	 		}
 	 	
 	 	 
 	 	//@FindBy(how=How.XPATH, using="//*[@id="18241"]/span")
 	 	//*[@id="18241"]/span
 	 	 private WebElement selectParentOrder;
 	 	 	 	    /**
 	 	 	 	     * Method to select customer.
 	 	 	 	     * @throws IOException 
 	 	 	 	     */
 	 	 public void selectParentOrder() throws IOException{
 	 	 	 CreateOrderPage sp=new CreateOrderPage(driver);
 	 	 	 JavaScriptExec.sleep();
 	 	 	 String OrderName = BasePage.getCellData(xlsxName, sheetName, 3, 5);
 	 	 	 WebElement selectOrder = driver
 	 	 	 					.findElement(By.xpath("//*[@id='18241']/span')'" + OrderName + "']"));
 	 	 	 navigateBottom();
 	 	 	 actions.moveToElement(selectOrder).click().perform();
 	 	 	 JavaScriptExec.sleep();
 	 	 	 	    }
 	 	@FindBy(how = How.XPATH, using = "//*[@id='column2']/div[2]/div[7]/div[1]/a[1]")
 	 	//*[@id="column2"]/div[2]/div[7]/div[1]/a[1]/span
 		private WebElement clickGenerateInvoiceButton1;

 		/**
 		 * Method to click on Generate Invoice Button.
 		 * 
 		 * @throws IOException
 		 */
 		public void clickGenerateInvoiceButton1() throws IOException {
 			CreateOrderPage sp = new CreateOrderPage(driver);
 			log.info("Click on Generate Invoice Button");
 			Assert.assertTrue(clickGenerateInvoiceButton.isDisplayed());
 			clickGenerateInvoiceButton.click();

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
