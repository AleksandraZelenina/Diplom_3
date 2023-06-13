import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RegistrationPage {
    private final By nameInput = By.xpath("//label[contains(text(),'Имя')]/../input"); // поле имя
    private final By emailInput = By.xpath("//label[contains(text(),'Email')]/../input"); // поле email
    private final By passwordInput = By.xpath("//label[contains(text(),'Пароль')]/../input"); // поле пароль
    private final By registrationFinallyBtn = By.xpath(".//button[text()='Зарегистрироваться']"); //кнопка зарегистрироваться
    private final By singInBtn = By.xpath("//a[text()='Войти']"); //кнопка вход
    private final By errorShortPassword = By.xpath(".//p[text() = 'Некорректный пароль']"); //информация о некорректном пароле


    private final WebDriver driver;

    public RegistrationPage(WebDriver webDriver) {
        driver = webDriver;
    }

    public void setNameInput(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void setEmailInput(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPasswordInput(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickRegistrationBtn() {
        driver.findElement(registrationFinallyBtn).click();
    }

    public void clickSingInBtn() {
        driver.findElement(singInBtn).click();
    }

    public void setRegistrationNewUser(String name, String email, String password) {
        setNameInput(name);
        setEmailInput(email);
        setPasswordInput(password);
        clickRegistrationBtn();
    }

    public void checkErrorAboutShortPassword() {
        assertThat("В авторизованном профиле отображается информационное сообщение", true,
                equalTo(driver.findElement(errorShortPassword).isDisplayed()));
    }
}

