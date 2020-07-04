package test_framework;

import org.junit.jupiter.api.Test;

class UIAutoFactoryTest {

    @Test
    void create() {
        BasePage basePage = UIAutoFactory.create("web");
        UIAuto uiAuto = basePage.load("/test_framework/webauto.yaml");
        basePage.run(uiAuto);
    }
}