package testSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



public class BaseClass {
    public WebDriver driver = new ChromeDriver();
    public WebDriverWait wait = new WebDriverWait(driver, 25);
    public WebDriverWait wait2 = new WebDriverWait(driver, 7);


    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        String urlSeleniumTestSite = "https://www.seleniumeasy.com/test/";
        driver.get(urlSeleniumTestSite);
        WebElement closeLightBox = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@id='at-cv-lightbox-close']")));
        closeLightBox.click();
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        driver.quit();
        System.out.println("Test is finished");
    }
}