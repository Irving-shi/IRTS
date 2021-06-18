package com.irving.ir.mapper;

import com.irving.ir.bean.Board;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author irving
 * @date 2021/6/18
 */
public interface BoardMapper {

    @Insert("insert into board (name,phone,school,question,email) values(#{name},#{phone},#{school},#{question},#{email})")
    int createBoard(Board board);



    @Select("select * from board order by createTime desc")
    List<Board> queryAllBoard();

}
