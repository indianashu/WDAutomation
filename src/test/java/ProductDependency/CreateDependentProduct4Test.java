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

public class CreateDependentProduct4Test {
	
	CreateDependentProduct4Page dependentProduct4Page;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        dependentProduct4Page=CreateDependentProduct4Page.getPage(driver, CreateDependentProduct4Page.class);


}
    @Test(groups={"Sanity"},description="Add Edit Product")
    public void userSignin() throws IOException{

    	dependentProduct4Page.enterLoginID();
    	dependentProduct4Page.enterPassword();
    	dependentProduct4Page.selectCompany();
    	dependentProduct4Page.clickLoginButton();
    	
    	dependentProduct4Page.clickProductsTab();
    	dependentProduct4Page.selectCategoryName();
    	dependentProduct4Page.clickAddProductButton();
    	dependentProduct4Page.enterEnglishDescription();
    	dependentProduct4Page.enterProductCode();
    	dependentProduct4Page.selectStandardAvailability();
    	dependentProduct4Page.selectAvailableAccountTypes();
    	dependentProduct4Page.selectCompanies();
    	dependentProduct4Page.enterPriceDate();
    	dependentProduct4Page.selectPriceCompany();
    	dependentProduct4Page.selectPriceCurrency();
    	dependentProduct4Page.enterPriceRate();
    	dependentProduct4Page.clickAddPriceButton();
    	
    	dependentProduct4Page.clickDependenciesPlus();
        dependentProduct4Page.selectProductCategoryDependency();
        dependentProduct4Page.selectProductDependency();
        dependentProduct4Page.selectProductPeriod();
        dependentProduct4Page.enterMin();
        dependentProduct4Page.clickDependencyPlusIcon();
        
        dependentProduct4Page.selectProductCategoryDependency1();
        dependentProduct4Page.selectProductDependency1();
        dependentProduct4Page.selectProductPeriod1();
        dependentProduct4Page.enterMax1();
        dependentProduct4Page.clickDependencyPlusIcon();
        
        dependentProduct4Page.selectProductCategoryDependency2();
        dependentProduct4Page.selectProductDependency2();
        dependentProduct4Page.selectProductPeriod2();
        dependentProduct4Page.enterMin();
        dependentProduct4Page.enterMax2();
        dependentProduct4Page.clickDependencyPlusIcon();
        
        dependentProduct4Page.clickSaveChangesButton();
        dependentProduct4Page.verifyConfirmationMsg();
        
        
        
}
}

	







