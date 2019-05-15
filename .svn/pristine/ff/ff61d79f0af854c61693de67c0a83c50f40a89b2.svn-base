package com.zhongz.rental.common.utils.wxpay;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.InputStream;

@Repository
public class WXPayConfigImpl extends WXPayConfig {

    @Value("${wechatpay.key}")
    public String key;
    @Value("${wechatpay.appid}")
    public String appId;
    @Value("${wechatpay.mch_id}")
    public String mchId;

    @Override
    String getAppID() {
        return appId;
    }

    @Override
    String getMchID() {
        return mchId;
    }

    @Override
    String getKey() {
        return key;
    }

    @Override
    InputStream getCertStream() {
        return null;
    }

    @Override
    IWXPayDomain getWXPayDomain() {
        return null;
    }
}
