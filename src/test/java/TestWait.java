import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.function.Function;

public class TestWait {
    WebDriver driver=null;

//    @BeforeClass
    public void before(){
        //设置chrome driver的路径
        System.setProperty("webdriver.chrome.driver","/Users/prsu/tools/chromedriver");

        //设置使用已经打开的chrome
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");


        driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
    }

    @Test
    public void test_before_with_debug_chrome(){
        //设置chrome driver的路径
        System.setProperty("webdriver.chrome.driver","/Users/prsu/tools/chromedriver");

        //设置使用已经打开的chrome
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
        //因为使用的是预先打开的浏览器，我们可以直接在这里调试啦！可以先把网页打开！可以提高写代码的速度！
        driver = new ChromeDriver(options);
        //
        driver.findElement(new By.ByXPath("//*[@id=\"main-nav-menu\"]/ul/li[1]/a")).click();
    }


    @Test
    public void testAddCookies(){
        //设置chrome driver的路径
        System.setProperty("webdriver.chrome.driver","/Users/prsu/tools/chromedriver");

        //设置使用已经打开的chrome
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
        //因为使用的是预先打开的浏览器，我们可以直接在这里调试啦！可以先把网页打开！可以提高写代码的速度！
        driver = new ChromeDriver(options);

        System.out.println(driver.manage().getCookies().toString());

    }



    @Test
    public void testExplicitWait(){
        new WebDriverWait(driver, Duration.ofSeconds(3).toMillis()).until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));

    }

    @Test
    public void testFluentWait(){
        // Waiting 30 seconds for an element to be present on the page, checking
    // for its presence once every 5 seconds.
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class)
                .ignoreAll(Arrays.asList(NoSuchWindowException.class,
                        NoSuchWindowException.class,
                        NoSuchCookieException.class));

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("foo"));
            }
        });

    }
}
