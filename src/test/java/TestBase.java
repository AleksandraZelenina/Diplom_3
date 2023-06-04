import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {
    private final String URL = "https://stellarburgers.nomoreparties.site/";
    public WebDriver driver;
    User user;
    UserApi userApi = new UserApi();
    private String bearerToken;

    @Before
    public void setUp() {
        //Хром браузер (по умолчанию).
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

        //Яндекс браузер. Для запуска тестов через данный браузер, нужно его раскомментить и закомментить 4 строки с браузером хром
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
//        driver = new ChromeDriver();

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


