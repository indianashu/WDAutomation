package orderHierarchiesTest;

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
import orderHierarchies.OrderHierarchiesPage;


public class orderHierarchiesDependentProductCreationTest {
	OrderHierarchiesPage orderHierarchiesPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        orderHierarchiesPage=OrderHierarchiesPage.getPage(driver, OrderHierarchiesPage.class);

    }

    @Test(groups={"Sanity"},description="Order Hierarchy Dependent Product Creation")
    public void userSignin() throws IOException{

    	/*orderHierarchiesPage.enterLoginID();
    	orderHierarchiesPage.enterPassword();
    	orderHierarchiesPage.selectCompany();
    	orderHierarchiesPage.clickLoginButton();*/

    	orderHierarchiesPage.clickProductsTab();
    	orderHierarchiesPage.clickAddCategoryButton();
    	orderHierarchiesPage.enterProductCategoryName();
		orderHierarchiesPage.clickSaveChangesButton();
    	orderHierarchiesPage.clickProductCategory();
    	orderHierarchiesPage.clickAddProductButton();
    	orderHierarchiesPage.enterEnglishDescription();
    	orderHierarchiesPage.enterProductCode();
    	orderHierarchiesPage.selectPriceCurrency();
    	orderHierarchiesPage.enterProductRate();
		orderHierarchiesPage.clickAddPriceButton();
    	orderHierarchiesPage.clickSaveChangesButton();
    	orderHierarchiesPage.verifyConfirmationMsg();
    	orderHierarchiesPage.clickProductCategory();
    	orderHierarchiesPage.clickAddProductButton();
    	orderHierarchiesPage.enterEnglishDescription1();
    	orderHierarchiesPage.enterProductCode1();
    	orderHierarchiesPage.selectPriceCurrency();
		orderHierarchiesPage.navigateBottom();
    	orderHierarchiesPage.enterProducteRate1();
		orderHierarchiesPage.clickAddPriceButton();
    	orderHierarchiesPage.clickDependenciesPlus();
    	orderHierarchiesPage.selectProductCategoryDependency();
    	orderHierarchiesPage.selectProductDependency();
    	orderHierarchiesPage.selectProductPeriod();
    	orderHierarchiesPage.clickDependencyPlusIcon();
    	orderHierarchiesPage.clickSaveChangesButton();
    	orderHierarchiesPage.verifyConfirmationMsg();
    	
    }
    
    @AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }

}
