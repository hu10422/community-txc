package top.tanpu.community.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.tanpu.community.config.TxcConfig;
import top.tanpu.community.model.TxcUserInfo;
import top.tanpu.community.util.JsonResp;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * TxcController
 * 接入"兔小巢"相关功能API
 *
 * @author Howitt
 * @date 2020/12/12 19:39
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/txc")
public class TxcController {
    private static final Log log = LogFactory.get();

    @Autowired
    private TxcConfig txcConfig;

    @GetMapping("/info")
    public JsonResp info() {
        log.info("获取“兔小巢”产品ID");
        TxcConfig config = BeanUtil.copyProperties(txcConfig, TxcConfig.class, "productName", "privateKey");
        return JsonResp.suc(config);
    }

    @GetMapping("/userInfo")
    public JsonResp userInfo(@CookieValue(value = "sessionId", required = false) String sessionId, HttpServletResponse response) {
        log.info("获取访问“兔小巢”页面的登录态信息");
        TxcUserInfo userInfo = TxcUserInfo.toTxcUserInfo(sessionId);//将cookie保存的信息解析出来，无效数据则重新生成

        Cookie cookie = new Cookie("sessionId", TxcUserInfo.toCookieInfoStr(userInfo));
        cookie.setMaxAge(60 * 60 * 24 * 7);//cookie 保存7天
        response.addCookie(cookie);

        return JsonResp.suc(userInfo);
    }


}
