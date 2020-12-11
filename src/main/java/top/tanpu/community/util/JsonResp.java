package top.tanpu.community.util;

import lombok.Data;

/**
 * @author howitt
 * @version 1.0.0
 * @ClassName JsonResp.java
 * @Description TODO
 * @createTime 2020年12月11日 18:51:00
 */
@Data
public class JsonResp {

    private Integer code;

    private String msg;

    private Object data;


    public static JsonResp suc(Integer code, String msg, Object data) {
        JsonResp jsonResp = new JsonResp();
        jsonResp.setCode(code);
        jsonResp.setMsg(msg);
        jsonResp.setData(data);
        return jsonResp;
    }

    public static JsonResp suc(Integer code, String msg) {
        return suc(code, msg, null);
    }

    public static JsonResp suc(String msg) {
        return suc(200, msg);
    }

    public static JsonResp suc(Object data) {
        return suc(200, "成功", data);
    }

    public static JsonResp suc() {
        return suc("成功");
    }

    public static JsonResp err(Integer code, String msg) {
        return suc(code, msg, null);
    }

    public static JsonResp err(String msg) {
        return err(500, msg);
    }

}
