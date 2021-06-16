package com.irving.ir.mapper;

import com.irving.ir.bean.Corpus;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author irving
 * @date 2021/6/12
 */


public interface CorpusMapper {

    @Select("select * from corpus where problem=#{problem}")
    Corpus getAnswerByProblem(String problem);


    @Select("select * from corpus where problem like CONCAT('%',#{keyword},'%')")
     List<Corpus>  getAnswerByBlurry(String keyword);


    @Insert("insert into corpus ( problem, answer) values(#{problem},#{answer})")
    int createQuestion(Corpus corpus);
}