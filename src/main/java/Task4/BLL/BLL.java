package Task4.BLL;

import Task4.pages.*;
import Task4.manager.PageFactoryManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.sleep;

public class BLL {
    private WebDriver driver;
    private HomePage homePage;
    private AddingStoryPage addingStoryPage;
    private CoronavirusStoriesPage coronavirusStoriesPage;
    private CoronavirusNewsPage coronavirusNewsPage;
    private NewsPage newsPage;
    private ResultSearchingPage resultSearchingPage;
    private SearchPage searchPage;
    private SportPage sportPage;
    private FootballNewsPage footballNewsPage;
    private FootballScoresAndFixturesPage footballScoresAndFixturesPage;
    private MatchResultPage matchResultPage;
    private PageFactoryManager pageFactoryManager;
    private Score score = null;
    public BLL(WebDriver driver){
        this.driver = driver;
        pageFactoryManager = new PageFactoryManager(driver);
    }

    private WebDriver getDriver(){
        return driver;
    }

    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    public void clickNewsButton(final long waitTime){
        homePage.waitVisibilityOfElement(waitTime, homePage.getNewsCategory());
        homePage.clickTheWebElement(homePage.getNewsCategory());
    }

    public String getTextOfMainArticle(final long waitTime, final int index){
        newsPage = pageFactoryManager.getNewsPage();
        newsPage.waitVisibilityOfElement(waitTime, newsPage.getTitleByIndex(index));
        return newsPage.getTextTitleByIndex(index);
    }

    public List<String> separateStringToList(final @NotNull String totalStr){
        return Arrays.asList(totalStr.split("\\s*;\\s*"));
    }

    public String getTextOfSecondaryArticleByIndex(final long waitTime, final int index){
        newsPage = pageFactoryManager.getNewsPage();
        newsPage.waitVisibilityOfElement(waitTime, newsPage.getSecondaryTitleByIndex(index));
        return newsPage.getTextSecondaryTitleByIndex(index);
    }

    public String getTextCoronavirusSelection(final long waitTime){
        newsPage = pageFactoryManager.getNewsPage();
        newsPage.waitVisibilityOfElement(waitTime, newsPage.getSearchButton());
        return newsPage.getTextCoronavirusSelection();
    }

    public void clickSearchButton(){
        newsPage.clickTheWebElement(newsPage.getSearchButton());
    }

    public void insertTextToSearchInput(final String searchText){
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.enterInput(searchPage.getSearchInput(), searchText);
    }

    public void clickSearchRequestButton(){
        searchPage.clickTheWebElement(searchPage.getSearchButton());
    }

    public String getTextArticleAfterSearchingByIndex(final long waitTime, final int index){
        resultSearchingPage = pageFactoryManager.getResultSearchingPage();
        resultSearchingPage.waitForPageLoadComplete(waitTime);
        resultSearchingPage.scrollToElement(resultSearchingPage.getSearchTitleByIndex(index));

        return resultSearchingPage.getTextSearchTitleByIndex(index);
    }

    public void clickCoronavirusSelection(){
        newsPage = pageFactoryManager.getNewsPage();
        newsPage.clickTheWebElement(newsPage.getCoronavirusSelection());
    }

    public void clickCoronavirusStoriesSelection(final int index){
        coronavirusNewsPage = pageFactoryManager.getCoronavirusNewsPage();
        coronavirusNewsPage.clickTheWebElement(coronavirusNewsPage.getCoronavirusStoryByIndex(index));
    }

    public void clickShareCoronavirusStoryArticle(){
        coronavirusStoriesPage = pageFactoryManager.getCoronavirusStoriesPage();
        coronavirusStoriesPage.scrollToElement(coronavirusStoriesPage.getShareCoronavirusStory());
        coronavirusStoriesPage.clickTheWebElementByJS(coronavirusStoriesPage.getShareCoronavirusStory());
    }

    public void closePopUpWindow(final long waitTime){
        addingStoryPage = pageFactoryManager.getAddingStoryPage();
        addingStoryPage.waitForPageLoadComplete(waitTime);
        addingStoryPage.waitVisibilityOfElementLocated(waitTime, addingStoryPage.getClosePopUpWindowButtonXPath());
        addingStoryPage.clickTheWebElement(addingStoryPage.getClosePopUpWindowButton());
    }

    public void fillStoryForm(final List<String> values){
        addingStoryPage.scrollToElement(addingStoryPage.getAddStoryFormContainer());
        Form.FillForm(addingStoryPage, addingStoryPage.getFormFields(), values);
    }

    public void clickAcceptTermsCheckBox(){
        addingStoryPage.clickTheWebElement(addingStoryPage.getAcceptTermsCheckBox());
    }

    public void clickSubmitButton(){
        addingStoryPage.clickTheWebElement(addingStoryPage.getSendStoryButton());
    }

    public String getResultParagraphAfterAddingStory(final long waitTime, final int index){
        addingStoryPage.waitVisibilityOfElementLocated(waitTime, addingStoryPage.getResultParagraphsAfterAddingStoryXPath());
        return addingStoryPage.getTextResultParagraphByIndex(index);
    }

