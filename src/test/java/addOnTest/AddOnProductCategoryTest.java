package addOnTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import addOn.AddOnProductCategoryPage;
import baseClassPackage.BaseClasses;
import utilPackages.PropertyValExtractors;

public class AddOnProductCategoryTest {
	
	AddOnProductCategoryPage addOnProductCategoryPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        addOnProductCategoryPage = AddOnProductCategoryPage.getPage(driver, AddOnProductCategoryPage.class);

    }
    
    @Test(groups={"Add ON"},description="Add ON Product and Category creation")
    public void userSignin() throws Exception{

    	addOnProductCategoryPage.enterLoginID();
    	addOnProductCategoryPage.enterPassword();
    	addOnProductCategoryPage.selectCompany();
    	addOnProductCategoryPage.clickLoginButton();

    	addOnProductCategoryPage.clickProductsTab();
    	addOnProductCategoryPage.clickAddCategoryButton();
    	addOnProductCategoryPage.enterCategoryName();
    	addOnProductCategoryPage.saveChanges();
    	addOnProductCategoryPage.verifyConfirmationMsg("Item Type Category Saved Successfully");
    	
    	addOnProductCategoryPage.clickProductsTab();
    	addOnProductCategoryPage.clickAddCategoryButton();
    	addOnProductCategoryPage.enterTypeId();
    	addOnProductCategoryPage.enterCategoryName();
    	addOnProductCategoryPage.saveChanges();
    	addOnProductCategoryPage.verifyConfirmationMsg("Add On Type Category Saved Successfully");
    	
    	addOnProductCategoryPage.addProducts();
    	
    	
    }
    
   
    }


