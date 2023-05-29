package Practice;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class DemoQAPage3Test {

    private ChromeDriver driver; // Declare a private instance variable of ChromeDriver class

    @BeforeMethod
    public void setup() { // Method to set up the test environment before each test method
        System.out.println("TestNG Test DemoQAPage");
        ChromeOptions options = new ChromeOptions(); // Create an instance of ChromeOptions
        options.addArguments("--remote-allow-origins=*"); // Add a command line argument
        driver = new ChromeDriver(options); // Initialize ChromeDriver with the options
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9)); // Set implicit wait time
        driver.manage().window().maximize();
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

        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent()); // Wait until the alert is present
        alert.accept(); // Accept the alert

        WebElement timerAlertButton = driver.findElement(By.xpath("//button[@id='timerAlertButton']")); // Find the element using XPath
        timerAlertButton.click(); // Click on the element

        Alert timerAlert = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent()); // Wait until the alert is present
        timerAlert.accept(); // Accept the alert

        WebElement confirmButton = driver.findElement(By.xpath("//button[@id='confirmButton']")); // Find the element using XPath
        confirmButton.click(); // Click on the element

        Alert confirmAlert = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent()); // Wait until the alert is present
        confirmAlert.accept(); // Accept the alert

        WebElement promptButton = driver.findElement(By.xpath("(//button[@id='promtButton'])[1]")); // Find the element using XPath
        promptButton.click(); // Click on the element

        Alert promptAlert = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent()); // Wait until the alert is present
        promptAlert.sendKeys("Lama"); // Enter text into the prompt alert
        promptAlert.accept(); // Accept the alert

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Create a WebDriverWait instance
        wait.until(ExpectedConditions.textToBe(By.xpath("//span[@id='promptResult']"), "You entered Lama")); // Wait until the text is present

        String responseMessage = driver.findElement(By.xpath("//span[@id='promptResult']")).getText(); // Get the text of the element
        Assert.assertEquals(responseMessage, "You entered Lama", "Response message is not as expected."); // Perform an assertion

        driver.quit(); // Quit the browser
    }

    @AfterMethod
    public void teardown() { // Method to perform cleanup after each test method
        if (driver != null) {
            driver.quit(); // Quit the browser if the driver instance is not null
        }
    }
}



    /*        Test Case: Alert Handling in DemoQA Page
Preconditions:
Ensure that Chrome browser is installed.
Download and set up the ChromeDriver executable for your system.
Test Steps:
Launch the Chrome browser.
Open the DemoQA website (https://demoqa.com/).
Click on the "Alerts, Frame & Windows" section on the page.
Click on the "Alerts" option in the sidebar.
Click on the "Click me" button next to the "Alert Box" label.
Verify that an alert box is displayed.
Click the "OK" button in the alert box.
Click on the "Click me" button next to the "Timer Alert" label.
Verify that a timer alert box is displayed.
Wait for the timer alert box to automatically close.
Click on the "Click me" button next to the "Confirm Box" label.
Verify that a confirmation box is displayed.
Click the "OK" button in the confirmation box.
Click on the "Click me" button next to the "Prompt Box" label.
Verify that a prompt box is displayed.
Enter "Lama" in the prompt box.
Click the "OK" button in the prompt box.
Wait for the page to display the message "You entered Lama" below the prompt box.
Verify that the displayed message matches the expected value "You entered Lama".
Close the browser.
Expected Results:
The alert boxes should be displayed and handled correctly.
The prompt box should accept the entered text and display the expected message.
The displayed message should match the expected value.
Note: These test case steps assume that the code and the website under test are functioning correctly.*/