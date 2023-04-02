package practice;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class TestClass1 {

	@Test(groups = {"smoke"})
	public void testmethod1()
	{
		System.out.println("smoke"+Thread.currentThread());
	}
	
	@Test(groups = {"smoke"})
	public void testmethod2()
	{
		System.out.println("testmethod 2"+Thread.currentThread());
	}

	@Test(groups = {"regression"})
	public void testmethod3()
	{
		System.out.println("testmethod 3"+Thread.currentThread());
	}

	@Test
	public void testmethod4()
	{
		System.out.println("testmethod 4"+Thread.currentThread());
	}

}
