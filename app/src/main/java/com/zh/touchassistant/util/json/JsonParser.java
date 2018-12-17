package com.zh.touchassistant.util.json;

/**
 * Package: com.hzh.nice.http.inter
 * FileName: Parser
 * Date: on 2017/11/30  上午9:59
 * Auther: zihe
 * Descirbe: 抽象解析器接口
 * Email: hezihao@linghit.com
 */

public interface JsonParser {
    /**
     * 抽象解析方法，开放解析者给使用者，使用者需要一个实现类实现该接口，重写解析方法
     *
     * @param json  json字符串
     * @param clazz 要转换的类的Class
     * @return 解析转换出来的bean
     */
    <Result> Result parse(String json, Class<Result> clazz);
}