package com.irving.ir.controller;

/**
 * @author irving
 * @date 2021/6/10
 */

import com.irving.ir.common.api.CommonPage;
import com.irving.ir.model.ProblemParam;
import com.irving.ir.service.CorpusService;
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

import java.util.List;

@RestController
@RequestMapping("/corpus")
@Api(tags = "CorpusController", description = "问题管理")
public class CorpusController {

    @Autowired
    private CorpusService corpusService;


    private static final Logger LOGGER = LoggerFactory.getLogger(CorpusController.class);

    @ApiOperation("根据问题查询答案")
    @RequestMapping(value = "/problem", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult getAnswerByProblem(@RequestBody ProblemParam problemParam, BindingResult result) {
      Corpus corpus =corpusService.getAnswerByProblem(problemParam.getProblem());
        if(null!=corpus){
            return CommonResult.success(corpus,"获取答案成功");
        }else {
            LOGGER.error("getAnswerByBlurry failed");
            return CommonResult.failed("未查询到相关问题");
        }

    }

    @ApiOperation("分页显示所有问题")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<Corpus>> listCorpus(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                       @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){

        List<Corpus> corpusList =corpusService.queryAllCorpus(pageNum,pageSize);

        return CommonResult.success(CommonPage.restPage(corpusList),"分页查询成功");

    }

    @ApiOperation("根据关键字模糊查询")
    @RequestMapping(value = "/keyword", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult getAnswerByBlurry(@RequestBody Blurry blurry, BindingResult result) {
        List<Corpus> corpusList =corpusService.getAnswerByBlurry(blurry.getKeyword());

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

        int count = corpusService.createQuestion(corpus);

        if (count==1){
            commonResult=CommonResult.success(corpus,"写入问题答案成功");
            LOGGER.debug("createQuestion success:{}",corpus);
        }else {
            commonResult=CommonResult.failed("操作失败");
            LOGGER.error("createQuestion failed:{}", corpus);
        }
        return  commonResult;

    }

    @ApiOperation("点赞")
    @RequestMapping(value = "/like", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult addLike(@RequestBody Corpus corpus) {
        CommonResult commonResult;

        int count=corpusService.updateLikeById(corpus.getPraise()+1,corpus.getId());
        if (count==1){
            commonResult=CommonResult.success(corpus,"点赞成功");
            LOGGER.debug("addLike success:{}",corpus);
        }else {
            commonResult=CommonResult.failed("点赞失败");
            LOGGER.error("addLike failed:{}", corpus);
        }

        return commonResult;

    }

    @ApiOperation("负向点赞")
    @RequestMapping(value = "/dislike", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult addDislike(@RequestBody Corpus corpus) {
        CommonResult commonResult;

        int count=corpusService.updateDislikeById(corpus.getDislike()+1,corpus.getId());
        if (count==1){
            commonResult=CommonResult.success(corpus,"点赞成功");
            LOGGER.debug("addLike success:{}",corpus);
        }else {
            commonResult=CommonResult.failed("点赞失败");
            LOGGER.error("addLike failed:{}", corpus);
        }

        return commonResult;

    }


}
