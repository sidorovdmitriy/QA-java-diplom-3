package main.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;

public class ResetPasswordPage {

    private WebDriver driver;

    public final static String RESET_PASSWORD_PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    @FindBy(xpath = "//a[text()='Войти']")
    private WebElement linkResetPasswordToLoginForm;

    // Конструктор класса ResetPasswordPage
    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Кликнуть Войти на странице восстановления пароля")
    public SignInPage clickResetPasswordButton() {
        linkResetPasswordToLoginForm.click();
        // В Selenium вам нужно создать экземпляр следующей страницы вручную, передав туда driver
        return new SignInPage(driver);
    }
}