package com.irving.ir.service;

import com.irving.ir.bean.Corpus;

import java.util.List;

/**
 * @author irving
 * @date 2021/6/16
 */
public interface CorpusService {
    Corpus getAnswerById(int id);

    List<Corpus> queryAllCorpus(int pageNum, int pageSize);

    List<Corpus> queryAllCorpusByDislike(int pageNum, int pageSize);

    List<Corpus> queryAllCorpusByPraise(int pageNum, int pageSize);

    Corpus getAnswerByProblem(String problem);

    List<Corpus> getAnswerByBlurry(String keyword);

    int createQuestion(Corpus corpus);

    int updateByCounts(int counts,int id);

    int updateLikeById(int praise,int id);

    int updateDislikeById(int dislike,int id);
}
