package com.zh.touchassistant.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.util.ArrayMap;

import com.zh.touchassistant.ContextProvider;

import java.util.Map;

/**
 * Created by Hezihao on 2017/7/13.
 * SharedPreference工具类
 */

public class Property {
    private static final String DEFAULT_FILE_NAME = "app.config";

    private Context applicationContext;
    private String fileName;
    private static volatile Property defaultInstance;
    private static final PropertyBuilder DEFAULT_BUILDER = new PropertyBuilder();

    private Property() {
        this(DEFAULT_BUILDER);
    }

    private Property(PropertyBuilder builder) {
        this.fileName = builder.fileName;
        this.applicationContext = ContextProvider.get().getContext().getApplicationContext();
    }

    public static class PropertyBuilder {
        protected String fileName;

        public PropertyBuilder() {
            fileName = DEFAULT_FILE_NAME;
        }

        public PropertyBuilder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public Property build() {
            return new Property(this);
        }

        public Property installDefaultProperty() {
            if (Property.defaultInstance != null) {
                throw new RuntimeException("Property已经有一个默认实例，如想设置默认实例，请在第一次getDefault()之前调用");
            }
            Property property = build();
            Property.defaultInstance = property;
            return property;
        }
    }

    public static Property getDefault() {
        Property instance = defaultInstance;
        if (instance == null) {
            synchronized (Property.class) {
                instance = Property.defaultInstance;
                if (instance == null) {
                    instance = Property.defaultInstance = new Property();
                }
            }
        }
        return instance;
    }

    private void apply(SharedPreferences.Editor editor) {
        editor.apply();
    }

    private Context context() {
        return applicationContext;
    }

    public SharedPreferences getPreferences() {
        return context().getSharedPreferences(defaultInstance.fileName, Context.MODE_MULTI_PROCESS);
    }

    public void setProperty(String key, int value) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putInt(key, value);
        apply(editor);
    }

    public void setProperty(String key, boolean value) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putBoolean(key, value);
        apply(editor);
    }

    public void setProperty(String key, String value) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putString(key, value);
        apply(editor);
    }

    public void setProperty(String key, long value) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putLong(key, value);
        apply(editor);
    }

    public void setProperty(String key, float value) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putFloat(key, value);
        apply(editor);
    }

    public void setProperty(ArrayMap<String, Object> map) {
        SharedPreferences.Editor editor = getPreferences().edit();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                editor.putString(key, (String) value);
            } else if (value instanceof Boolean) {
                editor.putBoolean(key, ((Boolean) value).booleanValue());
            } else if (value instanceof Float) {
                editor.putFloat(key, ((Float) value).floatValue());
            } else if (value instanceof Integer) {
                editor.putInt(key, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                editor.putLong(key, ((Long) value).longValue());
            }
        }
        apply(editor);
    }

    public void removeProperty(String key) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.remove(key);
        apply(editor);
    }

    public boolean getProperty(String key, boolean defValue) {
        return getPreferences().getBoolean(key, defValue);
    }

    public String getProperty(String key, String defValue) {
        return getPreferences().getString(key, defValue);
    }

    public int getProperty(String key, int defValue) {
        return getPreferences().getInt(key, defValue);
    }

    public long getProperty(String key, long defValue) {
        return getPreferences().getLong(key, defValue);
    }

    public float getProperty(String key, float defValue) {
        return getPreferences().getFloat(key, defValue);
    }
}