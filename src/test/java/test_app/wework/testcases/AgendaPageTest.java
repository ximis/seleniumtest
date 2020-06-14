package test_app.wework.testcases;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test_app.wework.page.AgendaPage;
import test_app.wework.page.MainPage;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AgendaPageTest {

    static MainPage mainPage;
    static AgendaPage agendaPage;

    @BeforeAll
    static void beforeAll() throws MalformedURLException {
        mainPage = new MainPage();
        agendaPage = mainPage.toAgenda();
    }

    @Test
    void add() {
//        List<String> data = agendaPage.add("上班打卡", null).getAgenda(null);
//        data.stream().forEach(x-> System.out.println(x));
        agendaPage.deleteRecords();
        assertTrue(agendaPage.add("上班打卡", null).getAgenda(null).contains("上班打卡"));
        agendaPage.deleteRecords();
    }

    @Test
    void getAgenda() {


    }

    @AfterAll
    static void clear(){
//        mainPage.quit();
    }
}