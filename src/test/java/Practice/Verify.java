package Practice;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Verify {
    private ChromeDriver driver;

    @BeforeMethod
    public void setup() {
        System.out.println("TestNG Test DemoQAPage");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
        driver.manage().window().maximize();
    }

    @Test
    public void testDemoQA () {
        driver.get("https://demoqa.com/");
        WebElement alertsWindows = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertsWindows.click();
        driver.quit();
    }

    @AfterMethod
    public void teardown () {
        driver.quit();
    }
}
