package top.tanpu.community.controller;

import cn.hutool.core.util.RandomUtil;
import org.springframework.web.bind.annotation.*;
import top.tanpu.community.dto.UserDto;
import top.tanpu.community.model.User;
import top.tanpu.community.util.ImageListUtil;
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

    @GetMapping("/getRabbitInfo")
    public JsonResp getRabbitInfo() {
        User user = new User();
        user.setAvatar(ImageListUtil.getImgUrl());
        user.setNickname("TXC" + RandomUtil.randomInt(1001, 9999));
        user.setOpenid(user.getNickname());

        return JsonResp.suc(user);
    }
}
