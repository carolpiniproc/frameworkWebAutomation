package Settings;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Driver {

    private static WebDriver driver;
    private static Dimension dimension;
    private static WebDriverWait wait;

    public static void abreBrowser()
    {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
       // driver.get(url);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public static void quitProcess()
    {
       driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setUrl(String url){
        driver.get(url);
    }

    public static void setDimension(int x,int y){
        dimension = new Dimension(x,y);
        driver.manage().window().setSize(dimension);
    }

    public static WebElement waitVisibleElement(By by){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitInvisibilityElement(By by){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static Alert waitIsPresentAlert(){
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public static WebElement waitIsClickable(By by){
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
}