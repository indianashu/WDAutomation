package specificPricing;

import baseClassPackage.BaseClasses;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;
import specificPricing.CreateCategoryPage;


public class CreateCategory1Test {

	CreateCategoryPage categoryPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        categoryPage=CreateCategoryPage.getPage(driver, CreateCategoryPage.class);
    }
        
        @Test(groups={"Specific Pricing Feature"},description="AddCategory")
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
        	categoryPage.enterEnglishDescription();
        	categoryPage.enterProductCode();
        	//categoryPage.selectCompany();
        	categoryPage.selectPriceCurrency();
        	categoryPage.enterPriceRate();
        	categoryPage.clickAddPriceButton();
        	categoryPage.clickSaveChangesButton();
            categoryPage.verifyConfirmationMsg();
            
            categoryPage.clickProductsTab();
        	categoryPage.clickAddCategoryButton();
        	categoryPage.enterCategoryType();
        	categoryPage.enterCategoryName1();
        	categoryPage.selectCompanies();
        	categoryPage.clickSaveChangesButton();
        	categoryPage.verifyConfirmationMsg();
        	
        	categoryPage.clickProductsTab();
        	categoryPage.selectCategoryName1();
        	categoryPage.clickAddProductButton();
        	categoryPage.enterEnglishDescription1();
        	categoryPage.enterProductCode1();
        	//categoryPage.selectCompany();
        	categoryPage.selectPriceCurrency();
        	categoryPage.enterPriceRate1();
        	categoryPage.clickAddPriceButton();
        	categoryPage.enterPlanProduct();
        	categoryPage.enterPricing();
        	categoryPage.clickOnAddPrice();
        	categoryPage.clickSaveChangesButton();
            categoryPage.verifyConfirmationMsg();

    }
}
