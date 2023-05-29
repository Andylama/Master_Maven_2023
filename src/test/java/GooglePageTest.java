// Import the necessary Selenium classes
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class GooglePageTest {
    // Define the main method
    public static void main(String[] args) throws InterruptedException {
        // Print test message to the console
        System.out.println("Test GoogleHomepage");

        // Instantiate the ChromeOptions class to customize Chrome browser settings
        ChromeOptions options = new ChromeOptions();
        // Add argument to allow all origins
        options.addArguments("--remote-allow-origins=*");
        // Instantiate the ChromeDriver with the options set
        WebDriver driver = new ChromeDriver(options);

        // Maximize the browser window
        driver.manage().window().maximize();
        // Navigate to the Google.com webpage
        driver.get("https://www.google.com/");
        // Print the title of the webpage to the console
        System.out.println(driver.getTitle());
        // Pause execution for 2 seconds to allow the page to load
        Thread.sleep(2000);
        // Find the search box by its id and type in "First Selenium Program"
        driver.findElement(By.id("APjFqb")).sendKeys("First Selenium Test Execution");
        // Pause execution for another 2 seconds
        Thread.sleep(2000);
        // Close the browser window
        driver.close();
        // Print test passed message to the console
        System.out.println("Test Passed");
    }
}
