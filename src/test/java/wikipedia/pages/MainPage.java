package wikipedia.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class MainPage {

 private final SelenideElement searchWikipedia = $(accessibilityId("Search Wikipedia")),
            moreButton = $(id("org.wikipedia.alpha:id/menu_icon")),
            loginButton = $(id("org.wikipedia.alpha:id/main_drawer_login_button")),
            navigationButton = $(id("org.wikipedia.alpha:id/menu_overflow_button")),
            settingButton = $(id("org.wikipedia.alpha:id/explore_overflow_settings"));
 private final ElementsCollection card = $$(id("org.wikipedia.alpha:id/view_card_header_title"));

    @Step("Кликаем на строку поиска Википедии")
    public MainPage searchClick() {
        searchWikipedia.click();
        return this;
    }

    @Step("Кликаем на кнопку 'More'")
    public MainPage moreClick() {
        moreButton.click();
        return this;
    }

    @Step("Кликаем на кнопку 'Log in/ join Wikipedia'")
    public MainPage loginClick() {
        loginButton.click();
        return this;
    }

    @Step("Проверяем наличие 'In the News'")
    public MainPage checkInTheNews(String value) {
        card.findBy(text(value)).shouldBe(Condition.visible);
        return this;
    }

    @Step ("Кликаем на кнопку 'Навигация'")
    public  MainPage navigationPress(){
        navigationButton.click();
        return this;
    }

    @Step("Кликаем на кнопку 'Settings'")
    public MainPage settingsButtonClick() {
        settingButton.click();
        return this;

    }
}
