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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;
import utilPackages.WaitClass;
import agentcommissions.AgentCommissionProcessPage;


public class agentCommissionBalanceProcessTest {
	AgentCommissionProcessPage agentCommissionProcessPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        WaitClass.waitForUrl(driver, url, 10);
        agentCommissionProcessPage=AgentCommissionProcessPage.getPage(driver, AgentCommissionProcessPage.class);

    }

    @Test(groups={"Sanity"},description="Agents and Commissions - The Commissions Balance Process")
    public void userSignin() throws IOException{
    	agentCommissionProcessPage.enterLoginID();
    	agentCommissionProcessPage.enterPassword();
    	agentCommissionProcessPage.selectCompany();
    	agentCommissionProcessPage.clickLoginButton();
    	agentCommissionProcessPage.clickAgentTab();
    	agentCommissionProcessPage.selectAgent();
    	agentCommissionProcessPage.clickShowCommissionButton();
    	agentCommissionProcessPage.verifyCommissionDisplay();
    	agentCommissionProcessPage.clickCustomerTab();
    	agentCommissionProcessPage.clickCustomerB();
    	agentCommissionProcessPage.clickCreateOrderButton();
    	agentCommissionProcessPage.selectOrderPeriod();
    	agentCommissionProcessPage.selectType();
    	agentCommissionProcessPage.clickProductsSubTab();
    	agentCommissionProcessPage.clickOnProduct();
    	agentCommissionProcessPage.clickUpdateButton();
    	agentCommissionProcessPage.clickSaveChangesButton();
    	agentCommissionProcessPage.clickGenerateInvoiceButton();
       	agentCommissionProcessPage.clickConfigurationTab();
    	agentCommissionProcessPage.clickAgentCommissionProcess();
		agentCommissionProcessPage.enterPeriodValue();
		agentCommissionProcessPage.enterNextRunDate();
    	agentCommissionProcessPage.clickSaveChangesButton();
     	agentCommissionProcessPage.clickRunCommissionButton();
        agentCommissionProcessPage.clickAgentTab();
        agentCommissionProcessPage.selectAgent();
        agentCommissionProcessPage.clickShowCommissionButton();
        agentCommissionProcessPage.clickCommission();
    	agentCommissionProcessPage.verifyCommissionAmount();
    }
    
    @AfterClass(alwaysRun=true)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }

}

