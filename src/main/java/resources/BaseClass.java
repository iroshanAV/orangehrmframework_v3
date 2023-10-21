package resources;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {
WebDriver driver;
String url = "https://opensource-demo.orangehrmlive.com/web/auth/login";

public WebDriver initializeDriver(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.navigate().to(url);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    return  driver;
}

}
