package Task4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
    @FindBy(xpath = "//input[@id='search-input']")
    private WebElement searchInput;
    @FindBy(xpath = "//button[@data-testid='test-search-submit']")
    private WebElement searchButton;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchButton(){
        return searchButton;
    }

    public WebElement getSearchInput(){
        return searchInput;
    }

}
