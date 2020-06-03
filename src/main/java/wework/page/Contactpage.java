package wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.time.Duration;

public class Contactpage extends BasePage{

    public Contactpage(RemoteWebDriver driver){
        super(driver);
    }


    public Contactpage addMemeber(String username, String acctid, String mobile){
        //todo:
//        driver = MainPage.driver;

        By addmember = By.linkText("添加成员");
        //todo: 就算可点击，仍然有一定概率是点击不成功的。
        new WebDriverWait(driver, Duration.ofSeconds(10).toMillis()).until(
                ExpectedConditions.elementToBeClickable(addmember));


        driver.findElement(addmember).click();
//        driver.findElement(By.)
        return this;
    }


    public Contactpage search(String name){

        driver.findElement(By.id("memberSearchInput")).sendKeys(name);
        return this;
    }

    public Contactpage delete(){
        return this;
    }


    public Contactpage importFromFile(URL path){
        //todo:
        System.out.println(path.getPath());

        String path_utf="";
        try {
            path_utf= URLDecoder.decode(path.getFile(), "UTF-8");
            System.out.println(path_utf);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        click(By.cssSelector(".ww_operationBar:nth-child(1) .ww_btn_PartDropdown_left"));
        click(By.linkText("文件导入"));
//        click(By.name("file"));
//        sendKeys(By.name("file"), "C:\\fakepath\\通讯录批量导入模板.xlsx");
        upload(By.name("file"), path_utf);
//        driver.findElement(By.name("file")).sendKeys("/Users/seveniruby/projects/Java3/src/main/resources/通讯录批量导入模板.xlsx");
//        sendKeys(By.name("file"), "C:\\fakepath\\通讯录批量导入模板.xlsx");
        click(By.linkText("导入"));
        click(By.linkText("完成"));

        return this;
    }


    public Contactpage addDepartment(String departmentName, String department){
        //点击+
        click(By.xpath("//i[@class='member_colLeft_top_addBtn']"));
        click(By.className("js_create_party"));  //创建部门

        sendKeys(By.xpath("//input[@name='name']"), departmentName);
        click(By.xpath("//a[@class='qui_btn ww_btn ww_btn_Dropdown js_toggle_party_list']"));
        click(By.xpath(
                String.format("//div[contains(@class,'jstree jstree-2 jstree-default')]//li[a='%s']/a",department)
        ));

        click(By.linkText("确定"));

        return this;
    }

    public String getCurrentDepartmentName(){
        return getElementText(By.id("party_name"));
    }

    public void deleteDepartment(String departmentName) {
        click(By.xpath(String.format("//li[a='%s']/a/span",departmentName)));
        click(By.linkText("删除"));
        click(By.linkText("确定"));
    }


    public void addTag(String tagName) {
        click(By.linkText("标签"));
        click(By.xpath("//i[@class='member_colLeft_top_addBtn']"));
        sendKeys(By.xpath("//input[@name='name']"), tagName);
        click(By.linkText("确定"));
    }

    public void deleteTag(String tagName){
        click(By.xpath(String.format("//li[contains(text(),'%s')]", tagName)));
        click(By.xpath("//a[contains(@class,'member_tag_list_moreBtn')]"));
        click(By.linkText("删除"));
        click(By.linkText("确定"));

    }
}
