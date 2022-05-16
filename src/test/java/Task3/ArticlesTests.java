package Task3;

import Task3.pages.BLL;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ArticlesTests extends BaseTest{

    private final static long DEFAULT_WAIT = 60;
    private final static int INDEX_OF_TITLE = 0;
    private final static String TITLE_TEXT = "Russian battalion wiped out in failed river crossing - UK";
    private final static String EXPECTED_RESULT_TITLE = "Ministers give coronavirus restrictions update";
    private List<String> articles = new ArrayList<>();

    @Test(priority = 0)
    public void checkNameOfArticleInNewsSection(){
        assertEquals(TITLE_TEXT, businessLogicLayer.getTextOfMainArticle(DEFAULT_WAIT, INDEX_OF_TITLE));
    }

    @Test(priority = 1)
    public void checkFirstFiveSecondaryArticles(){
        articles.add("CCTV shows Russian soldiers killing Ukrainian civilians");
        articles.add("North Korea announces first death from Covid-19");
        articles.add("India couple sue son for not giving them a grandchild");
        articles.add("Ireland fail to make Eurovision Song Contest final");
        articles.add("Moon soil used to grow plants for first time");

        for(int i = 0; i < articles.size(); i++){
            assertTrue(businessLogicLayer.checksSecondaryArticles(articles.get(i), i));
        }
        articles.clear();
    }

    @Test(priority = 2)
    public void checkNameOfFirstArticleAfterSearching(){
        assertEquals(EXPECTED_RESULT_TITLE, businessLogicLayer.getTextArticleAfterSearching(INDEX_OF_TITLE));
    }
}
