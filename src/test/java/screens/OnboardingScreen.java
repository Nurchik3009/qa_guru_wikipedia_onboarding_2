package screens;

import helpers.Attach;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.androidUIAutomator;
import static io.appium.java_client.AppiumBy.className;
import static io.qameta.allure.Allure.step;

public class OnboardingScreen {

    private final SelenideElement
            firstScreenText = $(androidUIAutomator("new UiSelector().text(\"All the world's knowledge\")")),
            secondScreenText = $(androidUIAutomator("new UiSelector().text(\"Data & Privacy\")")),
            thirdScreenText = $(androidUIAutomator("new UiSelector().text(\"English\")")),
            fourthScreenText = $(androidUIAutomator("new UiSelector().text(\"Follow your curiosity\")")),
            forwardButton = $(className("android.widget.Button"));

    public OnboardingScreen completeOnboarding() {
        step("Пройти первый экран онбординга", () -> {
            firstScreenText.shouldBe(visible);
            Attach.screenshotAs("Screenshot№1");
            forwardButton.click();
        });

        step("Пройти второй экран онбординга", () -> {
            secondScreenText.shouldBe(visible);
            Attach.screenshotAs("Screenshot№2");
            forwardButton.click();
        });

        step("Пройти третий экран онбординга", () -> {
            thirdScreenText.shouldBe(visible);
            Attach.screenshotAs("Screenshot№3");
            forwardButton.click();
        });

        step("Пройти четвертый экран онбординга", () -> {
            fourthScreenText.shouldBe(visible);
            Attach.screenshotAs("Screenshot№4");
            forwardButton.click();
        });
        return this;
    }
}