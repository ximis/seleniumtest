package utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

public class DealCookies {
    public static void loadCookie(RemoteWebDriver driver){
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


    }

}
