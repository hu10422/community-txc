package top.tanpu.community.util;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;

/**
 * @author howitt
 * @version 1.0.0
 * @ClassName ImageListUtil.java
 * @Description TODO 头像列表
 * @createTime 2020年12月11日 18:39:00
 */
public class ImageListUtil {
    /**
     * github Pages 头像地址
     */
    private static String imgUrl = "https://hu10422.github.io/image2/pic/{}.jpg";

    /**
     * 随机获取一个头像地址
     *
     * @return
     */
    public static String getImgUrl() {
        int i = RandomUtil.randomInt(1, 9);
        return StrUtil.format(imgUrl, i);
    }
}
