package test_app.wework.testcases;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test_app.wework.page.MainPage;
import test_app.wework.page.WaitToBeDone;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WaitToBeDoneTest {
    static MainPage mainPage;
    static WaitToBeDone waitToBeDone;

    @BeforeAll
    static void setUp() {
        mainPage = new MainPage();
        waitToBeDone = mainPage.toWaitToBeDone();
    }

    @AfterAll
    static void tearDown() {
        waitToBeDone.back();
        waitToBeDone.quit();
    }

    @Test
    void add() {
        String data = "吃饭了";
        assertTrue(waitToBeDone.add(data).getWaitToBeDoneLists().contains(data));
        waitToBeDone.done(data);
    }

    @Test
    void done() {
        String data = "吃饭了2";
        waitToBeDone.add(data);
        waitToBeDone.done(data);
        assertFalse(waitToBeDone.getWaitToBeDoneLists().contains(data));
    }

    @Test
    void back() {
        waitToBeDone.back();
        mainPage.toWaitToBeDone();
    }
}