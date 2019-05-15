package com.zhongz.rental.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;

@Log
public class SmsSendUtils {

    private static final String DOMAIN = "dysmsapi.aliyuncs.com";
    private static final String VERSION = "2017-05-25";
    private static final String ACTION = "SendSms";
    private static final String REGIONID = "cn-hangzhou";
    private static final String ACCESSKEYID = "LTAIFRZCFFt498fP";
    private static final String ACCESSSECRET = "QAJcMVkqfmrXnNa7BuVCHLVWmFMEI3";
    private static final String SIGNNAME = "中筑乐居";
    private static final String TEMPLATECODE = "SMS_157260397";
    private static final String TEMPLATECODE_COMMENT = "SMS_164505693";

    public static String generateRandomValidateCode() {
        return String.valueOf(new Double(100000 + Math.random()*900000).intValue());
    }

    public static boolean sendSmsValidateCode(String mobile,String validateCode) {
        DefaultProfile profile = DefaultProfile.getProfile(REGIONID, ACCESSKEYID, ACCESSSECRET);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain(DOMAIN);
        request.setVersion(VERSION);
        request.setAction(ACTION);
        request.putQueryParameter("RegionId", REGIONID);
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", SIGNNAME);
        request.putQueryParameter("TemplateCode", TEMPLATECODE);
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + validateCode + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
//            log.info(response.getData());
            String message = (String) JSONObject.parseObject(response.getData()).get("Message");
            if(StringUtils.isNotBlank(message) && "OK".equals(message)) {
                return true;
            }
            return false;
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean sendSms(String mobile,String phone,String name,String content) {
        DefaultProfile profile = DefaultProfile.getProfile(REGIONID, ACCESSKEYID, ACCESSSECRET);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain(DOMAIN);
        request.setVersion(VERSION);
        request.setAction(ACTION);
        request.putQueryParameter("RegionId", REGIONID);
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", SIGNNAME);
        request.putQueryParameter("TemplateCode", TEMPLATECODE_COMMENT);
        request.putQueryParameter("TemplateParam",
                "{\"phone\":\"" + phone + "\",\"name\":\"" + name + "\",\"content\":\"" + content + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
//            log.info(response.getData());
            String message = (String) JSONObject.parseObject(response.getData()).get("Message");
            if(StringUtils.isNotBlank(message) && "OK".equals(message)) {
                return true;
            }
            return false;
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println("{\"code\":\"" + generateRandomValidateCode() + "\"}");
        String mobile = "17640289146";
        String validateCode = generateRandomValidateCode();
        log.info(validateCode);
        log.info("" + sendSmsValidateCode(mobile,validateCode));
//        for(int i=0;i<100;i++) {
//            System.out.println(generateRandomValidateCode());
//        }
    }
}
