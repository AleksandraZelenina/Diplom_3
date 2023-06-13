import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class SignOutTest extends BaseTest {

    @Test
    @DisplayName("Выход из аккаунта авторизованного пользователя")
    @Description("Проверка, что можно выйти из аккаунта авторизованного пользователя")
    public void canSingOutFromProfile() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        userApi.userReg(user);
        loginPage.setSingInUserAccount(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountBtn();
        profilePage.clickSingOutBtn();
        profilePage.checkAccountTextIsDisplayed();
    }
}
