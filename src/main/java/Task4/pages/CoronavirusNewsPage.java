package Task4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CoronavirusNewsPage extends BasePage {
    @FindBy(xpath = "//header//span[contains(text(), 'Your Coronavirus')]")
    private List<WebElement> coronavirusStoriesList;

    public CoronavirusNewsPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getCoronavirusStoriesList(){
        return coronavirusStoriesList;
    }
    public WebElement getCoronavirusStoryByIndex(int index){
        return getCoronavirusStoriesList().get(index);
    }
}
