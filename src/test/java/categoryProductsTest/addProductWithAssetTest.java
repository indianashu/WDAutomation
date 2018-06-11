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
import categoryProducts.AddProductWithAssetPage;


public class addProductWithAssetTest {
	AddProductWithAssetPage addProductWithAssetPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        addProductWithAssetPage=AddProductWithAssetPage.getPage(driver, AddProductWithAssetPage.class);

    }

    @Test(groups={"Sanity"},description="Add Product with Asset")
    public void userSignin() throws IOException{

    	/*addProductWithAssetPage.enterLoginID();
    	addProductWithAssetPage.enterPassword();
    	addProductWithAssetPage.selectCompany();
    	addProductWithAssetPage.clickLoginButton();*/
    	
    	addProductWithAssetPage.clickPluginsLink();
    	addProductWithAssetPage.clickCategory17();
    	addProductWithAssetPage.clickAddNewButton();
    	addProductWithAssetPage.selectTypeId();
    	addProductWithAssetPage.clickSavePluginButton();
    	addProductWithAssetPage.clickProductsTab();
    	addProductWithAssetPage.selectCategoryName();
    	addProductWithAssetPage.clickAddProductButton();
    	addProductWithAssetPage.enterEnglishDescription();
    	addProductWithAssetPage.enterProductCode();
    	addProductWithAssetPage.clickGlobalCheckbox();
    	addProductWithAssetPage.selectAllowAssetManagement();
    	addProductWithAssetPage.enterPriceRate();
    	addProductWithAssetPage.clickAddPriceButton();
		addProductWithAssetPage.navigateBottom();
    	addProductWithAssetPage.clickSaveChangesButton();
    	addProductWithAssetPage.verifyConfirmationMsg();
    	addProductWithAssetPage.clickProductName();
		addProductWithAssetPage.navigateBottom();
    	addProductWithAssetPage.clickAddAssetButton();
    	addProductWithAssetPage.enterIdentifier1();
    	addProductWithAssetPage.checkIsGlobal();
    	addProductWithAssetPage.enterTaxID();
    	addProductWithAssetPage.clickSaveChangesButton();
    	addProductWithAssetPage.verifyConfirmationMsg();
    	addProductWithAssetPage.clickAddNewButton();
    	addProductWithAssetPage.enterIdentifier2();
    	addProductWithAssetPage.checkIsGlobal();
    	addProductWithAssetPage.enterTaxID1();
    	addProductWithAssetPage.clickSaveChangesButton();
    	addProductWithAssetPage.verifyConfirmationMsg();
    }

    @AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }

}

