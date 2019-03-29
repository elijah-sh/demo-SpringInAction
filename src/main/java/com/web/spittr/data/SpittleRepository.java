/**
 * 文件名: SpittleRepository.java
 * 版权：Copyright 2017-2022 CMCC All Rights Reserved.
 * 描述:
 */
package com.web.spittr.data;

import com.web.spittr.Spitter;
import com.web.spittr.Spittle;

import java.util.List;

/**
 * @description: 取数据
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-02-26 15:26
 */
public interface SpittleRepository {

    /**
     * 查询
     * @param max  代表所返回的Spittle中，Spittle ID属性的最大值
     * @param count  表明要返回多少个Spittle对象
     * @return Spittle对象
     */
    List<Spitter> findSpittles(long max, int count);


    /**
     * 根据ID查找实体
     * @param spittleId
     * @return
     */
    Spittle findOne(Long spittleId);

    /**
     * 保存方法
     * @param spittle
     */
    void save(Spittle spittle );


    /**
     * 根据USERNAME查找实体
     * @param username
     * @return
     */
    Spitter findByUsername(String username);

    List<Spittle> findRecentSpittles();


}
