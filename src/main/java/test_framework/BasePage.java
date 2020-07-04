package test_framework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//自动化领域建模
public class BasePage {
    List<PageObjectModel> pages = new ArrayList<>();
    private List<PageObjectModel> pages1;


    public void sendkeys(HashMap<String, Object> map) {
        System.out.println("sendkeys");
        System.out.println(map);

    }

    public void find() {

    }

    public void getText() {


    }

    //
    public void run(UIAuto uiAuto) {
        uiAuto.steps.stream().forEach(m -> {
//            if(m.keySet().contains("click")){
//                click((HashMap<String, Object>)m.get("click"));
//            }
            if (m.containsKey("click")) {
                HashMap<String, Object> by = (HashMap<String, Object>) m.get("click");
                click(by);
            }

            if (m.containsKey("sendkeys")) {
                sendkeys(m);
            }

            if(m.containsKey("getattribute")){
                getattribute(m);
            }

            if (m.containsKey("action")) {
                action(m);
            }

//            if (m.containsKey("P")) {
//                action(m);
//            }



        });

    }

    public String  getattribute(HashMap<String, Object> map) {
        System.out.println("get attribute");
        System.out.println(map);
        return null;
    }

    public void action(HashMap<String, Object> map) {
        System.out.println("action");
        System.out.println(map);

        if(map.containsKey("page")){
            String pageName = map.get("page").toString();
            String action = map.get("action").toString().toLowerCase();

            pages.stream().filter(pom -> pom.name.equals(pageName)).findFirst().get()
                    .methods.get(action).forEach(step ->{
                action(step);
            });
        } else{
            if (map.containsKey("click")) {
                HashMap<String, Object> by = (HashMap<String, Object>) map.get("click");
                click(by);
            }

            if (map.containsKey("sendkeys")) {
                sendkeys(map);
            }

            if(map.containsKey("getattribute")){
                getattribute(map);
            }
        }

    }

    public void click(HashMap<String, Object> data) {
        System.out.println("click");
        System.out.println(data);
    }

    public UIAuto load(String path) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//        TypeReference typeReference = new TypeReference(<List<>>)(){
//
//        };
        UIAuto uiauto = null;

        try {
            uiauto = mapper.readValue(
                    BasePage.class.getResourceAsStream(path), UIAuto.class
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uiauto;
    }

    public PageObjectModel loadPage(String path) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//        TypeReference typeReference = new TypeReference(<List<>>)(){
//
//        };
        PageObjectModel pom = null;

        try {
//            pom = mapper.readValue(
//                    BasePage.class.getResourceAsStream(path), PageObjectModel.class
//            );

            pom = mapper.readValue(
                    new File(path), PageObjectModel.class
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pom;
    }

    public void loadPages(String dir){
        Arrays.stream(new File(dir).list(new FilenameFilter() {
            @Override
            public boolean accept(File file, String name) {
                return name.contains("_page");
            }
        })).forEach(path -> {
            path = dir+ "/" + path;
            System.out.println(path);
            pages.add(loadPage(path));
        });
    }


}
