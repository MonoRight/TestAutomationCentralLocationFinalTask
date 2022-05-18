package Task4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddingStoryPage extends BasePage {
    @FindBy(xpath = "//div[@class='embed-content-container']")
    private WebElement addStoryFormContainer;
    @FindBy(xpath = "//textarea[@class='text-input--long']")
    private WebElement storyInput;
    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement nameInput;
    @FindBy(xpath = "//input[@placeholder='Email address']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@placeholder='Contact number ']")
    private WebElement telephoneInput;
    @FindBy(xpath = "//input[@placeholder='Location ']")
    private WebElement locationInput;
    @FindBy(xpath = "//p[contains(text(), 'I accept')]")
    private WebElement acceptTermsCheckBox;
    @FindBy(xpath = "//button[@class='button']")
    private WebElement sendStoryButton;
    @FindBy(xpath = resultParagraphsAfterAddingStoryXPath)
    private List<WebElement> resultParagraphsAfterAddingStory;
    @FindBy(xpath = errorMessagesXPath)
    private List<WebElement> errorMessages;
    private final String errorMessagesXPath = "//div[@class='input-error-message']";
    private final String resultParagraphsAfterAddingStoryXPath = "//div[@class='section-header-group__section-subheader']//p";

    private final List<WebElement> formFields = new ArrayList<>(Arrays.asList(storyInput, nameInput, emailInput, telephoneInput, locationInput));
    public AddingStoryPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAddStoryFormContainer(){
        return addStoryFormContainer;
    }
    public WebElement getStoryInput(){
        return storyInput;
    }
    public WebElement getNameInput(){
        return nameInput;
    }
    public WebElement getEmailInput(){
        return emailInput;
    }
    public WebElement getTelephoneInput(){
        return telephoneInput;
    }
    public WebElement getLocationInput(){
        return locationInput;
    }
    public WebElement getAcceptTermsCheckBox(){
        return acceptTermsCheckBox;
    }
    public WebElement getSendStoryButton(){
        return sendStoryButton;
    }
    public List<WebElement> getResultParagraphsAfterAddingStory(){
        return resultParagraphsAfterAddingStory;
    }
    public WebElement getResultParagraphByIndex(int index){
        return getResultParagraphsAfterAddingStory().get(index);
    }
    public String getTextResultParagraphByIndex(int index){
        return getResultParagraphByIndex(index).getText();
    }
    public String getResultParagraphsAfterAddingStoryXPath(){
        return resultParagraphsAfterAddingStoryXPath;
    }
    public List<WebElement> getFormFields(){
        return formFields;
    }
    public List<WebElement> getErrorMessages(){
        return errorMessages;
    }
    public WebElement getErrorMessageByIndex(int index){
        return getErrorMessages().get(index);
    }
    public String getTextErrorMessageByIndex(int index){
        return getErrorMessageByIndex(index).getText();
    }
    public String getErrorMessagesXPath(){
        return errorMessagesXPath;
    }
}
