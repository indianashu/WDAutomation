package productDependency;

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

	public void clickCustomerName() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("Click on Customer Name.");
		JavaScriptExec.sleep();
		String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, 10);
		driver.findElement(By.xpath("//*[text()='" + CustomerName + "']/following::a[1]")).click();
	}

	public void clickCustomerName1() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("Click on Customer Name.");
		JavaScriptExec.sleep();
		String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, 4);
		driver.findElement(By.xpath("//*[text()='" + CustomerName + "']/following::a[1]")).click();
		navigateBottom();
	}

	public void clickParentCustomerName() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("Click on Customer Name.");
		JavaScriptExec.sleep();
		String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, 5);
		driver.findElement(By.xpath("//*[text()='" + CustomerName + "']/following::a[1]")).click();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='column2']/div[1]/div[7]/div[1]/a[3]/span")
	private WebElement clickEditthisorder;

	/**
	 * Method to click on Customer tab after successful login.
	 * 
	 * @throws IOException
	 */
	public void clickEditthisorder() throws IOException {
		log.info("Click on Edit this folder button");
		navigateBottom();
		Assert.assertTrue(clickEditthisorder.isDisplayed());
		clickEditthisorder.click();
	}

	public void selectCustomer() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, 0);
		WebElement selectCustomer = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']"));
		navigateBottom();
		actions.moveToElement(selectCustomer).click().perform();
	}

	public void selectCustomer1() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		JavaScriptExec.sleep();
		String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, 1);
		WebElement selectCustomer = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']"));
		navigateBottom();
		actions.moveToElement(selectCustomer).click().perform();
		JavaScriptExec.sleep();
	}

	public void selectCustomer2() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		JavaScriptExec.sleep();
		String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, 2);
		WebElement selectCustomer = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']"));
		navigateBottom();
		actions.moveToElement(selectCustomer).click().perform();
		JavaScriptExec.sleep();
	}

	public void selectCustomer3() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		JavaScriptExec.sleep();
		String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, 3);
		WebElement selectCustomer = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']"));
		navigateBottom();
		actions.moveToElement(selectCustomer).click().perform();
		JavaScriptExec.sleep();
	}

	public void selectCustomer4() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		JavaScriptExec.sleep();
		String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, 4);
		WebElement selectCustomer = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']"));
		navigateBottom();
		actions.moveToElement(selectCustomer).click().perform();
		JavaScriptExec.sleep();
	}

	public void selectCustomer5() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, 5);
		WebElement selectCustomer = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CustomerName + "']"));
		navigateBottom();
		actions.moveToElement(selectCustomer).click().perform();
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
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("click on create order button.");
		Assert.assertTrue(clickCreateOrder.isDisplayed());
		clickCreateOrder.click();
		JavaScriptExec.sleep();
	}

	private WebElement selectPeriod;

	/**
	 * Method to select Period.
	 * 
	 * @throws IOException
	 */
	public void selectPeriod() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		WebElement Periodelement = driver.findElement(By.xpath("//select[@name='period']"));
		Select se = new Select(Periodelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 4, 0));
	}

	private WebElement selectPeriod1;

	/**
	 * Method to select Period.
	 * 
	 * @throws IOException
	 */
	public void selectPeriod1() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		WebElement Periodelement = driver.findElement(By.xpath("//select[@name='period']"));
		Select se = new Select(Periodelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 4, 1));
	}

	public void selectPeriod2() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		WebElement Periodelement = driver.findElement(By.xpath("//select[@name='period']"));
		Select se = new Select(Periodelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 4, 0));
	}

	public void selectPeriod3() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		WebElement Periodelement = driver.findElement(By.xpath("//select[@name='period']"));
		Select se = new Select(Periodelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 3, 0));
	}

	public void selectPeriod5() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		WebElement Periodelement = driver.findElement(By.xpath("//select[@name='period']"));
		Select se = new Select(Periodelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 4, 2));
	}

	public void selectOrderType() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		WebElement OrderTypeelement = driver.findElement(By.xpath("//select[@name='billingTypeId']"));
		Select se = new Select(OrderTypeelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 5, 0));
	}

	public void selectOrderType1() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		WebElement OrderTypeelement = driver.findElement(By.xpath("//select[@name='billingTypeId']"));
		Select se = new Select(OrderTypeelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 5, 0));
	}

	public void selectOrderType2() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		WebElement OrderTypeelement = driver.findElement(By.xpath("//select[@name='billingTypeId']"));
		Select se = new Select(OrderTypeelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 5, 0));
	}

	public void selectOrderType3() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		WebElement OrderTypeelement = driver.findElement(By.xpath("//select[@name='billingTypeId']"));
		Select se = new Select(OrderTypeelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 5, 1));
	}

	public void selectOrderType5() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		WebElement OrderTypeelement = driver.findElement(By.xpath("//select[@name='billingTypeId']"));
		Select se = new Select(OrderTypeelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 5, 1));
	}

	public void selectOrderType4() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		JavaScriptExec.sleep();
		WebElement OrderTypeelement = driver.findElement(By.xpath("//select[@name='billingTypeId']"));
		Select se = new Select(OrderTypeelement);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 5, 0));
	}

	@FindBy(how = How.XPATH, using = "//*[@id='ui-id-8']")
	private WebElement clickProductsSubTab;

	/**
	 * Method to Click Products tab.
	 * 
	 * @throws IOException
	 */
	public void clickProductsSubTab() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
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

	public void selectProduct() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		JavaScriptExec.sleep();
		String ProductName = BasePage.getCellData(xlsxName, sheetName, 6, 0);
		WebElement selectProduct = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']"));
		navigateBottom();
		actions.moveToElement(selectProduct).click().perform();
		JavaScriptExec.sleep();
	}

	public void selectProduct1() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		JavaScriptExec.sleep();
		String ProductName = BasePage.getCellData(xlsxName, sheetName, 6, 1);
		WebElement selectProduct = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']"));
		navigateBottom();
		actions.moveToElement(selectProduct).click().perform();
		JavaScriptExec.sleep();
	}

	public void selectProduct2() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		JavaScriptExec.sleep();
		String ProductName = BasePage.getCellData(xlsxName, sheetName, 6, 2);
		WebElement selectProduct = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']"));
		navigateBottom();
		actions.moveToElement(selectProduct).click().perform();
		JavaScriptExec.sleep();
	}

	public void selectProduct3() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		JavaScriptExec.sleep();
		String ProductName = BasePage.getCellData(xlsxName, sheetName, 6, 3);
		WebElement selectProduct = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']"));
		navigateBottom();
		actions.moveToElement(selectProduct).click().perform();
		JavaScriptExec.sleep();
	}

	public void selectProduct4() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		JavaScriptExec.sleep();
		String ProductName = BasePage.getCellData(xlsxName, sheetName, 6, 4);
		WebElement selectProduct = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']"));
		navigateBottom();
		actions.moveToElement(selectProduct).click().perform();
		JavaScriptExec.sleep();
	}

	public void selectProduct5() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		JavaScriptExec.sleep();
		String ProductName = BasePage.getCellData(xlsxName, sheetName, 6, 5);
		WebElement selectProduct = driver
				.findElement(By.xpath("//a[@class='cell double']//*[text()='" + ProductName + "']"));
		navigateBottom();
		actions.moveToElement(selectProduct).click().perform();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Dependency']")
	private WebElement clickPlusdependency;

	/**
	 * Method to click on Products tab after successful login.
	 * 
	 * @throws IOException
	 */
	public void clickPlusdependency() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("Click on plusDependency");
		Assert.assertTrue(clickPlusdependency.isDisplayed());
		clickPlusdependency.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='edit_change_header_-3']/td[1]")
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

	public void clickDependentProduct() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("click on dependenct product.");
		String DependentProduct = BasePage.getCellData(xlsxName, sheetName, 7, 0);
		driver.findElement(By.xpath("//a[not(@href)]/strong[text()='" + DependentProduct + "']")).click();
	}

	public void clickDependentProduct1() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("click on dependenct product.");
		String DependentProduct = BasePage.getCellData(xlsxName, sheetName, 7, 2);
		driver.findElement(By.xpath("//a[not(@href)]/strong[text()='" + DependentProduct + "']")).click();
	}

	public void clickDependentProduct2() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("click on dependenct product.");
		String DependentProduct = BasePage.getCellData(xlsxName, sheetName, 7, 2);
		driver.findElement(By.xpath("//a[not(@href)]/strong[text()='" + DependentProduct + "']")).click();
	}

	public void clickDependentProduct3() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("click on dependenct product.");
		String DependentProduct = BasePage.getCellData(xlsxName, sheetName, 7, 1);
		driver.findElement(By.xpath("//a[not(@href)]/strong[text()='" + DependentProduct + "']")).click();
	}

	public void clickDependentProduct4() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("click on dependenct product.");
		String DependentProduct = BasePage.getCellData(xlsxName, sheetName, 7, 0);
		driver.findElement(By.xpath("//a[not(@href)]/strong[text()='" + DependentProduct + "']")).click();
	}

	public void clickDependentProduct5() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("click on dependenct product.");
		String DependentProduct = BasePage.getCellData(xlsxName, sheetName, 7, 0);
		driver.findElement(By.xpath("//a[not(@href)]/strong[text()='" + DependentProduct + "']")).click();
	}

	public void clickDependentProduct6() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("click on dependenct product.");
		String DependentProduct = BasePage.getCellData(xlsxName, sheetName, 7, 1);
		driver.findElement(By.xpath("//a[not(@href)]/strong[text()='" + DependentProduct + "']")).click();
	}

	public void clickDependentProduct7() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("click on dependenct product.");
		String DependentProduct = BasePage.getCellData(xlsxName, sheetName, 7, 2);
		driver.findElement(By.xpath("//a[not(@href)]/strong[text()='" + DependentProduct + "']")).click();
	}

	public void clickDependentProduct8() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("click on dependenct product.");
		String DependentProduct = BasePage.getCellData(xlsxName, sheetName, 7, 0);
		driver.findElement(By.xpath("//a[not(@href)]/strong[text()='" + DependentProduct + "']")).click();
	}

	public void clickDependentProduct9() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("click on dependenct product.");
		String DependentProduct = BasePage.getCellData(xlsxName, sheetName, 7, 1);
		driver.findElement(By.xpath("//a[not(@href)]/strong[text()='" + DependentProduct + "']")).click();
	}

	public void clickDependentProduct10() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("click on dependenct product.");
		String DependentProduct = BasePage.getCellData(xlsxName, sheetName, 7, 2);
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

	@FindBy(how = How.XPATH, using = "//*[@id='change--5.quantityAsDecimal']")
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
		Assert.assertTrue(enterQuantity.isDisplayed());
		enterQuantity.clear();
		enterQuantity.sendKeys("2");
	}

	@FindBy(how = How.XPATH, using = "//*[@id='change--6.quantityAsDecimal']")
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
		Assert.assertTrue(enterQuantity1.isDisplayed());
		enterQuantity1.clear();
		enterQuantity1.sendKeys("3");
	}

	@FindBy(how = How.XPATH, using = "//*[@id='change--6.quantityAsDecimal']")
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
		Assert.assertTrue(enterQuantity1.isDisplayed());
		enterQuantity2.clear();
		enterQuantity2.sendKeys(BasePage.getCellData(xlsxName, sheetName, 8, 2));
	}

	@FindBy(how = How.XPATH, using = "//*[@id='change--6.quantityAsDecimal']")
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
		Assert.assertTrue(enterQuantity1.isDisplayed());
		enterQuantity2.clear();
		enterQuantity2.sendKeys(BasePage.getCellData(xlsxName, sheetName, 8, 3));
	}

	@FindBy(how = How.XPATH, using = "//*[@id='change--6.quantityAsDecimal']")
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
		Assert.assertTrue(enterQuantity1.isDisplayed());
		enterQuantity4.clear();
		enterQuantity4.sendKeys(BasePage.getCellData(xlsxName, sheetName, 8, 4));
	}

	@FindBy(how = How.XPATH, using = "//*[@id='change--6.quantityAsDecimal']")
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
		Assert.assertTrue(enterQuantity1.isDisplayed());
		enterQuantity5.clear();
		enterQuantity5.sendKeys("2");
	}

	@FindBy(how = How.XPATH, using = "//*[@id='change--12.quantityAsDecimal']")
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
		Assert.assertTrue(enterQuantity6.isDisplayed());
		JavaScriptExec.sleep();
		enterQuantity6.clear();
		enterQuantity6.sendKeys("4");
	}

	@FindBy(how = How.XPATH, using = "//*[@id='change--6.quantityAsDecimal']")
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
		Assert.assertTrue(enterQuantity8.isDisplayed());
		enterQuantity8.clear();
		enterQuantity8.sendKeys(BasePage.getCellData(xlsxName, sheetName, 8, 7));
	}

	@FindBy(how = How.XPATH, using = "//*[@id='change--6.quantityAsDecimal']")
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
		Assert.assertTrue(enterQuantity9.isDisplayed());
		enterQuantity9.clear();
		enterQuantity9.sendKeys("2");
	}

	@FindBy(how = How.XPATH, using = "//*[@id='change--9.quantityAsDecimal']")
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
		Assert.assertTrue(enterQuantity10.isDisplayed());
		enterQuantity10.clear();
		enterQuantity10.sendKeys("4");
	}

	@FindBy(how = How.XPATH, using = "//*[@id='change--5.quantityAsDecimal']")
	private WebElement enterQuantity7;

	/**
	 * Method to Enter Price Rate.
	 * 
	 * @throws IOException
	 */
	public void enterQuantity7() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("Enter Quantity");
		JavaScriptExec.sleep();
		Assert.assertTrue(enterQuantity7.isDisplayed());
		enterQuantity7.clear();
		enterQuantity7.sendKeys("3");
	}

	@FindBy(how = How.XPATH, using = "//a//following::span[text()='Update']")
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
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("Click on Save Changes Button");
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		JavaScriptExec.sleep();
		clickSaveChangesButton.click();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='order-18257']/td[1]")
	private WebElement clickOrder;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickOrder() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
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
		CreateOrderPage sp = new CreateOrderPage(driver);
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

	public String extractOrderId()
	{
		String msg=driver.findElement(By.xpath("//*[@id='messages']/div/p")).getText();
		String orderid=msg.substring(18,msg.indexOf(" for customer ")).replace(",", "");
		return orderid;
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

	@FindBy(how = How.XPATH, using = "//*[@id='ui-id-6']")
	private WebElement clickDetailsTab;

	/**
	 * Method to Click Products tab.
	 * 
	 * @throws IOException
	 */
	public void clickDetailsTab() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("Click Details Tab");
		Assert.assertTrue(clickDetailsTab.isDisplayed());
		clickDetailsTab.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='order-details-form']/div[1]/div[1]/span/a")
	private WebElement clickNew;

	/**
	 * Method to Click Products tab.
	 * 
	 * @throws IOException
	 */
	public void clickNew() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("Click Details Tab");
		Assert.assertTrue(clickNew.isDisplayed());
		clickNew.click();
		JavaScriptExec.sleep();
	}

	private WebElement selectParentOrder;

	/**
	 * Method to select customer.
	 * 
	 * @throws IOException
	 */
	public void selectParentOrder() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		JavaScriptExec.sleep();
		String OrderName = BasePage.getCellData(xlsxName, sheetName, 3, 3);
		WebElement selectOrder = driver.findElement(By.xpath("//*[@id='18241']/span')'" + OrderName + "']"));
		navigateBottom();
		actions.moveToElement(selectOrder).click().perform();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='column2']/div[2]/div[7]/div[1]/a[1]")
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
	
	public String verifyOrderLines(){
		navigateBottom();
		String product1=driver.findElement(By.xpath("//*[@id='column2']/div[1]/div[6]/div/table/tbody/tr[1]/td[2]")).getText();
		log.info("Verify Order Lines");
		Assert.assertEquals(product1,"Billing Category Product 1");
		String product2=driver.findElement(By.xpath("//*[@id='column2']/div[1]/div[6]/div/table/tbody/tr[2]/td[2]")).getText();
		Assert.assertEquals(product2,"Billing Product 1");
		return product1;
	}
	
	public String extractInvoiceId() {
		String message = driver.findElement(By.xpath("//*[@id='messages']/div/p")).getText();
		String invoiceid = message.substring(31, message.indexOf(" for Order "));
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url2") + "/invoice/list/" + invoiceid;
		driver.get(url);
		JavaScriptExec.sleep();
		return invoiceid;
	}
	
	public void verifyAmount(){
		String amount=driver.findElement(By.xpath("//*[@id='column2']/div[1]/div[2]/div/table[2]/tbody/tr[7]/td[2]")).getText();
		Assert.assertEquals(amount,"US$120.00");
	}
	
	public void verifySubOrders(){
		String subChilds=driver.findElement(By.xpath("//*[@id='18638']/span")).getText();
		Assert.assertEquals("subChilds", 1);
	}
		
	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();

	}
}
