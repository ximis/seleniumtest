package test_framework;

import test_app.wework.page.AppBasePage;
import wework.page.WebBasePage;

public class Factory {
    public static BasePage create(String driverName){
        if(driverName.equals("web") || driverName.equals("selenium")){
            return new WebBasePage();
        }else if(driverName.equals("app") || driverName.equals("appium")){
            return new AppBasePage();
        }

        return null;
    }
}
