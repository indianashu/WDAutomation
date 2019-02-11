package peakNonPeak;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import baseClassPackage.BasePage;
import productDependency.CreateCategoryPage;
import utilPackages.JavaScriptExec;
import utilPackages.PropertyValExtractors;
import utilPackages.WaitClass;

public class CategoryProductPage extends BasePage {

	public CategoryProductPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(CategoryProductPage.class);
	CategoryProductPage productCategoryPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "Product";
	String xlsxName = "/Peak_Non_Peak_Test_Data.xlsx";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		CategoryProductPage sp = new CategoryProductPage(driver);
		log.info("Verifying the Login ID is available or not");
		Assert.assertTrue(enterLoginID.isDisplayed());
		enterLoginID.sendKeys(BasePage.getCellData(xlsxName, sheetName, 0, 0));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='j_password']")
	private WebElement enterPassword;

	/**
	 * Method to enter Password.
	 * 
	 * @throws IOException
	 */
	public void enterPassword() throws IOException {
		CategoryProductPage sp = new CategoryProductPage(driver);
		log.info("Verifying the First Name is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, enterPassword);
		Assert.assertTrue(enterPassword.isDisplayed());
		enterPassword.sendKeys(BasePage.getCellData(xlsxName, sheetName, 1, 0));
	}

	@FindBy(how = How.XPATH, using = "//select[@name='j_client_id']")
	private WebElement selectCompany;

	/**
	 * Method to select Comapny.
	 * 
	 * @throws IOException
	 */
	public void selectCompany() throws IOException {
		CategoryProductPage sp = new CategoryProductPage(driver);
		Select se = new Select(selectCompany);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 2, 0));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']")
	private WebElement clickLoginButton;

	/**
	 * Method to Click on Save Changes Button
	 */
	public void clickLoginButton() {
		CategoryProductPage sp = new CategoryProductPage(driver);
		log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
		Assert.assertTrue(clickLoginButton.isDisplayed());
		clickLoginButton.click();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='menu.link.products']/a")
	private WebElement clickProductsTab;

	/**
	 * Method to click on Products tab after successful login.
	 * 
	 * @throws IOException
	 */
	public void clickProductsTab() throws IOException {
		CategoryProductPage sp = new CategoryProductPage(driver);
		log.info("Click on Products Tab after successful login");
		JavaScriptExec.sleep();
		Assert.assertTrue(clickProductsTab.isDisplayed());
		clickProductsTab.click();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add Category']")
	private WebElement clickAddCategoryButton;

	/**
	 * Method to click on Add Category Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddCategoryButton() throws IOException {
		CategoryProductPage sp = new CategoryProductPage(driver);
		log.info("Click on Add Category Button");
		navigateBottom();
		Assert.assertTrue(clickAddCategoryButton.isDisplayed());
		clickAddCategoryButton.click();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='description']")
	private WebElement enterCategoryName;

	/**
	 * Method to Enter Category Name.
	 * 
	 * @throws IOException
	 */
	public void enterCategoryName(int rowNum) throws IOException {
		CategoryProductPage sp = new CategoryProductPage(driver);
		log.info("Enter Category Name");
		Assert.assertTrue(enterCategoryName.isDisplayed());
		enterCategoryName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 5, rowNum));
	}

	@FindBy(how = How.XPATH, using = "//select[@name='entities']")
	private WebElement selectCompanies;

	/**
	 * Method to Enter Category Name.
	 * 
	 * @throws IOException
	 */
	public void selectCompanies() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		Select se = new Select(selectCompanies);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 2, 0));
	}

	@FindBy(how = How.XPATH, using = "//select[@name='orderLineTypeId']")
	private WebElement enterCategoryType;

	/**
	 * Method to Enter Category Name.
	 * 
	 * @throws IOException
	 */
	public void enterCategoryType() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		log.info("Enter Category Name");
		Assert.assertTrue(enterCategoryType.isDisplayed());
		enterCategoryType.sendKeys(BasePage.getCellData(xlsxName, sheetName, 8, 1));
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
	private WebElement clickSaveChangesButton;

	/**
	 * Method to click on Save Changes Button.
	 * 
	 * @throws IOException
	 */
	public void clickSaveChangesButton() throws IOException {
		CategoryProductPage sp = new CategoryProductPage(driver);
		log.info("Click on Save Changes Button");
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		clickSaveChangesButton.click();
	}

	@FindBy(how = How.XPATH, using = "//strong[text()='Done']")
	private WebElement verifyConfirmationMsg;

	/**
	 * Method to verify Product is created Successfully.
	 * 
	 * @throws IOException
	 */
	public void verifyConfirmationMsg() throws IOException {
		CategoryProductPage sp = new CategoryProductPage(driver);
		log.info("Verifying if Product is created Successfully or not");
		JavaScriptExec.sleep();
		Assert.assertTrue(verifyConfirmationMsg.isDisplayed(),
				"Assert Failed as its unable to search text in Logged in Page");
	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.descriptions[0].content']")
	private WebElement enterEnglishDescription;

	/**
	 * Method to Enter English Description.
	 * 
	 * @throws IOException
	 */
	public void enterEnglishDescription(int colNum, int rowNum) throws IOException {
		CategoryProductPage sp = new CategoryProductPage(driver);
		log.info("Enter English Description");
		Assert.assertTrue(enterEnglishDescription.isDisplayed());
		enterEnglishDescription.sendKeys(BasePage.getCellData(xlsxName, sheetName, colNum, rowNum));
	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.number']")
	private WebElement enterProductCode;

	/**
	 * Method to Enter Product Code.
	 * 
	 * @throws IOException
	 */
	public void enterProductCode(int colNum, int rowNum) throws IOException {
		CategoryProductPage sp = new CategoryProductPage(driver);
		log.info("Enter Product Code");
		Assert.assertTrue(enterProductCode.isDisplayed());
		enterProductCode.sendKeys(BasePage.getCellData(xlsxName, sheetName, colNum, rowNum));
	}

	@FindBy(how = How.XPATH, using = "//select[@name='product.currencies']")
	private WebElement selectCurrency;

	/**
	 * Method to Enter Price Rate.
	 * 
	 * @throws IOException
	 */
	public void selectCurrency() throws IOException {
		CategoryProductPage sp = new CategoryProductPage(driver);
		log.info("Enter Price Rate");
		Select sel = new Select(selectCurrency);
		sel.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 10, 0));
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='product.rate']")
	private WebElement enterPriceRate;

	/**
	 * Method to Enter Price Rate.
	 * 
	 * @throws IOException
	 */
	public void enterPriceRate(int rowNum) throws IOException {
		CategoryProductPage sp = new CategoryProductPage(driver);
		log.info("Enter Price Rate");
		JavaScriptExec.sleep();
		Assert.assertTrue(enterPriceRate.isDisplayed());
		enterPriceRate.sendKeys(BasePage.getCellData(xlsxName, sheetName, 9, rowNum));
	}

	public void selectCategoryName(int rowNum) throws IOException {
		CategoryProductPage sp = new CategoryProductPage(driver);
		log.info("Click on a category name.");
		String CategoryName = BasePage.getCellData(xlsxName, sheetName, 5, rowNum);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CategoryName + "']")).click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add Product']")
	private WebElement clickAddProductButton;

	/**
	 * Method to click on Add Product Button".
	 * 
	 * @throws IOException
	 */
	public void clickAddProductButton() throws IOException {
		CategoryProductPage sp = new CategoryProductPage(driver);
		log.info("Click on Add Product Button");
		Assert.assertTrue(clickAddProductButton.isDisplayed());
		clickAddProductButton.click();
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add Price']")
	private WebElement clickAddPriceButton;

	/**
	 * Method to click on Add Price Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddPriceButton() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		log.info("Click on Add Price Button");
		Assert.assertTrue(clickAddPriceButton.isDisplayed());
		clickAddPriceButton.click();
		navigateBottom();
	}

	@FindBy(how = How.XPATH, using = "//select[@name='product.confPricingProduct']")
	private WebElement enterPlanProduct;

	/**
	 * Method to Enter .
	 * 
	 * @throws IOException
	 */
	public void enterPlanProduct() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		log.info("Enter Plan Product");
		enterPlanProduct.click();
		Select select = new Select(enterPlanProduct);
		int selectOptions = select.getOptions().size();
		select.selectByIndex(selectOptions - 1);
	}

	@FindBy(how = How.XPATH, using = "//select[@name='product.confPricingList']")
	private WebElement enterPricing;

	/**
	 * Method to Enter .
	 * 
	 * @throws IOException
	 */
	public void enterPricing() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		log.info("Enter Pricing");
		JavaScriptExec.sleep();
		Assert.assertTrue(enterPricing.isDisplayed());
		enterPricing.sendKeys(BasePage.getCellData(xlsxName, sheetName, 3, 0));
	}

	@FindBy(how = How.XPATH, using = "//*[@id='confPricingList']//a/span")
	private WebElement clickOnAddPrice;

	/**
	 * Method to click on Add Price Button.
	 * 
	 * @throws IOException
	 */
	public void clickOnAddPrice() throws IOException {
		CreateCategoryPage sp = new CreateCategoryPage(driver);
		log.info("Click on Add Price Button");
		Assert.assertTrue(clickOnAddPrice.isDisplayed());
		clickOnAddPrice.click();
		navigateBottom();
	}

	public void verifyCategoryData(int column) throws IOException {
		String actualCategoryName = BasePage.getCellData(xlsxName, sheetName, 5, column);
		String expectedCategoryName = driver.findElement(By.xpath("//tbody//tr[1]//a[@class='cell double']/strong"))
				.getText();
		System.out.println("Category Name = " + expectedCategoryName);
		Assert.assertEquals(actualCategoryName, expectedCategoryName);

		String actualCategoryType = BasePage.getCellData(xlsxName, sheetName, 8, column);
		String expectedCategoryType = driver.findElement(By.xpath("//tbody//tr[1]//td[3]//a[@class='cell']/span"))
				.getText();
		System.out.println(expectedCategoryName + "Type is = " + expectedCategoryType);
		Assert.assertEquals(actualCategoryType, expectedCategoryType);
	}

	public void verifyProductName(int column) throws IOException {
		String actualProductName = BasePage.getCellData(xlsxName, sheetName, 6, column);
		String expectedProductName = driver
				.findElement(By.xpath("//table[@id='products']//tr[1]//a[@class='cell double']/strong")).getText();
		System.out.println("Item Product Name = " + expectedProductName);
		Assert.assertEquals(actualProductName, expectedProductName);
	}

	public void verifyProductData(int rowNum) throws IOException {
		String actualProductName = BasePage.getCellData(xlsxName, sheetName, 7, rowNum);
		String expectedProductName = driver
				.findElement(By.xpath("//table[@id='products']//tr[1]//a[@class='cell double']/strong")).getText();
		System.out.println("Plan Product Name Expected = " + expectedProductName);
		System.out.println("Plan Product Name Actual= " + actualProductName);
		Assert.assertEquals(actualProductName, expectedProductName);

		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + actualProductName + "']")).click();
		JavaScriptExec.sleep();

		String expectedComponentPricesProduct = driver
				.findElement(By.xpath("//*[@id='column2']//td[1]//a")).getText().substring(0,14);
		String actualComponentPricesProduct = BasePage.getCellData(xlsxName, sheetName, 6, rowNum);

		System.out.println("Component Price Name Expected= " +expectedComponentPricesProduct);
		System.out.println("Component Price Name Actual= " +actualComponentPricesProduct);
		Assert.assertTrue(expectedComponentPricesProduct.contains(actualComponentPricesProduct));

		String expectedComponentPricePricing = driver
				.findElement(By.xpath("//*[@id='column2']//td[2]//a")).getText().substring(0,19);
		String actualComponentPricesPricing = BasePage.getCellData(xlsxName, sheetName, 3, 0);

		System.out.println("Component Pricing Name Expected= " +expectedComponentPricePricing);
		System.out.println("Component Pricing Name Actual= " +actualComponentPricesPricing);
		System.out.println("Plan Product Name Actual= " +expectedComponentPricePricing);
		Assert.assertTrue(expectedComponentPricePricing.contains(actualComponentPricesPricing));
	}

	public void selectProductName(int rowNum) throws IOException {
		CategoryProductPage sp = new CategoryProductPage(driver);
		log.info("Click on a category name.");
		driver.findElement(By.xpath("//a[@class='submit show']//*[text()='Show All']")).click();
		JavaScriptExec.sleep();
		String productName = BasePage.getCellData(xlsxName, sheetName, 6, rowNum);
		driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + productName + "']")).click();
		navigateBottom();
	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add a Special Day']")
	private WebElement clickAddSpecialButton;

	/**
	 * Method to click on Add a Special Day Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddSpecialButton() throws IOException {
		CategoryProductPage sp = new CategoryProductPage(driver);
		log.info("Click on Add a Special Day Button");
		Assert.assertTrue(clickAddSpecialButton.isDisplayed());
		clickAddSpecialButton.click();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='peakDayTimeType']")
	private WebElement selectPeakInterval;

	/**
	 * Method to select PeakInterval.
	 * 
	 * @throws IOException
	 */
	public void selectPeakInterval(int rowNum) throws IOException {
		CategoryProductPage sp = new CategoryProductPage(driver);
		selectPeakInterval.click();
		Select se = new Select(selectPeakInterval);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 4, rowNum));

	}

	@FindBy(how = How.XPATH, using = "//a[@class='submit add addButton']//*[text()='Add']")
	private WebElement clickAddButton;

	/**
	 * Method to click on Add Button.
	 * 
	 * @throws IOException
	 */
	public void clickAddButton() throws IOException {
		CategoryProductPage sp = new CategoryProductPage(driver);
		log.info("Click on Add  Button");
		Assert.assertTrue(clickAddButton.isDisplayed());
		clickAddButton.click();
	}

	@FindBy(how = How.XPATH, using = "//select[@name='peakDayTime[0].recurring']")
	private WebElement selectisRecurring;

	/**
	 * Method to select PeakInterval.
	 * 
	 * @throws IOException
	 */
	public void selectisRecurring() throws IOException {
		CategoryProductPage sp = new CategoryProductPage(driver);
		selectisRecurring.click();
		Select se = new Select(selectisRecurring);
		se.selectByVisibleText("TRUE");

	}

	@FindBy(how = How.XPATH, using = "//*[@id='isPeak']")
	private WebElement checkIsPeak;

	/**
	 * Method to Check United States Dollar Currency CheckBox.
	 * 
	 * @throws IOException
	 */
	public void checkIsPeak() throws IOException {
		CategoryProductPage sp = new CategoryProductPage(driver);
		log.info("Check Is Peak Checkbox.");
		Assert.assertTrue(checkIsPeak.isDisplayed());
		if (!checkIsPeak.isSelected()) {
			checkIsPeak.click();
		}

	}

	@FindBy(how = How.XPATH, using = "//input[@name='peakDayTime[0].startDate']")
	private WebElement enterStartDate;

	/**
	 * Method to enter start date.
	 * 
	 * @throws IOException
	 */
	public void enterStartDate(int rowNum) throws IOException {
		Assert.assertTrue(enterStartDate.isDisplayed());
		enterStartDate.clear();
		enterStartDate.sendKeys(BasePage.getCellData(xlsxName, sheetName, 11, rowNum));
		JavaScriptExec.mouseclick(driver);
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='peakDayTime[0].endDate']")
	private WebElement enterEndDate;

	/**
	 * Method to End Date.
	 * 
	 * @throws IOException
	 */
	public void enterEndDate(int rowNum) throws IOException {
		Assert.assertTrue(enterEndDate.isDisplayed());
		enterEndDate.clear();
		enterEndDate.sendKeys(BasePage.getCellData(xlsxName, sheetName, 12, rowNum));
		JavaScriptExec.mouseclick(driver);
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//select[@name='peakDayTime[0].dayOfWeek']")
	private WebElement selectDayofWeek;

	/**
	 * Method to select PeakInterval.
	 * 
	 * @throws IOException
	 */
	public void selectDayofWeek(int rowNum) throws IOException {
		CategoryProductPage sp = new CategoryProductPage(driver);
		selectDayofWeek.click();
		Select se = new Select(selectDayofWeek);
		se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 13, rowNum));

	}

	@FindBy(how = How.XPATH, using = "//button[@id='savePeak']")
	private WebElement clickSavePeakButton;

	/**
	 * Method to click on Add Button.
	 * 
	 * @throws IOException
	 */
	public void clickSavePeakButton() throws IOException {
		CategoryProductPage sp = new CategoryProductPage(driver);
		log.info("Click on Add  Button");
		Assert.assertTrue(clickSavePeakButton.isDisplayed());
		clickSavePeakButton.click();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='peakDayTime[0].startTime']")
	private WebElement enterStartTime;

	/**
	 * Method to enter start date.
	 * 
	 * @throws IOException
	 */
	public void enterStartTime() throws IOException {
		Assert.assertTrue(enterStartDate.isDisplayed());
		enterStartTime.clear();
		enterStartTime.sendKeys("09:00");
		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='peakDayTime[0].endTime']")
	private WebElement enterEndTime;

	/**
	 * Method to End Date.
	 * 
	 * @throws IOException
	 */
	public void enterEndTime() throws IOException {
		Assert.assertTrue(enterEndDate.isDisplayed());
		enterEndTime.clear();
		enterEndTime.sendKeys("18:00");
		JavaScriptExec.sleep();
	}

	public void verifyActiveSpecialDaysData(int rowNum) throws IOException {
		int tableRowNo = rowNum + 1;
		String actualAvailabilityStartDate = BasePage.getCellData(xlsxName, sheetName, 14, rowNum);
		String expectedAvailabilityStartDate = driver
				.findElement(By.xpath("//*[@class='dataTable']//*[text()='" + actualAvailabilityStartDate + "']"))
				.getText();
		System.out.println(expectedAvailabilityStartDate);
		Assert.assertEquals(actualAvailabilityStartDate, expectedAvailabilityStartDate);

		String actualAvailabilityEndDate = BasePage.getCellData(xlsxName, sheetName, 15, rowNum);
		String expectedAvailabilityEndDate = driver
				.findElement(By.xpath("//*[@class='dataTable']//*[text()='" + actualAvailabilityEndDate + "']"))
				.getText();
		System.out.println(expectedAvailabilityEndDate);
		Assert.assertEquals(actualAvailabilityEndDate, expectedAvailabilityEndDate);

		String expectedisRecurring = driver.findElement(By.xpath("//*[@class='dataTable']//*[text()='true']"))
				.getText();
		System.out.println(expectedisRecurring);
		Assert.assertEquals("true", expectedisRecurring);
		
		
		String expectedisPeak = "";
		String isPeak = BasePage.getCellData(xlsxName, sheetName, 16, rowNum);
		try {
		WebElement productName = driver.findElement(By.xpath("//*[@class='dataTable']//*[text()='Peak Product2']"));
		if(productName.isDisplayed()) {
			expectedisPeak = driver.findElement(By.xpath(
					"//*[@class='dataTable']//*[text()='"+isPeak+"'][" + tableRowNo + "]"))
					.getText();
		}
		}catch(Exception e) {
		expectedisPeak = driver.findElement(By.xpath("//*[@class='dataTable']//*[text()='" + isPeak + "'][2]"))
					.getText();
		}
		System.out.println(expectedisPeak);
		Assert.assertEquals(isPeak, expectedisPeak);
		
		String actualStartTime = BasePage.getCellData(xlsxName, sheetName, 17, rowNum);
		String expectedStartTime = driver
				.findElement(By.xpath("//*[@class='dataTable']//*[text()='" + actualStartTime + "']")).getText();
		System.out.println(expectedStartTime);
		Assert.assertEquals(actualStartTime, expectedStartTime);

		String actualEndTime = BasePage.getCellData(xlsxName, sheetName, 18, rowNum);
		String expectedEndTime = driver
				.findElement(By.xpath("//*[@class='dataTable']//*[text()='" + actualEndTime + "']")).getText();
		System.out.println(expectedEndTime);
		Assert.assertEquals(actualEndTime, expectedEndTime);
	}

	public void verifyDayofWeek(int rowNum) throws IOException {
		String actualDayofWeek = BasePage.getCellData(xlsxName, sheetName, 13, rowNum);
		String expectedDayofWeek = driver
				.findElement(By.xpath("//*[@class='dataTable']//*[text()='" + actualDayofWeek + "']")).getText();
		System.out.println(expectedDayofWeek);
		Assert.assertEquals(actualDayofWeek, expectedDayofWeek);

	}

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();

	}
}
