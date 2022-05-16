package Task3;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class AddStoryTests extends BaseTest{
    private final static long DEFAULT_WAIT = 60;
    private final int INDEX_FIRST_LINK_STORIES = 0;
    private final String STORY = "Sorry for interruption, its just testing form :^)";
    private final String NAME = "Dmytro";
    private final String INCORRECT_EMAIL = "incorrectemail";
    private final String CORRECT_EMAIL = "gmailtestemail@gmail.com";
    private final String TELEPHONE = "123123123123";
    private final String LOCATION = "Ukraine, Kyiv";
    private final String EXPECTED_FIRST_PARAGRAPH = "Hey "+ NAME + ", thanks for asking your question: \"" + STORY +"\"";
    private final String EXPECTED_SECOND_PARAGRAPH = "If we're able to investigate it further, we'll email you at " + CORRECT_EMAIL + ".";
    private final String ERROR_EMPTY_STORY_FIELD = "can't be blank";
    private final String ERROR_EMPTY_NAME_FIELD = "Name can't be blank";
    private final String ERROR_NOT_ACCEPTED_TERMS_OF_SERVICE = "must be accepted";
    private final String ERROR_INVALID_EMAIL = "Email address is invalid";
    private final List<String> CORRECT_FORM_DATA = new ArrayList<>(Arrays.asList(STORY, NAME, CORRECT_EMAIL, TELEPHONE, LOCATION));
    private final List<String> INCORRECT_FORM_DATA = new ArrayList<>(Arrays.asList(STORY, NAME, INCORRECT_EMAIL, TELEPHONE, LOCATION));
    private final List<String> EMPTY_DATA = new ArrayList<>(Arrays.asList("","","","",""));
    private final List<String> ERROR_MESSAGES = new ArrayList<>(Arrays.asList(ERROR_EMPTY_STORY_FIELD, ERROR_EMPTY_NAME_FIELD, ERROR_NOT_ACCEPTED_TERMS_OF_SERVICE));

    @Test(priority = 0)
    public void checkAddingStoryWithCorrectData() {
        businessLogicLayer.goToCoronavirusAddingStoriesPage(DEFAULT_WAIT, INDEX_FIRST_LINK_STORIES);
        businessLogicLayer.fillingStoryFrom(CORRECT_FORM_DATA);
        businessLogicLayer.acceptTermsCheckBox();
        businessLogicLayer.clickSubmitButton();
        assertTrue(businessLogicLayer.checkAddingStory(DEFAULT_WAIT, EXPECTED_FIRST_PARAGRAPH, EXPECTED_SECOND_PARAGRAPH));
    }

    @Test(priority = 1)
    public void checkAddingStoryWithEmptyFields(){
        businessLogicLayer.goToCoronavirusAddingStoriesPage(DEFAULT_WAIT, INDEX_FIRST_LINK_STORIES);
        businessLogicLayer.fillingStoryFrom(EMPTY_DATA);
        businessLogicLayer.clickSubmitButton();
        assertTrue(businessLogicLayer.checkAddingStoryWithEmptyFields(DEFAULT_WAIT, ERROR_MESSAGES));
    }

    @Test(priority = 2)
    public void checkAddingStoryWithInvalidDataInEmailField(){
        businessLogicLayer.goToCoronavirusAddingStoriesPage(DEFAULT_WAIT, INDEX_FIRST_LINK_STORIES);
        businessLogicLayer.fillingStoryFrom(INCORRECT_FORM_DATA);
        businessLogicLayer.acceptTermsCheckBox();
        businessLogicLayer.clickSubmitButton();

        assertTrue(businessLogicLayer.checkAddingStoryWithInvalidEmail(DEFAULT_WAIT, ERROR_INVALID_EMAIL));
    }
}
