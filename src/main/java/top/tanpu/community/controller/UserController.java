package top.tanpu.community.controller;

import org.springframework.web.bind.annotation.*;
import top.tanpu.community.dto.UserDto;
import top.tanpu.community.util.JsonResp;

import javax.validation.Valid;

/**
 * @author howitt
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description TODO 用户
 * @createTime 2020年12月11日 18:48:00
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @PostMapping("/login")
    public JsonResp login(@Valid @RequestBody UserDto user) {

        return JsonResp.suc();
    }
}
