package wikipedia.pages;

import com.codeborne.selenide.ElementsCollection;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class SettingsPage {

    private final ElementsCollection
            languageList = $$(AppiumBy.className("android.widget.TextView"));

    @Step("Кликаем на иконку 'Wikipedia languages'")
    public SettingsPage languageListClick() {
        languageList.findBy(text("Wikipedia language")).click();
        return this;

    }
}
