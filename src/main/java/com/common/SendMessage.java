/**
 * 文件名: Sendmessage.java
 * 版权：Copyright 2017-2022 CMCC All Rights Reserved.
 * 描述:
 */
package com.common;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-03-02 11:55
 */
public class SendMessage {

        public static void main(String[] args) {
            String host = "http://mobai.market.alicloudapi.com";
            String path = "/mobai_sms";
            String method = "POST";
            String appcode = "ac473a65ae5042a99f20b5e09717a58d";
            Map<String, String> headers = new HashMap<String, String>();
            //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
            headers.put("Authorization", "APPCODE " + appcode);
            Map<String, String> querys = new HashMap<String, String>();
            querys.put("param", "code:9999");
            querys.put("phone", "18328032557");
            querys.put("templateId", "TP18040318");
            Map<String, String> bodys = new HashMap<String, String>();

            try {

                HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
                System.out.println(response.toString());
                System.out.println(EntityUtils.toString(response.getEntity()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
