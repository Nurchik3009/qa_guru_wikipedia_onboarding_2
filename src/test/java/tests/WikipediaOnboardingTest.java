package tests;

import org.junit.jupiter.api.Test;
import screens.ArticleScreen;
import screens.ExploreScreen;
import screens.OnboardingScreen;

public class WikipediaOnboardingTest extends TestBase {

    OnboardingScreen onboardingScreen = new OnboardingScreen();
    ExploreScreen exploreScreen = new ExploreScreen();
    ArticleScreen articleScreen = new ArticleScreen();

    @Test
    void successfulSearchTest() {

        onboardingScreen.completeOnboarding();

        exploreScreen
                .openSearchTab()
                .closeModal()
                .searchForQuery("Peggy Gou")
                .selectFirstSnippet();

        articleScreen
                .verifyArticleOpened("Peggy Gou")
                .clickArticleHeaderTitle()
                .verifyHeaderImageDisplayed()
                .openHeaderImage()
                .verifyFullScreenImage();
    }
}