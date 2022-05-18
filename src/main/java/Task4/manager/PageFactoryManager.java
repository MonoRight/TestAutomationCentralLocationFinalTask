package Task4.manager;

import Task4.pages.*;
import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver){
        this.driver = driver;
    }

    public AddingStoryPage getAddingStoryPage() {
        return new AddingStoryPage(driver);
    }

    public CoronavirusNewsPage getCoronavirusNewsPage(){
        return new CoronavirusNewsPage(driver);
    }

    public CoronavirusStoriesPage getCoronavirusStoriesPage(){
        return new CoronavirusStoriesPage(driver);
    }

    public HomePage getHomePage(){
        return new HomePage(driver);
    }

    public NewsPage getNewsPage(){
        return new NewsPage(driver);
    }

    public ResultSearchingPage getResultSearchingPage(){
        return new ResultSearchingPage(driver);
    }

    public SearchPage getSearchPage(){
        return new SearchPage(driver);
    }
    public SportPage getSportPage(){
        return new SportPage(driver);
    }
    public FootballNewsPage getFootballNewsPage(){
        return new FootballNewsPage(driver);
    }
    public FootballScoresAndFixturesPage getFootballScoresAndFixtures(){
        return new FootballScoresAndFixturesPage(driver);
    }
    public MatchResultPage getMatchResultPage(){
        return new MatchResultPage(driver);
    }
}
