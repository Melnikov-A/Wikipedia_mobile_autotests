package wikipedia.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.appium.java_client.AppiumBy.id;

public class LoginPage {

 private final SelenideElement usernameField = $x("//android.widget.EditText[@text=\"Username\"]"),
    passwordField = $x("//android.widget.EditText[@text=\"Password\"]"),
    loginButton = $(id("org.wikipedia.alpha:id/login_button")),
    errorTable = $(id("org.wikipedia.alpha:id/snackbar_text"));


    @Step("Вводим логин в поле Username")
    public LoginPage usernameInput(String value) {
        usernameField.sendKeys(value);
        return this;
    }

    @Step("Вводим пароль в поле Password")
    public LoginPage passwordInput(String value) {
        passwordField.sendKeys(value);
        return this;
    }

    @Step("Вводим пароль в поле Password")
    public LoginPage loginButtonClick() {
        loginButton.click();
        return this;
    }

    @Step("Проверяем наличие текста ошибки авторизации")
    public LoginPage checkErrorText(String value) {
        errorTable.shouldHave(text(value));
        return this;
    }
}
