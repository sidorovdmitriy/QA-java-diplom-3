import io.qameta.allure.junit4.DisplayName;
import page.SignInPage;
import org.junit.Test;

/**
 * Проверяем:
 * Переход из Личного кабинета на главную страницу через кнопку Конструтор
 * Переход из Личного кабинета на главную страницу через кнопку Лого
 * Провека перехода по клику на «Личный кабинет»
 */
public class TransitionTest extends BaseTest {
    @Test
    @DisplayName("Переход из Личного кабинета на главную страницу через кнопку Конструтор")
    public void openConstructorButtonTest() {
        driver.get(SignInPage.URL_SIGN_IN_PAGE);
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signInUser(user)
                .clickAccountButtonAfterAuthorization()
                .clickConstructorButton()
                .isConstructorHeaderExist();
    }

    @Test
    @DisplayName("Переход из Личного кабинета на главную страницу через кнопку Лого")
    public void openLogoPictureTest() {
        driver.get(SignInPage.URL_SIGN_IN_PAGE);
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signInUser(user)
                .clickAccountButtonAfterAuthorization()
                .clickLogoPicture()
                .isConstructorHeaderExist();
    }

    @Test
    @DisplayName("Провека перехода по клику на Личный кабинет")
    public void clickUserProfileButtonTest() {
        driver.get(SignInPage.URL_SIGN_IN_PAGE);
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signInUser(user)
                .clickAccountButtonAfterAuthorization()
                .isUserProfileHeaderExist();
    }
}