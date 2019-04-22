/**
 * 文件名: SecurityWebApplicationInitializer.java
 * 版权：Copyright 2017-2022 CMCC All Rights Reserved.
 * 描述:
 */
package com.web.spittr.config.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;



/**
 * @description:  继承AbstractSecurityWebApplicationInitializer会自动注册DelegatingFilterProxy
 *  等价于xml配置 springSecurityFilterChain
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-04-19 11:52
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
}
