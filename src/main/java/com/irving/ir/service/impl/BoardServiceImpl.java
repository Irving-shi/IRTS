package com.irving.ir.service.impl;

import com.github.pagehelper.PageHelper;
import com.irving.ir.bean.Board;
import com.irving.ir.mapper.BoardMapper;
import com.irving.ir.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author irving
 * @date 2021/6/18
 */
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public int createBoard(Board board) {
        board.setCreateTime(new Date());
        return boardMapper.createBoard(board);
    }

    @Override
    public List<Board> queryAllBoard(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return boardMapper.queryAllBoard();
    }
}
