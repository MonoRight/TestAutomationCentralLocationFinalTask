package Task4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MatchResultPage extends BasePage{
    @FindBy(xpath = resultScoresListXPath)
    private List<WebElement> resultScoresList;
    private final String resultScoresListXPath = "//div[contains(@class, 'match-overview-header')]//span[contains(@class, 'fixture__number')]";
    public MatchResultPage(WebDriver driver) {
        super(driver);
    }
    public List<WebElement> getResultScoresList(){
        return resultScoresList;
    }
    public WebElement getResultScoreByIndex(int index){
        return getResultScoresList().get(index);
    }
    public int getIntResultScoreByIndex(int index){
        return Integer.parseInt(getResultScoreByIndex(index).getText());
    }
    public String getResultScoresListXPath(){
        return resultScoresListXPath;
    }
}
