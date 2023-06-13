import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ProfilePage {
    private final By singOutBtn = By.xpath(".//button[text()='Выход']"); //кнопка выход
    private final By constructorBtn = By.xpath(".//p[text()='Конструктор']"); //кнопка конструктор
    private final By logoBtn = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']"); //кнопка лого
    private final By accountText = By.xpath(".//p[text() = 'В этом разделе вы можете изменить свои персональные данные']"); //текст в профиле при авториизации


    private final WebDriver driver;

    public ProfilePage(WebDriver webDriver) {
        driver = webDriver;
    }

    public void clickSingOutBtn() {
        driver.findElement(singOutBtn).click();
    }

    public void clickConstructorBtn() {
        driver.findElement(constructorBtn).click();
    }

    public void clickLogoBtn() {
        driver.findElement(logoBtn).click();
    }

    public void checkAccountTextIsDisplayed() {
        assertThat("В авторизованном профиле отображается информационное сообщение", true,
                equalTo(driver.findElement(accountText).isDisplayed()));
    }
}
