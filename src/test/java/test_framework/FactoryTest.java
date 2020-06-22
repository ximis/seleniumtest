package test_framework;

import org.junit.jupiter.api.Test;

class FactoryTest {

    @Test
    void create() {
        BasePage basePage = Factory.create("web");
        UIAuto uiAuto = basePage.load("/test_framework/webauto.yaml");
        basePage.run(uiAuto);

    }
}