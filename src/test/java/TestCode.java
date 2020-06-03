import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.math.BigDecimal;

public class TestCode {

    @Test
    public void test(){
        System.setProperty("webdriver.chrome.driver","/Users/prsu/tools/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
        driver.quit();
    }

    @Test
    public void testPrecise(){
        BigDecimal bd1 = new BigDecimal("0.01");
        BigDecimal bd2 = new BigDecimal("0.010");
        if(0.01 == 0.010){
            System.out.println("double is equal");
        }
        if(bd1 == bd2){
            System.out.println("big decimal is equal");
        }
        if(bd1.compareTo(bd2) == 0){
            System.out.println("big decimal equals function works.");
        }

    }
}
