package test_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Learndataprovider {
    static WebDriver driver;

    @Test(dataProvider = "getdata", dataProviderClass = utilis.DataUtilis.class)
    public void login(String data[]) {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        
        System.err.println("email"+ data[0]);
        System.err.println("password"+ data[1]);
        

        driver.get("https://digival-staging-nginx-ds-yk25kmkzeq-el.a.run.app/staging1-dcweb/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//div/input[@class=\"floating-input \"]")).sendKeys(data[0]);
        driver.findElement(By.xpath("//div/input[@type=\"password\"]")).sendKeys(data[1]);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        
        
        String message = driver.findElement(By.xpath("//div[contains(@class, 'login-message')]")).getText();
        Assert.assertTrue(message.contains("Welcome"), "Login failed for: " + data[0]);

        // Add logic to handle login validation, if necessary.
        driver.quit(); // Close browser after test
    }
}
