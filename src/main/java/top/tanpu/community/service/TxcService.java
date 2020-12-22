package top.tanpu.community.service;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tanpu.community.config.TxcConfig;

import java.util.List;

@Service
public class TxcService {

    @Autowired
    private TxcConfig txcConfig;


    public List getFeedback() throws Exception {
        String url = StrUtil.format("https://txc.qq.com/api/v1/{}/posts", txcConfig.getProductId());
        String Timestamp = Convert.toStr(DateUtil.currentSeconds());
        String Signature = SecureUtil.md5(StrUtil.concat(true, Timestamp, txcConfig.getPrivateKey()));

        String posts = "";
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Timestamp", Timestamp);
        httpGet.setHeader("Signature", Signature);
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            System.out.println("响应状态为:" + response.getStatusLine().getStatusCode());
            Assert.isTrue(200 == response.getStatusLine().getStatusCode(), "请求用户反馈API失败");
            HttpEntity responseEntity = response.getEntity();
            Assert.notNull(responseEntity, "请求用户反馈API未响应内容");
            posts = EntityUtils.toString(responseEntity);
        } catch (Exception e) {
            throw e;
        }

        JSONObject postsJson = JSONUtil.parseObj(posts);



        return null;
    }

}
