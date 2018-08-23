package categoryProductsTest;

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


public class addEditProductTest {
	AddProductPage addProductPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        addProductPage=AddProductPage.getPage(driver, AddProductPage.class);

    }

    @Test(groups={"Sanity"},description="Add Edit Product")
    public void userSignin() throws IOException{

    	/*addProductPage.enterLoginID();
    	addProductPage.enterPassword();
    	addProductPage.selectCompany();
    	addProductPage.clickLoginButton();*/

        addProductPage.clickProductsTab();
        addProductPage.selectCategoryName();
        addProductPage.clickAddProductButton();
        addProductPage.enterEnglishDescription();
        addProductPage.enterProductCode();
        addProductPage.selectStandardAvailability();
        addProductPage.selectAvailableAccountTypes();
        addProductPage.selectCompanies();
        addProductPage.navigateBottom();
        addProductPage.enterPriceDate();
        addProductPage.selectPriceCompany();
        addProductPage.selectPriceCurrency();
        addProductPage.enterPriceRate();
        addProductPage.clickAddPriceButton();
        addProductPage.enterPriceDate1();
        addProductPage.selectPriceCompany();
        addProductPage.selectPriceCurrency();
        addProductPage.enterPriceRate1();
        addProductPage.clickAddPriceButton();
        addProductPage.clickSaveChangesButton();
        addProductPage.verifyConfirmationMsg();
        addProductPage.clickProductsTab();
        addProductPage.selectCategoryName();
        addProductPage.clickAddProductButton();
        addProductPage.enterEnglishDescription3();
        addProductPage.enterProductCode3();
        addProductPage.selectCompanies();
        addProductPage.navigateBottom();
        addProductPage.enterPriceDate();
        addProductPage.selectPriceCompany();
        addProductPage.selectPriceCurrency();
        addProductPage.enterPriceRate3();
        addProductPage.clickAddPriceButton();
        addProductPage.clickSaveChangesButton();
        addProductPage.verifyConfirmationMsg();
        addProductPage.selectCategoryName();
        addProductPage.clickProductName();
        addProductPage.navigateBottom();
        addProductPage.clickEditProduct();
        addProductPage.editEnglishDescription();
        addProductPage.editProductCode();
        addProductPage.navigateBottom();
        addProductPage.clickSaveChangesButton();

    }
    
    @AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }

}

