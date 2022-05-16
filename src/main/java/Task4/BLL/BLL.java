package Task4.BLL;

import Task4.pages.*;
import Task4.manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BLL {
    private WebDriver driver;
    private HomePage homePage;
    private AddingStoryPage addingStoryPage;
    private CoronavirusStoriesPage coronavirusStoriesPage;
    private CoronavirusNewsPage coronavirusNewsPage;
    private NewsPage newsPage;
    private ResultSearchingPage resultSearchingPage;
    private SearchPage searchPage;
    private PageFactoryManager pageFactoryManager;
    public BLL(WebDriver driver){
        this.driver = driver;
        pageFactoryManager = new PageFactoryManager(driver);
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

    public List<String> separateStringToList(final String totalStr){
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
        addingStoryPage.waitVisibilityOfAllElementsLocatedBy(waitTime, getAddingStoryPage().getErrorMessagesXPath());
        return addingStoryPage.getTextErrorMessageByIndex(index);
    }

    public String getErrorAfterAddingStoryWithInvalidEmail(final long waitTime){
        addingStoryPage.waitVisibilityOfElementLocated(waitTime, addingStoryPage.getErrorMessagesXPath());

        return addingStoryPage.getTextErrorMessageByIndex(0);
    }

    private WebDriver getDriver(){
        return driver;
    }
    private HomePage getHomePage(){
        return new HomePage(getDriver());
    }
    private NewsPage getNewsPage(){
        return new NewsPage(getDriver());
    }
    private ResultSearchingPage getResultSearchingPage(){
        return new ResultSearchingPage(getDriver());
    }
    private SearchPage getSearchPage(){
        return new SearchPage(getDriver());
    }
    private CoronavirusNewsPage getCoronavirusNewsPage(){
        return new CoronavirusNewsPage(getDriver());
    }
    private CoronavirusStoriesPage getCoronavirusStoriesPage(){
        return new CoronavirusStoriesPage(getDriver());
    }
    private AddingStoryPage getAddingStoryPage(){
        return new AddingStoryPage(getDriver());
    }
}
