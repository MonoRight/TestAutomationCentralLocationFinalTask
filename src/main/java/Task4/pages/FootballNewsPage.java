package Task4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FootballNewsPage extends BasePage{

    @FindBy(xpath = "//li[contains(@class, 'sport-navigation')]//a[@data-stat-title='Scores & Fixtures']")
    private WebElement scoresAndFixturesSelection;
    public FootballNewsPage(WebDriver driver) {
        super(driver);
    }
    public WebElement getScoresAndFixturesSelection(){
        return scoresAndFixturesSelection;
    }
}
