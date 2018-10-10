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

public class CreateDependentProduct2Test {
	
	CreateDependentProduct2Page dependentProduct2Page;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        dependentProduct2Page=CreateDependentProduct2Page.getPage(driver, CreateDependentProduct2Page.class);


}
    @Test(groups={"Sanity"},description="Add Edit Product")
    public void userSignin() throws IOException{

    	dependentProduct2Page.enterLoginID();
    	dependentProduct2Page.enterPassword();
    	dependentProduct2Page.selectCompany();
    	dependentProduct2Page.clickLoginButton();
    	
    	dependentProduct2Page.clickProductsTab();
    	dependentProduct2Page.selectCategoryName();
    	dependentProduct2Page.clickAddProductButton();
    	dependentProduct2Page.enterEnglishDescription();
    	dependentProduct2Page.enterProductCode();
    	dependentProduct2Page.selectStandardAvailability();
    	dependentProduct2Page.selectAvailableAccountTypes();
    	dependentProduct2Page.selectCompanies();
    	dependentProduct2Page.enterPriceDate();
    	dependentProduct2Page.selectPriceCompany();
    	dependentProduct2Page.selectPriceCurrency();
    	dependentProduct2Page.enterPriceRate();
    	dependentProduct2Page.clickAddPriceButton();
    	
    	dependentProduct2Page.clickDependenciesPlus();
        dependentProduct2Page.selectProductCategoryDependency();
        dependentProduct2Page.selectProductPeriod();
        dependentProduct2Page.enterMin();
        dependentProduct2Page.enterMax();
        dependentProduct2Page.clickDependencyPlusIcon();
        
        dependentProduct2Page.clickSaveChangesButton();
        dependentProduct2Page.verifyConfirmationMsg();
        
        
        
}
}

	




