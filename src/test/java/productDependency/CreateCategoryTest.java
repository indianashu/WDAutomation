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

    	categoryPage.enterLoginID();
    	categoryPage.enterPassword();
    	categoryPage.selectCompany();
    	categoryPage.clickLoginButton();
    	
    	/*categoryPage.clickProductsTab();
    	categoryPage.clickAddCategoryButton();
    	categoryPage.enterCategoryName();
    	categoryPage.selectCompanies();
    	categoryPage.clickSaveChangesButton();
    	categoryPage.verifyConfirmationMsg();*/
    	
    	categoryPage.clickProductsTab();
    	categoryPage.selectCategoryName();
    	categoryPage.clickAddProductButton();
    	categoryPage.enterEnglishDescription();
    	categoryPage.enterProductCode();
    	categoryPage.selectCompany1();
    	categoryPage.selectPriceCurrency();
    	categoryPage.enterPriceRate();
    	categoryPage.clickAddPriceButton();
    	categoryPage.clickSaveChangesButton();
        categoryPage.verifyConfirmationMsg();
        
        categoryPage.clickProductsTab();
    	categoryPage.selectCategoryName();
    	categoryPage.clickAddProductButton();
    	categoryPage.enterEnglishDescription1();
    	categoryPage.enterProductCode1();
    	categoryPage.selectCompany1();
    	categoryPage.selectPriceCurrency();
    	categoryPage.enterPriceRate1();
    	categoryPage.clickAddPriceButton();
    	categoryPage.clickSaveChangesButton();
        categoryPage.verifyConfirmationMsg();
        
        categoryPage.clickProductsTab();
    	categoryPage.selectCategoryName();
    	categoryPage.clickAddProductButton();
    	categoryPage.enterEnglishDescription2();
    	categoryPage.enterProductCode2();
    	categoryPage.selectCompany1();
    	categoryPage.selectPriceCurrency();
    	categoryPage.enterPriceRate2();
    	categoryPage.clickAddPriceButton();
    	categoryPage.clickSaveChangesButton();
        categoryPage.verifyConfirmationMsg();
    }
}