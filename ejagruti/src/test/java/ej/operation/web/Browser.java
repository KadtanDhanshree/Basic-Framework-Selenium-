package ej.operation.web;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;

import ej.configuration.Config;

public class Browser extends Config
{	
	public void OpenBrowser(String BrowserName)
	{
		if(BrowserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
	}
	
	public void EnterUrl(String url)
	{
		driver.get(url);		
	}
		
	public void MaximizeBrowser()
	{
		driver.manage().window().maximize();
	}
	
	public void WaitTillPageGetsLoaded(int TimeOutInSeconds)
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
		
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
