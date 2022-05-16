package Task3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class NewsPage extends BasePage{
    @FindBy(xpath = "//div[contains(@class, 'top-stories-primary')]//h3[contains(@class, 'promo-heading__title')]")
    private List<WebElement> titleList;
    @FindBy(xpath = "//a[@class='gs-c-promo-heading gs-o-faux-block-link__overlay-link gel-pica-bold nw-o-link-split__anchor']")
    private List<WebElement> secondaryTitlesList;
    @FindBy(xpath = "//nav[@class='nw-c-nav__wide']//span[contains(text(), 'Coronavirus')]")
    private WebElement coronavirusSelection;
    @FindBy(xpath = "//a[@id='orbit-search-button']")
    private WebElement searchButton;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getTitleList(){
        return titleList;
    }
    public WebElement getTitleByIndex(int index){
        return getTitleList().get(index);
    }
    public List<WebElement> getSecondaryTitlesList(){
        return secondaryTitlesList;
    }
    public WebElement getSecondaryTitleByIndex(int index){
        return getSecondaryTitlesList().get(index);
    }
    public String getTextSecondaryTitleByIndex(int index) {
        return getSecondaryTitleByIndex(index).getText();
    }

    public WebElement getSearchButton(){
        return searchButton;
    }
    public WebElement getCoronavirusSelection(){
        return coronavirusSelection;
    }

    public String getTextCoronavirusSelection(){
        return getCoronavirusSelection().getText();
    }


}
