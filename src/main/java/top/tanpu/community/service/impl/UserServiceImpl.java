package top.tanpu.community.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import top.tanpu.community.dto.UserDto;
import top.tanpu.community.model.User;
import top.tanpu.community.service.UserService;
import top.tanpu.community.util.CacheManager;
import top.tanpu.community.util.ImageListUtil;

/**
 * @author howitt
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @Description TODO
 * @createTime 2020年12月11日 19:08:00
 */
public class UserServiceImpl implements UserService {
    private static final Log log = LogFactory.get();

    @Override
    public User login(UserDto userDto) {
        log.info("用户登录: username={}, password={}", userDto.getUsername(), userDto.getPassword());

        String userJson = CacheManager.getTimedCache().get(userDto.getUsername());
        User user;
        if (StrUtil.isBlank(userJson)) {
            user = new User();
            user.setUsername(userDto.getUsername());
            user.setPassword(userDto.getPassword());
            user.setNickname("TXC" + RandomUtil.randomInt(1001, 9999));
            user.setOpenid("TXCB" + System.currentTimeMillis() + RandomUtil.randomInt(11, 99));
            user.setAvatar(ImageListUtil.getImgUrl());
            CacheManager.getTimedCache().put(userDto.getUsername(), JSONUtil.toJsonStr(user), CacheManager.defaultTimeOutHour * 2);
        } else {
            user = JSONUtil.toBean(JSONUtil.parseObj(userJson), User.class);
        }


        return null;
    }
}
