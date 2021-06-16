package com.irving.ir.service;

import com.irving.ir.bean.Corpus;

import java.util.List;

/**
 * @author irving
 * @date 2021/6/16
 */
public interface CorpusService {

    Corpus getAnswerByProblem(String problem);

    List<Corpus> getAnswerByBlurry(String keyword);

    int createQuestion(Corpus corpus);

    int updateByCounts(int counts,int id);
}
