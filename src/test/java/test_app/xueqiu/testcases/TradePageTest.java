package test_app.xueqiu.testcases;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test_app.xueqiu.page.MainPage;
import test_app.xueqiu.page.TradePage;

import java.net.MalformedURLException;

class TradePageTest {
    static MainPage mainPage;
    static TradePage tradePage;

    @BeforeAll
    static void beforeAll() throws MalformedURLException {
        mainPage = new MainPage();
        tradePage = mainPage.toTrade();
    }

    @Test
    void register() {
        tradePage.register("18500989890");
    }

    @AfterAll
    static void afterAll(){

    }
}