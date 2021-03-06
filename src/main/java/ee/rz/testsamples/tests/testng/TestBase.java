package ee.rz.testsamples.tests.testng;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import ee.rz.testsamples.pageobjects.ClientsPage;
import ee.rz.testsamples.pageobjects.LoginPage;

public class TestBase {
	
	protected static WebDriver driver;
	protected static LoginPage loginPage;
	protected static ClientsPage clientsPage;
	
    @BeforeMethod
    // Quick example for GRID parameters from testng.xml
    //@Parameters({"browser", "platform", "hub-address"})
    // public static void setUp(String browser, String platform, String hub-address){
    public static void setUp(){
        // For GRID
        /*URL url2 = null;
        try {
            url2 = new URL("http", "localhost", 4444, "/wd/hub");
        } catch (MalformedURLException e) {
        	e.printStackTrace();
        }
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setJavascriptEnabled(true);
        driver = new RemoteWebDriver(url2, capabilities);*/

    	// Local testing
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        clientsPage = PageFactory.initElements(driver, ClientsPage.class);
    }
    
    @AfterMethod
    public static void tearDown(){
        driver.quit();
    }
    
    public static WebDriver getDriver()	{
    	return driver;
    }
    
    public static void takeScreenshot() throws Exception	{
    	// For GRID
    	/*WebDriver augmentedDriver = new Augmenter().augment(driver);
        File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);*/

    	// Local testing
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("./imageName.png"));
    }
}
