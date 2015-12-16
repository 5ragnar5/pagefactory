package ee.rz.testsamples.tests.junit;

import ee.rz.testsamples.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class SecurityServerTest extends TestBase{

    /*
     *Main test body
     */

	@Test
	public void testValidUserCredential() throws InterruptedException	{

        //Custom log4j logger example
        LoggerHelper helper = new LoggerHelper();
        helper.setAppLogger("logs", "SecurityServerTest");
        Logger logger = Logger.getLogger(LoggerHelper.class);

        System.out.println("Starting test " + new Object() {}.getClass().getEnclosingMethod().getName());

        //example log levels
        logger.info("Let's log something to INFO log");
        logger.warn("Let's log something to WARN log");
        logger.fatal("Lets's log something to FATAL log");
        
        driver.get("url");
        loginPage.logIn("user", "password");
        
        clientsPage.getServicesBtn().click();
        clientsPage.getAddWsdlBtn().click();
        clientsPage.setAddWsdlUrl("http://example.org");
        clientsPage.getOkBtn().click();
        clientsPage.getWsdl().click();
        clientsPage.getWsdlEnable().click();

        //screenshot PoC
        try	{
        	takeScreenshot();
        }
        catch (Exception e)	{
        	System.out.println("Taking screenshot failed " + e.getStackTrace());
        }
        
        //JUnit assertion
        Assert.assertTrue("Actual WSDL does not match the expected WSDL", clientsPage.getWsdl().getText().contains("http://example.org"));
        clientsPage.getCloseBtn().click();
        System.out.println("Ending test " + new Object() {}.getClass().getEnclosingMethod().getName());
	}
}
