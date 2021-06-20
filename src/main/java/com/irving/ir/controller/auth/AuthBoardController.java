package com.irving.ir.controller.auth;

import com.irving.ir.bean.Board;
import com.irving.ir.common.annotation.Login;
import com.irving.ir.common.api.CommonPage;
import com.irving.ir.common.api.CommonResult;
import com.irving.ir.service.BoardService;
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
@RequestMapping("/auth/board")
@Api(tags = "AuthBoardController", description = "留言板查看（需要登录token）")
public class AuthBoardController {
    @Autowired
    private BoardService boardService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthBoardController.class);


    @ApiOperation("分页显示所有留言并按时间进行降序")
    @RequestMapping(value = "/list/all", method = RequestMethod.GET)
    @ResponseBody
    @Login
    public CommonResult<CommonPage<Board>> listBoard(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                     @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){

        List<Board> boardList =boardService.queryAllBoard(pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(boardList),"分页查询成功");

    }
}
