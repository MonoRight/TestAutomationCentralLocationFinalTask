package Task4.definitionsteps;

import Task4.BLL.BLL;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {
    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    BLL businessLogicLayer;
    String buffer = "";
    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        businessLogicLayer = new BLL(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        businessLogicLayer.openPage(url);
    }

    @When("User clicks 'News' button")
    public void userClicksNewsButton() {
        businessLogicLayer.clickNewsButton(DEFAULT_TIMEOUT);
    }

    @Then("User checks that main <index> article contains {string}")
    public void userChecksThatMainIndexArticleContainsText1(final int index, final String text) {
        assertEquals(text, businessLogicLayer.getTextOfMainArticle(DEFAULT_TIMEOUT, index));
    }

    @Then("User checks that main {int} article contains {string}")
    public void userChecksThatMainIndexArticleContainsText(final int index, final String text) {
        assertEquals(text, businessLogicLayer.getTextOfMainArticle(DEFAULT_TIMEOUT, index));
    }

    @Then("User checks first {int} articles in {string}")
    public void userChecksFirstCountArticlesInOrder(final int count, final String order) {
        List<String> secondaryArticles = businessLogicLayer.separateStringToList(order);
        for(int i = 0; i < count; i++){
            assertEquals(secondaryArticles.get(i), businessLogicLayer.getTextOfSecondaryArticleByIndex(DEFAULT_TIMEOUT, i));
        }
    }

    @And("User copies 'Coronavirus' selection text")
    public void userCopiesCoronavirusSelectionText() {
        buffer = businessLogicLayer.getTextCoronavirusSelection(DEFAULT_TIMEOUT);
    }

    @And("User clicks 'Search' button")
    public void userClicksSearchButton() {
        businessLogicLayer.clickSearchButton();
    }

    @And("User insert copied text to 'Search' field")
    public void userInsertCopiedTextToSearchField() {
        businessLogicLayer.insertTextToSearchInput(buffer);
    }

    @When("User clicks 'Search request' button")
    public void userClicksSearchRequestButton() {
        businessLogicLayer.clickSearchRequestButton();
    }

    @Then("User checks that {int} article contains {string}")
    public void userChecksThatIndexArticleContains(final int index, final String text) {
        assertEquals(text, businessLogicLayer.getTextArticleAfterSearchingByIndex(DEFAULT_TIMEOUT, index));
    }

    @And("User clicks 'Coronavirus' selection")
    public void userClicksCoronavirusSelection() {
        businessLogicLayer.clickCoronavirusSelection();
    }

    @And("User clicks {int} 'Your Coronavirus Stories' selection")
    public void userClicksYourCoronavirusStories(final int index) {
        businessLogicLayer.clickCoronavirusStoriesSelection(index);
    }

    @And("User closes pop up window")
    public void userClosesPopUpWindow() {
        businessLogicLayer.closePopUpWindow(DEFAULT_TIMEOUT);
    }

    @And("User clicks 'How to share with BBC News' article")
    public void userClicksHowToShareWithBBCNewsArticle() {
        businessLogicLayer.clickShareCoronavirusStoryArticle();
    }

    @And("User fills form with data: story - {string}, name - {string}, email - {string}, contact number - {string}, location - {string}")
    public void userFillsFormWithCorrectDataStoryNameEmailContactNumberLocation(final String story, final String name, final String email, final String number, final String location) {
        List<String> formData = new ArrayList<>(Arrays.asList(story, name, email, number, location));
        businessLogicLayer.fillStoryForm(formData);
    }

    @And("User clicks on checkBox 'I accept the Terms of Service'")
    public void userClicksOnCheckBoxIAcceptTheTermsOfService() {
        businessLogicLayer.clickAcceptTermsCheckBox();
    }

    @When("User clicks 'Submit' button")
    public void userClicksSubmitButton() {
        businessLogicLayer.clickSubmitButton();
    }

    @Then("User checks result of sending story, it must contain {string} and {string}")
    public void userChecksResultOfSendingStoryItMustContainAnd(final @NotNull String firstParagraph, final String secondParagraph) {
        assertEquals(firstParagraph.replace(';', '\"'), businessLogicLayer.getResultParagraphAfterAddingStory(DEFAULT_TIMEOUT, 0));
        assertEquals(secondParagraph, businessLogicLayer.getResultParagraphAfterAddingStory(DEFAULT_TIMEOUT, 1));
    }

    @Then("User checks that error messages displayed: error story empty field - {string}, error name empty field - {string}, error acceptance terms - {string}")
    public void userChecksThatErrorMessagesDisplayedErrorStoryEmptyFieldErrorNameEmptyFieldErrorAcceptanceTerms(final String errorStory, final String errorName, final String errorTerms) {
        assertEquals(errorStory, businessLogicLayer.getErrorsAfterAddingStoryWIthEmptyFields(DEFAULT_TIMEOUT, 0));
        assertEquals(errorName, businessLogicLayer.getErrorsAfterAddingStoryWIthEmptyFields(DEFAULT_TIMEOUT, 1));
        assertEquals(errorTerms, businessLogicLayer.getErrorsAfterAddingStoryWIthEmptyFields(DEFAULT_TIMEOUT, 2));
    }

    @Then("User checks error {string} because of invalid email")
    public void userChecksErrorBecauseOfInvalidEmail(final String errorEmail) {
        assertEquals(errorEmail, businessLogicLayer.getErrorAfterAddingStoryWithInvalidEmail(DEFAULT_TIMEOUT));
    }

    @And("User clicks 'Sport' button")
    public void userClicksSportButton() {
        businessLogicLayer.clickSportButton(DEFAULT_TIMEOUT);
    }

    @And("User clicks on {int} 'Football' section")
    public void userClicksOnFootballSection(final int index) {
        businessLogicLayer.clickFootballSection(DEFAULT_TIMEOUT, index);
    }

    @And("User clicks on 'Scores & Fixtures' section")
    public void userClicksOnScoresFixturesSection() {
        businessLogicLayer.clickScoresFixturesSection(DEFAULT_TIMEOUT);
    }

    @And("User enters {string} in 'Enter a team or competition' input")
    public void userEntersInEnterATeamOrCompetitionInput(final String competition) {
        businessLogicLayer.enterTeamOrCompetitionInput(DEFAULT_TIMEOUT, competition);
    }

    @And("User chooses {int} from the drop down list")
    public void userChoosesIndexFromTheDropDownList(final int index) {
        businessLogicLayer.chooseFromTheDropDownList(DEFAULT_TIMEOUT, index);
    }

    @And("User select {string} and {string} of competition")
    public void userSelectMonthAndYearOfCompetition(final String month, final String year) {
        businessLogicLayer.selectMonthAndYearOfCompetition(DEFAULT_TIMEOUT, month, year);
    }

    @When("User finds match between {string} and {string} with score for first team - {int}, and score for second team - {int}")
    public void userFindsMatchBetweenTeamsWithScoreForFirstTeamAndScoreForSecondTeam(final String team1, final String team2, final int score1, final int score2) {
        businessLogicLayer.clickMatchWithSpecifiedTeamsAndScore(DEFAULT_TIMEOUT, team1, team2, score1, score2);
    }

    @Then("User compares displayed scores with scores from previous page and specified scores: {int}, {int}")
    public void userComparesDisplayedScoresWithScoresFromPreviousPageAndSpecifiedScoresScoreScore(int score1, int score2) {
        assertTrue(businessLogicLayer.compareDisplayedScoresWithPreviousPageAndSpecifiedScores(DEFAULT_TIMEOUT, score1, score2));
    }
}
