package com.muzi.module.data;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 作者: lipeng
 * 时间: 2018/12/28
 * 邮箱: lipeng@moyi365.com
 * 功能: 带有生命周期的SharedPreferences
 */
class SPLifeUtils {

    private static final String SP_DATA_NAME = "sp_data";

    private static SharedPreferences getPreferences() {
        return null;
    }

    private static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(SP_DATA_NAME, Context.MODE_PRIVATE);
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
        SharedPreferences.Editor edit = getPreferences().edit();
        setLife(edit, key, life, unit);
        edit.putString(key, value);
        edit.apply();
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
        SharedPreferences.Editor edit = getPreferences().edit();
        setLife(edit, key, life, unit);
        edit.putInt(key, value);
        edit.apply();
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
        SharedPreferences.Editor edit = getPreferences().edit();
        setLife(edit, key, life, unit);
        edit.putBoolean(key, value);
        edit.apply();
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
        SharedPreferences.Editor edit = getPreferences().edit();
        setLife(edit, key, life, unit);
        edit.putFloat(key, value);
        edit.apply();
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
        SharedPreferences.Editor edit = getPreferences().edit();
        setLife(edit, key, life, unit);
        edit.putLong(key, value);
        edit.apply();
    }

    /**
     * @param key
     * @param value
     */
    public static void set(String key, Set<String> value) {
        set(key, value, 0, null);
    }

    public static void set(String key, Set<String> value, long life, TimeUnit unit) {
        SharedPreferences.Editor edit = getPreferences().edit();
        setLife(edit, key, life, unit);
        edit.putStringSet(key, value);
        edit.apply();
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
        SharedPreferences preferences = getPreferences();
        if (isAvailable(preferences, key)) {
            return preferences.getString(key, defaultValue);
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
        SharedPreferences preferences = getPreferences();
        if (isAvailable(preferences, key)) {
            return preferences.getBoolean(key, defaultValue);
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
        SharedPreferences preferences = getPreferences();
        if (isAvailable(preferences, key)) {
            return preferences.getFloat(key, defaultValue);
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
        SharedPreferences preferences = getPreferences();
        if (isAvailable(preferences, key)) {
            return preferences.getInt(key, defaultValue);
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
        SharedPreferences preferences = getPreferences();
        if (isAvailable(preferences, key)) {
            return getPreferences().getLong(key, defaultValue);
        }
        return defaultValue;
    }

    public static Set<String> getStringSet(String key) {
        return getStringSet(key, null);
    }

    public static Set<String> getStringSet(String key, Set<String> defaultValue) {
        SharedPreferences preferences = getPreferences();
        if (isAvailable(preferences, key)) {
            return getPreferences().getStringSet(key, defaultValue);
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
        return getPreferences().contains(key);
    }

    /**
     * 删除数据
     *
     * @param keys
     */
    public static void remove(String... keys) {
        for (String key : keys) {
            if (contains(key)) {
                getPreferences().edit().remove(key).apply();
            }
        }
    }

    /**
     * 清空数据
     */
    public static void clear() {
        getPreferences().edit().clear().apply();
    }

    /**
     * 设置缓存时间
     *
     * @param edit
     * @param key
     * @param life
     * @param unit
     */
    private static void setLife(SharedPreferences.Editor edit, String key, long life, TimeUnit unit) {
        if (life <= 0 || unit == null) {
            return;
        }
        String lifeKey = key + "_life";
        long createValue = System.currentTimeMillis();
        long old = unit.toMillis(life);
        long lifeValue = createValue + old;
        edit.putLong(lifeKey, lifeValue);
    }

    /**
     * 判断是否可用
     *
     * @param preferences
     * @param key
     * @return
     */
    private static boolean isAvailable(SharedPreferences preferences, String key) {
        String lifeKey = key + "_life";
        if (!preferences.contains(lifeKey)) {
            return true;
        }
        long lifeValue = preferences.getLong(lifeKey, 0);
        if (lifeValue >= System.currentTimeMillis()) {
            return true;
        } else {
            SharedPreferences.Editor edit = preferences.edit();
            edit.remove(key).remove(lifeKey).apply();
            return false;
        }
    }

}
