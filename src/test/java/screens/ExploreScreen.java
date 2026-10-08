package screens;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class ExploreScreen {

    private final SelenideElement
            searchTab = $(accessibilityId("Search")),
            closeModalButton = $(accessibilityId("Close")),
            searchSnippet = $(androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(2)"));

    public ExploreScreen openSearchTab() {
        step("Нажать на вкладку «Поиск»", () -> {
            searchTab.shouldBe(visible).click();
        });
        return this;
    }

    public ExploreScreen closeModal() {
        step("Закрыть модальное окно", () -> {
            closeModalButton.shouldBe(visible).click();
        });
        return this;
    }

    public ExploreScreen searchForQuery(String query) {
        step("Нажать на поле «Search Wikipedia»", () -> {
            $(accessibilityId("Search Wikipedia")).shouldBe(visible).click();
        });

        step("Ввести в поиск запрос «" + query + "»", () -> {
            $(id("org.wikipedia.alpha:id/search_src_text"))
                    .shouldBe(visible)
                    .sendKeys(query);
        });
        return this;
    }

    public ExploreScreen verifySearchResults() {
        step("Проверить наличие результатов поиска", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(sizeGreaterThan(0));
        });
        return this;
    }

    public ArticleScreen selectFirstSnippet() {
        step("Кликнуть по первому сниппету", () -> {
           
            if ($$(id("org.wikipedia.alpha:id/page_list_item_container")).size() > 0) {
                $$(id("org.wikipedia.alpha:id/page_list_item_container")).first().click();
            } else {
                searchSnippet.shouldBe(visible).click();
            }
        });
        return new ArticleScreen();
    }
}