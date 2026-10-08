package screens;

import helpers.Attach;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;
import static io.appium.java_client.AppiumBy.androidUIAutomator;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class ArticleScreen {

    private final SelenideElement
            articleHeader = $(androidUIAutomator("new UiSelector().text(\"Peggy Gou\")")),
            headerImage = $(id("org.wikipedia.alpha:id/view_page_header_image")),
            fullScreenImage = $(id("org.wikipedia.alpha:id/imageView"));


    public ArticleScreen verifyArticleOpened(String title) {
        step("Проверить, что статья " + title + " открылась", () -> {
            
            if (title.equals("Peggy Gou")) {
                articleHeader.shouldBe(visible);
            } else {
                $x("//*[@resource-id='org.wikipedia.alpha:id/page_toolbar']//*[@text='" + title + "']")
                        .shouldBe(visible);
            }
        });
        return this;
    }

    public ArticleScreen clickArticleHeaderTitle() {
        step("Закрыть подсказку кликом по заголовку", () -> {
            articleHeader.click();
        });
        return this;
    }

    public ArticleScreen verifyHeaderImageDisplayed() {
        step("Проверить, что фотография статьи отображается", () -> {
            headerImage.shouldBe(visible);
        });
        return this;
    }

    public ArticleScreen openHeaderImage() {
        step("Открыть фотографию", () -> {
            headerImage.shouldBe(visible).click();
        });
        return this;
    }

    public ArticleScreen verifyFullScreenImage() {
        step("Проверить, что фотография открылась на весь экран", () -> {
            fullScreenImage.shouldBe(visible, Duration.ofSeconds(5));
            sleep(1000);
            Attach.screenshotAs("Screenshot№6");
        });
        return this;
    }
}