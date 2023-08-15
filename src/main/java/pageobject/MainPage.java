package pageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class MainPage {
    private WebDriver driver;
    private By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private By accountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private By bunButton = By.xpath(".//span[text()='Булки']");
    private By sauceButton = By.xpath(".//span[text()='Соусы']");
    private By fillingButton = By.xpath(".//span[text()='Начинки']");
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    public void clickAccountButton() {
        driver.findElement(accountButton).click();
    }
    public void clickBunButton() {
        driver.findElement(bunButton).click();
    }
    public void clickSauceButton() {
        driver.findElement(sauceButton).click();
    }
    public void clickFillingButton() {
        driver.findElement(fillingButton).click();
    }

}
