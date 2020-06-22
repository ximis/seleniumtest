package test_app.wework.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.List;

public class WaitToBeDone extends AppBasePage {
    public WaitToBeDone(AndroidDriver<MobileElement> driver) {
        super(driver);
    }


    public WaitToBeDone add(String data){
        click(By.id("gym"));
        sendKeys(By.id("b2k"), data);
        click(By.xpath("//*[@text='保存']"));


        return this;
    }

    public WaitToBeDone done(String data){
        click(By.xpath("//*[@text='"+ data+"']/../../android.widget.ImageView"));
        return this;
    }

    public List<String> getWaitToBeDoneLists(){
        return findElementsText(By.id("gw9"));
    }

    public void back(){
        click(By.id("gyb"));
    }

}
