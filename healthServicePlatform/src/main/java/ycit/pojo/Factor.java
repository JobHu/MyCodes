package ycit.pojo;
/**
 * CREATE TABLE `factor` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '影响睡眠的因素Id',
  `name` varchar(255) DEFAULT NULL COMMENT '因素名称',
  `type` varchar(255) DEFAULT NULL COMMENT '因素类型',
  `time` varchar(255) DEFAULT NULL COMMENT '在什么时间点影响睡眠',
  `result` varchar(255) DEFAULT NULL COMMENT '效果',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * @author hyg
 *
 */
//影响睡眠的因素表
public class Factor {
    private Integer id;

    private String name;//名称

    private String type;//类型

    private String time;//在什么时间点影响睡眠

    private String result;//影响的结果

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }
}