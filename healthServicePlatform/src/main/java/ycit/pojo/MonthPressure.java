package ycit.pojo;
/**
 * CREATE TABLE `month_pressure` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '月份的Id',
  `month_result` varchar(500) DEFAULT NULL COMMENT '分析结果',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * @author hyg
 *
 */
public class MonthPressure {
    private Integer id;//month的ID

    private String monthResult;//month分析的结果

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMonthResult() {
        return monthResult;
    }

    public void setMonthResult(String monthResult) {
        this.monthResult = monthResult == null ? null : monthResult.trim();
    }
}