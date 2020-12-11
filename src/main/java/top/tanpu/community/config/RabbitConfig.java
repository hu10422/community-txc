package top.tanpu.community.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author howitt
 * @version 1.0.0
 * @ClassName RabbitConfig.java
 * @Description TODO "兔小巢"配置
 * @createTime 2020年12月11日 17:56:00
 */
@Data
@Component
@ConfigurationProperties(prefix = "rabbit")
//@PropertySource(value = "config.properties")
public class RabbitConfig {

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品ID
     */
    private String productId;

    /**
     * 产品密钥
     */
    private String privateKey;
}
