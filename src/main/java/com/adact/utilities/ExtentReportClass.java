package com.adact.utilities;

import java.text.SimpleDateFormat;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReportClass 
{
	public static ExtentReports report=null;
	public static ExtentTest test=null;
	
	public static void openReport(String path) 
	{
		if(report==null)
		{
			report=new ExtentReports(path,false);
			report.config().reportHeadline("My Report");
			report.config().reportName("Adact In Hotel App");
			report.config().documentTitle("ADACTIN_HOTEL_APP");
		}
	}
	
	public static void openTest(String testname) 
	{
		if(test==null)
		{
			test=report.startTest(testname);
		}
	}
	
	public static void closeTest() 
	{
		if(test!=null)
		{
			report.endTest(test);
			test=null;
		}
	}
	
	public static void closeReport() 
	{
		if(report!=null)
		{
			report.flush();
			report.close();
			report=null;
		}
	}
	
	public static String extentReportFileName() 
	{
		SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		java.util.Date date=new java.util.Date();
		String dateFormat = format.format(date);
		String replace ="E:\\report\\"+dateFormat.trim().replace("-", "_").replace(":", "_")+".html";
		return replace;
	}
}
