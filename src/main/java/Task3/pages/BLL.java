package Task3.pages;

import org.openqa.selenium.WebDriver;

public class BLL {

    private WebDriver driver;
    public BLL(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver getDriver(){
        return driver;
    }

    public HomePage getHomePage(){
        return new HomePage(getDriver());
    }
    public NewsPage getNewsPage(){
        return new NewsPage(getDriver());
    }
    public ResultSearchingPage getResultSearchingPage(){
        return new ResultSearchingPage(getDriver());
    }
    public SearchPage getSearchPage(){
        return new SearchPage(getDriver());
    }
}
