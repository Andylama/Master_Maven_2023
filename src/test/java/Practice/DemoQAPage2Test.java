package Practice;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DemoQAPage2Test {
    private WebDriver driver;
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
    public void testFormSubmission() {
        driver.get("https://demoqa.com/");

        // Locating and interacting with the 'Elements' box on the webpage
        WebElement elementsBox = driver.findElement(By.xpath("//div[@class='category-cards']//div[1]//div[1]//div[2]//*[name()='svg']"));
        elementsBox.click();

        // Locating and interacting with the 'Text Box' option in the 'Elements' box
        WebElement textBoxOption = driver.findElement(By.xpath("(//li[@id='item-0'])[1]"));
        textBoxOption.click();

        // Filling in the 'Full Name' text box
        WebElement fullNameBox = driver.findElement(By.id("userName"));
        fullNameBox.sendKeys("Andy Sherpa");

        // Filling in the 'Email' text box
        WebElement emailBox = driver.findElement(By.id("userEmail"));
        emailBox.sendKeys("johndoe@example.com");

        // Filling in the 'Current Address' text box
        WebElement currentAddressBox = driver.findElement(By.id("currentAddress"));
        currentAddressBox.sendKeys("123 Main St, New York, NY");

        // Filling in the 'Permanent Address' text box
        WebElement permanentAddressBox = driver.findElement(By.id("permanentAddress"));
        permanentAddressBox.sendKeys("456 Main St, Los Angeles, CA");

        // Submitting the form
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Creating a WebDriverWait instance that waits a maximum of 10 seconds before throwing a TimeoutException
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Waiting until the success message is visible on the web page. If the success message doesn't show up within 10 seconds, a timeout exception will be thrown
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='border col-md-12 col-sm-12']")));

        // Assert that the success message is displayed. If it's not, the test case will fail.
        Assert.assertTrue(successMessage.isDisplayed());
        System.out.println("******************SuccessMessage is displaying:     "+successMessage+ " *********************");
        // Locating the output field for the userName
        WebElement nameOutput = driver.findElement(By.id("userName"));

        // Asserting that the text in the name output field is equal to the input value. If it's not, the test case will fail.
        Assert.assertEquals(nameOutput.getAttribute("value"), "Andy Sherpa");
        System.out.println("**************************Attribute value:     "+nameOutput+ " *****************************");

}
    @AfterMethod
    public void teardown() {
        driver.close();
    }
}

 /*  Test Case: Validate Form Submission on DemoQA Page
Test Scenario: To verify that the form submission functionality works correctly on the DemoQA Page.
TesSteps:
Open Chrome browser and navigate to https://demoqa.com/.
Click on the 'Elements' box on the webpage.
Click on the 'Text Box' option under 'Elements'.
Fill in 'Full Name' text box with "Andy Sherpa".
Fill in 'Email' text box with "johndoe@example.com".
Fill in 'Current Address' text box with "123 Main St, New York, NY".
Fill in 'Permanent Address' text box with "456 Main St, Los Angeles, CA".
Click on the 'Submit' button.
Wait for the success message to appear on the page.
Verify that the success message is displayed.
Verify the name output field shows "Andy Sherpa".
Close the browser.
Expected Result:
Form is submitted successfully with a success message displayed and the name output field shows "Andy Sherpa".
  */


