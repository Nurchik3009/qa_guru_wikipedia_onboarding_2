package tests;

import org.junit.jupiter.api.Test;
import screens.ArticleScreen;
import screens.ExploreScreen;

public class SearchTests extends TestBase {

    ExploreScreen exploreScreen = new ExploreScreen();
    ArticleScreen articleScreen = new ArticleScreen();

    @Test
    void successfulSearchTest() {
        exploreScreen
                .searchForQuery("Appium");
    }

    @Test
    void openArticleTest() {
        exploreScreen
                .searchForQuery("Appium")
                .selectFirstSnippet();

        articleScreen
                .verifyArticleOpened("Appium");
    }
}