package test_app.webview;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebViewTest {

    private static AndroidDriver driver;

    @BeforeAll
    public static void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
//        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("deviceName", "emulator-5556");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("noReset", "true");

        desiredCapabilities.setCapability("chromedriverExecutable", "/Users/prsu/tools/chromedriver");

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

//        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver = new AndroidDriver(desiredCapabilities);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@text='交易']"));


    }

    @Test
    void webview_native(){
        driver.findElement(By.xpath("//*[@text='交易']")).click();

        driver.findElement(By.xpath("//*[@content-desc='基金开户']")).click();
    }

    @Test
    void webview_web(){
        driver.findElement(By.xpath("//*[@text='交易']")).click();

        driver.getContextHandles().forEach(System.out::println);
        driver.context(driver.getContextHandles().toArray()[1].toString());

        driver.getWindowHandles().forEach(window ->{
            System.out.println(window);
            System.out.println(driver.getTitle());
            driver.switchTo().window(window);
            System.out.println(driver.getPageSource());

        });
//
//        driver.switchTo().window(driver.getWindowHandles().stream().filter(window
//        }));
        String[] array = driver.getWindowHandles().toArray(new String[0] );

        //todo: 这个位置需要优化，在我的代码里，新打开的页面，是在窗口里的第一个，老师的页面里，是在最后一个。
//        driver.switchTo().window(array[array.length-1]);
        driver.switchTo().window(array[0]);


        driver.findElement(By.cssSelector(".trade_home_info_3aI")).click();

    }

    @Test
    public void sampleTest() {
        MobileElement el1 = (MobileElement) driver.findElementById("com.xueqiu.android:id/home_search");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.xueqiu.android:id/search_input_text");
        el2.sendKeys("alibaba");
//        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]");
//        el3.click();
//        MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout[3]/android.widget.TextView");
//        el4.click();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}

