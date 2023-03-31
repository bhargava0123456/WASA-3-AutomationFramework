package practice;

import org.testng.annotations.Test;

public class Practice_Test {

	@Test(groups="smoke")
	public void smoke()
	{
		System.out.println("smoke executed");
	}
	@Test(groups="regression")
	public void regress()
	{
		System.out.println("regression executed");
	}
}
