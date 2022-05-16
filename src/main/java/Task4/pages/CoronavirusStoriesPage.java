package Task4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoronavirusStoriesPage extends BasePage {
    @FindBy(xpath = "//h3[contains(text(), 'share')]")
    private WebElement shareCoronavirusStory;

    public CoronavirusStoriesPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getShareCoronavirusStory(){
        return shareCoronavirusStory;
    }

}
