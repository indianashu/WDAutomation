package addOn;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import baseClassPackage.BasePage;
import orderHierarchies.OrderHierarchiesPage;
import utilPackages.JavaScriptExec;
import utilPackages.PropertyValExtractors;
import utilPackages.WaitClass;

public class AddOnProductCategoryPage extends BasePage {

	public AddOnProductCategoryPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(AddOnProductCategoryPage.class);
	String sheetName = "AddProductCategory1";
	String xlsxName = "/AddOn_TestData.xlsx";
	Actions actions = new Actions(driver);

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws Exception
	 */
	public void enterLoginID() throws Exception {
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
		log.info("Verifying the First Name is available or not");
		Assert.assertTrue(enterPassword.isDisplayed());
		enterPassword.sendKeys(BasePage.getCellData(xlsxName, sheetName, 1, 0));

	}

	public void selectCompany() throws Exception {
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
		log.info("Verifying the login button is available or not");
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
		log.info("Click on Add Category Button");
		navigateBottom();
		Assert.assertTrue(clickAddCategoryButton.isDisplayed());
		clickAddCategoryButton.click();

	}

	@FindBy(how = How.XPATH, using = "//*[@name='orderLineTypeId']")
	private WebElement enterTypeId;

	/**
	 * Method to Enter Order Line typeId.
	 * 
	 * @throws IOException
	 */
	public void enterTypeId() throws IOException {
		log.info("Enter Order Line typeId");
		Select se = new Select(enterTypeId);
		se.selectByVisibleText("Add On");

		JavaScriptExec.sleep();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='description']")
	private WebElement enterCategoryName;

	/**
	 * Method to Enter Category Name.
	 * 
	 * @throws IOException
	 */
	public void enterCategoryName() throws IOException {
		log.info("Enter Category Name");

		WebElement element = (new WebDriverWait(driver, 9))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='orderLineTypeId']/option[1]")));
		if (element.isSelected()) {

			enterCategoryName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 3, 0));

		} else {

			enterCategoryName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 3, 1));
		}
	}

	public void addProducts() throws IOException {

		for (int i = 0; i <= 1; i++) {
			int column = 3;

			log.info("Click on a category name.");
			JavaScriptExec.sleep();
			String CategoryName = BasePage.getCellData(xlsxName, sheetName, column, i);
			driver.findElement(By.xpath("//a[@class='cell double']//*[text()='" + CategoryName + "']")).click();

			log.info("Click on Add Product Button");
			JavaScriptExec.sleep();
			WebElement clickAddProductButton = driver
					.findElement(By.xpath("//a[@class='submit add']//*[text()='Add Product']"));
			Assert.assertTrue(clickAddProductButton.isDisplayed());
			clickAddProductButton.click();

			log.info("Enter English Description");
			WebElement enterEnglishDescription = driver
					.findElement(By.xpath("//input[@name='product.descriptions[0].content']"));
			Assert.assertTrue(enterEnglishDescription.isDisplayed());
			enterEnglishDescription.sendKeys(BasePage.getCellData(xlsxName, sheetName, column+1, i));

			log.info("Enter Product Code");
			WebElement enterProductCode = driver.findElement(By.xpath("//input[@name='product.number']"));
			Assert.assertTrue(enterProductCode.isDisplayed());
			enterProductCode.sendKeys(BasePage.getCellData(xlsxName, sheetName, column+2, i));

			log.info("Enter Price Date");
			WebElement enterPastPriceDate = driver.findElement(By.xpath("//*[@name='mydate']"));
			Assert.assertTrue(enterPastPriceDate.isDisplayed());
			enterPastPriceDate.clear();
			enterPastPriceDate.sendKeys(BasePage.getCellData(xlsxName, sheetName, 7, 0));
			JavaScriptExec.sleep();
			
			log.info("Enter Price Currency");
			WebElement enterPriceCurrency = driver.findElement(By.xpath("//*[@name='product.currencies']"));
			Assert.assertTrue(enterPriceCurrency.isDisplayed());
			Select select = new Select(enterPriceCurrency);
			select.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 8, 0));
			JavaScriptExec.sleep();

			log.info("Enter Price Rate");
			if (i == 0) {
				WebElement enterPriceRate = driver.findElement(By.xpath("//input[@name='product.rate']"));
				Assert.assertTrue(enterPriceRate.isDisplayed());
				enterPriceRate.sendKeys(BasePage.getCellData(xlsxName, sheetName, column+3, 0));
				clickAddPriceButton();
				saveChanges();
				verifyConfirmationMsg("Item Type Product Saved Successfully");
			} else {

				WebElement enterPriceRate = driver.findElement(By.xpath("//input[@name='product.rate']"));
				Assert.assertTrue(enterPriceRate.isDisplayed());
				enterPriceRate.clear();
				enterPriceRate.sendKeys(BasePage.getCellData(xlsxName, sheetName, column+3, 1));

				clickAddPriceButton();
				
				navigateBottom();
				WebElement selectCategory = driver.findElement(By.xpath("//select[@id='itemBundleItemType']"));
				selectCategory.click();
				Select se = new Select(selectCategory);
				se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 3, 0));

				WebElement selectProduct = driver.findElement(By.xpath("//*[@id='itemBundle']"));
				selectProduct.click();
				Select sel = new Select(selectProduct);
				sel.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 4, 0));

				WebElement freeUnits = driver.findElement(By.xpath("//input[@id='freeUnits']"));
				freeUnits.sendKeys("100");

				WebElement selectUnitt = driver.findElement(By.xpath("//*[@id='freeUnitType']"));
				selectUnitt.click();
				Select sel1 = new Select(selectUnitt);
				sel1.selectByVisibleText("Units");

				WebElement clickAddOnPlusIcon = driver
						.findElement(By.xpath("//*[@id='addon']/div[2]/div/div[2]/table/tbody/tr/td[7]/div/div/a/img"));
				log.info("click on Add On plus icon to add the product.");
				JavaScriptExec.sleep();
				Assert.assertTrue(clickAddOnPlusIcon.isDisplayed());
				clickAddOnPlusIcon.click();
				
				saveChanges();
				verifyConfirmationMsg("Add On Type Product Saved Successfully");

			}
			
		}
			
			
	}

	public void clickAddPriceButton() throws IOException {
		WebElement clickAddPriceButton = driver
				.findElement(By.xpath("//a[@class='submit add']//*[text()='Add Price']"));
		Assert.assertTrue(clickAddPriceButton.isDisplayed());
		actions.moveToElement(clickAddPriceButton).click().perform();
	}

	public void saveChanges() throws IOException {
		navigateBottom();

		WebElement clickSaveChangesButton = driver
				.findElement(By.xpath("//a[@class='submit save']//*[text()='Save Changes']"));
		log.info("Click on Save Changes Button");
		Assert.assertTrue(clickSaveChangesButton.isDisplayed());
		clickSaveChangesButton.click();

	}
		

	public void navigateBottom() {
		JavaScriptExec.scrolltoBottomofPage(driver);
		JavaScriptExec.sleep();
	}

}
