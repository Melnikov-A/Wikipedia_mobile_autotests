package wikipedia.pages;

import com.codeborne.selenide.ElementsCollection;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class LanguagePage {

 private final ElementsCollection languageName = $$((AppiumBy.id("org.wikipedia.alpha:id/localized_language_name"))),
            checkLanguageText = $$(AppiumBy.className("android.widget.TextView"));

    @Step("Выбираем нужный язык текста")
    public LanguagePage languageSelection(String value) {
        languageName.findBy(text(value));
        return this;
    }

    @Step("Проверяем смену языка")
    public LanguagePage checkLanguage(String value) {
        checkLanguageText.findBy(text(value)).shouldBe(visible);
        return this;
    }
}
