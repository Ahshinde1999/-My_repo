package com.AshokMavenProject.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.AshokMavenProject.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() {
		
        logger.info("Url is opened");
        
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("Entered Username");
		
		lp.setPassword(password);
        logger.info("Entered password");
        
		lp.clickSubmit();

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		} else {

			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	}

}