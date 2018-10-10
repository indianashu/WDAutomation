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


public class CreateDependentProduct1Test {
	
	CreateDependentProduct1Page dependentProduct1Page;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        dependentProduct1Page=CreateDependentProduct1Page.getPage(driver, CreateDependentProduct1Page.class);


}
    @Test(groups={"Sanity"},description="Add Edit Product")
    public void userSignin() throws IOException{

    	dependentProduct1Page.enterLoginID();
    	dependentProduct1Page.enterPassword();
    	dependentProduct1Page.selectCompany();
    	dependentProduct1Page.clickLoginButton();
    	
    	dependentProduct1Page.clickProductsTab();
    	dependentProduct1Page.selectCategoryName();
    	dependentProduct1Page.clickAddProductButton();
    	dependentProduct1Page.enterEnglishDescription();
    	dependentProduct1Page.enterProductCode();
    	dependentProduct1Page.selectStandardAvailability();
    	dependentProduct1Page.selectAvailableAccountTypes();
    	dependentProduct1Page.selectCompanies();
    	dependentProduct1Page.enterPriceDate();
    	dependentProduct1Page.selectPriceCompany();
    	dependentProduct1Page.selectPriceCurrency();
    	dependentProduct1Page.enterPriceRate();
    	dependentProduct1Page.clickAddPriceButton();
    	
    	dependentProduct1Page.clickDependenciesPlus();
        dependentProduct1Page.selectProductCategoryDependency();
        dependentProduct1Page.selectProductPeriod();
        dependentProduct1Page.enterMin();
        dependentProduct1Page.clickDependencyPlusIcon();
        
        dependentProduct1Page.clickSaveChangesButton();
        dependentProduct1Page.verifyConfirmationMsg();
        
        
        
}
}

	

