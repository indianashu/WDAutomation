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

public class CreateDependentProduct3Test {
	
	CreateDependentProduct3Page dependentProduct3Page;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        dependentProduct3Page=CreateDependentProduct3Page.getPage(driver, CreateDependentProduct3Page.class);


}
    @Test(groups={"Sanity"},description="Add Edit Product")
    public void userSignin() throws IOException{

    	dependentProduct3Page.enterLoginID();
    	dependentProduct3Page.enterPassword();
    	dependentProduct3Page.selectCompany();
    	dependentProduct3Page.clickLoginButton();
    	
    	dependentProduct3Page.clickProductsTab();
    	dependentProduct3Page.selectCategoryName();
    	dependentProduct3Page.clickAddProductButton();
    	dependentProduct3Page.enterEnglishDescription();
    	dependentProduct3Page.enterProductCode();
    	dependentProduct3Page.selectStandardAvailability();
    	dependentProduct3Page.selectAvailableAccountTypes();
    	dependentProduct3Page.selectCompanies();
    	dependentProduct3Page.enterPriceDate();
    	dependentProduct3Page.selectPriceCompany();
    	dependentProduct3Page.selectPriceCurrency();
    	dependentProduct3Page.enterPriceRate();
    	dependentProduct3Page.clickAddPriceButton();
    	
    	dependentProduct3Page.clickDependenciesPlus();
        dependentProduct3Page.selectProductCategoryDependency();
        dependentProduct3Page.selectProductPeriod();
        dependentProduct3Page.enterMin();
        dependentProduct3Page.enterMax();
        dependentProduct3Page.clickDependencyPlusIcon();
        
        dependentProduct3Page.clickSaveChangesButton();
        dependentProduct3Page.verifyConfirmationMsg();
        
        
        
}
}

	




