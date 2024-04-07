package resources;

import common.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    WebDriver driver;
    String url = "https://opensource-demo.orangehrmlive.com/web/auth/login";

    public WebDriver initializeDriver() {
        WebDriverManager.chromedriver().setup();
        DesiredCapabilities dcap = new DesiredCapabilities();
        driver = new ChromeDriver(getChromeOptions(dcap));
        driver.navigate().to(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    static ChromeOptions getChromeOptions(DesiredCapabilities desiredCapabilities) {
        ChromeOptions chromeOptions = new ChromeOptions();
        if (Constants.HEADELESS.equalsIgnoreCase("true")) {
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--no-sandbox");
            desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            chromeOptions.merge(desiredCapabilities);
            return chromeOptions;
        }
        return chromeOptions;
    }


}
