package test_class;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.cucumber.java.Before;

public class LearnParameters {

	@Test
	public class NewTest {

		WebDriver driver;
		WebDriverWait Wait;
		Actions action;
		JavascriptExecutor js;

//	    }

		@Parameters({ "Email", "Password", "browser" })
		@Test
		public void main(String Email, String Password, String browser) {

			switch (browser) {
			case "chrome":
				
				break;
			case "edge":
				driver = new EdgeDriver();
				
				break;

			default:
				System.out.println("The browser is not present");
				break;
			}

			String baseURL = "https://digival-staging-nginx-ds-yk25kmkzeq-el.a.run.app/dev-dcweb/auth/login";
			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver(options);
			driver.get(baseURL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			Wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;

			driver.findElement(By.xpath("//input[@type =\"input\"]")).sendKeys("sf61@mail.com");
			driver.findElement(By.xpath("//input [@type= \"password\"]")).sendKeys("12345678");

			driver.quit();
		}

	}

}
