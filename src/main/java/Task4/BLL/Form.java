package Task4.BLL;

import Task4.pages.BasePage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Form {
    public static void FillForm(BasePage page, List<WebElement> inputs, List<String> values){
        for(int i = 0; i < inputs.size(); i++){
            page.clickTheWebElement(inputs.get(i));
            page.enterInput(inputs.get(i), values.get(i));
        }
    }
}
