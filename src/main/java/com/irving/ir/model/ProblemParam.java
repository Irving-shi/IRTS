package com.irving.ir.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author irving
 * @date 2021/6/15
 */
public class ProblemParam {
    @ApiModelProperty(value = "问题", required = true)
    @NotEmpty(message = "问题不能为空")
    private String problem;

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }
}
