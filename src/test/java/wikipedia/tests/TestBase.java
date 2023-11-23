package wikipedia.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import wikipedia.drivers.LocalDriver;
import wikipedia.drivers.BrowserstackDriver;
import wikipedia.helpers.Attach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    public static String host = System.getProperty("host");
    @BeforeAll
    static void beforeAll() {
        switch (host) {
            case "browserstack":
                Configuration.browser = BrowserstackDriver.class.getName();
                break;
            case "local":
                Configuration.browser = LocalDriver.class.getName();
                break;
        }

        Configuration.browserSize = null;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void tearDown() {
        switch (host) {
            case "browserstack":
                String sessionId = Selenide.sessionId().toString();

                Attach.pageSource();
                Attach.addVideo(sessionId);
                break;
            case "local":
                Attach.screenshotAs("Last screenshot");
                Attach.pageSource();
        }
        closeWebDriver();
    }
}


