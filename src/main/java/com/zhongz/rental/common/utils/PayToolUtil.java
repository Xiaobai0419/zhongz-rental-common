package com.zhongz.rental.common.utils;


import java.text.SimpleDateFormat;
import java.util.*;

/**
 *@describe: 微信验证签名工具类
 *
 *@author zhaoyizhe
 *@date 2019/2/1
 */
public class PayToolUtil {

    /**
     * 是否签名正确,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。
     * @return boolean
     */
    public static boolean isTenpaySign(String characterEncoding, SortedMap<Object, Object> packageParams, String apiKey) {
        StringBuffer sb = new StringBuffer();
        Set es = packageParams.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            String v = (String)entry.getValue();
            if(!"sign".equals(k) && null != v && !"".equals(v)) {
                sb.append(k + "=" + v + "&");
            }
        }

        sb.append("key=" + apiKey);

        //算出摘要
        String mysign = Md5Utils.md5Encode(sb.toString(), characterEncoding).toLowerCase();
        String tenpaySign = ((String)packageParams.get("sign")).toLowerCase();

        return tenpaySign.equals(mysign);
    }

    /**
     * @author
     * @date 2016-4-22
     * @Description：sign签名
     * @param characterEncoding
     *            编码格式
     * @param
     *
     * @return
     */
    public static String createSign(SortedMap<String,String> parameters,String characterEncoding,String apiKey) {
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + apiKey);
        String sign = Md5Utils.md5Encode(sb.toString(), characterEncoding).toUpperCase();
        return sign;
    }


//    /** 
//          * 微信支付签名算法sign 
//          * @param characterEncoding 
//          * @param parameters 
//          * @return 
//          */
//    @SuppressWarnings("unchecked")
//    public static String createSign(String characterEncoding,SortedMap<Object,Object> parameters){
//        StringBuffer sb = new StringBuffer();
//        Set es =parameters.entrySet();//所有参与传参的参数按照accsii排序（升序）  
//        Iterator it =es.iterator();
//        while(it.hasNext()){
//            Map.Entry entry=(Map.Entry)it.next();
//            String k=(String)entry.getKey();
//            Object v=entry.getValue();
//            if(null !=v&&!"".equals(v)&&!"sign".equals(k)&&!"key".equals(k)){
//                sb.append(k+"="+v+"&");
//            }
//        }
//        sb.append("key="+Key);
//        String sign=MD5Util.MD5Encode(sb.toString(),characterEncoding).toUpperCase();
//        return sign;
//    }

    /**
     * @author
     * @date 2016-4-22
     * @Description：将请求参数转换为xml格式的string
     * @param parameters
     *            请求参数
     * @return
     */
    public static String getRequestXml(SortedMap<String, String> parameters) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if ("attach".equalsIgnoreCase(k) || "body".equalsIgnoreCase(k) || "sign".equalsIgnoreCase(k)) {
                sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");
            } else {
                sb.append("<" + k + ">" + v + "</" + k + ">");
            }
        }
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * 取出一个指定长度大小的随机正整数.
     *
     * @param length
     *            int 设定所取出随机数的长度。length小于11
     * @return int 返回生成的随机数。
     */
    public static int buildRandom(int length) {
        int num = 1;
        double random = Math.random();
        boolean flg=random < 0.1;
        if (flg) {
            random = random + 0.1;
        }
        for (int i = 0; i < length; i++) {
            num = num * 10;
        }
        return (int) ((random * num));
    }

    /**
     * 获取当前时间 yyyyMMddHHmmss
     *
     * @return String
     */
    public static String getCurrTime() {
        Date now = new Date();
        SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String s = outFormat.format(now);
        return s;
    }
}
