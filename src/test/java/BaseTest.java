
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest extends WebDriverCreator {
    private final String URL = "https://stellarburgers.nomoreparties.site/";
    public WebDriver driver;
    User user;
    UserApi userApi = new UserApi();
    private String bearerToken;

    @Before
    public void setUp() {
        driver = createWebDriver();
        driver.get(URL);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        userApi = new UserApi();
        user = new UserGenerateData().getRandomUser();
    }

    @After
    public void tearDown() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.quit();
        if (user != null) {
            ValidatableResponse responseLogin = UserApi.userLogin(user);
            bearerToken = responseLogin.extract().path("accessToken");
            if (bearerToken == null) {
                return;
            }
            UserApi.deleteUser(bearerToken);
        }
    }
}


