package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    By txtUsername = By.name("username");
    By txtPassword = By.name("password");
    By btnSubmit = By.xpath("//button[1]");
    By btnUserSettings = By.xpath("//p[text()='Paul Collings']");
    By btnLogout = By.xpath("//a[text()='Logout']");
    By txtInvalidText = By.xpath("//p[text()='Invalid credentials']");

    WebDriverWait wait;

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtUsername)).sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtPassword)).sendKeys(password);
    }

    public void clickSubmitBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnSubmit)).click();
    }


    public String locateInvalidLoginText() {
        String invalidText = wait.until(ExpectedConditions.visibilityOfElementLocated(txtInvalidText)).getText();
        return invalidText;
    }


}
