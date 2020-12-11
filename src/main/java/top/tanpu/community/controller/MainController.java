package top.tanpu.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author howitt
 * @version 1.0.0
 * @ClassName MainController.java
 * @Description TODO
 * @createTime 2020年12月11日 17:10:00
 */
@Controller
public class MainController {

    @GetMapping("index")
    public String index() {
        return "index.html";
    }
}
