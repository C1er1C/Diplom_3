import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.ProfilePage;
import user.User;
import user.UserDataGenerator;
import user.UserSteps;

import java.time.Duration;

public class LogoutTest {
    public WebDriver driver;
    private User user;
    private String accessToken;
    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--no-sandbox", "--headless", "--disable-dev-shm-usage"});
        driver = new ChromeDriver(options);
        driver.get(UserSteps.baseURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
        user = UserDataGenerator.getRandomUser();
        accessToken = UserSteps.createNewUser(user).then().extract().path("accessToken");
    }
    @Test
    @DisplayName("Ыфход из аккаунта в личном кабинете")
    public void logoutFromProfilePageTest(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        mainPage.clickAccountButton();
        loginPage.setUserLoginInfo(user.getEmail(), user.getPassword());
        loginPage.clickLoginButton();
        mainPage.clickAccountButton();
        profilePage.clickLogoutButton();
        String text = loginPage.getLoginLabelText();
        Assert.assertEquals("Вход", text);
    }
    @After
    public void tearDown(){
        driver.quit();
        if (accessToken != null) {
            UserSteps.deleteUser(accessToken);
        }
    }
}
