package test_app.xueqiu.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class TradePage extends BasePage{

    public TradePage(AndroidDriver<MobileElement> driver) {
        super(driver);

        switchContext("WEBVIEW_");
        //用来确保交易页面加载成功了
        find(By.xpath("//div[h1='A股开户']"));
        switchWindowByTitle("实盘交易");
    }

    public TradePage register(String mobile){
        click(By.xpath("//div[h1='A股开户']"));


        switchWindowByTitle("雪球");
        click(By.cssSelector(".open_more_plusImg_rAz"));

        switchWindowByTitle("中信证券");
//        sendKeys(By.id("mobile"), mobile);
        sendKeys(By.xpath("//input[contains(@placeholder,'手机号')]"), mobile);
//        click(By.id("djs"));
        click(By.cssSelector(".hqbtn"));
//        sendKeys(By.id("validCode"), "123456");
        sendKeys(By.xpath("//input[contains(@placeholder,'验证')]"), "1234");
//        click(By.id("submitBtn"));
        click(By.cssSelector(".subBtn"));

        return this;
    }


}
