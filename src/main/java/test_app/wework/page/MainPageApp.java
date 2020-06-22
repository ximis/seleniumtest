package test_app.wework.page;

import org.openqa.selenium.By;

public class MainPageApp extends AppBasePage {
    public MainPageApp() {
        super();
    }

    public AgendaPageApp toAgenda(){

        click(By.xpath("//*[@text='日程']"));

        return new AgendaPageApp(driver);
    }

    public WaitToBeDone toWaitToBeDone(){

        click(By.xpath("//*[contains(@text,\"待办\")]"));

        return new WaitToBeDone(driver);
    }

    public WorkBench toWorkBench(){
        click(By.xpath("//*[@text='工作台']"));
        return new WorkBench(driver);
    }

}
