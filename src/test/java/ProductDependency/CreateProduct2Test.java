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


public class CreateProduct2Test {
	
	
		CreateProduct2Page addProduct2Page;
	    WebDriver driver,driver2;

	    @BeforeClass(alwaysRun=true)
	    public void setup(){
	        driver= BaseClasses.setup( "User1");
	        PropertyValExtractors p=new PropertyValExtractors();
	        p.getPropertyFile("test", "configuration.properties");
	        String url=p.getVal("url1");
	        driver.get(url);
	        //WaitClass.waitForUrl(driver, url, 10);
	        addProduct2Page=CreateProduct2Page.getPage(driver, CreateProduct2Page.class);


	}
	    @Test(groups={"Sanity"},description="Add Edit Product")
	    public void userSignin() throws IOException{

	    	addProduct2Page.enterLoginID();
	    	addProduct2Page.enterPassword();
	    	addProduct2Page.selectCompany();
	    	addProduct2Page.clickLoginButton();
	    	
	    	addProduct2Page.clickProductsTab();
	    	addProduct2Page.selectCategoryName();
	    	addProduct2Page.clickAddProductButton();
	    	addProduct2Page.enterEnglishDescription();
	    	addProduct2Page.enterProductCode();
	    	addProduct2Page.selectStandardAvailability();
	    	addProduct2Page.selectAvailableAccountTypes();
	    	addProduct2Page.selectCompanies();
	    	addProduct2Page.enterPriceDate();
	    	addProduct2Page.selectPriceCompany();
	    	addProduct2Page.selectPriceCurrency();
	    	addProduct2Page.enterPriceRate();
	    	addProduct2Page.clickAddPriceButton();
	    	addProduct2Page.clickSaveChangesButton();
	        addProduct2Page.verifyConfirmationMsg();
	}
	}



