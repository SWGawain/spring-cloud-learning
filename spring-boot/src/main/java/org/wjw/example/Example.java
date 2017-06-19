package org.wjw.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by SWGawain on 2017/4/25.
 */
@RestController
@ConfigurationProperties(prefix = "mail")
public class Example {

    @Value("${address}")
    private String address ;

    @Value("#{ '${addressList}'.split(',')}")
    private List<String> addressList;

    private String to;
    private String add;
    private String pass;

    @RequestMapping("/")
    public String home(){
        return "hello world";
    }

    @RequestMapping("/ad")
    public String getAddress(){
        return address;
    }

    @RequestMapping("/adl")
    public String getAddressList(){

        StringBuilder list = new StringBuilder();

        addressList.stream().forEach(list::append);

        return list.toString();
    }

    @RequestMapping("/getmail")
    public String getmail(){
        return "{" +
                "to='" + to + '\'' +
                        ", add='" + add + '\'' +
                        ", pass='" + pass + '\'' +
                        '}';
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
