package junit5test;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

public class Junit5DemoTest {


    //before class  等同于
    @Before("test")
    public void before(){

    }

    @Test
    void fun(){
        System.out.println("fun");
    }
}
