package vtiger.GenericUtilities;

import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public String getsystemdate()
	{
		Date d=new Date();
		return d.toString();
	}
	public String getSystemdateformat()
	{
		Date d=new Date();
		String date[]=d.toString().split("");
		String month=date[1];
		String date1=date[2];
		String time=date[3].replace(":", ".");
		String Year=date[5];
		String finaldate=date1+" "+month+" "+Year+" "+time;
		return finaldate;
	}
	public int getRandomnumber()
	{
		Random r=new Random();
		return r.nextInt(1000);
	}
}
