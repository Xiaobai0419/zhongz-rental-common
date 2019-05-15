package com.zhongz.rental.common.utils;

import com.zhongz.rental.common.utils.wxpay.WXPay;
import com.zhongz.rental.common.utils.wxpay.WXPayConfig;
import com.zhongz.rental.result.WechatPrePayResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Consts;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.jdom.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

@Slf4j
@Component
public class WechatPayUtils {

    @Value("${wechatpay.key}")
    public String key;
    @Value("${wechatpay.appid}")
    public String appId;
    @Value("${wechatpay.mch_id}")
    public String mchId;
    @Value("${wechatpay.deviceInfo}")
    public String deviceInfo;
    @Value("${wechatpay.body}")
    public String body;
    @Value("${wechatpay.nonceStr}")
    public String nonceStr;
    @Value("${wechatpay.signType}")
    public String signType;
    @Value("${wechatpay.notifyUrl}")
    public String notifyUrl;

    @Autowired
    private WXPayConfig wxPayConfig;

    private WechatPrePayResult wechatPay(String orderId){
        WechatPrePayResult result = new WechatPrePayResult();
        SortedMap<String,String> packageParams = new TreeMap<String,String>();
        packageParams.put("appid", appId);
        packageParams.put("mch_id", mchId);
        packageParams.put("nonce_str", nonceStr);
        packageParams.put("body","中筑报修保洁订单");  //（调整为自己的名称）
        packageParams.put("out_trade_no", orderId);
        packageParams.put("total_fee","1"); //价格的单位为分
        packageParams.put("spbill_create_ip", "59.46.65.242");
        packageParams.put("notify_url", notifyUrl);
        packageParams.put("trade_type", "APP");
        String sign = PayToolUtil.createSign(packageParams,"UTF-8", key);
        packageParams.put("sign",sign);
        Map<String,String> map=payWechata(packageParams);
        String returnCode=map.get("return_code");
        if (returnCode.equals("FAIL")) {
            return new WechatPrePayResult();
        }
        result.setNoncestr(nonceStr);
        result.setPartnerid(mchId);
        result.setPrepayid(map.get("prepay_id"));
        SortedMap<String,String> pa = new TreeMap<String, String>();
        long time=System.currentTimeMillis()/1000;
        pa.put("appid", appId);
        pa.put("noncestr", nonceStr);
        pa.put("package", "Sign=WXPay");
        pa.put("partnerid", mchId);
        pa.put("prepayid", map.get("prepay_id"));
        pa.put("timestamp",String.valueOf(time));
        sign = PayToolUtil.createSign(pa, "UTF-8", key);
        result.setSign(sign);
        result.setTimestamp(time);
        return result;
    }

    private Map<String,String> payWechata(SortedMap<String,String> packageParams){
        String xml=PayToolUtil.getRequestXml(packageParams);
        ContentType contentType = ContentType.create("application/xml", Consts.UTF_8);
        StringEntity stringEntity = new StringEntity(xml,contentType);
        String str=HttpClientUtils.doPostRequest("https://api.mch.weixin.qq.com/pay/unifiedorder",null,null,stringEntity);
        Map<String,String> map=null;
        try {
            map=XMLUtil4jdom.doXMLParse(str);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    //使用官方demo预支付
    public Map<String, String> wechatPrePay(String orderId) {
        WXPay wxPay = null;
        Map<String, String> result = null;
        try {
            wxPay = new WXPay(wxPayConfig,notifyUrl);
        } catch (Exception e) {
            log.info("封装WXPay出错！！");
            e.printStackTrace();
        }
        if(wxPay != null) {
            Map<String, String> reqData = new TreeMap<>();
//            reqData.put("appid", appId);
//            reqData.put("mch_id", mchId);
//            reqData.put("nonce_str", nonceStr);
            reqData.put("body","中筑报修保洁订单");  //（调整为自己的名称）
            reqData.put("out_trade_no", orderId);
            reqData.put("total_fee","1"); //价格的单位为分
            reqData.put("spbill_create_ip", "59.46.65.242");
//            reqData.put("notify_url", notifyUrl);
            reqData.put("trade_type", "APP");
            try {
                result = wxPay.unifiedOrder(reqData);
            } catch (Exception e) {
                log.info("调用微信预支付出错！！");
                e.printStackTrace();
            }
        }
        return result;
    }

    //使用官方demo验证异步支付结果回调请求数据签名
    public boolean validateWechatPayResult(Map<String, String> reqData) {
        WXPay wxPay = null;
        try {
            wxPay = new WXPay(wxPayConfig,notifyUrl);
        } catch (Exception e) {
            log.info("封装WXPay出错！！");
            e.printStackTrace();
        }
        if(wxPay != null) {
            try {
                return wxPay.isPayResultNotifySignatureValid(reqData);
            } catch (Exception e) {
                log.info("验证异步支付结果回调请求数据签名出错！！");
                e.printStackTrace();
            }
        }
        return false;
    }

    //异步支付结果回调中对异步支付结果的业务处理

}
