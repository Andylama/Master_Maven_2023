package Practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Assertion {
    // Define the main method
    public static void main(String[] args)  {
        // Print test message
        System.out.println("Test for DemoQAPage");

        // Set the path to the chromedriver executable
        ChromeOptions options = new ChromeOptions();
        // Allow all origins
        options.addArguments("--remote-allow-origins=*");

        // Instantiate the ChromeDriver with options
        WebDriver driver = new ChromeDriver(options);

        // Set implicit wait for 9 seconds. This means that if an element is not immediately present, WebDriver will wait for it up to 9 seconds.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
        driver.manage().window().maximize();

        // Navigate to the demoqa.com webpage
        driver.get("https://demoqa.com/text-box");

        // Find the desired web element and input "Andy Sherpa"
        WebElement fullNameBox = driver.findElement(By.id("userName")); // Change to the correct id
        fullNameBox.sendKeys("Andy Sherpa");

        // Use explicit wait to ensure the value is set properly
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9));
        wait.until(ExpectedConditions.attributeToBe(By.id("userName"), "value", "Andy Sherpa")); // Change to the correct id

        // Find the output web element
        WebElement actualvalue= driver.findElement(By.id("userName")); // Change to the correct id

        // Assert that the value of the element matches the input value

        Assert.assertEquals(actualvalue.getAttribute("value"), "Andy Sherpa");
        System.out.println("**************************Attribute value:     "+actualvalue+ " *****************************");

        // Close the driver
        driver.quit();
    }
}
