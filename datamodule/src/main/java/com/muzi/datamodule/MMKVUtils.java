package com.muzi.datamodule;


import android.content.Context;

import com.tencent.mmkv.MMKV;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 作者: lipeng
 * 时间: 2019/1/30
 * 邮箱: lipeng@moyi365.com
 * 功能: MMKV数据存储
 * github：https://github.com/Tencent/MMKV/wiki/android_tutorial_cn
 */
class MMKVUtils {

    public static void init(Context context) {
        MMKV.initialize(context);
    }

    private static MMKV getMMKV() {
        return MMKV.defaultMMKV();
    }

    /**
     * @param key
     * @param value
     * @return
     */
    public static void set(String key, String value) {
        set(key, value, 0, null);
    }

    /**
     * @param key
     * @param value
     * @param life
     * @param unit
     * @return
     */
    public static void set(String key, String value, long life, TimeUnit unit) {
        MMKV mmkv = getMMKV();
        setLife(mmkv, key, life, unit);
        mmkv.encode(key, value);
    }

    /**
     * @param key
     * @param value
     * @return
     */
    public static void set(String key, int value) {
        set(key, value, 0, null);
    }

    /**
     * @param key
     * @param value
     * @param life
     * @param unit
     * @return
     */
    public static void set(String key, int value, long life, TimeUnit unit) {
        MMKV mmkv = getMMKV();
        setLife(mmkv, key, life, unit);
        mmkv.encode(key, value);
    }

    /**
     * @param key
     * @param value
     * @return
     */
    public static void set(String key, boolean value) {
        set(key, value, 0, null);
    }

    /**
     * @param key
     * @param value
     * @param life
     * @param unit
     * @return
     */
    public static void set(String key, boolean value, long life, TimeUnit unit) {
        MMKV mmkv = getMMKV();
        setLife(mmkv, key, life, unit);
        mmkv.encode(key, value);
    }

    /**
     * @param key
     * @param value
     * @return
     */
    public static void set(String key, float value) {
        set(key, value, 0, null);
    }

    /**
     * @param key
     * @param value
     * @param life
     * @param unit
     * @return
     */
    public static void set(String key, float value, long life, TimeUnit unit) {
        MMKV mmkv = getMMKV();
        setLife(mmkv, key, life, unit);
        mmkv.encode(key, value);
    }

    /**
     * @param key
     * @param value
     * @return
     */
    public static void set(String key, long value) {
        set(key, value, 0, null);
    }

    /**
     * @param key
     * @param value
     * @param life
     * @param unit
     * @return
     */
    public static void set(String key, long value, long life, TimeUnit unit) {
        MMKV mmkv = getMMKV();
        setLife(mmkv, key, life, unit);
        mmkv.encode(key, value);
    }

    /**
     * @param key
     * @param value
     */
    public static void set(String key, Set<String> value) {
        set(key, value, 0, null);
    }

    public static void set(String key, Set<String> value, long life, TimeUnit unit) {
        MMKV mmkv = getMMKV();
        setLife(mmkv, key, life, unit);
        mmkv.encode(key, value);
    }

    /**
     * @param key
     * @return
     */
    public static String getString(String key) {
        return getString(key, null);
    }

    /**
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getString(String key, String defaultValue) {
        MMKV mmkv = getMMKV();
        if (isAvailable(mmkv, key)) {
            return mmkv.decodeString(key, defaultValue);
        }
        return defaultValue;
    }

    /**
     * @param key
     * @return
     */
    public static boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    /**
     * @param key
     * @param defaultValue
     * @return
     */
    public static boolean getBoolean(String key, boolean defaultValue) {
        MMKV mmkv = getMMKV();
        if (isAvailable(mmkv, key)) {
            return mmkv.decodeBool(key, defaultValue);
        }
        return defaultValue;
    }

    /**
     * @param key
     * @return
     */
    public static float getFloat(String key) {
        return getFloat(key, 0);
    }

    /**
     * @param key
     * @param defaultValue
     * @return
     */
    public static float getFloat(String key, float defaultValue) {
        MMKV mmkv = getMMKV();
        if (isAvailable(mmkv, key)) {
            return mmkv.decodeFloat(key, defaultValue);
        }
        return defaultValue;
    }

    /**
     * @param key
     * @return
     */
    public static int getInt(String key) {
        return getInt(key, 0);
    }

    /**
     * @param key
     * @param defaultValue
     * @return
     */
    public static int getInt(String key, int defaultValue) {
        MMKV mmkv = getMMKV();
        if (isAvailable(mmkv, key)) {
            return mmkv.decodeInt(key, defaultValue);
        }
        return defaultValue;
    }

    /**
     * @param key
     * @return
     */
    public static long getLong(String key) {
        return getLong(key, 0);
    }

    /**
     * @param key
     * @param defaultValue
     * @return
     */
    public static long getLong(String key, long defaultValue) {
        MMKV mmkv = getMMKV();
        if (isAvailable(mmkv, key)) {
            return mmkv.decodeLong(key, defaultValue);
        }
        return defaultValue;
    }

    public static Set<String> getStringSet(String key) {
        return getStringSet(key, null);
    }

    public static Set<String> getStringSet(String key, Set<String> defaultValue) {
        MMKV mmkv = getMMKV();
        if (isAvailable(mmkv, key)) {
            return mmkv.decodeStringSet(key, defaultValue);
        }
        return defaultValue;
    }

    /**
     * 是否包含key
     *
     * @param key
     * @return
     */
    public static boolean contains(String key) {
        return getMMKV().contains(key);
    }

    /**
     * 删除数据
     *
     * @param keys
     */
    public static void remove(String... keys) {
        for (String key : keys) {
            if (contains(key)) {
                getMMKV().remove(key);
            }
        }
    }

    /**
     * 清空数据
     */
    public static void clear() {
        getMMKV().clearAll();
    }

    /**
     * 设置缓存时间
     *
     * @param mmkv
     * @param key
     * @param life
     * @param unit
     */
    private static void setLife(MMKV mmkv, String key, long life, TimeUnit unit) {
        if (life <= 0 || unit == null) {
            return;
        }
        String lifeKey = key + "_life";
        long createValue = System.currentTimeMillis();
        long old = unit.toMillis(life);
        long lifeValue = createValue + old;
        mmkv.encode(lifeKey, lifeValue);
    }

    /**
     * 判断是否可用
     *
     * @param mmkv
     * @param key
     * @return
     */
    private static boolean isAvailable(MMKV mmkv, String key) {
        String lifeKey = key + "_life";
        if (!mmkv.containsKey(lifeKey)) {
            return true;
        }
        long lifeValue = mmkv.decodeLong(lifeKey, 0);
        if (lifeValue >= System.currentTimeMillis()) {
            return true;
        } else {
            mmkv.removeValuesForKeys(new String[]{key, lifeKey});
            return false;
        }
    }

}