    public String getErrorsAfterAddingStoryWIthEmptyFields(final long waitTime, final int index){
        addingStoryPage.waitVisibilityOfAllElementsLocatedBy(waitTime, addingStoryPage.getErrorMessagesXPath());
        return addingStoryPage.getTextErrorMessageByIndex(index);
    }

    public String getErrorAfterAddingStoryWithInvalidEmail(final long waitTime){
        addingStoryPage.waitVisibilityOfElementLocated(waitTime, addingStoryPage.getErrorMessagesXPath());

        return addingStoryPage.getTextErrorMessageByIndex(0);
    }

    public void clickSportButton(final long waitTime){
        homePage.waitVisibilityOfElement(waitTime, homePage.getSportCategory());
        homePage.clickTheWebElement(homePage.getSportCategory());
    }

    public void clickFootballSection(final long waitTime, final int index){
        sportPage = pageFactoryManager.getSportPage();
        sportPage.waitVisibilityOfElement(waitTime, sportPage.getFootballSectionByIndex(index));
        sportPage.clickTheWebElement(sportPage.getFootballSectionByIndex(index));
    }

    public void clickScoresFixturesSection(final long waitTime){
        footballNewsPage = pageFactoryManager.getFootballNewsPage();
        footballNewsPage.waitVisibilityOfElement(waitTime, footballNewsPage.getScoresAndFixturesSelection());
        footballNewsPage.clickTheWebElement(footballNewsPage.getScoresAndFixturesSelection());
    }

    public void enterTeamOrCompetitionInput(final long waitTime, final String competition){
        footballScoresAndFixturesPage = pageFactoryManager.getFootballScoresAndFixtures();
        footballScoresAndFixturesPage.waitVisibilityOfElement(waitTime, footballScoresAndFixturesPage.getSearchInputCompetitions());
        footballScoresAndFixturesPage.enterInput(footballScoresAndFixturesPage.getSearchInputCompetitions(), competition);
    }

    public void chooseFromTheDropDownList(final long waitTime, final int index){
        footballScoresAndFixturesPage.waitVisibilityOfElement(waitTime, footballScoresAndFixturesPage.getSearchResultListByIndex(index));
        footballScoresAndFixturesPage.scrollToElement(footballScoresAndFixturesPage.getSearchResultListByIndex(index));
        footballScoresAndFixturesPage.clickTheWebElement(footballScoresAndFixturesPage.getSearchResultListByIndex(index));
    }

    public void selectMonthAndYearOfCompetition(final long waitTime, final String month, final String year) {
        footballScoresAndFixturesPage.waitForPageLoadComplete(waitTime);

        WebElement monthAndYearWebElement = null;
        for(int i = 0; i < footballScoresAndFixturesPage.getYearAndMonthSelectList().size(); i++){
            if(footballScoresAndFixturesPage.getTextYearByIndex(i).equals(year) && footballScoresAndFixturesPage.getTextMonthByIndex(i).equals(month)){
                            monthAndYearWebElement = footballScoresAndFixturesPage.getYearAndMonthSelectByIndex(i);
                            break;
            }
        }

        if(monthAndYearWebElement != null){
            footballScoresAndFixturesPage.clickTheWebElement(monthAndYearWebElement);
        }
        else throw new WebDriverException("Element was not found with such year and month");
    }

    public void clickMatchWithSpecifiedTeamsAndScore(final long waitTime, final String team1, final String team2, final int score1, final int score2){
        footballScoresAndFixturesPage.waitForPageLoadComplete(waitTime);
        footballScoresAndFixturesPage.waitVisibilityOfAllElementsLocatedBy(waitTime, footballScoresAndFixturesPage.getTeamsListXPath());

        ScoreBoard scoreBoard = new ScoreBoard();
        score = scoreBoard.GetScore(footballScoresAndFixturesPage, team1, team2);

        if(score1 == score.getScoreTeam1() && score2 == score.getScoreTeam2()){
            for(int i = 0; i < footballScoresAndFixturesPage.getTeamsList().size() - 1; i++){
                if(footballScoresAndFixturesPage.getTextTeamByIndex(i).equals(team1) && footballScoresAndFixturesPage.getTextTeamByIndex(i + 1).equals(team2)){
                    footballScoresAndFixturesPage.scrollToElement(footballScoresAndFixturesPage.getTeamByIndex(i));
                    footballScoresAndFixturesPage.clickTheWebElement(footballScoresAndFixturesPage.getTeamByIndex(i));
                }
            }
        }
        else throw new WebDriverException("Found scores are not similar as in tests");
    }

    public boolean compareDisplayedScoresWithPreviousPageAndSpecifiedScores(final long waitTime, final int score1, final int score2){
        matchResultPage = pageFactoryManager.getMatchResultPage();
        matchResultPage.waitForPageLoadComplete(waitTime);

        matchResultPage.waitVisibilityOfAllElementsLocatedBy(waitTime, matchResultPage.getResultScoresListXPath());
        return matchResultPage.getIntResultScoreByIndex(0) == score1 &&  matchResultPage.getIntResultScoreByIndex(0) == score.getScoreTeam1() &&
                matchResultPage.getIntResultScoreByIndex(1) == score2 && matchResultPage.getIntResultScoreByIndex(1) == score.getScoreTeam2();
    }

}
