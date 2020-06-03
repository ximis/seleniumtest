package wework.contact;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import wework.page.Contactpage;
import wework.page.MainPage;

import java.util.concurrent.TimeUnit;

public class TestContact {
    static MainPage main;
    static Contactpage contact;

    @BeforeAll
    static void beforeAll(){
        main=new MainPage();
        contact=main.toConcat();
    }
    @Test
    void testAddMemeber(){

        contact.addMemeber("3","3", "18600000001");
        //todo: assert
    }

    @Test
    void testAddDepartment(){
        String departmentName = "test";
        contact.addDepartment(departmentName, "ximis");
        int count = 0;
        while(contact.getCurrentDepartmentName() != departmentName && count < 2){
            count ++;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        assertEquals(contact.getCurrentDepartmentName(), departmentName);
        contact.deleteDepartment(departmentName);
    }

    @Test
    void testAddTag(){
        String tagName = "test";
        contact.addTag(tagName);
//        int count = 0;
//        while(contact.getCurrentDepartmentName() != departmentName && count < 2){
//            count ++;
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        assertEquals(contact.getCurrentDepartmentName(), departmentName);
        contact.deleteTag(tagName);
    }



    @AfterAll
    static void afterAll(){
        try {
            TimeUnit.SECONDS.sleep(20 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        contact.quit();
    }
}
