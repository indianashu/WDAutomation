package agentcommissionsTest;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;
import utilPackages.WaitClass;
import agentcommissions.AgentPage;


public class productCreationTest {
	AgentPage agentPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        WaitClass.waitForUrl(driver, url, 10);
        agentPage=agentPage.getPage(driver, AgentPage.class);

    }

    @Test(groups={"Sanity"},description="Login",priority = 1)
    public void userSignin() throws IOException{
    	agentPage.enterLoginID();
    	agentPage.enterPassword();
    	agentPage.selectCompany();
    	agentPage.clickLoginButton();
    	agentPage.clickAgentTab();    	
    }

}

