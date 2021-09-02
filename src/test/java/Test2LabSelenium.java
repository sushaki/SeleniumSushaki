import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Test2LabSelenium {
    //      WebDriver driver;
    //      WebDriverWait wait;
    //      WebDriverWait wait2;

        @Test
    public void secondTestSelenium() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 25);
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
        WebElement simpleFormDemoLink = wait2.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//div[@class='collapse navbar-collapse']//" +
                        "a[contains(text(),'Simple Form Demo')]")));
        simpleFormDemoLink.click();

        WebElement enterValueAField = wait2.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//div[@class='form-group']//input[@id='sum1']")));
        enterValueAField.sendKeys("8");

        WebElement enterValueBField = wait2.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//div[@class='form-group']//input[@id='sum2']")));
        enterValueBField.sendKeys("9");

        WebElement totalValueButton = wait2.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//button[@class='btn btn-default'][contains(text(),'Get Total')]")));
        totalValueButton.click();

        String totalResultLineOnPage = driver.findElement
                (By.xpath("//span[@id='displayvalue']")).getText();

            Integer valueA = new Integer(enterValueAField.getText());
            Integer valueB = new Integer(enterValueBField.getText());
            Integer expectedTotalValue = valueA + valueB;
            Integer actualTotalValue = new Integer(totalResultLineOnPage);

        Assert.assertEquals(actualTotalValue, expectedTotalValue,
                "Expected total value must be equal to value under 'GET TOTAL' button");
    }

//    @AfterTest(alwaysRun = true)
//    public void afterTest() {
//        driver.quit();
//        System.out.println("Test is finished");
    }



