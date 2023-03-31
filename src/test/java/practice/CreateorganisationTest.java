package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateOrganisation_POM;
import vtiger.ObjectRepository.Homepage;

public class CreateorganisationTest extends BaseClass {

	@Test
	public void createorg() throws Exception, IOException
	{
		String Orgname=eutil.datafromexcel("organization",1,1) + jutil.getRandomnumber();
		Homepage hp=new Homepage(driver);
		hp.clickorgbtn();
		
		CreateOrganisation_POM co=new CreateOrganisation_POM(driver);
		co.createorg(Orgname);
		String orgheader=co.orgheaderinfo();
		Assert.assertTrue(orgheader.contains(Orgname));
		System.out.println(orgheader+"------> organization created");
	}
}
