import io.qameta.allure.junit4.DisplayName;
import main.page.MainPage;
import org.junit.Assert;
import org.junit.Test;


/**
 * Проверяем:
 * Переход к разделу: Булки, Соусы, Начинки
 * Скролл к разделу: Булки, Соусы, Начинки
 */
public class ConstructorSectionTest extends BaseTest {


    @Test
    @DisplayName("Переход к разделу Булки")
    public void clickBunsSectionButtonTest() {
        driver.get(MainPage.MAIN_PAGE_URL);
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isSelectedBunsHeaderIsDisplayed());
    }

    @Test
    @DisplayName("Переход к разделу Соусы")
    public void clickSaucesSectionButtonTest() {
        driver.get(MainPage.MAIN_PAGE_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSaucesButton();
        Assert.assertTrue(mainPage.isSelectedSaucesHeaderIsDisplayed());
    }

    @Test
    @DisplayName("Переход к разделу Начинки")
    public void clickFillingsSectionButtonTest() {
        driver.get(MainPage.MAIN_PAGE_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillingsButton();
        Assert.assertTrue(mainPage.isSelectedFillingsHeaderIsDisplayed());
    }

    @Test
    @DisplayName("Скролл к разделу Булки")
    public void scrollBunsSectionTest() {
        driver.get(MainPage.MAIN_PAGE_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollToBunsHeader();
        Assert.assertTrue(mainPage.isBunsHeaderIsDisplayed());
    }

    @Test
    @DisplayName("Скролл к разделу Соусы")
    public void scrollSaucesSectionTest() {
        driver.get(MainPage.MAIN_PAGE_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollToSaucesHeader();
        Assert.assertTrue(mainPage.isSaucesHeaderIsDisplayed());
    }

    @Test
    @DisplayName("Скролл к разделу Начинки")
    public void scrollFillingsSectionTest() {
        driver.get(MainPage.MAIN_PAGE_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollToFillingsHeader();
        Assert.assertTrue(mainPage.isFillingsHeaderIsDisplayed());
    }
}