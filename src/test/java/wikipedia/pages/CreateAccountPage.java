package wikipedia.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class CreateAccountPage {

   private final SelenideElement loginButton = $(id("org.wikipedia.alpha:id/create_account_login_button"));

    @Step("Кликаем на кнопку Log in")
    public CreateAccountPage authLoginClick() {
        loginButton.click();
        return this;
    }
}
