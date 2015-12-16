**TestSample - Selenium PageFactory JUnit/TestNG PoC project**

**Usage pattern:** 

    mvn clean compile

**Selenium?** - Read more at: http://www.seleniumhq.org/

**What is PageFactory?** - Read more at: https://code.google.com/p/selenium/wiki/PageFactory

**What are PageObjects?** - Read more at: https://code.google.com/p/selenium/wiki/PageObjects

**JUnit?** - Read more at: http://junit.org/

**TestNG?** - Read more at: http://testng.org/doc/index.html

**The main purpose of this approach:**

	Without PageObjects
		- You have 200 Selenium/Junit or Selenium/TestNG tests
		- There is new version of the software
		- You have hardcoded logic into tests
		- You have to change all those 200 tests
		- Good luck from me

	With PageObjects
		- You use PageObjects
		- You change PageObjects
		- All the tests work
		- YAY

**Client arhitecture:**

1. main package: ee.rz.testsamples
	- logger
		* **LoggerHelper** - Custom log4j logger 
    - pageobjects
		* **ClientsPage.java** - PageObject for client page
		* **LoginPage.java** - PageObject for login page 
	- tests
		* junit
			* **SecurityServerTest.java** - Main test class
			* **TestBase.java** - TestBase which all other tests should extend
		* testng
			* **CustomTestListener.java** - Class for the results
			* **SecurityServerTest.java** - Main test class
			* **TestBase.java** - TestBase which all other tests should extend