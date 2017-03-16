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


public class orderHierarchiesDependentProductOrderTest {
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

    @Test(groups={"Sanity"},description="Order Hierarchy Dependent Product Order")
    public void userSignin() throws IOException{
/*
    	orderHierarchiesPage.enterLoginID();
    	orderHierarchiesPage.enterPassword();
    	orderHierarchiesPage.selectCompany();
    	orderHierarchiesPage.clickLoginButton();
*/
    	orderHierarchiesPage.clickCustomersTab();
    	orderHierarchiesPage.clickCustomerA();
    	orderHierarchiesPage.clickCreateOrderButton();
    	orderHierarchiesPage.selectOrderPeriod();
    	orderHierarchiesPage.selectOrderType();
    	orderHierarchiesPage.clickProductsSubTab();
    	orderHierarchiesPage.selectProductsSubTab();
//    	orderHierarchiesPage.verifyWarningMsg();
    	orderHierarchiesPage.clickDependencyButton();
    	orderHierarchiesPage.clickDependentProduct();
    	orderHierarchiesPage.clickCurrentOrderButton();
    	orderHierarchiesPage.clickUpdateButton();
    	orderHierarchiesPage.clickSaveChangesButton();
    	orderHierarchiesPage.verifyConfirmationMsg();
    	
    }
    
    @AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }

}
