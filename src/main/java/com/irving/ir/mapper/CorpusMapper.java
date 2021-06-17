package com.irving.ir.mapper;

import com.irving.ir.bean.Corpus;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author irving
 * @date 2021/6/12
 */


public interface CorpusMapper {

    @Select("select * from corpus")
    List<Corpus> queryAllCorpus();


    @Select("select * from corpus where id=#{id}")
    Corpus getAnswerById(int id);


    @Select("select * from corpus where problem=#{problem}")
    Corpus getAnswerByProblem(String problem);


    @Select("select * from corpus where problem like CONCAT('%',#{keyword},'%')")
     List<Corpus>  getAnswerByBlurry(String keyword);


    @Insert("insert into corpus ( problem, answer) values(#{problem},#{answer})")
    int createQuestion(Corpus corpus);


    @Update("UPDATE corpus SET counts=#{counts} WHERE id=#{id}")
    int updateByCounts(int counts,int id);

    @Update("UPDATE corpus SET praise=#{praise} WHERE id=#{id}")
    int updateLikeById(int praise,int id);

    @Update("UPDATE corpus SET dislike=#{dislike} WHERE id=#{id}")
    int updateDislikeById(int dislike,int id);

}
