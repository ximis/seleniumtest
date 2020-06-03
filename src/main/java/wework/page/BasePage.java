package wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DealCookies;

import java.util.concurrent.TimeUnit;

public class BasePage {
    RemoteWebDriver driver = null;
    WebDriverWait wait=null;

    public BasePage() {
        System.setProperty("webdriver.chrome.driver","/Users/prsu/tools/chromedriver");

        //设置使用已经打开的chrome
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
        //因为使用的是预先打开的浏览器，我们可以直接在这里调试啦！可以先把网页打开！可以提高写代码的速度！
        driver = new ChromeDriver();
        driver.get("https://work.weixin.qq.com/wework_admin/frame");

        DealCookies.loadCookie(driver);

        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        System.out.println(driver.manage().getCookies().toString());

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver,10);
    }

    public BasePage(RemoteWebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    public void quit(){
        driver.quit();
    }


    public void click(By by){
        //todo: 异常处理
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    public void sendKeys(By by, String content){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).sendKeys(content);
    }

    public String getElementText(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by).getText();
    }

    public void upload(By by, String path){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        driver.findElement(by).sendKeys(path);
    }


}
