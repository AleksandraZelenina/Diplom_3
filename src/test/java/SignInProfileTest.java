import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class SignInProfileTest extends BaseTest {

    @Test
    @DisplayName("Вход в профиль через кнопку 'Войти в аккаунт' на главной странице")
    @Description("Проверка, что можно войти в аккаунт через кнопку 'Войти в аккаунт' на главной странице")
    public void singInWithBtnOnHeadPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        userApi.userReg(user);
        mainPage.clickSingInCentralBtn();
        loginPage.setSingInUserAccount(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountBtn();
        profilePage.checkAccountTextIsDisplayed();
    }

    @Test
    @DisplayName("Вход в профиль через кнопку 'Личный кабинет'")
    @Description("Проверка, что можно войти в аккаунт через кнопку 'Личный кабинет'")
    public void singInWithProfileBtn() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        userApi.userReg(user);
        mainPage.clickPersonalAccountBtn();
        loginPage.setSingInUserAccount(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountBtn();
        profilePage.checkAccountTextIsDisplayed();
    }

    @Test
    @DisplayName("Вход в профиль через кнопку 'Войти' в форме регистрации")
    @Description("Проверка, что можно войти в аккаунт через кнопку 'Войти' в форме регистрации")
    public void singInWithBtnOnRegistrationPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        userApi.userReg(user);
        mainPage.clickPersonalAccountBtn();
        loginPage.clickRegistrationBtn();
        registrationPage.clickSingInBtn();
        loginPage.setSingInUserAccount(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountBtn();
        profilePage.checkAccountTextIsDisplayed();
    }

    @Test
    @DisplayName("Вход в профиль через кнопку 'Войти' в форме восстановления пароль")
    @Description("Проверка, что можно войти в аккаунт через кнопку 'Войти' в форме регистрации")
    public void singInWithBtnOnForgottPasswordPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        ForgottPasswordPage forgottPasswordPage = new ForgottPasswordPage(driver);

        userApi.userReg(user);
        mainPage.clickPersonalAccountBtn();
        loginPage.findForgottPasword();
        loginPage.clickForgottPasswordBtn();
        forgottPasswordPage.clickSingInBtn();
        loginPage.setSingInUserAccount(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountBtn();
        profilePage.checkAccountTextIsDisplayed();
    }
}
