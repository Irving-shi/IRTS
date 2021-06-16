package com.irving.ir.controller;

/**
 * @author irving
 * @date 2021/6/10
 */

import com.irving.ir.model.ProblemParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.irving.ir.bean.Corpus;
import com.irving.ir.common.api.CommonResult;
import com.irving.ir.mapper.CorpusMapper;
import com.irving.ir.model.Blurry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/corpus")
@Api(tags = "DemoController", description = "问题管理")
public class CorpusController {

    @Autowired
    CorpusMapper corpusMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(CorpusController.class);

    @ApiOperation("根据问题查询答案")
    @RequestMapping(value = "/problem", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult getAnswerByProblem(@RequestBody ProblemParam problemParam, BindingResult result) {
      Corpus corpus =corpusMapper.getAnswerByProblem(problemParam.getProblem());
        if(null!=corpus){
            return CommonResult.success(corpus,"获取答案成功");
        }else {
            LOGGER.error("getAnswerByBlurry failed");
            return CommonResult.failed("未查询到相关问题");
        }

    }


    @ApiOperation("根据关键字模糊查询")
    @RequestMapping(value = "/keyword", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult getAnswerByBlurry(@RequestBody Blurry blurry, BindingResult result) {
        List<Corpus> corpusList =corpusMapper.getAnswerByBlurry(blurry.getKeyword());

        if(null!=corpusList){
            return CommonResult.success(corpusList,"匹配上已知问题");
        }else {
            LOGGER.error("getAnswerByBlurry failed");
            return CommonResult.failed("匹配不上已知问题");
        }


    }


    @ApiOperation("写问题和答案")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createQuestion(@RequestBody Corpus corpus) {
        CommonResult commonResult;

        corpus.setCreateTime(new Date());
        int count = corpusMapper.createQuestion(corpus);

        if (count==1){
            commonResult=CommonResult.success(corpus,"写入问题答案成功");
            LOGGER.debug("createQuestion success:{}",corpus);
        }else {
            commonResult=CommonResult.failed("操作失败");
            LOGGER.error("createQuestion failed:{}", corpus);
        }
        return  commonResult;

    }

}
