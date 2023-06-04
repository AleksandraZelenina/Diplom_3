import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class MenuConstructorTest extends TestBase {
    @Test
    @DisplayName("Переход к разделу 'Булки'")
    @Description("Проверка, что можно перейти в раздел 'Булки' ")
    public void openCatalogBuns() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickSaucesBtn();
        mainPage.clickBunBtn();
        mainPage.checkBunsIsDisplayed();
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    @Description("Проверка, что можно перейти в раздел 'Соусы' ")
    public void openCatalogSauces() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickFillingsBtn();
        mainPage.clickSaucesBtn();
        mainPage.checkSaucesIsDisplayed();
    }

    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    @Description("Проверка, что можно перейти в раздел 'Начинки' ")
    public void openCatalogFillings() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickSaucesBtn();
        mainPage.clickFillingsBtn();
        mainPage.checkFillingsIsDisplayed();
    }
}

