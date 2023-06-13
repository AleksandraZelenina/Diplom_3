import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class GoToAndFromProfilePageTest extends BaseTest {
    @Test
    @DisplayName("Переход в Личный кабинет неавторизованного пользователя")
    @Description("Проверка, что открывается раздел Личный кабинет(форма входа), когда пользователь не авторизован")
    public void goToProfilePageWithoutAuth() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickPersonalAccountBtn();
        loginPage.checkSingInBtnIsDisplayed();
    }

    @Test
    @DisplayName("Переход в Личный кабинет авторизованного пользователя")
    @Description("Проверка, что открывается раздел Личный кабинет(профиль), когда пользователь авторизован")
    public void goToProfilePageWithAuth() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        userApi.userReg(user);
        loginPage.setSingInUserAccount(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountBtn();
        profilePage.checkAccountTextIsDisplayed();
    }

    @Test
    @DisplayName("Переход из Личного кабинета неавторизованного пользователя в Конструктор")
    @Description("Проверка, что открывается раздел Конструктор, когда пользователь не авторизован")
    public void goFromProfilePageWithoutAuth() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickPersonalAccountBtn();
        loginPage.clickConstructorBtn();
        mainPage.checkCreateBurgerTextIsDisplayed();
    }

    @Test
    @DisplayName("Переход из Личного кабинета авторизованного пользователя в Конструктор")
    @Description("Проверка, что открывается раздел Конструктор и есть кнопка Оформить заказ, когда пользователь авторизован")
    public void goFromProfilePageWithAuth() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        userApi.userReg(user);
        loginPage.setSingInUserAccount(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountBtn();
        profilePage.clickConstructorBtn();
        mainPage.checkCreateBurgerBtnIsDisplayed();
    }

    @Test
    @DisplayName("Переход из Личного кабинета авторизованного пользователя по клику на логотип")
    @Description("Проверка, что открывается главная станица, когда авторизованный пользователь кликнул на логотип")
    public void goFromProfilePageWithAuthWhenClickLogo() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        userApi.userReg(user);
        loginPage.setSingInUserAccount(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountBtn();
        profilePage.clickLogoBtn();
        mainPage.checkCreateBurgerBtnIsDisplayed();
    }
}

