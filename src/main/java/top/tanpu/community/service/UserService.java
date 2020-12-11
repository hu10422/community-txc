package top.tanpu.community.service;

import top.tanpu.community.dto.UserDto;
import top.tanpu.community.model.User;

/**
 * @author howitt
 * @version 1.0.0
 * @ClassName UserService.java
 * @Description TODO
 * @createTime 2020年12月11日 19:08:00
 */
public interface UserService {

    User login(UserDto userDto);
}
