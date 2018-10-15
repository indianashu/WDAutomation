package productDependency;

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
import productDependency.CreateDependentCategoryPage;



public class CreateDependentCategoryTest {
	

	CreateDependentCategoryPage dependentProductPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        dependentProductPage=CreateDependentCategoryPage.getPage(driver, CreateDependentCategoryPage.class);


}
    @Test(groups={"Product Dependency Feature"},description="Add Edit Product")
    public void userSignin() throws IOException{

    	/*dependentProductPage.enterLoginID();
    	dependentProductPage.enterPassword();
    	dependentProductPage.selectCompany();
    	dependentProductPage.clickLoginButton();*/
    	
    	dependentProductPage.clickProductsTab();
    	dependentProductPage.clickAddCategoryButton();
    	dependentProductPage.enterCategoryName();
    	dependentProductPage.clickSaveChangesButton();
    	dependentProductPage.verifyConfirmationMsg();
    	
    	dependentProductPage.selectCategoryName();
    	dependentProductPage.clickAddProductButton();
    	dependentProductPage.enterEnglishDescription();
    	dependentProductPage.enterProductCode();
    	dependentProductPage.selectStandardAvailability();
    	dependentProductPage.selectCompanies();
    	dependentProductPage.enterPriceDate();
    	dependentProductPage.selectPriceCompany();
    	dependentProductPage.selectPriceCurrency();
    	dependentProductPage.enterPriceRate();
    	dependentProductPage.clickAddPriceButton();
    	dependentProductPage.clickDependenciesPlus();
    	dependentProductPage.selectProductCategoryDependency();
    	dependentProductPage.selectProductPeriod();
    	dependentProductPage.enterMin();
    	dependentProductPage.clickDependencyPlusIcon();
    	dependentProductPage.clickSaveChangesButton();
    	dependentProductPage.verifyConfirmationMsg();
    	
    	dependentProductPage.clickProductsTab();
    	dependentProductPage.selectCategoryName();
    	dependentProductPage.clickAddProductButton();
    	dependentProductPage.enterEnglishDescription1();
    	dependentProductPage.enterProductCode1();
    	dependentProductPage.selectStandardAvailability();
    	dependentProductPage.selectCompanies();
    	dependentProductPage.enterPriceDate();
    	dependentProductPage.selectPriceCompany();
    	dependentProductPage.selectPriceCurrency();
    	dependentProductPage.enterPriceRate1();
    	dependentProductPage.clickAddPriceButton();
    	dependentProductPage.clickDependenciesPlus();
    	dependentProductPage.selectProductCategoryDependency();
    	dependentProductPage.selectProductPeriod1();
    	dependentProductPage.enterMin1();
    	dependentProductPage.enterMax1();
    	dependentProductPage.clickDependencyPlusIcon();
    	dependentProductPage.clickSaveChangesButton();
    	dependentProductPage.verifyConfirmationMsg();
    	
    	
    	dependentProductPage.clickProductsTab();
    	dependentProductPage.selectCategoryName();
    	dependentProductPage.clickAddProductButton();
    	dependentProductPage.enterEnglishDescription2();
    	dependentProductPage.enterProductCode2();
    	dependentProductPage.selectStandardAvailability();
    	dependentProductPage.selectCompanies();
    	dependentProductPage.enterPriceDate();
    	dependentProductPage.selectPriceCompany();
    	dependentProductPage.selectPriceCurrency();
    	dependentProductPage.enterPriceRate2();
    	dependentProductPage.clickAddPriceButton();
    	dependentProductPage.clickDependenciesPlus();
    	dependentProductPage.selectProductCategoryDependency();
    	dependentProductPage.selectProductPeriod2();
    	dependentProductPage.enterMin2();
    	dependentProductPage.enterMax2();
    	dependentProductPage.clickDependencyPlusIcon();
    	dependentProductPage.clickSaveChangesButton();
    	dependentProductPage.verifyConfirmationMsg();
    	
    	
    	dependentProductPage.clickProductsTab();
    	dependentProductPage.selectCategoryName();
    	dependentProductPage.clickAddProductButton();
    	dependentProductPage.enterEnglishDescription3();
    	dependentProductPage.enterProductCode3();
    	dependentProductPage.selectStandardAvailability();
    	dependentProductPage.selectCompanies();
    	dependentProductPage.enterPriceDate();
    	dependentProductPage.selectPriceCompany();
    	dependentProductPage.selectPriceCurrency();
    	dependentProductPage.enterPriceRate3();
    	dependentProductPage.clickAddPriceButton();
    	dependentProductPage.clickDependenciesPlus();
    	dependentProductPage.selectProductCategoryDependency();
    	dependentProductPage.selectProductDependency1();
    	dependentProductPage.selectProductPeriod3();
    	dependentProductPage.enterMin3();
    	dependentProductPage.clickDependencyPlusIcon();
    	
    	
    	dependentProductPage.selectProductCategoryDependency();
    	dependentProductPage.selectProductDependency2();
    	dependentProductPage.selectProductPeriod4();
    	dependentProductPage.entermin3();
    	dependentProductPage.enterMax3();
    	dependentProductPage.clickDependencyPlusIcon();
    	
    	dependentProductPage.selectProductCategoryDependency();
    	dependentProductPage.selectProductDependency3();
    	dependentProductPage.selectProductPeriod5();
    	dependentProductPage.enterMin4();
    	dependentProductPage.enterMax4();
    	dependentProductPage.clickDependencyPlusIcon();
    	dependentProductPage.clickSaveChangesButton();
    	dependentProductPage.verifyConfirmationMsg();
    	
    	
    	
    	dependentProductPage.clickProductsTab();
    	dependentProductPage.selectCategoryName();
    	dependentProductPage.clickAddProductButton();
    	dependentProductPage.enterEnglishDescription4();
    	dependentProductPage.enterProductCode4();
    	dependentProductPage.selectStandardAvailability();
    	dependentProductPage.selectCompanies();
    	dependentProductPage.enterPriceDate();
    	dependentProductPage.selectPriceCompany();
    	dependentProductPage.selectPriceCurrency();
    	dependentProductPage.enterPriceRate4();
    	dependentProductPage.clickAddPriceButton();
    	dependentProductPage.clickDependenciesPlus();
    	dependentProductPage.selectProductCategoryDependency();
    	dependentProductPage.selectProductDependency1();
    	dependentProductPage.selectProductPeriod3();
    	dependentProductPage.enterMin3();
    	dependentProductPage.clickDependencyPlusIcon();
    	dependentProductPage.clickSaveChangesButton();
    	dependentProductPage.verifyConfirmationMsg();
    	
    	
    	
    	dependentProductPage.clickProductsTab();
    	dependentProductPage.selectCategoryName();
    	dependentProductPage.clickAddProductButton();
    	dependentProductPage.enterEnglishDescription5();
    	dependentProductPage.enterProductCode5();
    	dependentProductPage.selectStandardAvailability();
    	dependentProductPage.selectCompanies();
    	dependentProductPage.enterPriceDate();
    	dependentProductPage.selectPriceCompany();
    	dependentProductPage.selectPriceCurrency();
    	dependentProductPage.enterPriceRate5();
    	dependentProductPage.clickAddPriceButton();
    	dependentProductPage.clickDependenciesPlus();
    	dependentProductPage.selectProductCategoryDependency();
    	dependentProductPage.selectProductDependency2();
    	dependentProductPage.selectProductPeriod4();
    	dependentProductPage.entermin3();
    	dependentProductPage.enterMax4();
    	dependentProductPage.clickDependencyPlusIcon();
    	
    	dependentProductPage.selectProductCategoryDependency();
    	dependentProductPage.selectProductDependency3();
    	dependentProductPage.selectProductPeriod5();
    	dependentProductPage.enterMin5();
    	dependentProductPage.enterMax5();
    	dependentProductPage.clickDependencyPlusIcon();
    	dependentProductPage.clickSaveChangesButton();
    	dependentProductPage.verifyConfirmationMsg();
    	
    	

}
}
