package Practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import java.time.Duration;
public class DemoQAPage {
    // Define the main method
    public static void main(String[] args)  {
        // Print test message
        System.out.println("Test for DemoQAPage with Main Method without @Test Annotation");

        // Set the path to the chromedriver executable
        ChromeOptions options = new ChromeOptions();
        // Allow all origins
        options.addArguments("--remote-allow-origins=*");

        // Instantiate the ChromeDriver with options
        WebDriver driver = new ChromeDriver(options);

        // Set implicit wait for 9 seconds. This means that if an element is not immediately present, WebDriver will wait for it up to 9 seconds.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
        driver.manage().window().maximize();

        // Navigate to the Demoqa.com webpage
        driver.get("https://demoqa.com/");

        // Locate the Elements Box using XPath and click on it
        WebElement elementsBox = driver.findElement(By.xpath("//div[@class='category-cards']//div[1]//div[1]//div[2]//*[name()='svg']"));
        elementsBox.click();

        // Locate the "Text Box" option using XPath and click on it
        WebElement textBoxOption = driver.findElement(By.xpath("(//li[@id='item-0'])[1]"));
        textBoxOption.click();

        // Locate the full name box by its id, and type in "Andy Sherpa"
        WebElement fullNameBox = driver.findElement(By.id("userName"));
        fullNameBox.sendKeys("Andy Sherpa");

        // Locate the email box by its id, and type in "johndoe@example.com"
        WebElement emailBox = driver.findElement(By.id("userEmail"));
        emailBox.sendKeys("johndoe@example.com");

        // Locate the current address box by its id, and type in "123 Main St, New York, NY"
        WebElement currentAddressBox = driver.findElement(By.id("currentAddress"));
        currentAddressBox.sendKeys("123 Main St, New York, NY");

        // Locate the permanent address box by its id, and type in "456 Main St, Los Angeles, CA"
        WebElement  permanentAddressBox = driver.findElement(By.id("permanentAddress"));
        permanentAddressBox.sendKeys("456 Main St, Los Angeles, CA");

        // Locate the submit button by its id, and click it to submit the form
        WebElement  submitButton = driver.findElement(By.id("submit"));
        submitButton.submit();

        // Adding the assertion
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='border col-md-12 col-sm-12"));
        Assert.assertTrue(successMessage.isDisplayed());

        // Locating the output field for the userName
        WebElement ActualOutputValue = driver.findElement(By.id("userName"));
        // Asserting that the text in the name output field is equal to the input value. If it's not, the test case will fail.
        Assert.assertEquals(ActualOutputValue.getAttribute("value"), "Andy Sherpa");


        // Close the browser session
        driver.close();


        // Print message to console when the test is passed
        System.out.println("Test Passed");
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






