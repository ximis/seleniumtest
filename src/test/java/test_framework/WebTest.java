package test_framework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class WebTest {

    private static BasePage basePage;

    @BeforeAll
    static void beforeAll(){

    }

    @BeforeEach
    void beforeEach(){

    }


    @Test
    void classic1(){
        BasePage basePage = UIAutoFactory.create("web");
        UIAuto uiAuto = basePage.load("/test_framework/webauto.yaml");
        basePage.run(uiAuto);
    }

    @ParameterizedTest(name = "{index} {1}")
//    @MethodSource("classic2")
    @MethodSource
    void classic2(UIAuto uiAuto, String path){
        basePage.run(uiAuto);
    }

    static Stream<Arguments> classic2(){
        basePage = UIAutoFactory.create("web");
        basePage.loadPages("src/main/resources/test_framework");
        List<Arguments> all = new ArrayList<>();

        Arrays.asList(
//                "/test_framework/webauto.yaml",
//                "/test_framework/webauto_1.yaml",
//                "/test_framework/webauto_2.yaml",
                "/test_framework/po.yaml"
        ).stream().forEach(path -> {
            UIAuto uiAuto = basePage.load(path);
            uiAuto.description = path;
            all.add(arguments(uiAuto, path));
        });

//        UIAuto uiAuto = basePage.load("/test_framework/webauto.yaml");
//        Stream.of(uiAuto);
//        return all.stream();
        return all.stream();

    }

}
