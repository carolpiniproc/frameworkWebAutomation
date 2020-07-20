package Settings;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static WebDriver driver;
    private static Dimension dimension;

    public static void abreBrowser()
    {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
       // driver.get(url);
        driver.manage().window().maximize();
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


}