package test_class;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.cucumber.java.Before;


@Test
public class NewTest {
	static WebDriver driver;
	WebDriverWait Wait;
	Actions action;
	JavascriptExecutor js;
	
	
	
	public WebDriver incognitoDriver;
    String incognitoWindowHandle = "";
    String mainWindowHandle;
	
	
	
	@Before
    public void setUp() {
        setUpDriver();
        //setUpIncognitoDriver();
    }
	
	
	
    @Test(invocationCount = 3 , invocationTimeOut = 20000)
    public void setUpDriver() {
        String baseURL = "https://digival-staging-nginx-ds-yk25kmkzeq-el.a.run.app/dev-dcweb/auth/login";
        ChromeOptions options = new ChromeOptions();
        options.addArguments(Arrays.asList("disable-infobars", "ignore-certificate-errors", "start-maximized", "use-fake-ui-for-media-stream"));
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.get(baseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        Wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        action = new Actions(driver);
        js = (JavascriptExecutor) driver;
        driver.quit();
    }
    
}
