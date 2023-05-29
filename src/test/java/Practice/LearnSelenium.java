package Practice;
// Import necessary libraries
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
public class LearnSelenium {
    // Define the main method
    public static void main(String[] args) throws InterruptedException {
        // Print test message
        System.out.println("Test  Page for Experiment");

        // Set the path to the chromedriver executable
        /*System.setProperty("WebDriver.EdgeDriver.driver", "Driver/EdgeDriver/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();*/
        /*System.setProperty("WebDriver driver .chrome.driver", "Driver/ChromeDriver/chromedriver.exe");*/

        // Create ChromeOptions object to customize Chrome browser settings
        ChromeOptions options = new ChromeOptions();
        // Allow all origins
        options.addArguments("--remote-allow-origins=*");
        // Instantiate the ChromeDriver with options
        WebDriver driver = new ChromeDriver(options);

        // Set implicit wait for 9 seconds. This means that if an element is not immediately present, WebDriver will wait for it up to 9 seconds.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the google.com webpage
        driver.get("https://www.google.com");

        // Get the title of the webpage
        String actualTitle= driver.getTitle();
        // Print the title of the webpage
        System.out.println("************************* "+actualTitle+ " **********************************************");
        // Print the title of the webpage
        System.out.println (driver.getTitle());
        // Print the title of the webpage
        System.out.println("************************* "+ driver.getTitle()+ " *****************************************");

            // Close the browser session
        driver.close();
        // Quits this driver, closing every associated window
        driver.quit();
        // Print message to console when the test is passed
        System.out.println("Test Passed");
    }
}


/*    Thread.sleep(3000);*/

