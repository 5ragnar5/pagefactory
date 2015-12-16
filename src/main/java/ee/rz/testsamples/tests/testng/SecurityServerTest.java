package ee.rz.testsamples.tests.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SecurityServerTest extends TestBase{

	/*
	 * Main test body
	 */

	@Test(dataProvider = "data1")
	public void TestValidUserCredential(String URL, String user, String password, String WSDL)	{       
        driver.get(URL);
        loginPage.logIn(user, password);
        
        clientsPage.getServicesBtn().click();
        clientsPage.getAddWsdlBtn().click();
        clientsPage.setAddWsdlUrl(WSDL);
        clientsPage.getOkBtn().click();
        clientsPage.getWsdl().click();
        clientsPage.getWsdlEnable().click();

        try	{
        	takeScreenshot();
        }
        catch (Exception e)	{
        	System.out.println("Taking screenshot failed " + e.getStackTrace());
        }
        
        // Assertion
        Assert.assertTrue(clientsPage.getWsdl().getText().contains(WSDL), "Actual WSDL does not match the expected WSDL");
        
    	clientsPage.getWsdlDelete().click();
    	clientsPage.getConfirmBtn().click();
    	clientsPage.getCloseBtn().click();
	}
	
	@DataProvider(name = "data1")
	public Object[][] testData() {
		 return new Object[][] {
		   { "http://example.org/url", "user", "password", "WSDLURL" },
		   // Example that dataprovider supports multi-dimensional array
		   { "http://example.org/url2", "user2", "password2", "WSDLURL2" },
		 };
	}

	
}
