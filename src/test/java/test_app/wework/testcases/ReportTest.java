package test_app.wework.testcases;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test_app.wework.page.MainPageApp;
import test_app.wework.page.Report;

import java.net.MalformedURLException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ReportTest {

    static MainPageApp mainPage;
    static Report report;

    @BeforeAll
    static void beforeAll() throws MalformedURLException {
        mainPage = new MainPageApp();
        report = mainPage.toWorkBench().toReport();
    }

    @Test
    void addDailyReprot() {
        String now = "1222";
        String next = "下一步";
        String others = "其他的";
        String user = "test";
        Map<String, String> map = report.addDailyReprot(now,next,others,user).getDailyReport();
        assertTrue(map.get("now").equals(now));
        assertTrue(map.get("next").equals(next));
        assertTrue(map.get("others").equals(others));
        assertTrue(map.get("user").contains(user));
    }

    @Test
    void addWeeklyReport() {
        String now = "1222";
        String next = "下一步";
        String others = "其他的";
        String user = "test";
        Map<String, String> map = report.addWeeklyReport(now,next,others,user).getWeeklyReport();
        assertTrue(map.get("now").equals(now));
        assertTrue(map.get("next").equals(next));
        assertTrue(map.get("others").equals(others));
        assertTrue(map.get("user").contains(user));
    }

    @AfterAll
    static void clear(){
//        mainPage.quit();
    }
}