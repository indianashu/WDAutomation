package productDependency;

import baseClassPackage.BaseClasses;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;
import productDependency.CreateCategoryPage;



public class CreateCategoryTest {
	CreateCategoryPage categoryPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        categoryPage=CreateCategoryPage.getPage(driver, CreateCategoryPage.class);

    }

    @Test(groups={"Product Dependency Feature"},description="AddCategory")
    public void userSignin() throws IOException{

    	/*categoryPage.enterLoginID();
    	categoryPage.enterPassword();
    	categoryPage.selectCompany();
    	categoryPage.clickLoginButton();*/
    	
    	categoryPage.clickProductsTab();
    	categoryPage.clickAddCategoryButton();
    	categoryPage.enterCategoryName();
    	categoryPage.selectCompanies();
    	categoryPage.clickSaveChangesButton();
    	categoryPage.verifyConfirmationMsg();
    	
    	categoryPage.clickProductsTab();
    	categoryPage.selectCategoryName();
    	categoryPage.clickAddProductButton();
    	categoryPage.enterEnglishDescription(0);
    	categoryPage.enterProductCode(0);
    	categoryPage.selectItemCompany();
    	categoryPage.selectPriceCompany();
    	categoryPage.selectPriceCurrency();
    	categoryPage.enterPriceRate(0);
    	categoryPage.clickAddPriceButton();
    	categoryPage.clickSaveChangesButton();
        categoryPage.verifyConfirmationMsg();
        
        categoryPage.clickProductsTab();
    	categoryPage.selectCategoryName();
    	categoryPage.clickAddProductButton();
    	categoryPage.enterEnglishDescription(1);
    	categoryPage.enterProductCode(1);
    	categoryPage.selectItemCompany();
    	categoryPage.selectPriceCompany();
    	categoryPage.selectPriceCurrency();
    	categoryPage.enterPriceRate(1);
    	categoryPage.clickAddPriceButton();
    	categoryPage.clickSaveChangesButton();
        categoryPage.verifyConfirmationMsg();
        
        categoryPage.clickProductsTab();
    	categoryPage.selectCategoryName();
    	categoryPage.clickAddProductButton();
    	categoryPage.enterEnglishDescription(2);
    	categoryPage.enterProductCode(2);
    	categoryPage.selectItemCompany();
    	categoryPage.selectPriceCompany();
    	categoryPage.selectPriceCurrency();
    	categoryPage.enterPriceRate(2);
    	categoryPage.clickAddPriceButton();
    	categoryPage.clickSaveChangesButton();
        categoryPage.verifyConfirmationMsg();
    }
}