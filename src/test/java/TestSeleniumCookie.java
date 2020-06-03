import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

public class TestSeleniumCookie {
    WebDriver driver = null;

    @Test
    public void testAddCookies(){
        //设置chrome driver的路径
        System.setProperty("webdriver.chrome.driver","/Users/prsu/tools/chromedriver");

        //设置使用已经打开的chrome
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
        //因为使用的是预先打开的浏览器，我们可以直接在这里调试啦！可以先把网页打开！可以提高写代码的速度！
        driver = new ChromeDriver();
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        loadCookie();
//        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        System.out.println(driver.manage().getCookies().toString());

    }

    @Test
    public void testLoadCookies(){
        //设置chrome driver的路径
        System.setProperty("webdriver.chrome.driver","/Users/prsu/tools/chromedriver");

        //设置使用已经打开的chrome
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
        //因为使用的是预先打开的浏览器，我们可以直接在这里调试啦！可以先把网页打开！可以提高写代码的速度！
        driver = new ChromeDriver(options);
        saveCookie();
    }

    public void loadCookie(){
        try {
            FileReader fileReader = new FileReader("cookies.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line="";
            while ((line = bufferedReader.readLine()) != null ) {

                StringTokenizer tokenizer = new StringTokenizer(line, ";");
                String name = tokenizer.nextToken();
                String value = tokenizer.nextToken();
                String domain = tokenizer.nextToken();
                String path = tokenizer.nextToken();
                String expiry = tokenizer.nextToken();
                Date expiryD = null;
                String isSecury = tokenizer.nextToken();
                if (!expiry.equals("null")){
                    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                    try {
                        expiryD = sdf.parse(expiry);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }


                Cookie cookie = new Cookie(name, value, domain,path, expiryD, Boolean.parseBoolean(isSecury));
                driver.manage().addCookie(cookie);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.get("https://work.weixin.qq.com/wework_admin/frame");


    }




    public void saveCookie(){
        try {
            FileWriter fileWriter = new FileWriter("cookies.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(Cookie cookie: driver.manage().getCookies()){
                bufferedWriter.write(
                        cookie.getName() + ";" +
                        cookie.getValue() + ";" +
                        cookie.getDomain() + ";" +
                        cookie.getPath() + ";" +
                        cookie.getExpiry() + ";" +
                        cookie.isSecure()
                );
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
