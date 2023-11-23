package wikipedia.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import wikipedia.pages.*;
import wikipedia.utils.RandomUtils;

@DisplayName("Локальное тестирование приложения Википедия")
public class LocalTests extends TestBase {

    WelcomePage welcomePage = new WelcomePage();
    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    ArticlePage articlePage = new ArticlePage();
    CreateAccountPage createAccountPage = new CreateAccountPage();
    LoginPage loginPage = new LoginPage();
    RandomUtils randomUtils = new RandomUtils();


    @Feature("Тестирование стартовых страниц после запуска приложения с проверкой содержимого")
    @Story("Проверка четырех страниц, содержащих текст для ознакомления с приложением")
    @Test
    @Tag("local")
    @DisplayName("Проверка стартовых страниц в википедии")
    @Severity(SeverityLevel.CRITICAL)
    void wikiWelcomePagesTest() {

        welcomePage.checkTextOnTitle("The Free Encyclopedia")
                .forwardButtonClick()
                .checkTextOnTitle("New ways to explore")
                .forwardButtonClick()
                .checkTextOnTitle("Reading lists with sync")
                .forwardButtonClick()
                .checkTextOnTitle("Send anonymous data")
                .acceptButtonClick();
    }

    @Feature("Проверка функции поиска Википедии с выпадающим списком ")
    @Story("Тестирование выпадающего списка поиска с проверкой найденного элемента")
    @DisplayName("Проверка поиска Википедии")
    @Tag("local")
    @Severity(SeverityLevel.BLOCKER)
    @ParameterizedTest(name = "Search term: {0}")
    @ValueSource(strings = {"White Rabbit", "Venus"})
    void searchTest(String searchTerm) {
        welcomePage.skipButtonClick();
        mainPage.searchClick();
        searchPage.searchQuery(searchTerm);
        searchPage.checkTheQuantity();
        searchPage.clickFirstElementResultList();
        articlePage.findText(searchTerm);

    }

    @Feature("Тестирование авторизации с неверно введенными данными")
    @Story("Проверка входа в личный кабинет после ввода данных")
    @DisplayName("Тестирование авторизации")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("local")
    @Test
    void unsuccessfulLoginTest() {
        welcomePage.skipButtonClick();
        mainPage.moreClick();
        mainPage.loginClick();
        createAccountPage.authLoginClick();
        loginPage.usernameInput(randomUtils.username)
                .passwordInput(randomUtils.password)
                .loginButtonClick()
                .checkErrorText("Incorrect username or password entered.");

    }
}



