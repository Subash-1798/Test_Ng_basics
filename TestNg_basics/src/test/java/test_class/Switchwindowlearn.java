package test_class;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Switchwindowlearn {
	
	public WebDriver incognitoDriver;
    String incognitoWindowHandle = "";
    String mainWindowHandle;
	
	
//	@Test(invocationCount = 3 , threadPoolSize = 2)
	@Test(timeOut = 10000)
	   public  void NewTest() {
			ChromeOptions chromeOptions = new ChromeOptions();
			HashMap<String, Object> chromePrefs = new HashMap<>();
			chromeOptions.addArguments("--incognito");
			incognitoDriver = new ChromeDriver(chromeOptions);
			incognitoDriver.manage().window().maximize();
			incognitoDriver.get("https://digival-staging-nginx-ds-yk25kmkzeq-el.a.run.app/dev-dcweb/auth/login");
			System.out.println("The Login is success");
			incognitoDriver.quit();

		}
		
	
	

}
