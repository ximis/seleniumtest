package test_app.wework.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.Date;
import java.util.List;

public class AgendaPage extends BasePage{
    public AgendaPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    //day time: 目前支持日期的
    public AgendaPage add(String name, Date date){

        if(date != null){
            // todo:
        }
        click(By.id("gym"));
        sendKeys(By.id("b2k"), name);
        click(By.xpath("//*[@text='保存']"));
        return this;
    }

    //默认可以设置为null
    public List<String> getAgenda(Date date){
        if(date != null ){
            //todo:
        }
        return findElementsText(By.id("gg_"));
    }


    public void back(){
        click(By.id("gyb"));
    }

    public AgendaPage deleteRecords(){

        while (finds(By.id("gg_")).size()>0){
            click(By.id("gg_"));
            click(By.id("bfi"));
            click(By.xpath("//*[@text='删除']"));
        }
        return this;
    }


}
