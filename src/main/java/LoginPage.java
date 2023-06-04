import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginPage {
    private final By personalAccountBtn = By.xpath(".//p[contains(text(),'Личный Кабинет')]"); //кнопка личный кабинет
    private final By registrationBtn = By.xpath(".//a[(@class = 'Auth_link__1fOlj' and text()= 'Зарегистрироваться')]"); //кнопка зарегистрироваться внизу
    private final By forgottPasswordBtn = By.xpath(".//a[(@class = 'Auth_link__1fOlj' and text()= 'Восстановить пароль')]"); //кнопка восстановить пароль
    private final By singInBtn = By.xpath(".//button[text()='Войти']"); //кнопка войти
    private final By emailInput = By.xpath("//label[contains(text(),'Email')]/../input"); // поле емаил
    private final By passwordInput = By.xpath("//label[contains(text(),'Пароль')]/../input"); //поле пароль
    private final By constructorBtn = By.xpath(".//p[text()='Конструктор']"); //кнопка конструктор


    private final WebDriver driver;

    public LoginPage(WebDriver webDriver) {
        driver = webDriver;
    }

    public void clickSingInBtn() {
        driver.findElement(singInBtn).click();
    }

    public void clickRegistrationBtn() {
        driver.findElement(registrationBtn).click();
    }

    public void clickForgottPasswordBtn() {
        driver.findElement(forgottPasswordBtn).click();
    }

    public void clickPersonalAccountBtn() {
        driver.findElement(personalAccountBtn).click();
    }

    public void setEmailInput(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPasswordInput(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void setSingInUserAccount(String email, String password) {
        clickPersonalAccountBtn();
        setEmailInput(email);
        setPasswordInput(password);
        clickSingInBtn();
    }

    public void checkSingInBtnIsDisplayed() {
        assertThat("После выхода из профиля отображается кнопка Войти", true,
                equalTo(driver.findElement(personalAccountBtn).isDisplayed()));
    }

    public void clickConstructorBtn() {
        driver.findElement(constructorBtn).click();
    }

    public void findForgottPasword() {
        WebElement element = driver.findElement(forgottPasswordBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}


