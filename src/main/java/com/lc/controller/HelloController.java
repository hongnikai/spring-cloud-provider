package com.lc.controller;

import com.lc.entity.Book;
import com.lc.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {


    private final Logger logger = Logger.getLogger(getClass());

    @Qualifier("discoveryClient")
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        logger.info("welcome");
        List<ServiceInstance> instances = client.getInstances("spring-cloud-provider");
        for (int i = 0; i < instances.size(); i++) {
            System.out.println("/hello,host:" + instances.get(i).getHost() + ",service_id:" + instances.get(i).getServiceId());
            logger.info("/hello,host:" + instances.get(i).getHost() + ",service_id:" + instances.get(i).getServiceId());
        }
        return "Hello World";
    }

    @RequestMapping(value = "/hello2",method = RequestMethod.POST)
    public String hello2(HttpServletRequest request,
                         //@RequestBody Book book,
                       // @RequestBody MultiValueMap paramMap
                          @RequestBody Map<String,Object> paramMap
                            ){
        //,defaultValue = "is not my name"

        return "Hello World2"+paramMap.toString();
    }

    @RequestMapping(value = "/hello3",method = RequestMethod.GET)
    public User hello3(HttpServletRequest request,@RequestParam("id") int id){

        switch (id){

            case 1:
                return new User(123,"我的名字123");
            case 2:
                return new User(1234,"我的名字1234");
                default:
                return new User(12345,"我的名字12345");
        }

    }

    @RequestMapping("/getbook6")
    public List<Book> book6(String ids) {
        System.out.println("ids>>>>>>>>>>>>>>>>>>>>>" + ids);
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("《李自成》", 55, "姚雪垠", "人民文学出版社"));
        books.add(new Book("中国文学简史", 33, "林庚", "清华大学出版社"));
        books.add(new Book("文学改良刍议", 33, "胡适", "无"));
        books.add(new Book("ids", 22, "helloworld", "haha"));
        return books;
    }

    @RequestMapping("/getbook6/{id}")
    public Book book61(@PathVariable Integer id) {
        Book book = new Book("《李自成》2", 55, "姚雪垠2", "人民文学出版社2");
        return book;
    }




}
