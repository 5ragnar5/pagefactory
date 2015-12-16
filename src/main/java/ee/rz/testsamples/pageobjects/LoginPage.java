package ee.rz.testsamples.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	/*
	 * Main PageObject for Login page /login
	 */

	@FindBy (how = How.ID, using = "j_username")
	private WebElement username;
	
	@FindBy (how = How.ID, using = "j_password")
	private WebElement password;
	
	@FindBy (how = How.CSS, using = "button.btn")
	private WebElement loginBtn;
	
	public void logIn(String username, String password)	{
		// Change sysout to logging
		System.out.println("Logging in as " + username + ":" + password);
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		loginBtn.click();
	}
}

