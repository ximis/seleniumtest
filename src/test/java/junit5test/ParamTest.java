package junit5test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParamTest {

    @ParameterizedTest
    @NullSource
//    @ValueSource(strings = {" ", "  "})
    void nullEmptyAndBlanksSTrings(String text){
        assertTrue(text == null);
    }
}
