package vtiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener{

	
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"---Execution started");
		
		test = report.createTest(methodname);
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname=result.getMethod().getMethodName();
		test.log(Status.PASS, methodname+"-----Execution started");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		JavaUtility jutil=new JavaUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		
		String Methodname=result.getMethod().getMethodName();
		test.log(Status.FAIL,Methodname+"---Fail");
		test.log(Status.INFO, result.getThrowable());
		
		String screenshotname=Methodname+"-"+jutil.getSystemdateformat();
		try {
			String path=wutil.takeScreenShot(BaseClass.sdriver,screenshotname);
			test.addScreenCaptureFromPath(path);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP,methodName+"----skip");
		test.log(Status.INFO,result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("suite execution started");
		ExtentSparkReporter htmlreport=new ExtentSparkReporter(".\\ExtentReports\\Report-"+ new JavaUtility().getRandomnumber()+".html");
		htmlreport.config().setDocumentTitle("vtiger Execution Report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("Vtiger Execution Report");
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base URL","http://localhost:8888");
		report.setSystemInfo("Base Browser","Firefox");
		report.setSystemInfo("reporter name","bhargav");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("suite execution finished");
		report.flush();
	}

	
	
	
}
