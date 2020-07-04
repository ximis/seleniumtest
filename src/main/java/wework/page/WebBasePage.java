package wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test_framework.BasePage;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class WebBasePage extends BasePage {
    RemoteWebDriver driver = null;
    WebDriverWait wait=null;

//    public WebBasePage() {
//        System.setProperty("webdriver.chrome.driver","/Users/prsu/tools/chromedriver");
//
//        //设置使用已经打开的chrome
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
//        //因为使用的是预先打开的浏览器，我们可以直接在这里调试啦！可以先把网页打开！可以提高写代码的速度！
//        driver = new ChromeDriver();
//        driver.get("https://work.weixin.qq.com/wework_admin/frame");
//
//        DealCookies.loadCookie(driver);
//
//        driver.get("https://work.weixin.qq.com/wework_admin/frame");
//        System.out.println(driver.manage().getCookies().toString());
//
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//        wait = new WebDriverWait(driver,10);
//    }

    public WebBasePage() {
        System.setProperty("webdriver.chrome.driver","/Users/prsu/tools/chromedriver");

        //设置使用已经打开的chrome
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
        //因为使用的是预先打开的浏览器，我们可以直接在这里调试啦！可以先把网页打开！可以提高写代码的速度！
        driver = new ChromeDriver();
//        driver.get("https://work.weixin.qq.com/wework_admin/frame");

//        DealCookies.loadCookie(driver);

//        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        System.out.println(driver.manage().getCookies().toString());

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver,10);
    }

    public WebBasePage(RemoteWebDriver driver){
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


    public String getattribute(By by, String attr){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by).getAttribute(attr);
    }

    @Override
    public String getattribute(HashMap<String, Object> map) {
        super.getattribute(map);

        String attr = (String)map.get("getattribute");

        By by = null;
        if(map.containsKey("id")){
            by = By.id((String)map.get("id"));
        }else if(map.containsKey("linktext")){
            by = By.linkText((String)map.get("linktext"));
        }else if(map.containsKey("xpath")){
            by = By.xpath((String)map.get("xpath"));
        }

        String data = getattribute(by, attr);
        System.out.println("get attr: "+ attr + ":"+data);
        return data;
    }

    @Override
    public void click(HashMap<String, Object> data) {
        super.click(data);
        String key = data.keySet().toArray(new String[0])[0];
        String value = (String) data.get(key);

        By by = null;
        if(key.toLowerCase().equals( "id")){
            by = By.id(value);
        }else if(key.toLowerCase().equals("linktext")){
            by = By.linkText(value);
        }else if(key.toLowerCase().equals("xpath")){
            by = By.xpath(value);
        }

        this.click(by);
    }



    @Override
    public void action(HashMap<String, Object> map) {
        super.action(map);
        if(map.containsKey("action")){
            String action = map.get("action").toString().toLowerCase();
            if(action.equals("get")){
                driver.get(map.get("url").toString());
            }
        }

    }
}
