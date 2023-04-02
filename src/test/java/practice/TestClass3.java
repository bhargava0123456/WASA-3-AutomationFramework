package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class TestClass3 {

	@Test
	public void testmethod9()
	{
		System.out.println("testmethod 9"+Thread.currentThread());
	}

	@Test(retryAnalyzer = vtiger.GenericUtilities.IretryAnalyser.class)
	public void testmethod10()
	{
		//Assert.fail();
		System.out.println("testmethod 10"+Thread.currentThread());
	}

	@Test
	public void testmethod11()
	{
		System.out.println("testmethod 11"+Thread.currentThread());
	}

	@Test
	public void testmethod12()
	{
		System.out.println("testmethod 12"+Thread.currentThread());
	}

}
