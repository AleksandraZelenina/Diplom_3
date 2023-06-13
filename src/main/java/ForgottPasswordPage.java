import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgottPasswordPage {
    private final By singInBtn = By.xpath(".//a[text()='Войти']"); //кнопка вход

    private final WebDriver driver;

    public ForgottPasswordPage(WebDriver webDriver) {
        driver = webDriver;
    }

    public void clickSingInBtn() {
        driver.findElement(singInBtn).click();
    }
}
