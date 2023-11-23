package wikipedia.drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import wikipedia.config.BrowserstackConfig;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;


public class BrowserstackDriver implements WebDriverProvider {
    protected static BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    @Nonnull
    @Override

    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        mutableCapabilities.setCapability("browserstack.user", browserstackConfig.getUsername());
        mutableCapabilities.setCapability("browserstack.key", browserstackConfig.getPassword());

        mutableCapabilities.setCapability("app", browserstackConfig.getApp());
        mutableCapabilities.setCapability("device", browserstackConfig.getDevice());
        mutableCapabilities.setCapability("os_version", browserstackConfig.getVersion());

        mutableCapabilities.setCapability("project", browserstackConfig.getProject());
        mutableCapabilities.setCapability("build", browserstackConfig.getBuild());
        mutableCapabilities.setCapability("name", browserstackConfig.getName());

        try {
            return new RemoteWebDriver(
                    new URL(browserstackConfig.getRemoteUrl()), mutableCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

