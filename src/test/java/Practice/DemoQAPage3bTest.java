package Practice;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoQAPage3bTest {

    private ChromeDriver driver; // Declare a private instance variable of ChromeDriver class
    private WebDriverWait wait; // Declare a private instance variable of WebDriverWait class

    @BeforeMethod
    public void setup() { // Method to set up the test environment before each test method
        System.out.println("TestNG Test DemoQAPage");
        ChromeOptions options = new ChromeOptions(); // Create an instance of ChromeOptions
        options.addArguments("--remote-allow-origins=*"); // Add a command line argument
        driver = new ChromeDriver(options); // Initialize ChromeDriver with the options
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9)); // Set implicit wait time
        driver.manage().window().maximize();

        // Initialize WebDriverWait with a timeout of 10 seconds
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testDemoQA() {
        driver.get("https://demoqa.com/");

        WebElement alertsWindows = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']")); // Find the element using XPath
        alertsWindows.click(); // Click on the element

        WebElement alertSideBar = driver.findElement(By.xpath("//span[contains(text(),'Alerts')]")); // Find the element using XPath
        alertSideBar.click(); // Click on the element

        WebElement alertButton = driver.findElement(By.xpath("//button[@id='alertButton']")); // Find the element using XPath
        alertButton.click(); // Click on the element

        Alert alert = driver.switchTo().alert(); // Switch to the alert
        alert.accept(); // Accept the alert

        WebElement timerAlertButton = driver.findElement(By.xpath("//button[@id='timerAlertButton']")); // Find the element using XPath
        timerAlertButton.click(); // Click on the element

        Alert timerAlert = wait.until(ExpectedConditions.alertIsPresent()); // Wait for the alert to be present
        timerAlert.accept(); // Accept the alert

        WebElement confirmButton = driver.findElement(By.xpath("//button[@id='confirmButton']")); // Find the element using XPath
        confirmButton.click(); // Click on the element

        Alert confirmAlert = driver.switchTo().alert(); // Switch to the alert
        confirmAlert.accept(); // Accept the alert

        WebElement promptButton = driver.findElement(By.xpath("(//button[@id='promtButton'])[1]")); // Find the element using XPath
        promptButton.click(); // Click on the element

        Alert promptAlert = driver.switchTo().alert(); // Switch to the alert
        promptAlert.sendKeys("Lama"); // Enter text into the prompt alert
        promptAlert.accept(); // Accept the alert

        String responseMessage = driver.findElement(By.xpath("//span[@id='promptResult']")).getText(); // Get the text of the element
        Assert.assertEquals(responseMessage, "You entered Lama", "Response message is not as expected."); // Perform an assertion

        driver.quit(); // Quit the browser
    }

    @AfterMethod
    public void teardown() { // Method to perform cleanup after each test method
        if (driver != null) {
            driver.quit(); // Quit the browser if the driver is not null
        }
    }
}
/*        "Validating the interaction and functionality of alerts and prompts on the 'https://demoqa.com/' webpage."
Open a new Google Chrome window.
Go to the URL "https://demoqa.com/".
Verify the presence of the element with the text "Alerts, Frame & Windows" on the webpage.
Click on the element with the text "Alerts, Frame & Windows".
Verify the presence of the sidebar element containing the text "Alerts".
Click on the sidebar element containing the text "Alerts".
Verify the presence of the button with the ID "alertButton" on the webpage.
Click on the button with the ID "alertButton".
Verify that an alert box pops up.
Accept the alert.
Verify the presence of the button with the ID "timerAlertButton" on the webpage.
Click on the button with the ID "timerAlertButton".
Wait for the timer alert to appear.
Accept the timer alert.
Verify the presence of the button with the ID "confirmButton" on the webpage.
Click on the button with the ID "confirmButton".
Verify that a confirmation alert box pops up.
Accept the confirmation alert.
Verify the presence of the button with the ID "promtButton" on the webpage.
Click on the button with the ID "promtButton".
Verify that a prompt alert box pops up.
Input the text "Lama" into the prompt alert box.
Accept the prompt alert.
Verify that a response message appears on the webpage with the text "You entered Lama".
Close the Google Chrome window.
Expected Result:
The interactions with the alerts work as expected and the response message after interacting with the prompt alert is "You entered Lama".
Post Condition:
The Google Chrome window is closed.                                                     */

