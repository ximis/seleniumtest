package test_app.xueqiu.page;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class MainPage extends BasePage {

    public MainPage() throws MalformedURLException {
        super();
    }



    public SearchPage toSearch(){

        MobileElement el1 = (MobileElement) driver.findElementById("com.xueqiu.android:id/home_search");
        el1.click();
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
