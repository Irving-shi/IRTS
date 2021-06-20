package com.irving.ir.bean;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author irving
 * @date 2021/6/18
 */
public class Board {
    /*
      `id` INT UNSIGNED AUTO_INCREMENT,
   `name` VARCHAR(50) NOT NULL,
   `phone` VARCHAR(20) NOT NULL,
   `email` VARCHAR(20) NOT NULL,
   `school` VARCHAR(50) NOT NULL ,
   `question` VARCHAR(100) NOT NULL ,
   `createTime` TIMESTAMP,
     */

    private Integer id;

    private String name;
    private String phone;
    private String school;
    private String question;
    private String email;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
