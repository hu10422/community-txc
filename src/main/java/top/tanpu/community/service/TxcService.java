package top.tanpu.community.service;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tanpu.community.config.TxcConfig;

import java.util.List;

@Service
public class TxcService {

    @Autowired
    private TxcConfig txcConfig;


    public List getFeedback() {
        String url = StrUtil.format("https://txc.qq.com/api/v1/{}/posts", txcConfig.getProductId());
        String Timestamp = Convert.toStr(DateUtil.currentSeconds());
        String Signature = SecureUtil.md5(StrUtil.concat(true, Timestamp, txcConfig.getPrivateKey()));
        System.out.println(url);
        System.out.println(Timestamp);
        System.out.println(Signature);

        String posts = HttpRequest.post(url)
                .header("Timestamp", Timestamp)
                .header("Signature", Signature)
                .execute().body();

        System.out.println(posts);

        return null;
    }

    public static void main(String[] args) {
        TxcService txcService = new TxcService();
        txcService.getFeedback();
    }

}
