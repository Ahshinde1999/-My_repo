package com.AshokMavenProject.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.AshokMavenProject.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseUrl = readconfig.getApplicationUrl();
	public String userName = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;

	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		logger = Logger.getLogger("AshokMavenProject");
		PropertyConfigurator.configure("Log4j.properties");

		
		if (br.equals("edge")) {
			System.setProperty("WebDriver.msedge.driver", readconfig.getEdgePath());
			driver = new EdgeDriver();
		} 
		else if (br.equals("chrome")) {
			System.setProperty("WebDriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		}
		else if (br.equals("ie")) {
			System.setProperty("WebDriver.ie.driver", readconfig.getIePath());
			driver = new InternetExplorerDriver();

		}

		driver.get(baseUrl);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}