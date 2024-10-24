package main.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;

public class SignUpPage {

    private WebDriver driver;

    public final static String SIGN_UP_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";

    @FindBy(how = How.XPATH, using = "//label[text()='Имя']/following-sibling::input")
    private WebElement nameField;

    @FindBy(how = How.XPATH, using = "//*[text()='Email']/following-sibling::input")
    private WebElement emailField;

    @FindBy(how = How.XPATH, using = "//*[text()='Пароль']/following-sibling::input")
    private WebElement passwordField;

    @FindBy(how = How.XPATH, using = "//button[text()='Зарегистрироваться']")
    private WebElement confirmSignUpButton;

    @FindBy(how = How.XPATH, using = "//a[text()='Войти']")
    private WebElement signUpPageEnterButton;

    // Конструктор класса SignUpPage
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Ввод имени")
    public SignUpPage setName(String name) {
        nameField.sendKeys(name);
        return this;
    }

    @Step("Ввод Email")
    public SignUpPage setEmail(String email) {
        emailField.sendKeys(email)
        ;
        return this;
    }

    @Step("Ввод пароля")
    public SignUpPage setPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Клик по кнопке Зарегистрироваться и переход на страницу Регистрации")
    public SignInPage clickConfirmSignUpButton() {
        confirmSignUpButton.click();
        // Здесь вам нужно будет создать экземпляр класса SignInPage вручную и передать в него driver
        return new SignInPage(driver);
    }

    @Step("Клик по кнопке Войти")
    public SignInPage clickSignUpPageEnterButton() {
        signUpPageEnterButton.click();
        // Аналогично предыдущему шагу, создаём экземпляр SignInPage
        return new SignInPage(driver);
    }
}