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
     * 随机获取一个图片序号
     *
     * @return
     */
    public static Integer getImgKey() {
        return RandomUtil.randomInt(1, 9);
    }

    /**
     * 通过图片序号获取一个图片地址
     *
     * @param key
     * @return
     */
    public static String getImgUrl(Integer key) {
        return StrUtil.format(imgUrl, key);
    }

    /**
     * 直接随机获取一个头像地址
     *
     * @return
     */
    public static String getImgUrl() {
        return getImgUrl(getImgKey());
    }
}
