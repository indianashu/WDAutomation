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
import webDataPages.SignupChildCompanyInvoiceAsSellerPage;;

public class ChildCompanySignupResellerTest {
	SignupChildCompanyInvoiceAsSellerPage signupChildCompanyInvoiceAsSellerPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        WaitClass.waitForUrl(driver, url, 10);
        signupChildCompanyInvoiceAsSellerPage=SignupChildCompanyInvoiceAsSellerPage.getPage(driver, SignupChildCompanyInvoiceAsSellerPage.class);


    }

    @Test(groups={"Sanity"},description="Child Company Sign up as Invoice Reseller New Company")
    public void userSignin() throws IOException{
    	signupChildCompanyInvoiceAsSellerPage.enterLoginID();
    	signupChildCompanyInvoiceAsSellerPage.enterPassword();
    	signupChildCompanyInvoiceAsSellerPage.selectCompany();
    	signupChildCompanyInvoiceAsSellerPage.clickLoginButton();
    	signupChildCompanyInvoiceAsSellerPage.verifyLabelSuccessfulLogin();
    	signupChildCompanyInvoiceAsSellerPage.enterURL();
    	signupChildCompanyInvoiceAsSellerPage.labelRootCompany();
    	signupChildCompanyInvoiceAsSellerPage.enterLoginName();
    	signupChildCompanyInvoiceAsSellerPage.enterFirstName();
    	signupChildCompanyInvoiceAsSellerPage.enterLastName();
    	signupChildCompanyInvoiceAsSellerPage.enterPhoneCountryCode();
    	signupChildCompanyInvoiceAsSellerPage.enterPhoneAreaCode();
    	signupChildCompanyInvoiceAsSellerPage.enterPhoneAreaCode();
    	signupChildCompanyInvoiceAsSellerPage.enterPhoneNumber();
    	signupChildCompanyInvoiceAsSellerPage.enterEmail();
    	signupChildCompanyInvoiceAsSellerPage.selectLanguage();
    	signupChildCompanyInvoiceAsSellerPage.selectCurrency();
    	signupChildCompanyInvoiceAsSellerPage.enterOrgName();
    	signupChildCompanyInvoiceAsSellerPage.checkInvoiceAsReseller();
    	signupChildCompanyInvoiceAsSellerPage.enterAddress();
    	signupChildCompanyInvoiceAsSellerPage.enterAddress2();
    	signupChildCompanyInvoiceAsSellerPage.enterCity();
    	signupChildCompanyInvoiceAsSellerPage.enterStateProvince();
    	signupChildCompanyInvoiceAsSellerPage.selectCountry();
    	signupChildCompanyInvoiceAsSellerPage.enterZipCode();
    	signupChildCompanyInvoiceAsSellerPage.clickSaveChangesButton();

    }
    @AfterClass(alwaysRun=true)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }

}