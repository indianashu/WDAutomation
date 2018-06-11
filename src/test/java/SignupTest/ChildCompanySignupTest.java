package SignupTest;

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
import webDataPages.SignupChildCompanyPage;

public class ChildCompanySignupTest {
	SignupChildCompanyPage signupChildCompanyPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        signupChildCompanyPage=SignupChildCompanyPage.getPage(driver, SignupChildCompanyPage.class);


    }

    @Test(groups={"Sanity"},description="Child Company Sign up new company")
    public void userSignin() throws IOException{

    	/*signupChildCompanyPage.enterLoginID();
    	signupChildCompanyPage.enterPassword();
    	signupChildCompanyPage.selectCompany();
    	signupChildCompanyPage.clickLoginButton();
    	signupChildCompanyPage.verifyLabelSuccessfulLogin();*/

    	signupChildCompanyPage.enterURL();
    	signupChildCompanyPage.labelRootCompany();
    	signupChildCompanyPage.enterLoginName();
    	signupChildCompanyPage.enterFirstName();
    	signupChildCompanyPage.enterLastName();
    	signupChildCompanyPage.enterPhoneCountryCode();
    	signupChildCompanyPage.enterPhoneAreaCode();
    	signupChildCompanyPage.enterPhoneAreaCode();
    	signupChildCompanyPage.enterPhoneNumber();
    	signupChildCompanyPage.enterEmail();
    	signupChildCompanyPage.selectLanguage();
    	signupChildCompanyPage.selectCurrency();
    	signupChildCompanyPage.enterOrgName();
    	signupChildCompanyPage.enterAddress();
    	signupChildCompanyPage.enterAddress2();
    	signupChildCompanyPage.enterCity();
    	signupChildCompanyPage.enterStateProvince();
    	signupChildCompanyPage.selectCountry();
    	signupChildCompanyPage.enterZipCode();
    	signupChildCompanyPage.clickSaveChangesButton();

    }
    @AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }

}