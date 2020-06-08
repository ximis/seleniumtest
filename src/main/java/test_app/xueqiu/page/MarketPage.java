package test_app.xueqiu.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MarketPage extends BasePage {
    public MarketPage(AndroidDriver driver) {
        super(driver);
    }

    public SearchPage toSearch(){

        driver.findElement(By.id("com.xueqiu.android:id/action_search")).click();
        return new SearchPage(driver);
    }

    public ManageStockPage toManageStock(){
        driver.findElement(By.id("com.xueqiu.android:id/edit_group")).click();
        return new ManageStockPage(driver);
    }

    public int getStocksSize(){
        //name_and_symbol
        return driver.findElements(By.id("portfolio_stockName")).size();
    }

}
