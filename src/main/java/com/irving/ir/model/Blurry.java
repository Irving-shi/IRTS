package com.irving.ir.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author irving
 * @date 2021/6/15
 */
public class Blurry {

    @ApiModelProperty(value = "问题关键词", required = true)
    @NotEmpty(message = "问题关键词不能为空")
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
