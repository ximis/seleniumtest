package wework.page;

import org.openqa.selenium.By;


public class MainPage extends BasePage {



    public Contactpage toConcat(){
        //todo:
        driver.findElement(By.id("menu_contacts")).click();
        return new  Contactpage(driver);
    }





}
