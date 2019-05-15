package com.zhongz.rental.common.utils;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Https忽略证书
 */
class SSLClientCustom {
    private static final String HTTP = "http";
    private static final String HTTPS = "https";
    private static SSLConnectionSocketFactory sslConnectionSocketFactory = null;
    private static PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = null;//连接池管理类
    private static SSLContextBuilder sslContextBuilder = null;//管理Https连接的上下文类

    static {
        try {
            sslContextBuilder = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
//                    信任所有站点 直接返回true
                    return true;
                }
            });
            sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContextBuilder.build(), new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.2"}, null, NoopHostnameVerifier.INSTANCE);
            Registry<ConnectionSocketFactory> registryBuilder = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register(HTTP, new PlainConnectionSocketFactory())
                    .register(HTTPS, sslConnectionSocketFactory)
                    .build();
            poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(registryBuilder);
            poolingHttpClientConnectionManager.setMaxTotal(200);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取连接
     *
     * @return
     * @throws Exception
     */
    public static CloseableHttpClient getHttpClinet() throws Exception {
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslConnectionSocketFactory)
                .setConnectionManager(poolingHttpClientConnectionManager)
                .setConnectionManagerShared(true)
                .build();
        return httpClient;
    }
}

/**
 * Http/Https请求的工具类
 */
public class HttpClientUtils {
    private static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    /**
     * 发送post请求
     *
     * @param url:请求地址
     * @param header:请求头参数
     * @param params:表单参数  form提交
     * @param httpEntity   json/xml参数
     * @return
     */
    public static String doPostRequest(String url, Map<String, String> header, Map<String, String> params, HttpEntity httpEntity) {
        String resultStr = "";
        if (StringUtils.isEmpty(url)) {
            return resultStr;
        }
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        try {
            httpClient = SSLClientCustom.getHttpClinet();
            HttpPost httpPost = new HttpPost(url);
            //请求头header信息
            if (MapUtils.isNotEmpty(header)) {
                for (Map.Entry<String, String> stringStringEntry : header.entrySet()) {
                    httpPost.setHeader(stringStringEntry.getKey(), stringStringEntry.getValue());
                }
            }
            //请求参数信息
            if (MapUtils.isNotEmpty(params)) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (Map.Entry<String, String> stringStringEntry : params.entrySet()) {
                    paramList.add(new BasicNameValuePair(stringStringEntry.getKey(), stringStringEntry.getValue()));
                }
                UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(paramList, Consts.UTF_8);
                httpPost.setEntity(urlEncodedFormEntity);
            }
            //实体设置
            if (httpEntity != null) {
                httpPost.setEntity(httpEntity);
            }

            //发起请求
            httpResponse = httpClient.execute(httpPost);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity httpResponseEntity = httpResponse.getEntity();
                resultStr = EntityUtils.toString(httpResponseEntity);
                logger.info("请求正常,请求地址:{},响应结果:{}", url, resultStr);
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                HeaderIterator headerIterator = httpResponse.headerIterator();
                while (headerIterator.hasNext()) {
                    stringBuffer.append("\t" + headerIterator.next());
                }
                logger.info("异常信息:请求地址:{},响应状态:{},请求返回结果:{}", url, httpResponse.getStatusLine().getStatusCode(), stringBuffer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HttpClientUtils.closeConnection(httpClient, httpResponse);
        }
        return resultStr;
    }

    public static String doGetRequest(String url, Map<String, String> header, Map<String, String> params) {
        String resultStr = "";
        if (StringUtils.isEmpty(url)) {
            return resultStr;
        }
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        try {
            httpClient = SSLClientCustom.getHttpClinet();
            //请求参数信息
            if (MapUtils.isNotEmpty(params)) {
                url = url + buildUrl(params);
            }
            HttpGet httpGet = new HttpGet(url);
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000)//连接超时
                    .setConnectionRequestTimeout(5000)//请求超时
                    .setSocketTimeout(5000)//套接字连接超时
                    .setRedirectsEnabled(true).build();//允许重定向
            httpGet.setConfig(requestConfig);
            if (MapUtils.isNotEmpty(header)) {
                for (Map.Entry<String, String> stringStringEntry : header.entrySet()) {
                    httpGet.setHeader(stringStringEntry.getKey(), stringStringEntry.getValue());
                }
            }
            //发起请求
            httpResponse = httpClient.execute(httpGet);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                resultStr = EntityUtils.toString(httpResponse.getEntity(), Consts.UTF_8);
                logger.info("请求地址:{},响应结果:{}", url, resultStr);
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                HeaderIterator headerIterator = httpResponse.headerIterator();
                while (headerIterator.hasNext()) {
                    stringBuffer.append("\t" + headerIterator.next());
                }
                logger.info("异常信息:请求响应状态:{},请求返回结果:{}", httpResponse.getStatusLine().getStatusCode(), stringBuffer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HttpClientUtils.closeConnection(httpClient, httpResponse);
        }
        return resultStr;
    }

    /**
     * 关掉连接释放资源
     */
    private static void closeConnection(CloseableHttpClient httpClient, CloseableHttpResponse httpResponse) {
        if (httpClient != null) {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (httpResponse != null) {
            try {
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 构造get请求的参数
     *
     * @return
     */
    private static String buildUrl(Map<String, String> map) {
        if (MapUtils.isEmpty(map)) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer("?");
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            stringBuffer.append(stringStringEntry.getKey()).append("=").append(stringStringEntry.getValue()).append("&");
        }
        String result = stringBuffer.toString();
        if (StringUtils.isNotEmpty(result)) {
            result = result.substring(0, result.length() - 1);//去掉结尾的&连接符
        }
        return result;
    }

    public static void main(String[] args) {
        String httpsUrl = "https://github.com/";
        HttpClientUtils.doGetRequest(httpsUrl, null, null);
        String hpptsPostUrl = "https://www.cnblogs.com/Mr-Rocker/p/6229652.html";
        HttpClientUtils.doPostRequest(hpptsPostUrl, null, null, null);
        Map<String, String> params = new HashMap<>();
        params.put("ie", "utf-8");
        params.put("wd", "java");
        params.put("tn", "92032424_hao_pg");
        Map<String, String> header = new HashMap<>();
        header.put("User-Agent:", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
        HttpClientUtils.doGetRequest("https://www.baidu.com/s", header, params);
    }
}
