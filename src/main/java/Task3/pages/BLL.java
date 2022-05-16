package Task3.pages;

import org.openqa.selenium.WebDriver;
import java.util.List;

public class BLL {

    private WebDriver driver;
    public BLL(WebDriver driver){
        this.driver = driver;
    }

    public String getTextOfMainArticle(final long waitTime, final int index){
        getHomePage().clickTheWebElement(getHomePage().getNewsCategory());

        return getNewsPage().waitVisibilityOfElement(waitTime, getNewsPage().getTitleByIndex(index)).getText();
    }

    public boolean checksSecondaryArticles(final String secondaryArticle, final int index){
        getHomePage().clickTheWebElement(getHomePage().getNewsCategory());

        return secondaryArticle.equals(getNewsPage().getTextSecondaryTitleByIndex(index));
    }

    public String getTextArticleAfterSearching(final int index){
        getHomePage().clickTheWebElement(getHomePage().getNewsCategory());
        String searchText = getNewsPage().getTextCoronavirusSelection();
        getNewsPage().clickTheWebElement(getNewsPage().getSearchButton());
        getSearchPage().enterInput(getSearchPage().getSearchInput(), searchText);
        getSearchPage().clickTheWebElement(getSearchPage().getSearchButton());

        return getResultSearchingPage().getTextSearchTitleByIndex(index);
    }

    public void goToCoronavirusAddingStoriesPage(final long waitTime, final int index){
        getHomePage().clickTheWebElement(getHomePage().getNewsCategory());
        getNewsPage().clickTheWebElement(getNewsPage().getCoronavirusSelection());
        getCoronavirusNewsPage().clickTheWebElement(getCoronavirusNewsPage().getCoronavirusStoryByIndex(index));
        getCoronavirusStoriesPage().scrollToElement(getCoronavirusStoriesPage().getShareCoronavirusStory());
        getCoronavirusStoriesPage().clickTheWebElementByJS(getCoronavirusStoriesPage().getShareCoronavirusStory());
        getAddingStoryPage().waitForPageLoadComplete(waitTime);
        getAddingStoryPage().waitVisibilityOfElementLocated(waitTime, getAddingStoryPage().getClosePopUpWindowButtonXPath());
        getAddingStoryPage().clickTheWebElement(getAddingStoryPage().getClosePopUpWindowButton());
    }

    public void fillingStoryFrom(final List<String> values){
        getAddingStoryPage().scrollToElement(getAddingStoryPage().getAddStoryFormContainer());
        Form.FillForm(getAddingStoryPage(), getAddingStoryPage().getFormFields(), values);
    }
    public void clickSubmitButton(){
        getAddingStoryPage().clickTheWebElement(getAddingStoryPage().getSendStoryButton());
    }
    public void acceptTermsCheckBox(){
        getAddingStoryPage().clickTheWebElement(getAddingStoryPage().getAcceptTermsCheckBox());
    }

    public boolean checkAddingStory(final long waitTime, final String expectedFirstParagraph, final String expectedSecondParagraph){
        getAddingStoryPage().waitVisibilityOfElementLocated(waitTime, getAddingStoryPage().getResultParagraphsAfterAddingStoryXPath());
        return expectedFirstParagraph.equals(getAddingStoryPage().getTextResultParagraphByIndex(0)) && expectedSecondParagraph.equals(getAddingStoryPage().getTextResultParagraphByIndex(1));
    }

    public boolean checkAddingStoryWithEmptyFields(final long waitTime, final List<String> expectedErrors){
        getAddingStoryPage().waitVisibilityOfAllElementsLocatedBy(waitTime, getAddingStoryPage().getErrorMessagesXPath());

        for(int i = 0; i < expectedErrors.size(); i++){
            if(!expectedErrors.get(i).equals(getAddingStoryPage().getTextErrorMessageByIndex(i))){
                return false;
            }
        }
        return true;
    }

    public boolean checkAddingStoryWithInvalidEmail(final long waitTime, final String expectedError){
        getAddingStoryPage().waitVisibilityOfElementLocated(waitTime, getAddingStoryPage().getErrorMessagesXPath());

        return expectedError.equals(getAddingStoryPage().getTextErrorMessageByIndex(0));
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
