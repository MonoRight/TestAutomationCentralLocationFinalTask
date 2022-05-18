package Task4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FootballScoresAndFixturesPage extends BasePage{
    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchInputCompetitions;
    @FindBy(xpath = "//ul[@id='search-results-list']/li")
    private List<WebElement> searchResultList;
    @FindBy(xpath = "//li[contains(@class, 'date-picker')]/a/span[1]")
    private List<WebElement> monthList;
    @FindBy(xpath = "//li[contains(@class, 'date-picker')]/a/span[2]")
    private List<WebElement> yearList;
    @FindBy(xpath = "//li[contains(@class, 'date-picker')]")
    private List<WebElement> yearAndMonthSelectList;
    @FindBy(xpath = teamsListXPath)
    private List<WebElement> teamsList;
    private final String teamsListXPath = "//span[@class='sp-c-fixture__team-name-wrap']";
    @FindBy(xpath = "//span[contains(@class, 'sp-c-fixture__number')]")
    private List<WebElement> scoresList;

    public FootballScoresAndFixturesPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchInputCompetitions(){
        return searchInputCompetitions;
    }
    public List<WebElement> getSearchResultList(){
        return searchResultList;
    }
    public WebElement getSearchResultListByIndex(int index){
        return getSearchResultList().get(index);
    }

    public List<WebElement> getMonthList(){
        return monthList;
    }

    public WebElement getMonthByIndex(int index){
        return getMonthList().get(index);
    }

    public String getTextMonthByIndex(int index){
        return getMonthByIndex(index).getText();
    }

    public List<WebElement> getYearList(){
        return yearList;
    }
    public WebElement getYearByIndex(int index){
        return getYearList().get(index);
    }
    public String getTextYearByIndex(int index) {
        return getYearByIndex(index).getText();
    }

    public List<WebElement> getYearAndMonthSelectList(){
        return yearAndMonthSelectList;
    }
    public WebElement getYearAndMonthSelectByIndex(int index){
        return getYearAndMonthSelectList().get(index);
    }
    public List<WebElement> getTeamsList(){
        return teamsList;
    }
    public WebElement getTeamByIndex(int index){
        return getTeamsList().get(index);
    }
    public String getTextTeamByIndex(int index){
        return getTeamByIndex(index).getText();
    }
    public String getTeamsListXPath(){
        return teamsListXPath;
    }
    public List<WebElement> getScoresList(){
        return scoresList;
    }
    public WebElement getScoreByIndex(int index){
        return getScoresList().get(index);
    }
    public String getTextScoreByIndex(int index){
        return getScoreByIndex(index).getText();
    }
    public int getIntScoreByIndex(int index){
        return Integer.parseInt(getTextScoreByIndex(index));
    }
}
