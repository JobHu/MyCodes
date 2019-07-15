package ycit.pojo;
/**
 * CREATE TABLE `state` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '状态表的主键Id',
  `mood` varchar(255) DEFAULT NULL COMMENT '心情的标价',
  `work_state` varchar(255) DEFAULT NULL COMMENT '工作状态',
  `body_state` varchar(255) DEFAULT NULL COMMENT '身体状态',
  `attention` varchar(255) DEFAULT NULL COMMENT '注意力情况',
  `appetite` varchar(255) DEFAULT NULL COMMENT '胃口情况',
  `sleep_id` int(11) DEFAULT NULL COMMENT '睡眠质量的Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * @author hyg
 *
 */
//睡眠之后的状态表
public class State {
    private Integer id;//状态Id

    private String mood;//睡眠之后的心情

    private String workState;//工作状态

    private String bodyState;//身体状态

    private String attention;//注意力

    private String appetite;//胃口

    private Integer sleepId;//睡眠的ID

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood == null ? null : mood.trim();
    }

    public String getWorkState() {
        return workState;
    }

    public void setWorkState(String workState) {
        this.workState = workState == null ? null : workState.trim();
    }

    public String getBodyState() {
        return bodyState;
    }

    public void setBodyState(String bodyState) {
        this.bodyState = bodyState == null ? null : bodyState.trim();
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention == null ? null : attention.trim();
    }

    public String getAppetite() {
        return appetite;
    }

    public void setAppetite(String appetite) {
        this.appetite = appetite == null ? null : appetite.trim();
    }

    public Integer getSleepId() {
        return sleepId;
    }

    public void setSleepId(Integer sleepId) {
        this.sleepId = sleepId;
    }
}