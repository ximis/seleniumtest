package test_app.wework.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {

    AndroidDriver<MobileElement> driver = null;
    WebDriverWait wait = null;
    TouchAction touchAction = null;


    public BasePage() {

        startApp("com.tencent.wework", ".launch.WwMainActivity");
//        startApp("com.tencent.wework", ".launch.LaunchSplashActivity");
    }

    public void startApp(String appPackage, String appActivity) {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appPackage", appPackage);
        desiredCapabilities.setCapability("appActivity", appActivity);
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("noReset", "true");
        desiredCapabilities.setCapability("skipLogcatCapture", "true");
        desiredCapabilities.setCapability("skipDeviceInitialization  ", "true");
        desiredCapabilities.setCapability("skipServerInstallation  ", "true");

        URL remoteUrl = null;
        try {
            remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 60);
        touchAction = new TouchAction(driver);
    }

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        touchAction = new TouchAction(driver);
    }


    public void quit() {
        driver.quit();
    }


    public void click(By by) {
        //todo: 异常处理by
        //移动端的元素，就是显示不可点击，实际上也是可以点击的
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    public List<String> findElementsText(By  by) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        List<String> res = new LinkedList<>();
        try {
            driver.findElements(by).stream().forEach(x ->
                    res.add(x.getText())
            );
        } catch (Exception e){
            // for the element does not exist
            //todo: 可以搞清楚具体是什么异常。使用NoSuchElment居然不可以。

        }
        return res;
    }

    public void sendKeys(By by, String content) {
        //由于移动端的元素，就算不可见，实际上也是可见的
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).sendKeys(content);
    }

    public MobileElement find(By by) {

        return driver.findElement(by);
    }

    public List<MobileElement> finds(By by) {

        return driver.findElements(by);

    }

    public void scroll(int sx, int sy, int dx, int dy){

        touchAction.press(PointOption.point(sx, sy)).waitAction().moveTo(PointOption.point(dx,dy)).release().perform();
    }

    public void scrollDown(){
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();

        scroll(width* 1/2, height * 3/4, width * 1/2, height * 1/4);
    }
    public void scrollDown2(){

    }
}
