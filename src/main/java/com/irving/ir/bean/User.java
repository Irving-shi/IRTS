package com.irving.ir.bean;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author irving
 * @date 2021/6/19
 */
public class User {
    /**
     * `id` INT UNSIGNED AUTO_INCREMENT,
     *    `username` VARCHAR(50) NOT NULL,
     *    `phone` VARCHAR(20),
     *    `password` VARCHAR(50) NOT NULL,
     *    PRIMARY KEY ( `id` )
     */

    private Integer id;
    private String username;
    private String password;
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
