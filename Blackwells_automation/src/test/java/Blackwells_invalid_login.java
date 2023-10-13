import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Blackwells_invalid_login {

    private WebDriver driver;

    @Test
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://blackwells.co.uk");
        WebElement closeButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
        closeButton.click();
        WebElement loginButton = driver.findElement(By.className("mobile-icon-account"));
        loginButton.click();
        WebElement emailAddress = driver.findElement(By.id("login_username"));
        emailAddress.sendKeys("test@test.com");
        WebElement password = driver.findElement(By.id("login_password"));
        password.sendKeys("test123");
        WebElement loginButton2 = driver.findElement(By.name("submitLogin"));
        loginButton2.click();
        WebElement error = driver.findElement(By.className("is-error"));
        Assertions.assertTrue(error.isDisplayed());
        System.out.println("Error message is displayed");

        driver.close();

    }
}
