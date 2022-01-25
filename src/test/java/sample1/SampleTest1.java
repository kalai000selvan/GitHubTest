package sample1;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest1 {
	
	WebDriver wd =null;
	@Test
	public void loadGoogle(){
		WebDriverManager.chromedriver().setup();
		WebDriver wd=new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("https://www.google.co.in/ ");
		wd.findElement(By.name("q")).sendKeys("chennai");
		wd.findElement(By.name("q")).submit();
	}
	
	@After
	public void tearDown(Scenario s)throws IOException{
	if(s.isFailed()){
		File src=((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C:/Users/tharun/Desktop/Vcentry/seleniumWorkspace/GitHubTest/src/screenshot"+".png"));
	}
	
    }
}
