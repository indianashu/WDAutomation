package ProductDependency;

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
import categoryProducts.ProductCategoryPage;



public class CreateCategoryTest {
	CreateCategoryPage categoryPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        categoryPage=CreateCategoryPage.getPage(driver, CreateCategoryPage.class);

    }

    @Test(groups={"Sanity"},description="Add Edit Category")
    public void userSignin() throws IOException{

    	categoryPage.enterLoginID();
    	categoryPage.enterPassword();
    	categoryPage.selectCompany();
    	categoryPage.clickLoginButton();
    	
    	categoryPage.clickProductsTab();
    	categoryPage.clickAddCategoryButton();
    	categoryPage.enterCategoryName();
    	categoryPage.clickSaveChangesButton();
    	categoryPage.verifyConfirmationMsg();
    	
    	categoryPage.clickProductsTab();
    	categoryPage.selectCategoryName();
    	categoryPage.clickAddProductButton();
    	categoryPage.enterEnglishDescription();
    	categoryPage.enterProductCode();
    	categoryPage.selectStandardAvailability();
    	
    	categoryPage.enterPriceDate();
    	categoryPage.selectPriceCompany();
    	categoryPage.selectPriceCurrency();
    	categoryPage.enterPriceRate();
    	categoryPage.clickAddPriceButton();
    	categoryPage.clickSaveChangesButton();
        categoryPage.verifyConfirmationMsg();
        
        categoryPage.clickProductsTab();
    	categoryPage.selectCategoryName();
    	categoryPage.clickAddProductButton();
    	categoryPage.enterEnglishDescription1();
    	categoryPage.enterProductCode1();
    	categoryPage.selectStandardAvailability();
    	
    	categoryPage.enterPriceDate();
    	categoryPage.selectPriceCompany();
    	categoryPage.selectPriceCurrency();
    	categoryPage.enterPriceRate1();
    	categoryPage.clickAddPriceButton();
    	categoryPage.clickSaveChangesButton();
        categoryPage.verifyConfirmationMsg();
    	
        categoryPage.clickProductsTab();
    	categoryPage.selectCategoryName();
    	categoryPage.clickAddProductButton();
    	categoryPage.enterEnglishDescription2();
    	categoryPage.enterProductCode2();
    	categoryPage.selectStandardAvailability();
    	
    	categoryPage.enterPriceDate();
    	categoryPage.selectPriceCompany();
    	categoryPage.selectPriceCurrency();
    	categoryPage.enterPriceRate2();
    	categoryPage.clickAddPriceButton();
    	categoryPage.clickSaveChangesButton();
        categoryPage.verifyConfirmationMsg();
    	
    	
    	 
    }
}