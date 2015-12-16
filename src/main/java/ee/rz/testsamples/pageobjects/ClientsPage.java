package ee.rz.testsamples.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ClientsPage {

	/*
	 * Main PageObject for page /clients
	 */
	
	@FindBy (how = How.XPATH, using = "//table[@id='clients']/tbody/tr/td[4]/ul/li[3]")
	private WebElement servicesBtn;
	
	@FindBy (how = How.ID, using = "wsdl_add")
	private WebElement addWsdlBtn;
	
	@FindBy (how = How.ID, using = "wsdl_add_url")
	private WebElement addWsdlUrl;
	
	@FindBy (how = How.XPATH, using = "(//button[@type='button'])[30]")
	private WebElement okBtn;
	
	@FindBy (how = How.XPATH, using = "//table[@id='services']/tbody/tr/td[2]")
	private WebElement wsdl;
	
	@FindBy (how = How.ID, using = "wsdl_enable")
	private WebElement wsdlEnable;
	
	@FindBy (how = How.ID, using = "wsdl_delete")
	private WebElement wsdlDelete;
	
	@FindBy (how = How.CSS, using = "div.ui-dialog-buttonset > #confirm")
	private WebElement confirmBtn;
	
	@FindBy (how = How.XPATH, using = "(//button[@type='button'])[14]")
	private WebElement closeNtn;

	public WebElement getServicesBtn() {
		System.out.println("Opening services modal");
		return servicesBtn;
	}

	public WebElement getAddWsdlBtn() {
		System.out.println("Adding new WSDL");
		return addWsdlBtn;
	}

	public WebElement getOkBtn() {
		return okBtn;
	}

	public WebElement getWsdl() {
		return wsdl;
	}

	public WebElement getWsdlEnable() {
		System.out.println("Enabling WSDL");
		return wsdlEnable;
	}

	public void setAddWsdlUrl(String addWsdlUrl) {
		System.out.println("Input WSDL address " + addWsdlUrl);
		this.addWsdlUrl.clear();
		this.addWsdlUrl.sendKeys(addWsdlUrl);
	}
	
	public WebElement getCloseBtn()	{
		return closeNtn;
	}

	public WebElement getWsdlDelete() {
		System.out.println("Deleting WSDL");
		return wsdlDelete;
	}

	public WebElement getConfirmBtn() {
		return confirmBtn;
	}
	
	
	
}
