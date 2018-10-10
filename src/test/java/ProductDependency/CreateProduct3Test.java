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

public class CreateProduct3Test {
	
	CreateProduct3Page addProduct3Page;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        addProduct3Page=CreateProduct3Page.getPage(driver, CreateProduct3Page.class);


}
    @Test(groups={"Sanity"},description="Add Edit Product")
    public void userSignin() throws IOException{

    	addProduct3Page.enterLoginID();
    	addProduct3Page.enterPassword();
    	addProduct3Page.selectCompany();
    	addProduct3Page.clickLoginButton();
    	
    	addProduct3Page.clickProductsTab();
    	addProduct3Page.selectCategoryName();
    	addProduct3Page.clickAddProductButton();
    	addProduct3Page.enterEnglishDescription();
    	addProduct3Page.enterProductCode();
    	addProduct3Page.selectStandardAvailability();
    	addProduct3Page.selectAvailableAccountTypes();
    	addProduct3Page.selectCompanies();
    	addProduct3Page.enterPriceDate();
    	addProduct3Page.selectPriceCompany();
    	addProduct3Page.selectPriceCurrency();
    	addProduct3Page.enterPriceRate();
    	addProduct3Page.clickAddPriceButton();
    	addProduct3Page.clickSaveChangesButton();
        addProduct3Page.verifyConfirmationMsg();
}
}






