package testSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test1LabSelenium {

    private final WebDriver driver = new ChromeDriver();
    private final WebDriverWait wait = new WebDriverWait(driver, 25);
    private final WebDriverWait wait2 = new WebDriverWait(driver, 7);


    @Test
    public void firstTestSelenium() {
          WebDriverManager.chromedriver().setup();
          driver.manage().window().maximize();
          String urlSeleniumTestSite = "https://www.seleniumeasy.com/test/";
          driver.get(urlSeleniumTestSite);
          WebElement closeLightBox = wait.until(ExpectedConditions.elementToBeClickable
                  (By.xpath("//*[@id='at-cv-lightbox-close']")));
          closeLightBox.click();
        WebElement inputForms = wait2.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//div[@class='collapse navbar-collapse']//" +
                        "a[contains(text(),'Input Forms')]")));
        inputForms.click();
        WebElement simpleFormDemo = wait2.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//div[@class='collapse navbar-collapse']//" +
                        "a[contains(text(),'Simple Form Demo')]")));
        simpleFormDemo.click();
        WebElement wrightText = wait2.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//div[@class='form-group']//input[@id='user-message']")));
        wrightText.sendKeys("Hello, my name is Ivan");
        WebElement showMessageButton = wait2.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//button[@class='btn btn-default'][contains(text(),'Show Message')]")));
        showMessageButton.click();
        String userMessageOnScreen = driver.findElement
                (By.xpath("//div[@id='user-message']//span[@id='display']")).getText();
        String userMessageInput = wrightText.getText();
        Assert.assertEquals(userMessageOnScreen, userMessageInput,
                "User text after entering must be equal to Text under Show Message button");
    }
  }

//java.lang.AssertionError: User text after entering must be equal to Text under Show Message button
//        Expected :
//        Actual   :Hello, my name is Ivan

