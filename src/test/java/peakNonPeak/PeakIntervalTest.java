package peakNonPeak;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClassPackage.BaseClasses;
import utilPackages.PropertyValExtractors;

public class PeakIntervalTest {
	PeakIntervalPage peakIntervalPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		peakIntervalPage = PeakIntervalPage.getPage(driver, PeakIntervalPage.class);
}
	@Test(groups = { "Peak Non-Peak Feature" }, description = "Create Peak NoN Peak Intervals at Company Level")
	public void userSignin() throws Exception {

		/*peakIntervalPage.enterLoginID();
		peakIntervalPage.enterPassword();
		peakIntervalPage.selectCompany();
		peakIntervalPage.clickLoginButton();*/
		
		peakIntervalPage.getPeakIntervalPage();
		//WEEKLY BASED
		peakIntervalPage.selectPeakInterval(0);
		peakIntervalPage.clickAddButton();
		peakIntervalPage.selectisRecurring();
		peakIntervalPage.checkIsPeak();
		peakIntervalPage.enterStartDate(0);
		peakIntervalPage.enterEndDate(0);
		peakIntervalPage.selectDayofWeek();
		peakIntervalPage.clickSaveChangesButton();
		peakIntervalPage.verifyConfirmationMsg();
		
		//SPECIAL DAY
		peakIntervalPage.selectPeakInterval(1);
		peakIntervalPage.clickAddButton();
		peakIntervalPage.selectisRecurring();
		peakIntervalPage.enterStartDate(1);
		peakIntervalPage.enterDescription();
		peakIntervalPage.clickSaveChangesButton();
		peakIntervalPage.verifyConfirmationMsg();
		
		//HOLIDAY
		peakIntervalPage.selectPeakInterval(2);
		peakIntervalPage.clickAddButton();
		peakIntervalPage.selectisRecurring();
		peakIntervalPage.enterStartDate(2);
		peakIntervalPage.clickSaveChangesButton();
		peakIntervalPage.verifyConfirmationMsg();
		
		//TIME BASED
		peakIntervalPage.selectPeakInterval(3);
		peakIntervalPage.clickAddButton();
		peakIntervalPage.selectisRecurring();
		peakIntervalPage.checkIsPeak();
		peakIntervalPage.enterStartDate(3);
		peakIntervalPage.enterEndDate(1);
		peakIntervalPage.enterStartTime();
		peakIntervalPage.enterEndTime();
		peakIntervalPage.clickSaveChangesButton();
		peakIntervalPage.verifyConfirmationMsg();
	}

}
