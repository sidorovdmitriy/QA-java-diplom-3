import io.qameta.allure.junit4.DisplayName;
import page.MainPage;
import page.ResetPasswordPage;
import page.SignUpPage;
import org.junit.Test;
import org.junit.Assert;


/**
 * Проверяем:
 * Вход по кнопке «Войти в аккаунт» на главной странице
 * Вход через кнопку Личный кабинет
 * Вход через кнопку в форме регистрации
 * Вход через кнопку в форме восстановления пароля
 */
public class LoginWebTest extends BaseTest {

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной странице")
    public void signInButtonMainPageTest() {
        driver.get(MainPage.MAIN_PAGE_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickEnterAccountButton()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickSignInButton();
        Assert.assertTrue(mainPage.isCreateOrderButtonExist());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void signInButtonUserProfileTest() {
        driver.get(MainPage.MAIN_PAGE_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAccountButtonBeforeAuthorization()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickSignInButton();
        Assert.assertTrue(mainPage.isCreateOrderButtonExist());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void signInButtonSignUpTest() {
        driver.get(SignUpPage.SIGN_UP_PAGE_URL);
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.clickSignUpPageEnterButton()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickSignInButton()
                .isCreateOrderButtonExist();
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void signInButtonResetPasswordTest() {
        driver.get(ResetPasswordPage.RESET_PASSWORD_PAGE_URL);
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);
        resetPasswordPage.clickResetPasswordButton()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickSignInButton()
                .isCreateOrderButtonExist();
    }
}