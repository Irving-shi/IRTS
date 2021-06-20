package com.irving.ir.controller.pub;

import com.irving.ir.bean.Board;
import com.irving.ir.common.api.CommonResult;
import com.irving.ir.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author irving
 * @date 2021/6/18
 */

@RestController
@RequestMapping("/board")
@Api(tags = "BoardController", description = "留言板")
public class BoardController {

    @Autowired
    private BoardService boardService;

    private static final Logger LOGGER = LoggerFactory.getLogger(BoardController.class);

    @ApiOperation("写留言板")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createQuestion(@RequestBody Board board) {
        CommonResult commonResult;

        int count = boardService.createBoard(board);

        if (count==1){
            commonResult=CommonResult.success(board,"写入留言板成功");
            LOGGER.debug("createBoard success:{}",board);
        }else {
            commonResult=CommonResult.failed("写入留言板失败");
            LOGGER.error("createBoard failed:{}", board);
        }
        return  commonResult;

    }


}
