package top.tanpu.community.util;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;

/**
 * @author howitt
 * @version 1.0.0
 * @ClassName CacheManager.java
 * @Description TODO 基于hutool的缓存代理
 * @createTime 2020年12月11日 19:32:00
 */
public class CacheManager {

    public static final long defaultTimeOutSeconds = 1000;
    public static final long defaultTimeOutMinutes = defaultTimeOutSeconds * 60;
    public static final long defaultTimeOutHour = defaultTimeOutMinutes * 60;
    public static final long defaultTimeOutDay = defaultTimeOutHour * 24 * 1;

    private static TimedCache<String, String> timedCache;

    public static TimedCache<String, String> getTimedCache() {
        if (timedCache == null) {
            timedCache = CacheUtil.newTimedCache(defaultTimeOutDay);
        }
        return timedCache;
    }


}
