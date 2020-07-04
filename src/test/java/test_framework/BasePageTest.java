package test_framework;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BasePageTest {
    static BasePage basePage;

    @BeforeAll
    static void beforell(){
        basePage = new BasePage();
    }

    @Test
    void run() {
        UIAuto uiAuto =  basePage.load("/test_framework/uiauto.yaml");
        basePage.run(uiAuto);
    }

    @Test
    void load() throws JsonProcessingException {
       UIAuto uiAuto =  basePage.load("/test_framework/uiauto.yaml");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(uiAuto));

    }


    @Test
    void runPOM() {
        basePage.loadPages("/Users/prsu/learn/seleniumtest/src/main/resources/test_framework");
        UIAuto uiAuto =  basePage.load("/test_framework/po.yaml");
        basePage.run(uiAuto);
    }
}