package pages;

import org.openqa.selenium.WebDriver;

public class PageManager {
    private WebDriver driver;
    public LoginPage loginPage;
    public DashboardPage dashboardPage;


    public PageManager(WebDriver driver){
        this.driver = driver;
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }
}
