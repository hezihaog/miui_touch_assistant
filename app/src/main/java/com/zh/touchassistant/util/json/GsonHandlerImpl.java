package com.zh.touchassistant.util.json;

import com.google.gson.Gson;

/**
 * <b>Package:</b> com.zh.touchassistant.util.json <br>
 * <b>FileName:</b> GsonHandlerImpl <br>
 * <b>Create Date:</b> 2018/12/21  下午10:18 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class GsonHandlerImpl implements JsonHandler {
    private final Gson mGson;

    public GsonHandlerImpl() {
        this.mGson = new Gson();
    }

    @Override
    public <Result> Result parse(String json, Class<Result> clazz) {
        return mGson.fromJson(json, clazz);
    }

    @Override
    public String toJson(Object model) {
        return mGson.toJson(model);
    }
}