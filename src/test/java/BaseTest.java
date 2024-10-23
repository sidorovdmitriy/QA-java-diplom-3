import api.clients.Client;
import api.clients.UserClient;
import api.generator.UserGenerator;
import api.models.Credentials;
import api.models.User;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import manager.BrowserFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Родительский класс для тестов, содержит
 * создание фейкового пользователя
 * метод для выбора браузера yandex/chrome
 * и метод для удаления пользователя и закрытия браузера
 */
public class BaseTest {
    public static final User user = UserGenerator.getUser();
    public WebDriver driver;
    public UserClient userClient;

    @Before
    @Step("Открыть base url")
    public void setUp() throws IOException {
        Properties props = new Properties();
        FileInputStream ip = new FileInputStream("C:\\Users\\79276\\IdeaProjects\\new\\QA-java-diplom-3\\src\\main\\resources\\application.properties");
        props.load(ip);
        driver = BrowserFactory.getDriver(props.getProperty("browser"));
        driver.get(Client.BASE_URL);
        userClient = new UserClient();
        userClient.createUser(user);
    }

    @After
    @Step("Закрытие браузера")
    public void cleanUp() {
        Credentials credentials = new Credentials(user.getEmail(), user.getPassword());
        Response response = UserClient.login(credentials);
        if (response.body().jsonPath().getString("accessToken") != null) {
            userClient.delete(response);
        }
        driver.quit();
    }
}