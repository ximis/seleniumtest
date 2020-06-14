package test_app.wework.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class WorkBench extends BasePage{
    public WorkBench(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public Report toReport(){

        //确保工作台加载出来了
        find(By.xpath("//*[@text='添加应用']"));
//        try {
//            TimeUnit.SECONDS.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        scrollDown();

        click(By.xpath("//*[@text='汇报']"));

        return new Report(driver);
    }
}
