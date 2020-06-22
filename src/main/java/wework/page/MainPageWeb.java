package wework.page;

import org.openqa.selenium.By;


public class MainPageWeb extends WebBasePage {



    public Contactpage toConcat(){
        //todo:
        driver.findElement(By.id("menu_contacts")).click();
        return new  Contactpage(driver);
    }





}
