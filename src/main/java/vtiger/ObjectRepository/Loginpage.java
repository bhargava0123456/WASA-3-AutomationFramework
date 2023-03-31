package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	@FindBy(name="user_name")
	private WebElement username;
	@FindBy(name="user_password")
	private WebElement password;
	@FindBy(id="submitButton")
	private WebElement loginbtn;
	//creation of constructor
	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	public void logintoapp(String user,String pass)
	{
		getUsername().sendKeys(user);
		getPassword().sendKeys(pass);
		getLoginbtn().click();
	}

}