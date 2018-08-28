package com.vdunpay.utils;

import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by HY on 2018/8/14.
 */

public class SharedPreferencesUtils {
    private static SharedPreferences sharedPreferences = null;
    private static SharedPreferencesUtils SharedPreferencesUtils = null;
    /*
     * 保存手机里面的名字
     */
    private static SharedPreferences.Editor editor;

    public static SharedPreferencesUtils getInstance(Context context, String FILE_NAME) {
        if (SharedPreferencesUtils == null) {
            SharedPreferencesUtils = new SharedPreferencesUtils();
        }

        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(FILE_NAME,
                    Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
        }
        return SharedPreferencesUtils;
    }

    /**
     * 存储
     */
    public void put(String key, Object object) {
        if (object instanceof String) {
            editor.putString(key, (String) object);
        } else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        } else {
            editor.putString(key, object.toString());
        }
        editor.commit();
    }

    /**
     * 获取保存的数据
     */
    public Object getSharedPreference(String key, Object defaultObject) {
        if (defaultObject instanceof String) {
            return sharedPreferences.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return sharedPreferences.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sharedPreferences.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return sharedPreferences.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sharedPreferences.getLong(key, (Long) defaultObject);
        } else {
            return sharedPreferences.getString(key, null);
        }
    }

    /**
     * 移除某个key值已经对应的值
     */
    public void remove(String key) {
        editor.remove(key);
        editor.commit();
    }

    /**
     * 清除所有数据
     */
    public static void clear() {
        editor.clear();
        editor.commit();
    }

    /**
     * 查询某个key是否存在
     */
    public static Boolean contain(String key) {
        return sharedPreferences.contains(key);
    }

    /**
     * 返回所有的键值对
     */
    public static Map<String, ?> getAll() {
        return sharedPreferences.getAll();
    }
}
