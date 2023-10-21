package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    By lblDashboard = By.xpath("//h6[text()='Dashboard']");

    WebDriverWait wait;
    public WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }


    public boolean isUserLoggedIn() {
        if (wait.until(ExpectedConditions.visibilityOfElementLocated(lblDashboard)).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }
}
