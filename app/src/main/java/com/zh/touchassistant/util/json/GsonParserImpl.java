package com.zh.touchassistant.util.json;

import com.zh.touchassistant.util.GsonUtils;

/**
 * <b>Package:</b> com.zh.touchassistant.util.json <br>
 * <b>FileName:</b> GsonParserImpl <br>
 * <b>Create Date:</b> 2018/12/17  下午12:19 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class GsonParserImpl implements JsonParser {

    @Override
    public <Result> Result parse(String json, Class<Result> clazz) {
        return GsonUtils.fromJson(json, clazz);
    }
}