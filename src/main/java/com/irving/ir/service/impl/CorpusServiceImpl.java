package com.irving.ir.service.impl;

import com.irving.ir.bean.Corpus;
import com.irving.ir.controller.CorpusController;
import com.irving.ir.mapper.CorpusMapper;
import com.irving.ir.service.CorpusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author irving
 * @date 2021/6/16
 */
@Service
public class CorpusServiceImpl implements CorpusService {

    @Autowired
    private CorpusMapper corpusMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(CorpusServiceImpl.class);

    @Override
    public Corpus getAnswerByProblem(String problem) {
        Corpus corpus =corpusMapper.getAnswerByProblem(problem);
        int result = updateByCounts(corpus.getCounts()+1,corpus.getId());
        if(result!=1){
            LOGGER.error("更新查询次数失败");
        }

        return corpus;
    }

    @Override
    public List<Corpus> getAnswerByBlurry(String keyword) {
        return corpusMapper.getAnswerByBlurry(keyword);
    }

    @Override
    public int createQuestion(Corpus corpus) {
        corpus.setCreateTime(new Date());
        int count = corpusMapper.createQuestion(corpus);
        return count;
    }

    @Override
    public int updateByCounts(int counts,int id) {

        return corpusMapper.updateByCounts(counts,id);
    }
}