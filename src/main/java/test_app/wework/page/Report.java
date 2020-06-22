package test_app.wework.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class Report extends AppBasePage {
    public Report(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public Report addDailyReprot(String now, String next, String others,String user){
        click(By.xpath("//*[@text='日报']"));

        sendKeys(By.xpath("//android.widget.EditText[1]"), now);
        sendKeys(By.xpath("//android.widget.EditText[2]"), next);
        sendKeys(By.xpath("//android.widget.EditText[3]"), others);

        scrollDown();

//        click(By.xpath("//android.view.View[@content-desc=\"请选择汇报对象\"]"));
//
//        click(By.xpath("//*[@text='"+user+"']/../../../android.widget.FrameLayout[1]"));
//
//        click(By.xpath("//*[@text='确定']"));

        click(By.xpath("//android.view.View[@content-desc=\"提交\"]\n"));
//        clickUntil(By.xpath("//*[@text='提交']"),
//                By.xpath("//android.view.View[@content-desc='今日工作']/following-sibling::android.view.View[1]"));
        return this;
    }

    public Report addWeeklyReport(String now, String next, String others,String user){
        click(By.xpath("//*[@text='周报']"));

        sendKeys(By.xpath("//android.widget.EditText[1]"), now);
        sendKeys(By.xpath("//android.widget.EditText[2]"), next);
        sendKeys(By.xpath("//android.widget.EditText[3]"), others);

        scrollDown();

//        click(By.xpath("//android.view.View[@content-desc=\"请选择汇报对象\"]"));
//
//        click(By.xpath("//*[@text='"+user+"']/../../../android.widget.FrameLayout[1]"));
//
//        click(By.xpath("//*[@text='确定']"));
        click(By.xpath("//android.view.View[@content-desc=\"提交\"]\n"));

        return this;
    }

    public Map<String, String> getDailyReport(){
        Map<String, String> data = new HashMap<>();
        ;
        find(By.xpath("//android.view.View[@content-desc=\"我的日报\"]"));
        data.put("now",find(By.xpath("//android.view.View[@content-desc='今日工作']/following-sibling::android.view.View[1]"))
                .getAttribute("content-desc"));
        data.put("next",find(By.xpath("//android.view.View[@content-desc='明日计划']/following-sibling::android.view.View[1]"))
                .getAttribute("content-desc"));
        data.put("others",find(By.xpath("//android.view.View[@content-desc='其他事项']/following-sibling::android.view.View[1]"))
                .getAttribute("content-desc"));

        data.put("user",find(By.xpath("//android.view.View[contains(@content-desc,\"已汇报给\")]"))
                .getAttribute("content-desc"));

        return data;

    }

    public Map<String, String> getWeeklyReport(){
        Map<String, String> data = new HashMap<>();

        data.put("now",find(By.xpath("//android.view.View[@content-desc='本周工作']/following-sibling::android.view.View[1]"))
                .getAttribute("content-desc"));
        data.put("next",find(By.xpath("//android.view.View[@content-desc='下周计划']/following-sibling::android.view.View[1]"))
                .getAttribute("content-desc"));
        data.put("others",find(By.xpath("//android.view.View[@content-desc='其他事项']/following-sibling::android.view.View[1]"))
                .getAttribute("content-desc"));

        data.put("user",find(By.xpath("//android.view.View[contains(@content-desc,\"已汇报给\")]"))
                .getAttribute("content-desc"));

        return data;

    }




    public Report back(){
        click(By.id("gyb"));
        return this;
    }

}
