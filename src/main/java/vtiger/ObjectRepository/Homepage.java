package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class Homepage {

	@FindBy(xpath="(//td[@class='small'])[2]")
	private WebElement adminbtn;
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement logoutbtn;
	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement orgbtn;
	
	public Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getAdminbtn() {
		return adminbtn;
	}
	public WebElement getLogoutbtn() {
		return logoutbtn;
	}
	public WebElement getOrgbtn() {
		return orgbtn;
	}
	public void clickorgbtn()
	{
		getOrgbtn().click();
	}
	public void logout(WebDriver driver)
	{
		WebDriverUtility util= new WebDriverUtility();
		util.mousehoveraction(driver, adminbtn);
		getLogoutbtn().click();
	}
}
