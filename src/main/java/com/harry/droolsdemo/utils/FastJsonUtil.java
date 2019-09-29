package com.harry.droolsdemo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.alibaba.fastjson.util.TypeUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class FastJsonUtil {
    private static final SerializeConfig config= new SerializeConfig();

    static {
        //解决fastjson输出bean属性名首字母默认小写的问题
        TypeUtils.compatibleWithJavaBean = true;
        String dateFormat = "yyyy-MM-dd";
        JSON.DEFFAULT_DATE_FORMAT =dateFormat;
        config.put(Date.class, new SimpleDateFormatSerializer(dateFormat));
        //config.put(java.util.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
        //config.put(java.sql.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
    }

    private static final SerializerFeature[] features = {
            SerializerFeature.WriteDateUseDateFormat,//全局修改日期格式,默认为false
            //SerializerFeature.WriteMapNullValue, // 是否输出值为null的字段,默认为false
            SerializerFeature.SkipTransientField,//不忽略transient字段
            SerializerFeature.WriteNullListAsEmpty, // list字段如果为null，输出为[]，而不是null
            SerializerFeature.WriteNullNumberAsZero, // 数值字段如果为null，输出为0，而不是null
            SerializerFeature.WriteNullBooleanAsFalse, // Boolean字段如果为null，输出为false，而不是null
            SerializerFeature.WriteNullStringAsEmpty // 字符类型字段如果为null，输出为""，而不是null
    };


    public static String toJSONString(Object object) {
        return JSON.toJSONString(object, config, features);
    }

    public static String toJSONString(Object object, SerializerFeature... features) {
        return JSON.toJSONString(object, config, features);
    }
    public static String toJSONString(Object object,SerializeConfig config, SerializerFeature... features) {
        return JSON.toJSONString(object, config, features);
    }

    public static String toJSONNoFeatures(Object object) {
        return JSON.toJSONString(object, config);
    }

    /**
     * json 字符串转map
     *
     * @param json
     * @return
     */
    public static Map toMap(String json) {
        return JSON.parseObject(json);
    }

    public static Object toBean(String text) {
        return JSON.parse(text);
    }

    public static <T> T toBean(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz);
    }

    // 转换为数组
    public static <T> Object[] toArray(String text) {
        return toArray(text, null);
    }

    // 转换为数组
    public static <T> Object[] toArray(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz).toArray();
    }

    // 转换为List
    public static <T> List<T> toList(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz);
    }

    /**
     * json字符串转化为map
     * @param s
     * @return
     */
    public static Map stringToMap(String s) {
        Map m = JSONObject.parseObject(s);
        return m;
    }

    /**
     * 将map转化为string
     * @param m
     * @return
     */
    /*public static IlasUsers mapToString(Map m) {
        IlasUsers s = JSONObject.toJSONString(m);
        return s;
    }*/
    //**************************************************************************
    /**
     * Json转化时保持原状，不把首字母变成小写 <br><pre>
     * 设置为true<br>
     */
    //**************************************************************************
    public static void initCompatibleWithJavaBean() {
        //Json转化时保持原状，不把首字母变成小写
        TypeUtils.compatibleWithJavaBean = true;
    }
}
