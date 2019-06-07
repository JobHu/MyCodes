package ycit.pojo;
/**
 * 抗压减压的模块
 * @author hyg
 *CREATE TABLE `reduce_pressure` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '抗压的ID',
  `reduce_pressure_name` varchar(50) DEFAULT NULL COMMENT '减轻压力的名称',
  `content` varchar(1000) DEFAULT NULL COMMENT '减压的具体的操作',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class ReducePressure {
    private Integer id;

    private String reducePressureName;//抗压方法的名称

    private String content;//抗压方法的内容

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReducePressureName() {
        return reducePressureName;
    }

    public void setReducePressureName(String reducePressureName) {
        this.reducePressureName = reducePressureName == null ? null : reducePressureName.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}