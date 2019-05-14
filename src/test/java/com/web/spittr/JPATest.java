/**
 * 文件名: JPATest.java
 * 版权：Copyright 2017-2022 CMCC All Rights Reserved.
 * 描述:
 */
package com.web.spittr;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @description:
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-05-08 21:58
 */
public class JPATest {
    public static void main(String[] args) {

        //1.创建 EntityManagerFactory
        String persistenceUnitName = "jpa";
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);

        //2.创建 EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //4.开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        //5.进行持久化操作
        Spitter spitter = new Spitter();
        spitter.setLastName("AA");
        spitter.setEmail("aa@163.com");
        spitter.setUsername("s");

        entityManager.persist(spitter);

        //6.提交事务
        transaction.commit();

        //7.关闭 EntityManager
        entityManager.close();

        //8.关闭 EntityManagerFactory
        entityManagerFactory.close();
    }
}
