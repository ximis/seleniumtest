package test_app.xueqiu.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BasePage {

    AndroidDriver<MobileElement> driver = null;
    WebDriverWait wait=null;


    public BasePage(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("noReset", "true");
        desiredCapabilities.setCapability("skipLogcatCapture", "true");
        desiredCapabilities.setCapability("skipDeviceInitialization  ", "true");
        desiredCapabilities.setCapability("skipServerInstallation  ", "true");
        //用来启用h5的
        desiredCapabilities.setCapability("chromedriverExecutable", "/Users/prsu/tools/chromedriver");

        URL remoteUrl = null;
        try {
            remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver = new AndroidDriver(desiredCapabilities);
//        driver = new AndroidDriver(remoteUrl, desiredCapabilities);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,30);

    }

    public BasePage(AndroidDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);

    }


    public void quit(){
        driver.quit();
    }


    public void click(By by){
        //todo: 异常处理
        //移动端的元素，就是显示不可点击，实际上也是可以点击的
//        wait.until(ExpectedConditions.elementToBeClickable(by));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).click();
    }

    public void sendKeys(By by, String content){
        //由于移动端的元素，就算不可见，实际上也是可见的
//        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).sendKeys(content);
    }

    public MobileElement find(By by){
        return driver.findElement(by);
    }


    //webview part
    public void switchContext(String name){
        driver.getContextHandles().forEach(context -> {
            if(context.contains(name)){
                driver.context(context);
            }
        });
    }

    //webview part
    public void switchWindowByTitle(String title){
        int count = 10;
        boolean isSuccess = false;
        while (!isSuccess && count-- >0){
            for(String window: driver.getWindowHandles()){
                driver.switchTo().window(window);
                if(driver.getTitle().contains(title)){
                    isSuccess = true;
                    break;
                }
            }
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        if(!isSuccess) System.out.println("切换窗口失败--->" + title);

    }
}
