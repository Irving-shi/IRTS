package com.irving.ir.controller.auth;

import com.irving.ir.bean.Corpus;
import com.irving.ir.common.annotation.Login;
import com.irving.ir.common.api.CommonPage;
import com.irving.ir.common.api.CommonResult;
import com.irving.ir.service.CorpusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author irving
 * @date 2021/6/20
 */
@RestController
@RequestMapping("/auth/corpus")
@Api(tags = "AuthCorpusController", description = "问题管理查看（需要登录token）")
public class AuthCorpusController {
    @Autowired
    private CorpusService corpusService;


    private static final Logger LOGGER = LoggerFactory.getLogger(AuthCorpusController.class);

    @ApiOperation("分页显示所有问题并按反向点赞次数进行降序")
    @RequestMapping(value = "/list/dislike", method = RequestMethod.GET)
    @ResponseBody
    @Login
    public CommonResult<CommonPage<Corpus>> listCorpusByDislike(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                                @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){

        List<Corpus> corpusList =corpusService.queryAllCorpusByDislike(pageNum,pageSize);

        return CommonResult.success(CommonPage.restPage(corpusList),"分页查询成功");

    }

    @ApiOperation("分页显示所有问题并按访问点赞次数进行降序")
    @RequestMapping(value = "/list/like", method = RequestMethod.GET)
    @ResponseBody
    @Login
    public CommonResult<CommonPage<Corpus>> listCorpusByParsise(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                                @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){

        List<Corpus> corpusList =corpusService.queryAllCorpusByPraise(pageNum,pageSize);

        return CommonResult.success(CommonPage.restPage(corpusList),"分页查询成功");

    }
    @ApiOperation("分页显示所有问题并按访问次数进行降序")
    @RequestMapping(value = "/list/all", method = RequestMethod.GET)
    @ResponseBody
    @Login
    public CommonResult<CommonPage<Corpus>> listCorpus(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                       @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){

        List<Corpus> corpusList =corpusService.queryAllCorpus(pageNum,pageSize);

        return CommonResult.success(CommonPage.restPage(corpusList),"分页查询成功");

    }

    @ApiOperation("写问题和答案")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    @Login
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

}
