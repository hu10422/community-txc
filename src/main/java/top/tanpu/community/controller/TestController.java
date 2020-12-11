package top.tanpu.community.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author howitt
 * @version 1.0.0
 * @ClassName TestController.java
 * @Description TODO
 * @createTime 2020年12月11日 16:36:00
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/index")
    public Object index(){
        return "hallo world!";
    }
}
