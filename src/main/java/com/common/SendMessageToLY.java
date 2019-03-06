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
public class SendMessageToLY {



            public static void main(String[] args) {
                String host = "https://aliyun.chanyoo.net";
                String path = "/sendsms";
                String method = "GET";
                String appcode = "ac473a65ae5042a99f20b5e09717a58d";
                Map<String, String> headers = new HashMap<String, String>();
                //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
                headers.put("Authorization", "APPCODE " + appcode);
                Map<String, String> querys = new HashMap<String, String>();
                querys.put("mobile", "13298335921");
                querys.put("content", "您的手机号：13333333333，验证码：110426，请及时完成验证，如不是本人操作请忽略。【阿里云市场】");

              /*  querys.put("content", "帅虎同学" +
                        "XX 同学。咱们燎原服务队十周年庆典在即，为感谢和铭记大家在大学期间为服务队做出的服务和贡献，" +
                        "队里的小伙伴们要制作燎原志，需要大家提供一些个人资料，使用表单填写  https://jinshuju.net/f/i0IYFq   ");
*/
                try {

                    HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
                    System.out.println(response.toString());
                    //获取response的body
                    System.out.println(EntityUtils.toString(response.getEntity()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    }
