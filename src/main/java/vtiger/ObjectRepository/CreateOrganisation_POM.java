package vtiger.ObjectRepository;

import java.util.Random;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganisation_POM {

	@FindBy(css="[title='Create Organization...']")
	private WebElement createorgbtn;
	@FindBy(css="[name='accountname']")
	private WebElement orgname;
	@FindBy(xpath="(//input[@class='crmbutton small save'])[2]")
	private WebElement savebtn;
	@FindBy(css="[class='dvHeaderText']")
	private WebElement orgheader;
	
	public CreateOrganisation_POM(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public WebElement getCreateorgbtn() {
		return createorgbtn;
	}



	public WebElement getOrgname() {
		return orgname;
	}



	public WebElement getOrgheader() {
		return orgheader;
	}

	
	public WebElement getSavebtn() {
		return savebtn;
	}



	public void createorg(String orgname)
	{
		getCreateorgbtn().click();
		getOrgname().sendKeys(orgname);
		getSavebtn().click();
		
	}
	public String orgheaderinfo()
	{
		return getOrgheader().getText();
	}
	
	}
