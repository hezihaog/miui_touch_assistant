package com.zh.touchassistant.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;

/**
 * <b>Project:</b> almanac<br>
 * <b>Create Date:</b> 15/7/27<br>
 * <b>Author:</b> Gordon<br>
 * <b>Description:</b>
 * Utils for Google GSON.
 * <br>
 */
public class GsonUtils {
    private static final Gson gson;

    static {
        gson = new GsonBuilder()
                .registerTypeAdapter(Integer.class, new JsonDeserializer<Integer>() {

                    @Override
                    public Integer deserialize(JsonElement json, Type type,
                                               JsonDeserializationContext arg2) throws JsonParseException {
                        try {
                            return json.getAsInt();
                        } catch (Exception e) {
                            return -1;
                        }
                    }
                })
                .registerTypeAdapter(Long.class, new JsonDeserializer<Long>() {

                    @Override
                    public Long deserialize(JsonElement json, Type type,
                                            JsonDeserializationContext arg2) throws JsonParseException {
                        try {
                            return json.getAsLong();
                        } catch (Exception e) {
                            return (long) -1;
                        }
                    }
                })
                .registerTypeAdapter(Float.class, new JsonDeserializer<Float>() {

                    @Override
                    public Float deserialize(JsonElement json, Type type,
                                             JsonDeserializationContext arg2) throws JsonParseException {
                        try {
                            return json.getAsFloat();
                        } catch (Exception e) {
                            return (float) -1;
                        }
                    }
                })
                .registerTypeAdapter(Double.class, new JsonDeserializer<Double>() {

                    @Override
                    public Double deserialize(JsonElement json, Type type,
                                              JsonDeserializationContext arg2) throws JsonParseException {
                        try {
                            return json.getAsDouble();
                        } catch (Exception e) {
                            return (double) -1;
                        }
                    }
                })
                .serializeNulls()
                .setPrettyPrinting()
                .create();
    }

    private GsonUtils() {
        // hide
    }

    /**
     * @return 返回Gson
     */
    public static Gson getGson() {
        return gson;
    }

    /**
     * JsonObject string to Json bean.
     *
     * @param json  json string
     * @param clazz json bean
     * @param <T>   json bean class
     * @return json bean or null.
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return gson.fromJson(json, clazz);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * JsonObject string to Json bean.
     */
    public static <T> T fromJson(String json, Type type) {
        try {
            return gson.fromJson(json, type);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Json bean to json string.
     */
    public static String toJson(Object json) {
        return gson.toJson(json);
    }
}
