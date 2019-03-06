/**
 * 文件名: Spittle.java
 * 版权：Copyright 2017-2022 CMCC All Rights Reserved.
 * 描述:
 */
package com.web.spittr;

import com.alibaba.fastjson.annotation.JSONType;
import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @description:
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-02-26 15:27
 */
@Data
public class Spittle {

/*    private final Long id ;
    private final String message;
    private final Date time = new Date();*/

    /**
     * 所注解的元素必须是数字，并且它的值必须有指定的位数
     */
    @Digits(integer = 0, fraction =10 )
    private Long id ;
    private String message;
    private Date time;

    /**
     * 纬度
     */
    private Double latitude;

    /**
     * 纬度
     */
    private Double longitude;

    @NotNull
    @Size(min = 2, max = 30)
    private String firstName;

    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;

    @NotNull
    @Size(min = 5, max = 16)
    private String username;

    @NotNull
    @Size(min = 5, max = 16)
    private String password;

    public Spittle(String message, Date time) {
        this(message, time, null, null);
    }


    public Spittle(String message, Date time, Double latitude, Double longitude) {
        this.id = null;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Apache Common Lang包来实现equals()和hashCode()方法
     */

    @Override
    public boolean equals(Object that) {
        return new EqualsBuilder().reflectionEquals(this, that, "id", "time");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id", "time");
    }

}
