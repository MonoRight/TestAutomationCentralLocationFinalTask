package Task4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultSearchingPage extends BasePage {
    @FindBy(xpath = "//span[@role='text']//span")
    private List<WebElement> searchTitlesList;

    public ResultSearchingPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSearchTitlesList(){
        return searchTitlesList;
    }
    public WebElement getSearchTitleByIndex(int index){
        return getSearchTitlesList().get(index);
    }
    public String getTextSearchTitleByIndex(int index){
        return getSearchTitleByIndex(index).getText();
    }
}
