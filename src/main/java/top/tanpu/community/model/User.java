package top.tanpu.community.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author howitt
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2020年12月11日 19:10:00
 */
@Data
public class User implements Serializable {

    private String username;

    private String password;

    private String openId;

    private String nickname;

    private String avatar;

}
