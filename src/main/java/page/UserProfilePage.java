package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;

public class UserProfilePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(how = How.XPATH, using = "//a[text()='Профиль']")
    private WebElement userProfileButton;

    @FindBy(how = How.XPATH, using = "//p[text()='Конструктор']")
    private WebElement constructorButton;

    @FindBy(how = How.XPATH, using = "//div[@class='AppHeader_header__logo__2D0X2']")
    private WebElement logoPicture;

    @FindBy(how = How.XPATH, using = "//button[text()='Выход']")
    private WebElement logoutButton;

    public UserProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10); // Устанавливаем таймаут ожидания в 10 секунд
        PageFactory.initElements(driver, this);
    }

    @Step("Кликнуть на кнопку Выход")
    public SignInPage clickLogOutButton() {
        logoutButton.click();
        // В Selenium вам нужно создать экземпляр следующей страницы вручную, передав туда driver
        return new SignInPage(driver);
    }

    @Step("Проверка что заголовок Профиль существует")
    public boolean isUserProfileHeaderExist() {
        wait.until(ExpectedConditions.visibilityOf(userProfileButton));
        return userProfileButton.isDisplayed();
    }

    @Step("Клик по кнопке конструктора")
    public MainPage clickConstructorButton() {
        constructorButton.click();
        // В Selenium вам нужно создать экземпляр следующей страницы вручную, передав туда driver
        return new MainPage(driver);
    }

    @Step("Клик по Лого")
    public MainPage clickLogoPicture() {
        logoPicture.click();
        // В Selenium вам нужно создать экземпляр следующей страницы вручную, передав туда driver
        return new MainPage(driver);
    }
}