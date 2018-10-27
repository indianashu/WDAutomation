package specificPricing;

import baseClassPackage.BaseClasses;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;
import specificPricing.CreateProductAndCategoryPage;


public class CreateProductAndCategoryTest {

	CreateProductAndCategoryPage categoryPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        categoryPage=CreateProductAndCategoryPage.getPage(driver, CreateProductAndCategoryPage.class);
    }
        
        @Test(groups={"Specific Pricing Feature"},description="AddCategory")
        public void userSignin() throws IOException{

        	/*categoryPage.enterLoginID();
        	categoryPage.enterPassword();
        	categoryPage.selectCompany();
        	categoryPage.clickLoginButton();*/
        	
        	categoryPage.clickProductsTab();
        	categoryPage.clickAddCategoryButton();
        	categoryPage.enterCategoryName(0);
        	categoryPage.selectEntity();
        	categoryPage.clickSaveChangesButton();
        	categoryPage.verifyConfirmationMsg();
        	
        	categoryPage.clickProductsTab();
        	categoryPage.selectCategoryName(0);
        	categoryPage.clickAddProductButton();
        	categoryPage.enterEnglishDescription(0);
        	categoryPage.enterProductCode(0);
        	categoryPage.selectEntity();
        	categoryPage.selectPriceCurrency();
        	categoryPage.enterPriceRate(0);
        	categoryPage.clickAddPriceButton();
        	categoryPage.clickSaveChangesButton();
            categoryPage.verifyConfirmationMsg();
            
            categoryPage.clickProductsTab();
        	categoryPage.clickAddCategoryButton();
        	categoryPage.enterCategoryType();
        	categoryPage.enterCategoryName(1);
        	categoryPage.selectEntity();
        	categoryPage.clickSaveChangesButton();
        	categoryPage.verifyConfirmationMsg();
        	
        	categoryPage.clickProductsTab();
        	categoryPage.selectCategoryName(1);
        	categoryPage.clickAddProductButton();
        	categoryPage.enterEnglishDescription(1);
        	categoryPage.enterProductCode(1);
        	categoryPage.selectEntity();
        	categoryPage.selectPriceCurrency();
        	categoryPage.enterPriceRate(1);
        	categoryPage.clickAddPriceButton();
        	categoryPage.enterPlanProduct();
        	categoryPage.enterPricing();
        	categoryPage.clickOnAddPrice();
        	categoryPage.clickSaveChangesButton();
            categoryPage.verifyConfirmationMsg();

    }
}
