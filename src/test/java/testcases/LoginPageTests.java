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
        System.out.println("Start of the test case 1");
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(dashboardPage.isUserLoggedIn(), "User managed to logged in successfully");
        System.out.println("End of the test case 1");
    }

    @Test(priority = 1)
    public void checkLoginUnsuccessful() {
        System.out.println("Start of the test case 2");
        loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin1234");
        loginPage.clickSubmitBtn();
        String expectedText = "Invalid credentials";

        Assert.assertEquals(loginPage.locateInvalidLoginText(), expectedText, "User logged in no errors occurred");
        System.out.println("End of the test case 2");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        System.out.println("Browser closed");
    }

}
