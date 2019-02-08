package discount;

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
import discount.DiscountPage;
import tearDown.TearDownProcessPage;
import utilPackages.JavaScriptExec;
import utilPackages.PropertyValExtractors;

public class DiscountPage extends BasePage {
		
		public DiscountPage(WebDriver driver) {
			super(driver);
		}

		Logger log = Logger.getLogger(DiscountPage.class);
		PropertyValExtractors p = new PropertyValExtractors();
		String sheetName = "Discount";
		String xlsxName = "/Discount_TestData.xlsx";

		@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
		private WebElement enterLoginID;

		/**
		 * Method to enter login ID.
		 * 
		 * @throws IOException
		 */
		public void enterLoginID() throws IOException {
			DiscountPage sp = new DiscountPage(driver);

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
			DiscountPage sp = new DiscountPage(driver);
			log.info("Verifying the First Name is available or not");
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
			DiscountPage sp = new DiscountPage(driver);
			Select se = new Select(selectCompany);
			se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 2, 0));

		}

		@FindBy(how = How.XPATH, using = "//a[@class='submit save']")
		private WebElement clickLoginButton;

		/**
		 * Method to Click on Login Button
		 */
		public void clickLoginButton() {
			DiscountPage sp = new DiscountPage(driver);
			log.info("Verifying the login button is available or not");
			Assert.assertTrue(clickLoginButton.isDisplayed());
			clickLoginButton.click();
		}

		@FindBy(how = How.XPATH, using = "//*[@id='menu.link.discounts']/a")
		private WebElement clickDiscountTab;

		/**
		 * Method to click on Products tab after successful login.
		 * 
		 * @throws IOException
		 */
		public void clickDiscountTab() throws IOException {
			DiscountPage sp = new DiscountPage(driver);
			log.info("Click on Discount Tab after successful login");
			Assert.assertTrue(clickDiscountTab.isDisplayed());
			clickDiscountTab.click();
			JavaScriptExec.sleep();
		}

		@FindBy(how = How.XPATH, using = "//a[@class='submit add']//*[text()='Add New']")
		private WebElement clickAddNewButton;

		/**
		 * Method to click on Add New Button.
		 * 
		 * @throws IOException
		 */
		public void clickAddNewButton() throws IOException {
			DiscountPage sp = new DiscountPage(driver);
			log.info("Click on Add New");
			Assert.assertTrue(clickAddNewButton.isDisplayed());
			clickAddNewButton.click();
			JavaScriptExec.sleep();
		}

		@FindBy(how = How.XPATH, using = "//input[@name='discount.descriptions[0].content']")
		private WebElement enterDiscountDescription;

		/**
		 * Method to enter discount description.
		 * 
		 * @throws IOException
		 */
		public void enterDiscountDescription(int rowNum) throws IOException {
			DiscountPage sp = new DiscountPage(driver);
			log.info("Enter Discount Description");
			Assert.assertTrue(enterDiscountDescription.isDisplayed());
			enterDiscountDescription.sendKeys(BasePage.getCellData(xlsxName, sheetName, 3, rowNum));

		}
		@FindBy(how = How.XPATH, using = "//input[@id='discount.code']")
		private WebElement enterDiscountCode;

		/**
		 * Method to enter discount description.
		 * 
		 * @throws IOException
		 */
		public void enterDiscountCode(int rowNum) throws IOException {
			DiscountPage sp = new DiscountPage(driver);
			log.info("Enter Discount Description");
			Assert.assertTrue(enterDiscountCode.isDisplayed());
			enterDiscountCode.sendKeys(BasePage.getCellData(xlsxName, sheetName, 3, rowNum));
			JavaScriptExec.sleep();

		}
		@FindBy(how = How.XPATH, using = "//select[@name='discount.type']")
		private WebElement selectDiscountType;

		/**
		 * Method to select Discount Type.
		 * 
		 * @throws IOException
		 */
		public void selectDiscountType() throws IOException {
			DiscountPage sp = new DiscountPage(driver);
			//selectDiscountType.click();
			Select se = new Select(selectDiscountType);
			se.selectByVisibleText(BasePage.getCellData(xlsxName, sheetName, 4, 0));
			JavaScriptExec.sleep();
		}
		
		@FindBy(how = How.XPATH, using = "//*[@id='discount.attribute.1.value']")
		private WebElement checkPercentage;

		/**
		 * Method to Check United States Dollar Currency CheckBox.
		 * 
		 * @throws IOException
		 */
		public void checkPercentage() throws IOException {
			DiscountPage sp = new DiscountPage(driver);
			log.info("Check United States Dollar Currency Checkbox.");
			Assert.assertTrue(checkPercentage.isDisplayed());
			checkPercentage.click();
			JavaScriptExec.sleep();
		}
		
		@FindBy(how = How.XPATH, using = "//input[@id='discount.attribute.2.value' and contains(@value, 'TIER')]")
		private WebElement selectTierRadioButton;

		/**
		 * Method to click on Add New Button.
		 * 
		 * @throws IOException
		 */
		public void selectTierRadioButton() throws IOException {
			DiscountPage sp = new DiscountPage(driver);
			log.info("Click on Tier Radio Button");
			Assert.assertTrue(selectTierRadioButton.isDisplayed());
			selectTierRadioButton.click();
			JavaScriptExec.sleep();
		}
		
		@FindBy(how = How.XPATH, using = "//input[@id='discount.attribute.2.value' and contains(@value, 'VOLUME')]")
		private WebElement selectVolumeRadioButton;

		/**
		 * Method to click on Add New Button.
		 * 
		 * @throws IOException
		 */
		public void selectVolumeRadioButton() throws IOException {
			DiscountPage sp = new DiscountPage(driver);
			log.info("Click on Volume Radio Button");
			Assert.assertTrue(selectVolumeRadioButton.isDisplayed());
			selectVolumeRadioButton.click();
			JavaScriptExec.sleep();
		}

		public void fillTierData() throws IOException {
			for (int i = 0; i < 5; i++) {

				DiscountPage sp = new DiscountPage(driver);
				WebElement endTier = driver.findElement(By.xpath("//*[@id='discount_usage." + i + ".usageEnd']"));
				endTier.sendKeys(BasePage.getCellData(xlsxName, sheetName, 5, i));

				WebElement enterRate = driver.findElement(By.xpath("//*[@id='discount_usage." + i + ".rate']"));
				enterRate.sendKeys(BasePage.getCellData(xlsxName, sheetName, 6, i));

				WebElement clickOnPlus = driver.findElement(By.xpath("//*[@id='add." + i + "']/img"));
				clickOnPlus.click();
			}
		}

		@FindBy(how = How.XPATH, using = "//a[@class='submit save']//*[text()='Save Changes']")
		private WebElement clickSaveChangesButton;

		/**
		 * Method to click on Save Changes Button.
		 * 
		 * @throws IOException
		 */
		public void clickSaveChangesButton() throws IOException {
			DiscountPage sp = new DiscountPage(driver);
			log.info("Click on Save Changes Button");
			Assert.assertTrue(clickSaveChangesButton.isDisplayed());
			clickSaveChangesButton.click();
		}

		@FindBy(how = How.XPATH, using = "//strong[text()='Done']")
		private WebElement verifyConfirmationMsg;

		/**
		 * Method to verify Discount is created Successfully.
		 * 
		 * @throws IOException
		 */
		public void verifyConfirmationMsg() throws IOException {
			DiscountPage sp = new DiscountPage(driver);
			log.info("Verifying if Discount is created Successfully or not");
			JavaScriptExec.sleep();
			Assert.assertTrue(verifyConfirmationMsg.isDisplayed(),
					"Assert Failed as its unable to search text in Logged in Page");
		}

	public void verifyDiscountName(int rowNum) throws IOException {
		String actualDiscountName = BasePage.getCellData(xlsxName, sheetName, 3, rowNum);
		String expectedDiscountName = driver
				.findElement(By.xpath("//*[@id='column2']//table/tbody/tr[2]/td[2]")).getText();
		System.out.println("Discount Name = "+expectedDiscountName);
		Assert.assertEquals(actualDiscountName, expectedDiscountName);

		WebElement element = driver.findElement(By.xpath("//*[@id='column2']//table/tbody/tr[14]/td[3]"));
		Assert.assertTrue(element.isDisplayed());
		
		String isPercentage = element.getText();
		System.out.println("For Discount" + expectedDiscountName + " the Percentage Rate =" + isPercentage);
		if (isPercentage == "Yes") {
			Assert.assertEquals("Yes", isPercentage);
		}
	}

		@FindBy(how = How.XPATH, using = "//a[@class='submit edit']//*[text()='Edit']")
		private WebElement clickEditButton;

		/**
		 * Method to click on Edit Button.
		 * 
		 * @throws IOException
		 */
		public void clickEditButton() throws IOException {
			DiscountPage sp = new DiscountPage(driver);
			log.info("Click on Edit Button");
			Assert.assertTrue(clickEditButton.isDisplayed());
			clickEditButton.click();
		}

		@FindBy(how = How.XPATH, using = "//input[@name='discount.descriptions[0].content']")
		private WebElement editDiscountName;

		/**
		 * Method to enter Password.
		 * 
		 * @throws IOException
		 */
		public void editDiscountName() throws IOException {
			DiscountPage sp = new DiscountPage(driver);
			log.info("Verifying the Discount Name is available or not");
			Assert.assertTrue(editDiscountName.isDisplayed());
			editDiscountName.clear();
			editDiscountName.sendKeys(BasePage.getCellData(xlsxName, sheetName, 7, 0));
		}

		@FindBy(how = How.XPATH, using = "//a[@class='submit delete']//*[text()='Delete']")
		private WebElement clickDeleteButton;

		/**
		 * Method to click on Edit Button.
		 * 
		 * @throws IOException
		 */
		public void clickDeleteButton() throws IOException {
			DiscountPage sp = new DiscountPage(driver);
			log.info("Click on Delete Button");
			Assert.assertTrue(clickDeleteButton.isDisplayed());
			clickDeleteButton.click();
			JavaScriptExec.sleep();
		}
		
		@FindBy(how = How.XPATH, using = "//button[text()='Yes']")
		private WebElement clickDeleteYesDiscountPopup;

		/**
		 * Method to click on delete customer popup.
		 * 
		 * @throws IOException
		 */
		public void clickDeleteYesDiscountPopup() throws IOException {
			DiscountPage sp = new DiscountPage(driver);
			log.info("click on delete customer popup");
			JavaScriptExec.sleep();
			Assert.assertTrue(clickDeleteYesDiscountPopup.isDisplayed());
			clickDeleteYesDiscountPopup.click();
			JavaScriptExec.sleep();
		}

		public void navigateBottom() {
			JavaScriptExec.scrolltoBottomofPage(driver);
			JavaScriptExec.sleep();
		}
}
