package test_app.xueqiu.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage{

    private By nameLocator=By.id("name");

    public SearchPage(AndroidDriver driver){
        super(driver);
    }

    public SearchPage search(String keyword){
        MobileElement el2 = (MobileElement) driver.findElementById("com.xueqiu.android:id/search_input_text");
        el2.sendKeys(keyword);

        return this;
    }

    public List<String> getSearchList(){
        List<String> nameList=new ArrayList<>();
        for(Object element: driver.findElements(nameLocator)){
            nameList.add(((WebElement)element).getText());
        }

        //todo: stream lamda优化

        return nameList;
    }

    public double getPrice(){
        driver.findElement(nameLocator).click();
        return Double.valueOf(driver.findElement(By.id("current_price")).getText());
    }

    public SearchPage follow() {
        driver.findElement(nameLocator).click();
        driver.findElement(By.id("follow_btn")).click();

        try{
            WebElement element = driver.findElement(By.id("com.xueqiu.android:id/tv_left"));
            element.click();
        }catch (Exception e){

        }

        return this;
    }


    public SearchPage cancel() {
        driver.findElement(By.id("com.xueqiu.android:id/action_close")).click();
        return this;
    }

}
