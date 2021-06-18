package com.irving.ir.service;

import com.irving.ir.bean.Board;

import java.util.List;

/**
 * @author irving
 * @date 2021/6/18
 */
public interface BoardService {

    int createBoard(Board board);

    List<Board> queryAllBoard(int pageNum, int pageSize);
}
