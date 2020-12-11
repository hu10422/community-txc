package top.tanpu.community.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author howitt
 * @version 1.0.0
 * @ClassName UserDto.java
 * @Description TODO
 * @createTime 2020年12月11日 19:05:00
 */
@Data
public class UserDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
