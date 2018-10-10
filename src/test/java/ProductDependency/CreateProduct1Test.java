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
import categoryProducts.AddProductPage;


public class CreateProduct1Test {
	
	CreateProduct1Page addProduct1Page;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        addProduct1Page=CreateProduct1Page.getPage(driver, CreateProduct1Page.class);


}
    @Test(groups={"Sanity"},description="Add Edit Product")
    public void userSignin() throws IOException{

    	addProduct1Page.enterLoginID();
    	addProduct1Page.enterPassword();
    	addProduct1Page.selectCompany();
    	addProduct1Page.clickLoginButton();
    	
    	addProduct1Page.clickProductsTab();
    	addProduct1Page.selectCategoryName();
    	addProduct1Page.clickAddProductButton();
    	addProduct1Page.enterEnglishDescription();
    	addProduct1Page.enterProductCode();
    	addProduct1Page.selectStandardAvailability();
    	addProduct1Page.selectAvailableAccountTypes();
    	addProduct1Page.selectCompanies();
    	addProduct1Page.enterPriceDate();
    	addProduct1Page.selectPriceCompany();
    	addProduct1Page.selectPriceCurrency();
    	addProduct1Page.enterPriceRate();
    	addProduct1Page.clickAddPriceButton();
    	addProduct1Page.clickSaveChangesButton();
        addProduct1Page.verifyConfirmationMsg();
}
}
