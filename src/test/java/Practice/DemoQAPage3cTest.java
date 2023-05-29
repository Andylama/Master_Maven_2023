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

public class DemoQAPage3cTest {
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
    public void testDemoQA() {
        driver.get("https://demoqa.com/");
      // Locate the 'Alerts, Frame & Windows' element on the page using its XPath  //
        WebElement alertsWindows = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        // Assert that the 'Alerts, Frame & Windows' element is displayed on the page  //
        Assert.assertTrue(alertsWindows.isDisplayed(), "Alerts, Frame & Windows option is not displayed.");
        // Click on the 'Alerts, Frame & Windows' element //
        alertsWindows.click();

        WebElement alertSideBar = driver.findElement(By.xpath("//span[contains(text(),'Alerts')]"));
        Assert.assertTrue(alertSideBar.isDisplayed(), "Alerts sidebar option is not displayed.");
        alertSideBar.click();

        WebElement alertButton = driver.findElement(By.xpath("//button[@id='alertButton']"));
        Assert.assertTrue(alertButton.isDisplayed(), "Alert Button is not displayed.");
        alertButton.click();

        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
        alert.accept();

        WebElement timerAlertButton = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        Assert.assertTrue(timerAlertButton.isDisplayed(), "Timer Alert Button is not displayed.");
        timerAlertButton.click();

        Alert timerAlert = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
        timerAlert.accept();

        WebElement confirmButton = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        Assert.assertTrue(confirmButton.isDisplayed(), "Confirm Button is not displayed.");
        confirmButton.click();
// Wait for the confirm alert to be present and get the alert//
        Alert confirmAlert = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
        confirmAlert.accept();

        WebElement promptButton = driver.findElement(By.xpath("(//button[@id='promtButton'])[1]"));
        Assert.assertTrue(promptButton.isDisplayed(), "Prompt Button is not displayed.");
        promptButton.click();
// Wait for the prompt alert to be present and get the alert//
        Alert promptAlert = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
        promptAlert.sendKeys("Lama");
        promptAlert.accept();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBe(By.xpath("//span[@id='promptResult']"), "You entered Lama"));

        String responseMessage = driver.findElement(By.xpath("//span[@id='promptResult']")).getText();
        Assert.assertEquals(responseMessage, "You entered Lama", "Response message is not as expected.");

        driver.quit();
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
 /*

Test Case: DemoQA Page Alerts and Prompts Test
Launch the Chrome browser.
Navigate to the DemoQA website (https://demoqa.com/).
Verify that the page is loaded and displayed correctly.
Locate the "Alerts, Frame & Windows" option on the page.
Verify that the "Alerts, Frame & Windows" option is displayed.
Click on the "Alerts, Frame & Windows" option.
Verify that the "Alerts" sidebar option is displayed.
Click on the "Alerts" sidebar option.
Verify that the "Alert Button" is displayed.
Click on the "Alert Button".
Wait for an alert dialog to appear.
Verify that the alert dialog is displayed.
Accept the alert by clicking the OK button.
Verify that the alert dialog is closed.
Verify that the "Timer Alert Button" is displayed.
Click on the "Timer Alert Button".
Wait for a timer alert dialog to appear.
Verify that the timer alert dialog is displayed.
Accept the timer alert by clicking the OK button.
Verify that the timer alert dialog is closed.
Verify that the "Confirm Button" is displayed.
Click on the "Confirm Button".
Wait for a confirm alert dialog to appear.
Verify that the confirm alert dialog is displayed.
Accept the confirmation alert by clicking the OK button.
Verify that the confirm alert dialog is closed.
Verify that the "Prompt Button" is displayed.
Click on the "Prompt Button".
Wait for a prompt alert dialog to appear.
Verify that the prompt alert dialog is displayed.
Enter the text "Lama" in the input field of the prompt alert.
Accept the prompt alert by clicking the OK button.
Wait for the response message to be displayed.
Verify that the response message is "You entered Lama".
Quit the browser.
Verify that the browser is closed                                      */