package main.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import api.models.User;
import org.junit.Assert;

public class SignInPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public final static String URL_SIGN_IN_PAGE = "https://stellarburgers.nomoreparties.site/login";

    @FindBy(how = How.XPATH, using = "//h2[text()='Вход']")
    private WebElement enterButton;

    @FindBy(how = How.XPATH, using = "//button[text()='Войти']")
    private WebElement signInButton;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Зарегистрироваться')]")
    private WebElement signUpButton;

    @FindBy(how = How.XPATH, using = "//label[text()='Email']//following-sibling::input")
    private WebElement emailField;

    @FindBy(how = How.XPATH, using = "//label[text()='Пароль']//following-sibling::input")
    private WebElement passwordField;

    @FindBy(how = How.XPATH, using = "//p[text()='Некорректный пароль']")
    private WebElement errorMessage;

    @FindBy(how = How.XPATH, using = "//div/p/a[text()='Войти']")
    private WebElement enterLinkButton;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    @Step("Клик по кнопке Зарегистрироваться")
    public SignUpPage clickSignUpButton() {
        signUpButton.click();
        return new SignUpPage(driver);
    }

    @Step("Ввод email")
    public SignInPage setEmail(String email) {
        emailField.click();
        emailField.sendKeys(email);
        return this;
    }

    @Step("Ввод пароля")
    public SignInPage setPassword(String password) {
        passwordField.click();
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Клик по кнопке Войти на странице логина")
    public MainPage clickSignInButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
        return new MainPage(driver);
    }

    @Step("Ввести данные пользователя при входе")
    public MainPage signInUser(User user) {
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        return clickSignInButton();
    }

    @Step("Ввести данные пользователя при регистрации")
    public MainPage signUpUser(String email, String password) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        setEmail(email);
        setPassword(password);
        return clickSignInButton();
    }

    @Step("Проверить что кнопка Войти есть на странице")
    public boolean isEnterButtonExist() {
        wait.until(ExpectedConditions.visibilityOf(enterButton));
        return enterButton.isDisplayed();
    }

    @Step("Проверка отображения текста с ошибкой")
    public SignInPage getErrorMessageText() {
        String actualErrorMessage = wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();
        Assert.assertEquals("Некорректный пароль", actualErrorMessage);
        return this;
    }

    @Step("Клик по ссылке Войти")
    public SignInPage clickEnterLinkButton() {
        enterLinkButton.click();
        return this;
    }
}