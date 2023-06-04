import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class CreateUserTest extends TestBase {
    @Test
    @DisplayName("Регистрация пользователя с валидными данными")
    @Description("Проверка, что можно зарегистрировать пользователя с валидными данными ")
    public void createNewUser() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        user = new UserGenerateData().getRandomUser();

        mainPage.clickPersonalAccountBtn();
        loginPage.clickRegistrationBtn();
        registrationPage.setRegistrationNewUser(user.getName(), user.getEmail(), user.getPassword());
        loginPage.setSingInUserAccount(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountBtn();
        profilePage.checkAccountTextIsDisplayed();
    }

    //при обсуждении кейса ниже у некоторых появлялся баг, что пользователь не логинился. поэтому решила добавить тест
    @Test
    @DisplayName("Регистрация пользователя с валидными данными через API")
    @Description("Проверка, что можно зарегистрировать пользователя с валидными данными через API")
    public void createNewUserWithApi() {
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
    @DisplayName("Регистрация пользователя с коротким паролем")
    @Description("Проверка, что нельзя зарегистрировать пользователя с паролем менее 6 символов")
    public void createNewUserWithShortPassword() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        user = new UserGenerateData().getRandomUser();
        user.setPassword(RandomStringUtils.randomAlphabetic(3));

        mainPage.clickPersonalAccountBtn();
        loginPage.clickRegistrationBtn();
        registrationPage.setRegistrationNewUser(user.getName(), user.getEmail(), user.getPassword());
        registrationPage.checkErrorAboutShortPassword();
    }
}
