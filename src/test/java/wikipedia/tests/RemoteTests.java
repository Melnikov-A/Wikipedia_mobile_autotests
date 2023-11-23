package wikipedia.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import wikipedia.pages.*;

import static io.qameta.allure.Allure.step;

public class RemoteTests extends TestBase {
    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    SettingsPage settingsPage = new SettingsPage();
    LanguagePage languagePage = new LanguagePage();


    @Feature("Проверка выпадающей ошибки после ввода значения в поиске")
    @DisplayName("Проверка появления иконки с ошибкой")
    @Tag("browserstack")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void iconErrorTest() {
        mainPage.searchClick();
        searchPage.searchQuery("appium")
                .checkTheQuantity()
                .firstListClick()
                .checkErrorIcon();
    }

    @Feature("Проверка отображения баннера с новостями")
    @Story("Проверка отображения раздела с новостями 'In the News' на главное странице Википедии")
    @DisplayName("Проверка наличия раздела 'In the News' на главной странице")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("browserstack")
    @Test
    void inTheNewsSectionTest() {
        step("Проверить, что 'In the News' отображается на главной странице", () ->
                mainPage
                        .checkInTheNews("In the News"));
    }

    @Feature("Проверка добавления функции смены языка текста в настройках Википедии")
    @Story("Проверка отображения смены языка текста в настроках Википедии после добавления из общего списка языков")
    @DisplayName("Проверка добавления языка текста в настройках")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("browserstack")
    void languageSettingTest() {
        mainPage.navigationPress()
                .settingsButtonClick();
        settingsPage.languageListClick();
        languagePage.languageSelection("Svenska")
                .checkLanguage("Svenska");

    }
}
