package test_app.xueqiu.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ManageStockPage extends BasePage{
    public ManageStockPage(AndroidDriver driver) {
        super(driver);
    }


    public ManageStockPage selectAll(){

        driver.findElement(By.id("com.xueqiu.android:id/check_all")).click();
        return this;
    }

    public ManageStockPage deleteAll(){
        driver.findElement(By.id("com.xueqiu.android:id/cancel_follow")).click();
        driver.findElement(By.id("com.xueqiu.android:id/tv_right")).click();
        return this;
    }

    public ManageStockPage done(){
        driver.findElement(By.id("com.xueqiu.android:id/action_close")).click();
        return this;
    }
}
