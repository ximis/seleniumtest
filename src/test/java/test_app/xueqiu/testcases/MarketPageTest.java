package test_app.xueqiu.testcases;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test_app.xueqiu.page.MainPage;
import test_app.xueqiu.page.MarketPage;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarketPageTest {

    static MainPage mainPage;
    static MarketPage marketPage;
    private Object assertEquals;

    @BeforeAll
    static void beforeAll() throws MalformedURLException {
        mainPage = new MainPage();
        marketPage = mainPage.toMarket();
    }

    @Test
    public void testDeleteAndAddstock(){
        if(marketPage.getStocksSize() != 0){
            marketPage.toManageStock().selectAll().deleteAll().done();
        }
        //判断删除股票成功
        assertEquals(marketPage.getStocksSize(),0);

        marketPage.toSearch().search("alibaba").follow().cancel();
        marketPage.toSearch().search("jd").follow().cancel();
        marketPage.toSearch().search("xiaomi").follow().cancel();

        assertEquals(marketPage.getStocksSize(),3);
    }

    @AfterAll
    public void clear(){
        marketPage.quit();
    }
}