package Task4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SportPage extends BasePage{
    @FindBy(xpath = "//ul[@role='list']//span[text()='Football']")
    private List<WebElement> footballSectionList;

    public SportPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getFootballSectionList(){
        return footballSectionList;
    }

    public WebElement getFootballSectionByIndex(int index){
        return getFootballSectionList().get(index);
    }
}
