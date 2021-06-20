package com.irving.ir.service.impl;

import com.github.pagehelper.PageHelper;
import com.irving.ir.bean.Corpus;
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
    public Corpus getAnswerById(int id) {
        return corpusMapper.getAnswerById(id);
    }

    @Override
    public List<Corpus> queryAllCorpus(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        return corpusMapper.queryAllCorpus();
    }

    @Override
    public List<Corpus> queryAllCorpusByDislike(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return corpusMapper.queryAllCorpusByDislike();
    }

    @Override
    public List<Corpus> queryAllCorpusByPraise(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return corpusMapper.queryAllCorpusByPraise();
    }

    @Override
    public Corpus getAnswerByProblem(String problem) {
        Corpus corpus =corpusMapper.getAnswerByProblem(problem);
        if(null!=corpus) {
            int result = updateByCounts(corpus.getCounts() + 1, corpus.getId());
            if (result != 1) {
                LOGGER.error("更新查询次数失败");
            }
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

    @Override
    public int updateLikeById(int praise, int id) {
        return corpusMapper.updateLikeById(praise,id);
    }

    @Override
    public int updateDislikeById(int dislike, int id) {
        return corpusMapper.updateDislikeById(dislike,id);
    }
}
