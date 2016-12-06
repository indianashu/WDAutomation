package SignupTest;

/**
 * Created by ashutosh on 07/10/16.
 */
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
import webDataPages.SignupPage;

public class SignupTest {
    SignupPage signupPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url");
        driver.get(url);
        WaitClass.waitForUrl(driver, url, 10);
        signupPage=SignupPage.getPage(driver, SignupPage.class);


    }

    @Test(groups={"Sanity"},description="Sign up new company",priority = 2)
    public void userSignin() throws IOException{
        signupPage.enterLoginName();
        signupPage.enterFirstName();
        signupPage.enterLastName();
        signupPage.enterPhoneCountryCode();
        signupPage.enterPhoneAreaCode();
        signupPage.enterPhoneAreaCode();
        signupPage.enterPhoneNumber();
        signupPage.enterEmail();
        signupPage.selectLanguage();
        signupPage.selectCurrency();
        signupPage.enterOrgName();
        signupPage.enterAddress();
        signupPage.enterAddress2();
        signupPage.enterCity();
        signupPage.enterStateProvince();
        signupPage.selectCountry();
        signupPage.enterZipCode();
        signupPage.clickSaveChangesButton();
        signupPage.verifyLabelConfirmationMessage();


    }
    @AfterClass(alwaysRun=true)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }

}