package wikipedia.pages;

import com.codeborne.selenide.ElementsCollection;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class ArticlePage {

    private final ElementsCollection
    contentArticle = $$(AppiumBy.className("android.view.View"));

    @Step
    public ArticlePage findText(String value) {
        contentArticle.findBy(text(value));
        return this;
    }
}
