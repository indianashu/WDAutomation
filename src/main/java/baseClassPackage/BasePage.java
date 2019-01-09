package baseClassPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilPackages.JavaScriptExec;

public class BasePage {
	static Logger log = Logger.getLogger(BasePage.class);
	public WebDriver driver;

	public BasePage(WebDriver webdriver) {
		this.driver = webdriver;
	}

	/**
	 * Used for Page factory and the page initialization will be called from Test
	 * classes. They will pass the driver and from this class the driver will be
	 * passed to the Page classes, if page factory is not used for a method then
	 * driver will be initialized in this class constructor and it will be passed to
	 * the page classes
	 * 
	 * @param driver
	 * @param Page
	 * @return
	 */
	public static <T> T getPage(WebDriver driver, Class<T> Page) {
		log.info("####### Initializing the Pagefactory Model Base class #####");
		return PageFactory.initElements(driver, Page);
	}

	public static ArrayList<String> ExcelRead(String sheetName) throws IOException {

		ArrayList<String> rl = new ArrayList<String>();
		File file = new File(System.getProperty("user.dir") + "/Webdata_TestData.xlsx");
		FileInputStream fs = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sheet = wb.getSheet(sheetName);

		Iterator<Row> row = sheet.iterator();
		// System.out.println();
		while (row.hasNext()) {
			Iterator<Cell> cell = row.next().iterator();
			int i = 0;

			while (cell.hasNext()) {

				Cell c1 = cell.next();
				c1.setCellType(c1.CELL_TYPE_STRING);
				String sample = c1.getStringCellValue();
				// log.info("***************************"+sample+"********************");

				rl.add(sample);

			}
			System.out.println(rl);
		}

		return rl;
	}

	public static String getCellData(String xlFilePath, String sheetName, int colNum, int rowNum) throws IOException {

		try {
			File file = new File(System.getProperty("user.dir") + xlFilePath);
			FileInputStream fs = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fs);
			
			XSSFSheet sheet = wb.getSheet(sheetName);
			
			XSSFRow row = sheet.getRow(rowNum);
			XSSFCell cell = row.getCell(colNum);
			
			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
				String cellValue = String.valueOf(cell.getNumericCellValue());
				
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					DateFormat df = new SimpleDateFormat("dd/MM/yy");
					Date date = cell.getDateCellValue();
					cellValue = df.format(date);
				}
				
				return cellValue;
				
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
				
				return "";
			
			else
				return String.valueOf(cell.getBooleanCellValue());
			
		} catch (IOException e) {
			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist  in Excel";
		}
	}
	@FindBy(how = How.XPATH, using = "//div[@class='msg-box successfully']//*[text()='Done']")
	private WebElement verifyConfirmationMsg;
	
	@FindBy(how = How.XPATH, using = "//div[@class='msg-box error']")
	private WebElement verifyErrorMsg;
	
	/**
	 * Method to verify Product is created Successfully.
	 * 
	 * @throws IOException
	 */
		public void verifyConfirmationMsg(String message) throws IOException {
			log.info("Verifying if Product is created Successfully or not");
			JavaScriptExec.sleep();
			try {
				Assert.assertTrue(verifyConfirmationMsg.isDisplayed(),
						message);
				System.out.println(message);
			} catch (NoSuchElementException e) {
				if(verifyErrorMsg.isDisplayed()) {
					String failureMsg = verifyErrorMsg.getText();
					throw new RuntimeException(failureMsg);
				}
			}
	}

}
