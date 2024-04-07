package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import resources.BaseClass;

public class LoginPageTests extends BaseClass {
    public WebDriver driver;
    public LoginPage loginPage;
    public DashboardPage dashboardPage;


    @BeforeMethod
    public void initialize() {
        driver = initializeDriver();
    }

    @Test(priority = 0)
    public void checkLoginSuccessful() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin12");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(dashboardPage.isUserLoggedIn(), "User managed to logged in successfully");
    }

    @Test(priority = 1)
    public void checkLoginUnsuccessful() {
        loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin1234");
        loginPage.clickSubmitBtn();
        String expectedText = "Invalid credentials";

        Assert.assertEquals(loginPage.locateInvalidLoginText(), expectedText, "User logged in no errors occurred");

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        System.out.println("Browser closed");
    }

}
