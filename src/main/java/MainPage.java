import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MainPage {
    private final By personalAccountBtn = By.xpath(".//p[contains(text(),'Личный Кабинет')]"); //кнопка личный кабинет
    private final By singInCentralBtn = By.xpath(".//button[text()='Войти в аккаунт']"); //кнопка войти
    private final By createOrderBtn = By.xpath(".//button[text()='Оформить заказ']"); //кнопка оформить заказ
    private final By bunBtn = By.xpath(".//div[span[text()='Булки']]"); // вкладка булки
    private final By saucesBtn = By.xpath(".//div[span[text()='Соусы']]"); // вкладка соусы
    private final By fillingsBtn = By.xpath(".//div[span[text()='Начинки']]"); // вкладка начинки
    private final By constructorBtn = By.xpath(".//p[text()='Конструктор']"); //кнопка конструктор


    private final WebDriver driver;

    public MainPage(WebDriver webDriver) {
        driver = webDriver;
    }

    public void clickBunBtn() {
        driver.findElement(bunBtn).click();
    }

    public void clickSaucesBtn() {
        driver.findElement(saucesBtn).click();
    }

    public void clickFillingsBtn() {
        driver.findElement(fillingsBtn).click();
    }

    public void clickSingInCentralBtn() {
        driver.findElement(singInCentralBtn).click();
    }

    public void clickPersonalAccountBtn() {
        driver.findElement(personalAccountBtn).click();
    }

    public void checkBunsIsDisplayed() {
        assertThat("Вкладка Булки отображается", true,
                equalTo(driver.findElement(By.xpath("//div[contains(span/text(),'Булки') and contains(@class,'current')]")).isDisplayed()));
    }

    public void checkSaucesIsDisplayed() {
        assertThat("Вкладка Соусы отображается", true,
                equalTo(driver.findElement(By.xpath("//div[contains(span/text(),'Соусы') and contains(@class,'current')]")).isDisplayed()));
    }

    public void checkFillingsIsDisplayed() {
        assertThat("Вкладка Начинки отображается", true,
                equalTo(driver.findElement(By.xpath("//div[contains(span/text(),'Начинки') and contains(@class,'current')]")).isDisplayed()));
    }

    public void checkCreateBurgerTextIsDisplayed() {
        assertThat("Отображается раздел Соберите бургер", true,
                equalTo(driver.findElement(By.xpath(".//h1[text() = 'Соберите бургер']")).isDisplayed()));
    }

    public void checkCreateBurgerBtnIsDisplayed() {
        assertThat("Отображается кнопка Оформить заказ", true,
                equalTo(driver.findElement(createOrderBtn).isDisplayed()));
    }
}
