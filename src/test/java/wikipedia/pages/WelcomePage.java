package wikipedia.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class WelcomePage {

  private final SelenideElement titleText = $(id("org.wikipedia.alpha:id/primaryTextView")),
            forwardButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            skipButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")),
            acceptButton = $(id("org.wikipedia.alpha:id/acceptButton"));


    @Step("Проверка текста в заголовке страницы")
    public WelcomePage checkTextOnTitle(String value) {
        titleText.shouldHave(text(value));
        return this;
    }

    @Step("Нажимаем кнопку 'Вперед'")
    public WelcomePage forwardButtonClick() {
        forwardButton.click();
        return this;
    }

    @Step("Пропускаем страницы приветствия")
    public WelcomePage skipButtonClick() {
        skipButton.click();
        return this;
    }

    @Step("Нажимаем кнопку 'Принять'")
    public WelcomePage acceptButtonClick() {
        acceptButton.click();
        return this;

    }
}
