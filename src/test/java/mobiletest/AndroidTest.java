package mobiletest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AndroidTest {
	
	public static AndroidDriver<MobileElement> appiumDriver;

	public static void main(String[] args) throws MalformedURLException {
		
		String USERNAME = "ENTER YOUR BROWSER STACK USERNAME";
		String KEY = "ENTER YOUR OWN ACCESS KEY";
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("os_version", "9.0");
		cap.setCapability("device", "Google Pixel 3");
		cap.setCapability("app", "bs://2ad4b56c03595f577dde294ee398fdeb21f2977e");
		cap.setCapability("project", "Training_Appium");
		cap.setCapability("build", "Build 1.1");
		cap.setCapability("name", "Demo App Test");
		
		String URL = "https://"+ USERNAME + ":" + KEY + "@hub-cloud.browserstack.com/wd/hub";
		appiumDriver = new AndroidDriver<MobileElement>(new URL(URL), cap);
		MobileElement preference = (MobileElement) appiumDriver.findElement(By.xpath("//android.widget.TextView[@content-desc='Preference']"));
		System.out.println(preference.getText());
		preference.click();
		appiumDriver.findElement(By.xpath("//android.widget.TextView[@content-desc='7. Fragment']")).click();
		
		List<MobileElement> allElement = appiumDriver.findElements(By.xpath("//android.widget.ListView/android.widget.LinearLayout"));
		System.out.println("Count of LinearLayout : " + allElement.size());
		
		//android.widget.ListView[@resource-id="android:id/list"]/android.widget.LinearLayout[1]//android.widget.TextView[1]
		
		
		appiumDriver.quit();
		
	}

}
