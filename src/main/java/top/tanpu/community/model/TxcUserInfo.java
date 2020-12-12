package top.tanpu.community.model;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import lombok.Data;
import top.tanpu.community.util.ImageListUtil;

import java.util.ArrayList;

/**
 * TxcUserInfo
 * 传递至兔小巢登录参数信息
 *
 * @author Howitt
 * @date 2020/12/12 20:04
 * @since 1.0.0
 */
@Data
public class TxcUserInfo {

    /**
     * 用户唯一标识，由接入方生成
     */
    private String openid;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户头像，一般是图片链接 必须要支持https
     */
    private String avatar;

    /**
     * 图片序号，通过序号生成图片
     * 参考{@like top.tanpu.community.util.ImageListUtil}
     */
    private Integer imgKey;

    /**
     * 随机生成一组登录信息
     *
     * @return 兔小巢登录信息
     */
    public static TxcUserInfo randomInfo() {
        TxcUserInfo info = new TxcUserInfo();
        info.setOpenid("TXCID" + RandomUtil.randomString(9));
        info.setNickname("TXC" + RandomUtil.randomString(5));
        info.setImgKey(ImageListUtil.getImgKey());
        info.setAvatar(ImageListUtil.getImgUrl(info.getImgKey()));

        return info;
    }

    /**
     * 将登录信息转换为cookie 保存的字符
     *
     * @param txcUserInfo
     * @return
     */
    public static String toCookieInfoStr(TxcUserInfo txcUserInfo) {
        if (ObjectUtil.isNull(txcUserInfo)) {
            txcUserInfo = randomInfo();
        }

        ArrayList<String> info = CollUtil.newArrayList(txcUserInfo.getOpenid(), txcUserInfo.getNickname(), Convert.toStr(txcUserInfo.getImgKey()));
        return CollUtil.join(info, "-");
    }

    /**
     * 将字符转换为 登录信息
     *
     * @param cookieInfo
     * @return
     */
    public static TxcUserInfo toTxcUserInfo(String cookieInfo) {
        if (StrUtil.isBlank(cookieInfo)) {
            return randomInfo();
        }

        try {
            String[] split = StrUtil.split(cookieInfo, "-");
            TxcUserInfo info = new TxcUserInfo();
            info.setOpenid(split[0]);
            info.setNickname(split[1]);
            info.setImgKey(Convert.toInt(split[2]));
            info.setAvatar(ImageListUtil.getImgUrl(info.getImgKey()));
            return info;
        } catch (Exception e) {
            return randomInfo();
        }
    }
}
