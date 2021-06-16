package ir.irving.com.bean;

import java.sql.DatabaseMetaData;
import java.util.Date;

/**
 * @author irving
 * @date 2021/6/12
 */


public class Corpus {
    /*
     `id` INT UNSIGNED AUTO_INCREMENT,
   `problem` VARCHAR(100) NOT NULL,
   `answer` TEXT NOT NULL,
   `like` INT DEFAULT '0',
   `dislike` INT DEFAULT '0',
   `counts` INT DEFAULT '0',

     */

    private Integer id;
    private Integer like;
    private Integer dislike;
    private Integer counts;

    private String problem;
    private String answer;

    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getDislike() {
        return dislike;
    }

    public void setDislike(Integer dislike) {
        this.dislike = dislike;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
