import api.models.User;
import io.qameta.allure.junit4.DisplayName;
import main.page.SignInPage;
import org.junit.Test;
import org.junit.Assert;
/**
 * Проверяем:
 * Выход из личного кабинета через кнопку Выйти
 */
public class ExitTest extends BaseTest {
    @Test
    @DisplayName("Выход из личного кабинета через кнопку Выйти")
    public void logoutUserProfileButtonTest(){
        driver.get(SignInPage.URL_SIGN_IN_PAGE);
        SignInPage signInPage = new SignInPage(driver);
        signInPage.setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickSignInButton()
                .clickAccountButtonAfterAuthorization()
                .clickLogOutButton();
        Assert.assertTrue("Кнопка входа должна быть видимой после логаута", signInPage.isEnterButtonExist());
    }
}
