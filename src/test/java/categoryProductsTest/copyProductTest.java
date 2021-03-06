package categoryProductsTest;

import baseClassPackage.BaseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;
import utilPackages.WaitClass;
import categoryProducts.CopyProductPage;


public class copyProductTest {
	CopyProductPage copyProductPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
       //WaitClass.waitForUrl(driver, url, 10);
        copyProductPage=CopyProductPage.getPage(driver, CopyProductPage.class);

    }

    @Test(groups={"Sanity"},description="Copy Product")
    public void userSignin() throws IOException{

    	/*copyProductPage.enterLoginID();
    	copyProductPage.enterPassword();
    	copyProductPage.selectCompany();
    	copyProductPage.clickLoginButton();*/

    	copyProductPage.clickProductsTab();
    	copyProductPage.clickAddCategoryButton();
    	copyProductPage.enterCategoryName();
    	copyProductPage.clickSaveChangesButton();
    	copyProductPage.verifyConfirmationMsg("Saved Category Successfully");
    	//copyProductPage.selectCategoryName();
    	copyProductPage.clickAddProductButton();
    	copyProductPage.enterEnglishDescription();
    	copyProductPage.enterProductCode();
    	copyProductPage.selectCompanies();
		copyProductPage.navigateBottom();
    	copyProductPage.enterPriceDate();
    	copyProductPage.selectPriceCompany();
    	copyProductPage.selectPriceCurrency();
    	copyProductPage.enterPriceRate();
    	copyProductPage.clickAddPriceButton();
    	copyProductPage.clickSaveChangesButton();
    	copyProductPage.verifyConfirmationMsg("Saved Product Successfully");
    	//copyProductPage.clickProductsTab();
    	//copyProductPage.selectCopyCategory();
    	copyProductPage.selectProduct();
    	copyProductPage.clickCopyProductButton();
		copyProductPage.navigateBottom();
    	copyProductPage.enterPriceRate1();
    	copyProductPage.clickAddPriceButton();
    	copyProductPage.clickSaveChangesButton();
    	copyProductPage.verifyConfirmationMsg("Product Copied Successfully");
    	
    	
    	
    }
    
    @AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }

}
