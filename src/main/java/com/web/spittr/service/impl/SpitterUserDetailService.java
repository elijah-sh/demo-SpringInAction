/**
 * 文件名: SpitterUserDetailService.java
 * 版权：Copyright 2017-2022 CMCC All Rights Reserved.
 * 描述:
 */
package com.web.spittr.service.impl;

import com.web.spittr.Spitter;
import com.web.spittr.data.SpittleRepository;
import com.web.spittr.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 获取登录用户
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-04-16 16:23
 */
public class SpitterUserDetailService implements UserDetailService {

    @Autowired
    public  SpittleRepository spittleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Spitter spitter = spittleRepository.findByUsername(username);
        if (spitter !=null) {
            // 创建权限列表
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_SPITER"));
            return new User(spitter.getUsername(),
                    spitter.getPassword(),
                    authorities);
        }
        throw new UsernameNotFoundException("User '" + username + " 'not found.");
    }
}
