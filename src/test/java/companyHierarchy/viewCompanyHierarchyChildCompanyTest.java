package companyHierarchy;

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
import companyHierarchy.ViewAssignedInfoPage;


public class viewCompanyHierarchyChildCompanyTest {
	ViewAssignedInfoPage viewAssignedInfoPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        viewAssignedInfoPage=ViewAssignedInfoPage.getPage(driver, ViewAssignedInfoPage.class);

    }

    @Test(groups={"Sanity"},description="Verify that Root Company has ability to impersonate Child Company and view all & only information assigned to Child Company.")
    public void userSignin() throws IOException{
    	

    	/*viewAssignedInfoPage.enterLoginID();
    	viewAssignedInfoPage.enterPassword();
    	viewAssignedInfoPage.selectCompany();
    	viewAssignedInfoPage.clickLoginButton();*/

    	viewAssignedInfoPage.clickImpersonate();
    	viewAssignedInfoPage.selectChildCompany();
    	viewAssignedInfoPage.clickSelectButton();
    	viewAssignedInfoPage.verifyChildCompanyName();
    	viewAssignedInfoPage.clickProductsTab();
    	viewAssignedInfoPage.clickCategoryName();
    	viewAssignedInfoPage.clickProductName();
    	viewAssignedInfoPage.clickShowAssetsButton();
    	viewAssignedInfoPage.verifyAssetName();
    	viewAssignedInfoPage.verifyAssetName1();
    	viewAssignedInfoPage.clickRedCross();
    	viewAssignedInfoPage.clickCustomersTab();
    	viewAssignedInfoPage.verifyChildCustomer(); 

    }
    
    @AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }

}