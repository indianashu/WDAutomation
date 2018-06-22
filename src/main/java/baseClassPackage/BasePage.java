package baseClassPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	static Logger log=Logger.getLogger(BasePage.class);
	public WebDriver driver;
	
	public BasePage(WebDriver webdriver){
		this.driver = webdriver;
	}
	
	
	/**
	 * Used for Page factory and the page initialization will be called from Test classes. They will pass the
	 * driver and from this class the driver will be passed to the Page classes, if page factory is not used for 
	 * a method then driver will be initialized in this class constructor and it will be passed to the page classes
	 * 
	 * @param driver
	 * @param Page
	 * @return
	 */
	public static <T> T getPage (WebDriver driver,Class<T> Page){
		log.info("####### Initializing the Pagefactory Model Base class #####");
		return PageFactory.initElements(driver, Page);
	}
	
	 public  static ArrayList<String> ExcelRead(String sheetName, String xlsxName) throws IOException{
	    	

			ArrayList<String> rl=new ArrayList<String>();
			File file=new File(System.getProperty("user.dir") + xlsxName);
			FileInputStream fs=new FileInputStream(file);
			XSSFWorkbook wb=new XSSFWorkbook(fs);
			XSSFSheet sheet=wb.getSheet(sheetName);
			
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

}
