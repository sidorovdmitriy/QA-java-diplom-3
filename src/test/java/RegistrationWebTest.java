import api.clients.UserClient;
import api.generator.UserGenerator;
import api.models.Credentials;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;

import manager.BrowserFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import manager.TestValue;
import main.page.MainPage;
import org.openqa.selenium.WebDriver;


/**
 * Проверяем:
 * Успешная регистрация пользователя
 * Некорректная регистрация пользователя
 * Удаляем пользователей после того, как создали
 */
public class RegistrationWebTest{

    private UserClient userClient;
    public WebDriver driver;
    protected String name = UserGenerator.getUser().getName();
    protected String email = UserGenerator.getUser().getEmail();
    protected String password = UserGenerator.getUser().getPassword();


    @Before
    @Step("Открыть base url")
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
    }

    @Test
    @DisplayName("Успешная регистрация пользователя")
    @Description("Успешная регистрация пользователя")
    public void checkSuccessRegistration() {
        driver.get(MainPage.MAIN_PAGE_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickEnterAccountButton()
                .clickSignUpButton()
                .setName(name)
                .setEmail(email)
                .setPassword(password)
                .clickConfirmSignUpButton()
                .signUpUser(email, password);
    }

    @Test
    @DisplayName("Некорректная регистрация пользователя")
    @Description("Используем некорректный для регистрации пароль")
    public void checkErrorRegistration() {
        driver.get(MainPage.MAIN_PAGE_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickEnterAccountButton()
                .clickSignUpButton()
                .setName(name)
                .setEmail(email)
                .setPassword(TestValue.PASSWORD_ERROR)
                .clickConfirmSignUpButton()
                .getErrorMessageText()
                .clickEnterLinkButton()
                .signUpUser(email, TestValue.PASSWORD_ERROR)
                .isErrorMessageExist();
    }

    @After
    public void tearDown() {
        userClient = new UserClient();
        Credentials credentials = new Credentials(email, password);
        Response response = UserClient.login(credentials);
        if (response.body().jsonPath().getString("accessToken") != null) {
            userClient.delete(response);
        }

        Credentials userInValidCredentials = new Credentials(email, TestValue.PASSWORD_ERROR);
        Response inValidResponse = UserClient.login(userInValidCredentials);
        if (inValidResponse.body().jsonPath().getString("accessToken") != null) {
            userClient.delete(inValidResponse);
        }

        if (driver != null) {
            driver.quit();
        }
    }
}

