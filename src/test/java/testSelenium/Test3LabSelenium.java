package testSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Test3LabSelenium {
    WebDriver driver;

    @Test
    public void thirdTestSelenium() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        String urlSeleniumTestSite = "https://www.seleniumeasy.com/test/";
        driver.get(urlSeleniumTestSite);
        WebElement closeLightBox = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@id='at-cv-lightbox-close']")));
        closeLightBox.click();

        WebElement inputFormsLink = wait2.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//div[@class='collapse navbar-collapse']//" +
                        "a[contains(text(),'Input Forms')]")));
        inputFormsLink.click();
        WebElement checkBoxDemoLink = wait2.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//div[@class='collapse navbar-collapse']" +
                        "//a [contains(text(),'Checkbox Demo')]")));
        checkBoxDemoLink.click();
        WebElement option1CheckBoxDemoLink = wait2.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//label[text()='Option 1']")));
        option1CheckBoxDemoLink.click();
        WebElement option3CheckBoxDemoLink = wait2.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//label[text()='Option 3']")));
        option3CheckBoxDemoLink.click();

        Assert.assertTrue(option1CheckBoxDemoLink.isSelected(), "Option 1 Link" +
                " must be selected");
        Assert.assertTrue(option1CheckBoxDemoLink.isSelected(), "Option 3 Link" +
                " must be selected");
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        driver.quit();
        System.out.println("Test is finished");
    }
}

