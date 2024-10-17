package main.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public static String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    @FindBy(how = How.XPATH, using = "//button[text()='Войти в аккаунт']")
    private WebElement enterAccountButton;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Оформить заказ')]")
    private WebElement createOrderButton;

    @FindBy(how = How.XPATH, using = "//p[text()='Личный Кабинет']")
    private WebElement accountButton;

    @FindBy(how = How.XPATH, using = "//h1[text()='Соберите бургер']")
    private WebElement constructorHeader;

    @FindBy(how = How.XPATH, using = "//div[span[text()='Булки']]")
    private WebElement bunsButton;

    @FindBy(how = How.XPATH, using = "//div[span[text()='Соусы']]")
    private WebElement sauceButton;

    @FindBy(how = How.XPATH, using = "//span[contains(@class, 'text_type_main-default') and contains(., 'Начинки')]")
    private WebElement fillingsButton;

    @FindBy(how = How.XPATH, using = "//h2[text()='Булки']")
    private WebElement bunsHeader;

    @FindBy(how = How.XPATH, using = "//h2[text()='Соусы']")
    private WebElement sauceHeader;

    @FindBy(how = How.XPATH, using = "//h2[text()='Начинки']")
    private WebElement fillingsHeader;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'tab_tab_type_current__2BEPc') and contains(., 'Булки')]")
    private WebElement selectedBunsHeader;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'tab_tab_type_current__2BEPc') and contains(., 'Соусы')]")
    private WebElement selectedSauceHeader;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'tab_tab_type_current__2BEPc') and contains(., 'Начинки')]")
    private WebElement selectedFillingsHeader;

    @FindBy(how = How.CLASS_NAME, using = "tab_tab_type_current__2BEPc")
    private WebElement sectionIngredients;

    @FindBy(how = How.XPATH, using = "//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']")
    private WebElement constructorContainer;

    @FindBy(how = How.XPATH, using = "//p[text()='Некорректный пароль']")
    private WebElement errorMessage;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    @Step("Клик по кнопке Войти в аккаунт")
    public SignInPage clickEnterAccountButton() {
        enterAccountButton.click();
        return new SignInPage(driver);
    }

    @Step("Проверка кнопки Оформить заказ")
    public boolean isCreateOrderButtonExist() {
        wait.until(ExpectedConditions.visibilityOf(createOrderButton));
        return createOrderButton.isDisplayed();
    }

    @Step("Клик по кнопке Личного кабинета до авторизации")
    public SignInPage clickAccountButtonBeforeAuthorization() {
        accountButton.click();
        return new SignInPage(driver);
    }

    @Step("Клик по кнопке Личного кабинета после авторизации")
    public UserProfilePage clickAccountButtonAfterAuthorization() {
        accountButton.click();
        return new UserProfilePage(driver);
    }

    @Step("Проверка заголовка конструктора")
    public boolean isConstructorHeaderExist() {
        return constructorHeader.isDisplayed();
    }

    @Step("Клик по кнопке Булки в конструторе")
    public MainPage clickBunsButton() {
        bunsButton.click();
        return this;
    }

    @Step("Клик по кнопке Соусы в конструкторе")
    public MainPage clickSaucesButton() {
        sauceButton.click();
        return this;
    }

    @Step("Клик по кнопке Начинки в конструкторе")
    public MainPage clickFillingsButton() {
        fillingsButton.click();
        return this;
    }

    @Step("Проверка появления заголовка Булки")
    public boolean isBunsHeaderIsDisplayed() {
        return bunsHeader.isDisplayed();
    }

    @Step("Проверка появления заголовка Соусы")
    public boolean isSaucesHeaderIsDisplayed() {
        return sauceHeader.isDisplayed();
    }

    @Step("Проверка появления заголовка Начинки")
    public boolean isFillingsHeaderIsDisplayed() {
        return fillingsHeader.isDisplayed();
    }

    @Step("Проверка появления выбранной вкладки Булки")
    public boolean isSelectedBunsHeaderIsDisplayed() {
        return selectedBunsHeader.isDisplayed();
    }

    @Step("Проверка появления выбранной вкладки Соусы")
    public boolean isSelectedSaucesHeaderIsDisplayed() {
        return selectedSauceHeader.isDisplayed();
    }

    @Step("Проверка появления выбранной вкладки Начинки")
    public boolean isSelectedFillingsHeaderIsDisplayed() {
        return selectedFillingsHeader.isDisplayed();
    }

    @Step("Скролл до заголовка Булки")
    public MainPage scrollToBunsHeader() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bunsHeader);
        return this;
    }

    @Step("Скролл до заголовка Соусы")
    public MainPage scrollToSaucesHeader() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sauceHeader);
        return this;
    }

    @Step("Скролл до заголовка Начинки")
    public MainPage scrollToFillingsHeader() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fillingsHeader);
        return this;
    }

    @Step("Проверка сообщения об ошибке")
    public boolean isErrorMessageExist() {
        try {
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}