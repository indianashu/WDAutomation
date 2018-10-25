package productDependency;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import baseClassPackage.BasePage;
import customer.DiscountPage;
import orderHierarchies.OrderHierarchiesPage;
import utilPackages.JavaScriptExec;
import utilPackages.PropertyValExtractors;

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

	public void clickCustomerName(int columnNumber) throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("Click on Customer Name.");
		JavaScriptExec.sleep();
		String CustomerName = BasePage.getCellData(xlsxName, sheetName, 3, columnNumber);
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

	@FindBy(how = How.XPATH, using = "//select[@name='period']")
	private WebElement selectPeriod;

	/**
	 * Method to select Period.
	 * 
	 * @throws IOException
	 */
	public void selectPeriod(int columnNumber) throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		Assert.assertTrue(selectPeriod.isDisplayed());
		Select se = new Select(selectPeriod);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 4, columnNumber));
	}

	@FindBy(how = How.XPATH, using = "//select[@name='billingTypeId']")
	private WebElement selectOrderType;

	/**
	 * Method to select Period.
	 * 
	 * @throws IOException
	 */
	public void selectOrderType(int columnNumber) throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		Assert.assertTrue(selectOrderType.isDisplayed());
		Select se = new Select(selectOrderType);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 5, columnNumber));
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

	@FindBy(how = How.XPATH, using = "//select[@name='typeId']")
	private WebElement categoryElement;

	/**
	 * Method to Click Products tab.
	 * 
	 * @throws IOException
	 */
	public void selectCategory() {
		CreateOrderPage sp = new CreateOrderPage(driver);
		Select se = new Select(categoryElement);
		se.selectByVisibleText("Dependent Category");
	}

	public void selectProduct(int columnNumber) throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		JavaScriptExec.sleep();
		String ProductName = BasePage.getCellData(xlsxName, sheetName, 6, columnNumber);
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

	public void clickDependentProduct(int i) throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("click on dependenct product.");
		String DependentProduct = BasePage.getCellData(xlsxName, sheetName, 7, i);
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

	public void enterOrderQuantity(String quantity, String xPathRow) throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("Enter Min value");
		JavaScriptExec.sleep();
		WebElement enterSubOrderQuantity = driver
				.findElement(By.xpath("//*[@id='change--" + xPathRow + ".quantityAsDecimal']"));
		Assert.assertTrue(enterSubOrderQuantity.isDisplayed());
		enterSubOrderQuantity.clear();
		enterSubOrderQuantity.sendKeys(quantity);
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//a//following::span[text()='Update'][2]")
	private WebElement clickUpdateButton;

	/**
	 * Method to click on Update button.
	 * 
	 * @throws IOException
	 */
	public void clickUpdateButton() throws IOException {
		OrderHierarchiesPage sp = new OrderHierarchiesPage(driver);
		log.info("click on Update button.");
		Assert.assertTrue(clickUpdateButton.isDisplayed());
		clickUpdateButton.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Update']")
	private WebElement clickSubOrderUpdateButton;

	/**
	 * Method to click on update button.
	 * 
	 * @throws IOException
	 */
	public void clickSubOrderUpdateButton() throws IOException {
		DiscountPage sp = new DiscountPage(driver);
		log.info("click on update button.");
		Assert.assertTrue(clickSubOrderUpdateButton.isDisplayed());
		clickSubOrderUpdateButton.click();
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
	public void clickGenerateInvoiceButton(String orderid) throws IOException {
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url2") + "/order/generateInvoice/" + orderid;
		driver.get(url);
		JavaScriptExec.sleep();
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
		log.info("Verifying if Element is created Successfully or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyConfirmationMsg.isDisplayed(),
				"Assert Failed as its unable to search text in Logged in Page");
	}

	@FindBy(how = How.XPATH, using = "//div[@class='msg-box error']//*[text()='The order has an error in the hierarchy field: Mandatory dependency not satisfied']")
	private WebElement verifyErrorMsg;

	/**
	 * Method to verify Account Type is created Successfully.
	 * 
	 * @throws IOException
	 */
	public void verifyErrorMsg() throws IOException {
		CreateOrderPage sp = new CreateOrderPage(driver);
		log.info("Verifying dependency is satisfied or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyErrorMsg.isDisplayed(),
				"Assert Failed as its unable to search text in Logged in Page");
	}

	public String extractOrderId() {
		String msg = driver.findElement(By.xpath("//*[@id='messages']/div/p")).getText();
		String orderid = msg.substring(18, msg.indexOf(" for customer ")).replace(",", "");
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

	public String verifyOrderLinesLeo() {
		navigateBottom();
		String orderLineItem1 = driver
				.findElement(By.xpath("//*[@id='column2']/div[1]/div[6]/div/table/tbody/tr[1]/td[2]")).getText();
		log.info("Verify Order Lines");
		Assert.assertEquals(orderLineItem1, "Billing Category Product 1");

		String orderLineItem2 = driver
				.findElement(By.xpath("//*[@id='column2']/div[1]/div[6]/div/table/tbody/tr[2]/td[2]")).getText();
		Assert.assertEquals(orderLineItem2, "Billing Product 1");
		return orderLineItem1;
	}

	public String verifyOrderLinesWilliam() {
		String product = driver.findElement(By.xpath("//*[@id='column2']/div[2]/div[6]/div/table/tbody/tr/td[2]"))
				.getText();
		log.info("Verify Order Lines");
		Assert.assertEquals(product, "Billing Category Product 2");
		return product;
	}

	public String verifyOrderLineOlivia() {
		String product1 = driver.findElement(By.xpath("//*[@id='column2']/div[2]/div[6]/div/table/tbody/tr[1]/td[2]"))
				.getText();
		log.info("Verify Order Lines");
		Assert.assertEquals(product1, "Billing Category Product 3");
		String product2 = driver.findElement(By.xpath("//*[@id='column2']/div[2]/div[6]/div/table/tbody/tr[2]/td[2]"))
				.getText();
		Assert.assertEquals(product2, "Billing Product 1");
		return product1;
	}

	public String verifyOrderLineIsabella() {
		String product1 = driver.findElement(By.xpath("//*[@id='column2']/div[2]/div[6]/div/table/tbody/tr/td[2]"))
				.getText();
		log.info("Verify Order Line");
		Assert.assertEquals(product1, "Billing Category Product 4");
		return product1;
	}

	public String verifyOrderLineSophia() {
		String product1 = driver.findElement(By.xpath("//*[@id='column2']/div[1]/div[6]/div/table/tbody/tr[1]/td[2]"))
				.getText();
		log.info("Verify Order Line");
		Assert.assertEquals(product1, "Billing Category Product 5");
		String product2 = driver.findElement(By.xpath("//*[@id='column2']/div[1]/div[6]/div/table/tbody/tr[2]/td[2]"))
				.getText();
		Assert.assertEquals(product2, "Billing Product 1");
		return product1;
	}

	public void showOrder(String orderId) {
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url2") + "/order/list/" + orderId;
		driver.get(url);
		JavaScriptExec.sleep();
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

	public void verifyAmountofInvoice(String invoiceId) throws IOException {
		String invoiceXpath = "invoice-" + invoiceId;
		String amount = driver.findElement(By.xpath("//*[@id='invoices']//tr[@id='" + invoiceXpath + "']//td[6]"))
				.getText();
		System.out.println("Amount of Invoice  = " + amount);
		String customer = driver.findElement(By.xpath("//*[@id=" + invoiceId + "]/strong/span")).getText();
		System.out.println("Customer Name  for Invoice=" + customer);
		if (customer.contains(BasePage.getCellData(xlsxName, sheetName, 3, 0))) {
			Assert.assertEquals(amount, "US$120.00");
		} else if (customer.contains(BasePage.getCellData(xlsxName, sheetName, 3, 1))) {
			Assert.assertEquals(amount, "US$20.00");
		} else if (customer.contains(BasePage.getCellData(xlsxName, sheetName, 3, 2))) {
			Assert.assertEquals(amount, "US$180.00");
		} else if (customer.contains(BasePage.getCellData(xlsxName, sheetName, 3, 3))) {
			Assert.assertEquals(amount, "US$200.00");
		} else if (customer.contains(BasePage.getCellData(xlsxName, sheetName, 3, 4))) {
			Assert.assertEquals(amount, "US$140.00");
		} else {
			Assert.assertEquals(amount, "US$10.00");
		}
	}

	public String verifySubOrdersTest(String orderId) {
		JavaScriptExec.sleep();
		String orderXpath = "order-" + orderId;
		String verifysubChilds = driver.findElement(By.xpath("//*[@id='" + orderXpath + "']/td[6]/a/span")).getText();

		Assert.assertEquals(verifysubChilds, "1");
		driver.findElement(By.xpath("//*[@id='" + orderXpath + "']/td[6]/a")).click();
		JavaScriptExec.sleep();

		String subOrderXpath = "suborder_tr_" + orderId;
		String getSubOrder = driver.findElement(By.xpath("//E2/preceding-sibling::*[1][@id=" + orderId + "]"))
				.getText();

		String subOrderId = getSubOrder.substring(5);
		return subOrderId;
	}

	public void verifySubOrders(String orderid) throws IOException {
		JavaScriptExec.sleep();
		String orderXpath = "order-" + orderid;
		String verifysubChilds = driver.findElement(By.xpath("//*[@id='" + orderXpath + "']/td[6]/a/span")).getText();
		String customer = driver.findElement(By.xpath("//*[@id=" + orderid + "]/strong/span")).getText();
		System.out.println("Customer Name =" + customer);
		if (customer.contains(BasePage.getCellData(xlsxName, sheetName, 3, 1))) {
			Assert.assertEquals(verifysubChilds, "1");
		} else if (customer.contains(BasePage.getCellData(xlsxName, sheetName, 3, 2))
				|| customer.contains(BasePage.getCellData(xlsxName, sheetName, 3, 5))) {
			Assert.assertEquals(verifysubChilds, "2");
		} else {
			Assert.assertEquals(verifysubChilds, "3");
		}
		driver.findElement(By.xpath("//*[@id='" + orderXpath + "']/td[6]/a")).click();
		JavaScriptExec.sleep();
	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();

	}
}
