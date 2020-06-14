package test_app.xueqiu.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    public SearchPage toSearch(){

//        MobileElement el1 = (MobileElement) driver.findElementById("com.xueqiu.android:id/home_search");
//        el1.click();
        click(By.id("com.xueqiu.android:id/home_search"));
        return new SearchPage(driver);
    }

    public void toStock(){

    }


    public MarketPage toMarket(){
        WebElement element = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TabHost/android.widget.LinearLayout/android.widget.TabWidget/android.widget.RelativeLayout[2]/android.widget.TextView");
        element.click();
        return new MarketPage(driver);
    }

}
